
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_InventTransferRemainStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_InventTransferRemainStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Receiving"/>
 *     &lt;enumeration value="Shipping"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_InventTransferRemainStatus")
@XmlEnum
public enum AxdEnumInventTransferRemainStatus {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Receiving")
    RECEIVING("Receiving"),
    @XmlEnumValue("Shipping")
    SHIPPING("Shipping");
    private final String value;

    AxdEnumInventTransferRemainStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumInventTransferRemainStatus fromValue(String v) {
        for (AxdEnumInventTransferRemainStatus c: AxdEnumInventTransferRemainStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
