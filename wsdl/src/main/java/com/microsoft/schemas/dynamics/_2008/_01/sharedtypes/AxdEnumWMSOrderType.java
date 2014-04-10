
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_WMSOrderType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_WMSOrderType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Output"/>
 *     &lt;enumeration value="NotUsed"/>
 *     &lt;enumeration value="Transport"/>
 *     &lt;enumeration value="OrderPick"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_WMSOrderType")
@XmlEnum
public enum AxdEnumWMSOrderType {

    @XmlEnumValue("Output")
    OUTPUT("Output"),
    @XmlEnumValue("NotUsed")
    NOT_USED("NotUsed"),
    @XmlEnumValue("Transport")
    TRANSPORT("Transport"),
    @XmlEnumValue("OrderPick")
    ORDER_PICK("OrderPick");
    private final String value;

    AxdEnumWMSOrderType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumWMSOrderType fromValue(String v) {
        for (AxdEnumWMSOrderType c: AxdEnumWMSOrderType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
