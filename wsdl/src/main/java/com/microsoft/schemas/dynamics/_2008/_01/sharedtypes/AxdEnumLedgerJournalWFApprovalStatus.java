
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_LedgerJournalWFApprovalStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_LedgerJournalWFApprovalStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="NotSubmitted"/>
 *     &lt;enumeration value="Submitted"/>
 *     &lt;enumeration value="PendingApproval"/>
 *     &lt;enumeration value="ChangeRequested"/>
 *     &lt;enumeration value="Approved"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_LedgerJournalWFApprovalStatus")
@XmlEnum
public enum AxdEnumLedgerJournalWFApprovalStatus {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("NotSubmitted")
    NOT_SUBMITTED("NotSubmitted"),
    @XmlEnumValue("Submitted")
    SUBMITTED("Submitted"),
    @XmlEnumValue("PendingApproval")
    PENDING_APPROVAL("PendingApproval"),
    @XmlEnumValue("ChangeRequested")
    CHANGE_REQUESTED("ChangeRequested"),
    @XmlEnumValue("Approved")
    APPROVED("Approved");
    private final String value;

    AxdEnumLedgerJournalWFApprovalStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumLedgerJournalWFApprovalStatus fromValue(String v) {
        for (AxdEnumLedgerJournalWFApprovalStatus c: AxdEnumLedgerJournalWFApprovalStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
