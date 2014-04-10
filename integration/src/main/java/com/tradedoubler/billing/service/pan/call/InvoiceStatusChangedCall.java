package com.tradedoubler.billing.service.pan.call;

import com.tradedoubler.billing.service.BillingServiceException;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.math.BigDecimal;

/**
* Call to change invoice state in Pan
 */
public class InvoiceStatusChangedCall extends AbstractDatabaseCall {

    private final SimpleJdbcCall invoiceStateChanged;

    InvoiceStatusChangedCall(SimpleJdbcTemplate jdbcTemplate, SimpleJdbcCall invoiceStateChanged) {
        super(jdbcTemplate);
        this.invoiceStateChanged = invoiceStateChanged;
    }

    public void updateState(String invoiceId, int invoiceStatus) throws BillingServiceException {
                  int status = invoiceStateChanged.executeFunction(BigDecimal.class, invoiceId, invoiceStatus).intValue();

        if (status == DB_FUNCTION_ERROR_CODE) {
            throw BillingServiceException.createBugDisturbance(
                    String.format("BUG_DISTURBANCE : Could not update invoice with id %s and status %d", invoiceId, status));
        }
    }
}
