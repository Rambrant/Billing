
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_ParmJobStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_ParmJobStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Executed"/>
 *     &lt;enumeration value="ContainErrors"/>
 *     &lt;enumeration value="Waiting"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_ParmJobStatus")
@XmlEnum
public enum AxdEnumParmJobStatus {

    @XmlEnumValue("Executed")
    EXECUTED("Executed"),
    @XmlEnumValue("ContainErrors")
    CONTAIN_ERRORS("ContainErrors"),
    @XmlEnumValue("Waiting")
    WAITING("Waiting");
    private final String value;

    AxdEnumParmJobStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumParmJobStatus fromValue(String v) {
        for (AxdEnumParmJobStatus c: AxdEnumParmJobStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
