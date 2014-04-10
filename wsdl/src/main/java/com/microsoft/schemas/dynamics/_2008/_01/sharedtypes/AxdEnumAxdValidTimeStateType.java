
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_AxdValidTimeStateType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_AxdValidTimeStateType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AsOf"/>
 *     &lt;enumeration value="Range"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_AxdValidTimeStateType")
@XmlEnum
public enum AxdEnumAxdValidTimeStateType {

    @XmlEnumValue("AsOf")
    AS_OF("AsOf"),
    @XmlEnumValue("Range")
    RANGE("Range");
    private final String value;

    AxdEnumAxdValidTimeStateType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumAxdValidTimeStateType fromValue(String v) {
        for (AxdEnumAxdValidTimeStateType c: AxdEnumAxdValidTimeStateType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
