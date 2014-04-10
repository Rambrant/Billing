
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_EcoResCategoryChangeStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_EcoResCategoryChangeStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NoChange"/>
 *     &lt;enumeration value="Changed"/>
 *     &lt;enumeration value="NewlyAdded"/>
 *     &lt;enumeration value="NoLongerValid"/>
 *     &lt;enumeration value="NotApplicable"/>
 *     &lt;enumeration value="All"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_EcoResCategoryChangeStatus")
@XmlEnum
public enum AxdEnumEcoResCategoryChangeStatus {

    @XmlEnumValue("NoChange")
    NO_CHANGE("NoChange"),
    @XmlEnumValue("Changed")
    CHANGED("Changed"),
    @XmlEnumValue("NewlyAdded")
    NEWLY_ADDED("NewlyAdded"),
    @XmlEnumValue("NoLongerValid")
    NO_LONGER_VALID("NoLongerValid"),
    @XmlEnumValue("NotApplicable")
    NOT_APPLICABLE("NotApplicable"),
    @XmlEnumValue("All")
    ALL("All");
    private final String value;

    AxdEnumEcoResCategoryChangeStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumEcoResCategoryChangeStatus fromValue(String v) {
        for (AxdEnumEcoResCategoryChangeStatus c: AxdEnumEcoResCategoryChangeStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
