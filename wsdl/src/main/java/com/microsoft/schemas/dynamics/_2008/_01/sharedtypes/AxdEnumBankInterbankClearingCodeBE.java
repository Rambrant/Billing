
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_BankInterbankClearingCode_BE.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_BankInterbankClearingCode_BE">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Normal"/>
 *     &lt;enumeration value="Urgent"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_BankInterbankClearingCode_BE")
@XmlEnum
public enum AxdEnumBankInterbankClearingCodeBE {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Normal")
    NORMAL("Normal"),
    @XmlEnumValue("Urgent")
    URGENT("Urgent");
    private final String value;

    AxdEnumBankInterbankClearingCodeBE(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumBankInterbankClearingCodeBE fromValue(String v) {
        for (AxdEnumBankInterbankClearingCodeBE c: AxdEnumBankInterbankClearingCodeBE.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
