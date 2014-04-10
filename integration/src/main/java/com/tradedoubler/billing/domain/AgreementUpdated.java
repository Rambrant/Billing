package com.tradedoubler.billing.domain;

/**
 * Information about an agreement that has been updated in the CRM
 *
 * @author bjoek
 * @since 2012-07-03
 */
public class AgreementUpdated {
    private final MetaData metaData;
    private final Agreement agreement;

    public AgreementUpdated(MetaData metaData, Agreement agreement) {
        this.metaData = metaData;
        this.agreement = agreement;
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public Agreement getAgreement() {
        return agreement;
    }
}
