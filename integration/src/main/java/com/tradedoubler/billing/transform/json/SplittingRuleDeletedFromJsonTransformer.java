package com.tradedoubler.billing.transform.json;


import com.tradedoubler.billing.domain.MetaData;
import com.tradedoubler.billing.domain.SplittingRuleDeleted;
import org.springframework.stereotype.Component;

/**
 * Converts Json string to the domain object SplittingRuleDeleted. The actual conversion code is located in BillingAbstractTransformer
 *
 * @see BillingAbstractTransformer
 */
@Component
public class SplittingRuleDeletedFromJsonTransformer extends BillingAbstractTransformer<SplittingRuleDeleted> {
    @Override
    protected Class<SplittingRuleDeleted> getDomainClass() {
        return SplittingRuleDeleted.class;
    }

    @Override
    protected String getEntityId(SplittingRuleDeleted domainObject) {
        return domainObject.getSplittingRuleId().getGuid();
    }

    @Override
    protected MetaData getMetaData(SplittingRuleDeleted domainObject) {
        return domainObject.getMetaData();
    }

}
