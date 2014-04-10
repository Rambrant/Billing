
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_BarcodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_BarcodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NoBarcode"/>
 *     &lt;enumeration value="EAN128"/>
 *     &lt;enumeration value="Code39"/>
 *     &lt;enumeration value="Interleaved2of5"/>
 *     &lt;enumeration value="Code128"/>
 *     &lt;enumeration value="UPCA"/>
 *     &lt;enumeration value="UPCE"/>
 *     &lt;enumeration value="EAN13"/>
 *     &lt;enumeration value="EAN8"/>
 *     &lt;enumeration value="PDF417"/>
 *     &lt;enumeration value="Maxicode"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_BarcodeType")
@XmlEnum
public enum AxdEnumBarcodeType {

    @XmlEnumValue("NoBarcode")
    NO_BARCODE("NoBarcode"),
    @XmlEnumValue("EAN128")
    EAN_128("EAN128"),
    @XmlEnumValue("Code39")
    CODE_39("Code39"),
    @XmlEnumValue("Interleaved2of5")
    INTERLEAVED_2_OF_5("Interleaved2of5"),
    @XmlEnumValue("Code128")
    CODE_128("Code128"),
    UPCA("UPCA"),
    UPCE("UPCE"),
    @XmlEnumValue("EAN13")
    EAN_13("EAN13"),
    @XmlEnumValue("EAN8")
    EAN_8("EAN8"),
    @XmlEnumValue("PDF417")
    PDF_417("PDF417"),
    @XmlEnumValue("Maxicode")
    MAXICODE("Maxicode");
    private final String value;

    AxdEnumBarcodeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumBarcodeType fromValue(String v) {
        for (AxdEnumBarcodeType c: AxdEnumBarcodeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
