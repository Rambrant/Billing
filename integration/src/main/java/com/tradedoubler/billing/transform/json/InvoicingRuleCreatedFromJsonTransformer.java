package com.tradedoubler.billing.transform.json;


import com.tradedoubler.billing.domain.*;
import org.springframework.stereotype.Component;

/**
 * Converts Json string to the domain object InvoicingRuleCreated. The actual conversion code is located in BillingAbstractTransformer
 *
 * @see BillingAbstractTransformer
 */
@Component
public class InvoicingRuleCreatedFromJsonTransformer extends BillingAbstractTransformer<InvoicingRuleCreated> {
    @Override
    protected Class<InvoicingRuleCreated> getDomainClass() {
        return InvoicingRuleCreated.class;
    }

    @Override
    protected String getEntityId(InvoicingRuleCreated domainObject) {
        return domainObject.getInvoicingRule().getInvoicingRuleId().getGuid();
    }

    @Override
    protected MetaData getMetaData(InvoicingRuleCreated domainObject) {
        return domainObject.getMetaData();
    }

}
