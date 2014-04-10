package com.tradedoubler.billing.service;

/**
 * Classification of disturbance.
 * Integration disturbance is that something in the surrounding environment has failed
 * temporarily so that the flow cannot complete the operation.
 * Bug disturbance is that something in the code or data
 * causes an error that is unlikely to recover from.
 *
 * @author bjoek
 * @since 2012-06-12
 */
public enum ServiceResultCategory {
    /** Temporary recoverable error */
    INTEGRATION_DISTURBANCE, 
    /** Unrecoverable error */
    BUG_DISTURBANCE
}
