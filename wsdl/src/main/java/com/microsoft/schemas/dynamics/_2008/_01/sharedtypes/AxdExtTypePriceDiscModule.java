
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_PriceDiscModule.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_PriceDiscModule">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Invent"/>
 *     &lt;enumeration value="Cust"/>
 *     &lt;enumeration value="Vend"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_PriceDiscModule")
@XmlEnum
public enum AxdExtTypePriceDiscModule {

    @XmlEnumValue("Invent")
    INVENT("Invent"),
    @XmlEnumValue("Cust")
    CUST("Cust"),
    @XmlEnumValue("Vend")
    VEND("Vend");
    private final String value;

    AxdExtTypePriceDiscModule(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypePriceDiscModule fromValue(String v) {
        for (AxdExtTypePriceDiscModule c: AxdExtTypePriceDiscModule.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
