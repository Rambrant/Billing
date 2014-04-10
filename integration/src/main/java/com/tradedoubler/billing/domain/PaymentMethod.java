package com.tradedoubler.billing.domain;

/**
 * The payment method for an Invoicing rule
 * 2 - EZEUR
 * 3 - ABEUR
 *
 * @author bjoek
 * @since 2012-06-13
 */
public class PaymentMethod {
    private final int value;

    public PaymentMethod(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
