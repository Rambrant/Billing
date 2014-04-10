
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_smmActivityCategory.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_smmActivityCategory">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Appointment"/>
 *     &lt;enumeration value="Task"/>
 *     &lt;enumeration value="Action"/>
 *     &lt;enumeration value="Event"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_smmActivityCategory")
@XmlEnum
public enum AxdEnumSmmActivityCategory {

    @XmlEnumValue("Appointment")
    APPOINTMENT("Appointment"),
    @XmlEnumValue("Task")
    TASK("Task"),
    @XmlEnumValue("Action")
    ACTION("Action"),
    @XmlEnumValue("Event")
    EVENT("Event");
    private final String value;

    AxdEnumSmmActivityCategory(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumSmmActivityCategory fromValue(String v) {
        for (AxdEnumSmmActivityCategory c: AxdEnumSmmActivityCategory.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
