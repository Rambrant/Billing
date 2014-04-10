
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_AccountRole.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_AccountRole">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Original"/>
 *     &lt;enumeration value="Reversing"/>
 *     &lt;enumeration value="Adjusting"/>
 *     &lt;enumeration value="Closing"/>
 *     &lt;enumeration value="Opening"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_AccountRole")
@XmlEnum
public enum AxdEnumAccountRole {

    @XmlEnumValue("Original")
    ORIGINAL("Original"),
    @XmlEnumValue("Reversing")
    REVERSING("Reversing"),
    @XmlEnumValue("Adjusting")
    ADJUSTING("Adjusting"),
    @XmlEnumValue("Closing")
    CLOSING("Closing"),
    @XmlEnumValue("Opening")
    OPENING("Opening");
    private final String value;

    AxdEnumAccountRole(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumAccountRole fromValue(String v) {
        for (AxdEnumAccountRole c: AxdEnumAccountRole.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
