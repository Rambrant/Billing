
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_CashDiscDue.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_CashDiscDue">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CashDisc"/>
 *     &lt;enumeration value="Due"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_CashDiscDue")
@XmlEnum
public enum AxdEnumCashDiscDue {

    @XmlEnumValue("CashDisc")
    CASH_DISC("CashDisc"),
    @XmlEnumValue("Due")
    DUE("Due");
    private final String value;

    AxdEnumCashDiscDue(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumCashDiscDue fromValue(String v) {
        for (AxdEnumCashDiscDue c: AxdEnumCashDiscDue.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
