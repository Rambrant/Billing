package com.tradedoubler.billing.platform.flowcontroller;

import com.tradedoubler.billing.platform.logging.LogError;
import org.mule.api.MuleContext;
import org.mule.api.registry.RegistrationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * A service that manages the bookkeeping of Mule flows and their corresponding state information.
 * This class is thread-safe.
 */
public class FlowService {

    private final static Logger log = LoggerFactory.getLogger(FlowService.class);

    private static FlowControllerSettings flowControllerSettings;

    public FlowControllerSettings getFlowControllerSettings() {
        return flowControllerSettings;
    }

    public void setFlowControllerSettings(FlowControllerSettings flowControllerSettings) {
        this.flowControllerSettings = flowControllerSettings;
    }

    /**
     * Computes the given flow id from the given flow and context.
     *
     * @param flowName The name of the flow.
     * @param context  The mule context where the flow is running.
     * @return The flow id that the bookkeeping is based upon.
     */
    private static String computeFlowId(String flowName, MuleContext context) {
        if (flowName == null) {
            throw new IllegalArgumentException("No flow name supplied");
        }

        if (context == null) {
            throw new IllegalArgumentException("No mule context supplied");
        }

        return flowName + "_info";
    }

    /**
     * Fetches the registered information for the given flow name.
     *
     * @param flowName The name of the flow.
     * @param context  The mule context where the flow is running.
     * @return The registered information for the flow.
     */
    public static FlowInfo getFlowInfo(String flowName, MuleContext context) {

        String flowId = computeFlowId(flowName, context);

        FlowInfo flowInfo = context.getRegistry().get(flowId);
        if (flowInfo == null) {
            flowInfo = new FlowInfo(flowId);
            try {
                context.getRegistry().registerObject(flowId, flowInfo);
            } catch (RegistrationException exp) {
                log.error(LogError.PLATFORM.name(), exp);
            }
        }

        return flowInfo;
    }


    /**
     * Computes the next time to run the flow depending on how many times it has failed
     * already. Bug disturbances are always handled equal independent on how many fails that have occurred.
     */
    private static long computeNextTimeToRun(int numberOfRetries, boolean bugDisturbance) {

        if (numberOfRetries < 0) {
            throw new IllegalArgumentException("numberOfRetries must be greater than zero.");
        }

        if (bugDisturbance) {
            return System.currentTimeMillis() + flowControllerSettings.FLOW_CONTROLLER_BUG_DISTURBANCE;
        }

        switch (numberOfRetries) {
            case 0:
                return System.currentTimeMillis() + flowControllerSettings.FLOW_CONTROLLER_DISTURBANCE_1;
            case 1:
                return System.currentTimeMillis() + flowControllerSettings.FLOW_CONTROLLER_DISTURBANCE_2;
            default:
                return System.currentTimeMillis() + flowControllerSettings.FLOW_CONTROLLER_DISTURBANCE_3;
        }
    }


    /** Registers a new input disturbance for the given flow. */
    public static void registerInputDisturbance(String flowName, MuleContext context, ServiceResult result) {

        String flowId = computeFlowId(flowName, context);
        FlowInfo flowInfo = context.getRegistry().get(flowId);
        if (flowInfo == null) {
            throw new IllegalArgumentException("No such flow registered: " + flowName);
        }

        flowInfo.registerInputDisturbance(result);

        // Compute the next time to run
        long nextTimeToRun = computeNextTimeToRun(flowInfo.getNumberOfInputRetries(), false);
        flowInfo.setNextTimeToRun(nextTimeToRun);
        flowInfo.increaseNumberOfInputRetries();
    }


    /** Clears an input disturbance. */
    public static void clearInputDisturbance(String flowName, MuleContext context) {
        String flowId = computeFlowId(flowName, context);
        FlowInfo flowInfo = context.getRegistry().get(flowId);
        if (flowInfo == null) {
            throw new IllegalArgumentException("No such flow registered: " + flowName);
        }

        flowInfo.clearInputDisturbance();
    }


    /** Registers a new bug disturbance for the given flow. */
      public static void registerBugDisturbance(String flowName, MuleContext context, String errorMessage, String DetailedErrorMessage) {

        String flowId = computeFlowId(flowName, context);
        FlowInfo flowInfo = context.getRegistry().get(flowId);
        if (flowInfo == null) {
            throw new IllegalArgumentException("No such flow registered: " + flowName);
        }

        flowInfo.registerBugDisturbance(errorMessage, DetailedErrorMessage);

        // Compute the next time to run
        long nextTimeToRun = computeNextTimeToRun(0, true);
        flowInfo.setNextTimeToRun(nextTimeToRun);
    }


    /** Clears a bug disturbance. */
    public static void clearBugDisturbance(String flowName, MuleContext context) {
        String flowId = computeFlowId(flowName, context);
        FlowInfo flowInfo = context.getRegistry().get(flowId);
        if (flowInfo == null) {
            throw new IllegalArgumentException("No such flow registered: " + flowName);
        }

        flowInfo.clearBugDisturbance();
    }


    /** Registers a new output disturbance for the given flow. */
    public static void registerOutputDisturbance(String flowName, MuleContext context, ServiceResult result) {

        String flowId = computeFlowId(flowName, context);
        FlowInfo flowInfo = context.getRegistry().get(flowId);
        if (flowInfo == null) {
            throw new IllegalArgumentException("No such flow registered: " + flowName);
        }

        flowInfo.registerOutputDisturbance(result);

        // Compute the next time to run
        long nextTimeToRun = computeNextTimeToRun(flowInfo.getNumberOfOutputRetries(), false);
        flowInfo.setNextTimeToRun(nextTimeToRun);
        flowInfo.increaseNumberOfOutputRetries();
    }


    /** Clears an output disturbance. */
    public static void clearOutputDisturbance(String flowName, MuleContext context) {
        String flowId = computeFlowId(flowName, context);
        FlowInfo flowInfo = context.getRegistry().get(flowId);
        if (flowInfo == null) {
            throw new IllegalArgumentException("No such flow registered: " + flowName);
        }

        flowInfo.clearOutputDisturbance();
    }

}
