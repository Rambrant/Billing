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
 * <p>Java class for AxdEnum_UseCashDisc.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_UseCashDisc">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Normal"/>
 *     &lt;enumeration value="Always"/>
 *     &lt;enumeration value="Never"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_UseCashDisc")
@XmlEnum
public enum AxdEnumUseCashDisc {

    @XmlEnumValue("Normal")
    NORMAL("Normal"),
    @XmlEnumValue("Always")
    ALWAYS("Always"),
    @XmlEnumValue("Never")
    NEVER("Never");
    private final String value;

    AxdEnumUseCashDisc(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumUseCashDisc fromValue(String v) {
        for (AxdEnumUseCashDisc c: AxdEnumUseCashDisc.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
