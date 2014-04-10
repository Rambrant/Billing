package com.tradedoubler.billing.service.pan.call;

import com.tradedoubler.billing.service.BillingServiceException;
import org.springframework.jdbc.core.simple.*;

/**
 * Checks if Pan wants Ax to start invoicing. The invoicing operation is confirmed by ConfirmReadyToInvoiceCall
 *
 * @author bjoek
 * @since 2012-09-26
 */
public class ReadReadyToInvoiceCall extends AbstractDatabaseCall {

    private boolean readyToInvoiceStatus = false;
    private final SimpleJdbcCall readyToInvoice;

    public ReadReadyToInvoiceCall(SimpleJdbcTemplate jdbcTemplate, SimpleJdbcCall readyToInvoice) {
        super(jdbcTemplate);
        this.readyToInvoice = readyToInvoice;
    }

    /**
     * Read the status from Pan.
     *
     * @throws BillingServiceException thrown if the function sends fail code back.
     */
    public void read() throws BillingServiceException {
        String callValue = readyToInvoice.executeFunction(String.class);

        if (callValue.equalsIgnoreCase("Y")) {
            readyToInvoiceStatus = true;
        } else if (callValue.equalsIgnoreCase("N")) {
            readyToInvoiceStatus = false;
        } else {
            throw BillingServiceException.createBugDisturbance(String.format(
                    "Something went wrong when executing stored function billing_pkg.readyToInvoice in Pan database, returnValue: %s",
                    callValue));
        }
    }

    public String getVersion() {
        return "1.0";
    }

    public String getSourceSystemId() {
        return "PAN";
    }

    public boolean isReadyToInvoice() {
        return readyToInvoiceStatus;
    }
}
