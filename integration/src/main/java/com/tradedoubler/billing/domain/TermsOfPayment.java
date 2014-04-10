package com.tradedoubler.billing.domain;

/**
 * How many days Terms of payment is
 *
 * @author bjoek
 * @since 2012-06-13
 */
public class TermsOfPayment {
    private final int days;

    public TermsOfPayment(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }
}
