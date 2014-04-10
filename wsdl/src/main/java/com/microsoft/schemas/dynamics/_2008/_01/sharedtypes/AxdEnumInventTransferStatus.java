
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_InventTransferStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_InventTransferStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Created"/>
 *     &lt;enumeration value="Shipped"/>
 *     &lt;enumeration value="Received"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_InventTransferStatus")
@XmlEnum
public enum AxdEnumInventTransferStatus {

    @XmlEnumValue("Created")
    CREATED("Created"),
    @XmlEnumValue("Shipped")
    SHIPPED("Shipped"),
    @XmlEnumValue("Received")
    RECEIVED("Received");
    private final String value;

    AxdEnumInventTransferStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumInventTransferStatus fromValue(String v) {
        for (AxdEnumInventTransferStatus c: AxdEnumInventTransferStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
