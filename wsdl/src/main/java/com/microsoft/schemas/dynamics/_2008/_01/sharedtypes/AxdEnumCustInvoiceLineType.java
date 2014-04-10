
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_CustInvoiceLineType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_CustInvoiceLineType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Customer"/>
 *     &lt;enumeration value="MarkupTrans"/>
 *     &lt;enumeration value="InterestNote"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_CustInvoiceLineType")
@XmlEnum
public enum AxdEnumCustInvoiceLineType {

    @XmlEnumValue("Customer")
    CUSTOMER("Customer"),
    @XmlEnumValue("MarkupTrans")
    MARKUP_TRANS("MarkupTrans"),
    @XmlEnumValue("InterestNote")
    INTEREST_NOTE("InterestNote");
    private final String value;

    AxdEnumCustInvoiceLineType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumCustInvoiceLineType fromValue(String v) {
        for (AxdEnumCustInvoiceLineType c: AxdEnumCustInvoiceLineType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
