
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_ModuleVendPurch.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_ModuleVendPurch">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Vend"/>
 *     &lt;enumeration value="Purch"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_ModuleVendPurch")
@XmlEnum
public enum AxdEnumModuleVendPurch {

    @XmlEnumValue("Vend")
    VEND("Vend"),
    @XmlEnumValue("Purch")
    PURCH("Purch");
    private final String value;

    AxdEnumModuleVendPurch(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumModuleVendPurch fromValue(String v) {
        for (AxdEnumModuleVendPurch c: AxdEnumModuleVendPurch.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
