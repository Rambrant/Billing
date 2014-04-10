
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_ListcodeId.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_ListcodeId">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IncludeNot"/>
 *     &lt;enumeration value="EUTrade"/>
 *     &lt;enumeration value="ProductionOnToll"/>
 *     &lt;enumeration value="TriangularEUTrade"/>
 *     &lt;enumeration value="TriangularProductionOnToll"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_ListcodeId")
@XmlEnum
public enum AxdExtTypeListcodeId {

    @XmlEnumValue("IncludeNot")
    INCLUDE_NOT("IncludeNot"),
    @XmlEnumValue("EUTrade")
    EU_TRADE("EUTrade"),
    @XmlEnumValue("ProductionOnToll")
    PRODUCTION_ON_TOLL("ProductionOnToll"),
    @XmlEnumValue("TriangularEUTrade")
    TRIANGULAR_EU_TRADE("TriangularEUTrade"),
    @XmlEnumValue("TriangularProductionOnToll")
    TRIANGULAR_PRODUCTION_ON_TOLL("TriangularProductionOnToll");
    private final String value;

    AxdExtTypeListcodeId(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypeListcodeId fromValue(String v) {
        for (AxdExtTypeListcodeId c: AxdExtTypeListcodeId.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
