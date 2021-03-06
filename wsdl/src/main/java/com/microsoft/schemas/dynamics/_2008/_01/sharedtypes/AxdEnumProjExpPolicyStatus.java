
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_ProjExpPolicyStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_ProjExpPolicyStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NoPolicy"/>
 *     &lt;enumeration value="ExpensePassed"/>
 *     &lt;enumeration value="DayPassed"/>
 *     &lt;enumeration value="ReportPassed"/>
 *     &lt;enumeration value="ExpenseWarning"/>
 *     &lt;enumeration value="DayWarning"/>
 *     &lt;enumeration value="ReportWarning"/>
 *     &lt;enumeration value="ExpenseFailed"/>
 *     &lt;enumeration value="DayFailed"/>
 *     &lt;enumeration value="ReportFailed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_ProjExpPolicyStatus")
@XmlEnum
public enum AxdEnumProjExpPolicyStatus {

    @XmlEnumValue("NoPolicy")
    NO_POLICY("NoPolicy"),
    @XmlEnumValue("ExpensePassed")
    EXPENSE_PASSED("ExpensePassed"),
    @XmlEnumValue("DayPassed")
    DAY_PASSED("DayPassed"),
    @XmlEnumValue("ReportPassed")
    REPORT_PASSED("ReportPassed"),
    @XmlEnumValue("ExpenseWarning")
    EXPENSE_WARNING("ExpenseWarning"),
    @XmlEnumValue("DayWarning")
    DAY_WARNING("DayWarning"),
    @XmlEnumValue("ReportWarning")
    REPORT_WARNING("ReportWarning"),
    @XmlEnumValue("ExpenseFailed")
    EXPENSE_FAILED("ExpenseFailed"),
    @XmlEnumValue("DayFailed")
    DAY_FAILED("DayFailed"),
    @XmlEnumValue("ReportFailed")
    REPORT_FAILED("ReportFailed");
    private final String value;

    AxdEnumProjExpPolicyStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumProjExpPolicyStatus fromValue(String v) {
        for (AxdEnumProjExpPolicyStatus c: AxdEnumProjExpPolicyStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
