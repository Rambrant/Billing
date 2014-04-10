
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_AdvancedLedgerEntryTransactionStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_AdvancedLedgerEntryTransactionStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="All"/>
 *     &lt;enumeration value="Draft"/>
 *     &lt;enumeration value="Posted"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_AdvancedLedgerEntryTransactionStatus")
@XmlEnum
public enum AxdEnumAdvancedLedgerEntryTransactionStatus {

    @XmlEnumValue("All")
    ALL("All"),
    @XmlEnumValue("Draft")
    DRAFT("Draft"),
    @XmlEnumValue("Posted")
    POSTED("Posted");
    private final String value;

    AxdEnumAdvancedLedgerEntryTransactionStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumAdvancedLedgerEntryTransactionStatus fromValue(String v) {
        for (AxdEnumAdvancedLedgerEntryTransactionStatus c: AxdEnumAdvancedLedgerEntryTransactionStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
