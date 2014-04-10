
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_GSTHSTTaxType_CA.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_GSTHSTTaxType_CA">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Rebates111"/>
 *     &lt;enumeration value="TaxOnAcquisition205"/>
 *     &lt;enumeration value="SelfAssessment405"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_GSTHSTTaxType_CA")
@XmlEnum
public enum AxdEnumGSTHSTTaxTypeCA {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Rebates111")
    REBATES_111("Rebates111"),
    @XmlEnumValue("TaxOnAcquisition205")
    TAX_ON_ACQUISITION_205("TaxOnAcquisition205"),
    @XmlEnumValue("SelfAssessment405")
    SELF_ASSESSMENT_405("SelfAssessment405");
    private final String value;

    AxdEnumGSTHSTTaxTypeCA(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumGSTHSTTaxTypeCA fromValue(String v) {
        for (AxdEnumGSTHSTTaxTypeCA c: AxdEnumGSTHSTTaxTypeCA.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
