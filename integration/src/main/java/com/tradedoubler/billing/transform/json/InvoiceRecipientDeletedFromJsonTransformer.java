package com.tradedoubler.billing.transform.json;


import com.tradedoubler.billing.domain.InvoiceRecipientDeleted;
import com.tradedoubler.billing.domain.MetaData;
import org.springframework.stereotype.Component;

/**
 * Converts Json string to the domain object InvoiceRecipientDeleted. The actual conversion code is located in BillingAbstractTransformer
 *
 * @see BillingAbstractTransformer
 */
@Component
public class InvoiceRecipientDeletedFromJsonTransformer extends BillingAbstractTransformer<InvoiceRecipientDeleted> {
    @Override
    protected Class<InvoiceRecipientDeleted> getDomainClass() {
        return InvoiceRecipientDeleted.class;
    }

    @Override
    protected String getEntityId(InvoiceRecipientDeleted domainObject) {
        return domainObject.getInvoiceRecipientId().getGuid();
    }

    @Override
    protected MetaData getMetaData(InvoiceRecipientDeleted domainObject) {
        return domainObject.getMetaData();
    }

}
