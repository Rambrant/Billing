
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_FormTextType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_FormTextType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="LedgerCompanyFrontpage"/>
 *     &lt;enumeration value="LedgerAuditorReport"/>
 *     &lt;enumeration value="LedgerStatement"/>
 *     &lt;enumeration value="LedgerAccountingPrinciples"/>
 *     &lt;enumeration value="LedgerNotes"/>
 *     &lt;enumeration value="CustInvoice"/>
 *     &lt;enumeration value="CustCreditNote"/>
 *     &lt;enumeration value="CustACStatement"/>
 *     &lt;enumeration value="CustACStatementExt"/>
 *     &lt;enumeration value="CustInterestNote"/>
 *     &lt;enumeration value="CustCollectionLetter1"/>
 *     &lt;enumeration value="CustCollectionLetter2"/>
 *     &lt;enumeration value="CustCollectionLetter3"/>
 *     &lt;enumeration value="CustCollectionLetter4"/>
 *     &lt;enumeration value="CustCollectionLetter5"/>
 *     &lt;enumeration value="Vendor"/>
 *     &lt;enumeration value="VendACStatement"/>
 *     &lt;enumeration value="SalesQuotation"/>
 *     &lt;enumeration value="SalesConfirmation"/>
 *     &lt;enumeration value="SalesPackingSlip"/>
 *     &lt;enumeration value="SalesInvoice"/>
 *     &lt;enumeration value="SalesCreditNote"/>
 *     &lt;enumeration value="PurchPurchaseOrder"/>
 *     &lt;enumeration value="Invent"/>
 *     &lt;enumeration value="ProjectQuotation"/>
 *     &lt;enumeration value="ProjectConfirmation"/>
 *     &lt;enumeration value="ProjectPackingSlip"/>
 *     &lt;enumeration value="ProjectInvoice"/>
 *     &lt;enumeration value="ProjectAcontoInvoice"/>
 *     &lt;enumeration value="ProjectCreditNote"/>
 *     &lt;enumeration value="PayRoll"/>
 *     &lt;enumeration value="HRMCourseConfirmation"/>
 *     &lt;enumeration value="HRMCourse"/>
 *     &lt;enumeration value="ReturnSendDocument"/>
 *     &lt;enumeration value="ReturnAcknowledgement"/>
 *     &lt;enumeration value="PurchRFQ"/>
 *     &lt;enumeration value="PurchRFQAccept"/>
 *     &lt;enumeration value="PurchRFQReject"/>
 *     &lt;enumeration value="RBOReceipt"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_FormTextType")
@XmlEnum
public enum AxdEnumFormTextType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("LedgerCompanyFrontpage")
    LEDGER_COMPANY_FRONTPAGE("LedgerCompanyFrontpage"),
    @XmlEnumValue("LedgerAuditorReport")
    LEDGER_AUDITOR_REPORT("LedgerAuditorReport"),
    @XmlEnumValue("LedgerStatement")
    LEDGER_STATEMENT("LedgerStatement"),
    @XmlEnumValue("LedgerAccountingPrinciples")
    LEDGER_ACCOUNTING_PRINCIPLES("LedgerAccountingPrinciples"),
    @XmlEnumValue("LedgerNotes")
    LEDGER_NOTES("LedgerNotes"),
    @XmlEnumValue("CustInvoice")
    CUST_INVOICE("CustInvoice"),
    @XmlEnumValue("CustCreditNote")
    CUST_CREDIT_NOTE("CustCreditNote"),
    @XmlEnumValue("CustACStatement")
    CUST_AC_STATEMENT("CustACStatement"),
    @XmlEnumValue("CustACStatementExt")
    CUST_AC_STATEMENT_EXT("CustACStatementExt"),
    @XmlEnumValue("CustInterestNote")
    CUST_INTEREST_NOTE("CustInterestNote"),
    @XmlEnumValue("CustCollectionLetter1")
    CUST_COLLECTION_LETTER_1("CustCollectionLetter1"),
    @XmlEnumValue("CustCollectionLetter2")
    CUST_COLLECTION_LETTER_2("CustCollectionLetter2"),
    @XmlEnumValue("CustCollectionLetter3")
    CUST_COLLECTION_LETTER_3("CustCollectionLetter3"),
    @XmlEnumValue("CustCollectionLetter4")
    CUST_COLLECTION_LETTER_4("CustCollectionLetter4"),
    @XmlEnumValue("CustCollectionLetter5")
    CUST_COLLECTION_LETTER_5("CustCollectionLetter5"),
    @XmlEnumValue("Vendor")
    VENDOR("Vendor"),
    @XmlEnumValue("VendACStatement")
    VEND_AC_STATEMENT("VendACStatement"),
    @XmlEnumValue("SalesQuotation")
    SALES_QUOTATION("SalesQuotation"),
    @XmlEnumValue("SalesConfirmation")
    SALES_CONFIRMATION("SalesConfirmation"),
    @XmlEnumValue("SalesPackingSlip")
    SALES_PACKING_SLIP("SalesPackingSlip"),
    @XmlEnumValue("SalesInvoice")
    SALES_INVOICE("SalesInvoice"),
    @XmlEnumValue("SalesCreditNote")
    SALES_CREDIT_NOTE("SalesCreditNote"),
    @XmlEnumValue("PurchPurchaseOrder")
    PURCH_PURCHASE_ORDER("PurchPurchaseOrder"),
    @XmlEnumValue("Invent")
    INVENT("Invent"),
    @XmlEnumValue("ProjectQuotation")
    PROJECT_QUOTATION("ProjectQuotation"),
    @XmlEnumValue("ProjectConfirmation")
    PROJECT_CONFIRMATION("ProjectConfirmation"),
    @XmlEnumValue("ProjectPackingSlip")
    PROJECT_PACKING_SLIP("ProjectPackingSlip"),
    @XmlEnumValue("ProjectInvoice")
    PROJECT_INVOICE("ProjectInvoice"),
    @XmlEnumValue("ProjectAcontoInvoice")
    PROJECT_ACONTO_INVOICE("ProjectAcontoInvoice"),
    @XmlEnumValue("ProjectCreditNote")
    PROJECT_CREDIT_NOTE("ProjectCreditNote"),
    @XmlEnumValue("PayRoll")
    PAY_ROLL("PayRoll"),
    @XmlEnumValue("HRMCourseConfirmation")
    HRM_COURSE_CONFIRMATION("HRMCourseConfirmation"),
    @XmlEnumValue("HRMCourse")
    HRM_COURSE("HRMCourse"),
    @XmlEnumValue("ReturnSendDocument")
    RETURN_SEND_DOCUMENT("ReturnSendDocument"),
    @XmlEnumValue("ReturnAcknowledgement")
    RETURN_ACKNOWLEDGEMENT("ReturnAcknowledgement"),
    @XmlEnumValue("PurchRFQ")
    PURCH_RFQ("PurchRFQ"),
    @XmlEnumValue("PurchRFQAccept")
    PURCH_RFQ_ACCEPT("PurchRFQAccept"),
    @XmlEnumValue("PurchRFQReject")
    PURCH_RFQ_REJECT("PurchRFQReject"),
    @XmlEnumValue("RBOReceipt")
    RBO_RECEIPT("RBOReceipt");
    private final String value;

    AxdEnumFormTextType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumFormTextType fromValue(String v) {
        for (AxdEnumFormTextType c: AxdEnumFormTextType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
