
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_PurchReqConsolidationStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_PurchReqConsolidationStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Pending"/>
 *     &lt;enumeration value="Consolidated"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_PurchReqConsolidationStatus")
@XmlEnum
public enum AxdEnumPurchReqConsolidationStatus {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Pending")
    PENDING("Pending"),
    @XmlEnumValue("Consolidated")
    CONSOLIDATED("Consolidated");
    private final String value;

    AxdEnumPurchReqConsolidationStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumPurchReqConsolidationStatus fromValue(String v) {
        for (AxdEnumPurchReqConsolidationStatus c: AxdEnumPurchReqConsolidationStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
