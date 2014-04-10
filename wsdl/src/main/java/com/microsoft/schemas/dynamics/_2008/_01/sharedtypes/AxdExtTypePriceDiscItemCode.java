
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_PriceDiscItemCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_PriceDiscItemCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Table"/>
 *     &lt;enumeration value="GroupId"/>
 *     &lt;enumeration value="All"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_PriceDiscItemCode")
@XmlEnum
public enum AxdExtTypePriceDiscItemCode {

    @XmlEnumValue("Table")
    TABLE("Table"),
    @XmlEnumValue("GroupId")
    GROUP_ID("GroupId"),
    @XmlEnumValue("All")
    ALL("All");
    private final String value;

    AxdExtTypePriceDiscItemCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypePriceDiscItemCode fromValue(String v) {
        for (AxdExtTypePriceDiscItemCode c: AxdExtTypePriceDiscItemCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
