
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_CurrentOperationsTax.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_CurrentOperationsTax">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Current"/>
 *     &lt;enumeration value="Operations"/>
 *     &lt;enumeration value="Tax"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_CurrentOperationsTax")
@XmlEnum
public enum AxdEnumCurrentOperationsTax {

    @XmlEnumValue("Current")
    CURRENT("Current"),
    @XmlEnumValue("Operations")
    OPERATIONS("Operations"),
    @XmlEnumValue("Tax")
    TAX("Tax");
    private final String value;

    AxdEnumCurrentOperationsTax(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumCurrentOperationsTax fromValue(String v) {
        for (AxdEnumCurrentOperationsTax c: AxdEnumCurrentOperationsTax.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
