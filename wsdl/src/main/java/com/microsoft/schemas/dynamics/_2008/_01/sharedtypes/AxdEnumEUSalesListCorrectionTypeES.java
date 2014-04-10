
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_EUSalesListCorrectionType_ES.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_EUSalesListCorrectionType_ES">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Complementary"/>
 *     &lt;enumeration value="Replacement"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_EUSalesListCorrectionType_ES")
@XmlEnum
public enum AxdEnumEUSalesListCorrectionTypeES {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Complementary")
    COMPLEMENTARY("Complementary"),
    @XmlEnumValue("Replacement")
    REPLACEMENT("Replacement");
    private final String value;

    AxdEnumEUSalesListCorrectionTypeES(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumEUSalesListCorrectionTypeES fromValue(String v) {
        for (AxdEnumEUSalesListCorrectionTypeES c: AxdEnumEUSalesListCorrectionTypeES.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
