package com.tradedoubler.billing.transform.json;


import com.tradedoubler.billing.domain.*;
import org.springframework.stereotype.Component;

/**
 * Converts Json string to the domain object ClientUpdated. The actual conversion code is located in BillingAbstractTransformer
 *
 * @see BillingAbstractTransformer
 */
@Component
public class ClientUpdatedFromJsonTransformer extends BillingAbstractTransformer<ClientUpdated> {
    @Override
    protected Class<ClientUpdated> getDomainClass() {
        return ClientUpdated.class;
    }

    @Override
    protected String getEntityId(ClientUpdated domainObject) {
        return domainObject.getClient().getClientId();
    }

    @Override
    protected MetaData getMetaData(ClientUpdated domainObject) {
        return domainObject.getMetaData();
    }

}
