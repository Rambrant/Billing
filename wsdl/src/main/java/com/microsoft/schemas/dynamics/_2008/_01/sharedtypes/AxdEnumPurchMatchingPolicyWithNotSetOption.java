
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

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
