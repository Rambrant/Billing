package com.tradedoubler.billing.service.pan.call;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.*;

/**
 * Confirms to admindb that an invoicing rule has been successfully delivered to AX.
 */
public class ConfirmInvoicingRuleProcessedCall extends AbstractDatabaseCall {

    private final static Logger log = LoggerFactory.getLogger(ConfirmInvoicingRuleProcessedCall.class);

    ConfirmInvoicingRuleProcessedCall(SimpleJdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public void confirmInvoicingRuleProcessed(String resellerInvoiceRulesEventGuid) {
        getJdbcTemplate().update("UPDATE RESELLER_INVOICE_RULES_EVENTS SET PROCESSED='Y' WHERE RESELLER_INV_RULE_EVENT_ID like ?",resellerInvoiceRulesEventGuid);
    }
}

