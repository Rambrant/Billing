
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_ModuleSalesPurch.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_ModuleSalesPurch">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Sales"/>
 *     &lt;enumeration value="Purch"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_ModuleSalesPurch")
@XmlEnum
public enum AxdEnumModuleSalesPurch {

    @XmlEnumValue("Sales")
    SALES("Sales"),
    @XmlEnumValue("Purch")
    PURCH("Purch");
    private final String value;

    AxdEnumModuleSalesPurch(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumModuleSalesPurch fromValue(String v) {
        for (AxdEnumModuleSalesPurch c: AxdEnumModuleSalesPurch.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
