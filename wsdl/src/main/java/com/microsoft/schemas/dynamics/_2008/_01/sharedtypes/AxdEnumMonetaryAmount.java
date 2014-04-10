
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_MonetaryAmount.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_MonetaryAmount">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ExtendedPrice"/>
 *     &lt;enumeration value="RoundingAmount"/>
 *     &lt;enumeration value="PriceAdjustment"/>
 *     &lt;enumeration value="Discount"/>
 *     &lt;enumeration value="Charge"/>
 *     &lt;enumeration value="TaxNonRecoverable"/>
 *     &lt;enumeration value="Tax"/>
 *     &lt;enumeration value="DiscountVariance"/>
 *     &lt;enumeration value="ChargeVariance"/>
 *     &lt;enumeration value="TaxNonRecoverableVariance"/>
 *     &lt;enumeration value="TaxVariance"/>
 *     &lt;enumeration value="QuantityVariance"/>
 *     &lt;enumeration value="PriceVariance"/>
 *     &lt;enumeration value="PriceAdjustmentVariance"/>
 *     &lt;enumeration value="TotalDiscount"/>
 *     &lt;enumeration value="TotalDiscountVariance"/>
 *     &lt;enumeration value="TotalDiscountRounding"/>
 *     &lt;enumeration value="CashDiscount"/>
 *     &lt;enumeration value="CashDiscountVariance"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_MonetaryAmount")
@XmlEnum
public enum AxdEnumMonetaryAmount {

    @XmlEnumValue("ExtendedPrice")
    EXTENDED_PRICE("ExtendedPrice"),
    @XmlEnumValue("RoundingAmount")
    ROUNDING_AMOUNT("RoundingAmount"),
    @XmlEnumValue("PriceAdjustment")
    PRICE_ADJUSTMENT("PriceAdjustment"),
    @XmlEnumValue("Discount")
    DISCOUNT("Discount"),
    @XmlEnumValue("Charge")
    CHARGE("Charge"),
    @XmlEnumValue("TaxNonRecoverable")
    TAX_NON_RECOVERABLE("TaxNonRecoverable"),
    @XmlEnumValue("Tax")
    TAX("Tax"),
    @XmlEnumValue("DiscountVariance")
    DISCOUNT_VARIANCE("DiscountVariance"),
    @XmlEnumValue("ChargeVariance")
    CHARGE_VARIANCE("ChargeVariance"),
    @XmlEnumValue("TaxNonRecoverableVariance")
    TAX_NON_RECOVERABLE_VARIANCE("TaxNonRecoverableVariance"),
    @XmlEnumValue("TaxVariance")
    TAX_VARIANCE("TaxVariance"),
    @XmlEnumValue("QuantityVariance")
    QUANTITY_VARIANCE("QuantityVariance"),
    @XmlEnumValue("PriceVariance")
    PRICE_VARIANCE("PriceVariance"),
    @XmlEnumValue("PriceAdjustmentVariance")
    PRICE_ADJUSTMENT_VARIANCE("PriceAdjustmentVariance"),
    @XmlEnumValue("TotalDiscount")
    TOTAL_DISCOUNT("TotalDiscount"),
    @XmlEnumValue("TotalDiscountVariance")
    TOTAL_DISCOUNT_VARIANCE("TotalDiscountVariance"),
    @XmlEnumValue("TotalDiscountRounding")
    TOTAL_DISCOUNT_ROUNDING("TotalDiscountRounding"),
    @XmlEnumValue("CashDiscount")
    CASH_DISCOUNT("CashDiscount"),
    @XmlEnumValue("CashDiscountVariance")
    CASH_DISCOUNT_VARIANCE("CashDiscountVariance");
    private final String value;

    AxdEnumMonetaryAmount(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumMonetaryAmount fromValue(String v) {
        for (AxdEnumMonetaryAmount c: AxdEnumMonetaryAmount.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
