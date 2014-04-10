
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_LedgerPostingType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_LedgerPostingType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="ExchRateGain"/>
 *     &lt;enumeration value="ExchRateLoss"/>
 *     &lt;enumeration value="InterCompany"/>
 *     &lt;enumeration value="Tax"/>
 *     &lt;enumeration value="VATRoundOff"/>
 *     &lt;enumeration value="Allocation"/>
 *     &lt;enumeration value="InvestmentDuty"/>
 *     &lt;enumeration value="Liquidity"/>
 *     &lt;enumeration value="MSTDiffSecond"/>
 *     &lt;enumeration value="ErrorAccount"/>
 *     &lt;enumeration value="MSTDiff"/>
 *     &lt;enumeration value="YearResult"/>
 *     &lt;enumeration value="Closing"/>
 *     &lt;enumeration value="LedgerJournal"/>
 *     &lt;enumeration value="CashDiscount"/>
 *     &lt;enumeration value="ConsolidateDiffBalance"/>
 *     &lt;enumeration value="PaymentFee"/>
 *     &lt;enumeration value="TaxReport"/>
 *     &lt;enumeration value="TransferOpeningClosing"/>
 *     &lt;enumeration value="Bank"/>
 *     &lt;enumeration value="ConversionProfit"/>
 *     &lt;enumeration value="ConversionLoss"/>
 *     &lt;enumeration value="TaxWithhold"/>
 *     &lt;enumeration value="IndirectEstimatedAbsorption"/>
 *     &lt;enumeration value="IndirectEstimatedAbsorptionOffset"/>
 *     &lt;enumeration value="IndirectAbsorption"/>
 *     &lt;enumeration value="IndirectAbsorptionOffset"/>
 *     &lt;enumeration value="CustBalance"/>
 *     &lt;enumeration value="CustRevenue"/>
 *     &lt;enumeration value="CustInterest"/>
 *     &lt;enumeration value="CustCashDisc"/>
 *     &lt;enumeration value="CustCollectionLetterFee"/>
 *     &lt;enumeration value="CustInterestFee"/>
 *     &lt;enumeration value="CustInvoiceDisc"/>
 *     &lt;enumeration value="CustPayment"/>
 *     &lt;enumeration value="CustReimbursement"/>
 *     &lt;enumeration value="CustSettlement"/>
 *     &lt;enumeration value="VendBalance"/>
 *     &lt;enumeration value="VendPurchLedger"/>
 *     &lt;enumeration value="VendOffsetAccount"/>
 *     &lt;enumeration value="VendInterest"/>
 *     &lt;enumeration value="VendCashDisc"/>
 *     &lt;enumeration value="VendPayment"/>
 *     &lt;enumeration value="VendInvoiceDisc"/>
 *     &lt;enumeration value="VendSettlement"/>
 *     &lt;enumeration value="SalesRevenue"/>
 *     &lt;enumeration value="SalesConsump"/>
 *     &lt;enumeration value="SalesDisc"/>
 *     &lt;enumeration value="SalesCash"/>
 *     &lt;enumeration value="SalesFreight"/>
 *     &lt;enumeration value="SalesFee"/>
 *     &lt;enumeration value="SalesPostage"/>
 *     &lt;enumeration value="SalesRoundOff"/>
 *     &lt;enumeration value="SalesPackingSlip"/>
 *     &lt;enumeration value="SalesOffsetAccountPackingSlip"/>
 *     &lt;enumeration value="SalesIssue"/>
 *     &lt;enumeration value="SalesCommission"/>
 *     &lt;enumeration value="SalesOffsetAccountCommission"/>
 *     &lt;enumeration value="SalesPckSlipRevenue"/>
 *     &lt;enumeration value="SalesPckSlipRevenueOffsetAccount"/>
 *     &lt;enumeration value="SalesPackingslipTax"/>
 *     &lt;enumeration value="PurchConsump"/>
 *     &lt;enumeration value="PurchDisc"/>
 *     &lt;enumeration value="PurchCash"/>
 *     &lt;enumeration value="PurchFreight"/>
 *     &lt;enumeration value="PurchFee"/>
 *     &lt;enumeration value="PurchPostage"/>
 *     &lt;enumeration value="PurchOffsetAccount"/>
 *     &lt;enumeration value="PurchaseInvoiceRoundOff"/>
 *     &lt;enumeration value="PurchMarkupFreight"/>
 *     &lt;enumeration value="PurchMarkupCustoms"/>
 *     &lt;enumeration value="PurchMarkupInsurance"/>
 *     &lt;enumeration value="PurchPckSlp"/>
 *     &lt;enumeration value="PurchOffsetAccountPckSlp"/>
 *     &lt;enumeration value="PurchReceipt"/>
 *     &lt;enumeration value="PurchStdProfit"/>
 *     &lt;enumeration value="PurchStdLoss"/>
 *     &lt;enumeration value="PurchStdOffsetAccount"/>
 *     &lt;enumeration value="PurchCharge"/>
 *     &lt;enumeration value="PurchStockVariation"/>
 *     &lt;enumeration value="PurchPckSlpPurchase"/>
 *     &lt;enumeration value="PurchPckSlpPurchaseOffsetAccount"/>
 *     &lt;enumeration value="PurchPckSlpTax"/>
 *     &lt;enumeration value="InventReceipt"/>
 *     &lt;enumeration value="InventIssue"/>
 *     &lt;enumeration value="InventProfit"/>
 *     &lt;enumeration value="InventLoss"/>
 *     &lt;enumeration value="InventStdProfit"/>
 *     &lt;enumeration value="InventStdLoss"/>
 *     &lt;enumeration value="ProdReportFinished"/>
 *     &lt;enumeration value="ProdReportFinishedOffsetAccount"/>
 *     &lt;enumeration value="ProdIssue"/>
 *     &lt;enumeration value="ProdIssueOffsetAccount"/>
 *     &lt;enumeration value="ProdReceipt"/>
 *     &lt;enumeration value="ProdReceiptOffsetAccount"/>
 *     &lt;enumeration value="ProdPicklistOffsetAccount"/>
 *     &lt;enumeration value="ProdPicklist"/>
 *     &lt;enumeration value="ProdWIPValuation"/>
 *     &lt;enumeration value="ProdWIPIssue"/>
 *     &lt;enumeration value="ProdWrkCtrIssue"/>
 *     &lt;enumeration value="ProdScrap"/>
 *     &lt;enumeration value="ProdWrkCtrIssueOffsetAccount"/>
 *     &lt;enumeration value="ProdScrapOffsetAccount"/>
 *     &lt;enumeration value="ProjCost"/>
 *     &lt;enumeration value="ProjPayrollAllocation"/>
 *     &lt;enumeration value="ProjWIPCostvalue"/>
 *     &lt;enumeration value="ProjOffsetAccountItem"/>
 *     &lt;enumeration value="ProjStatusAccountItem"/>
 *     &lt;enumeration value="ProjTurnover"/>
 *     &lt;enumeration value="ProjOnAccount"/>
 *     &lt;enumeration value="ProjSalesvalue"/>
 *     &lt;enumeration value="ProjSalesvalueOffset"/>
 *     &lt;enumeration value="ProjAccruedTurnoverProd"/>
 *     &lt;enumeration value="ProjWIPProduction"/>
 *     &lt;enumeration value="ProJAccruedTurnoverProfit"/>
 *     &lt;enumeration value="ProjWIPProfit"/>
 *     &lt;enumeration value="ProjNeverLedger"/>
 *     &lt;enumeration value="ProjAccruedCost"/>
 *     &lt;enumeration value="ProjWIPCost"/>
 *     &lt;enumeration value="ProjAccruedRevenueOnAccount"/>
 *     &lt;enumeration value="ProjWIPInvoicedOnAccount"/>
 *     &lt;enumeration value="ProjNoLedger"/>
 *     &lt;enumeration value="ProjAccruedRevenueSubscription"/>
 *     &lt;enumeration value="ProjWIPSubscription"/>
 *     &lt;enumeration value="PayrollDebitAccount"/>
 *     &lt;enumeration value="PayrollCreditAccount"/>
 *     &lt;enumeration value="FixedAssetsDebit"/>
 *     &lt;enumeration value="FixedAssetsCredit"/>
 *     &lt;enumeration value="CACLedgerJournalNoOff"/>
 *     &lt;enumeration value="ConsolidateDiffProfitLoss"/>
 *     &lt;enumeration value="InventStdCostRevaluation"/>
 *     &lt;enumeration value="InventStdCostChangeVariance"/>
 *     &lt;enumeration value="InventSystemRounding"/>
 *     &lt;enumeration value="PurchStdCostPurchasePriceVariance"/>
 *     &lt;enumeration value="ProdStdCostProductionVariance"/>
 *     &lt;enumeration value="ProdStdCostLotSizeVariance"/>
 *     &lt;enumeration value="ProdStdCostQuantityVariance"/>
 *     &lt;enumeration value="ProdStdCostSubstitutionVariance"/>
 *     &lt;enumeration value="InventInterUnitPayable"/>
 *     &lt;enumeration value="InventInterUnitReceivable"/>
 *     &lt;enumeration value="CrossCompanySettlement"/>
 *     &lt;enumeration value="InventIssueFixedAsset"/>
 *     &lt;enumeration value="PurchReceiptFixedAsset"/>
 *     &lt;enumeration value="InventStdCostRoundingVariance"/>
 *     &lt;enumeration value="PurchExpense"/>
 *     &lt;enumeration value="PurchReq"/>
 *     &lt;enumeration value="PurchOrder"/>
 *     &lt;enumeration value="APInvoice"/>
 *     &lt;enumeration value="Budget"/>
 *     &lt;enumeration value="PurchOrderYearEnd"/>
 *     &lt;enumeration value="Rebate"/>
 *     &lt;enumeration value="PdsCWLoss"/>
 *     &lt;enumeration value="PdsCWProfit"/>
 *     &lt;enumeration value="TaxOffsetWithhold_TH"/>
 *     &lt;enumeration value="PurchAdvance"/>
 *     &lt;enumeration value="InflationAdjustment_MX"/>
 *     &lt;enumeration value="Opening_ES"/>
 *     &lt;enumeration value="ProdLeanWIPServiceReceipt"/>
 *     &lt;enumeration value="ProdLeanWIPServiceClearing"/>
 *     &lt;enumeration value="PurchAdvanceApplication"/>
 *     &lt;enumeration value="ConversionReportingProfit"/>
 *     &lt;enumeration value="ConversionReportingLoss"/>
 *     &lt;enumeration value="PSAEmployeeAdvance"/>
 *     &lt;enumeration value="PSAEmployeeClearing"/>
 *     &lt;enumeration value="PSACompanyCCClearing"/>
 *     &lt;enumeration value="PSATransportation"/>
 *     &lt;enumeration value="PSAWriteOffCap"/>
 *     &lt;enumeration value="PSAProjPurchRetain"/>
 *     &lt;enumeration value="PSAProjRetain"/>
 *     &lt;enumeration value="FreeTextInvoice"/>
 *     &lt;enumeration value="InventMovingAveragePriceDifference"/>
 *     &lt;enumeration value="InventMovingAverageCostRevaluation"/>
 *     &lt;enumeration value="IntercompanyCost"/>
 *     &lt;enumeration value="IntercompanyRevenue"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_LedgerPostingType")
@XmlEnum
public enum AxdEnumLedgerPostingType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("ExchRateGain")
    EXCH_RATE_GAIN("ExchRateGain"),
    @XmlEnumValue("ExchRateLoss")
    EXCH_RATE_LOSS("ExchRateLoss"),
    @XmlEnumValue("InterCompany")
    INTER_COMPANY("InterCompany"),
    @XmlEnumValue("Tax")
    TAX("Tax"),
    @XmlEnumValue("VATRoundOff")
    VAT_ROUND_OFF("VATRoundOff"),
    @XmlEnumValue("Allocation")
    ALLOCATION("Allocation"),
    @XmlEnumValue("InvestmentDuty")
    INVESTMENT_DUTY("InvestmentDuty"),
    @XmlEnumValue("Liquidity")
    LIQUIDITY("Liquidity"),
    @XmlEnumValue("MSTDiffSecond")
    MST_DIFF_SECOND("MSTDiffSecond"),
    @XmlEnumValue("ErrorAccount")
    ERROR_ACCOUNT("ErrorAccount"),
    @XmlEnumValue("MSTDiff")
    MST_DIFF("MSTDiff"),
    @XmlEnumValue("YearResult")
    YEAR_RESULT("YearResult"),
    @XmlEnumValue("Closing")
    CLOSING("Closing"),
    @XmlEnumValue("LedgerJournal")
    LEDGER_JOURNAL("LedgerJournal"),
    @XmlEnumValue("CashDiscount")
    CASH_DISCOUNT("CashDiscount"),
    @XmlEnumValue("ConsolidateDiffBalance")
    CONSOLIDATE_DIFF_BALANCE("ConsolidateDiffBalance"),
    @XmlEnumValue("PaymentFee")
    PAYMENT_FEE("PaymentFee"),
    @XmlEnumValue("TaxReport")
    TAX_REPORT("TaxReport"),
    @XmlEnumValue("TransferOpeningClosing")
    TRANSFER_OPENING_CLOSING("TransferOpeningClosing"),
    @XmlEnumValue("Bank")
    BANK("Bank"),
    @XmlEnumValue("ConversionProfit")
    CONVERSION_PROFIT("ConversionProfit"),
    @XmlEnumValue("ConversionLoss")
    CONVERSION_LOSS("ConversionLoss"),
    @XmlEnumValue("TaxWithhold")
    TAX_WITHHOLD("TaxWithhold"),
    @XmlEnumValue("IndirectEstimatedAbsorption")
    INDIRECT_ESTIMATED_ABSORPTION("IndirectEstimatedAbsorption"),
    @XmlEnumValue("IndirectEstimatedAbsorptionOffset")
    INDIRECT_ESTIMATED_ABSORPTION_OFFSET("IndirectEstimatedAbsorptionOffset"),
    @XmlEnumValue("IndirectAbsorption")
    INDIRECT_ABSORPTION("IndirectAbsorption"),
    @XmlEnumValue("IndirectAbsorptionOffset")
    INDIRECT_ABSORPTION_OFFSET("IndirectAbsorptionOffset"),
    @XmlEnumValue("CustBalance")
    CUST_BALANCE("CustBalance"),
    @XmlEnumValue("CustRevenue")
    CUST_REVENUE("CustRevenue"),
    @XmlEnumValue("CustInterest")
    CUST_INTEREST("CustInterest"),
    @XmlEnumValue("CustCashDisc")
    CUST_CASH_DISC("CustCashDisc"),
    @XmlEnumValue("CustCollectionLetterFee")
    CUST_COLLECTION_LETTER_FEE("CustCollectionLetterFee"),
    @XmlEnumValue("CustInterestFee")
    CUST_INTEREST_FEE("CustInterestFee"),
    @XmlEnumValue("CustInvoiceDisc")
    CUST_INVOICE_DISC("CustInvoiceDisc"),
    @XmlEnumValue("CustPayment")
    CUST_PAYMENT("CustPayment"),
    @XmlEnumValue("CustReimbursement")
    CUST_REIMBURSEMENT("CustReimbursement"),
    @XmlEnumValue("CustSettlement")
    CUST_SETTLEMENT("CustSettlement"),
    @XmlEnumValue("VendBalance")
    VEND_BALANCE("VendBalance"),
    @XmlEnumValue("VendPurchLedger")
    VEND_PURCH_LEDGER("VendPurchLedger"),
    @XmlEnumValue("VendOffsetAccount")
    VEND_OFFSET_ACCOUNT("VendOffsetAccount"),
    @XmlEnumValue("VendInterest")
    VEND_INTEREST("VendInterest"),
    @XmlEnumValue("VendCashDisc")
    VEND_CASH_DISC("VendCashDisc"),
    @XmlEnumValue("VendPayment")
    VEND_PAYMENT("VendPayment"),
    @XmlEnumValue("VendInvoiceDisc")
    VEND_INVOICE_DISC("VendInvoiceDisc"),
    @XmlEnumValue("VendSettlement")
    VEND_SETTLEMENT("VendSettlement"),
    @XmlEnumValue("SalesRevenue")
    SALES_REVENUE("SalesRevenue"),
    @XmlEnumValue("SalesConsump")
    SALES_CONSUMP("SalesConsump"),
    @XmlEnumValue("SalesDisc")
    SALES_DISC("SalesDisc"),
    @XmlEnumValue("SalesCash")
    SALES_CASH("SalesCash"),
    @XmlEnumValue("SalesFreight")
    SALES_FREIGHT("SalesFreight"),
    @XmlEnumValue("SalesFee")
    SALES_FEE("SalesFee"),
    @XmlEnumValue("SalesPostage")
    SALES_POSTAGE("SalesPostage"),
    @XmlEnumValue("SalesRoundOff")
    SALES_ROUND_OFF("SalesRoundOff"),
    @XmlEnumValue("SalesPackingSlip")
    SALES_PACKING_SLIP("SalesPackingSlip"),
    @XmlEnumValue("SalesOffsetAccountPackingSlip")
    SALES_OFFSET_ACCOUNT_PACKING_SLIP("SalesOffsetAccountPackingSlip"),
    @XmlEnumValue("SalesIssue")
    SALES_ISSUE("SalesIssue"),
    @XmlEnumValue("SalesCommission")
    SALES_COMMISSION("SalesCommission"),
    @XmlEnumValue("SalesOffsetAccountCommission")
    SALES_OFFSET_ACCOUNT_COMMISSION("SalesOffsetAccountCommission"),
    @XmlEnumValue("SalesPckSlipRevenue")
    SALES_PCK_SLIP_REVENUE("SalesPckSlipRevenue"),
    @XmlEnumValue("SalesPckSlipRevenueOffsetAccount")
    SALES_PCK_SLIP_REVENUE_OFFSET_ACCOUNT("SalesPckSlipRevenueOffsetAccount"),
    @XmlEnumValue("SalesPackingslipTax")
    SALES_PACKINGSLIP_TAX("SalesPackingslipTax"),
    @XmlEnumValue("PurchConsump")
    PURCH_CONSUMP("PurchConsump"),
    @XmlEnumValue("PurchDisc")
    PURCH_DISC("PurchDisc"),
    @XmlEnumValue("PurchCash")
    PURCH_CASH("PurchCash"),
    @XmlEnumValue("PurchFreight")
    PURCH_FREIGHT("PurchFreight"),
    @XmlEnumValue("PurchFee")
    PURCH_FEE("PurchFee"),
    @XmlEnumValue("PurchPostage")
    PURCH_POSTAGE("PurchPostage"),
    @XmlEnumValue("PurchOffsetAccount")
    PURCH_OFFSET_ACCOUNT("PurchOffsetAccount"),
    @XmlEnumValue("PurchaseInvoiceRoundOff")
    PURCHASE_INVOICE_ROUND_OFF("PurchaseInvoiceRoundOff"),
    @XmlEnumValue("PurchMarkupFreight")
    PURCH_MARKUP_FREIGHT("PurchMarkupFreight"),
    @XmlEnumValue("PurchMarkupCustoms")
    PURCH_MARKUP_CUSTOMS("PurchMarkupCustoms"),
    @XmlEnumValue("PurchMarkupInsurance")
    PURCH_MARKUP_INSURANCE("PurchMarkupInsurance"),
    @XmlEnumValue("PurchPckSlp")
    PURCH_PCK_SLP("PurchPckSlp"),
    @XmlEnumValue("PurchOffsetAccountPckSlp")
    PURCH_OFFSET_ACCOUNT_PCK_SLP("PurchOffsetAccountPckSlp"),
    @XmlEnumValue("PurchReceipt")
    PURCH_RECEIPT("PurchReceipt"),
    @XmlEnumValue("PurchStdProfit")
    PURCH_STD_PROFIT("PurchStdProfit"),
    @XmlEnumValue("PurchStdLoss")
    PURCH_STD_LOSS("PurchStdLoss"),
    @XmlEnumValue("PurchStdOffsetAccount")
    PURCH_STD_OFFSET_ACCOUNT("PurchStdOffsetAccount"),
    @XmlEnumValue("PurchCharge")
    PURCH_CHARGE("PurchCharge"),
    @XmlEnumValue("PurchStockVariation")
    PURCH_STOCK_VARIATION("PurchStockVariation"),
    @XmlEnumValue("PurchPckSlpPurchase")
    PURCH_PCK_SLP_PURCHASE("PurchPckSlpPurchase"),
    @XmlEnumValue("PurchPckSlpPurchaseOffsetAccount")
    PURCH_PCK_SLP_PURCHASE_OFFSET_ACCOUNT("PurchPckSlpPurchaseOffsetAccount"),
    @XmlEnumValue("PurchPckSlpTax")
    PURCH_PCK_SLP_TAX("PurchPckSlpTax"),
    @XmlEnumValue("InventReceipt")
    INVENT_RECEIPT("InventReceipt"),
    @XmlEnumValue("InventIssue")
    INVENT_ISSUE("InventIssue"),
    @XmlEnumValue("InventProfit")
    INVENT_PROFIT("InventProfit"),
    @XmlEnumValue("InventLoss")
    INVENT_LOSS("InventLoss"),
    @XmlEnumValue("InventStdProfit")
    INVENT_STD_PROFIT("InventStdProfit"),
    @XmlEnumValue("InventStdLoss")
    INVENT_STD_LOSS("InventStdLoss"),
    @XmlEnumValue("ProdReportFinished")
    PROD_REPORT_FINISHED("ProdReportFinished"),
    @XmlEnumValue("ProdReportFinishedOffsetAccount")
    PROD_REPORT_FINISHED_OFFSET_ACCOUNT("ProdReportFinishedOffsetAccount"),
    @XmlEnumValue("ProdIssue")
    PROD_ISSUE("ProdIssue"),
    @XmlEnumValue("ProdIssueOffsetAccount")
    PROD_ISSUE_OFFSET_ACCOUNT("ProdIssueOffsetAccount"),
    @XmlEnumValue("ProdReceipt")
    PROD_RECEIPT("ProdReceipt"),
    @XmlEnumValue("ProdReceiptOffsetAccount")
    PROD_RECEIPT_OFFSET_ACCOUNT("ProdReceiptOffsetAccount"),
    @XmlEnumValue("ProdPicklistOffsetAccount")
    PROD_PICKLIST_OFFSET_ACCOUNT("ProdPicklistOffsetAccount"),
    @XmlEnumValue("ProdPicklist")
    PROD_PICKLIST("ProdPicklist"),
    @XmlEnumValue("ProdWIPValuation")
    PROD_WIP_VALUATION("ProdWIPValuation"),
    @XmlEnumValue("ProdWIPIssue")
    PROD_WIP_ISSUE("ProdWIPIssue"),
    @XmlEnumValue("ProdWrkCtrIssue")
    PROD_WRK_CTR_ISSUE("ProdWrkCtrIssue"),
    @XmlEnumValue("ProdScrap")
    PROD_SCRAP("ProdScrap"),
    @XmlEnumValue("ProdWrkCtrIssueOffsetAccount")
    PROD_WRK_CTR_ISSUE_OFFSET_ACCOUNT("ProdWrkCtrIssueOffsetAccount"),
    @XmlEnumValue("ProdScrapOffsetAccount")
    PROD_SCRAP_OFFSET_ACCOUNT("ProdScrapOffsetAccount"),
    @XmlEnumValue("ProjCost")
    PROJ_COST("ProjCost"),
    @XmlEnumValue("ProjPayrollAllocation")
    PROJ_PAYROLL_ALLOCATION("ProjPayrollAllocation"),
    @XmlEnumValue("ProjWIPCostvalue")
    PROJ_WIP_COSTVALUE("ProjWIPCostvalue"),
    @XmlEnumValue("ProjOffsetAccountItem")
    PROJ_OFFSET_ACCOUNT_ITEM("ProjOffsetAccountItem"),
    @XmlEnumValue("ProjStatusAccountItem")
    PROJ_STATUS_ACCOUNT_ITEM("ProjStatusAccountItem"),
    @XmlEnumValue("ProjTurnover")
    PROJ_TURNOVER("ProjTurnover"),
    @XmlEnumValue("ProjOnAccount")
    PROJ_ON_ACCOUNT("ProjOnAccount"),
    @XmlEnumValue("ProjSalesvalue")
    PROJ_SALESVALUE("ProjSalesvalue"),
    @XmlEnumValue("ProjSalesvalueOffset")
    PROJ_SALESVALUE_OFFSET("ProjSalesvalueOffset"),
    @XmlEnumValue("ProjAccruedTurnoverProd")
    PROJ_ACCRUED_TURNOVER_PROD("ProjAccruedTurnoverProd"),
    @XmlEnumValue("ProjWIPProduction")
    PROJ_WIP_PRODUCTION("ProjWIPProduction"),
    @XmlEnumValue("ProJAccruedTurnoverProfit")
    PRO_J_ACCRUED_TURNOVER_PROFIT("ProJAccruedTurnoverProfit"),
    @XmlEnumValue("ProjWIPProfit")
    PROJ_WIP_PROFIT("ProjWIPProfit"),
    @XmlEnumValue("ProjNeverLedger")
    PROJ_NEVER_LEDGER("ProjNeverLedger"),
    @XmlEnumValue("ProjAccruedCost")
    PROJ_ACCRUED_COST("ProjAccruedCost"),
    @XmlEnumValue("ProjWIPCost")
    PROJ_WIP_COST("ProjWIPCost"),
    @XmlEnumValue("ProjAccruedRevenueOnAccount")
    PROJ_ACCRUED_REVENUE_ON_ACCOUNT("ProjAccruedRevenueOnAccount"),
    @XmlEnumValue("ProjWIPInvoicedOnAccount")
    PROJ_WIP_INVOICED_ON_ACCOUNT("ProjWIPInvoicedOnAccount"),
    @XmlEnumValue("ProjNoLedger")
    PROJ_NO_LEDGER("ProjNoLedger"),
    @XmlEnumValue("ProjAccruedRevenueSubscription")
    PROJ_ACCRUED_REVENUE_SUBSCRIPTION("ProjAccruedRevenueSubscription"),
    @XmlEnumValue("ProjWIPSubscription")
    PROJ_WIP_SUBSCRIPTION("ProjWIPSubscription"),
    @XmlEnumValue("PayrollDebitAccount")
    PAYROLL_DEBIT_ACCOUNT("PayrollDebitAccount"),
    @XmlEnumValue("PayrollCreditAccount")
    PAYROLL_CREDIT_ACCOUNT("PayrollCreditAccount"),
    @XmlEnumValue("FixedAssetsDebit")
    FIXED_ASSETS_DEBIT("FixedAssetsDebit"),
    @XmlEnumValue("FixedAssetsCredit")
    FIXED_ASSETS_CREDIT("FixedAssetsCredit"),
    @XmlEnumValue("CACLedgerJournalNoOff")
    CAC_LEDGER_JOURNAL_NO_OFF("CACLedgerJournalNoOff"),
    @XmlEnumValue("ConsolidateDiffProfitLoss")
    CONSOLIDATE_DIFF_PROFIT_LOSS("ConsolidateDiffProfitLoss"),
    @XmlEnumValue("InventStdCostRevaluation")
    INVENT_STD_COST_REVALUATION("InventStdCostRevaluation"),
    @XmlEnumValue("InventStdCostChangeVariance")
    INVENT_STD_COST_CHANGE_VARIANCE("InventStdCostChangeVariance"),
    @XmlEnumValue("InventSystemRounding")
    INVENT_SYSTEM_ROUNDING("InventSystemRounding"),
    @XmlEnumValue("PurchStdCostPurchasePriceVariance")
    PURCH_STD_COST_PURCHASE_PRICE_VARIANCE("PurchStdCostPurchasePriceVariance"),
    @XmlEnumValue("ProdStdCostProductionVariance")
    PROD_STD_COST_PRODUCTION_VARIANCE("ProdStdCostProductionVariance"),
    @XmlEnumValue("ProdStdCostLotSizeVariance")
    PROD_STD_COST_LOT_SIZE_VARIANCE("ProdStdCostLotSizeVariance"),
    @XmlEnumValue("ProdStdCostQuantityVariance")
    PROD_STD_COST_QUANTITY_VARIANCE("ProdStdCostQuantityVariance"),
    @XmlEnumValue("ProdStdCostSubstitutionVariance")
    PROD_STD_COST_SUBSTITUTION_VARIANCE("ProdStdCostSubstitutionVariance"),
    @XmlEnumValue("InventInterUnitPayable")
    INVENT_INTER_UNIT_PAYABLE("InventInterUnitPayable"),
    @XmlEnumValue("InventInterUnitReceivable")
    INVENT_INTER_UNIT_RECEIVABLE("InventInterUnitReceivable"),
    @XmlEnumValue("CrossCompanySettlement")
    CROSS_COMPANY_SETTLEMENT("CrossCompanySettlement"),
    @XmlEnumValue("InventIssueFixedAsset")
    INVENT_ISSUE_FIXED_ASSET("InventIssueFixedAsset"),
    @XmlEnumValue("PurchReceiptFixedAsset")
    PURCH_RECEIPT_FIXED_ASSET("PurchReceiptFixedAsset"),
    @XmlEnumValue("InventStdCostRoundingVariance")
    INVENT_STD_COST_ROUNDING_VARIANCE("InventStdCostRoundingVariance"),
    @XmlEnumValue("PurchExpense")
    PURCH_EXPENSE("PurchExpense"),
    @XmlEnumValue("PurchReq")
    PURCH_REQ("PurchReq"),
    @XmlEnumValue("PurchOrder")
    PURCH_ORDER("PurchOrder"),
    @XmlEnumValue("APInvoice")
    AP_INVOICE("APInvoice"),
    @XmlEnumValue("Budget")
    BUDGET("Budget"),
    @XmlEnumValue("PurchOrderYearEnd")
    PURCH_ORDER_YEAR_END("PurchOrderYearEnd"),
    @XmlEnumValue("Rebate")
    REBATE("Rebate"),
    @XmlEnumValue("PdsCWLoss")
    PDS_CW_LOSS("PdsCWLoss"),
    @XmlEnumValue("PdsCWProfit")
    PDS_CW_PROFIT("PdsCWProfit"),
    @XmlEnumValue("TaxOffsetWithhold_TH")
    TAX_OFFSET_WITHHOLD_TH("TaxOffsetWithhold_TH"),
    @XmlEnumValue("PurchAdvance")
    PURCH_ADVANCE("PurchAdvance"),
    @XmlEnumValue("InflationAdjustment_MX")
    INFLATION_ADJUSTMENT_MX("InflationAdjustment_MX"),
    @XmlEnumValue("Opening_ES")
    OPENING_ES("Opening_ES"),
    @XmlEnumValue("ProdLeanWIPServiceReceipt")
    PROD_LEAN_WIP_SERVICE_RECEIPT("ProdLeanWIPServiceReceipt"),
    @XmlEnumValue("ProdLeanWIPServiceClearing")
    PROD_LEAN_WIP_SERVICE_CLEARING("ProdLeanWIPServiceClearing"),
    @XmlEnumValue("PurchAdvanceApplication")
    PURCH_ADVANCE_APPLICATION("PurchAdvanceApplication"),
    @XmlEnumValue("ConversionReportingProfit")
    CONVERSION_REPORTING_PROFIT("ConversionReportingProfit"),
    @XmlEnumValue("ConversionReportingLoss")
    CONVERSION_REPORTING_LOSS("ConversionReportingLoss"),
    @XmlEnumValue("PSAEmployeeAdvance")
    PSA_EMPLOYEE_ADVANCE("PSAEmployeeAdvance"),
    @XmlEnumValue("PSAEmployeeClearing")
    PSA_EMPLOYEE_CLEARING("PSAEmployeeClearing"),
    @XmlEnumValue("PSACompanyCCClearing")
    PSA_COMPANY_CC_CLEARING("PSACompanyCCClearing"),
    @XmlEnumValue("PSATransportation")
    PSA_TRANSPORTATION("PSATransportation"),
    @XmlEnumValue("PSAWriteOffCap")
    PSA_WRITE_OFF_CAP("PSAWriteOffCap"),
    @XmlEnumValue("PSAProjPurchRetain")
    PSA_PROJ_PURCH_RETAIN("PSAProjPurchRetain"),
    @XmlEnumValue("PSAProjRetain")
    PSA_PROJ_RETAIN("PSAProjRetain"),
    @XmlEnumValue("FreeTextInvoice")
    FREE_TEXT_INVOICE("FreeTextInvoice"),
    @XmlEnumValue("InventMovingAveragePriceDifference")
    INVENT_MOVING_AVERAGE_PRICE_DIFFERENCE("InventMovingAveragePriceDifference"),
    @XmlEnumValue("InventMovingAverageCostRevaluation")
    INVENT_MOVING_AVERAGE_COST_REVALUATION("InventMovingAverageCostRevaluation"),
    @XmlEnumValue("IntercompanyCost")
    INTERCOMPANY_COST("IntercompanyCost"),
    @XmlEnumValue("IntercompanyRevenue")
    INTERCOMPANY_REVENUE("IntercompanyRevenue");
    private final String value;

    AxdEnumLedgerPostingType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumLedgerPostingType fromValue(String v) {
        for (AxdEnumLedgerPostingType c: AxdEnumLedgerPostingType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
