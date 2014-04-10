
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_PurchReqRFQRequirement.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_PurchReqRFQRequirement">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Informal"/>
 *     &lt;enumeration value="Formal"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_PurchReqRFQRequirement")
@XmlEnum
public enum AxdEnumPurchReqRFQRequirement {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Informal")
    INFORMAL("Informal"),
    @XmlEnumValue("Formal")
    FORMAL("Formal");
    private final String value;

    AxdEnumPurchReqRFQRequirement(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumPurchReqRFQRequirement fromValue(String v) {
        for (AxdEnumPurchReqRFQRequirement c: AxdEnumPurchReqRFQRequirement.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
