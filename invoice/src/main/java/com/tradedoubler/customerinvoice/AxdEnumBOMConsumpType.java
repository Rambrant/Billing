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
 * <p>Java class for AxdEnum_BOMConsumpType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_BOMConsumpType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Variable"/>
 *     &lt;enumeration value="Constant"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_BOMConsumpType")
@XmlEnum
public enum AxdEnumBOMConsumpType {

    @XmlEnumValue("Variable")
    VARIABLE("Variable"),
    @XmlEnumValue("Constant")
    CONSTANT("Constant");
    private final String value;

    AxdEnumBOMConsumpType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumBOMConsumpType fromValue(String v) {
        for (AxdEnumBOMConsumpType c: AxdEnumBOMConsumpType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
