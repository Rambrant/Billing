package com.tradedoubler.billing.service.ax.webservice.call;

/** Data holder for the result of attempting insert/update of orderLines to Ax. */
public class OrderLineResponseResult {

    private final String orderLineId;
    private final String errorMessage;
    private final String state;

    public OrderLineResponseResult(String orderLineId, String errorMessage, String state) {
        this.orderLineId = orderLineId;
        this.errorMessage = errorMessage;

        this.state = state;
    }

    public String getOrderLineId() {
        return orderLineId;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getState() {
        return state;
    }
}
