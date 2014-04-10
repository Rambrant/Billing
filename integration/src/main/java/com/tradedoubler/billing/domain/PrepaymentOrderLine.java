package com.tradedoubler.billing.domain;

/**
 * Order line for a prepayment program. Used to create forecasts for Crm.
 *
 * @author bjoek
 * @since 2012-11-08
 */
public class PrepaymentOrderLine {
    private final OrderLine orderLine;
    private final Currency currency;

    public PrepaymentOrderLine(OrderLine orderLine, Currency currency) {
        this.orderLine = orderLine;
        this.currency = currency;
    }

    public OrderLine getOrderLine() {
        return orderLine;
    }

    public Currency getCurrency() {
        return currency;
    }

}
