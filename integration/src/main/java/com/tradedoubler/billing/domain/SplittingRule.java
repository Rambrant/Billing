package com.tradedoubler.billing.domain;

/**
 * A rule that separate order lines to different invoices
 *
 * @author bjoek
 * @since 2012-06-25
 */
public class SplittingRule {
    private final Guid invoiceRecipientId;
    private final String splitter;
    private final Guid splittingRuleId;

    public SplittingRule(String splittingRuleId, String invoiceRecipientId, String splitter) {
        this.splittingRuleId = new Guid(splittingRuleId);
        this.invoiceRecipientId = new Guid(invoiceRecipientId);
        this.splitter = splitter;
    }

    /** The CRM primary key for the splitting rule */
    public Guid getSplittingRuleId() {
        return splittingRuleId;
    }

    /** A reference to the invoice recipient the splitter refers to */
    public Guid getInvoiceRecipientId() {
        return invoiceRecipientId;
    }

    /** Custom event that shall be invoiced to selected Invoice recipient. */
    public String getSplitter() {
        return splitter;
    }
}
