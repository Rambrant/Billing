
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_ProdJournalVoucherChange.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_ProdJournalVoucherChange">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DateProdChange"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_ProdJournalVoucherChange")
@XmlEnum
public enum AxdEnumProdJournalVoucherChange {

    @XmlEnumValue("DateProdChange")
    DATE_PROD_CHANGE("DateProdChange");
    private final String value;

    AxdEnumProdJournalVoucherChange(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumProdJournalVoucherChange fromValue(String v) {
        for (AxdEnumProdJournalVoucherChange c: AxdEnumProdJournalVoucherChange.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
