
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_MarkupCategoryType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_MarkupCategoryType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Fixed"/>
 *     &lt;enumeration value="Pcs"/>
 *     &lt;enumeration value="Percent"/>
 *     &lt;enumeration value="InterCompanyPercent"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_MarkupCategoryType")
@XmlEnum
public enum AxdExtTypeMarkupCategoryType {

    @XmlEnumValue("Fixed")
    FIXED("Fixed"),
    @XmlEnumValue("Pcs")
    PCS("Pcs"),
    @XmlEnumValue("Percent")
    PERCENT("Percent"),
    @XmlEnumValue("InterCompanyPercent")
    INTER_COMPANY_PERCENT("InterCompanyPercent");
    private final String value;

    AxdExtTypeMarkupCategoryType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypeMarkupCategoryType fromValue(String v) {
        for (AxdExtTypeMarkupCategoryType c: AxdExtTypeMarkupCategoryType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
