
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_CustBillOfExchangeStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_CustBillOfExchangeStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Drawn"/>
 *     &lt;enumeration value="Redrawn"/>
 *     &lt;enumeration value="Protested"/>
 *     &lt;enumeration value="Honored"/>
 *     &lt;enumeration value="Remitted"/>
 *     &lt;enumeration value="Invoiced"/>
 *     &lt;enumeration value="InvoiceRemitted"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_CustBillOfExchangeStatus")
@XmlEnum
public enum AxdExtTypeCustBillOfExchangeStatus {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Drawn")
    DRAWN("Drawn"),
    @XmlEnumValue("Redrawn")
    REDRAWN("Redrawn"),
    @XmlEnumValue("Protested")
    PROTESTED("Protested"),
    @XmlEnumValue("Honored")
    HONORED("Honored"),
    @XmlEnumValue("Remitted")
    REMITTED("Remitted"),
    @XmlEnumValue("Invoiced")
    INVOICED("Invoiced"),
    @XmlEnumValue("InvoiceRemitted")
    INVOICE_REMITTED("InvoiceRemitted");
    private final String value;

    AxdExtTypeCustBillOfExchangeStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypeCustBillOfExchangeStatus fromValue(String v) {
        for (AxdExtTypeCustBillOfExchangeStatus c: AxdExtTypeCustBillOfExchangeStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
