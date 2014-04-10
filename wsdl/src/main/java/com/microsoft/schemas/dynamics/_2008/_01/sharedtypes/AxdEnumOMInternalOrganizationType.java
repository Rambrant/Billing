
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_OMInternalOrganizationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_OMInternalOrganizationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="LegalEntity"/>
 *     &lt;enumeration value="OperatingUnit"/>
 *     &lt;enumeration value="Team"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_OMInternalOrganizationType")
@XmlEnum
public enum AxdEnumOMInternalOrganizationType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("LegalEntity")
    LEGAL_ENTITY("LegalEntity"),
    @XmlEnumValue("OperatingUnit")
    OPERATING_UNIT("OperatingUnit"),
    @XmlEnumValue("Team")
    TEAM("Team");
    private final String value;

    AxdEnumOMInternalOrganizationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumOMInternalOrganizationType fromValue(String v) {
        for (AxdEnumOMInternalOrganizationType c: AxdEnumOMInternalOrganizationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
