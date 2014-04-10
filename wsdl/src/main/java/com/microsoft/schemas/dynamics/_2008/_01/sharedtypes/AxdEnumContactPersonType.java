
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_ContactPersonType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_ContactPersonType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BPL"/>
 *     &lt;enumeration value="NT"/>
 *     &lt;enumeration value="SEBBPL"/>
 *     &lt;enumeration value="SEBINT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_ContactPersonType")
@XmlEnum
public enum AxdEnumContactPersonType {

    BPL,
    NT,
    SEBBPL,
    SEBINT;

    public String value() {
        return name();
    }

    public static AxdEnumContactPersonType fromValue(String v) {
        return valueOf(v);
    }

}
