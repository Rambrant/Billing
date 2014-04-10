
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_TaxIDType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_TaxIDType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Unknown"/>
 *     &lt;enumeration value="EIN"/>
 *     &lt;enumeration value="SSN"/>
 *     &lt;enumeration value="ITIN"/>
 *     &lt;enumeration value="ATIN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_TaxIDType")
@XmlEnum
public enum AxdEnumTaxIDType {

    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown"),
    EIN("EIN"),
    SSN("SSN"),
    ITIN("ITIN"),
    ATIN("ATIN");
    private final String value;

    AxdEnumTaxIDType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumTaxIDType fromValue(String v) {
        for (AxdEnumTaxIDType c: AxdEnumTaxIDType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
