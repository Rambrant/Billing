package com.tradedoubler.billing.transform.json;


import com.tradedoubler.billing.domain.*;
import org.springframework.stereotype.Component;

/**
 * Converts Json string to the domain object MarketMessageUpdated. The actual conversion code is located in BillingAbstractTransformer
 *
 * @see BillingAbstractTransformer
 */
@Component
public class MarketMessageUpdatedFromJsonTransformer extends BillingAbstractTransformer<MarketMessageUpdated> {
    @Override
    protected Class<MarketMessageUpdated> getDomainClass() {
        return MarketMessageUpdated.class;
    }

    @Override
    protected String getEntityId(MarketMessageUpdated domainObject) {
        return domainObject.getInvoiceMessageRule().getInvoiceMessageRuleId().getGuid();
    }

    @Override
    protected MetaData getMetaData(MarketMessageUpdated domainObject) {
        return domainObject.getMetaData();
    }

}
