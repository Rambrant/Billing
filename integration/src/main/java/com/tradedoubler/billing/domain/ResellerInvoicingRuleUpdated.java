package com.tradedoubler.billing.domain;

/**
 * Container object that holds both an invoicing rule update and an agreement update
 * to accomodate for the updating the invoicing-rule page in Spaceport for a reseller's customer's program.
 */
public class ResellerInvoicingRuleUpdated {

    private InvoicingRuleUpdated invoicingRuleUpdated;
    private AgreementUpdated agreementUpdated;
    private MetaData metaData;

    public ResellerInvoicingRuleUpdated(MetaData metaData, InvoicingRuleUpdated invoicingRuleUpdated, AgreementUpdated agreementUpdated) {
        this.metaData = metaData;
        this.invoicingRuleUpdated = invoicingRuleUpdated;
        this.agreementUpdated = agreementUpdated;
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    public InvoicingRuleUpdated getInvoicingRuleUpdated() {
        return invoicingRuleUpdated;
    }

    public void setInvoicingRuleUpdated(InvoicingRuleUpdated invoicingRuleUpdated) {
        this.invoicingRuleUpdated = invoicingRuleUpdated;
    }

    public AgreementUpdated getAgreementUpdated() {
        return agreementUpdated;
    }

    public void setAgreementUpdated(AgreementUpdated agreementUpdated) {
        this.agreementUpdated = agreementUpdated;
    }
}
