package com.tradedoubler.billing.service.crm;

import com.microsoft.windowsazure.services.core.storage.*;
import com.tradedoubler.billing.fetch.FlowName;
import com.tradedoubler.billing.service.BillingServiceException;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.HashMap;

/**
 * Utility class to handle exceptions that can occur during Azure calls.
 *
 * @author bjoek
 * @since 2012-10-15
 */
public class AzureExceptionHandler {

    /** Create a BillingServiceException from an Azure StorageException. Will extract error messages for the original exception. */
    public static BillingServiceException createException(StorageException e, FlowName flowName, String queueName) {
        String errorMessage = getStorageExceptionString(e, flowName, queueName);
        return BillingServiceException.createIntegrationDisturbance(errorMessage, e.getHttpStatusCode());
    }

    /**
     * Extracts the complete error information out of an azure StorageException.
     *
     * @param e The actual exception
     * @return the extracted error message
     */
    private static String getStorageExceptionString(StorageException e, FlowName flowName, String queueName) {
        try {
            StorageExtendedErrorInformation extInfo = e.getExtendedErrorInformation();
            StringBuffer addInfo = new StringBuffer("[");
            if (extInfo != null) {
                HashMap<String, String[]> addDetails = extInfo.getAdditionalDetails();
                if (addDetails != null) {
                    for (String key : addDetails.keySet()) {
                        String[] values = addDetails.get(key);
                        if (values != null) {
                            addInfo.append(key).append("={");
                            boolean added = false;
                            for (String val : values) {
                                if (added) {
                                    addInfo.append(", ");
                                } else {
                                    added = true;
                                }
                                addInfo.append(val);
                            }
                            addInfo.append("}, ");
                        }
                    }
                }
            }
            addInfo.append("]");

            String errorMessage = "Azure problem for integration " + flowName + " azure queue: " +
                    queueName + " HTTP status code: " + e.getHttpStatusCode() + " Error code: " +
                    e.getErrorCode() + " Error message: " + e.getExtendedErrorInformation().getErrorMessage() +
                    " Additional info: " + addInfo.toString();

            return errorMessage;
        } catch (Exception exp) {
            return "Error while extracing info from a StorageException: " + exp.getMessage() + " StorageException was: " + (e != null ? e.getMessage() : "<null>");
        }
    }

    /** Create a BillingServiceException from an InvalidKeyException. Will extract error messages for the original exception. */
    public static BillingServiceException createException(InvalidKeyException e, FlowName flowName, String queueName) {
        return BillingServiceException.createBugDisturbance("Azure problem for integration " + flowName + " azure queue: " +
                queueName + " InvalidKeyException towards Azure: " + e.getMessage());
    }

    /** Create a BillingServiceException from an URISyntaxException. Will extract error messages for the original exception. */
    public static BillingServiceException createException(URISyntaxException e, FlowName flowName, String queueName) {
        return BillingServiceException.createBugDisturbance("Azure problem for integration " + flowName + " azure queue: " +
                queueName + " URISyntaxException towards Azure. Input: " + e.getInput() +
                " Reason:  " + e.getReason() + " Message: " + e.getMessage());
    }

}
