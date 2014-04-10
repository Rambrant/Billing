
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_TradeLineDlvTypeId.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_TradeLineDlvTypeId">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="DropShip"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_TradeLineDlvTypeId")
@XmlEnum
public enum AxdExtTypeTradeLineDlvTypeId {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("DropShip")
    DROP_SHIP("DropShip");
    private final String value;

    AxdExtTypeTradeLineDlvTypeId(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypeTradeLineDlvTypeId fromValue(String v) {
        for (AxdExtTypeTradeLineDlvTypeId c: AxdExtTypeTradeLineDlvTypeId.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
