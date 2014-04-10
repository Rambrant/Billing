
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_TrvTaxType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_TrvTaxType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="VAT"/>
 *     &lt;enumeration value="GST"/>
 *     &lt;enumeration value="HST"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_TrvTaxType")
@XmlEnum
public enum AxdEnumTrvTaxType {

    VAT,
    GST,
    HST;

    public String value() {
        return name();
    }

    public static AxdEnumTrvTaxType fromValue(String v) {
        return valueOf(v);
    }

}
