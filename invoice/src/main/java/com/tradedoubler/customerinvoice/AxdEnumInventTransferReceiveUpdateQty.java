//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.12.28 at 01:35:45 PM CET 
//


package com.tradedoubler.customerinvoice;

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
