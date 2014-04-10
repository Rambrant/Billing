package com.tradedoubler.billing.platform.flowcontroller;

/**
 * Tracks status information about an ongoing Mule flow.
 * This class is not thread-safe.
 */
public class FlowInfo {

    /** The identifier of the flow that is being tracked. */
    private final String flowId;

    /** Determines if the flow is currently suffering from an input integration point operational disturbance. */
    private boolean inputDisturbance;

    /** Tracks the start time of an ongoing input integration point disturbance. */
    private long inputDisturbanceStartTime;

    /** Tracks how many retries the flow has performed since an input disturbance occurred. */
    private int numberOfInputRetries;

    /** Determines if the flow is currently suffering from an output integration point operational disturbance. */
    private boolean outputDisturbance;

    /** Tracks the time of an ongoing output integration point disturbance. */
    private long outputDisturbanceStartTime;

    /** Tracks how many retries the flow has performed since the output point disturbance occurred. */
    private int numberOfOutputRetries;


    /** Description of the error that caused the disturbance. */
    private String errorMessage;

    /** A detailed description of the error that caused the disturbance. */
    private String detailedErrorMessage;


    /** Determines if the flow is currently suffering from a bug. */
    private boolean bugDisturbance;

    /** Tracks */
    private long bugDisturbanceStartTime;

    /** Determines when the flow should be allowed to run next time, only used when there is an ongoing disturbance. */
    private long nextTimeToRun;

    /** Determines the server time of when the last invocation of the flow was made. */
    private long lastInvocationStartTime;

    /** Determines the server time of when the last successful run of the flow concluded in FlowEnd. */
    private long lastSuccessfulInvocationStopTime;


    /**
     * Creates a new FlowInfo object.
     *
     * @param flowId The identifier for the flow that should be tracked. It is assumed that the caller will keep
     *               track of different flow ids and thus separate different flows from each other.
     */
    public FlowInfo(String flowId) {
        this.flowId = flowId;
    }

    /** Is there an ongoing disturbance of any kind? */
    public boolean hasOperationalDisturbance() {
        return inputDisturbance || outputDisturbance || bugDisturbance;
    }

    /** Is there an ongoing bug disturbance? */
    public boolean hasBugDisturbance() {
        return bugDisturbance;
    }

    /** Registers a bug disturbance. */
    public void registerBugDisturbance(String errorMessage, String detailedErrorMessage) {
        if (!bugDisturbance) {
            bugDisturbanceStartTime = System.currentTimeMillis();
        }
        this.errorMessage = errorMessage;
        this.detailedErrorMessage = detailedErrorMessage;
        bugDisturbance = true;
    }

    /** Clears a bug disturbance. */
    public void clearBugDisturbance() {
        this.bugDisturbance = false;
        this.bugDisturbanceStartTime = 0;
        this.errorMessage = null;
    }

    public void increaseNumberOfInputRetries() {
        numberOfInputRetries++;
    }


    /** Is there an ongoing input integration point disturbance? */
    public boolean hasInputDisturbance() {
        return inputDisturbance;
    }

    /** Registers an input integration point disturbance. */
    public void registerInputDisturbance(ServiceResult result) {
        inputDisturbance = true;
        if (numberOfInputRetries == 0) {
            inputDisturbanceStartTime = System.currentTimeMillis();
        }
        this.errorMessage = result.getErrorMessage();
        this.detailedErrorMessage = result.getDetailedErrorMessage();
    }

    /** Clears an input disturbance. */
    public void clearInputDisturbance() {
        this.inputDisturbance = false;
        this.inputDisturbanceStartTime = 0;
        this.numberOfInputRetries = 0;
        this.errorMessage = null;
        this.detailedErrorMessage = null;
    }


    /** Is there an ongoing output integration point disturbance? */
    public boolean hasOutputDisturbance() {
        return outputDisturbance;
    }

    /** Registers an output integration point disturbance. */
    public void registerOutputDisturbance(ServiceResult result) {
        outputDisturbance = true;
        if (numberOfOutputRetries == 0) {
            outputDisturbanceStartTime = System.currentTimeMillis();
        }
        this.errorMessage = result.getErrorMessage();
        this.detailedErrorMessage = result.getDetailedErrorMessage();
    }

    /** Clears an output disturbance. */
    public void clearOutputDisturbance() {
        this.outputDisturbance = false;
        this.outputDisturbanceStartTime = 0;
        this.numberOfOutputRetries = 0;
        this.errorMessage = null;
        this.detailedErrorMessage = null;
    }

    public void increaseNumberOfOutputRetries() {
        numberOfOutputRetries++;
    }

    public int getNumberOfOutputRetries() {
        return numberOfOutputRetries;
    }

    public long getNextTimeToRun() {
        return nextTimeToRun;
    }

    public void setNextTimeToRun(long nextTimeToRun) {
        this.nextTimeToRun = nextTimeToRun;
    }

    public String getFlowId() {
        return flowId;
    }

    public long getInputDisturbanceStartTime() {
        return inputDisturbanceStartTime;
    }

    public int getNumberOfInputRetries() {
        return numberOfInputRetries;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public long getOutputDisturbanceStartTime() {
        return outputDisturbanceStartTime;
    }

    public long getBugDisturbanceStartTime() {
        return bugDisturbanceStartTime;
    }

    public String getDetailedErrorMessage() {
        return detailedErrorMessage;
    }

    @Override
    public String toString() {
        return "FlowInfo{" +
                "flowId='" + flowId + '\'' +
                ", inputDisturbance=" + inputDisturbance +
                ", inputDisturbanceStartTime=" + inputDisturbanceStartTime +
                ", numberOfInputRetries=" + numberOfInputRetries +
                ", outputDisturbance=" + outputDisturbance +
                ", outputDisturbanceStartTime=" + outputDisturbanceStartTime +
                ", numberOfOutputRetries=" + numberOfOutputRetries +
                ", errorMessage='" + errorMessage + '\'' +
                ", detailedErrorMessage='" + detailedErrorMessage + '\'' +
                ", bugDisturbance=" + bugDisturbance +
                ", bugDisturbanceStartTime=" + bugDisturbanceStartTime +
                ", nextTimeToRun=" + nextTimeToRun +
                '}';
    }
}
