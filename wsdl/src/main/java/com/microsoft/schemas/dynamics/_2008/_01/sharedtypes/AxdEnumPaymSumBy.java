
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_PaymSumBy.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_PaymSumBy">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Invoice"/>
 *     &lt;enumeration value="TransDate"/>
 *     &lt;enumeration value="Week"/>
 *     &lt;enumeration value="Total"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_PaymSumBy")
@XmlEnum
public enum AxdEnumPaymSumBy {

    @XmlEnumValue("Invoice")
    INVOICE("Invoice"),
    @XmlEnumValue("TransDate")
    TRANS_DATE("TransDate"),
    @XmlEnumValue("Week")
    WEEK("Week"),
    @XmlEnumValue("Total")
    TOTAL("Total");
    private final String value;

    AxdEnumPaymSumBy(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumPaymSumBy fromValue(String v) {
        for (AxdEnumPaymSumBy c: AxdEnumPaymSumBy.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
