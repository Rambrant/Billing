
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_CustPaymType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_CustPaymType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BillOfExchange"/>
 *     &lt;enumeration value="Check"/>
 *     &lt;enumeration value="CreditCard"/>
 *     &lt;enumeration value="ElectronicPayment"/>
 *     &lt;enumeration value="Other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_CustPaymType")
@XmlEnum
public enum AxdExtTypeCustPaymType {

    @XmlEnumValue("BillOfExchange")
    BILL_OF_EXCHANGE("BillOfExchange"),
    @XmlEnumValue("Check")
    CHECK("Check"),
    @XmlEnumValue("CreditCard")
    CREDIT_CARD("CreditCard"),
    @XmlEnumValue("ElectronicPayment")
    ELECTRONIC_PAYMENT("ElectronicPayment"),
    @XmlEnumValue("Other")
    OTHER("Other");
    private final String value;

    AxdExtTypeCustPaymType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypeCustPaymType fromValue(String v) {
        for (AxdExtTypeCustPaymType c: AxdExtTypeCustPaymType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
