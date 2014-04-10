
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_BankRemittanceType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_BankRemittanceType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Collection"/>
 *     &lt;enumeration value="Discount"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_BankRemittanceType")
@XmlEnum
public enum AxdEnumBankRemittanceType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Collection")
    COLLECTION("Collection"),
    @XmlEnumValue("Discount")
    DISCOUNT("Discount");
    private final String value;

    AxdEnumBankRemittanceType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumBankRemittanceType fromValue(String v) {
        for (AxdEnumBankRemittanceType c: AxdEnumBankRemittanceType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
