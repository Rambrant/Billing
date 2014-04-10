
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_TrvAirlineChargeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_TrvAirlineChargeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TotalFare"/>
 *     &lt;enumeration value="TotalFee"/>
 *     &lt;enumeration value="TotalTaxAmount"/>
 *     &lt;enumeration value="Other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_TrvAirlineChargeType")
@XmlEnum
public enum AxdEnumTrvAirlineChargeType {

    @XmlEnumValue("TotalFare")
    TOTAL_FARE("TotalFare"),
    @XmlEnumValue("TotalFee")
    TOTAL_FEE("TotalFee"),
    @XmlEnumValue("TotalTaxAmount")
    TOTAL_TAX_AMOUNT("TotalTaxAmount"),
    @XmlEnumValue("Other")
    OTHER("Other");
    private final String value;

    AxdEnumTrvAirlineChargeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumTrvAirlineChargeType fromValue(String v) {
        for (AxdEnumTrvAirlineChargeType c: AxdEnumTrvAirlineChargeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
