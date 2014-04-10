package com.tradedoubler.billing.domain;

/**
 * Common interface for entities that contains an invoicing rule, such as InvoicingRuleCreated or InvoicingRuleUpdated
 *
 * @author bjoek
 * @since 2012-10-05
 */
public interface ContainsInvoicingRule {
    InvoicingRule getInvoicingRule();
}
