
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_BankDocumentFacilityNature.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_BankDocumentFacilityNature">
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
@XmlType(name = "AxdExtType_BankDocumentFacilityNature")
@XmlEnum
public enum AxdExtTypeBankDocumentFacilityNature {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("LetterOfCredit")
    LETTER_OF_CREDIT("LetterOfCredit"),
    @XmlEnumValue("ImportCollection")
    IMPORT_COLLECTION("ImportCollection"),
    @XmlEnumValue("LetterOfGuarantee")
    LETTER_OF_GUARANTEE("LetterOfGuarantee");
    private final String value;

    AxdExtTypeBankDocumentFacilityNature(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypeBankDocumentFacilityNature fromValue(String v) {
        for (AxdExtTypeBankDocumentFacilityNature c: AxdExtTypeBankDocumentFacilityNature.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
