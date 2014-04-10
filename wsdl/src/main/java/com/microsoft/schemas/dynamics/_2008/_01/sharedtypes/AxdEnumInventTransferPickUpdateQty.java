
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_InventTransferPickUpdateQty.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_InventTransferPickUpdateQty">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ShipNow"/>
 *     &lt;enumeration value="All"/>
 *     &lt;enumeration value="ReservedQty"/>
 *     &lt;enumeration value="AvailableQty"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_InventTransferPickUpdateQty")
@XmlEnum
public enum AxdEnumInventTransferPickUpdateQty {

    @XmlEnumValue("ShipNow")
    SHIP_NOW("ShipNow"),
    @XmlEnumValue("All")
    ALL("All"),
    @XmlEnumValue("ReservedQty")
    RESERVED_QTY("ReservedQty"),
    @XmlEnumValue("AvailableQty")
    AVAILABLE_QTY("AvailableQty");
    private final String value;

    AxdEnumInventTransferPickUpdateQty(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumInventTransferPickUpdateQty fromValue(String v) {
        for (AxdEnumInventTransferPickUpdateQty c: AxdEnumInventTransferPickUpdateQty.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
