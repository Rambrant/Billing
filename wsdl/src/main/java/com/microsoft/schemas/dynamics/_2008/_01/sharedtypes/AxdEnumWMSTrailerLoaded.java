
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_WMSTrailerLoaded.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_WMSTrailerLoaded">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ByShipper"/>
 *     &lt;enumeration value="ByDriver"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_WMSTrailerLoaded")
@XmlEnum
public enum AxdEnumWMSTrailerLoaded {

    @XmlEnumValue("ByShipper")
    BY_SHIPPER("ByShipper"),
    @XmlEnumValue("ByDriver")
    BY_DRIVER("ByDriver");
    private final String value;

    AxdEnumWMSTrailerLoaded(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumWMSTrailerLoaded fromValue(String v) {
        for (AxdEnumWMSTrailerLoaded c: AxdEnumWMSTrailerLoaded.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
