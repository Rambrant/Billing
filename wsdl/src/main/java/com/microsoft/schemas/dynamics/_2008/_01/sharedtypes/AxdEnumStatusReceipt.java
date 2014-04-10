
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_StatusReceipt.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_StatusReceipt">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Purchased"/>
 *     &lt;enumeration value="Received"/>
 *     &lt;enumeration value="Registered"/>
 *     &lt;enumeration value="Arrived"/>
 *     &lt;enumeration value="Ordered"/>
 *     &lt;enumeration value="QuotationReceipt"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_StatusReceipt")
@XmlEnum
public enum AxdEnumStatusReceipt {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Purchased")
    PURCHASED("Purchased"),
    @XmlEnumValue("Received")
    RECEIVED("Received"),
    @XmlEnumValue("Registered")
    REGISTERED("Registered"),
    @XmlEnumValue("Arrived")
    ARRIVED("Arrived"),
    @XmlEnumValue("Ordered")
    ORDERED("Ordered"),
    @XmlEnumValue("QuotationReceipt")
    QUOTATION_RECEIPT("QuotationReceipt");
    private final String value;

    AxdEnumStatusReceipt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumStatusReceipt fromValue(String v) {
        for (AxdEnumStatusReceipt c: AxdEnumStatusReceipt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
