
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_PriceDiscAccountCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_PriceDiscAccountCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Table"/>
 *     &lt;enumeration value="GroupId"/>
 *     &lt;enumeration value="All"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_PriceDiscAccountCode")
@XmlEnum
public enum AxdExtTypePriceDiscAccountCode {

    @XmlEnumValue("Table")
    TABLE("Table"),
    @XmlEnumValue("GroupId")
    GROUP_ID("GroupId"),
    @XmlEnumValue("All")
    ALL("All");
    private final String value;

    AxdExtTypePriceDiscAccountCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypePriceDiscAccountCode fromValue(String v) {
        for (AxdExtTypePriceDiscAccountCode c: AxdExtTypePriceDiscAccountCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
