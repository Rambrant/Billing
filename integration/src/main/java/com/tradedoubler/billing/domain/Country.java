package com.tradedoubler.billing.domain;

/**
 * Two character country code according to ISO-3166
 *
 * @author bjoek
 * @since 2012-08-17
 */
public class Country {
    private final String value;

    public Country(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
