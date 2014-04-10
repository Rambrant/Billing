
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_ValidTimeStateUpdate.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_ValidTimeStateUpdate">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CreateNewTimePeriod"/>
 *     &lt;enumeration value="Correction"/>
 *     &lt;enumeration value="EffectiveBased"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_ValidTimeStateUpdate")
@XmlEnum
public enum AxdEnumValidTimeStateUpdate {

    @XmlEnumValue("CreateNewTimePeriod")
    CREATE_NEW_TIME_PERIOD("CreateNewTimePeriod"),
    @XmlEnumValue("Correction")
    CORRECTION("Correction"),
    @XmlEnumValue("EffectiveBased")
    EFFECTIVE_BASED("EffectiveBased");
    private final String value;

    AxdEnumValidTimeStateUpdate(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumValidTimeStateUpdate fromValue(String v) {
        for (AxdEnumValidTimeStateUpdate c: AxdEnumValidTimeStateUpdate.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
