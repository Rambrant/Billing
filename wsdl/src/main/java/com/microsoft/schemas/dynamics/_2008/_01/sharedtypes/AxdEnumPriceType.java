
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_PriceType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_PriceType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PricePurch"/>
 *     &lt;enumeration value="LineDiscPurch"/>
 *     &lt;enumeration value="MultiLineDiscPurch"/>
 *     &lt;enumeration value="EndDiscPurch"/>
 *     &lt;enumeration value="PriceSales"/>
 *     &lt;enumeration value="LineDiscSales"/>
 *     &lt;enumeration value="MultiLineDiscSales"/>
 *     &lt;enumeration value="EndDiscSales"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_PriceType")
@XmlEnum
public enum AxdEnumPriceType {

    @XmlEnumValue("PricePurch")
    PRICE_PURCH("PricePurch"),
    @XmlEnumValue("LineDiscPurch")
    LINE_DISC_PURCH("LineDiscPurch"),
    @XmlEnumValue("MultiLineDiscPurch")
    MULTI_LINE_DISC_PURCH("MultiLineDiscPurch"),
    @XmlEnumValue("EndDiscPurch")
    END_DISC_PURCH("EndDiscPurch"),
    @XmlEnumValue("PriceSales")
    PRICE_SALES("PriceSales"),
    @XmlEnumValue("LineDiscSales")
    LINE_DISC_SALES("LineDiscSales"),
    @XmlEnumValue("MultiLineDiscSales")
    MULTI_LINE_DISC_SALES("MultiLineDiscSales"),
    @XmlEnumValue("EndDiscSales")
    END_DISC_SALES("EndDiscSales");
    private final String value;

    AxdEnumPriceType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumPriceType fromValue(String v) {
        for (AxdEnumPriceType c: AxdEnumPriceType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
