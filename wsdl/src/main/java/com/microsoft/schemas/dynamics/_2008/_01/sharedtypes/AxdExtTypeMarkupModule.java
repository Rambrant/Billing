
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_MarkupModule.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_MarkupModule">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Invent"/>
 *     &lt;enumeration value="Cust"/>
 *     &lt;enumeration value="Vend"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_MarkupModule")
@XmlEnum
public enum AxdExtTypeMarkupModule {

    @XmlEnumValue("Invent")
    INVENT("Invent"),
    @XmlEnumValue("Cust")
    CUST("Cust"),
    @XmlEnumValue("Vend")
    VEND("Vend");
    private final String value;

    AxdExtTypeMarkupModule(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypeMarkupModule fromValue(String v) {
        for (AxdExtTypeMarkupModule c: AxdExtTypeMarkupModule.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
