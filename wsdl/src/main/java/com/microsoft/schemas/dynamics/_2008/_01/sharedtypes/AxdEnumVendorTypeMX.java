
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_VendorType_MX.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_VendorType_MX">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Blank"/>
 *     &lt;enumeration value="DomesticVendor"/>
 *     &lt;enumeration value="ForeignVendor"/>
 *     &lt;enumeration value="DomesticGlobal"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_VendorType_MX")
@XmlEnum
public enum AxdEnumVendorTypeMX {

    @XmlEnumValue("Blank")
    BLANK("Blank"),
    @XmlEnumValue("DomesticVendor")
    DOMESTIC_VENDOR("DomesticVendor"),
    @XmlEnumValue("ForeignVendor")
    FOREIGN_VENDOR("ForeignVendor"),
    @XmlEnumValue("DomesticGlobal")
    DOMESTIC_GLOBAL("DomesticGlobal");
    private final String value;

    AxdEnumVendorTypeMX(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumVendorTypeMX fromValue(String v) {
        for (AxdEnumVendorTypeMX c: AxdEnumVendorTypeMX.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
