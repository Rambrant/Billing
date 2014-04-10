
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_WMSAutoDecreaseQty.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_WMSAutoDecreaseQty">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="No"/>
 *     &lt;enumeration value="Yes"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_WMSAutoDecreaseQty")
@XmlEnum
public enum AxdExtTypeWMSAutoDecreaseQty {

    @XmlEnumValue("No")
    NO("No"),
    @XmlEnumValue("Yes")
    YES("Yes");
    private final String value;

    AxdExtTypeWMSAutoDecreaseQty(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypeWMSAutoDecreaseQty fromValue(String v) {
        for (AxdExtTypeWMSAutoDecreaseQty c: AxdExtTypeWMSAutoDecreaseQty.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
