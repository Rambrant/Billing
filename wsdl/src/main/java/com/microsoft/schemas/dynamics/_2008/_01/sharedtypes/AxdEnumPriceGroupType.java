
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_PriceGroupType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_PriceGroupType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PriceGroup"/>
 *     &lt;enumeration value="LineDiscGroup"/>
 *     &lt;enumeration value="MultiLineDiscGroup"/>
 *     &lt;enumeration value="EndDiscGroup"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_PriceGroupType")
@XmlEnum
public enum AxdEnumPriceGroupType {

    @XmlEnumValue("PriceGroup")
    PRICE_GROUP("PriceGroup"),
    @XmlEnumValue("LineDiscGroup")
    LINE_DISC_GROUP("LineDiscGroup"),
    @XmlEnumValue("MultiLineDiscGroup")
    MULTI_LINE_DISC_GROUP("MultiLineDiscGroup"),
    @XmlEnumValue("EndDiscGroup")
    END_DISC_GROUP("EndDiscGroup");
    private final String value;

    AxdEnumPriceGroupType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumPriceGroupType fromValue(String v) {
        for (AxdEnumPriceGroupType c: AxdEnumPriceGroupType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
