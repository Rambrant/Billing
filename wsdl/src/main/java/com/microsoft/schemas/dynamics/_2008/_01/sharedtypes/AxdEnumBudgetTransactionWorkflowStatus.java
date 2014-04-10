
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_BudgetTransactionWorkflowStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_BudgetTransactionWorkflowStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="NotSubmitted"/>
 *     &lt;enumeration value="Submitted"/>
 *     &lt;enumeration value="Approved"/>
 *     &lt;enumeration value="Rejected"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_BudgetTransactionWorkflowStatus")
@XmlEnum
public enum AxdEnumBudgetTransactionWorkflowStatus {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("NotSubmitted")
    NOT_SUBMITTED("NotSubmitted"),
    @XmlEnumValue("Submitted")
    SUBMITTED("Submitted"),
    @XmlEnumValue("Approved")
    APPROVED("Approved"),
    @XmlEnumValue("Rejected")
    REJECTED("Rejected");
    private final String value;

    AxdEnumBudgetTransactionWorkflowStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumBudgetTransactionWorkflowStatus fromValue(String v) {
        for (AxdEnumBudgetTransactionWorkflowStatus c: AxdEnumBudgetTransactionWorkflowStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
