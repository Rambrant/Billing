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
 * <p>Java class for AxdEnum_LedgerTransType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_LedgerTransType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Transfer"/>
 *     &lt;enumeration value="Sales"/>
 *     &lt;enumeration value="Purch"/>
 *     &lt;enumeration value="Invent"/>
 *     &lt;enumeration value="Production"/>
 *     &lt;enumeration value="Project"/>
 *     &lt;enumeration value="Interest"/>
 *     &lt;enumeration value="Cust"/>
 *     &lt;enumeration value="ExchAdjustment"/>
 *     &lt;enumeration value="SummedUp"/>
 *     &lt;enumeration value="Payroll"/>
 *     &lt;enumeration value="FixedAssets"/>
 *     &lt;enumeration value="CollectionLetter"/>
 *     &lt;enumeration value="Vend"/>
 *     &lt;enumeration value="Payment"/>
 *     &lt;enumeration value="Tax"/>
 *     &lt;enumeration value="Bank"/>
 *     &lt;enumeration value="Conversion"/>
 *     &lt;enumeration value="BillOfExchange"/>
 *     &lt;enumeration value="PromissoryNote"/>
 *     &lt;enumeration value="Cost"/>
 *     &lt;enumeration value="Work"/>
 *     &lt;enumeration value="Fee"/>
 *     &lt;enumeration value="Settlement"/>
 *     &lt;enumeration value="Allocation"/>
 *     &lt;enumeration value="Elimination"/>
 *     &lt;enumeration value="CashDiscount"/>
 *     &lt;enumeration value="OverUnder"/>
 *     &lt;enumeration value="PennyDifference"/>
 *     &lt;enumeration value="CrossCompanySettlement"/>
 *     &lt;enumeration value="PurchReq"/>
 *     &lt;enumeration value="InflationAdjustment_MX"/>
 *     &lt;enumeration value="PurchAdvanceApplication"/>
 *     &lt;enumeration value="ConversionReporting"/>
 *     &lt;enumeration value="PdsRebateCreditNote"/>
 *     &lt;enumeration value="PdsRebatePassToAP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_LedgerTransType")
@XmlEnum
public enum AxdEnumLedgerTransType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Transfer")
    TRANSFER("Transfer"),
    @XmlEnumValue("Sales")
    SALES("Sales"),
    @XmlEnumValue("Purch")
    PURCH("Purch"),
    @XmlEnumValue("Invent")
    INVENT("Invent"),
    @XmlEnumValue("Production")
    PRODUCTION("Production"),
    @XmlEnumValue("Project")
    PROJECT("Project"),
    @XmlEnumValue("Interest")
    INTEREST("Interest"),
    @XmlEnumValue("Cust")
    CUST("Cust"),
    @XmlEnumValue("ExchAdjustment")
    EXCH_ADJUSTMENT("ExchAdjustment"),
    @XmlEnumValue("SummedUp")
    SUMMED_UP("SummedUp"),
    @XmlEnumValue("Payroll")
    PAYROLL("Payroll"),
    @XmlEnumValue("FixedAssets")
    FIXED_ASSETS("FixedAssets"),
    @XmlEnumValue("CollectionLetter")
    COLLECTION_LETTER("CollectionLetter"),
    @XmlEnumValue("Vend")
    VEND("Vend"),
    @XmlEnumValue("Payment")
    PAYMENT("Payment"),
    @XmlEnumValue("Tax")
    TAX("Tax"),
    @XmlEnumValue("Bank")
    BANK("Bank"),
    @XmlEnumValue("Conversion")
    CONVERSION("Conversion"),
    @XmlEnumValue("BillOfExchange")
    BILL_OF_EXCHANGE("BillOfExchange"),
    @XmlEnumValue("PromissoryNote")
    PROMISSORY_NOTE("PromissoryNote"),
    @XmlEnumValue("Cost")
    COST("Cost"),
    @XmlEnumValue("Work")
    WORK("Work"),
    @XmlEnumValue("Fee")
    FEE("Fee"),
    @XmlEnumValue("Settlement")
    SETTLEMENT("Settlement"),
    @XmlEnumValue("Allocation")
    ALLOCATION("Allocation"),
    @XmlEnumValue("Elimination")
    ELIMINATION("Elimination"),
    @XmlEnumValue("CashDiscount")
    CASH_DISCOUNT("CashDiscount"),
    @XmlEnumValue("OverUnder")
    OVER_UNDER("OverUnder"),
    @XmlEnumValue("PennyDifference")
    PENNY_DIFFERENCE("PennyDifference"),
    @XmlEnumValue("CrossCompanySettlement")
    CROSS_COMPANY_SETTLEMENT("CrossCompanySettlement"),
    @XmlEnumValue("PurchReq")
    PURCH_REQ("PurchReq"),
    @XmlEnumValue("InflationAdjustment_MX")
    INFLATION_ADJUSTMENT_MX("InflationAdjustment_MX"),
    @XmlEnumValue("PurchAdvanceApplication")
    PURCH_ADVANCE_APPLICATION("PurchAdvanceApplication"),
    @XmlEnumValue("ConversionReporting")
    CONVERSION_REPORTING("ConversionReporting"),
    @XmlEnumValue("PdsRebateCreditNote")
    PDS_REBATE_CREDIT_NOTE("PdsRebateCreditNote"),
    @XmlEnumValue("PdsRebatePassToAP")
    PDS_REBATE_PASS_TO_AP("PdsRebatePassToAP");
    private final String value;

    AxdEnumLedgerTransType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumLedgerTransType fromValue(String v) {
        for (AxdEnumLedgerTransType c: AxdEnumLedgerTransType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}