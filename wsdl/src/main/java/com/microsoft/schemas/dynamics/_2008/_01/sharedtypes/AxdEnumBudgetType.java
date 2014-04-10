
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_BudgetType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_BudgetType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Expense"/>
 *     &lt;enumeration value="Revenue"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_BudgetType")
@XmlEnum
public enum AxdEnumBudgetType {

    @XmlEnumValue("Expense")
    EXPENSE("Expense"),
    @XmlEnumValue("Revenue")
    REVENUE("Revenue");
    private final String value;

    AxdEnumBudgetType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumBudgetType fromValue(String v) {
        for (AxdEnumBudgetType c: AxdEnumBudgetType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
