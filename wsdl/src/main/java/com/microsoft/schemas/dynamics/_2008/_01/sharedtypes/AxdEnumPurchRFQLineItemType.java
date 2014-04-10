
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_PurchRFQLineItemType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_PurchRFQLineItemType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Category"/>
 *     &lt;enumeration value="Item"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_PurchRFQLineItemType")
@XmlEnum
public enum AxdEnumPurchRFQLineItemType {

    @XmlEnumValue("Category")
    CATEGORY("Category"),
    @XmlEnumValue("Item")
    ITEM("Item");
    private final String value;

    AxdEnumPurchRFQLineItemType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumPurchRFQLineItemType fromValue(String v) {
        for (AxdEnumPurchRFQLineItemType c: AxdEnumPurchRFQLineItemType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
