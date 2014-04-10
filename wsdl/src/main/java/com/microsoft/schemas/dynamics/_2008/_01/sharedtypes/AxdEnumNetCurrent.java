
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_NetCurrent.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_NetCurrent">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Net"/>
 *     &lt;enumeration value="CurrentMth"/>
 *     &lt;enumeration value="CurrentQuart"/>
 *     &lt;enumeration value="CurrentYear"/>
 *     &lt;enumeration value="CurrentWeek"/>
 *     &lt;enumeration value="COD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_NetCurrent")
@XmlEnum
public enum AxdEnumNetCurrent {

    @XmlEnumValue("Net")
    NET("Net"),
    @XmlEnumValue("CurrentMth")
    CURRENT_MTH("CurrentMth"),
    @XmlEnumValue("CurrentQuart")
    CURRENT_QUART("CurrentQuart"),
    @XmlEnumValue("CurrentYear")
    CURRENT_YEAR("CurrentYear"),
    @XmlEnumValue("CurrentWeek")
    CURRENT_WEEK("CurrentWeek"),
    COD("COD");
    private final String value;

    AxdEnumNetCurrent(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumNetCurrent fromValue(String v) {
        for (AxdEnumNetCurrent c: AxdEnumNetCurrent.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
