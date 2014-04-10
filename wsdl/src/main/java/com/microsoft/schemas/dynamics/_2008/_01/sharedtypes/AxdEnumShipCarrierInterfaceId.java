
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_ShipCarrierInterfaceId.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_ShipCarrierInterfaceId">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ClipperShip"/>
 *     &lt;enumeration value="FedEx"/>
 *     &lt;enumeration value="UPS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_ShipCarrierInterfaceId")
@XmlEnum
public enum AxdEnumShipCarrierInterfaceId {

    @XmlEnumValue("ClipperShip")
    CLIPPER_SHIP("ClipperShip"),
    @XmlEnumValue("FedEx")
    FED_EX("FedEx"),
    UPS("UPS");
    private final String value;

    AxdEnumShipCarrierInterfaceId(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumShipCarrierInterfaceId fromValue(String v) {
        for (AxdEnumShipCarrierInterfaceId c: AxdEnumShipCarrierInterfaceId.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
