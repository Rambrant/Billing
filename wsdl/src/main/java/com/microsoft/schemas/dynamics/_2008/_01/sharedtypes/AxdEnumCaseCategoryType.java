
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_CaseCategoryType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_CaseCategoryType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="General"/>
 *     &lt;enumeration value="Sales"/>
 *     &lt;enumeration value="Purchase"/>
 *     &lt;enumeration value="Service"/>
 *     &lt;enumeration value="Project"/>
 *     &lt;enumeration value="Production"/>
 *     &lt;enumeration value="Collections"/>
 *     &lt;enumeration value="Audit"/>
 *     &lt;enumeration value="Web"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_CaseCategoryType")
@XmlEnum
public enum AxdEnumCaseCategoryType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("General")
    GENERAL("General"),
    @XmlEnumValue("Sales")
    SALES("Sales"),
    @XmlEnumValue("Purchase")
    PURCHASE("Purchase"),
    @XmlEnumValue("Service")
    SERVICE("Service"),
    @XmlEnumValue("Project")
    PROJECT("Project"),
    @XmlEnumValue("Production")
    PRODUCTION("Production"),
    @XmlEnumValue("Collections")
    COLLECTIONS("Collections"),
    @XmlEnumValue("Audit")
    AUDIT("Audit"),
    @XmlEnumValue("Web")
    WEB("Web");
    private final String value;

    AxdEnumCaseCategoryType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumCaseCategoryType fromValue(String v) {
        for (AxdEnumCaseCategoryType c: AxdEnumCaseCategoryType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
