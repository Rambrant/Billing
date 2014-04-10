
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_CustFreeInvoiceWFApprovalStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_CustFreeInvoiceWFApprovalStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Draft"/>
 *     &lt;enumeration value="Submitted"/>
 *     &lt;enumeration value="PendingApproval"/>
 *     &lt;enumeration value="Approved"/>
 *     &lt;enumeration value="Rejected"/>
 *     &lt;enumeration value="ChangeRequested"/>
 *     &lt;enumeration value="Pending"/>
 *     &lt;enumeration value="Cancellation"/>
 *     &lt;enumeration value="NotSubmitted"/>
 *     &lt;enumeration value="PendingCompletion"/>
 *     &lt;enumeration value="Completed"/>
 *     &lt;enumeration value="PendingCancellation"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_CustFreeInvoiceWFApprovalStatus")
@XmlEnum
public enum AxdEnumCustFreeInvoiceWFApprovalStatus {

    @XmlEnumValue("Draft")
    DRAFT("Draft"),
    @XmlEnumValue("Submitted")
    SUBMITTED("Submitted"),
    @XmlEnumValue("PendingApproval")
    PENDING_APPROVAL("PendingApproval"),
    @XmlEnumValue("Approved")
    APPROVED("Approved"),
    @XmlEnumValue("Rejected")
    REJECTED("Rejected"),
    @XmlEnumValue("ChangeRequested")
    CHANGE_REQUESTED("ChangeRequested"),
    @XmlEnumValue("Pending")
    PENDING("Pending"),
    @XmlEnumValue("Cancellation")
    CANCELLATION("Cancellation"),
    @XmlEnumValue("NotSubmitted")
    NOT_SUBMITTED("NotSubmitted"),
    @XmlEnumValue("PendingCompletion")
    PENDING_COMPLETION("PendingCompletion"),
    @XmlEnumValue("Completed")
    COMPLETED("Completed"),
    @XmlEnumValue("PendingCancellation")
    PENDING_CANCELLATION("PendingCancellation");
    private final String value;

    AxdEnumCustFreeInvoiceWFApprovalStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumCustFreeInvoiceWFApprovalStatus fromValue(String v) {
        for (AxdEnumCustFreeInvoiceWFApprovalStatus c: AxdEnumCustFreeInvoiceWFApprovalStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
