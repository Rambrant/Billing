
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_PaymMethod.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_PaymMethod">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Net"/>
 *     &lt;enumeration value="CurrentMth"/>
 *     &lt;enumeration value="CurrentQuart"/>
 *     &lt;enumeration value="CurrentYear"/>
 *     &lt;enumeration value="CurrentWeek"/>
 *     &lt;enumeration value="COD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_PaymMethod")
@XmlEnum
public enum AxdExtTypePaymMethod {

    @XmlEnumValue("Net")
    NET("Net"),
    @XmlEnumValue("CurrentMth")
    CURRENT_MTH("CurrentMth"),
    @XmlEnumValue("CurrentQuart")
    CURRENT_QUART("CurrentQuart"),
    @XmlEnumValue("CurrentYear")
    CURRENT_YEAR("CurrentYear"),
    @XmlEnumValue("CurrentWeek")
    CURRENT_WEEK("CurrentWeek"),
    COD("COD");
    private final String value;

    AxdExtTypePaymMethod(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypePaymMethod fromValue(String v) {
        for (AxdExtTypePaymMethod c: AxdExtTypePaymMethod.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
