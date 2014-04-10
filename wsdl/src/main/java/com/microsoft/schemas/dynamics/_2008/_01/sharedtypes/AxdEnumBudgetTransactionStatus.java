
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_BudgetTransactionStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_BudgetTransactionStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Draft"/>
 *     &lt;enumeration value="Completed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_BudgetTransactionStatus")
@XmlEnum
public enum AxdEnumBudgetTransactionStatus {

    @XmlEnumValue("Draft")
    DRAFT("Draft"),
    @XmlEnumValue("Completed")
    COMPLETED("Completed");
    private final String value;

    AxdEnumBudgetTransactionStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumBudgetTransactionStatus fromValue(String v) {
        for (AxdEnumBudgetTransactionStatus c: AxdEnumBudgetTransactionStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
