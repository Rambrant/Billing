
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_TaxWithholdVendorType_TH.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_TaxWithholdVendorType_TH">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Blank"/>
 *     &lt;enumeration value="Domestic"/>
 *     &lt;enumeration value="Foreign"/>
 *     &lt;enumeration value="Individual"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_TaxWithholdVendorType_TH")
@XmlEnum
public enum AxdEnumTaxWithholdVendorTypeTH {

    @XmlEnumValue("Blank")
    BLANK("Blank"),
    @XmlEnumValue("Domestic")
    DOMESTIC("Domestic"),
    @XmlEnumValue("Foreign")
    FOREIGN("Foreign"),
    @XmlEnumValue("Individual")
    INDIVIDUAL("Individual");
    private final String value;

    AxdEnumTaxWithholdVendorTypeTH(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumTaxWithholdVendorTypeTH fromValue(String v) {
        for (AxdEnumTaxWithholdVendorTypeTH c: AxdEnumTaxWithholdVendorTypeTH.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
