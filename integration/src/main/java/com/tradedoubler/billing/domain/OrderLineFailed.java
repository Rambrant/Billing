package com.tradedoubler.billing.domain;

/**
 * Contains information about an order line that was to delivered to Ax for some reason.
 *
 * @author bjoek
 * @since 2012-10-24
 */
public class OrderLineFailed {
    private final String orderLineId;
    private final String errorMessage;

    public OrderLineFailed(String orderLineId, String errorMessage) {
        this.orderLineId = orderLineId;
        this.errorMessage = errorMessage;
    }

    public String getOrderLineId() {
        return orderLineId;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
