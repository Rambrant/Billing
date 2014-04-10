
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_MDS_SalesInvoiceRuleDeviatingExchRate.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_MDS_SalesInvoiceRuleDeviatingExchRate">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="No"/>
 *     &lt;enumeration value="Yes"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_MDS_SalesInvoiceRuleDeviatingExchRate")
@XmlEnum
public enum AxdExtTypeMDSSalesInvoiceRuleDeviatingExchRate {

    @XmlEnumValue("No")
    NO("No"),
    @XmlEnumValue("Yes")
    YES("Yes");
    private final String value;

    AxdExtTypeMDSSalesInvoiceRuleDeviatingExchRate(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypeMDSSalesInvoiceRuleDeviatingExchRate fromValue(String v) {
        for (AxdExtTypeMDSSalesInvoiceRuleDeviatingExchRate c: AxdExtTypeMDSSalesInvoiceRuleDeviatingExchRate.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
