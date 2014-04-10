
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_PurchRFQType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_PurchRFQType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Purch"/>
 *     &lt;enumeration value="PurchAgreement"/>
 *     &lt;enumeration value="PurchReq"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_PurchRFQType")
@XmlEnum
public enum AxdEnumPurchRFQType {

    @XmlEnumValue("Purch")
    PURCH("Purch"),
    @XmlEnumValue("PurchAgreement")
    PURCH_AGREEMENT("PurchAgreement"),
    @XmlEnumValue("PurchReq")
    PURCH_REQ("PurchReq");
    private final String value;

    AxdEnumPurchRFQType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumPurchRFQType fromValue(String v) {
        for (AxdEnumPurchRFQType c: AxdEnumPurchRFQType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
