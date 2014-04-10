package com.tradedoubler.billing.service.pan.call;

import com.tradedoubler.billing.domain.Guid;
import com.tradedoubler.billing.service.BillingServiceException;
import org.springframework.jdbc.core.simple.*;

import java.math.BigDecimal;

/**
 * Confirm in Pan that forecast order lines have been sent to Crm.
 *
 * @author bjorn
 * @since 2012-10-10
 */
public class ConfirmPrepaymentForecastOrderLinesCall extends AbstractDatabaseCall {

    private final SimpleJdbcCall updateBatchOfOrderLinesPP;

    public ConfirmPrepaymentForecastOrderLinesCall(SimpleJdbcTemplate jdbcTemplate, SimpleJdbcCall updateBatchOfOrderLinesPP) {
        super(jdbcTemplate);
        this.updateBatchOfOrderLinesPP = updateBatchOfOrderLinesPP;
    }

    /**
     * Confirms that forecasts have been sent to CRM.
     *
     * @param batchId the batch to confirm
     * @throws com.tradedoubler.billing.service.BillingServiceException
     *          thrown if database operation fails
     */
    public void confirm(final Guid batchId) throws BillingServiceException {
        int returnValue = updateBatchOfOrderLinesPP.executeFunction(BigDecimal.class,
                batchId.getGuidForOracleDb()).intValue();

        if (returnValue == DB_FUNCTION_ERROR_CODE) {
            throw BillingServiceException.createBugDisturbance("Something went wrong when executing stored function billing_pkg.updateBatchOfOrderLines in Pan database" +
                    ", batchId: " + batchId.getGuidForOracleDb());
        }
    }
}
