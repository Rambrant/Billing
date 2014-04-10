
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_CreditCardAddressVerificationResult.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_CreditCardAddressVerificationResult">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Returned"/>
 *     &lt;enumeration value="NotReturned"/>
 *     &lt;enumeration value="VerificationNotSupported"/>
 *     &lt;enumeration value="SystemUnavailable"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_CreditCardAddressVerificationResult")
@XmlEnum
public enum AxdEnumCreditCardAddressVerificationResult {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Returned")
    RETURNED("Returned"),
    @XmlEnumValue("NotReturned")
    NOT_RETURNED("NotReturned"),
    @XmlEnumValue("VerificationNotSupported")
    VERIFICATION_NOT_SUPPORTED("VerificationNotSupported"),
    @XmlEnumValue("SystemUnavailable")
    SYSTEM_UNAVAILABLE("SystemUnavailable");
    private final String value;

    AxdEnumCreditCardAddressVerificationResult(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumCreditCardAddressVerificationResult fromValue(String v) {
        for (AxdEnumCreditCardAddressVerificationResult c: AxdEnumCreditCardAddressVerificationResult.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
