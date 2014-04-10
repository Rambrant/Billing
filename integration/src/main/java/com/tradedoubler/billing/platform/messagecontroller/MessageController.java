package com.tradedoubler.billing.platform.messagecontroller;

import com.tradedoubler.billing.domain.MetaData;
import com.tradedoubler.billing.platform.flowcontroller.*;
import com.tradedoubler.billing.platform.logging.LogError;
import org.mule.api.*;
import org.mule.api.lifecycle.Callable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * The MessageController is responsible for determining if an integration message should be
 * allowed to be processed.
 */
public class MessageController implements Callable {

    private final static Logger log = LoggerFactory.getLogger(MessageController.class);

    /** Is used to communicate with MySql regarding message items. */
    private MessageControllerService messageControllerService;

    /**
     * Determines if the message controller is disabled and should just pass on the input.
     * Should never be set to true in production!
     */
    private boolean skipMessageController;

    /**
     * Injected by Spring.
     *
     * @param messageControllerService The service
     */
    public void setMessageControllerService(MessageControllerService messageControllerService) {
        this.messageControllerService = messageControllerService;
    }

    /**
     * Injected by Spring.
     *
     * @param skipMessageController Determines if the message controller is active or not
     */
    public void setSkipMessageController(boolean skipMessageController) {
        this.skipMessageController = skipMessageController;
        if (skipMessageController) {
            log.warn(LogError.PLATFORM.name() + " - BE AWARE: The MessageController is set as inactive. Should never be inactive in Production.");
        }
    }


    @Override
    public Object onCall(MuleEventContext muleEventContext) throws Exception {

        MuleMessage message = muleEventContext.getMessage();

        if (message == null || message.getPayload() == null || !(message.getPayload() instanceof ServiceResult)) {
            // The wrong payload has arrived, abort the flow
            ServiceResult result = new ServiceResult();
            result.setRawData(message != null ? message.getPayload() : "No raw data");
            String flowName = muleEventContext.getSession().getFlowConstruct().getName();
            String errorMessage = "Flow with name: " + flowName + " has not passed a ServiceResult to the MessageController. " +
                    "This breaks platform semantics and the flow is now ended.";
            result.setErrorMessage(errorMessage);
            FlowService.registerBugDisturbance(flowName, message != null ? message.getMuleContext() : null, result.getErrorMessage(), result.getDetailedErrorMessage());
            log.error( LogError.BUG_DISTURBANCE.name() + " - " + errorMessage);
            return result;
        }

        ServiceResult serviceResult = (ServiceResult) message.getPayload();

        if (serviceResult.getIntegrationMessage() == null) {
            // No integration message has been supplied which is breaking platform semantics
            String errorMessage = "Flow with name: " + serviceResult.getFlowName().name() + " has not included an IntegrationMessage in its ServiceResult " +
                    "to the MessageController. This breaks platform semantics and the flow is now ended.";
            serviceResult.setErrorMessage(errorMessage);
            FlowService.registerBugDisturbance(serviceResult.getFlowName().name(), message.getMuleContext(), serviceResult.getDetailedErrorMessage(), serviceResult.getDetailedErrorMessage());
            log.error( LogError.BUG_DISTURBANCE.name() + " - " + errorMessage);
            return serviceResult;
        }

        // Has an entity id been set?
        IntegrationMessage integrationMessage = serviceResult.getIntegrationMessage();

        if (integrationMessage.getEntityId() == null || integrationMessage.getEntityId().trim().isEmpty()) {
            // No integration message has been supplied which is breaking platform semantics
            serviceResult.setRawData(message.getPayload());
            String errorMessage = "Flow with name: " + serviceResult.getFlowName().name() + " has not included an entityId in its IntegrationMessage." +
                    " This breaks platform semantics and the flow is now ended.";
            serviceResult.setErrorMessage(errorMessage);
            FlowService.registerBugDisturbance(serviceResult.getFlowName().name(), message.getMuleContext(), serviceResult.getErrorMessage(), serviceResult.getDetailedErrorMessage());
            log.error( LogError.BUG_DISTURBANCE.name() + " - " + errorMessage);
            return serviceResult;
        }

        // If the message controller is inactivated it will just pass on its input
        if (skipMessageController) {
            log.warn( LogError.PLATFORM.name() + " - The MessageController is inactivated. Should never be inactivated in Production.");
            return serviceResult;
        }

        // Analyze the meta data
        MetaData metaData = serviceResult.getIntegrationMessage().getMetaData();
        MessageItem item;
        try {
            item = messageControllerService.findMessageItem(serviceResult.getIntegrationMessage());
        } catch (Exception e) {
            log.error( LogError.BUG_DISTURBANCE.name(), e);

            String errorMessage = "Flow with name: " + serviceResult.getFlowName().name() +
                    " Error - The MessageController has failed when using the MessageControllerService.findMessageItem(...) " +
                    "method. This indicates that there is a problem with the MySql database.";
            serviceResult.setErrorMessage(errorMessage);
            FlowService.registerBugDisturbance(serviceResult.getFlowName().name(), message.getMuleContext(), serviceResult.getErrorMessage(), serviceResult.getDetailedErrorMessage());
            return serviceResult;
        }

        if (item == null) {
            //  A new integration message that has never been encountered before
            try {
                messageControllerService.insertMessageItem(metaData.getMessageId().getGuid(), metaData.getCreationTime().getSqlTimestamp(),
                        metaData.getMessageType(), integrationMessage.getEntityId(), serviceResult.getRawData().toString());
            } catch (Exception e) {
                log.error(LogError.BUG_DISTURBANCE.name(),e);
                serviceResult.setRawData(message.getPayload());
                String errorMessage = "Flow with name: " + serviceResult.getFlowName().name() +
                        " Error - The MessageController has failed when using the MessageControllerService.insertMessageItem(...) " +
                        "method. This indicates that there is a problem with the MySql database.";
                serviceResult.setErrorMessage(errorMessage);
                FlowService.registerBugDisturbance(serviceResult.getFlowName().name(), message.getMuleContext(), serviceResult.getErrorMessage(), serviceResult.getDetailedErrorMessage());
                return serviceResult;
            }

        } else {

            // Track how many attempts that have been made for this specific message
            // This gives the chance for business components to react if required. Can for example be
            // used to make sure that an integration flow never stops on one particular message.
            try {
                messageControllerService.updateMessageItem(item.getId(), item.getNumberOfAttempts() + 1);
            } catch (Exception e) {
                log.error( LogError.PLATFORM.name(), e);
            } finally {
                integrationMessage.setNumberOfAttempts(item.getNumberOfAttempts() + 1);
            }

            // Duplicate message or previously failed message?
            if (metaData.getMessageId().getGuid().equalsIgnoreCase(item.getGuid())) {
                // Duplicate message or the output phase has previously failed
                // -> OK to continue as the message should be reprocessed.
            } else {
                // Out-of-sequence
                integrationMessage.setOutOfSequence(true);
                log.warn( LogError.PLATFORM.name() +  " - Message detected as out-of-sequence: " + serviceResult.toString());
            }
        }

        // Pass on message to the flow's business component
        return serviceResult;
    }

}

