package com.tradedoubler.billing.service;

/**
 * This exception is thrown if a service call fails. It can be either a bug disturbance or integration
 * disturbance. The exception is used to terminate the service call and the call may be halfway done
 * (no rollback unless explicitly defined). The platform will retry the call to finnish the halfdone 
 * call.
 * 
 * The exception will be catched by the Mule component, which inserts the exception into the 
 * ServiceResult instance. 
  * @since 2012-06-12
 */
public class BillingServiceException extends Exception {
    /** Bug or integration disturbance */
    private final ServiceResultCategory category;
    /** Error Code if applicable, otherwise it is set to -1 */
    private final int code;

    private BillingServiceException(String message, ServiceResultCategory category, int code) {
        super(message);
        this.category = category;
        this.code = code;
    }

    public static BillingServiceException createBugDisturbance(String errorMessage, int code) {
        return new BillingServiceException(errorMessage, ServiceResultCategory.BUG_DISTURBANCE, code);
    }

    public static BillingServiceException createBugDisturbance(String errorMessage) {
        return createBugDisturbance(errorMessage, -1);
    }

    public static BillingServiceException createIntegrationDisturbance(String errorMessage, int code) {
        return new BillingServiceException(errorMessage, ServiceResultCategory.INTEGRATION_DISTURBANCE, code);
    }

    public static BillingServiceException createIntegrationDisturbance(String errorMessage) {
        return new BillingServiceException(errorMessage, ServiceResultCategory.INTEGRATION_DISTURBANCE, -1);
    }

    /** Error Code if applicable, otherwise it is set to -1 */
    public int getCode() {
        return code;
    }

    /** Bug or integration disturbance */
    public ServiceResultCategory getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return String.format("BillingServiceException{message='%s', category=%s, code=%d}",
                getMessage(), category, code);
    }


}
