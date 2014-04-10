package com.tradedoubler.billing.service.crm.handler;

import com.tradedoubler.billing.domain.Guid;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.validate.GUIDValidator;

/**
 * Creates new Guids by combining an original Guid and additional information
 * @author bjoek
 * @since 2013-03-06
 */
public class MessageGuidGenerator {
    private final Guid baseGuid;
    private final String baseGuidFirstPart;

    /** Create generator using base guid */
    public MessageGuidGenerator(Guid baseGuid) {
        this.baseGuid = baseGuid;

        String baseGuidString = baseGuid.getGuid();
        this.baseGuidFirstPart = baseGuidString.substring(0, baseGuidString.length() - 8);
    }

    /** Add a program id as the last part to the original guid and return the combined guid */
    public Guid generateCompositeGuid(String systemAgreementId) throws BillingServiceException {
        String agreementSecondPart = getAgreementSubString(systemAgreementId);

        Guid combinedGuid = new Guid(baseGuidFirstPart.concat(agreementSecondPart));

        boolean isGuid = GUIDValidator.validateGUI(combinedGuid);

        if (!isGuid) {
            throw BillingServiceException.createBugDisturbance(String.format(
                    "Failed to create unique Guid for Update prepayment forecast from %s and %s",
                    baseGuid.getGuid(),
                    systemAgreementId));
        }

        return combinedGuid;
    }

    private String getAgreementSubString(String systemAgreementId) {
        // First part identifies subsystem
        String programId = systemAgreementId.substring(2);

        // pad with zeroes
        programId = "0000000" + programId;

        // return 8 last characters
        return programId.substring(programId.length() - 8);
    }
}
