
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_VendBlocked.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_VendBlocked">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="No"/>
 *     &lt;enumeration value="Invoice"/>
 *     &lt;enumeration value="All"/>
 *     &lt;enumeration value="Payment"/>
 *     &lt;enumeration value="Requisition"/>
 *     &lt;enumeration value="Never"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_VendBlocked")
@XmlEnum
public enum AxdExtTypeVendBlocked {

    @XmlEnumValue("No")
    NO("No"),
    @XmlEnumValue("Invoice")
    INVOICE("Invoice"),
    @XmlEnumValue("All")
    ALL("All"),
    @XmlEnumValue("Payment")
    PAYMENT("Payment"),
    @XmlEnumValue("Requisition")
    REQUISITION("Requisition"),
    @XmlEnumValue("Never")
    NEVER("Never");
    private final String value;

    AxdExtTypeVendBlocked(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypeVendBlocked fromValue(String v) {
        for (AxdExtTypeVendBlocked c: AxdExtTypeVendBlocked.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
