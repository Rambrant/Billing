
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_EUSalesListReportingPeriodType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_EUSalesListReportingPeriodType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NotSelected"/>
 *     &lt;enumeration value="Monthly"/>
 *     &lt;enumeration value="BiMonthly"/>
 *     &lt;enumeration value="Quarterly"/>
 *     &lt;enumeration value="Yearly"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_EUSalesListReportingPeriodType")
@XmlEnum
public enum AxdEnumEUSalesListReportingPeriodType {

    @XmlEnumValue("NotSelected")
    NOT_SELECTED("NotSelected"),
    @XmlEnumValue("Monthly")
    MONTHLY("Monthly"),
    @XmlEnumValue("BiMonthly")
    BI_MONTHLY("BiMonthly"),
    @XmlEnumValue("Quarterly")
    QUARTERLY("Quarterly"),
    @XmlEnumValue("Yearly")
    YEARLY("Yearly");
    private final String value;

    AxdEnumEUSalesListReportingPeriodType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumEUSalesListReportingPeriodType fromValue(String v) {
        for (AxdEnumEUSalesListReportingPeriodType c: AxdEnumEUSalesListReportingPeriodType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
