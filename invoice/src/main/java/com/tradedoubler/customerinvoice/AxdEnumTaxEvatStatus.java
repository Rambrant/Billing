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
 * <p>Java class for AxdEnum_TaxEvatStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_TaxEvatStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Created"/>
 *     &lt;enumeration value="Sent"/>
 *     &lt;enumeration value="Errors"/>
 *     &lt;enumeration value="Acknowledgement"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_TaxEvatStatus")
@XmlEnum
public enum AxdEnumTaxEvatStatus {

    @XmlEnumValue("Created")
    CREATED("Created"),
    @XmlEnumValue("Sent")
    SENT("Sent"),
    @XmlEnumValue("Errors")
    ERRORS("Errors"),
    @XmlEnumValue("Acknowledgement")
    ACKNOWLEDGEMENT("Acknowledgement");
    private final String value;

    AxdEnumTaxEvatStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumTaxEvatStatus fromValue(String v) {
        for (AxdEnumTaxEvatStatus c: AxdEnumTaxEvatStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
