package com.tradedoubler.billing.service.pan.call;

import com.tradedoubler.billing.service.BillingServiceException;
import org.springframework.jdbc.core.simple.*;

import java.math.BigDecimal;

/**
 * Confirms in Pan that the invoicing job have started in Ax. This confirmation is not that Ax has order lines to invoice,
 * the invoicing job has finished or that the invoicing process succeeded, its just that Ax has been told to start invoicing.
 *
 * @author bjoek
 * @since 2012-09-26
 */
public class ConfirmReadyToInvoiceCall extends AbstractDatabaseCall {

    private final SimpleJdbcCall invoicingStarted;

    public ConfirmReadyToInvoiceCall(SimpleJdbcTemplate jdbcTemplate, SimpleJdbcCall invoicingStarted) {
        super(jdbcTemplate);
        this.invoicingStarted = invoicingStarted;
    }

    public void confirm() throws BillingServiceException {
        int callValue = invoicingStarted.executeFunction(BigDecimal.class).intValue();

        if (callValue == DB_FUNCTION_ERROR_CODE) {
            throw BillingServiceException.createBugDisturbance("Something went wrong when executing stored function billing_pkg.invoicingStarted in Pan database");
        }
    }
}
