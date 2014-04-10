
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_CaseResolutionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_CaseResolutionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Accept"/>
 *     &lt;enumeration value="Reject"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_CaseResolutionType")
@XmlEnum
public enum AxdEnumCaseResolutionType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Accept")
    ACCEPT("Accept"),
    @XmlEnumValue("Reject")
    REJECT("Reject");
    private final String value;

    AxdEnumCaseResolutionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumCaseResolutionType fromValue(String v) {
        for (AxdEnumCaseResolutionType c: AxdEnumCaseResolutionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
