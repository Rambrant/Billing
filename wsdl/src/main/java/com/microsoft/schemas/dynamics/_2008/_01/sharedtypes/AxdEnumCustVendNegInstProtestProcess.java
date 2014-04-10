
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_CustVendNegInstProtestProcess.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_CustVendNegInstProtestProcess">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OpenPaym"/>
 *     &lt;enumeration value="OpenTrans"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_CustVendNegInstProtestProcess")
@XmlEnum
public enum AxdEnumCustVendNegInstProtestProcess {

    @XmlEnumValue("OpenPaym")
    OPEN_PAYM("OpenPaym"),
    @XmlEnumValue("OpenTrans")
    OPEN_TRANS("OpenTrans");
    private final String value;

    AxdEnumCustVendNegInstProtestProcess(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumCustVendNegInstProtestProcess fromValue(String v) {
        for (AxdEnumCustVendNegInstProtestProcess c: AxdEnumCustVendNegInstProtestProcess.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
