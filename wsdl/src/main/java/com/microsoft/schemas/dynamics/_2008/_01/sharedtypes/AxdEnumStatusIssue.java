
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_StatusIssue.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_StatusIssue">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Sold"/>
 *     &lt;enumeration value="Deducted"/>
 *     &lt;enumeration value="Picked"/>
 *     &lt;enumeration value="ReservPhysical"/>
 *     &lt;enumeration value="ReservOrdered"/>
 *     &lt;enumeration value="OnOrder"/>
 *     &lt;enumeration value="QuotationIssue"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_StatusIssue")
@XmlEnum
public enum AxdEnumStatusIssue {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Sold")
    SOLD("Sold"),
    @XmlEnumValue("Deducted")
    DEDUCTED("Deducted"),
    @XmlEnumValue("Picked")
    PICKED("Picked"),
    @XmlEnumValue("ReservPhysical")
    RESERV_PHYSICAL("ReservPhysical"),
    @XmlEnumValue("ReservOrdered")
    RESERV_ORDERED("ReservOrdered"),
    @XmlEnumValue("OnOrder")
    ON_ORDER("OnOrder"),
    @XmlEnumValue("QuotationIssue")
    QUOTATION_ISSUE("QuotationIssue");
    private final String value;

    AxdEnumStatusIssue(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumStatusIssue fromValue(String v) {
        for (AxdEnumStatusIssue c: AxdEnumStatusIssue.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
