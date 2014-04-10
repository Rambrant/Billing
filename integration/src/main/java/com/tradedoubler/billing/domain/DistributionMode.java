package com.tradedoubler.billing.domain;

/**
 * How an Invoice should be sent
 * 1 - Invoice is sent by mail
 * 2 - Invoice is sent by email
 * 3 - Invoice is sent by both email and mail
 *
 * @author bjoek
 * @since 2012-06-13
 */
public class DistributionMode {
    private final int value;

    public DistributionMode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
