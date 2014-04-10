package com.tradedoubler.billing.domain;

/**
 * Status indicator if the order line has been processed by Ax
 *
 * @author bjorn
 * @since 2012-10-10
 */
public enum OrderLineStatus {
    NOT_PROCESSED, SENT_TO_AX_SUCCEEDED, SENT_TO_AX_FAILED, VALIDATION_FAILED;

    public boolean isFailed() {
        return this == SENT_TO_AX_FAILED || this == VALIDATION_FAILED;
    }
}
