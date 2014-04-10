
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_PurchInvoiceLineType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_PurchInvoiceLineType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Standard"/>
 *     &lt;enumeration value="Advance"/>
 *     &lt;enumeration value="AdvanceApplication"/>
 *     &lt;enumeration value="ReverseAdvanceApplication"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_PurchInvoiceLineType")
@XmlEnum
public enum AxdEnumPurchInvoiceLineType {

    @XmlEnumValue("Standard")
    STANDARD("Standard"),
    @XmlEnumValue("Advance")
    ADVANCE("Advance"),
    @XmlEnumValue("AdvanceApplication")
    ADVANCE_APPLICATION("AdvanceApplication"),
    @XmlEnumValue("ReverseAdvanceApplication")
    REVERSE_ADVANCE_APPLICATION("ReverseAdvanceApplication");
    private final String value;

    AxdEnumPurchInvoiceLineType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumPurchInvoiceLineType fromValue(String v) {
        for (AxdEnumPurchInvoiceLineType c: AxdEnumPurchInvoiceLineType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
