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
 * <p>Java class for AxdEnum_PaymSchedTaxDistribution.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_PaymSchedTaxDistribution">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Proportional"/>
 *     &lt;enumeration value="FirstRate"/>
 *     &lt;enumeration value="LastRate"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_PaymSchedTaxDistribution")
@XmlEnum
public enum AxdEnumPaymSchedTaxDistribution {

    @XmlEnumValue("Proportional")
    PROPORTIONAL("Proportional"),
    @XmlEnumValue("FirstRate")
    FIRST_RATE("FirstRate"),
    @XmlEnumValue("LastRate")
    LAST_RATE("LastRate");
    private final String value;

    AxdEnumPaymSchedTaxDistribution(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumPaymSchedTaxDistribution fromValue(String v) {
        for (AxdEnumPaymSchedTaxDistribution c: AxdEnumPaymSchedTaxDistribution.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
