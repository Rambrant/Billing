package com.tradedoubler.billing.platform.logging;

/**
 * Defines the various types of errors that can occur.
 */
public enum LogError {
    OPERATIONAL_DISTURBANCE,
    BUG_DISTURBANCE,
    PLATFORM,
    BUSINESS_COMPONENT,
    AX_INCONSISTENCY
}
