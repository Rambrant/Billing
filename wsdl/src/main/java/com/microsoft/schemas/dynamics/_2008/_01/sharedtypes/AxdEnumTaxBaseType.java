
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_TaxBaseType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_TaxBaseType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PctPerNet"/>
 *     &lt;enumeration value="PctPerGross"/>
 *     &lt;enumeration value="PctPerTax"/>
 *     &lt;enumeration value="AmountByUnit"/>
 *     &lt;enumeration value="PctGrosOnNet"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_TaxBaseType")
@XmlEnum
public enum AxdEnumTaxBaseType {

    @XmlEnumValue("PctPerNet")
    PCT_PER_NET("PctPerNet"),
    @XmlEnumValue("PctPerGross")
    PCT_PER_GROSS("PctPerGross"),
    @XmlEnumValue("PctPerTax")
    PCT_PER_TAX("PctPerTax"),
    @XmlEnumValue("AmountByUnit")
    AMOUNT_BY_UNIT("AmountByUnit"),
    @XmlEnumValue("PctGrosOnNet")
    PCT_GROS_ON_NET("PctGrosOnNet");
    private final String value;

    AxdEnumTaxBaseType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumTaxBaseType fromValue(String v) {
        for (AxdEnumTaxBaseType c: AxdEnumTaxBaseType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
