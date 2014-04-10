
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_ItemReservation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_ItemReservation">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Automatic"/>
 *     &lt;enumeration value="Explosion"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_ItemReservation")
@XmlEnum
public enum AxdEnumItemReservation {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Automatic")
    AUTOMATIC("Automatic"),
    @XmlEnumValue("Explosion")
    EXPLOSION("Explosion");
    private final String value;

    AxdEnumItemReservation(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumItemReservation fromValue(String v) {
        for (AxdEnumItemReservation c: AxdEnumItemReservation.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
