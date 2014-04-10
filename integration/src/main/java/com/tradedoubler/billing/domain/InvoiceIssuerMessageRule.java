package com.tradedoubler.billing.domain;

import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumMDSSalesMessageSourceType;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.transform.AxConverterService;

/**
 * A invoice issuer message rule is an invoice message that is valid for a certain market (td organization).
 *
 * @since 2012-06-25
 */
public class InvoiceIssuerMessageRule implements InvoiceMessageRule {
    private Guid invoiceMessageRuleId;

    private Market marketId;
    private String messageText;
    private final Timestamp validFrom;
    private final Timestamp validTo;

    public InvoiceIssuerMessageRule(String invoiceMessageRuleId, int marketId, String messageText, Timestamp validFrom, Timestamp validTo) {
        this.invoiceMessageRuleId = new Guid(invoiceMessageRuleId);
        this.marketId = new Market(marketId);
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
     * This is only set if the message belongs to an invoice issuer.
     * The PAN Org Id of the market the message refers to
     */
    public Market getMarketId() {
        return marketId;
    }

    public void setMarketId(Integer marketId) {
        this.marketId = new Market(marketId);
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
        return AxdEnumMDSSalesMessageSourceType.COMPANY;
    }

    @Override
    public String getParentPrimaryKeyForAx(AxConverterService converter) throws BillingServiceException {
        return converter.convert(marketId);
    }

    public void setInvoiceMessageRuleId(String invoiceMessageRuleId) {
        this.invoiceMessageRuleId = new Guid(invoiceMessageRuleId);
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
