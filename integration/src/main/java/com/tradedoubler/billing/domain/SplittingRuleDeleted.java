package com.tradedoubler.billing.domain;

/**
 * Information about a splitting rule that has been deleted
 *
 * @author bjoek
 * @since 2012-09-10
 */
public class SplittingRuleDeleted {
    private final MetaData metaData;
    private Guid splittingRuleId;
    private final Guid invoiceRecipientId;
    private final Market marketId;

    public SplittingRuleDeleted(MetaData metaData, String splittingRuleId, String invoiceRecipientId, int marketId) {
        this.metaData = metaData;
        this.splittingRuleId = new Guid(splittingRuleId);
        this.invoiceRecipientId = new Guid(invoiceRecipientId);
        this.marketId = new Market(marketId);
    }

    /** Meta data of the message itself */
    public MetaData getMetaData() {
        return metaData;
    }

    /** The CRM primary key for the deleted splitting rule */
    public Guid getSplittingRuleId() {
        return splittingRuleId;
    }

    public void setSplittingRuleId(String splittingRuleId) {
        this.splittingRuleId = new Guid(splittingRuleId);
    }

    /** The invoice recipient the splitter refered to */
    public Guid getInvoiceRecipientId() {
        return invoiceRecipientId;
    }

    /** The PAN market id the splitting rule refered to (derivated from the invoicing rule) */
    public Market getMarketId() {
        return marketId;
    }
}
