
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_smmSensitivity.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_smmSensitivity">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Normal"/>
 *     &lt;enumeration value="Personal"/>
 *     &lt;enumeration value="Privat"/>
 *     &lt;enumeration value="Confidential"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_smmSensitivity")
@XmlEnum
public enum AxdEnumSmmSensitivity {

    @XmlEnumValue("Normal")
    NORMAL("Normal"),
    @XmlEnumValue("Personal")
    PERSONAL("Personal"),
    @XmlEnumValue("Privat")
    PRIVAT("Privat"),
    @XmlEnumValue("Confidential")
    CONFIDENTIAL("Confidential");
    private final String value;

    AxdEnumSmmSensitivity(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumSmmSensitivity fromValue(String v) {
        for (AxdEnumSmmSensitivity c: AxdEnumSmmSensitivity.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
