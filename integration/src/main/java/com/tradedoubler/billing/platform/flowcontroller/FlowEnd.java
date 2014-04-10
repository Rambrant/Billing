package com.tradedoubler.billing.platform.flowcontroller;

import com.tradedoubler.billing.platform.logging.LogError;
import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;
import org.mule.module.client.MuleClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * The mandatory end point for all flows. It takes care of error handling regarding the output business
 * component and also output integration point disturbances as well as invoking the vm transport
 * when the flow has been successful.
 */
public class FlowEnd implements Callable {

    private final static Logger log = LoggerFactory.getLogger(FlowEnd.class);

    private FlowService flowService;

    public void setFlowService(FlowService flowService) {
        this.flowService = flowService;
    }

    @Override
    public Object onCall(MuleEventContext muleEventContext) throws Exception {

        MuleMessage message = muleEventContext.getMessage();

        if ( message == null || message.getPayload() == null || !(message.getPayload() instanceof ServiceResult)){
            // The wrong payload has arrived, abort the flow
            ServiceResult result = new ServiceResult();
            result.setRawData(message.getPayload());
            String flowName = muleEventContext.getSession().getFlowConstruct().getName();
            String errorMessage = "Flow with name: " + flowName + " has an output component that doesn't pass along a " +
                                    "ServiceResult object. This violates the platform rules and the flow is now ended.";
            result.setErrorMessage(errorMessage);
            flowService.registerBugDisturbance( flowName, message.getMuleContext(),result.getErrorMessage(), result.getDetailedErrorMessage());
            log.error(LogError.BUG_DISTURBANCE.name() + " - " + errorMessage);
            return false;
        }

        ServiceResult result = (ServiceResult)message.getPayload();

        if ( result.isDisturbance()){
            if ( result.isBugDisturbance()){
                flowService.registerBugDisturbance( result.getFlowName().name(),muleEventContext.getMuleContext(), result.getErrorMessage(), result.getDetailedErrorMessage());
            }
            if ( result.isIntegrationPointDisturbance()){
                flowService.registerOutputDisturbance( result.getFlowName().name(), muleEventContext.getMuleContext(), result);
            }
            return false;
        }

        // Clear potentially earlier bug disturbance state
        flowService.clearBugDisturbance( result.getFlowName().name(), message.getMuleContext());
        flowService.clearOutputDisturbance( result.getFlowName().name(), message.getMuleContext());

        log.info(result.getFlowName().name() + " has successfully terminated.");

        try{
            MuleClient client = new MuleClient(  muleEventContext.getMuleContext());
            String vmRoute = "vm://" + result.getFlowName().name();
            client.dispatch( vmRoute, "VM", null);
        }catch(Exception exp){
            log.error(LogError.PLATFORM.name(),exp);
            return false;
        }

        return true;
    }
}
