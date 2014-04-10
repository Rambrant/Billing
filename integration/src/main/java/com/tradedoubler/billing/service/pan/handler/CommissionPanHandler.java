package com.tradedoubler.billing.service.pan.handler;

import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.pan.call.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Handles the operation to update 'display TD commission' in the Pan database.
 *
 * @author bjoek
 * @since 2012-09-26
 */
@Component
public class CommissionPanHandler {
    private final static Logger log = LoggerFactory.getLogger(CommissionPanHandler.class);

    @Autowired
    private DatabaseCallFactory databaseCallFactory;

    /** Update display TradeDoubler commission in the Pan system */
    public void updateDisplayTradeDoublerCommission(String sourceSystemAgreementId, boolean displayTradeDoublerCommission) throws BillingServiceException {
        UpdateCommissionCall call = databaseCallFactory.createCall(UpdateCommissionCall.class);

        if (sourceSystemAgreementId.startsWith("1-")) {
            int programId = extractProgramId(sourceSystemAgreementId);

            log.debug(String.format("Updating Display TD Commission, programId : %d isDisplay: %s",
                    programId, displayTradeDoublerCommission));

            call.updateDisplayCommission(programId, displayTradeDoublerCommission);
        } else {
            log.warn("The source system agreement id was not a program, cannot update display TD commission. sourceSystemAgreementId: " +
                    sourceSystemAgreementId);
        }
    }

    private int extractProgramId(String sourceSystemAgreementId) {
        // Remove the "1-" prefix
        String programIdString = sourceSystemAgreementId.substring(2, sourceSystemAgreementId.length());

        // Return the programId as number
        return Integer.parseInt(programIdString);
    }
}
