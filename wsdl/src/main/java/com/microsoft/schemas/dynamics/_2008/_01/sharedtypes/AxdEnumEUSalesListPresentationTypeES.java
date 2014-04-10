
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_EUSalesListPresentationType_ES.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_EUSalesListPresentationType_ES">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Telematic"/>
 *     &lt;enumeration value="DVD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_EUSalesListPresentationType_ES")
@XmlEnum
public enum AxdEnumEUSalesListPresentationTypeES {

    @XmlEnumValue("Telematic")
    TELEMATIC("Telematic"),
    DVD("DVD");
    private final String value;

    AxdEnumEUSalesListPresentationTypeES(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumEUSalesListPresentationTypeES fromValue(String v) {
        for (AxdEnumEUSalesListPresentationTypeES c: AxdEnumEUSalesListPresentationTypeES.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
