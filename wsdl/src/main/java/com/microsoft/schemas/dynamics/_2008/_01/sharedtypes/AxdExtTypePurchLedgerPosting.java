
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_PurchLedgerPosting.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_PurchLedgerPosting">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Arrival"/>
 *     &lt;enumeration value="Offset"/>
 *     &lt;enumeration value="Vendor"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_PurchLedgerPosting")
@XmlEnum
public enum AxdExtTypePurchLedgerPosting {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Arrival")
    ARRIVAL("Arrival"),
    @XmlEnumValue("Offset")
    OFFSET("Offset"),
    @XmlEnumValue("Vendor")
    VENDOR("Vendor");
    private final String value;

    AxdExtTypePurchLedgerPosting(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypePurchLedgerPosting fromValue(String v) {
        for (AxdExtTypePurchLedgerPosting c: AxdExtTypePurchLedgerPosting.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
