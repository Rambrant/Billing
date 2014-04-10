
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_DistributionAmountSource.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_DistributionAmountSource">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PrimaryAmount"/>
 *     &lt;enumeration value="Discount"/>
 *     &lt;enumeration value="Tax"/>
 *     &lt;enumeration value="Cost"/>
 *     &lt;enumeration value="RoundOff"/>
 *     &lt;enumeration value="PriceVariance"/>
 *     &lt;enumeration value="Markup"/>
 *     &lt;enumeration value="QuantityVariance"/>
 *     &lt;enumeration value="TaxVariance"/>
 *     &lt;enumeration value="DiscountVariance"/>
 *     &lt;enumeration value="MarkupVariance"/>
 *     &lt;enumeration value="CostVariance"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_DistributionAmountSource")
@XmlEnum
public enum AxdEnumDistributionAmountSource {

    @XmlEnumValue("PrimaryAmount")
    PRIMARY_AMOUNT("PrimaryAmount"),
    @XmlEnumValue("Discount")
    DISCOUNT("Discount"),
    @XmlEnumValue("Tax")
    TAX("Tax"),
    @XmlEnumValue("Cost")
    COST("Cost"),
    @XmlEnumValue("RoundOff")
    ROUND_OFF("RoundOff"),
    @XmlEnumValue("PriceVariance")
    PRICE_VARIANCE("PriceVariance"),
    @XmlEnumValue("Markup")
    MARKUP("Markup"),
    @XmlEnumValue("QuantityVariance")
    QUANTITY_VARIANCE("QuantityVariance"),
    @XmlEnumValue("TaxVariance")
    TAX_VARIANCE("TaxVariance"),
    @XmlEnumValue("DiscountVariance")
    DISCOUNT_VARIANCE("DiscountVariance"),
    @XmlEnumValue("MarkupVariance")
    MARKUP_VARIANCE("MarkupVariance"),
    @XmlEnumValue("CostVariance")
    COST_VARIANCE("CostVariance");
    private final String value;

    AxdEnumDistributionAmountSource(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumDistributionAmountSource fromValue(String v) {
        for (AxdEnumDistributionAmountSource c: AxdEnumDistributionAmountSource.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
