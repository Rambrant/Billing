
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_Tax1099NameChoice.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_Tax1099NameChoice">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="VendorName"/>
 *     &lt;enumeration value="DBA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_Tax1099NameChoice")
@XmlEnum
public enum AxdEnumTax1099NameChoice {

    @XmlEnumValue("VendorName")
    VENDOR_NAME("VendorName"),
    DBA("DBA");
    private final String value;

    AxdEnumTax1099NameChoice(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumTax1099NameChoice fromValue(String v) {
        for (AxdEnumTax1099NameChoice c: AxdEnumTax1099NameChoice.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
