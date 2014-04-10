
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_PurchStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_PurchStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Backorder"/>
 *     &lt;enumeration value="Received"/>
 *     &lt;enumeration value="Invoiced"/>
 *     &lt;enumeration value="Canceled"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_PurchStatus")
@XmlEnum
public enum AxdEnumPurchStatus {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Backorder")
    BACKORDER("Backorder"),
    @XmlEnumValue("Received")
    RECEIVED("Received"),
    @XmlEnumValue("Invoiced")
    INVOICED("Invoiced"),
    @XmlEnumValue("Canceled")
    CANCELED("Canceled");
    private final String value;

    AxdEnumPurchStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumPurchStatus fromValue(String v) {
        for (AxdEnumPurchStatus c: AxdEnumPurchStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
