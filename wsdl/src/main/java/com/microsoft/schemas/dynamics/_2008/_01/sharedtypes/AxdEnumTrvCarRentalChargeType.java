
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_TrvCarRentalChargeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_TrvCarRentalChargeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BaseRentalAmount"/>
 *     &lt;enumeration value="Insurance"/>
 *     &lt;enumeration value="Fuel"/>
 *     &lt;enumeration value="OneWayDropOff"/>
 *     &lt;enumeration value="Towing"/>
 *     &lt;enumeration value="ExtraMileage"/>
 *     &lt;enumeration value="LateReturn"/>
 *     &lt;enumeration value="Telephone"/>
 *     &lt;enumeration value="Other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_TrvCarRentalChargeType")
@XmlEnum
public enum AxdEnumTrvCarRentalChargeType {

    @XmlEnumValue("BaseRentalAmount")
    BASE_RENTAL_AMOUNT("BaseRentalAmount"),
    @XmlEnumValue("Insurance")
    INSURANCE("Insurance"),
    @XmlEnumValue("Fuel")
    FUEL("Fuel"),
    @XmlEnumValue("OneWayDropOff")
    ONE_WAY_DROP_OFF("OneWayDropOff"),
    @XmlEnumValue("Towing")
    TOWING("Towing"),
    @XmlEnumValue("ExtraMileage")
    EXTRA_MILEAGE("ExtraMileage"),
    @XmlEnumValue("LateReturn")
    LATE_RETURN("LateReturn"),
    @XmlEnumValue("Telephone")
    TELEPHONE("Telephone"),
    @XmlEnumValue("Other")
    OTHER("Other");
    private final String value;

    AxdEnumTrvCarRentalChargeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumTrvCarRentalChargeType fromValue(String v) {
        for (AxdEnumTrvCarRentalChargeType c: AxdEnumTrvCarRentalChargeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
