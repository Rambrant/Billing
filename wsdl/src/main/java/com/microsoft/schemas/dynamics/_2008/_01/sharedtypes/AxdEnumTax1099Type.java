
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_Tax1099Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_Tax1099Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="F1099DIV"/>
 *     &lt;enumeration value="F1099INT"/>
 *     &lt;enumeration value="F1099MISC"/>
 *     &lt;enumeration value="F1099OID"/>
 *     &lt;enumeration value="F1099G"/>
 *     &lt;enumeration value="F1099S"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_Tax1099Type")
@XmlEnum
public enum AxdEnumTax1099Type {

    @XmlEnumValue("F1099DIV")
    F_1099_DIV("F1099DIV"),
    @XmlEnumValue("F1099INT")
    F_1099_INT("F1099INT"),
    @XmlEnumValue("F1099MISC")
    F_1099_MISC("F1099MISC"),
    @XmlEnumValue("F1099OID")
    F_1099_OID("F1099OID"),
    @XmlEnumValue("F1099G")
    F_1099_G("F1099G"),
    @XmlEnumValue("F1099S")
    F_1099_S("F1099S");
    private final String value;

    AxdEnumTax1099Type(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumTax1099Type fromValue(String v) {
        for (AxdEnumTax1099Type c: AxdEnumTax1099Type.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
