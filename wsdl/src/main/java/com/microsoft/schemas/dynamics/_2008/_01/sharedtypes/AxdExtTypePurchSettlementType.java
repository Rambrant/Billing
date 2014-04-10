
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_PurchSettlementType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_PurchSettlementType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="OpenTransact"/>
 *     &lt;enumeration value="SelectedTransact"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_PurchSettlementType")
@XmlEnum
public enum AxdExtTypePurchSettlementType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("OpenTransact")
    OPEN_TRANSACT("OpenTransact"),
    @XmlEnumValue("SelectedTransact")
    SELECTED_TRANSACT("SelectedTransact");
    private final String value;

    AxdExtTypePurchSettlementType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypePurchSettlementType fromValue(String v) {
        for (AxdExtTypePurchSettlementType c: AxdExtTypePurchSettlementType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
