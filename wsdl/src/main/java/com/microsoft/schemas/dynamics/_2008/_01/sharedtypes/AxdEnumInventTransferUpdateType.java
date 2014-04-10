
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_InventTransferUpdateType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_InventTransferUpdateType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Shipment"/>
 *     &lt;enumeration value="Receive"/>
 *     &lt;enumeration value="PickingList"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_InventTransferUpdateType")
@XmlEnum
public enum AxdEnumInventTransferUpdateType {

    @XmlEnumValue("Shipment")
    SHIPMENT("Shipment"),
    @XmlEnumValue("Receive")
    RECEIVE("Receive"),
    @XmlEnumValue("PickingList")
    PICKING_LIST("PickingList");
    private final String value;

    AxdEnumInventTransferUpdateType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumInventTransferUpdateType fromValue(String v) {
        for (AxdEnumInventTransferUpdateType c: AxdEnumInventTransferUpdateType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
