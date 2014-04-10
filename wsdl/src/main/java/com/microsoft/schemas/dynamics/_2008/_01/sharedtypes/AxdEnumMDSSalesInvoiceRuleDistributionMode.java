
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_MDS_SalesInvoiceRuleDistributionMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_MDS_SalesInvoiceRuleDistributionMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Mail"/>
 *     &lt;enumeration value="Email"/>
 *     &lt;enumeration value="MailAndEmail"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_MDS_SalesInvoiceRuleDistributionMode")
@XmlEnum
public enum AxdEnumMDSSalesInvoiceRuleDistributionMode {

    @XmlEnumValue("Mail")
    MAIL("Mail"),
    @XmlEnumValue("Email")
    EMAIL("Email"),
    @XmlEnumValue("MailAndEmail")
    MAIL_AND_EMAIL("MailAndEmail");
    private final String value;

    AxdEnumMDSSalesInvoiceRuleDistributionMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumMDSSalesInvoiceRuleDistributionMode fromValue(String v) {
        for (AxdEnumMDSSalesInvoiceRuleDistributionMode c: AxdEnumMDSSalesInvoiceRuleDistributionMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
