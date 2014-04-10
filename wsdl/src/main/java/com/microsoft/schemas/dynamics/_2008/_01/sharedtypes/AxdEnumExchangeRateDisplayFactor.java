
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_ExchangeRateDisplayFactor.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_ExchangeRateDisplayFactor">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="One"/>
 *     &lt;enumeration value="Ten"/>
 *     &lt;enumeration value="Hundred"/>
 *     &lt;enumeration value="Thousand"/>
 *     &lt;enumeration value="TenThousand"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_ExchangeRateDisplayFactor")
@XmlEnum
public enum AxdEnumExchangeRateDisplayFactor {

    @XmlEnumValue("One")
    ONE("One"),
    @XmlEnumValue("Ten")
    TEN("Ten"),
    @XmlEnumValue("Hundred")
    HUNDRED("Hundred"),
    @XmlEnumValue("Thousand")
    THOUSAND("Thousand"),
    @XmlEnumValue("TenThousand")
    TEN_THOUSAND("TenThousand");
    private final String value;

    AxdEnumExchangeRateDisplayFactor(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumExchangeRateDisplayFactor fromValue(String v) {
        for (AxdEnumExchangeRateDisplayFactor c: AxdEnumExchangeRateDisplayFactor.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
