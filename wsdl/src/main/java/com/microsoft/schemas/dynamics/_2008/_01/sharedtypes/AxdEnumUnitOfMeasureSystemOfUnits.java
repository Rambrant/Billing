
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_UnitOfMeasureSystemOfUnits.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_UnitOfMeasureSystemOfUnits">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Metric"/>
 *     &lt;enumeration value="US"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_UnitOfMeasureSystemOfUnits")
@XmlEnum
public enum AxdEnumUnitOfMeasureSystemOfUnits {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Metric")
    METRIC("Metric"),
    US("US");
    private final String value;

    AxdEnumUnitOfMeasureSystemOfUnits(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumUnitOfMeasureSystemOfUnits fromValue(String v) {
        for (AxdEnumUnitOfMeasureSystemOfUnits c: AxdEnumUnitOfMeasureSystemOfUnits.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
