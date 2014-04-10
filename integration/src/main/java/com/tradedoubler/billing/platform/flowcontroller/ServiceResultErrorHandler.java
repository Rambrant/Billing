package com.tradedoubler.billing.platform.flowcontroller;

import com.microsoft.windowsazure.services.core.storage.StorageException;
import com.tradedoubler.billing.service.*;
import com.tradedoubler.billing.service.crm.JsonMessage;
import org.springframework.dao.*;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.SOAPFaultException;

import java.io.PrintWriter;
import java.io.StringWriter;

import static com.tradedoubler.billing.service.ServiceResultCategory.*;

/**
 * Contains methods to have unified handling of common disturbances that may occur in the flows.
 *
 * @since 2012-08-14
 */
public class ServiceResultErrorHandler {
    public static ServiceResult handleException(final ServiceResult serviceResult, String errorMessage, Exception rex) {
        ServiceResultCategory category = getExceptionCategory(rex);
        if (category == BUG_DISTURBANCE) {
            serviceResult.setBugDisturbance(true);
            serviceResult.setDetailedErrorMessage(rex);
        } else {
            serviceResult.setIntegrationPointDisturbance(true);
            serviceResult.setDetailedErrorMessage(rex.toString());
        }

        // Extract crucial info from the cause as well
        if(rex.getCause() != null){
            try{
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                rex.getCause().printStackTrace(pw);
                String err = sw.toString();
                if ( err != null){
                    err = err.replace('\n',' ');
                    err = err.replace('\r', ' ');
                }
                if (serviceResult!=null && err != null && !err.trim().isEmpty()){
                    serviceResult.setDetailedErrorMessage(serviceResult.getDetailedErrorMessage() + " Cause: " + err);
                }
            }catch(Exception e){
                // Ignore this
                e.printStackTrace();
            }
        }

        serviceResult.setErrorMessage(errorMessage);
        return serviceResult;
    }

    private static ServiceResultCategory getExceptionCategory(Exception rex) {
        // If Azure connection fails
        if (rex instanceof StorageException) {
            return INTEGRATION_DISTURBANCE;
        }
        // If the web service call contains a soap fault
        if (rex instanceof SOAPFaultException) {
            return INTEGRATION_DISTURBANCE;
        }
        // If Ax WebService connection fails
        if (rex instanceof WebServiceException) {
            return INTEGRATION_DISTURBANCE;
        }

        // If jdbc connection is lost
        if (rex instanceof CannotGetJdbcConnectionException) {
            return INTEGRATION_DISTURBANCE;
        }
        // If jdbc template fails with recoverable sql error (reset and retry the transaction)
        if (rex instanceof RecoverableDataAccessException) {
            return INTEGRATION_DISTURBANCE;
        }
        // If jdbc template fails with recoverable sql error (the transaction does not even have to be reset)
        if (rex instanceof TransientDataAccessException) {
            return INTEGRATION_DISTURBANCE;
        }
        // A catch all if the exception already is of a type with a classification
        if (rex instanceof BillingServiceException) {
            return ((BillingServiceException) rex).getCategory();
        }

        return BUG_DISTURBANCE;
    }

    public static ServiceResult handleBillingException(final ServiceResult serviceResult, BillingServiceException bsex, String errorMessage) {
        serviceResult.setErrorMessage(errorMessage);
        if (bsex.getCategory() == BUG_DISTURBANCE) {
            serviceResult.setBugDisturbance(true);
        } else {
            serviceResult.setIntegrationPointDisturbance(true);
        }
        serviceResult.setDetailedErrorMessage(bsex.getMessage());
        serviceResult.setErrorCode(bsex.getCode());
        return serviceResult;
    }

    public static ServiceResult handleTransformationFail(ServiceResult serviceResult, Class<?> transformationClass, JsonMessage jsonMessage) {
        serviceResult.setBugDisturbance(true);
        serviceResult.setErrorMessage("Was not able to transform class " + transformationClass);
        serviceResult.setDetailedErrorMessage("Parsed json: " + jsonMessage);
        return serviceResult;
    }

    public static ServiceResult handleJsonValidationFail(ServiceResult serviceResult, String validationErrorMessage, String jsonSchema, String json) {
        serviceResult.setBugDisturbance(true);
        serviceResult.setErrorMessage("Was not able to validate json, error message " + validationErrorMessage);
        serviceResult.setDetailedErrorMessage("Json schema: " + jsonSchema + " parsed json: " + json);
        return serviceResult;
    }

    public static ServiceResult handleJsonValidationFail(final ServiceResult serviceResult, String errorMessage, Exception rex) {
        serviceResult.setBugDisturbance(true);
        serviceResult.setErrorMessage(errorMessage);
        serviceResult.setDetailedErrorMessage(rex);
        return serviceResult;
    }

    public static ServiceResult handleIllegalStateBug(ServiceResult serviceResult, String errorMessage) {
        serviceResult.setBugDisturbance(true);
        serviceResult.setErrorMessage(errorMessage);
        return serviceResult;
    }
}
