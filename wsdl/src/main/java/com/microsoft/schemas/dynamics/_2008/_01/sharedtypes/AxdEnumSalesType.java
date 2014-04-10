
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_SalesType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_SalesType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Journal"/>
 *     &lt;enumeration value="DEL_Quotation"/>
 *     &lt;enumeration value="Subscription"/>
 *     &lt;enumeration value="Sales"/>
 *     &lt;enumeration value="ReturnItem"/>
 *     &lt;enumeration value="DEL_Blanket"/>
 *     &lt;enumeration value="ItemReq"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_SalesType")
@XmlEnum
public enum AxdEnumSalesType {

    @XmlEnumValue("Journal")
    JOURNAL("Journal"),
    @XmlEnumValue("DEL_Quotation")
    DEL_QUOTATION("DEL_Quotation"),
    @XmlEnumValue("Subscription")
    SUBSCRIPTION("Subscription"),
    @XmlEnumValue("Sales")
    SALES("Sales"),
    @XmlEnumValue("ReturnItem")
    RETURN_ITEM("ReturnItem"),
    @XmlEnumValue("DEL_Blanket")
    DEL_BLANKET("DEL_Blanket"),
    @XmlEnumValue("ItemReq")
    ITEM_REQ("ItemReq");
    private final String value;

    AxdEnumSalesType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumSalesType fromValue(String v) {
        for (AxdEnumSalesType c: AxdEnumSalesType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
