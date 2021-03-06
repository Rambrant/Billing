
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_TrvAirlineServiceClass.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_TrvAirlineServiceClass">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="EconomyClass"/>
 *     &lt;enumeration value="FrstClass"/>
 *     &lt;enumeration value="BusinessClass"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_TrvAirlineServiceClass")
@XmlEnum
public enum AxdExtTypeTrvAirlineServiceClass {

    @XmlEnumValue("EconomyClass")
    ECONOMY_CLASS("EconomyClass"),
    @XmlEnumValue("FrstClass")
    FRST_CLASS("FrstClass"),
    @XmlEnumValue("BusinessClass")
    BUSINESS_CLASS("BusinessClass");
    private final String value;

    AxdExtTypeTrvAirlineServiceClass(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypeTrvAirlineServiceClass fromValue(String v) {
        for (AxdExtTypeTrvAirlineServiceClass c: AxdExtTypeTrvAirlineServiceClass.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
