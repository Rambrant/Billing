
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_PurchDlvAddrType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_PurchDlvAddrType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Company"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_PurchDlvAddrType")
@XmlEnum
public enum AxdExtTypePurchDlvAddrType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Company")
    COMPANY("Company");
    private final String value;

    AxdExtTypePurchDlvAddrType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypePurchDlvAddrType fromValue(String v) {
        for (AxdExtTypePurchDlvAddrType c: AxdExtTypePurchDlvAddrType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
