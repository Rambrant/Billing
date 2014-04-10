package com.tradedoubler.billing.transform.json.gson;

import com.google.gson.*;
import com.tradedoubler.billing.domain.PaymentMethod;

import java.lang.reflect.Type;

/**
 * Custom serializer for Gson json transformation. It is used by the GsonFactory.
 * This serializer makes sure that the internal value is set and written with json, and not the actual class PaymentMethod.
 *
 * @author bjoek
 * @see GsonFactory for json example
 * @since 2012-08-17
 */
class PaymentMethodSerializer
        implements JsonSerializer<PaymentMethod>, JsonDeserializer<PaymentMethod> {
    @Override
    public JsonElement serialize(PaymentMethod src, Type srcType, JsonSerializationContext context) {
        return new JsonPrimitive(src.getValue());
    }

    @Override
    public PaymentMethod deserialize(JsonElement json, Type type, JsonDeserializationContext context)
            throws JsonParseException {
        return new PaymentMethod(json.getAsInt());
    }
}
