
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_BudgetTransactionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_BudgetTransactionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OriginalBudget"/>
 *     &lt;enumeration value="Transfer"/>
 *     &lt;enumeration value="Amendment"/>
 *     &lt;enumeration value="Encumbrance"/>
 *     &lt;enumeration value="PreEncumbrance"/>
 *     &lt;enumeration value="CarryForwardBudget"/>
 *     &lt;enumeration value="Project"/>
 *     &lt;enumeration value="FixedAsset"/>
 *     &lt;enumeration value="SalesForecast"/>
 *     &lt;enumeration value="PurchForecast"/>
 *     &lt;enumeration value="Apportionment"/>
 *     &lt;enumeration value="PreliminaryBudget"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_BudgetTransactionType")
@XmlEnum
public enum AxdEnumBudgetTransactionType {

    @XmlEnumValue("OriginalBudget")
    ORIGINAL_BUDGET("OriginalBudget"),
    @XmlEnumValue("Transfer")
    TRANSFER("Transfer"),
    @XmlEnumValue("Amendment")
    AMENDMENT("Amendment"),
    @XmlEnumValue("Encumbrance")
    ENCUMBRANCE("Encumbrance"),
    @XmlEnumValue("PreEncumbrance")
    PRE_ENCUMBRANCE("PreEncumbrance"),
    @XmlEnumValue("CarryForwardBudget")
    CARRY_FORWARD_BUDGET("CarryForwardBudget"),
    @XmlEnumValue("Project")
    PROJECT("Project"),
    @XmlEnumValue("FixedAsset")
    FIXED_ASSET("FixedAsset"),
    @XmlEnumValue("SalesForecast")
    SALES_FORECAST("SalesForecast"),
    @XmlEnumValue("PurchForecast")
    PURCH_FORECAST("PurchForecast"),
    @XmlEnumValue("Apportionment")
    APPORTIONMENT("Apportionment"),
    @XmlEnumValue("PreliminaryBudget")
    PRELIMINARY_BUDGET("PreliminaryBudget");
    private final String value;

    AxdEnumBudgetTransactionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumBudgetTransactionType fromValue(String v) {
        for (AxdEnumBudgetTransactionType c: AxdEnumBudgetTransactionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
