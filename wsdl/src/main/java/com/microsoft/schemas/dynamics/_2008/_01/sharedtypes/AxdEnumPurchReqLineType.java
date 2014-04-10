
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_PurchReqLineType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_PurchReqLineType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Item"/>
 *     &lt;enumeration value="Category"/>
 *     &lt;enumeration value="External"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_PurchReqLineType")
@XmlEnum
public enum AxdEnumPurchReqLineType {

    @XmlEnumValue("Item")
    ITEM("Item"),
    @XmlEnumValue("Category")
    CATEGORY("Category"),
    @XmlEnumValue("External")
    EXTERNAL("External");
    private final String value;

    AxdEnumPurchReqLineType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumPurchReqLineType fromValue(String v) {
        for (AxdEnumPurchReqLineType c: AxdEnumPurchReqLineType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
