
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_DirNameAffixType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_DirNameAffixType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PersonalPrefix"/>
 *     &lt;enumeration value="PersonalSuffix"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_DirNameAffixType")
@XmlEnum
public enum AxdEnumDirNameAffixType {

    @XmlEnumValue("PersonalPrefix")
    PERSONAL_PREFIX("PersonalPrefix"),
    @XmlEnumValue("PersonalSuffix")
    PERSONAL_SUFFIX("PersonalSuffix");
    private final String value;

    AxdEnumDirNameAffixType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumDirNameAffixType fromValue(String v) {
        for (AxdEnumDirNameAffixType c: AxdEnumDirNameAffixType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
