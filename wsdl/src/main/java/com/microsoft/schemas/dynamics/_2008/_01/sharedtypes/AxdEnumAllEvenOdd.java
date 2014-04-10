
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_AllEvenOdd.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_AllEvenOdd">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="All"/>
 *     &lt;enumeration value="Even"/>
 *     &lt;enumeration value="Odd"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_AllEvenOdd")
@XmlEnum
public enum AxdEnumAllEvenOdd {

    @XmlEnumValue("All")
    ALL("All"),
    @XmlEnumValue("Even")
    EVEN("Even"),
    @XmlEnumValue("Odd")
    ODD("Odd");
    private final String value;

    AxdEnumAllEvenOdd(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumAllEvenOdd fromValue(String v) {
        for (AxdEnumAllEvenOdd c: AxdEnumAllEvenOdd.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
