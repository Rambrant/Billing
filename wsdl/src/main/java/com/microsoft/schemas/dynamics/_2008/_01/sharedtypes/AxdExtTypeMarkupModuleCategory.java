
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_MarkupModuleCategory.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_MarkupModuleCategory">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Heading"/>
 *     &lt;enumeration value="Linie"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_MarkupModuleCategory")
@XmlEnum
public enum AxdExtTypeMarkupModuleCategory {

    @XmlEnumValue("Heading")
    HEADING("Heading"),
    @XmlEnumValue("Linie")
    LINIE("Linie");
    private final String value;

    AxdExtTypeMarkupModuleCategory(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypeMarkupModuleCategory fromValue(String v) {
        for (AxdExtTypeMarkupModuleCategory c: AxdExtTypeMarkupModuleCategory.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
