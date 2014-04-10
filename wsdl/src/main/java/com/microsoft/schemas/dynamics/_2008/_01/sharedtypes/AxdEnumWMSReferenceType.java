
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_WMSReferenceType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_WMSReferenceType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Sales"/>
 *     &lt;enumeration value="TransferOrderShipment"/>
 *     &lt;enumeration value="ProductionLine"/>
 *     &lt;enumeration value="Kanban"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_WMSReferenceType")
@XmlEnum
public enum AxdEnumWMSReferenceType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Sales")
    SALES("Sales"),
    @XmlEnumValue("TransferOrderShipment")
    TRANSFER_ORDER_SHIPMENT("TransferOrderShipment"),
    @XmlEnumValue("ProductionLine")
    PRODUCTION_LINE("ProductionLine"),
    @XmlEnumValue("Kanban")
    KANBAN("Kanban");
    private final String value;

    AxdEnumWMSReferenceType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumWMSReferenceType fromValue(String v) {
        for (AxdEnumWMSReferenceType c: AxdEnumWMSReferenceType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
