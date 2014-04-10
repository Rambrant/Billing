
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_FreightSlipType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_FreightSlipType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="UPS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_FreightSlipType")
@XmlEnum
public enum AxdEnumFreightSlipType {

    @XmlEnumValue("None")
    NONE("None"),
    UPS("UPS");
    private final String value;

    AxdEnumFreightSlipType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumFreightSlipType fromValue(String v) {
        for (AxdEnumFreightSlipType c: AxdEnumFreightSlipType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
