package com.tradedoubler.billing.domain;

import java.util.*;

/**
 * A recipient of invoices
 *
 * @author bjoek
 * @since 2012-06-25
 */
public class InvoiceRecipient {
    private final String attentionRow1;
    private String attentionRow2;
    private final boolean defaultRecipient;
    private final String emailAddress;
    private Guid invoiceRecipientId;
    private Guid invoicingRuleId;
    private final Address registeredAddress;
    private final List<SplittingRule> splittingRules = new ArrayList<SplittingRule>();

    public InvoiceRecipient(String invoiceRecipientId, String invoicingRuleId, String attentionRow1, String attentionRow2, String emailAddress, boolean defaultRecipient, Address registeredAddress, List<SplittingRule> splittingRules) {
        this.invoiceRecipientId = new Guid(invoiceRecipientId);
        this.invoicingRuleId = new Guid(invoicingRuleId);
        this.attentionRow1 = attentionRow1;
        this.attentionRow2 = attentionRow2;
        this.emailAddress = emailAddress;
        this.defaultRecipient = defaultRecipient;
        this.registeredAddress = registeredAddress;
        this.splittingRules.addAll(splittingRules);
    }
    
    /** The primary id for the invoice recipient */
    public Guid getInvoiceRecipientId() {
        return invoiceRecipientId;
    }

    /** The id of the invoicing rule the recipient refers to */
    public Guid getInvoicingRuleId() {
        return invoicingRuleId;
    }

    public void setInvoicingRuleId(String invoicingRuleId) {
        this.invoicingRuleId = new Guid(invoicingRuleId);
    }

    /** Used for attention information in invoice address. (may be null) */
    public String getAttentionRow1() {
        return attentionRow1;
    }

    /** Used for attention information in invoice address. (may be null) */
    public String getAttentionRow2() {
        return attentionRow2;
    }

    /**
     * Email address to be used when emailing invoices. (may be null)
     * <p/>
     * Pattern : \\b[A-Za-z0-9._%-]+\\@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /** Set to true if the recipient is intended to be used as default invoice recipient for current invoicing rule. */
    public boolean isDefaultRecipient() {
        return defaultRecipient;
    }

    /** The invoicing address of the recipient */
    public Address getRegisteredAddress() {
        return registeredAddress;
    }

    /** The splitting rules of the recipient */
    public List<SplittingRule> getSplittingRules() {
        return splittingRules;
    }

    /**
     * Used for test
     */
    public void setInvoiceRecipientId(String invoiceRecipientId) {
        this.invoiceRecipientId = new Guid(invoiceRecipientId);
    }

    /**
     * Used for test
     */
    public void setAttentionRow2(String attentionRow2) {
        this.attentionRow2 = attentionRow2;
    }
}
