package com.tradedoubler.billing.service.pan.call;

import com.tradedoubler.billing.service.BillingServiceException;
import org.springframework.jdbc.core.simple.*;

import java.math.BigDecimal;

/**
 * A database call to update 'display TD commission' in Pan. This is handled by the flag SPLIT_REVENUES in Pan database.
 *
 * @author bjoek
 * @since 2012-09-26
 */
public class UpdateCommissionCall extends AbstractDatabaseCall {

    private final SimpleJdbcCall updateProgram;

    public UpdateCommissionCall(SimpleJdbcTemplate jdbcTemplate, SimpleJdbcCall updateProgram) {
        super(jdbcTemplate);
        this.updateProgram = updateProgram;
    }

    public void updateDisplayCommission(int programId, boolean displayTradeDoublerCommission) throws BillingServiceException {
        int status = updateProgram.executeFunction(BigDecimal.class, programId,
                "SPLIT_REVENUES", "S", 0, displayTradeDoublerCommission ? "Y" : "N").intValue();

        if (status == DB_FUNCTION_ERROR_CODE) {
            throw BillingServiceException.createBugDisturbance(
                    String.format("Could find program to update in pan, programId: %d", programId));
        }
    }
}
