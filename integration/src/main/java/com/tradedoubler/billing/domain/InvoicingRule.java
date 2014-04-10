package com.tradedoubler.billing.domain;

import java.util.*;

/** Information about an invoicing rule */
public class InvoicingRule {

    private final String clientId;
    private final String clientReference;
    private final Currency currencyCode;
    private String description;
    private final boolean deviatingExchangeRate;
    private boolean displayTDcommission;
    private final DistributionMode distributionMode;
    private Guid invoicingRuleId;
    private final String invoicingRuleName;
    private final String issuerReference;
    private Market marketId;
    private final PaymentMethod paymentMethod;
    private final PostingProfile postingProfile;
    private final RevenueType revenueType;
    private final TermsOfPayment termsOfPayment;
    private final List<InvoicingRuleMessageRule> invoiceMessageRules = new ArrayList<InvoicingRuleMessageRule>();
    private final List<InvoiceRecipient> invoiceRecipients = new ArrayList<InvoiceRecipient>();
    private final List<PurchaseOrder> purchaseOrders = new ArrayList<PurchaseOrder>();
    private List<String> sourceSystemAgreementIds = new ArrayList<String>();

    public InvoicingRule(String clientId, int marketId, String invoicingRuleId,
                         String invoicingRuleName, String description, String issuerReference,
                         String clientReference, String currencyCode, int distributionMode,
                         int termsOfPayment, int postingProfile, boolean displayTDcommission,
                         int revenueType, int paymentMethod,
                         boolean deviatingExchangeRate,
                         List<InvoiceRecipient> invoiceRecipients,
                         List<PurchaseOrder> purchaseOrders,
                         List<InvoicingRuleMessageRule> invoiceMessageRules,
                         List<String> sourceSystemAgreementIds) {
        this.clientId = clientId;
        this.marketId = new Market(marketId);
        this.invoicingRuleId = new Guid(invoicingRuleId);
        this.invoicingRuleName = invoicingRuleName;
        this.description = description;
        this.issuerReference = issuerReference;
        this.clientReference = clientReference;
        this.currencyCode = new Currency(currencyCode);
        this.distributionMode = new DistributionMode(distributionMode);
        this.termsOfPayment = new TermsOfPayment(termsOfPayment);
        this.postingProfile = new PostingProfile(postingProfile);
        this.displayTDcommission = displayTDcommission;
        this.revenueType = new RevenueType(revenueType);
        this.paymentMethod = new PaymentMethod(paymentMethod);
        this.deviatingExchangeRate = deviatingExchangeRate;
        this.invoiceRecipients.addAll(invoiceRecipients);
        this.purchaseOrders.addAll(purchaseOrders);
        this.invoiceMessageRules.addAll(invoiceMessageRules);
        this.sourceSystemAgreementIds.addAll(sourceSystemAgreementIds);
    }

    /** The PAN Org Id of the client the invoicing rule belongs to */
    public String getClientId() {
        return clientId;
    }


    /** The PAN Market ID of the market acting as invoice issuer */
    public Market getMarketId() {
        return marketId;
    }

    /** CRM primary key of the invoicing rule */
    public Guid getInvoicingRuleId() {
        return invoicingRuleId;
    }


    /** Name of invoicing rule */
    public String getInvoicingRuleName() {
        return invoicingRuleName;
    }


    /** A description of the invoicing rule (may be null) */
    public String getDescription() {
        return description;
    }


    /** Name of reference person of the invoice issuer organisation */
    public String getIssuerReference() {
        return issuerReference;
    }


    /** Name of reference person of the client organisation */
    public String getClientReference() {
        return clientReference;
    }

    /**
     * Currency to be used on invoices in ISO 4217 format (string)
     * <p/>
     * Pattern: ^[A-Z]{3}$
     */
    public Currency getCurrencyCode() {
        return currencyCode;
    }


    /** Invoice distribution mode. 1 = Send by post, 2 = Send by email, 3 = Send by post and email */
    public DistributionMode getDistributionMode() {
        return distributionMode;
    }


    /** Terms of payment to be used for invoices. The enum values corresponds to the number of days */
    public TermsOfPayment getTermsOfPayment() {
        return termsOfPayment;
    }


    /** Profile for how to handle interest and reminders. Valid values are currently unknown */
    public PostingProfile getPostingProfile() {
        return postingProfile;
    }


    /** Rule for if TD commission shall be shown separately on invoice */
    public boolean isDisplayTradeDoublerCommission() {
        return displayTDcommission;
    }


    /**
     * Type of revenue the invoice contains. Used to decide what account the revenue shall be posted on.
     * 1 = Tradedoubler, 2 = PVN
     */
    public RevenueType getRevenueType() {
        return revenueType;
    }


    /**
     * Payment method to be used. Overrules default payment method set for client.
     * 1 = Default (Will be used for clients where this setting is null in CRM), 2 = EZEUR, 3 = ABEUR
     */
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }


    /**
     * Decides if the creation of invoice shall be triggered manually for the order.
     * Enables setting of order specific currency exchange rate to be used for the invoice.
     */
    public boolean isDeviatingExchangeRate() {
        return deviatingExchangeRate;
    }

    /** The invoice recipients for the invoicing rule */
    public List<InvoiceRecipient> getInvoiceRecipients() {
        return invoiceRecipients;
    }

    /** The purchase orders for the invoicing rule */
    public List<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
    }

    /** The invoice messages for the invoicing rule */
    public List<InvoicingRuleMessageRule> getInvoiceMessageRules() {
        return invoiceMessageRules;
    }

    public void setSourceSystemAgreementIds(List<String> sourceSystemAgreementIds) {
        this.sourceSystemAgreementIds = sourceSystemAgreementIds;
    }

    public List<String> getSourceSystemAgreementIds() {
        return sourceSystemAgreementIds;
    }

    public void setInvoicingRuleId(String invoicingRuleId) {
        this.invoicingRuleId = new Guid(invoicingRuleId);
    }

    public void setMarketId(int marketId) {
        this.marketId = new Market(marketId);
    }

    public void setDisplayTDcommission(boolean displayTDcommission) {
        this.displayTDcommission = displayTDcommission;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
