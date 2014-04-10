
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_TrvDisputeIsTempCredit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_TrvDisputeIsTempCredit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NotSet"/>
 *     &lt;enumeration value="TempCredit"/>
 *     &lt;enumeration value="LegTransAction"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_TrvDisputeIsTempCredit")
@XmlEnum
public enum AxdEnumTrvDisputeIsTempCredit {

    @XmlEnumValue("NotSet")
    NOT_SET("NotSet"),
    @XmlEnumValue("TempCredit")
    TEMP_CREDIT("TempCredit"),
    @XmlEnumValue("LegTransAction")
    LEG_TRANS_ACTION("LegTransAction");
    private final String value;

    AxdEnumTrvDisputeIsTempCredit(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumTrvDisputeIsTempCredit fromValue(String v) {
        for (AxdEnumTrvDisputeIsTempCredit c: AxdEnumTrvDisputeIsTempCredit.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
