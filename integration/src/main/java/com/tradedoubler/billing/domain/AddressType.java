package com.tradedoubler.billing.domain;

/**
 * Address type determines what kind of address is sent.
 *
 * 1 - Means Invoicing address
 * 3 - Means Business address
 *
 * @author bjoek
 * @since 2012-06-25
 */
public class AddressType {
    private final int value;

    public AddressType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
