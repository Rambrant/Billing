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
 * <p>Java class for AxdEnum_EUSalesListReportingLayout.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_EUSalesListReportingLayout">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DisplayAmountsByRows"/>
 *     &lt;enumeration value="DisplayAmountsByColumns"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_EUSalesListReportingLayout")
@XmlEnum
public enum AxdEnumEUSalesListReportingLayout {

    @XmlEnumValue("DisplayAmountsByRows")
    DISPLAY_AMOUNTS_BY_ROWS("DisplayAmountsByRows"),
    @XmlEnumValue("DisplayAmountsByColumns")
    DISPLAY_AMOUNTS_BY_COLUMNS("DisplayAmountsByColumns");
    private final String value;

    AxdEnumEUSalesListReportingLayout(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumEUSalesListReportingLayout fromValue(String v) {
        for (AxdEnumEUSalesListReportingLayout c: AxdEnumEUSalesListReportingLayout.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
