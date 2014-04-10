
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_EcoResVariantConfigurationTechnologyType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_EcoResVariantConfigurationTechnologyType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PredefinedVariants"/>
 *     &lt;enumeration value="DimensionBased"/>
 *     &lt;enumeration value="RuleBased"/>
 *     &lt;enumeration value="ConstraintBased"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_EcoResVariantConfigurationTechnologyType")
@XmlEnum
public enum AxdEnumEcoResVariantConfigurationTechnologyType {

    @XmlEnumValue("PredefinedVariants")
    PREDEFINED_VARIANTS("PredefinedVariants"),
    @XmlEnumValue("DimensionBased")
    DIMENSION_BASED("DimensionBased"),
    @XmlEnumValue("RuleBased")
    RULE_BASED("RuleBased"),
    @XmlEnumValue("ConstraintBased")
    CONSTRAINT_BASED("ConstraintBased");
    private final String value;

    AxdEnumEcoResVariantConfigurationTechnologyType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumEcoResVariantConfigurationTechnologyType fromValue(String v) {
        for (AxdEnumEcoResVariantConfigurationTechnologyType c: AxdEnumEcoResVariantConfigurationTechnologyType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
