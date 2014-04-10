
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_TaxPrintDetail.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_TaxPrintDetail">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TaxCode"/>
 *     &lt;enumeration value="TaxGroup"/>
 *     &lt;enumeration value="NoDetail"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_TaxPrintDetail")
@XmlEnum
public enum AxdEnumTaxPrintDetail {

    @XmlEnumValue("TaxCode")
    TAX_CODE("TaxCode"),
    @XmlEnumValue("TaxGroup")
    TAX_GROUP("TaxGroup"),
    @XmlEnumValue("NoDetail")
    NO_DETAIL("NoDetail");
    private final String value;

    AxdEnumTaxPrintDetail(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumTaxPrintDetail fromValue(String v) {
        for (AxdEnumTaxPrintDetail c: AxdEnumTaxPrintDetail.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
