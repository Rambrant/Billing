
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_ReverseChargeApplies_UK.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_ReverseChargeApplies_UK">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="No"/>
 *     &lt;enumeration value="Yes"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_ReverseChargeApplies_UK")
@XmlEnum
public enum AxdExtTypeReverseChargeAppliesUK {

    @XmlEnumValue("No")
    NO("No"),
    @XmlEnumValue("Yes")
    YES("Yes");
    private final String value;

    AxdExtTypeReverseChargeAppliesUK(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypeReverseChargeAppliesUK fromValue(String v) {
        for (AxdExtTypeReverseChargeAppliesUK c: AxdExtTypeReverseChargeAppliesUK.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
