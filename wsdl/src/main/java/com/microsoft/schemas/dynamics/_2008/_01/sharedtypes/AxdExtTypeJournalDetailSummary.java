
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_JournalDetailSummary.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_JournalDetailSummary">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Detail"/>
 *     &lt;enumeration value="Summary"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_JournalDetailSummary")
@XmlEnum
public enum AxdExtTypeJournalDetailSummary {

    @XmlEnumValue("Detail")
    DETAIL("Detail"),
    @XmlEnumValue("Summary")
    SUMMARY("Summary");
    private final String value;

    AxdExtTypeJournalDetailSummary(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypeJournalDetailSummary fromValue(String v) {
        for (AxdExtTypeJournalDetailSummary c: AxdExtTypeJournalDetailSummary.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
