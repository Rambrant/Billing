
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_BOMRoundUp.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_BOMRoundUp">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="No"/>
 *     &lt;enumeration value="Qty"/>
 *     &lt;enumeration value="MeasureConfig"/>
 *     &lt;enumeration value="Consumption"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_BOMRoundUp")
@XmlEnum
public enum AxdEnumBOMRoundUp {

    @XmlEnumValue("No")
    NO("No"),
    @XmlEnumValue("Qty")
    QTY("Qty"),
    @XmlEnumValue("MeasureConfig")
    MEASURE_CONFIG("MeasureConfig"),
    @XmlEnumValue("Consumption")
    CONSUMPTION("Consumption");
    private final String value;

    AxdEnumBOMRoundUp(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumBOMRoundUp fromValue(String v) {
        for (AxdEnumBOMRoundUp c: AxdEnumBOMRoundUp.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
