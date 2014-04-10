package com.tradedoubler.billing.domain;

/** Information about an invoicing rule that has been created in the CRM */
public class InvoicingRuleCreated implements ContainsInvoicingRule {

    private final MetaData metaData;
    private final Agreement agreement;
    private final Client client;
    private final InvoicingRule invoicingRule;

    public InvoicingRuleCreated(MetaData metaData, InvoicingRule invoicingRule, Agreement agreement, Client client) {
        this.metaData = metaData;
        this.invoicingRule = invoicingRule;
        this.agreement = agreement;
        this.client = client;
    }

    /** Meta data of the message itself */
    public MetaData getMetaData() {
        return metaData;
    }

    /** Information about the invoicing rule that has been created */
    public InvoicingRule getInvoicingRule() {
        return invoicingRule;
    }

    /** Information about the agreement that has been created/attached to the invoicing rule */
    public Agreement getAgreement() {
        return agreement;
    }

    /** Information about the client the invoicing rule refers to */
    public Client getClient() {
        return client;
    }
}
