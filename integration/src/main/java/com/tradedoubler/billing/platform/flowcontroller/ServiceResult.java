package com.tradedoubler.billing.platform.flowcontroller;

import com.tradedoubler.billing.fetch.FlowName;

import java.io.*;

/** Defines a result object that is used to communicate between components of a Mule flow. */
public class ServiceResult {

    /** Determines the name of the actual flow the result is for. */
    private FlowName flowName;

    /** The available raw data. */
    private Object rawData;

    /**
     * Stores information that is needed to commit a successful flow.
     * Can be for example info about what azure message to delete etc.
     */
    private Object commitInfo;

    /** The integration message if/when one has been created. */
    private IntegrationMessage integrationMessage;

    /** If true indicates an integration point disturbance. */
    private boolean integrationPointDisturbance;

    /** If true indicates a bug disturbance. */
    private boolean bugDisturbance;

    /** An error code if available. */
    private long errorCode;

    /** A concrete message describing the error if one has occurred. */
    private String errorMessage;

    /** A technical error message such as stack traces. */
    private String detailedErrorMessage;


    /**
     * Determines if there is any data to process.
     */
    public boolean isDataToProcess() {
        return rawData != null;
    }

    public boolean isDisturbance() {
        return integrationPointDisturbance || bugDisturbance;
    }

    public Object getRawData() {
        return rawData;
    }

    public void setRawData(Object rawData) {
        this.rawData = rawData;
    }

    public boolean isIntegrationPointDisturbance() {
        return integrationPointDisturbance;
    }

    public void setIntegrationPointDisturbance(boolean integrationPointDisturbance) {
        this.integrationPointDisturbance = integrationPointDisturbance;
    }

    public boolean isBugDisturbance() {
        return bugDisturbance;
    }

    public void setBugDisturbance(boolean bugDisturbance) {
        this.bugDisturbance = bugDisturbance;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public IntegrationMessage getIntegrationMessage() {
        return integrationMessage;
    }

    public void setIntegrationMessage(IntegrationMessage integrationMessage) {
        this.integrationMessage = integrationMessage;
    }

    public long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(long errorCode) {
        this.errorCode = errorCode;
    }

    public String getDetailedErrorMessage() {
        return detailedErrorMessage;
    }

    public void setDetailedErrorMessage(String detailedErrorMessage) {
        this.detailedErrorMessage = detailedErrorMessage;
    }

    public void setDetailedErrorMessage(Exception detailedError) {
        if (detailedError == null) {
            this.detailedErrorMessage = "ServiceResult.setDetailedErrorMessage is invoked without an exception. Probably not what was intended?";
            return;
        }
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        detailedError.printStackTrace(pw);
        this.detailedErrorMessage = sw.toString();
    }

    public Object getCommitInfo() {
        return commitInfo;
    }

    public void setCommitInfo(Object commitInfo) {
        this.commitInfo = commitInfo;
    }

    public FlowName getFlowName() {
        return flowName;
    }

    public void setFlowName(FlowName flowName) {
        this.flowName = flowName;
    }

    @Override
    public String toString() {
        String rawdataShort;
        if (rawData instanceof ServiceResult){
            throw new IllegalArgumentException("Raw data is ServiceResult!");
        }
        if (rawData == null || rawData.toString() == null) {
            rawdataShort = null;
        } else if (rawData.toString().length() > 20) {
            rawdataShort = rawData.toString().substring(0, 17) + "...";
        } else {
            rawdataShort = rawData.toString();
        }
        return "ServiceResult{" +
                "flowName=" + flowName +
                ", bugDisturbance=" + bugDisturbance +
                ", integrationPointDisturbance=" + integrationPointDisturbance +
                ", errorCode=" + errorCode +
                ", errorMessage='" + errorMessage + '\'' +
                ", detailedErrorMessage='" + detailedErrorMessage + '\'' +
                ", rawData=" + rawdataShort +
                ", integrationMessage=" + integrationMessage +
                ", commitInfo=" + commitInfo +
                '}';
    }

    public String toStringShort() {
        String rawdataShort;
        if (rawData == null || rawData.toString() == null) {
            rawdataShort = null;
        } else if (rawData.toString().length() > 20) {
            rawdataShort = rawData.toString().substring(0, 17) + "...";
        } else {
            rawdataShort = rawData.toString();
        }
        return "ServiceResult{" +
                "flowName=" + flowName +
                ", disturbance=" + isDisturbance() +
                ", errorCode=" + errorCode +
                ", errorMessage='" + errorMessage + '\'' +
                ", detailedErrorMessage='" + detailedErrorMessage + '\'' +
                ", rawData=" + rawdataShort +
                ", integrationMessage=" + integrationMessage +
                ", commitInfo=" + commitInfo +
                '}';
    }

}
