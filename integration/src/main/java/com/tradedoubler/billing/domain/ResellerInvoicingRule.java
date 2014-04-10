package com.tradedoubler.billing.domain;

/**
 * TODO
 * Created by IntelliJ IDEA.
 * User: mattjo
 * Date: 2012-12-27
 * Time: 09:14
 * To change this template use File | Settings | File Templates.
 */
public class ResellerInvoicingRule {

    // Client attributes
    private long clientId;

    // Invoicing rule attributes
    private long resellerInvoicingRulePk;
    private int marketId;
    private String invoicingRuleId;
    private String invoicingRuleName;
    private String description;
    private String issuerReference;
    private String clientReference;
    private String currencyCode;
    private int distributionMode;
    private int termsOfPayment;
    private int postingProfile;
    private boolean displayTDcommission;
    private int revenueType = 2; // PVN
    private int paymentMethod;
    private boolean deviatingExchangeRate;

    // Invoicing rule message attributes
    private String invoiceMessageRuleId;
    private String invoiceMessage;
    private com.tradedoubler.billing.domain.Timestamp invoiceMessageValidFrom;
    private com.tradedoubler.billing.domain.Timestamp invoiceMessageValidTo;


    // Invoice recipient attributes
    private String invoiceRecipientId;
    private String attentionRow1;
    private String attentionRow2;
    private String emailAddress;
    private boolean defaultRecipient = true;

    // Invoicing address
    private String city;
    private String countryCode;
    private String addressLine1;
    private String addressLine2;
    private String postalCode;
    private int addressType;
    private String county;


    // Agreement
    private String sourceSystemAgreementId;
    private String agreementDescription;
    private int productType;
    private int agreementMarketId;
    private String agreementCurrencyCode;
    private com.tradedoubler.billing.domain.Timestamp validFrom;
    private com.tradedoubler.billing.domain.Timestamp validTo;
    private String documentLink;



    public long getResellerInvoicingRulePk() {
        return resellerInvoicingRulePk;
    }

    public void setResellerInvoicingRulePk(long resellerInvoicingRulePk) {
        this.resellerInvoicingRulePk = resellerInvoicingRulePk;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public int getMarketId() {
        return marketId;
    }

    public void setMarketId(int marketId) {
        this.marketId = marketId;
    }

    public String getInvoicingRuleId() {
        return invoicingRuleId;
    }

    public void setInvoicingRuleId(String invoicingRuleId) {
        this.invoicingRuleId = invoicingRuleId;
    }

    public String getInvoicingRuleName() {
        return invoicingRuleName;
    }

    public void setInvoicingRuleName(String invoicingRuleName) {
        this.invoicingRuleName = invoicingRuleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIssuerReference() {
        return issuerReference;
    }

    public void setIssuerReference(String issuerReference) {
        this.issuerReference = issuerReference;
    }

    public String getClientReference() {
        return clientReference;
    }

    public void setClientReference(String clientReference) {
        this.clientReference = clientReference;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public int getDistributionMode() {
        return distributionMode;
    }

    public void setDistributionMode(int distributionMode) {
        this.distributionMode = distributionMode;
    }

    public int getTermsOfPayment() {
        return termsOfPayment;
    }

    public void setTermsOfPayment(int termsOfPayment) {
        this.termsOfPayment = termsOfPayment;
    }

    public int getPostingProfile() {
        return postingProfile;
    }

    public void setPostingProfile(int postingProfile) {
        this.postingProfile = postingProfile;
    }

    public boolean isDisplayTDcommission() {
        return displayTDcommission;
    }

    public void setDisplayTDcommission(boolean displayTDcommission) {
        this.displayTDcommission = displayTDcommission;
    }

    public int getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean isDeviatingExchangeRate() {
        return deviatingExchangeRate;
    }

    public void setDeviatingExchangeRate(boolean deviatingExchangeRate) {
        this.deviatingExchangeRate = deviatingExchangeRate;
    }

    public int getRevenueType() {
        return revenueType;
    }

    public String getInvoiceRecipientId() {
        return invoiceRecipientId;
    }

    public void setInvoiceRecipientId(String invoiceRecipientId) {
        this.invoiceRecipientId = invoiceRecipientId;
    }

    public String getAttentionRow1() {
        return attentionRow1;
    }

    public void setAttentionRow1(String attentionRow1) {
        this.attentionRow1 = attentionRow1;
    }

    public String getAttentionRow2() {
        return attentionRow2;
    }

    public void setAttentionRow2(String attentionRow2) {
        this.attentionRow2 = attentionRow2;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public boolean isDefaultRecipient() {
        return defaultRecipient;
    }

    public int getAddressType() {
        return addressType;
    }

    public String getSourceSystemAgreementId() {
        return sourceSystemAgreementId;
    }

    public void setSourceSystemAgreementId(String sourceSystemAgreementId) {
        this.sourceSystemAgreementId = sourceSystemAgreementId;
    }

    public String getAgreementDescription() {
        return agreementDescription;
    }

    public void setAgreementDescription(String agreementDescription) {
        this.agreementDescription = agreementDescription;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public int getAgreementMarketId() {
        return agreementMarketId;
    }

    public void setAgreementMarketId(int agreementMarketId) {
        this.agreementMarketId = agreementMarketId;
    }

    public String getAgreementCurrencyCode() {
        return agreementCurrencyCode;
    }

    public void setAgreementCurrencyCode(String agreementCurrencyCode) {
        this.agreementCurrencyCode = agreementCurrencyCode;
    }

    public Timestamp getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Timestamp validFrom) {
        this.validFrom = validFrom;
    }

    public Timestamp getValidTo() {
        return validTo;
    }

    public void setValidTo(Timestamp validTo) {
        this.validTo = validTo;
    }

    public String getDocumentLink() {
        return documentLink;
    }

    public void setDocumentLink(String documentLink) {
        this.documentLink = documentLink;
    }

    public String getInvoiceMessage() {
        return invoiceMessage;
    }

    public void setInvoiceMessage(String invoiceMessage) {
        this.invoiceMessage = invoiceMessage;
    }

    public Timestamp getInvoiceMessageValidFrom() {
        return invoiceMessageValidFrom;
    }

    public void setInvoiceMessageValidFrom(Timestamp invoiceMessageValidFrom) {
        this.invoiceMessageValidFrom = invoiceMessageValidFrom;
    }

    public Timestamp getInvoiceMessageValidTo() {
        return invoiceMessageValidTo;
    }

    public void setInvoiceMessageValidTo(Timestamp invoiceMessageValidTo) {
        this.invoiceMessageValidTo = invoiceMessageValidTo;
    }

    public String getInvoiceMessageRuleId() {
        return invoiceMessageRuleId;
    }

    public void setInvoiceMessageRuleId(String invoiceMessageRuleId) {
        this.invoiceMessageRuleId = invoiceMessageRuleId;
    }

    @Override
    public String toString() {
        return "ResellerInvoicingRule{" +
                "clientId=" + clientId +
                ", resellerInvoicingRulePk=" + resellerInvoicingRulePk +
                ", marketId=" + marketId +
                ", invoicingRuleId='" + invoicingRuleId + '\'' +
                ", invoicingRuleName='" + invoicingRuleName + '\'' +
                ", description='" + description + '\'' +
                ", issuerReference='" + issuerReference + '\'' +
                ", clientReference='" + clientReference + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                ", distributionMode=" + distributionMode +
                ", termsOfPayment=" + termsOfPayment +
                ", postingProfile=" + postingProfile +
                ", displayTDcommission=" + displayTDcommission +
                ", revenueType=" + revenueType +
                ", paymentMethod=" + paymentMethod +
                ", deviatingExchangeRate=" + deviatingExchangeRate +
                ", invoiceMessageRuleId='" + invoiceMessageRuleId + '\'' +
                ", invoiceMessage='" + invoiceMessage + '\'' +
                ", invoiceMessageValidFrom=" + invoiceMessageValidFrom +
                ", invoiceMessageValidTo=" + invoiceMessageValidTo +
                ", invoiceRecipientId='" + invoiceRecipientId + '\'' +
                ", attentionRow1='" + attentionRow1 + '\'' +
                ", attentionRow2='" + attentionRow2 + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", defaultRecipient=" + defaultRecipient +
                ", city='" + city + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", addressType=" + addressType +
                ", county='" + county + '\'' +
                ", sourceSystemAgreementId='" + sourceSystemAgreementId + '\'' +
                ", agreementDescription='" + agreementDescription + '\'' +
                ", productType=" + productType +
                ", agreementMarketId=" + agreementMarketId +
                ", agreementCurrencyCode='" + agreementCurrencyCode + '\'' +
                ", validFrom=" + validFrom +
                ", validTo=" + validTo +
                ", documentLink='" + documentLink + '\'' +
                '}';
    }
}
