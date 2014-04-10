
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_TaxRoundOffType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_TaxRoundOffType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Ordinary"/>
 *     &lt;enumeration value="RoundDown"/>
 *     &lt;enumeration value="RoundUp"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_TaxRoundOffType")
@XmlEnum
public enum AxdExtTypeTaxRoundOffType {

    @XmlEnumValue("Ordinary")
    ORDINARY("Ordinary"),
    @XmlEnumValue("RoundDown")
    ROUND_DOWN("RoundDown"),
    @XmlEnumValue("RoundUp")
    ROUND_UP("RoundUp");
    private final String value;

    AxdExtTypeTaxRoundOffType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypeTaxRoundOffType fromValue(String v) {
        for (AxdExtTypeTaxRoundOffType c: AxdExtTypeTaxRoundOffType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
