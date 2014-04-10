package com.tradedoubler.billing.service.pan.call;

import com.tradedoubler.billing.service.pan.PanDatabaseServiceSetup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Factory to create (instantiate) Pan database calls. The calls use PanDatabaseServiceSetup to find a cached jdbcTemplate,
 * cached transaction manager and cached stored procedures.
 * This class was originally created to simplify testing of flows with dummy database calls.
 *
 * @author bjoek
 * @since 2012-09-26
 */
@SuppressWarnings("unchecked")
@Component
public class DatabaseCallFactory {
    @Autowired
    private PanDatabaseServiceSetup serviceSetup;

    public <T extends AbstractDatabaseCall> T createCall(Class<T> clazz) {
        if (clazz == UpdateCommissionCall.class) {
            return (T) new UpdateCommissionCall(serviceSetup.getJdbcTemplate(), serviceSetup.getUpdateProgram());
        }
        if (clazz == InsertInvoicedOrderLineCall.class) {
            return (T) new InsertInvoicedOrderLineCall(serviceSetup.getJdbcTemplate(), serviceSetup.getTransactionTemplate(), serviceSetup.getInvoiceCreatedAx());
        }
        if (clazz == InvoiceStatusChangedCall.class) {
            return (T) new InvoiceStatusChangedCall(serviceSetup.getJdbcTemplate(), serviceSetup.getInvoiceStateChanged());
        }


        // --------- Confirm Calls ----------
        if (clazz == ConfirmOrderLinesCall.class) {
            return (T) new ConfirmOrderLinesCall(serviceSetup.getJdbcTemplate(), serviceSetup.getTransactionTemplate(), serviceSetup.getUpdateBatchOfOrderLines());
        }
        if (clazz == ConfirmReadyToInvoiceCall.class) {
            return (T) new ConfirmReadyToInvoiceCall(serviceSetup.getJdbcTemplate(), serviceSetup.getInvoicingStarted());
        }
        if (clazz == ConfirmPrepaymentForecastOrderLinesCall.class) {
            return (T) new ConfirmPrepaymentForecastOrderLinesCall(serviceSetup.getJdbcTemplate(), serviceSetup.getUpdateBatchOfOrderLinesPP());
        }
        if (clazz == ConfirmInvoicingRuleProcessedCall.class) {
            return (T) new ConfirmInvoicingRuleProcessedCall(serviceSetup.getJdbcTemplate());
        }
        if (clazz == ConfirmResellerClientProcessedCall.class) {
            return (T) new ConfirmResellerClientProcessedCall(serviceSetup.getJdbcTemplate());
        }


        // --------- Read Calls ----------
        if (clazz == ReadOrderLinesCall.class) {
            return (T) new ReadOrderLinesCall(serviceSetup.getJdbcTemplate(), serviceSetup.getFetchOrderLineBatchId());
        }
        if (clazz == ReadPrepaymentForecastOrderLinesCall.class) {
            return (T) new ReadPrepaymentForecastOrderLinesCall(serviceSetup.getJdbcTemplate(), serviceSetup.getFetchOrderLineBatchIdPP());
        }
        if (clazz == ReadReadyToInvoiceCall.class) {
            return (T) new ReadReadyToInvoiceCall(serviceSetup.getJdbcTemplate(), serviceSetup.getReadyToInvoice());
        }
        if (clazz == ReadCountryCodesCall.class) {
            return (T) new ReadCountryCodesCall(serviceSetup.getJdbcTemplate());
        }
        if (clazz == ReadDistributionModesCall.class) {
            return (T) new ReadDistributionModesCall(serviceSetup.getJdbcTemplate());
        }
        if (clazz == ReadAllMarketsCall.class) {
            return (T) new ReadAllMarketsCall(serviceSetup.getJdbcTemplate());
        }
        if (clazz == ReadActiveMarketsCall.class) {
            return (T) new ReadActiveMarketsCall(serviceSetup.getJdbcTemplate());
        }
        if (clazz == ReadPaymentMethodsCall.class) {
            return (T) new ReadPaymentMethodsCall(serviceSetup.getJdbcTemplate());
        }
        if (clazz == ReadPostingProfilesCall.class) {
            return (T) new ReadPostingProfilesCall(serviceSetup.getJdbcTemplate());
        }
        if (clazz == FetchCreateInvoicingRuleCall.class) {
            return (T) new FetchCreateInvoicingRuleCall(serviceSetup.getJdbcTemplate());
        }
        if (clazz == FetchUpdateInvoicingRuleCall.class) {
            return (T) new FetchUpdateInvoicingRuleCall(serviceSetup.getJdbcTemplate());
        }
        if (clazz == ReadUpdatedOrCreatedResellerCall.class) {
            return (T) new ReadUpdatedOrCreatedResellerCall(serviceSetup.getJdbcTemplate());
        }
        throw new IllegalArgumentException("Cannot handle " + clazz);
    }
}
