
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_CustVendPaymStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_CustVendPaymStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Sent"/>
 *     &lt;enumeration value="Recieved"/>
 *     &lt;enumeration value="Confirmed"/>
 *     &lt;enumeration value="Rejected"/>
 *     &lt;enumeration value="Delete"/>
 *     &lt;enumeration value="SentDelete"/>
 *     &lt;enumeration value="Deleted"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_CustVendPaymStatus")
@XmlEnum
public enum AxdEnumCustVendPaymStatus {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Sent")
    SENT("Sent"),
    @XmlEnumValue("Recieved")
    RECIEVED("Recieved"),
    @XmlEnumValue("Confirmed")
    CONFIRMED("Confirmed"),
    @XmlEnumValue("Rejected")
    REJECTED("Rejected"),
    @XmlEnumValue("Delete")
    DELETE("Delete"),
    @XmlEnumValue("SentDelete")
    SENT_DELETE("SentDelete"),
    @XmlEnumValue("Deleted")
    DELETED("Deleted");
    private final String value;

    AxdEnumCustVendPaymStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumCustVendPaymStatus fromValue(String v) {
        for (AxdEnumCustVendPaymStatus c: AxdEnumCustVendPaymStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
