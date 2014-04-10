
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_PdsCopyBatchAttrib.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_PdsCopyBatchAttrib">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="No"/>
 *     &lt;enumeration value="Yes"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_PdsCopyBatchAttrib")
@XmlEnum
public enum AxdExtTypePdsCopyBatchAttrib {

    @XmlEnumValue("No")
    NO("No"),
    @XmlEnumValue("Yes")
    YES("Yes");
    private final String value;

    AxdExtTypePdsCopyBatchAttrib(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypePdsCopyBatchAttrib fromValue(String v) {
        for (AxdExtTypePdsCopyBatchAttrib c: AxdExtTypePdsCopyBatchAttrib.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
