
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_UnitOfMeasureConversionRounding.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_UnitOfMeasureConversionRounding">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Nearest"/>
 *     &lt;enumeration value="Up"/>
 *     &lt;enumeration value="Down"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_UnitOfMeasureConversionRounding")
@XmlEnum
public enum AxdEnumUnitOfMeasureConversionRounding {

    @XmlEnumValue("Nearest")
    NEAREST("Nearest"),
    @XmlEnumValue("Up")
    UP("Up"),
    @XmlEnumValue("Down")
    DOWN("Down");
    private final String value;

    AxdEnumUnitOfMeasureConversionRounding(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumUnitOfMeasureConversionRounding fromValue(String v) {
        for (AxdEnumUnitOfMeasureConversionRounding c: AxdEnumUnitOfMeasureConversionRounding.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
