//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.12.28 at 01:35:45 PM CET 
//


package com.tradedoubler.customerinvoice;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_LedgerJournalType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_LedgerJournalType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Daily"/>
 *     &lt;enumeration value="Periodic"/>
 *     &lt;enumeration value="PurchaseLedger"/>
 *     &lt;enumeration value="Approval"/>
 *     &lt;enumeration value="Payment"/>
 *     &lt;enumeration value="CustPayment"/>
 *     &lt;enumeration value="Cost"/>
 *     &lt;enumeration value="VendInvoiceRegister"/>
 *     &lt;enumeration value="VendInvoicePool"/>
 *     &lt;enumeration value="VendInvoicePoolNotPosted"/>
 *     &lt;enumeration value="Assets"/>
 *     &lt;enumeration value="AssetBudgets"/>
 *     &lt;enumeration value="CustPaymRemittance"/>
 *     &lt;enumeration value="CustBillOfExchangeDraw"/>
 *     &lt;enumeration value="CustBillOfExchangeProtest"/>
 *     &lt;enumeration value="CustBillOfExchangeRedraw"/>
 *     &lt;enumeration value="VendPromissoryNoteDraw"/>
 *     &lt;enumeration value="CustBillOfExchangeAccept"/>
 *     &lt;enumeration value="VendPromissoryNoteRedraw"/>
 *     &lt;enumeration value="VendPaymRemittance"/>
 *     &lt;enumeration value="CustBillOfExchangeSettle"/>
 *     &lt;enumeration value="VendPromissoryNoteSettle"/>
 *     &lt;enumeration value="CostAccDaily"/>
 *     &lt;enumeration value="CostAccPeriodic"/>
 *     &lt;enumeration value="StatTrans"/>
 *     &lt;enumeration value="Allocation"/>
 *     &lt;enumeration value="Elimination"/>
 *     &lt;enumeration value="BankChequeReversal"/>
 *     &lt;enumeration value="BankDepositPaymCancel"/>
 *     &lt;enumeration value="Budget"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_LedgerJournalType")
@XmlEnum
public enum AxdEnumLedgerJournalType {

    @XmlEnumValue("Daily")
    DAILY("Daily"),
    @XmlEnumValue("Periodic")
    PERIODIC("Periodic"),
    @XmlEnumValue("PurchaseLedger")
    PURCHASE_LEDGER("PurchaseLedger"),
    @XmlEnumValue("Approval")
    APPROVAL("Approval"),
    @XmlEnumValue("Payment")
    PAYMENT("Payment"),
    @XmlEnumValue("CustPayment")
    CUST_PAYMENT("CustPayment"),
    @XmlEnumValue("Cost")
    COST("Cost"),
    @XmlEnumValue("VendInvoiceRegister")
    VEND_INVOICE_REGISTER("VendInvoiceRegister"),
    @XmlEnumValue("VendInvoicePool")
    VEND_INVOICE_POOL("VendInvoicePool"),
    @XmlEnumValue("VendInvoicePoolNotPosted")
    VEND_INVOICE_POOL_NOT_POSTED("VendInvoicePoolNotPosted"),
    @XmlEnumValue("Assets")
    ASSETS("Assets"),
    @XmlEnumValue("AssetBudgets")
    ASSET_BUDGETS("AssetBudgets"),
    @XmlEnumValue("CustPaymRemittance")
    CUST_PAYM_REMITTANCE("CustPaymRemittance"),
    @XmlEnumValue("CustBillOfExchangeDraw")
    CUST_BILL_OF_EXCHANGE_DRAW("CustBillOfExchangeDraw"),
    @XmlEnumValue("CustBillOfExchangeProtest")
    CUST_BILL_OF_EXCHANGE_PROTEST("CustBillOfExchangeProtest"),
    @XmlEnumValue("CustBillOfExchangeRedraw")
    CUST_BILL_OF_EXCHANGE_REDRAW("CustBillOfExchangeRedraw"),
    @XmlEnumValue("VendPromissoryNoteDraw")
    VEND_PROMISSORY_NOTE_DRAW("VendPromissoryNoteDraw"),
    @XmlEnumValue("CustBillOfExchangeAccept")
    CUST_BILL_OF_EXCHANGE_ACCEPT("CustBillOfExchangeAccept"),
    @XmlEnumValue("VendPromissoryNoteRedraw")
    VEND_PROMISSORY_NOTE_REDRAW("VendPromissoryNoteRedraw"),
    @XmlEnumValue("VendPaymRemittance")
    VEND_PAYM_REMITTANCE("VendPaymRemittance"),
    @XmlEnumValue("CustBillOfExchangeSettle")
    CUST_BILL_OF_EXCHANGE_SETTLE("CustBillOfExchangeSettle"),
    @XmlEnumValue("VendPromissoryNoteSettle")
    VEND_PROMISSORY_NOTE_SETTLE("VendPromissoryNoteSettle"),
    @XmlEnumValue("CostAccDaily")
    COST_ACC_DAILY("CostAccDaily"),
    @XmlEnumValue("CostAccPeriodic")
    COST_ACC_PERIODIC("CostAccPeriodic"),
    @XmlEnumValue("StatTrans")
    STAT_TRANS("StatTrans"),
    @XmlEnumValue("Allocation")
    ALLOCATION("Allocation"),
    @XmlEnumValue("Elimination")
    ELIMINATION("Elimination"),
    @XmlEnumValue("BankChequeReversal")
    BANK_CHEQUE_REVERSAL("BankChequeReversal"),
    @XmlEnumValue("BankDepositPaymCancel")
    BANK_DEPOSIT_PAYM_CANCEL("BankDepositPaymCancel"),
    @XmlEnumValue("Budget")
    BUDGET("Budget");
    private final String value;

    AxdEnumLedgerJournalType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumLedgerJournalType fromValue(String v) {
        for (AxdEnumLedgerJournalType c: AxdEnumLedgerJournalType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
