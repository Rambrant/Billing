
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_ReturnStatusLine.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_ReturnStatusLine">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Awaiting"/>
 *     &lt;enumeration value="Registered"/>
 *     &lt;enumeration value="Quarantine"/>
 *     &lt;enumeration value="Received"/>
 *     &lt;enumeration value="Invoiced"/>
 *     &lt;enumeration value="Canceled"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_ReturnStatusLine")
@XmlEnum
public enum AxdEnumReturnStatusLine {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Awaiting")
    AWAITING("Awaiting"),
    @XmlEnumValue("Registered")
    REGISTERED("Registered"),
    @XmlEnumValue("Quarantine")
    QUARANTINE("Quarantine"),
    @XmlEnumValue("Received")
    RECEIVED("Received"),
    @XmlEnumValue("Invoiced")
    INVOICED("Invoiced"),
    @XmlEnumValue("Canceled")
    CANCELED("Canceled");
    private final String value;

    AxdEnumReturnStatusLine(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumReturnStatusLine fromValue(String v) {
        for (AxdEnumReturnStatusLine c: AxdEnumReturnStatusLine.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
