
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_ReferenceDistributionRole.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_ReferenceDistributionRole">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Ordered"/>
 *     &lt;enumeration value="Received"/>
 *     &lt;enumeration value="Invoiced"/>
 *     &lt;enumeration value="Reversed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_ReferenceDistributionRole")
@XmlEnum
public enum AxdEnumReferenceDistributionRole {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Ordered")
    ORDERED("Ordered"),
    @XmlEnumValue("Received")
    RECEIVED("Received"),
    @XmlEnumValue("Invoiced")
    INVOICED("Invoiced"),
    @XmlEnumValue("Reversed")
    REVERSED("Reversed");
    private final String value;

    AxdEnumReferenceDistributionRole(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumReferenceDistributionRole fromValue(String v) {
        for (AxdEnumReferenceDistributionRole c: AxdEnumReferenceDistributionRole.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
