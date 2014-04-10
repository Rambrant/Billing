
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_ProdErrorCause.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_ProdErrorCause">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Material"/>
 *     &lt;enumeration value="Machine"/>
 *     &lt;enumeration value="OperatingStaff"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_ProdErrorCause")
@XmlEnum
public enum AxdEnumProdErrorCause {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Material")
    MATERIAL("Material"),
    @XmlEnumValue("Machine")
    MACHINE("Machine"),
    @XmlEnumValue("OperatingStaff")
    OPERATING_STAFF("OperatingStaff");
    private final String value;

    AxdEnumProdErrorCause(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumProdErrorCause fromValue(String v) {
        for (AxdEnumProdErrorCause c: AxdEnumProdErrorCause.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
