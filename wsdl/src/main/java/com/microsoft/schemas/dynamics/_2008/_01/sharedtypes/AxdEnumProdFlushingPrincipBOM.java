
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_ProdFlushingPrincipBOM.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_ProdFlushingPrincipBOM">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Blank"/>
 *     &lt;enumeration value="Start"/>
 *     &lt;enumeration value="Finish"/>
 *     &lt;enumeration value="Manual"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_ProdFlushingPrincipBOM")
@XmlEnum
public enum AxdEnumProdFlushingPrincipBOM {

    @XmlEnumValue("Blank")
    BLANK("Blank"),
    @XmlEnumValue("Start")
    START("Start"),
    @XmlEnumValue("Finish")
    FINISH("Finish"),
    @XmlEnumValue("Manual")
    MANUAL("Manual");
    private final String value;

    AxdEnumProdFlushingPrincipBOM(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumProdFlushingPrincipBOM fromValue(String v) {
        for (AxdEnumProdFlushingPrincipBOM c: AxdEnumProdFlushingPrincipBOM.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
