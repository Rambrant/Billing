
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_CreditCardAddressVerification.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_CreditCardAddressVerification">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="No"/>
 *     &lt;enumeration value="Yes"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_CreditCardAddressVerification")
@XmlEnum
public enum AxdEnumCreditCardAddressVerification {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("No")
    NO("No"),
    @XmlEnumValue("Yes")
    YES("Yes");
    private final String value;

    AxdEnumCreditCardAddressVerification(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumCreditCardAddressVerification fromValue(String v) {
        for (AxdEnumCreditCardAddressVerification c: AxdEnumCreditCardAddressVerification.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
