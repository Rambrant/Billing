
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_BOMFormula.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_BOMFormula">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Formula0"/>
 *     &lt;enumeration value="Formula1"/>
 *     &lt;enumeration value="Formula2"/>
 *     &lt;enumeration value="Formula3"/>
 *     &lt;enumeration value="Formula4"/>
 *     &lt;enumeration value="Formula5"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_BOMFormula")
@XmlEnum
public enum AxdEnumBOMFormula {

    @XmlEnumValue("Formula0")
    FORMULA_0("Formula0"),
    @XmlEnumValue("Formula1")
    FORMULA_1("Formula1"),
    @XmlEnumValue("Formula2")
    FORMULA_2("Formula2"),
    @XmlEnumValue("Formula3")
    FORMULA_3("Formula3"),
    @XmlEnumValue("Formula4")
    FORMULA_4("Formula4"),
    @XmlEnumValue("Formula5")
    FORMULA_5("Formula5");
    private final String value;

    AxdEnumBOMFormula(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumBOMFormula fromValue(String v) {
        for (AxdEnumBOMFormula c: AxdEnumBOMFormula.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
