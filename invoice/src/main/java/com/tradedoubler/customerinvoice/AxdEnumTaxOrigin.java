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
 * <p>Java class for AxdEnum_TaxOrigin.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_TaxOrigin">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Tax"/>
 *     &lt;enumeration value="TaxReporting"/>
 *     &lt;enumeration value="CashDisc"/>
 *     &lt;enumeration value="TaxReversed"/>
 *     &lt;enumeration value="Transfer"/>
 *     &lt;enumeration value="Payment"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_TaxOrigin")
@XmlEnum
public enum AxdEnumTaxOrigin {

    @XmlEnumValue("Tax")
    TAX("Tax"),
    @XmlEnumValue("TaxReporting")
    TAX_REPORTING("TaxReporting"),
    @XmlEnumValue("CashDisc")
    CASH_DISC("CashDisc"),
    @XmlEnumValue("TaxReversed")
    TAX_REVERSED("TaxReversed"),
    @XmlEnumValue("Transfer")
    TRANSFER("Transfer"),
    @XmlEnumValue("Payment")
    PAYMENT("Payment");
    private final String value;

    AxdEnumTaxOrigin(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumTaxOrigin fromValue(String v) {
        for (AxdEnumTaxOrigin c: AxdEnumTaxOrigin.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
