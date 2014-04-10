//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.12.28 at 01:35:45 PM CET 
//


package com.tradedoubler.customerinvoice;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_TrvAppStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_TrvAppStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Create"/>
 *     &lt;enumeration value="Submitted"/>
 *     &lt;enumeration value="Approved"/>
 *     &lt;enumeration value="Returned"/>
 *     &lt;enumeration value="Ready"/>
 *     &lt;enumeration value="Ledger"/>
 *     &lt;enumeration value="Cancelled"/>
 *     &lt;enumeration value="Pending"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_TrvAppStatus")
@XmlEnum
public enum AxdEnumTrvAppStatus {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Create")
    CREATE("Create"),
    @XmlEnumValue("Submitted")
    SUBMITTED("Submitted"),
    @XmlEnumValue("Approved")
    APPROVED("Approved"),
    @XmlEnumValue("Returned")
    RETURNED("Returned"),
    @XmlEnumValue("Ready")
    READY("Ready"),
    @XmlEnumValue("Ledger")
    LEDGER("Ledger"),
    @XmlEnumValue("Cancelled")
    CANCELLED("Cancelled"),
    @XmlEnumValue("Pending")
    PENDING("Pending");
    private final String value;

    AxdEnumTrvAppStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumTrvAppStatus fromValue(String v) {
        for (AxdEnumTrvAppStatus c: AxdEnumTrvAppStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
