
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_CompanyType_MX.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_CompanyType_MX">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Blank"/>
 *     &lt;enumeration value="LegalEntity"/>
 *     &lt;enumeration value="LegalPerson"/>
 *     &lt;enumeration value="ForeignCompany"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_CompanyType_MX")
@XmlEnum
public enum AxdEnumCompanyTypeMX {

    @XmlEnumValue("Blank")
    BLANK("Blank"),
    @XmlEnumValue("LegalEntity")
    LEGAL_ENTITY("LegalEntity"),
    @XmlEnumValue("LegalPerson")
    LEGAL_PERSON("LegalPerson"),
    @XmlEnumValue("ForeignCompany")
    FOREIGN_COMPANY("ForeignCompany");
    private final String value;

    AxdEnumCompanyTypeMX(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumCompanyTypeMX fromValue(String v) {
        for (AxdEnumCompanyTypeMX c: AxdEnumCompanyTypeMX.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
