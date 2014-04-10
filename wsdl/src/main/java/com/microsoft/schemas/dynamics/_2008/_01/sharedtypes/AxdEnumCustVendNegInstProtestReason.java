
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_CustVendNegInstProtestReason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_CustVendNegInstProtestReason">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="NonAcceptance"/>
 *     &lt;enumeration value="NonPayment"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_CustVendNegInstProtestReason")
@XmlEnum
public enum AxdEnumCustVendNegInstProtestReason {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("NonAcceptance")
    NON_ACCEPTANCE("NonAcceptance"),
    @XmlEnumValue("NonPayment")
    NON_PAYMENT("NonPayment");
    private final String value;

    AxdEnumCustVendNegInstProtestReason(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumCustVendNegInstProtestReason fromValue(String v) {
        for (AxdEnumCustVendNegInstProtestReason c: AxdEnumCustVendNegInstProtestReason.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
