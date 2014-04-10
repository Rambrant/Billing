
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_InventFiscalLIFONormalValueCalc.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_InventFiscalLIFONormalValueCalc">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Never"/>
 *     &lt;enumeration value="Manual"/>
 *     &lt;enumeration value="Automatic"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_InventFiscalLIFONormalValueCalc")
@XmlEnum
public enum AxdEnumInventFiscalLIFONormalValueCalc {

    @XmlEnumValue("Never")
    NEVER("Never"),
    @XmlEnumValue("Manual")
    MANUAL("Manual"),
    @XmlEnumValue("Automatic")
    AUTOMATIC("Automatic");
    private final String value;

    AxdEnumInventFiscalLIFONormalValueCalc(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumInventFiscalLIFONormalValueCalc fromValue(String v) {
        for (AxdEnumInventFiscalLIFONormalValueCalc c: AxdEnumInventFiscalLIFONormalValueCalc.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
