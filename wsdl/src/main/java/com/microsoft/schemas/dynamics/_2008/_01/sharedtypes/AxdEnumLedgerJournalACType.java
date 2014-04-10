
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_LedgerJournalACType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_LedgerJournalACType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Ledger"/>
 *     &lt;enumeration value="Cust"/>
 *     &lt;enumeration value="Vend"/>
 *     &lt;enumeration value="Project"/>
 *     &lt;enumeration value="FixedAssets"/>
 *     &lt;enumeration value="Bank"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_LedgerJournalACType")
@XmlEnum
public enum AxdEnumLedgerJournalACType {

    @XmlEnumValue("Ledger")
    LEDGER("Ledger"),
    @XmlEnumValue("Cust")
    CUST("Cust"),
    @XmlEnumValue("Vend")
    VEND("Vend"),
    @XmlEnumValue("Project")
    PROJECT("Project"),
    @XmlEnumValue("FixedAssets")
    FIXED_ASSETS("FixedAssets"),
    @XmlEnumValue("Bank")
    BANK("Bank");
    private final String value;

    AxdEnumLedgerJournalACType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumLedgerJournalACType fromValue(String v) {
        for (AxdEnumLedgerJournalACType c: AxdEnumLedgerJournalACType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
