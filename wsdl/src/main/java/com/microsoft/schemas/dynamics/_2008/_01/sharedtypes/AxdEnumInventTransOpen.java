
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_InventTransOpen.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_InventTransOpen">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="No"/>
 *     &lt;enumeration value="Yes"/>
 *     &lt;enumeration value="Quotation"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_InventTransOpen")
@XmlEnum
public enum AxdEnumInventTransOpen {

    @XmlEnumValue("No")
    NO("No"),
    @XmlEnumValue("Yes")
    YES("Yes"),
    @XmlEnumValue("Quotation")
    QUOTATION("Quotation");
    private final String value;

    AxdEnumInventTransOpen(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumInventTransOpen fromValue(String v) {
        for (AxdEnumInventTransOpen c: AxdEnumInventTransOpen.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
