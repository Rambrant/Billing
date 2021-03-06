
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_TrvExpLineType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_TrvExpLineType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Default"/>
 *     &lt;enumeration value="ItemizedHeader"/>
 *     &lt;enumeration value="ItemizedLine"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_TrvExpLineType")
@XmlEnum
public enum AxdEnumTrvExpLineType {

    @XmlEnumValue("Default")
    DEFAULT("Default"),
    @XmlEnumValue("ItemizedHeader")
    ITEMIZED_HEADER("ItemizedHeader"),
    @XmlEnumValue("ItemizedLine")
    ITEMIZED_LINE("ItemizedLine");
    private final String value;

    AxdEnumTrvExpLineType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumTrvExpLineType fromValue(String v) {
        for (AxdEnumTrvExpLineType c: AxdEnumTrvExpLineType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
