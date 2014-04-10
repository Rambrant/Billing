
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_TypeOfDraft.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_TypeOfDraft">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NoDraft"/>
 *     &lt;enumeration value="NoAcceptance"/>
 *     &lt;enumeration value="Acceptance"/>
 *     &lt;enumeration value="Promissory"/>
 *     &lt;enumeration value="BankAcceptance"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_TypeOfDraft")
@XmlEnum
public enum AxdEnumTypeOfDraft {

    @XmlEnumValue("NoDraft")
    NO_DRAFT("NoDraft"),
    @XmlEnumValue("NoAcceptance")
    NO_ACCEPTANCE("NoAcceptance"),
    @XmlEnumValue("Acceptance")
    ACCEPTANCE("Acceptance"),
    @XmlEnumValue("Promissory")
    PROMISSORY("Promissory"),
    @XmlEnumValue("BankAcceptance")
    BANK_ACCEPTANCE("BankAcceptance");
    private final String value;

    AxdEnumTypeOfDraft(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumTypeOfDraft fromValue(String v) {
        for (AxdEnumTypeOfDraft c: AxdEnumTypeOfDraft.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
