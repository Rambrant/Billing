
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_VersioningDocumentState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_VersioningDocumentState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Draft"/>
 *     &lt;enumeration value="InReview"/>
 *     &lt;enumeration value="Rejected"/>
 *     &lt;enumeration value="Approved"/>
 *     &lt;enumeration value="Confirmed"/>
 *     &lt;enumeration value="Finalized"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_VersioningDocumentState")
@XmlEnum
public enum AxdEnumVersioningDocumentState {

    @XmlEnumValue("Draft")
    DRAFT("Draft"),
    @XmlEnumValue("InReview")
    IN_REVIEW("InReview"),
    @XmlEnumValue("Rejected")
    REJECTED("Rejected"),
    @XmlEnumValue("Approved")
    APPROVED("Approved"),
    @XmlEnumValue("Confirmed")
    CONFIRMED("Confirmed"),
    @XmlEnumValue("Finalized")
    FINALIZED("Finalized");
    private final String value;

    AxdEnumVersioningDocumentState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumVersioningDocumentState fromValue(String v) {
        for (AxdEnumVersioningDocumentState c: AxdEnumVersioningDocumentState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
