
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_AccountingDistributionReferenceRole.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_AccountingDistributionReferenceRole">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Reversing"/>
 *     &lt;enumeration value="Adjusting"/>
 *     &lt;enumeration value="Matching"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_AccountingDistributionReferenceRole")
@XmlEnum
public enum AxdEnumAccountingDistributionReferenceRole {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Reversing")
    REVERSING("Reversing"),
    @XmlEnumValue("Adjusting")
    ADJUSTING("Adjusting"),
    @XmlEnumValue("Matching")
    MATCHING("Matching");
    private final String value;

    AxdEnumAccountingDistributionReferenceRole(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumAccountingDistributionReferenceRole fromValue(String v) {
        for (AxdEnumAccountingDistributionReferenceRole c: AxdEnumAccountingDistributionReferenceRole.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
