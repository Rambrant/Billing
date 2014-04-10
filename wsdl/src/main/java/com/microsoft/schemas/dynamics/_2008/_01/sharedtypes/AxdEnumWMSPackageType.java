
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_WMSPackageType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_WMSPackageType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Carton"/>
 *     &lt;enumeration value="Pallet"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_WMSPackageType")
@XmlEnum
public enum AxdEnumWMSPackageType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Carton")
    CARTON("Carton"),
    @XmlEnumValue("Pallet")
    PALLET("Pallet");
    private final String value;

    AxdEnumWMSPackageType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumWMSPackageType fromValue(String v) {
        for (AxdEnumWMSPackageType c: AxdEnumWMSPackageType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
