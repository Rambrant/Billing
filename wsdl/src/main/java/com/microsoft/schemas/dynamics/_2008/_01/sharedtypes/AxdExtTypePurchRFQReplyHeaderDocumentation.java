
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_PurchRFQReplyHeaderDocumentation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_PurchRFQReplyHeaderDocumentation">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="No"/>
 *     &lt;enumeration value="Yes"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_PurchRFQReplyHeaderDocumentation")
@XmlEnum
public enum AxdExtTypePurchRFQReplyHeaderDocumentation {

    @XmlEnumValue("No")
    NO("No"),
    @XmlEnumValue("Yes")
    YES("Yes");
    private final String value;

    AxdExtTypePurchRFQReplyHeaderDocumentation(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypePurchRFQReplyHeaderDocumentation fromValue(String v) {
        for (AxdExtTypePurchRFQReplyHeaderDocumentation c: AxdExtTypePurchRFQReplyHeaderDocumentation.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
