
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_MDS_SalesMessageSourceType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_MDS_SalesMessageSourceType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Customer"/>
 *     &lt;enumeration value="Company"/>
 *     &lt;enumeration value="InvoiceRule"/>
 *     &lt;enumeration value="InvoiceRulePurchaseOrder"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_MDS_SalesMessageSourceType")
@XmlEnum
public enum AxdEnumMDSSalesMessageSourceType {

    @XmlEnumValue("Customer")
    CUSTOMER("Customer"),
    @XmlEnumValue("Company")
    COMPANY("Company"),
    @XmlEnumValue("InvoiceRule")
    INVOICE_RULE("InvoiceRule"),
    @XmlEnumValue("InvoiceRulePurchaseOrder")
    INVOICE_RULE_PURCHASE_ORDER("InvoiceRulePurchaseOrder");
    private final String value;

    AxdEnumMDSSalesMessageSourceType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumMDSSalesMessageSourceType fromValue(String v) {
        for (AxdEnumMDSSalesMessageSourceType c: AxdEnumMDSSalesMessageSourceType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
