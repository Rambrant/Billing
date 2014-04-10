
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_ReturnStatusHeader.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_ReturnStatusHeader">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Created"/>
 *     &lt;enumeration value="Open"/>
 *     &lt;enumeration value="Canceled"/>
 *     &lt;enumeration value="Closed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_ReturnStatusHeader")
@XmlEnum
public enum AxdEnumReturnStatusHeader {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Created")
    CREATED("Created"),
    @XmlEnumValue("Open")
    OPEN("Open"),
    @XmlEnumValue("Canceled")
    CANCELED("Canceled"),
    @XmlEnumValue("Closed")
    CLOSED("Closed");
    private final String value;

    AxdEnumReturnStatusHeader(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumReturnStatusHeader fromValue(String v) {
        for (AxdEnumReturnStatusHeader c: AxdEnumReturnStatusHeader.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
