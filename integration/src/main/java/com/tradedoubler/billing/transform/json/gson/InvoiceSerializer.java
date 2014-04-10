package com.tradedoubler.billing.transform.json.gson;

import com.google.gson.*;
import com.tradedoubler.billing.domain.Invoice;
import com.tradedoubler.billing.domain.InvoicedAgreement;
import com.tradedoubler.billing.transform.ftp.InvoiceConverter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * User: erigu
 * Date: 2012-10-09
 */
class InvoiceSerializer implements JsonSerializer<Invoice> {
    @Override
    public JsonElement serialize(Invoice invoice, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonElement elem = new Gson().toJsonTree(invoice);
        InvoiceConverter invoiceConverter = new InvoiceConverter();
        JsonObject result = elem.getAsJsonObject();
        result.remove("currency");
        result.add("currencyCode", new JsonPrimitive(invoice.getCurrency()));

        if (invoice.getRevenueType() == InvoiceConverter.NO_REVENUE_TYPE) {
            result.remove("revenueType");
        }

        if (invoice.getLinkToInvoiceDocument() == null) {
            result.add("linkToInvoiceDocument", new JsonPrimitive("none"));
        }
        if (invoice.getLinkToInvoiceDocumentCopy() == null) {
            result.add("linkToInvoiceDocumentCopy", JsonNull.INSTANCE);
        }
        if (invoice.getOriginalInvoiceId() == null) {
            result.add("originalInvoiceId", JsonNull.INSTANCE);
        }
        if (invoice.getPaidDate() == null) {
            result.add("paidDate", JsonNull.INSTANCE);
        }

        result.remove("event");
        result.add("invoicingEvent", new JsonPrimitive(invoiceConverter.convertEventFromDomainToCRM(invoice.getEvent())));
        List<String> sourceSystemAgreementIds = new ArrayList<String>();


        for (InvoicedAgreement invoicedAgreement : invoice.getInvoicedAgreements()) {
            //CRM only accepts a list of unique agreement ids - therefore the contains check
            if (!sourceSystemAgreementIds.contains(invoicedAgreement.getSourceSystemAgreementID().trim())) {
                sourceSystemAgreementIds.add(invoicedAgreement.getSourceSystemAgreementID().trim());
            }
        }
        result.add("sourceSystemAgreementIds", jsonSerializationContext.serialize(sourceSystemAgreementIds));
        result.remove("marketId");
        result.add("marketId", new JsonPrimitive(invoice.getMarketId().getOrganizationId()));

        return result;
    }
}
