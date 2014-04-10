package com.tradedoubler.billing.domain;

import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumMDSSalesMessageSourceType;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.transform.AxConverterService;

/**
 * A invoice rule message rule is an invoice message that is valid for a certain invoicing rule.
 *
 * @author bjoek
 * @since 2012-06-25
 */
public class InvoicingRuleMessageRule implements InvoiceMessageRule {
    private Guid invoiceMessageRuleId;

    private Guid invoicingRuleId;
    private String messageText;
    private final Timestamp validFrom;
    private final Timestamp validTo;

    public InvoicingRuleMessageRule(String invoiceMessageRuleId, String invoicingRuleId, String messageText, Timestamp validFrom, Timestamp validTo) {
        this.invoiceMessageRuleId = new Guid(invoiceMessageRuleId);
        this.invoicingRuleId = new Guid(invoicingRuleId);
        this.messageText = messageText;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    /** The primary id for the invoice message rule */
    @Override
    public Guid getInvoiceMessageRuleId() {
        return invoiceMessageRuleId;
    }

    /**
     * This is only set if the message belongs to an invoicing rule.
     * The CRM guid of the invoicing rule the message refers to
     */
    public Guid getInvoicingRuleId() {
        return invoicingRuleId;
    }

    public void setInvoicingRuleId(String invoicingRuleId) {
        this.invoicingRuleId = new Guid(invoicingRuleId);
    }

    /** Message text to be shown on the invoice */
    @Override
    public String getMessageText() {
        return messageText;
    }

    /** Start date for when the message shall be shown on invoices */
    @Override
    public Timestamp getValidFrom() {
        return validFrom;
    }

    /** End date for when the message shall be shown on invoices */
    @Override
    public Timestamp getValidTo() {
        return validTo;
    }

    @Override
    public AxdEnumMDSSalesMessageSourceType getSourceType() {
        return AxdEnumMDSSalesMessageSourceType.INVOICE_RULE;
    }

    @Override
    public String getParentPrimaryKeyForAx(AxConverterService converter) throws BillingServiceException {
        return invoiceMessageRuleId.getGuidForAx();
    }

    public void setInvoiceMessageRuleId(String invoiceMessageRuleId) {
        this.invoiceMessageRuleId = new Guid(invoiceMessageRuleId);
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
