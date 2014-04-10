
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_LineDeliveryType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_LineDeliveryType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OrderLine"/>
 *     &lt;enumeration value="OrderLineWithMultipleDeliveries"/>
 *     &lt;enumeration value="DeliveryLine"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_LineDeliveryType")
@XmlEnum
public enum AxdEnumLineDeliveryType {

    @XmlEnumValue("OrderLine")
    ORDER_LINE("OrderLine"),
    @XmlEnumValue("OrderLineWithMultipleDeliveries")
    ORDER_LINE_WITH_MULTIPLE_DELIVERIES("OrderLineWithMultipleDeliveries"),
    @XmlEnumValue("DeliveryLine")
    DELIVERY_LINE("DeliveryLine");
    private final String value;

    AxdEnumLineDeliveryType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumLineDeliveryType fromValue(String v) {
        for (AxdEnumLineDeliveryType c: AxdEnumLineDeliveryType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
