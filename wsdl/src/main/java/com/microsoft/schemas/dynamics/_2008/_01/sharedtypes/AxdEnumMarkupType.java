
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_MarkupType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_MarkupType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Item"/>
 *     &lt;enumeration value="LedgerAccount"/>
 *     &lt;enumeration value="CustVend"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_MarkupType")
@XmlEnum
public enum AxdEnumMarkupType {

    @XmlEnumValue("Item")
    ITEM("Item"),
    @XmlEnumValue("LedgerAccount")
    LEDGER_ACCOUNT("LedgerAccount"),
    @XmlEnumValue("CustVend")
    CUST_VEND("CustVend");
    private final String value;

    AxdEnumMarkupType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumMarkupType fromValue(String v) {
        for (AxdEnumMarkupType c: AxdEnumMarkupType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
