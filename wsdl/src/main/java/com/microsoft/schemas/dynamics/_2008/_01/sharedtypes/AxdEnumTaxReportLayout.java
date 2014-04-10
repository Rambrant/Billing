
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_TaxReportLayout.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_TaxReportLayout">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Default"/>
 *     &lt;enumeration value="Norway"/>
 *     &lt;enumeration value="UnitedKingdom"/>
 *     &lt;enumeration value="Sweden"/>
 *     &lt;enumeration value="Germany"/>
 *     &lt;enumeration value="Austria"/>
 *     &lt;enumeration value="Netherlands"/>
 *     &lt;enumeration value="USA"/>
 *     &lt;enumeration value="Italy"/>
 *     &lt;enumeration value="Belgium"/>
 *     &lt;enumeration value="Singapore"/>
 *     &lt;enumeration value="Finland"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_TaxReportLayout")
@XmlEnum
public enum AxdEnumTaxReportLayout {

    @XmlEnumValue("Default")
    DEFAULT("Default"),
    @XmlEnumValue("Norway")
    NORWAY("Norway"),
    @XmlEnumValue("UnitedKingdom")
    UNITED_KINGDOM("UnitedKingdom"),
    @XmlEnumValue("Sweden")
    SWEDEN("Sweden"),
    @XmlEnumValue("Germany")
    GERMANY("Germany"),
    @XmlEnumValue("Austria")
    AUSTRIA("Austria"),
    @XmlEnumValue("Netherlands")
    NETHERLANDS("Netherlands"),
    USA("USA"),
    @XmlEnumValue("Italy")
    ITALY("Italy"),
    @XmlEnumValue("Belgium")
    BELGIUM("Belgium"),
    @XmlEnumValue("Singapore")
    SINGAPORE("Singapore"),
    @XmlEnumValue("Finland")
    FINLAND("Finland");
    private final String value;

    AxdEnumTaxReportLayout(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumTaxReportLayout fromValue(String v) {
        for (AxdEnumTaxReportLayout c: AxdEnumTaxReportLayout.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
