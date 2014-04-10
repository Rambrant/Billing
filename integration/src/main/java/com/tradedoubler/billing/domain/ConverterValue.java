package com.tradedoubler.billing.domain;

/**
 * Conversion of value constants between Ax and Crm use this class.
 *
 * @author bjoek
 * @since 2012-10-29
 */
public class ConverterValue<K> {
    public final String axValue;
    public final K crmValue;

    public ConverterValue(String axValue, K crmValue) {
        this.axValue = axValue;
        this.crmValue = crmValue;
    }
}
