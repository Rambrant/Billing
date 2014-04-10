package com.tradedoubler.billing.type;

/**
 * @author Thomas Rambrant (thore)
 */

public enum CrmQueueType
{
    INVOICING_RULE_CREATED,
    INVOICING_RULE_UPDATED,
    CLIENT_UPDATED,
    AGREEMENT_UPDATED,
    MARKET_MESSAGE_UPDATED,
    INVOICE_RECIPIENT_DELETED,
    SPLITTING_RULE_DELETED
}
