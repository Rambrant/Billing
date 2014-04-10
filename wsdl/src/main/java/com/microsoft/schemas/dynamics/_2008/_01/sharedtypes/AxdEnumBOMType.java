
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_BOMType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_BOMType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Item"/>
 *     &lt;enumeration value="Phantom"/>
 *     &lt;enumeration value="PeggedSupply"/>
 *     &lt;enumeration value="Vendor"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_BOMType")
@XmlEnum
public enum AxdEnumBOMType {

    @XmlEnumValue("Item")
    ITEM("Item"),
    @XmlEnumValue("Phantom")
    PHANTOM("Phantom"),
    @XmlEnumValue("PeggedSupply")
    PEGGED_SUPPLY("PeggedSupply"),
    @XmlEnumValue("Vendor")
    VENDOR("Vendor");
    private final String value;

    AxdEnumBOMType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumBOMType fromValue(String v) {
        for (AxdEnumBOMType c: AxdEnumBOMType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
