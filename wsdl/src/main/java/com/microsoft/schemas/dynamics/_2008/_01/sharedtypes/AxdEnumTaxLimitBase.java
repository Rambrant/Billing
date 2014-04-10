
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_TaxLimitBase.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_TaxLimitBase">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="LineWithoutVAT"/>
 *     &lt;enumeration value="UnitWithoutVAT"/>
 *     &lt;enumeration value="InvoiceWithoutVAT"/>
 *     &lt;enumeration value="LineInclVAT"/>
 *     &lt;enumeration value="UnitInclVAT"/>
 *     &lt;enumeration value="InvoiceInclVAT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_TaxLimitBase")
@XmlEnum
public enum AxdEnumTaxLimitBase {

    @XmlEnumValue("LineWithoutVAT")
    LINE_WITHOUT_VAT("LineWithoutVAT"),
    @XmlEnumValue("UnitWithoutVAT")
    UNIT_WITHOUT_VAT("UnitWithoutVAT"),
    @XmlEnumValue("InvoiceWithoutVAT")
    INVOICE_WITHOUT_VAT("InvoiceWithoutVAT"),
    @XmlEnumValue("LineInclVAT")
    LINE_INCL_VAT("LineInclVAT"),
    @XmlEnumValue("UnitInclVAT")
    UNIT_INCL_VAT("UnitInclVAT"),
    @XmlEnumValue("InvoiceInclVAT")
    INVOICE_INCL_VAT("InvoiceInclVAT");
    private final String value;

    AxdEnumTaxLimitBase(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumTaxLimitBase fromValue(String v) {
        for (AxdEnumTaxLimitBase c: AxdEnumTaxLimitBase.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
