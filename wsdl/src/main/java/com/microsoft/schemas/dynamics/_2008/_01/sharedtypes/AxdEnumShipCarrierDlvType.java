
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_ShipCarrierDlvType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_ShipCarrierDlvType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Misc"/>
 *     &lt;enumeration value="Ground"/>
 *     &lt;enumeration value="Air"/>
 *     &lt;enumeration value="PickUp"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_ShipCarrierDlvType")
@XmlEnum
public enum AxdEnumShipCarrierDlvType {

    @XmlEnumValue("Misc")
    MISC("Misc"),
    @XmlEnumValue("Ground")
    GROUND("Ground"),
    @XmlEnumValue("Air")
    AIR("Air"),
    @XmlEnumValue("PickUp")
    PICK_UP("PickUp");
    private final String value;

    AxdEnumShipCarrierDlvType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumShipCarrierDlvType fromValue(String v) {
        for (AxdEnumShipCarrierDlvType c: AxdEnumShipCarrierDlvType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
