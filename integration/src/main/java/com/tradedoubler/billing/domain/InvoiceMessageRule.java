package com.tradedoubler.billing.domain;

import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumMDSSalesMessageSourceType;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.transform.AxConverterService;

/**
 * Common interface for messages that will be printed on an invoice. The message rules are always connected to a parent
 * that can be either a Client, a Market or an Invoicing Rule
 *
 * @author bjoek
 * @since 2012-09-26
 */
public interface InvoiceMessageRule {
    /** The primary id for the invoice message rule */
    Guid getInvoiceMessageRuleId();

    /** Message text to be shown on the invoice */
    String getMessageText();

    /** Start date for when the message shall be shown on invoices */
    Timestamp getValidFrom();

    /** End date for when the message shall be shown on invoices */
    Timestamp getValidTo();

    /** Indicates if the message rules parent is a Client, Market or Invoicing Rule */
    AxdEnumMDSSalesMessageSourceType getSourceType();

    /** Reference to parents primary key */
    String getParentPrimaryKeyForAx(AxConverterService converter) throws BillingServiceException;
}
