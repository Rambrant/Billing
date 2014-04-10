package com.tradedoubler.billing.domain;

/** Information about an invoicing rule that has been updated in the CRM */
public class InvoicingRuleUpdated implements ContainsInvoicingRule {

    private final MetaData metaData;
    private final InvoicingRule invoicingRule;

    public InvoicingRuleUpdated(MetaData metaData, InvoicingRule invoicingRule) {
        this.metaData = metaData;
        this.invoicingRule = invoicingRule;
    }

    /** Meta data of the message itself */
    public MetaData getMetaData() {
        return metaData;
    }

    /** Information about the invoicing rule that has been updated */
    public InvoicingRule getInvoicingRule() {
        return invoicingRule;
    }

}
