
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_AssetTransTypePurchEDT.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_AssetTransTypePurchEDT">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Acquisition"/>
 *     &lt;enumeration value="AcquisitionAdj"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_AssetTransTypePurchEDT")
@XmlEnum
public enum AxdExtTypeAssetTransTypePurchEDT {

    @XmlEnumValue("Acquisition")
    ACQUISITION("Acquisition"),
    @XmlEnumValue("AcquisitionAdj")
    ACQUISITION_ADJ("AcquisitionAdj");
    private final String value;

    AxdExtTypeAssetTransTypePurchEDT(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypeAssetTransTypePurchEDT fromValue(String v) {
        for (AxdExtTypeAssetTransTypePurchEDT c: AxdExtTypeAssetTransTypePurchEDT.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
