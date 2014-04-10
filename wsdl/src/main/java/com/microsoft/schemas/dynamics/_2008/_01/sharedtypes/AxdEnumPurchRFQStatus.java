
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_PurchRFQStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_PurchRFQStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Created"/>
 *     &lt;enumeration value="Sent"/>
 *     &lt;enumeration value="Received"/>
 *     &lt;enumeration value="Rejected"/>
 *     &lt;enumeration value="Accepted"/>
 *     &lt;enumeration value="Canceled"/>
 *     &lt;enumeration value="Declined"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_PurchRFQStatus")
@XmlEnum
public enum AxdEnumPurchRFQStatus {

    @XmlEnumValue("Created")
    CREATED("Created"),
    @XmlEnumValue("Sent")
    SENT("Sent"),
    @XmlEnumValue("Received")
    RECEIVED("Received"),
    @XmlEnumValue("Rejected")
    REJECTED("Rejected"),
    @XmlEnumValue("Accepted")
    ACCEPTED("Accepted"),
    @XmlEnumValue("Canceled")
    CANCELED("Canceled"),
    @XmlEnumValue("Declined")
    DECLINED("Declined");
    private final String value;

    AxdEnumPurchRFQStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumPurchRFQStatus fromValue(String v) {
        for (AxdEnumPurchRFQStatus c: AxdEnumPurchRFQStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
