
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_LogisticsElectronicAddressMethodType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_LogisticsElectronicAddressMethodType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Phone"/>
 *     &lt;enumeration value="Email"/>
 *     &lt;enumeration value="URL"/>
 *     &lt;enumeration value="Telex"/>
 *     &lt;enumeration value="Fax"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_LogisticsElectronicAddressMethodType")
@XmlEnum
public enum AxdEnumLogisticsElectronicAddressMethodType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Phone")
    PHONE("Phone"),
    @XmlEnumValue("Email")
    EMAIL("Email"),
    URL("URL"),
    @XmlEnumValue("Telex")
    TELEX("Telex"),
    @XmlEnumValue("Fax")
    FAX("Fax");
    private final String value;

    AxdEnumLogisticsElectronicAddressMethodType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumLogisticsElectronicAddressMethodType fromValue(String v) {
        for (AxdEnumLogisticsElectronicAddressMethodType c: AxdEnumLogisticsElectronicAddressMethodType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
