
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_LogisticsLocationEntityType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_LogisticsLocationEntityType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Site"/>
 *     &lt;enumeration value="Warehouse"/>
 *     &lt;enumeration value="ApplicationBasket"/>
 *     &lt;enumeration value="Party"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_LogisticsLocationEntityType")
@XmlEnum
public enum AxdEnumLogisticsLocationEntityType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Site")
    SITE("Site"),
    @XmlEnumValue("Warehouse")
    WAREHOUSE("Warehouse"),
    @XmlEnumValue("ApplicationBasket")
    APPLICATION_BASKET("ApplicationBasket"),
    @XmlEnumValue("Party")
    PARTY("Party");
    private final String value;

    AxdEnumLogisticsLocationEntityType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumLogisticsLocationEntityType fromValue(String v) {
        for (AxdEnumLogisticsLocationEntityType c: AxdEnumLogisticsLocationEntityType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
