
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_SalesBatchType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_SalesBatchType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FormLetter"/>
 *     &lt;enumeration value="Delete"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_SalesBatchType")
@XmlEnum
public enum AxdExtTypeSalesBatchType {

    @XmlEnumValue("FormLetter")
    FORM_LETTER("FormLetter"),
    @XmlEnumValue("Delete")
    DELETE("Delete");
    private final String value;

    AxdExtTypeSalesBatchType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypeSalesBatchType fromValue(String v) {
        for (AxdExtTypeSalesBatchType c: AxdExtTypeSalesBatchType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
