
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_ECPsalesOrdersViewType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_ECPsalesOrdersViewType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="WebEntered"/>
 *     &lt;enumeration value="All"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_ECPsalesOrdersViewType")
@XmlEnum
public enum AxdEnumECPsalesOrdersViewType {

    @XmlEnumValue("WebEntered")
    WEB_ENTERED("WebEntered"),
    @XmlEnumValue("All")
    ALL("All");
    private final String value;

    AxdEnumECPsalesOrdersViewType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumECPsalesOrdersViewType fromValue(String v) {
        for (AxdEnumECPsalesOrdersViewType c: AxdEnumECPsalesOrdersViewType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
