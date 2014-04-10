
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_VendorOperationType_MX.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_VendorOperationType_MX">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Blank"/>
 *     &lt;enumeration value="ProServices"/>
 *     &lt;enumeration value="RentLease"/>
 *     &lt;enumeration value="Other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_VendorOperationType_MX")
@XmlEnum
public enum AxdEnumVendorOperationTypeMX {

    @XmlEnumValue("Blank")
    BLANK("Blank"),
    @XmlEnumValue("ProServices")
    PRO_SERVICES("ProServices"),
    @XmlEnumValue("RentLease")
    RENT_LEASE("RentLease"),
    @XmlEnumValue("Other")
    OTHER("Other");
    private final String value;

    AxdEnumVendorOperationTypeMX(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumVendorOperationTypeMX fromValue(String v) {
        for (AxdEnumVendorOperationTypeMX c: AxdEnumVendorOperationTypeMX.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
