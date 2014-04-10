
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_TaxModuleTypeId.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_TaxModuleTypeId">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Sales"/>
 *     &lt;enumeration value="Purch"/>
 *     &lt;enumeration value="Voucher"/>
 *     &lt;enumeration value="SalesInvoice"/>
 *     &lt;enumeration value="PurchInvoice"/>
 *     &lt;enumeration value="FreeTxtInvoice"/>
 *     &lt;enumeration value="CustCollectionLetter"/>
 *     &lt;enumeration value="Tax"/>
 *     &lt;enumeration value="CustInterestNote"/>
 *     &lt;enumeration value="Project"/>
 *     &lt;enumeration value="ProjectInvoice"/>
 *     &lt;enumeration value="BankAccountReconcile"/>
 *     &lt;enumeration value="Retail"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_TaxModuleTypeId")
@XmlEnum
public enum AxdExtTypeTaxModuleTypeId {

    @XmlEnumValue("Sales")
    SALES("Sales"),
    @XmlEnumValue("Purch")
    PURCH("Purch"),
    @XmlEnumValue("Voucher")
    VOUCHER("Voucher"),
    @XmlEnumValue("SalesInvoice")
    SALES_INVOICE("SalesInvoice"),
    @XmlEnumValue("PurchInvoice")
    PURCH_INVOICE("PurchInvoice"),
    @XmlEnumValue("FreeTxtInvoice")
    FREE_TXT_INVOICE("FreeTxtInvoice"),
    @XmlEnumValue("CustCollectionLetter")
    CUST_COLLECTION_LETTER("CustCollectionLetter"),
    @XmlEnumValue("Tax")
    TAX("Tax"),
    @XmlEnumValue("CustInterestNote")
    CUST_INTEREST_NOTE("CustInterestNote"),
    @XmlEnumValue("Project")
    PROJECT("Project"),
    @XmlEnumValue("ProjectInvoice")
    PROJECT_INVOICE("ProjectInvoice"),
    @XmlEnumValue("BankAccountReconcile")
    BANK_ACCOUNT_RECONCILE("BankAccountReconcile"),
    @XmlEnumValue("Retail")
    RETAIL("Retail");
    private final String value;

    AxdExtTypeTaxModuleTypeId(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypeTaxModuleTypeId fromValue(String v) {
        for (AxdExtTypeTaxModuleTypeId c: AxdExtTypeTaxModuleTypeId.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
