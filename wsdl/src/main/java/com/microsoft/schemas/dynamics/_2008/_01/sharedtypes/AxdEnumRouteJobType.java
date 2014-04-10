
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_RouteJobType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_RouteJobType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="QueueBefore"/>
 *     &lt;enumeration value="Setup"/>
 *     &lt;enumeration value="Process"/>
 *     &lt;enumeration value="Overlap"/>
 *     &lt;enumeration value="Transport"/>
 *     &lt;enumeration value="QueueAfter"/>
 *     &lt;enumeration value="Burden"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_RouteJobType")
@XmlEnum
public enum AxdEnumRouteJobType {

    @XmlEnumValue("QueueBefore")
    QUEUE_BEFORE("QueueBefore"),
    @XmlEnumValue("Setup")
    SETUP("Setup"),
    @XmlEnumValue("Process")
    PROCESS("Process"),
    @XmlEnumValue("Overlap")
    OVERLAP("Overlap"),
    @XmlEnumValue("Transport")
    TRANSPORT("Transport"),
    @XmlEnumValue("QueueAfter")
    QUEUE_AFTER("QueueAfter"),
    @XmlEnumValue("Burden")
    BURDEN("Burden");
    private final String value;

    AxdEnumRouteJobType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumRouteJobType fromValue(String v) {
        for (AxdEnumRouteJobType c: AxdEnumRouteJobType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
