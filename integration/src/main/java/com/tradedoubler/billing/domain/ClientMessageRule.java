package com.tradedoubler.billing.domain;

import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumMDSSalesMessageSourceType;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.transform.AxConverterService;

/**
 * A client message rule is an invoice message that is valid for a certain client
 *
 * @author bjoek
 * @since 2012-06-25
 */
public class ClientMessageRule implements InvoiceMessageRule {
    private String clientId;
    private Guid invoiceMessageRuleId;
    private String messageText;
    private final Timestamp validFrom;
    private final Timestamp validTo;

    public ClientMessageRule(String invoiceMessageRuleId, String clientId, String messageText, Timestamp validFrom, Timestamp validTo) {
        this.invoiceMessageRuleId = new Guid(invoiceMessageRuleId);
        this.clientId = clientId;
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
     * This is only set if the message belongs to a client.
     * The PAN Org Id of the client the message refers to
     */
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
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
        return AxdEnumMDSSalesMessageSourceType.CUSTOMER;
    }

    @Override
    public String getParentPrimaryKeyForAx(AxConverterService converter) throws BillingServiceException {
        return clientId;
    }

    public void setInvoiceMessageRuleId(String invoiceMessageRuleId) {
        this.invoiceMessageRuleId = new Guid(invoiceMessageRuleId);
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
