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
 * <p>Java class for AxdExtType_Tax1099Reporting.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_Tax1099Reporting">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="No"/>
 *     &lt;enumeration value="Yes"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_Tax1099Reporting")
@XmlEnum
public enum AxdExtTypeTax1099Reporting {

    @XmlEnumValue("No")
    NO("No"),
    @XmlEnumValue("Yes")
    YES("Yes");
    private final String value;

    AxdExtTypeTax1099Reporting(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypeTax1099Reporting fromValue(String v) {
        for (AxdExtTypeTax1099Reporting c: AxdExtTypeTax1099Reporting.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
