package com.tradedoubler.billing.domain;

/**
 * Information about an invoice message rule related to a market
 *
 * @since 2012-08-17
 */
public class MarketMessageUpdated {
    private final MetaData metaData;
    private final InvoiceIssuerMessageRule invoiceMessageRule;

    public MarketMessageUpdated(MetaData metaData, InvoiceIssuerMessageRule invoiceMessageRule) {
        this.metaData = metaData;
        this.invoiceMessageRule = invoiceMessageRule;
    }

    /** Meta data of the message itself */
    public MetaData getMetaData() {
        return metaData;
    }

    /** Information about the message that has been created or updated */
    public InvoiceIssuerMessageRule getInvoiceMessageRule() {
        return invoiceMessageRule;
    }

}