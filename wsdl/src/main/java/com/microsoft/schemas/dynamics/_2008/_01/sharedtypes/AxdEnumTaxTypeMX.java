
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_TaxType_MX.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_TaxType_MX">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Blank"/>
 *     &lt;enumeration value="ISR"/>
 *     &lt;enumeration value="IVA"/>
 *     &lt;enumeration value="IEPS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_TaxType_MX")
@XmlEnum
public enum AxdEnumTaxTypeMX {

    @XmlEnumValue("Blank")
    BLANK("Blank"),
    ISR("ISR"),
    IVA("IVA"),
    IEPS("IEPS");
    private final String value;

    AxdEnumTaxTypeMX(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumTaxTypeMX fromValue(String v) {
        for (AxdEnumTaxTypeMX c: AxdEnumTaxTypeMX.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
