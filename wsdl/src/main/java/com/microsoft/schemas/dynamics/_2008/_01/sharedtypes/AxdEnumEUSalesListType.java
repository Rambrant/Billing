
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_EUSalesListType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_EUSalesListType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NotAssigned"/>
 *     &lt;enumeration value="Item"/>
 *     &lt;enumeration value="Service"/>
 *     &lt;enumeration value="Investment"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_EUSalesListType")
@XmlEnum
public enum AxdEnumEUSalesListType {

    @XmlEnumValue("NotAssigned")
    NOT_ASSIGNED("NotAssigned"),
    @XmlEnumValue("Item")
    ITEM("Item"),
    @XmlEnumValue("Service")
    SERVICE("Service"),
    @XmlEnumValue("Investment")
    INVESTMENT("Investment");
    private final String value;

    AxdEnumEUSalesListType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumEUSalesListType fromValue(String v) {
        for (AxdEnumEUSalesListType c: AxdEnumEUSalesListType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
