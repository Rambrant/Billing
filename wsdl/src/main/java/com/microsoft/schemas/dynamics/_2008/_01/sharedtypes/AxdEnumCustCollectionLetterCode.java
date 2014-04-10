
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_CustCollectionLetterCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_CustCollectionLetterCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="CollectionLetter1"/>
 *     &lt;enumeration value="CollectionLetter2"/>
 *     &lt;enumeration value="CollectionLetter3"/>
 *     &lt;enumeration value="CollectionLetter4"/>
 *     &lt;enumeration value="Collection"/>
 *     &lt;enumeration value="All"/>
 *     &lt;enumeration value="CollectionPerCust"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_CustCollectionLetterCode")
@XmlEnum
public enum AxdEnumCustCollectionLetterCode {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("CollectionLetter1")
    COLLECTION_LETTER_1("CollectionLetter1"),
    @XmlEnumValue("CollectionLetter2")
    COLLECTION_LETTER_2("CollectionLetter2"),
    @XmlEnumValue("CollectionLetter3")
    COLLECTION_LETTER_3("CollectionLetter3"),
    @XmlEnumValue("CollectionLetter4")
    COLLECTION_LETTER_4("CollectionLetter4"),
    @XmlEnumValue("Collection")
    COLLECTION("Collection"),
    @XmlEnumValue("All")
    ALL("All"),
    @XmlEnumValue("CollectionPerCust")
    COLLECTION_PER_CUST("CollectionPerCust");
    private final String value;

    AxdEnumCustCollectionLetterCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumCustCollectionLetterCode fromValue(String v) {
        for (AxdEnumCustCollectionLetterCode c: AxdEnumCustCollectionLetterCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
