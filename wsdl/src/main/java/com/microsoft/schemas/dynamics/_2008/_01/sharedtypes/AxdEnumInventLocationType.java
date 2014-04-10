
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_InventLocationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_InventLocationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Standard"/>
 *     &lt;enumeration value="Quarantine"/>
 *     &lt;enumeration value="Transit"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_InventLocationType")
@XmlEnum
public enum AxdEnumInventLocationType {

    @XmlEnumValue("Standard")
    STANDARD("Standard"),
    @XmlEnumValue("Quarantine")
    QUARANTINE("Quarantine"),
    @XmlEnumValue("Transit")
    TRANSIT("Transit");
    private final String value;

    AxdEnumInventLocationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumInventLocationType fromValue(String v) {
        for (AxdEnumInventLocationType c: AxdEnumInventLocationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
