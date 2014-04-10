
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_PurchMatchingPolicyOption.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_PurchMatchingPolicyOption">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ThreeWayMatch"/>
 *     &lt;enumeration value="TwoWayMatch"/>
 *     &lt;enumeration value="NoMatch"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_PurchMatchingPolicyOption")
@XmlEnum
public enum AxdEnumPurchMatchingPolicyOption {

    @XmlEnumValue("ThreeWayMatch")
    THREE_WAY_MATCH("ThreeWayMatch"),
    @XmlEnumValue("TwoWayMatch")
    TWO_WAY_MATCH("TwoWayMatch"),
    @XmlEnumValue("NoMatch")
    NO_MATCH("NoMatch");
    private final String value;

    AxdEnumPurchMatchingPolicyOption(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumPurchMatchingPolicyOption fromValue(String v) {
        for (AxdEnumPurchMatchingPolicyOption c: AxdEnumPurchMatchingPolicyOption.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
