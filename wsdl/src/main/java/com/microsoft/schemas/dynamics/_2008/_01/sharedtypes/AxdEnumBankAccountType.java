
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_BankAccountType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_BankAccountType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CheckingAccount"/>
 *     &lt;enumeration value="SavingsAccount"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_BankAccountType")
@XmlEnum
public enum AxdEnumBankAccountType {

    @XmlEnumValue("CheckingAccount")
    CHECKING_ACCOUNT("CheckingAccount"),
    @XmlEnumValue("SavingsAccount")
    SAVINGS_ACCOUNT("SavingsAccount");
    private final String value;

    AxdEnumBankAccountType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumBankAccountType fromValue(String v) {
        for (AxdEnumBankAccountType c: AxdEnumBankAccountType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
