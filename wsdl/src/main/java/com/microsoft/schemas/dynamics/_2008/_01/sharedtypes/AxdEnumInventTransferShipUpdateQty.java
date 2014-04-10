
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_InventTransferShipUpdateQty.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_InventTransferShipUpdateQty">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ShipNow"/>
 *     &lt;enumeration value="All"/>
 *     &lt;enumeration value="ReservedQty"/>
 *     &lt;enumeration value="AvailableQty"/>
 *     &lt;enumeration value="PickedQty"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_InventTransferShipUpdateQty")
@XmlEnum
public enum AxdEnumInventTransferShipUpdateQty {

    @XmlEnumValue("ShipNow")
    SHIP_NOW("ShipNow"),
    @XmlEnumValue("All")
    ALL("All"),
    @XmlEnumValue("ReservedQty")
    RESERVED_QTY("ReservedQty"),
    @XmlEnumValue("AvailableQty")
    AVAILABLE_QTY("AvailableQty"),
    @XmlEnumValue("PickedQty")
    PICKED_QTY("PickedQty");
    private final String value;

    AxdEnumInventTransferShipUpdateQty(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumInventTransferShipUpdateQty fromValue(String v) {
        for (AxdEnumInventTransferShipUpdateQty c: AxdEnumInventTransferShipUpdateQty.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
