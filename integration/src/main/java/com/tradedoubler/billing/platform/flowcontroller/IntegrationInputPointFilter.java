package com.tradedoubler.billing.platform.flowcontroller;

import com.tradedoubler.billing.platform.logging.LogError;
import org.mule.api.MuleMessage;
import org.mule.api.routing.filter.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Inspects and decides what to do with input fetched from an input integration point.
 * Empty or erroneous executions will be ended here.
 */
public class IntegrationInputPointFilter implements Filter {

    private final static Logger log = LoggerFactory.getLogger(IntegrationInputPointFilter.class);

    @Override
    public boolean accept(MuleMessage message) {


        if (message.getPayload() == null || !(message.getPayload() instanceof ServiceResult)) {
            // The wrong payload has arrived, abort the flow
            ServiceResult result = new ServiceResult();
            result.setRawData(message.getPayload());
            String errorMessage = "An input fetching component doesn't pass along a " +
                    "ServiceResult object. This violates the platform rules and the flow is now ended.";
            result.setErrorMessage(errorMessage);
            //FlowService.registerBugDisturbance( flowName, message.getMuleContext(),result);
            try {
                Thread.sleep(60000);
            } catch (Exception e) {
                // ignore
            }
            log.error(LogError.PLATFORM.name() + " - " +  errorMessage);
            return false;
        }

        ServiceResult result = (ServiceResult) message.getPayload();

        String flowName = result.getFlowName().name();

        if (result.isIntegrationPointDisturbance()) {
            // Book keep the input disturbance for later executions
            FlowService.registerInputDisturbance(flowName, message.getMuleContext(), result);
            log.info("Integration point disturbance registered [" + flowName + "]: " + result.getErrorMessage());
            return false;
        }

        if (result.isBugDisturbance()) {
            // Book keep the bug disturbance for later executions
            FlowService.registerBugDisturbance(flowName, message.getMuleContext(), result.getErrorMessage(), result.getDetailedErrorMessage());
            log.info("Bug disturbance registered [" + flowName + "]: " + result.getErrorMessage());
            return false;
        }

        // Clear potentially earlier input disturbance state
        FlowService.clearInputDisturbance(flowName, message.getMuleContext());

        if ( !result.isDataToProcess()){
            log.info(result.getFlowName().name() + " terminates successfully due to lack of input.");
        }

        return result.isDataToProcess();
    }
}


