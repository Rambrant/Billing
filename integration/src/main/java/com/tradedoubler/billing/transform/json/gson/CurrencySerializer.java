package com.tradedoubler.billing.transform.json.gson;

import com.google.gson.*;
import com.tradedoubler.billing.domain.Currency;

import java.lang.reflect.Type;

/**
 * Custom serializer for Gson json transformation. It is used by the GsonFactory.
 * This serializer makes sure that the internal value is set and written with json, and not the actual class Currency.
 *
 * @author bjoek
 * @see GsonFactory for json example
 * @since 2012-08-17
 */
class CurrencySerializer
        implements JsonSerializer<Currency>, JsonDeserializer<Currency> {
    @Override
    public JsonElement serialize(Currency src, Type srcType, JsonSerializationContext context) {
        return new JsonPrimitive(src.getCurrencyCode());
    }

    @Override
    public Currency deserialize(JsonElement json, Type type, JsonDeserializationContext context)
            throws JsonParseException {
        return new Currency(json.getAsString());
    }
}
