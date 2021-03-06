
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_smmCreateActivity.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_smmCreateActivity">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Yes"/>
 *     &lt;enumeration value="No"/>
 *     &lt;enumeration value="Prompt"/>
 *     &lt;enumeration value="AdvancedPrompt"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_smmCreateActivity")
@XmlEnum
public enum AxdEnumSmmCreateActivity {

    @XmlEnumValue("Yes")
    YES("Yes"),
    @XmlEnumValue("No")
    NO("No"),
    @XmlEnumValue("Prompt")
    PROMPT("Prompt"),
    @XmlEnumValue("AdvancedPrompt")
    ADVANCED_PROMPT("AdvancedPrompt");
    private final String value;

    AxdEnumSmmCreateActivity(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumSmmCreateActivity fromValue(String v) {
        for (AxdEnumSmmCreateActivity c: AxdEnumSmmCreateActivity.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
