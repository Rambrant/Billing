
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_InventTransferReceiveUpdateQty.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_InventTransferReceiveUpdateQty">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ReceiveNow"/>
 *     &lt;enumeration value="All"/>
 *     &lt;enumeration value="Shipment"/>
 *     &lt;enumeration value="Registered"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_InventTransferReceiveUpdateQty")
@XmlEnum
public enum AxdEnumInventTransferReceiveUpdateQty {

    @XmlEnumValue("ReceiveNow")
    RECEIVE_NOW("ReceiveNow"),
    @XmlEnumValue("All")
    ALL("All"),
    @XmlEnumValue("Shipment")
    SHIPMENT("Shipment"),
    @XmlEnumValue("Registered")
    REGISTERED("Registered");
    private final String value;

    AxdEnumInventTransferReceiveUpdateQty(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumInventTransferReceiveUpdateQty fromValue(String v) {
        for (AxdEnumInventTransferReceiveUpdateQty c: AxdEnumInventTransferReceiveUpdateQty.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
