
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_PurchReqRequisitionStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_PurchReqRequisitionStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Draft"/>
 *     &lt;enumeration value="InReview"/>
 *     &lt;enumeration value="Rejected"/>
 *     &lt;enumeration value="Approved"/>
 *     &lt;enumeration value="Cancelled"/>
 *     &lt;enumeration value="Closed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_PurchReqRequisitionStatus")
@XmlEnum
public enum AxdEnumPurchReqRequisitionStatus {

    @XmlEnumValue("Draft")
    DRAFT("Draft"),
    @XmlEnumValue("InReview")
    IN_REVIEW("InReview"),
    @XmlEnumValue("Rejected")
    REJECTED("Rejected"),
    @XmlEnumValue("Approved")
    APPROVED("Approved"),
    @XmlEnumValue("Cancelled")
    CANCELLED("Cancelled"),
    @XmlEnumValue("Closed")
    CLOSED("Closed");
    private final String value;

    AxdEnumPurchReqRequisitionStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumPurchReqRequisitionStatus fromValue(String v) {
        for (AxdEnumPurchReqRequisitionStatus c: AxdEnumPurchReqRequisitionStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
