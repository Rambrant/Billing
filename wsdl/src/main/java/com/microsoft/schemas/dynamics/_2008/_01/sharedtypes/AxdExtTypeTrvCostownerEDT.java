
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_TrvCostownerEDT.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_TrvCostownerEDT">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Company"/>
 *     &lt;enumeration value="Employee"/>
 *     &lt;enumeration value="CustomerOther"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_TrvCostownerEDT")
@XmlEnum
public enum AxdExtTypeTrvCostownerEDT {

    @XmlEnumValue("Company")
    COMPANY("Company"),
    @XmlEnumValue("Employee")
    EMPLOYEE("Employee"),
    @XmlEnumValue("CustomerOther")
    CUSTOMER_OTHER("CustomerOther");
    private final String value;

    AxdExtTypeTrvCostownerEDT(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypeTrvCostownerEDT fromValue(String v) {
        for (AxdExtTypeTrvCostownerEDT c: AxdExtTypeTrvCostownerEDT.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
