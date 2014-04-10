
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_BankAccountHoldStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_BankAccountHoldStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ActiveForAllTransactions"/>
 *     &lt;enumeration value="InactiveForNewTransactions"/>
 *     &lt;enumeration value="InactiveForAllTransactions"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_BankAccountHoldStatus")
@XmlEnum
public enum AxdEnumBankAccountHoldStatus {

    @XmlEnumValue("ActiveForAllTransactions")
    ACTIVE_FOR_ALL_TRANSACTIONS("ActiveForAllTransactions"),
    @XmlEnumValue("InactiveForNewTransactions")
    INACTIVE_FOR_NEW_TRANSACTIONS("InactiveForNewTransactions"),
    @XmlEnumValue("InactiveForAllTransactions")
    INACTIVE_FOR_ALL_TRANSACTIONS("InactiveForAllTransactions");
    private final String value;

    AxdEnumBankAccountHoldStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumBankAccountHoldStatus fromValue(String v) {
        for (AxdEnumBankAccountHoldStatus c: AxdEnumBankAccountHoldStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
