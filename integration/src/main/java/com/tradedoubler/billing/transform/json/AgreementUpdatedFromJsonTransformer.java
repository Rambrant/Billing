package com.tradedoubler.billing.transform.json;


import com.tradedoubler.billing.domain.*;
import org.springframework.stereotype.Component;

/**
 * Converts Json string to the domain object AgreementUpdated. The actual conversion code is located in BillingAbstractTransformer
 *
 * @see BillingAbstractTransformer
 */
@Component
public class AgreementUpdatedFromJsonTransformer extends BillingAbstractTransformer<AgreementUpdated> {
    @Override
    protected Class<AgreementUpdated> getDomainClass() {
        return AgreementUpdated.class;
    }

    @Override
    protected String getEntityId(AgreementUpdated domainObject) {
        return domainObject.getAgreement().getSourceSystemAgreementId();
    }

    @Override
    protected MetaData getMetaData(AgreementUpdated domainObject) {
        return domainObject.getMetaData();
    }

}
