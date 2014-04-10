package com.tradedoubler.billing.platform.flowcontroller;

import com.tradedoubler.billing.fetch.FlowName;
import com.tradedoubler.billing.platform.logging.LogError;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.mule.transport.NullPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The FlowController is responsible for determining if a flow will be run or terminated based
 * on the current operational situation.
 */
public class FlowController implements Callable {

    private final static Logger log = LoggerFactory.getLogger(FlowController.class);

    @Override
    public Object onCall(MuleEventContext muleEventContext) throws Exception {

        String flowName = muleEventContext.getSession().getFlowConstruct().getName();

        FlowInfo flowInfo = FlowService.getFlowInfo( flowName, muleEventContext.getMuleContext());

        // Analyze the operational situation
        if ( flowInfo.hasOperationalDisturbance() && System.currentTimeMillis() < flowInfo.getNextTimeToRun()){
            try{
                logDisturbance(flowInfo);
            }catch( Exception e){
                log.error(LogError.PLATFORM.name(), e);
            }finally {
                return NullPayload.getInstance();
            }
        }

        // No current disturbance, lets go
        ServiceResult serviceResult = new ServiceResult();
        try{
            serviceResult.setFlowName(FlowName.valueOf(flowName));
        }catch( IllegalArgumentException e){
            log.error(LogError.PLATFORM.name(), e);
            return NullPayload.getInstance();
        }
        return serviceResult;
    }


    private void logDisturbance( FlowInfo flowInfo){
        try{

            StringBuffer sb = new StringBuffer();
            DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d = new Date();
            boolean added = false;
            sb.append("FlowController aborts flow '" + flowInfo.getFlowId() + "' at " + dfm.format(d) + "     ");

            if ( flowInfo.hasInputDisturbance()){
                d = new Date(flowInfo.getInputDisturbanceStartTime());
                sb.append("Reason: There is an input integration point disturbance that started at: " + dfm.format(d) + "     ");
                if ( flowInfo.getErrorMessage() != null){
                    sb.append("Error message: " + flowInfo.getErrorMessage() + "     ");
                }
                if ( flowInfo.getDetailedErrorMessage() != null){
                    sb.append("Detailed error: " + flowInfo.getDetailedErrorMessage() + "     ");
                }
                d.setTime(flowInfo.getNextTimeToRun());
                sb.append("Next allowed time to run: " + dfm.format(d) + "     ");
                long waitPeriod = (flowInfo.getNextTimeToRun() - flowInfo.getInputDisturbanceStartTime()) / 1000;
                sb.append("Scheduled wait since occurrence: " + waitPeriod + " second(s)     ");
                long remaining = (flowInfo.getNextTimeToRun() - System.currentTimeMillis()) / 1000;
                sb.append("Remains approximately: " + remaining + " second(s) before a new attempt is allowed     ");
                sb.append("Number of retries performed: " + flowInfo.getNumberOfInputRetries() + "     ");
                added = true;
            }
            if ( flowInfo.hasOutputDisturbance()){
                if ( added) sb.append( "Another reason:     ");
                d = new Date(flowInfo.getOutputDisturbanceStartTime());
                sb.append("Reason: There is an output integration point disturbance that started at: " + dfm.format(d) + "     ");
                if ( flowInfo.getErrorMessage() != null){
                    sb.append("Error message: " + flowInfo.getErrorMessage() + "     ");
                }
                if ( flowInfo.getDetailedErrorMessage() != null){
                    sb.append("Detailed error: " + flowInfo.getDetailedErrorMessage() + "     ");
                }
                d.setTime(flowInfo.getNextTimeToRun());
                sb.append("Next allowed time to run: " + dfm.format(d) + "     ");
                long waitPeriod = (flowInfo.getNextTimeToRun() - flowInfo.getOutputDisturbanceStartTime()) / 1000;
                sb.append("Scheduled wait since occurrence: " + waitPeriod + " second(s)     ");
                long remaining = (flowInfo.getNextTimeToRun() - System.currentTimeMillis()) / 1000;
                sb.append("Remains approximately: " + remaining + " second(s) before a new attempt is allowed     ");
                sb.append("Number of retries performed: " + flowInfo.getNumberOfOutputRetries() + "     ");
                added = true;
            }
            if ( flowInfo.hasBugDisturbance()){
                if ( added) sb.append( "Another reason:     ");
                d = new Date(flowInfo.getBugDisturbanceStartTime());
                sb.append("Reason: There is a bug disturbance that started at: " + dfm.format(d) + "     ");
                if ( flowInfo.getErrorMessage() != null){
                    sb.append("Error message: " + flowInfo.getErrorMessage() + "     ");
                }
                if ( flowInfo.getDetailedErrorMessage() != null){
                    sb.append("Detailed error: " + flowInfo.getDetailedErrorMessage() + "     ");
                }
                d.setTime(flowInfo.getNextTimeToRun());
                sb.append("Next allowed time to run: " + dfm.format(d) + "     ");
                long waitPeriod = (flowInfo.getNextTimeToRun() - flowInfo.getBugDisturbanceStartTime()) / 1000;
                sb.append("Scheduled wait since occurrence: " + waitPeriod + " second(s)     ");
                long remaining = (flowInfo.getNextTimeToRun() - System.currentTimeMillis()) / 1000;
                sb.append("Remains approximately: " + remaining + " second(s) before a new attempt is allowed     ");
            }

            String logMessage = sb.toString();
            //To avoid line breaks in log. logMessage can't be null so no check
            logMessage = logMessage.replaceAll("\\r\\n|\\r|\\n", " ");

            if ( flowInfo.hasBugDisturbance()){
                log.error(LogError.BUG_DISTURBANCE.name() + " - " + logMessage);
            }else {
                boolean elevate = (flowInfo.hasInputDisturbance() && flowInfo.getNumberOfInputRetries() > 3) ||
                        (flowInfo.hasOutputDisturbance() && flowInfo.getNumberOfOutputRetries() > 3);
                if(elevate){
                    log.error(LogError.OPERATIONAL_DISTURBANCE.name() + " - " + logMessage);
                }else{
                    log.warn(LogError.OPERATIONAL_DISTURBANCE.name() + " - " + logMessage);
                }
            }

        }catch(Exception e){
            log.error(LogError.PLATFORM.name(),e);
        }
    }
}
