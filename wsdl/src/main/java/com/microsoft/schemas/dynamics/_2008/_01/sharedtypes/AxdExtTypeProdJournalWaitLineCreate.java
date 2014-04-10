
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_ProdJournalWaitLineCreate.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_ProdJournalWaitLineCreate">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="No"/>
 *     &lt;enumeration value="Yes"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_ProdJournalWaitLineCreate")
@XmlEnum
public enum AxdExtTypeProdJournalWaitLineCreate {

    @XmlEnumValue("No")
    NO("No"),
    @XmlEnumValue("Yes")
    YES("Yes");
    private final String value;

    AxdExtTypeProdJournalWaitLineCreate(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypeProdJournalWaitLineCreate fromValue(String v) {
        for (AxdExtTypeProdJournalWaitLineCreate c: AxdExtTypeProdJournalWaitLineCreate.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
