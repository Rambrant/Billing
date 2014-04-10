
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_DirPartyIsLocationOwner.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_DirPartyIsLocationOwner">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="No"/>
 *     &lt;enumeration value="Yes"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_DirPartyIsLocationOwner")
@XmlEnum
public enum AxdExtTypeDirPartyIsLocationOwner {

    @XmlEnumValue("No")
    NO("No"),
    @XmlEnumValue("Yes")
    YES("Yes");
    private final String value;

    AxdExtTypeDirPartyIsLocationOwner(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypeDirPartyIsLocationOwner fromValue(String v) {
        for (AxdExtTypeDirPartyIsLocationOwner c: AxdExtTypeDirPartyIsLocationOwner.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
