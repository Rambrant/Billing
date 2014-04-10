
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_BankDocumentType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_BankDocumentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="LetterOfCredit"/>
 *     &lt;enumeration value="ImportCollection"/>
 *     &lt;enumeration value="LetterOfGuarantee"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_BankDocumentType")
@XmlEnum
public enum AxdEnumBankDocumentType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("LetterOfCredit")
    LETTER_OF_CREDIT("LetterOfCredit"),
    @XmlEnumValue("ImportCollection")
    IMPORT_COLLECTION("ImportCollection"),
    @XmlEnumValue("LetterOfGuarantee")
    LETTER_OF_GUARANTEE("LetterOfGuarantee");
    private final String value;

    AxdEnumBankDocumentType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumBankDocumentType fromValue(String v) {
        for (AxdEnumBankDocumentType c: AxdEnumBankDocumentType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
