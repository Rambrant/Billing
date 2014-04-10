
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_RouteOprPriority.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_RouteOprPriority">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Primary"/>
 *     &lt;enumeration value="Secondary1"/>
 *     &lt;enumeration value="Secondary2"/>
 *     &lt;enumeration value="Secondary3"/>
 *     &lt;enumeration value="Secondary4"/>
 *     &lt;enumeration value="Secondary5"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_RouteOprPriority")
@XmlEnum
public enum AxdEnumRouteOprPriority {

    @XmlEnumValue("Primary")
    PRIMARY("Primary"),
    @XmlEnumValue("Secondary1")
    SECONDARY_1("Secondary1"),
    @XmlEnumValue("Secondary2")
    SECONDARY_2("Secondary2"),
    @XmlEnumValue("Secondary3")
    SECONDARY_3("Secondary3"),
    @XmlEnumValue("Secondary4")
    SECONDARY_4("Secondary4"),
    @XmlEnumValue("Secondary5")
    SECONDARY_5("Secondary5");
    private final String value;

    AxdEnumRouteOprPriority(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumRouteOprPriority fromValue(String v) {
        for (AxdEnumRouteOprPriority c: AxdEnumRouteOprPriority.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
