
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_RoundOffType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_RoundOffType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Ordinary"/>
 *     &lt;enumeration value="RoundDown"/>
 *     &lt;enumeration value="RoundUp"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_RoundOffType")
@XmlEnum
public enum AxdEnumRoundOffType {

    @XmlEnumValue("Ordinary")
    ORDINARY("Ordinary"),
    @XmlEnumValue("RoundDown")
    ROUND_DOWN("RoundDown"),
    @XmlEnumValue("RoundUp")
    ROUND_UP("RoundUp");
    private final String value;

    AxdEnumRoundOffType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumRoundOffType fromValue(String v) {
        for (AxdEnumRoundOffType c: AxdEnumRoundOffType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
