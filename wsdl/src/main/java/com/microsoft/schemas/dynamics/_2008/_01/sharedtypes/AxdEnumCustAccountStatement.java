
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_CustAccountStatement.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_CustAccountStatement">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Always"/>
 *     &lt;enumeration value="Quarter"/>
 *     &lt;enumeration value="Biannually"/>
 *     &lt;enumeration value="Yearly"/>
 *     &lt;enumeration value="Never"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_CustAccountStatement")
@XmlEnum
public enum AxdEnumCustAccountStatement {

    @XmlEnumValue("Always")
    ALWAYS("Always"),
    @XmlEnumValue("Quarter")
    QUARTER("Quarter"),
    @XmlEnumValue("Biannually")
    BIANNUALLY("Biannually"),
    @XmlEnumValue("Yearly")
    YEARLY("Yearly"),
    @XmlEnumValue("Never")
    NEVER("Never");
    private final String value;

    AxdEnumCustAccountStatement(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumCustAccountStatement fromValue(String v) {
        for (AxdEnumCustAccountStatement c: AxdEnumCustAccountStatement.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
