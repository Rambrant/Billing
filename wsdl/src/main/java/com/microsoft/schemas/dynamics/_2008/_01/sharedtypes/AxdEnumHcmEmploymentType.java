
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_HcmEmploymentType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_HcmEmploymentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Employee"/>
 *     &lt;enumeration value="Contractor"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_HcmEmploymentType")
@XmlEnum
public enum AxdEnumHcmEmploymentType {

    @XmlEnumValue("Employee")
    EMPLOYEE("Employee"),
    @XmlEnumValue("Contractor")
    CONTRACTOR("Contractor");
    private final String value;

    AxdEnumHcmEmploymentType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumHcmEmploymentType fromValue(String v) {
        for (AxdEnumHcmEmploymentType c: AxdEnumHcmEmploymentType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
