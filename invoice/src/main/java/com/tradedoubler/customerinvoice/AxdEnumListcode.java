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
 * <p>Java class for AxdEnum_Listcode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_Listcode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IncludeNot"/>
 *     &lt;enumeration value="EUTrade"/>
 *     &lt;enumeration value="ProductionOnToll"/>
 *     &lt;enumeration value="TriangularEUTrade"/>
 *     &lt;enumeration value="TriangularProductionOnToll"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_Listcode")
@XmlEnum
public enum AxdEnumListcode {

    @XmlEnumValue("IncludeNot")
    INCLUDE_NOT("IncludeNot"),
    @XmlEnumValue("EUTrade")
    EU_TRADE("EUTrade"),
    @XmlEnumValue("ProductionOnToll")
    PRODUCTION_ON_TOLL("ProductionOnToll"),
    @XmlEnumValue("TriangularEUTrade")
    TRIANGULAR_EU_TRADE("TriangularEUTrade"),
    @XmlEnumValue("TriangularProductionOnToll")
    TRIANGULAR_PRODUCTION_ON_TOLL("TriangularProductionOnToll");
    private final String value;

    AxdEnumListcode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumListcode fromValue(String v) {
        for (AxdEnumListcode c: AxdEnumListcode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}