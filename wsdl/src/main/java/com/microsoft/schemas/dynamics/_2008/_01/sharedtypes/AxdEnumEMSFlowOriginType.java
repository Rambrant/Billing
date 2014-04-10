
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_EMSFlowOriginType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_EMSFlowOriginType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Meter"/>
 *     &lt;enumeration value="Verification"/>
 *     &lt;enumeration value="InvoiceRegister"/>
 *     &lt;enumeration value="PurchaseOrder"/>
 *     &lt;enumeration value="Manual"/>
 *     &lt;enumeration value="Calculated"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_EMSFlowOriginType")
@XmlEnum
public enum AxdEnumEMSFlowOriginType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Meter")
    METER("Meter"),
    @XmlEnumValue("Verification")
    VERIFICATION("Verification"),
    @XmlEnumValue("InvoiceRegister")
    INVOICE_REGISTER("InvoiceRegister"),
    @XmlEnumValue("PurchaseOrder")
    PURCHASE_ORDER("PurchaseOrder"),
    @XmlEnumValue("Manual")
    MANUAL("Manual"),
    @XmlEnumValue("Calculated")
    CALCULATED("Calculated");
    private final String value;

    AxdEnumEMSFlowOriginType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumEMSFlowOriginType fromValue(String v) {
        for (AxdEnumEMSFlowOriginType c: AxdEnumEMSFlowOriginType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
