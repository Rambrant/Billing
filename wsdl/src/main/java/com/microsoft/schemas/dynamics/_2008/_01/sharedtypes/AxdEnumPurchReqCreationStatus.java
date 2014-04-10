
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_PurchReqCreationStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_PurchReqCreationStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Draft"/>
 *     &lt;enumeration value="Approved"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_PurchReqCreationStatus")
@XmlEnum
public enum AxdEnumPurchReqCreationStatus {

    @XmlEnumValue("Draft")
    DRAFT("Draft"),
    @XmlEnumValue("Approved")
    APPROVED("Approved");
    private final String value;

    AxdEnumPurchReqCreationStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumPurchReqCreationStatus fromValue(String v) {
        for (AxdEnumPurchReqCreationStatus c: AxdEnumPurchReqCreationStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
