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
 * <p>Java class for AxdEnum_PurchMatchingPolicyWithNotSetOption.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_PurchMatchingPolicyWithNotSetOption">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NotSet"/>
 *     &lt;enumeration value="ThreeWayMatch"/>
 *     &lt;enumeration value="TwoWayMatch"/>
 *     &lt;enumeration value="NoMatch"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_PurchMatchingPolicyWithNotSetOption")
@XmlEnum
public enum AxdEnumPurchMatchingPolicyWithNotSetOption {

    @XmlEnumValue("NotSet")
    NOT_SET("NotSet"),
    @XmlEnumValue("ThreeWayMatch")
    THREE_WAY_MATCH("ThreeWayMatch"),
    @XmlEnumValue("TwoWayMatch")
    TWO_WAY_MATCH("TwoWayMatch"),
    @XmlEnumValue("NoMatch")
    NO_MATCH("NoMatch");
    private final String value;

    AxdEnumPurchMatchingPolicyWithNotSetOption(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumPurchMatchingPolicyWithNotSetOption fromValue(String v) {
        for (AxdEnumPurchMatchingPolicyWithNotSetOption c: AxdEnumPurchMatchingPolicyWithNotSetOption.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
