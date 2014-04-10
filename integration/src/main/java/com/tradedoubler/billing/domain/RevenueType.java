package com.tradedoubler.billing.domain;

/**
 * The Revenue Type for an Invoicing rule
 * 1 - Tradedoubler
 * 2 - Private virtual network (PVN)
 *
 * @author bjoek
 * @since 2012-06-13
 */
public class RevenueType {
    private final int value;

    public RevenueType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
