//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.12.28 at 01:35:45 PM CET 
//


package com.tradedoubler.customerinvoice;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_DirPersonMaritalStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_DirPersonMaritalStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Single"/>
 *     &lt;enumeration value="Married"/>
 *     &lt;enumeration value="Divorced"/>
 *     &lt;enumeration value="Widowhood"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_DirPersonMaritalStatus")
@XmlEnum
public enum AxdEnumDirPersonMaritalStatus {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Single")
    SINGLE("Single"),
    @XmlEnumValue("Married")
    MARRIED("Married"),
    @XmlEnumValue("Divorced")
    DIVORCED("Divorced"),
    @XmlEnumValue("Widowhood")
    WIDOWHOOD("Widowhood");
    private final String value;

    AxdEnumDirPersonMaritalStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumDirPersonMaritalStatus fromValue(String v) {
        for (AxdEnumDirPersonMaritalStatus c: AxdEnumDirPersonMaritalStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
