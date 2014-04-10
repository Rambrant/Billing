package com.tradedoubler.billing.domain;

/**
 * Information about an invoice recipient that has been deleted
 *
 * @author bjoek
 * @since 2012-09-10
 */
public class InvoiceRecipientDeleted {

    private final MetaData metaData;
    private final Guid invoiceRecipientId;
    private final Market marketId;

    public InvoiceRecipientDeleted(MetaData metaData, String invoiceRecipientId, int marketId) {
        this.metaData = metaData;
        this.marketId = new Market(marketId);
        this.invoiceRecipientId = new Guid(invoiceRecipientId);
    }

    /** Meta data of the message itself */
    public MetaData getMetaData() {
        return metaData;
    }

    /** The invoice recipient that has been deleted */
    public Guid getInvoiceRecipientId() {
        return invoiceRecipientId;
    }

    /**
     * The PAN market id the invoice recipient refered to (derivated from the invoicing rule)
     * *A market id that is used to set the call context when executing the call. This is NOT the same
     * as "the invoice recipient should be removed from this market", the reason is that Invoice recipient is a global/virtual
     * object in dynamics ax and is not tied to any given market. For this reason any existing market id would suffice.
     */
    public Market getMarketId() {
        return marketId;
    }

}
