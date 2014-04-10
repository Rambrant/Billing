
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_ItemType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_ItemType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Item"/>
 *     &lt;enumeration value="DEL_BOM"/>
 *     &lt;enumeration value="Service"/>
 *     &lt;enumeration value="DEL_Formula"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_ItemType")
@XmlEnum
public enum AxdEnumItemType {

    @XmlEnumValue("Item")
    ITEM("Item"),
    DEL_BOM("DEL_BOM"),
    @XmlEnumValue("Service")
    SERVICE("Service"),
    @XmlEnumValue("DEL_Formula")
    DEL_FORMULA("DEL_Formula");
    private final String value;

    AxdEnumItemType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumItemType fromValue(String v) {
        for (AxdEnumItemType c: AxdEnumItemType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
