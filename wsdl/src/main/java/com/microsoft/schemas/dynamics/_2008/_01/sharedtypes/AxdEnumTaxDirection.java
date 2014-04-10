
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_TaxDirection.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_TaxDirection">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IncomingTax"/>
 *     &lt;enumeration value="OutgoingTax"/>
 *     &lt;enumeration value="UseTax"/>
 *     &lt;enumeration value="TaxExemptPurchase"/>
 *     &lt;enumeration value="TaxExemptSales"/>
 *     &lt;enumeration value="TaxTransaction"/>
 *     &lt;enumeration value="MajorExporterScheme_SG"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_TaxDirection")
@XmlEnum
public enum AxdEnumTaxDirection {

    @XmlEnumValue("IncomingTax")
    INCOMING_TAX("IncomingTax"),
    @XmlEnumValue("OutgoingTax")
    OUTGOING_TAX("OutgoingTax"),
    @XmlEnumValue("UseTax")
    USE_TAX("UseTax"),
    @XmlEnumValue("TaxExemptPurchase")
    TAX_EXEMPT_PURCHASE("TaxExemptPurchase"),
    @XmlEnumValue("TaxExemptSales")
    TAX_EXEMPT_SALES("TaxExemptSales"),
    @XmlEnumValue("TaxTransaction")
    TAX_TRANSACTION("TaxTransaction"),
    @XmlEnumValue("MajorExporterScheme_SG")
    MAJOR_EXPORTER_SCHEME_SG("MajorExporterScheme_SG");
    private final String value;

    AxdEnumTaxDirection(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumTaxDirection fromValue(String v) {
        for (AxdEnumTaxDirection c: AxdEnumTaxDirection.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
