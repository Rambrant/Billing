package com.tradedoubler.billing.domain;

import java.math.BigDecimal;

/**
 * Money, money, money!!!
 *
 * @author bjorn
 * @since 2012-10-12
 */
public class Money {
    private BigDecimal value;

    public Money(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    /** Add amount to current value */
    public void add(Money amount) {
        value = value.add(amount.value);
    }

    /** Reduce current value by amount */
    public void subtract(Money amount) {
        value = value.subtract(amount.value);
    }

    public boolean isNegative() {
        return value.floatValue() < 0;
    }

    public boolean isPositive() {
        return value.floatValue() > 0;
    }

    @Override
    public String toString() {
        return value.toString();
    }


    public boolean isZero() {
        return BigDecimal.ZERO.compareTo(value) == 0;

    }

}
