
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_CustFreightSlipType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_CustFreightSlipType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="UPS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_CustFreightSlipType")
@XmlEnum
public enum AxdExtTypeCustFreightSlipType {

    @XmlEnumValue("None")
    NONE("None"),
    UPS("UPS");
    private final String value;

    AxdExtTypeCustFreightSlipType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypeCustFreightSlipType fromValue(String v) {
        for (AxdExtTypeCustFreightSlipType c: AxdExtTypeCustFreightSlipType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
