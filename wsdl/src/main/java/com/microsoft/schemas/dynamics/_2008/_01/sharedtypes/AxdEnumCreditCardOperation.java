
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_CreditCardOperation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_CreditCardOperation">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="AuthorizeAndCapture"/>
 *     &lt;enumeration value="Authorize"/>
 *     &lt;enumeration value="Refund"/>
 *     &lt;enumeration value="Void"/>
 *     &lt;enumeration value="CaptureAfterAuthorize"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_CreditCardOperation")
@XmlEnum
public enum AxdEnumCreditCardOperation {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("AuthorizeAndCapture")
    AUTHORIZE_AND_CAPTURE("AuthorizeAndCapture"),
    @XmlEnumValue("Authorize")
    AUTHORIZE("Authorize"),
    @XmlEnumValue("Refund")
    REFUND("Refund"),
    @XmlEnumValue("Void")
    VOID("Void"),
    @XmlEnumValue("CaptureAfterAuthorize")
    CAPTURE_AFTER_AUTHORIZE("CaptureAfterAuthorize");
    private final String value;

    AxdEnumCreditCardOperation(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumCreditCardOperation fromValue(String v) {
        for (AxdEnumCreditCardOperation c: AxdEnumCreditCardOperation.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
