package com.tradedoubler.billing.domain;

/**
 * Currency used for the client order in ISO 4217 format
 *
 * @author bjoek
 * @since 2012-08-17
 */
public class Currency {
    private final String currencyCode;

    public Currency(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }
}
