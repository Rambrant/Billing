
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_TypeOfAccount.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_TypeOfAccount">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BankAccountNumber"/>
 *     &lt;enumeration value="BankgiroNumber"/>
 *     &lt;enumeration value="PostgiroBankAccountNumber"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_TypeOfAccount")
@XmlEnum
public enum AxdEnumTypeOfAccount {

    @XmlEnumValue("BankAccountNumber")
    BANK_ACCOUNT_NUMBER("BankAccountNumber"),
    @XmlEnumValue("BankgiroNumber")
    BANKGIRO_NUMBER("BankgiroNumber"),
    @XmlEnumValue("PostgiroBankAccountNumber")
    POSTGIRO_BANK_ACCOUNT_NUMBER("PostgiroBankAccountNumber");
    private final String value;

    AxdEnumTypeOfAccount(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumTypeOfAccount fromValue(String v) {
        for (AxdEnumTypeOfAccount c: AxdEnumTypeOfAccount.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
