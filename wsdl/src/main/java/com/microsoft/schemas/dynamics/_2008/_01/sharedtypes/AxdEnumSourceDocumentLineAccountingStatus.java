
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_SourceDocumentLineAccountingStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_SourceDocumentLineAccountingStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Completed"/>
 *     &lt;enumeration value="Draft"/>
 *     &lt;enumeration value="Canceled"/>
 *     &lt;enumeration value="PartlyDistributed"/>
 *     &lt;enumeration value="Finalized"/>
 *     &lt;enumeration value="FullyDistributed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_SourceDocumentLineAccountingStatus")
@XmlEnum
public enum AxdEnumSourceDocumentLineAccountingStatus {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Completed")
    COMPLETED("Completed"),
    @XmlEnumValue("Draft")
    DRAFT("Draft"),
    @XmlEnumValue("Canceled")
    CANCELED("Canceled"),
    @XmlEnumValue("PartlyDistributed")
    PARTLY_DISTRIBUTED("PartlyDistributed"),
    @XmlEnumValue("Finalized")
    FINALIZED("Finalized"),
    @XmlEnumValue("FullyDistributed")
    FULLY_DISTRIBUTED("FullyDistributed");
    private final String value;

    AxdEnumSourceDocumentLineAccountingStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumSourceDocumentLineAccountingStatus fromValue(String v) {
        for (AxdEnumSourceDocumentLineAccountingStatus c: AxdEnumSourceDocumentLineAccountingStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
