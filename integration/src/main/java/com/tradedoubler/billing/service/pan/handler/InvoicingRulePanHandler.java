package com.tradedoubler.billing.service.pan.handler;

import com.tradedoubler.billing.domain.Guid;
import com.tradedoubler.billing.domain.InvoicingRuleCreated;
import com.tradedoubler.billing.domain.ResellerClientUpdated;
import com.tradedoubler.billing.domain.ResellerInvoicingRuleUpdated;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.pan.call.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Handles reseller create and update invoicing rules in the Pan database.
 */
@Component
public class InvoicingRulePanHandler {
    private final static Logger log = LoggerFactory.getLogger(InvoicingRulePanHandler.class);

    @Autowired
    private DatabaseCallFactory databaseCallFactory;

    public InvoicingRuleCreated fetchCreatedInvoicingRule() {
        FetchCreateInvoicingRuleCall call = databaseCallFactory.createCall(FetchCreateInvoicingRuleCall.class);
        return call.fetchInvoicingRule();
    }

    public ResellerInvoicingRuleUpdated fetchUpdatedInvoicingRule() {
        FetchUpdateInvoicingRuleCall call = databaseCallFactory.createCall(FetchUpdateInvoicingRuleCall.class);
        return call.fetchResellerInvoicingRule();
    }

    public void confirmInvoicingRuleProcessed(String resellerInvoicingRuleEventGuid) {
        log.debug("About to run SQL to admin to update events table for guid: " + resellerInvoicingRuleEventGuid);
        ConfirmInvoicingRuleProcessedCall call = databaseCallFactory.createCall(ConfirmInvoicingRuleProcessedCall.class);
        call.confirmInvoicingRuleProcessed(resellerInvoicingRuleEventGuid);
    }

    public ResellerClientUpdated getUpdatedOrCreatedReseller() throws BillingServiceException {
        ReadUpdatedOrCreatedResellerCall call = databaseCallFactory.createCall(ReadUpdatedOrCreatedResellerCall.class);
        call.read();
        return call.getReseller();
    }

    public void confirmResellerClientProcessed(Guid resellerClientEventGuid) {
        log.info("About to confirm a reseller client as being processed, guid: " + resellerClientEventGuid.getGuidForOracleDb());
        ConfirmResellerClientProcessedCall call = databaseCallFactory.createCall(ConfirmResellerClientProcessedCall.class);
        call.confirm(resellerClientEventGuid);
    }
}

