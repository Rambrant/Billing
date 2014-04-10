
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_ShipCarrierFuelSurcharge.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_ShipCarrierFuelSurcharge">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="No"/>
 *     &lt;enumeration value="Yes"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_ShipCarrierFuelSurcharge")
@XmlEnum
public enum AxdExtTypeShipCarrierFuelSurcharge {

    @XmlEnumValue("No")
    NO("No"),
    @XmlEnumValue("Yes")
    YES("Yes");
    private final String value;

    AxdExtTypeShipCarrierFuelSurcharge(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypeShipCarrierFuelSurcharge fromValue(String v) {
        for (AxdExtTypeShipCarrierFuelSurcharge c: AxdExtTypeShipCarrierFuelSurcharge.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
