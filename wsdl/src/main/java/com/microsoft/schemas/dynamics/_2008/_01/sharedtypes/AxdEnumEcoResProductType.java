
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_EcoResProductType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_EcoResProductType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Item"/>
 *     &lt;enumeration value="Service"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_EcoResProductType")
@XmlEnum
public enum AxdEnumEcoResProductType {

    @XmlEnumValue("Item")
    ITEM("Item"),
    @XmlEnumValue("Service")
    SERVICE("Service");
    private final String value;

    AxdEnumEcoResProductType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumEcoResProductType fromValue(String v) {
        for (AxdEnumEcoResProductType c: AxdEnumEcoResProductType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
