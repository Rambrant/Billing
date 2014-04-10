
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_InventJournalVoucherChange.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_InventJournalVoucherChange">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DateChange"/>
 *     &lt;enumeration value="DateItemChange"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_InventJournalVoucherChange")
@XmlEnum
public enum AxdEnumInventJournalVoucherChange {

    @XmlEnumValue("DateChange")
    DATE_CHANGE("DateChange"),
    @XmlEnumValue("DateItemChange")
    DATE_ITEM_CHANGE("DateItemChange");
    private final String value;

    AxdEnumInventJournalVoucherChange(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumInventJournalVoucherChange fromValue(String v) {
        for (AxdEnumInventJournalVoucherChange c: AxdEnumInventJournalVoucherChange.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
