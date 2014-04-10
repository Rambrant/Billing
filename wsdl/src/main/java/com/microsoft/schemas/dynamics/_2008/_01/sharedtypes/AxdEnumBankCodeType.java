
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_BankCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_BankCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Code_None"/>
 *     &lt;enumeration value="Code_AT"/>
 *     &lt;enumeration value="Code_BL"/>
 *     &lt;enumeration value="Code_CC"/>
 *     &lt;enumeration value="Code_CP"/>
 *     &lt;enumeration value="Code_CH"/>
 *     &lt;enumeration value="Code_FW"/>
 *     &lt;enumeration value="Code_SC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_BankCodeType")
@XmlEnum
public enum AxdEnumBankCodeType {

    @XmlEnumValue("Code_None")
    CODE_NONE("Code_None"),
    @XmlEnumValue("Code_AT")
    CODE_AT("Code_AT"),
    @XmlEnumValue("Code_BL")
    CODE_BL("Code_BL"),
    @XmlEnumValue("Code_CC")
    CODE_CC("Code_CC"),
    @XmlEnumValue("Code_CP")
    CODE_CP("Code_CP"),
    @XmlEnumValue("Code_CH")
    CODE_CH("Code_CH"),
    @XmlEnumValue("Code_FW")
    CODE_FW("Code_FW"),
    @XmlEnumValue("Code_SC")
    CODE_SC("Code_SC");
    private final String value;

    AxdEnumBankCodeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumBankCodeType fromValue(String v) {
        for (AxdEnumBankCodeType c: AxdEnumBankCodeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
