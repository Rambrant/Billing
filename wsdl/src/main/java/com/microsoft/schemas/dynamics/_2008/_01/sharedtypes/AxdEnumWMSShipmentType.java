
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_WMSShipmentType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_WMSShipmentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ConsolidatedPick"/>
 *     &lt;enumeration value="OrderPick"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_WMSShipmentType")
@XmlEnum
public enum AxdEnumWMSShipmentType {

    @XmlEnumValue("ConsolidatedPick")
    CONSOLIDATED_PICK("ConsolidatedPick"),
    @XmlEnumValue("OrderPick")
    ORDER_PICK("OrderPick");
    private final String value;

    AxdEnumWMSShipmentType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumWMSShipmentType fromValue(String v) {
        for (AxdEnumWMSShipmentType c: AxdEnumWMSShipmentType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
