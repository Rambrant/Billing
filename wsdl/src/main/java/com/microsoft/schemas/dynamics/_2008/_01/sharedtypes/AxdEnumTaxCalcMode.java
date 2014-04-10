
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_TaxCalcMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_TaxCalcMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FullAmounts"/>
 *     &lt;enumeration value="Interval"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_TaxCalcMode")
@XmlEnum
public enum AxdEnumTaxCalcMode {

    @XmlEnumValue("FullAmounts")
    FULL_AMOUNTS("FullAmounts"),
    @XmlEnumValue("Interval")
    INTERVAL("Interval");
    private final String value;

    AxdEnumTaxCalcMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumTaxCalcMode fromValue(String v) {
        for (AxdEnumTaxCalcMode c: AxdEnumTaxCalcMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
