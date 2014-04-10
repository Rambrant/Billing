//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.12.28 at 01:35:45 PM CET 
//


package com.tradedoubler.customerinvoice;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_CreditCardAddressVerificationLevel.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_CreditCardAddressVerificationLevel">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Accept"/>
 *     &lt;enumeration value="AccountHolderName"/>
 *     &lt;enumeration value="BillingPostalCode"/>
 *     &lt;enumeration value="BillingAddress"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_CreditCardAddressVerificationLevel")
@XmlEnum
public enum AxdEnumCreditCardAddressVerificationLevel {

    @XmlEnumValue("Accept")
    ACCEPT("Accept"),
    @XmlEnumValue("AccountHolderName")
    ACCOUNT_HOLDER_NAME("AccountHolderName"),
    @XmlEnumValue("BillingPostalCode")
    BILLING_POSTAL_CODE("BillingPostalCode"),
    @XmlEnumValue("BillingAddress")
    BILLING_ADDRESS("BillingAddress");
    private final String value;

    AxdEnumCreditCardAddressVerificationLevel(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumCreditCardAddressVerificationLevel fromValue(String v) {
        for (AxdEnumCreditCardAddressVerificationLevel c: AxdEnumCreditCardAddressVerificationLevel.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
