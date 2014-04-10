package com.tradedoubler.billing.transform.json;


import com.tradedoubler.billing.domain.*;
import org.springframework.stereotype.Component;

/**
 * Converts Json string to the domain object InvoicingRuleUpdated. The actual conversion code is located in BillingAbstractTransformer
 *
 * @see BillingAbstractTransformer
 */
@Component
public class InvoicingRuleUpdatedFromJsonTransformer extends BillingAbstractTransformer<InvoicingRuleUpdated> {
    @Override
    protected Class<InvoicingRuleUpdated> getDomainClass() {
        return InvoicingRuleUpdated.class;
    }

    @Override
    protected String getEntityId(InvoicingRuleUpdated domainObject) {
        return domainObject.getInvoicingRule().getInvoicingRuleId().getGuid();
    }

    @Override
    protected MetaData getMetaData(InvoicingRuleUpdated domainObject) {
        return domainObject.getMetaData();
    }

}
