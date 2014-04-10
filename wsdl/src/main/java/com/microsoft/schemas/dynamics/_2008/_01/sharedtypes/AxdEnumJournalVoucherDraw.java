
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_JournalVoucherDraw.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_JournalVoucherDraw">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Entering"/>
 *     &lt;enumeration value="Post"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_JournalVoucherDraw")
@XmlEnum
public enum AxdEnumJournalVoucherDraw {

    @XmlEnumValue("Entering")
    ENTERING("Entering"),
    @XmlEnumValue("Post")
    POST("Post");
    private final String value;

    AxdEnumJournalVoucherDraw(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumJournalVoucherDraw fromValue(String v) {
        for (AxdEnumJournalVoucherDraw c: AxdEnumJournalVoucherDraw.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
