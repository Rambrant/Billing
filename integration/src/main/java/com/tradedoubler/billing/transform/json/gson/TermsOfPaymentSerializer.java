package com.tradedoubler.billing.transform.json.gson;

import com.google.gson.*;
import com.tradedoubler.billing.domain.TermsOfPayment;

import java.lang.reflect.Type;

/**
 * Custom serializer for Gson json transformation. It is used by the GsonFactory.
 * This serializer makes sure that the internal value is set and written with json, and not the actual class TermsOfPayment.
 *
 * @author bjoek
 * @see GsonFactory for json example
 * @since 2012-08-17
 */
class TermsOfPaymentSerializer
        implements JsonSerializer<TermsOfPayment>, JsonDeserializer<TermsOfPayment> {
    @Override
    public JsonElement serialize(TermsOfPayment src, Type srcType, JsonSerializationContext context) {
        return new JsonPrimitive(src.getDays());
    }

    @Override
    public TermsOfPayment deserialize(JsonElement json, Type type, JsonDeserializationContext context)
            throws JsonParseException {
        return new TermsOfPayment(json.getAsInt());
    }
}
