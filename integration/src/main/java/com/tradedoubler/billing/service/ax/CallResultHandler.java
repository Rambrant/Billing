package com.tradedoubler.billing.service.ax;

import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.webservice.*;
import com.tradedoubler.billing.service.ax.webservice.call.AbstractWebServiceCall;
import org.springframework.stereotype.Component;

/**
 * Checks that AxRequestResult from an Ax web service call is correct. Depending on operation type, different errors
 * will either result in bug or integration disturbance.
 * 
 * @author bjoek
 * @since 2012-08-31
 */
@Component
public class CallResultHandler {
    /** For an Insert call */
    public void handleInsertResult(AbstractWebServiceCall call) throws BillingServiceException {
        AxRequestResult requestResult = call.getAxRequestResult();
        switch (requestResult) {
            case UNKNOWN:
                throw BillingServiceException.createIntegrationDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case DB_DEADLOCK:
                throw BillingServiceException.createIntegrationDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case TIME_OUT_SERVER_BUSY:
                throw BillingServiceException.createIntegrationDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case SCHEMA_ERROR:
                throw BillingServiceException.createBugDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case FATAL_ERROR:
                throw BillingServiceException.createBugDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case ALL_IS_WELL:
                return;
            case ENTITY_NOT_FOUND:
                throw BillingServiceException.createBugDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case DOCUMENT_HASH_CHANGED:
                throw BillingServiceException.createBugDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case RECORD_ALREADY_EXISTS:
                throw BillingServiceException.createIntegrationDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
        }

        throw new IllegalArgumentException("Cannot handle requestResult: " + requestResult);
    }

    /** For an Update call */
    public void handleUpdateResult(AbstractWebServiceCall call) throws BillingServiceException {
        AxRequestResult requestResult = call.getAxRequestResult();
        switch (requestResult) {
            case UNKNOWN:
                throw BillingServiceException.createIntegrationDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case DB_DEADLOCK:
                throw BillingServiceException.createIntegrationDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case TIME_OUT_SERVER_BUSY:
                throw BillingServiceException.createIntegrationDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case SCHEMA_ERROR:
                throw BillingServiceException.createBugDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case FATAL_ERROR:
                throw BillingServiceException.createBugDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case ALL_IS_WELL:
                return;
            case ENTITY_NOT_FOUND:
                throw BillingServiceException.createIntegrationDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case DOCUMENT_HASH_CHANGED:
                throw BillingServiceException.createIntegrationDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case RECORD_ALREADY_EXISTS:
                throw BillingServiceException.createBugDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
        }

        throw new IllegalArgumentException("Cannot handle requestResult: " + requestResult);
    }

    /** For a Read call */
    public void handleReadResult(AbstractWebServiceCall call) throws BillingServiceException {
        AxRequestResult requestResult = call.getAxRequestResult();
        switch (requestResult) {
            case UNKNOWN:
                throw BillingServiceException.createIntegrationDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case DB_DEADLOCK:
                throw BillingServiceException.createIntegrationDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case TIME_OUT_SERVER_BUSY:
                throw BillingServiceException.createIntegrationDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case SCHEMA_ERROR:
                throw BillingServiceException.createBugDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case FATAL_ERROR:
                throw BillingServiceException.createBugDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case ALL_IS_WELL:
                return;
            case ENTITY_NOT_FOUND:
                throw BillingServiceException.createBugDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case DOCUMENT_HASH_CHANGED:
                throw BillingServiceException.createBugDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case RECORD_ALREADY_EXISTS:
                throw BillingServiceException.createBugDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
        }

        throw new IllegalArgumentException("Cannot handle requestResult: " + requestResult);
    }

    /** For a Find call */
    public void handleFindResult(AbstractWebServiceCall call) throws BillingServiceException {
        AxRequestResult requestResult = call.getAxRequestResult();
        switch (requestResult) {
            case UNKNOWN:
                throw BillingServiceException.createIntegrationDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case DB_DEADLOCK:
                throw BillingServiceException.createIntegrationDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case TIME_OUT_SERVER_BUSY:
                throw BillingServiceException.createIntegrationDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case SCHEMA_ERROR:
                throw BillingServiceException.createBugDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case FATAL_ERROR:
                throw BillingServiceException.createBugDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case ALL_IS_WELL:
                return;
            case ENTITY_NOT_FOUND:
                throw BillingServiceException.createBugDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case DOCUMENT_HASH_CHANGED:
                throw BillingServiceException.createBugDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case RECORD_ALREADY_EXISTS:
                throw BillingServiceException.createBugDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
        }

        throw new IllegalArgumentException("Cannot handle requestResult: " + requestResult);
    }

    /** For a Delete call */
    public void handleDeleteResult(AbstractWebServiceCall call) throws BillingServiceException {
        AxRequestResult requestResult = call.getAxRequestResult();
        switch (requestResult) {
            case UNKNOWN:
                throw BillingServiceException.createIntegrationDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case DB_DEADLOCK:
                throw BillingServiceException.createIntegrationDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case TIME_OUT_SERVER_BUSY:
                throw BillingServiceException.createIntegrationDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case SCHEMA_ERROR:
                throw BillingServiceException.createBugDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case FATAL_ERROR:
                throw BillingServiceException.createBugDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case ALL_IS_WELL:
                return;
            case ENTITY_NOT_FOUND:
                throw BillingServiceException.createIntegrationDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case DOCUMENT_HASH_CHANGED:
                throw BillingServiceException.createIntegrationDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
            case RECORD_ALREADY_EXISTS:
                throw BillingServiceException.createBugDisturbance(call.getCallLogInformation() + ", " + requestResult.getDescription() + " : " + call.getErrorMessage(), call.getErrorCode());
        }

        throw new IllegalArgumentException("Cannot handle requestResult: " + requestResult);
    }
}
