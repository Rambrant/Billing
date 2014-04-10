
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_PurchaseType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_PurchaseType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Journal"/>
 *     &lt;enumeration value="DEL_Quotation"/>
 *     &lt;enumeration value="DEL_Subscription"/>
 *     &lt;enumeration value="Purch"/>
 *     &lt;enumeration value="ReturnItem"/>
 *     &lt;enumeration value="DEL_Blanket"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_PurchaseType")
@XmlEnum
public enum AxdEnumPurchaseType {

    @XmlEnumValue("Journal")
    JOURNAL("Journal"),
    @XmlEnumValue("DEL_Quotation")
    DEL_QUOTATION("DEL_Quotation"),
    @XmlEnumValue("DEL_Subscription")
    DEL_SUBSCRIPTION("DEL_Subscription"),
    @XmlEnumValue("Purch")
    PURCH("Purch"),
    @XmlEnumValue("ReturnItem")
    RETURN_ITEM("ReturnItem"),
    @XmlEnumValue("DEL_Blanket")
    DEL_BLANKET("DEL_Blanket");
    private final String value;

    AxdEnumPurchaseType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumPurchaseType fromValue(String v) {
        for (AxdEnumPurchaseType c: AxdEnumPurchaseType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
