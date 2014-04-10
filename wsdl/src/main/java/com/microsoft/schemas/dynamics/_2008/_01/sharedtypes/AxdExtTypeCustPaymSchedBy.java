
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_CustPaymSchedBy.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_CustPaymSchedBy">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Total"/>
 *     &lt;enumeration value="AmountByPayment"/>
 *     &lt;enumeration value="NumOfPayment"/>
 *     &lt;enumeration value="Specified"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_CustPaymSchedBy")
@XmlEnum
public enum AxdExtTypeCustPaymSchedBy {

    @XmlEnumValue("Total")
    TOTAL("Total"),
    @XmlEnumValue("AmountByPayment")
    AMOUNT_BY_PAYMENT("AmountByPayment"),
    @XmlEnumValue("NumOfPayment")
    NUM_OF_PAYMENT("NumOfPayment"),
    @XmlEnumValue("Specified")
    SPECIFIED("Specified");
    private final String value;

    AxdExtTypeCustPaymSchedBy(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypeCustPaymSchedBy fromValue(String v) {
        for (AxdExtTypeCustPaymSchedBy c: AxdExtTypeCustPaymSchedBy.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
