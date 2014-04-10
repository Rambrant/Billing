package com.tradedoubler.billing.transform.json.gson;

import com.google.gson.*;
import com.tradedoubler.billing.domain.*;

import java.lang.reflect.Type;

/**
 * Custom serializer for Gson json transformation. It is used by the GsonFactory.
 * This serializer makes sure that the internal value is set and written with json, and not the actual class InvoiceMessageRule.
 *
 * @author bjoek
 * @see GsonFactory for json example
 * @since 2012-09-26
 */
class InvoiceMessageRuleSerializer
        implements JsonSerializer<InvoiceMessageRule> {

    @Override
    public JsonElement serialize(InvoiceMessageRule src, Type typeOfSrc, JsonSerializationContext context) {
        return context.serialize(new InvoiceMessageRuleBase(src));
    }

    static private class InvoiceMessageRuleBase {
        private final String clientId;
        private final Guid invoiceMessageRuleId;
        private final Guid invoicingRuleId;
        private final Market marketId;
        private final String messageText;
        private final Timestamp validFrom;
        private final Timestamp validTo;

        InvoiceMessageRuleBase(InvoiceMessageRule src) {
            this.invoiceMessageRuleId = src.getInvoiceMessageRuleId();
            this.messageText = src.getMessageText();
            this.validFrom = src.getValidFrom();
            this.validTo = src.getValidTo();
            this.clientId = src instanceof ClientMessageRule ? ((ClientMessageRule) src).getClientId() : null;
            this.invoicingRuleId = src instanceof InvoicingRuleMessageRule ? ((InvoicingRuleMessageRule) src).getInvoicingRuleId() : null;
            this.marketId = src instanceof InvoiceIssuerMessageRule ? ((InvoiceIssuerMessageRule) src).getMarketId() : null;
        }
    }
}
