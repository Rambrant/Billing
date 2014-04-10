
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_MDS_SalesInvoiceEvent.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_MDS_SalesInvoiceEvent">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Posted"/>
 *     &lt;enumeration value="Paid"/>
 *     &lt;enumeration value="Reminded"/>
 *     &lt;enumeration value="WriteOff"/>
 *     &lt;enumeration value="Settled"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_MDS_SalesInvoiceEvent")
@XmlEnum
public enum AxdEnumMDSSalesInvoiceEvent {

    @XmlEnumValue("Posted")
    POSTED("Posted"),
    @XmlEnumValue("Paid")
    PAID("Paid"),
    @XmlEnumValue("Reminded")
    REMINDED("Reminded"),
    @XmlEnumValue("WriteOff")
    WRITE_OFF("WriteOff"),
    @XmlEnumValue("Settled")
    SETTLED("Settled");
    private final String value;

    AxdEnumMDSSalesInvoiceEvent(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumMDSSalesInvoiceEvent fromValue(String v) {
        for (AxdEnumMDSSalesInvoiceEvent c: AxdEnumMDSSalesInvoiceEvent.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
