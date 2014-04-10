
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_HcmPersonMaritalStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_HcmPersonMaritalStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Married"/>
 *     &lt;enumeration value="Single"/>
 *     &lt;enumeration value="Widowed"/>
 *     &lt;enumeration value="Divorced"/>
 *     &lt;enumeration value="Cohabiting"/>
 *     &lt;enumeration value="RegisteredPartnership"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_HcmPersonMaritalStatus")
@XmlEnum
public enum AxdEnumHcmPersonMaritalStatus {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Married")
    MARRIED("Married"),
    @XmlEnumValue("Single")
    SINGLE("Single"),
    @XmlEnumValue("Widowed")
    WIDOWED("Widowed"),
    @XmlEnumValue("Divorced")
    DIVORCED("Divorced"),
    @XmlEnumValue("Cohabiting")
    COHABITING("Cohabiting"),
    @XmlEnumValue("RegisteredPartnership")
    REGISTERED_PARTNERSHIP("RegisteredPartnership");
    private final String value;

    AxdEnumHcmPersonMaritalStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumHcmPersonMaritalStatus fromValue(String v) {
        for (AxdEnumHcmPersonMaritalStatus c: AxdEnumHcmPersonMaritalStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
