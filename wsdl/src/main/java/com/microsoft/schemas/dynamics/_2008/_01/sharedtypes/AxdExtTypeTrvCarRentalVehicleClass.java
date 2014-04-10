
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_TrvCarRentalVehicleClass.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_TrvCarRentalVehicleClass">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Compact"/>
 *     &lt;enumeration value="Intermediate"/>
 *     &lt;enumeration value="Full"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_TrvCarRentalVehicleClass")
@XmlEnum
public enum AxdExtTypeTrvCarRentalVehicleClass {

    @XmlEnumValue("Compact")
    COMPACT("Compact"),
    @XmlEnumValue("Intermediate")
    INTERMEDIATE("Intermediate"),
    @XmlEnumValue("Full")
    FULL("Full");
    private final String value;

    AxdExtTypeTrvCarRentalVehicleClass(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypeTrvCarRentalVehicleClass fromValue(String v) {
        for (AxdExtTypeTrvCarRentalVehicleClass c: AxdExtTypeTrvCarRentalVehicleClass.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
