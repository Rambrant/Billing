
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_WMSExpeditionStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_WMSExpeditionStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Registered"/>
 *     &lt;enumeration value="DEL_Reserved"/>
 *     &lt;enumeration value="Activated"/>
 *     &lt;enumeration value="Started"/>
 *     &lt;enumeration value="Picked"/>
 *     &lt;enumeration value="Staged"/>
 *     &lt;enumeration value="Loaded"/>
 *     &lt;enumeration value="Complete"/>
 *     &lt;enumeration value="Cancelled"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_WMSExpeditionStatus")
@XmlEnum
public enum AxdEnumWMSExpeditionStatus {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Registered")
    REGISTERED("Registered"),
    @XmlEnumValue("DEL_Reserved")
    DEL_RESERVED("DEL_Reserved"),
    @XmlEnumValue("Activated")
    ACTIVATED("Activated"),
    @XmlEnumValue("Started")
    STARTED("Started"),
    @XmlEnumValue("Picked")
    PICKED("Picked"),
    @XmlEnumValue("Staged")
    STAGED("Staged"),
    @XmlEnumValue("Loaded")
    LOADED("Loaded"),
    @XmlEnumValue("Complete")
    COMPLETE("Complete"),
    @XmlEnumValue("Cancelled")
    CANCELLED("Cancelled");
    private final String value;

    AxdEnumWMSExpeditionStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumWMSExpeditionStatus fromValue(String v) {
        for (AxdEnumWMSExpeditionStatus c: AxdEnumWMSExpeditionStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
