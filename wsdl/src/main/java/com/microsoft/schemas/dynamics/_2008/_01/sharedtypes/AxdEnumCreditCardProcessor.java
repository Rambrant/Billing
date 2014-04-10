
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_CreditCardProcessor.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_CreditCardProcessor">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MicrosoftDynamicsPaymentService"/>
 *     &lt;enumeration value="AuthorizeNet"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_CreditCardProcessor")
@XmlEnum
public enum AxdEnumCreditCardProcessor {

    @XmlEnumValue("MicrosoftDynamicsPaymentService")
    MICROSOFT_DYNAMICS_PAYMENT_SERVICE("MicrosoftDynamicsPaymentService"),
    @XmlEnumValue("AuthorizeNet")
    AUTHORIZE_NET("AuthorizeNet");
    private final String value;

    AxdEnumCreditCardProcessor(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumCreditCardProcessor fromValue(String v) {
        for (AxdEnumCreditCardProcessor c: AxdEnumCreditCardProcessor.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
