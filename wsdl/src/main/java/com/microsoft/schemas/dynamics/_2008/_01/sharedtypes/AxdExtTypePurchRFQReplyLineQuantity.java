
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_PurchRFQReplyLineQuantity.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_PurchRFQReplyLineQuantity">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="No"/>
 *     &lt;enumeration value="Yes"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_PurchRFQReplyLineQuantity")
@XmlEnum
public enum AxdExtTypePurchRFQReplyLineQuantity {

    @XmlEnumValue("No")
    NO("No"),
    @XmlEnumValue("Yes")
    YES("Yes");
    private final String value;

    AxdExtTypePurchRFQReplyLineQuantity(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypePurchRFQReplyLineQuantity fromValue(String v) {
        for (AxdExtTypePurchRFQReplyLineQuantity c: AxdExtTypePurchRFQReplyLineQuantity.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
