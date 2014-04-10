package com.tradedoubler.billing.platform.flowcontroller;

import com.tradedoubler.billing.platform.logging.LogError;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.mule.message.ExceptionMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Default exception handler for all mule flows. It will mark the responsible flow as having a bug disturbance.
 * This handler acts as a catch-all point in Mule.
 */
public class FlowExceptionHandler implements Callable {

    private final static Logger log = LoggerFactory.getLogger(FlowExceptionHandler.class);

    @Override
    public Object onCall(MuleEventContext muleEventContext) throws Exception {

        try {

            String flowName = muleEventContext.getFlowConstruct().getName();

            ExceptionMessage exceptionMessage = (ExceptionMessage) muleEventContext.getMessage().getPayload();

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            exceptionMessage.getException().getCause().printStackTrace(pw);
            String err = sw.toString();
            if ( err != null){
                err = err.replace('\n',' ');
                err = err.replace('\r', ' ');
            }

            String errorMessage = "Flow with name: " + flowName + " has encountered an unexpected exception that " +
                    "has invoked the Mule Default exception handler. " +
                    " This violates the platform rules and the flow will now be marked as having a bug disturbance. " +
                    "  The actual error: " + err;

            if( exceptionMessage.getPayload() instanceof ServiceResult) {
                ServiceResult result = (ServiceResult) exceptionMessage.getPayload();
                String originalMessage = result.getErrorMessage();
                result.setErrorMessage(errorMessage);

                FlowService.registerBugDisturbance(flowName, muleEventContext.getMuleContext(), result.getErrorMessage() +
                    " The original message: " + originalMessage, result.getDetailedErrorMessage());
            } else {
                FlowService.registerBugDisturbance(flowName, muleEventContext.getMuleContext(), errorMessage, "");
            }

            log.error(LogError.BUG_DISTURBANCE.name() + " - " + errorMessage);

        } catch (Exception e) {
            log.error( LogError.PLATFORM.name(),e);
        }

        return true;
    }
}
