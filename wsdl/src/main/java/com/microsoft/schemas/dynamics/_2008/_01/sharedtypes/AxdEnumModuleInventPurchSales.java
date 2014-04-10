
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_ModuleInventPurchSales.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_ModuleInventPurchSales">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Invent"/>
 *     &lt;enumeration value="Purch"/>
 *     &lt;enumeration value="Sales"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_ModuleInventPurchSales")
@XmlEnum
public enum AxdEnumModuleInventPurchSales {

    @XmlEnumValue("Invent")
    INVENT("Invent"),
    @XmlEnumValue("Purch")
    PURCH("Purch"),
    @XmlEnumValue("Sales")
    SALES("Sales");
    private final String value;

    AxdEnumModuleInventPurchSales(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumModuleInventPurchSales fromValue(String v) {
        for (AxdEnumModuleInventPurchSales c: AxdEnumModuleInventPurchSales.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
