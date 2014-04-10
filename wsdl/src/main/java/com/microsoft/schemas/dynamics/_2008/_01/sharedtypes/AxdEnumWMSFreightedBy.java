
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_WMSFreightedBy.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_WMSFreightedBy">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Carrier"/>
 *     &lt;enumeration value="Shipper"/>
 *     &lt;enumeration value="Recipient"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_WMSFreightedBy")
@XmlEnum
public enum AxdEnumWMSFreightedBy {

    @XmlEnumValue("Carrier")
    CARRIER("Carrier"),
    @XmlEnumValue("Shipper")
    SHIPPER("Shipper"),
    @XmlEnumValue("Recipient")
    RECIPIENT("Recipient");
    private final String value;

    AxdEnumWMSFreightedBy(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumWMSFreightedBy fromValue(String v) {
        for (AxdEnumWMSFreightedBy c: AxdEnumWMSFreightedBy.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
