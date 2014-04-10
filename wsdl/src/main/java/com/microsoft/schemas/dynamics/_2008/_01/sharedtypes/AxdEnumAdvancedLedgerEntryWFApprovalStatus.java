
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_AdvancedLedgerEntryWFApprovalStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_AdvancedLedgerEntryWFApprovalStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Draft"/>
 *     &lt;enumeration value="Submitted"/>
 *     &lt;enumeration value="Approved"/>
 *     &lt;enumeration value="Rejected"/>
 *     &lt;enumeration value="ChangeRequested"/>
 *     &lt;enumeration value="Denied"/>
 *     &lt;enumeration value="Cancellation"/>
 *     &lt;enumeration value="NotSubmitted"/>
 *     &lt;enumeration value="PendingCompletion"/>
 *     &lt;enumeration value="Completed"/>
 *     &lt;enumeration value="PendingCancellation"/>
 *     &lt;enumeration value="PendingApproval"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_AdvancedLedgerEntryWFApprovalStatus")
@XmlEnum
public enum AxdEnumAdvancedLedgerEntryWFApprovalStatus {

    @XmlEnumValue("Draft")
    DRAFT("Draft"),
    @XmlEnumValue("Submitted")
    SUBMITTED("Submitted"),
    @XmlEnumValue("Approved")
    APPROVED("Approved"),
    @XmlEnumValue("Rejected")
    REJECTED("Rejected"),
    @XmlEnumValue("ChangeRequested")
    CHANGE_REQUESTED("ChangeRequested"),
    @XmlEnumValue("Denied")
    DENIED("Denied"),
    @XmlEnumValue("Cancellation")
    CANCELLATION("Cancellation"),
    @XmlEnumValue("NotSubmitted")
    NOT_SUBMITTED("NotSubmitted"),
    @XmlEnumValue("PendingCompletion")
    PENDING_COMPLETION("PendingCompletion"),
    @XmlEnumValue("Completed")
    COMPLETED("Completed"),
    @XmlEnumValue("PendingCancellation")
    PENDING_CANCELLATION("PendingCancellation"),
    @XmlEnumValue("PendingApproval")
    PENDING_APPROVAL("PendingApproval");
    private final String value;

    AxdEnumAdvancedLedgerEntryWFApprovalStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumAdvancedLedgerEntryWFApprovalStatus fromValue(String v) {
        for (AxdEnumAdvancedLedgerEntryWFApprovalStatus c: AxdEnumAdvancedLedgerEntryWFApprovalStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
