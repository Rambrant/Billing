package com.tradedoubler.billing.transform.json.gson;

import com.google.gson.*;
import com.tradedoubler.billing.domain.Market;

import java.lang.reflect.Type;

/**
 * Custom serializer for Gson json transformation. It is used by the GsonFactory.
 * This serializer makes sure that the internal value is set and written with json, and not the actual class Market.
 *
 * @author bjoek
 * @see GsonFactory for json example
 * @since 2012-08-17
 */
class MarketSerializer
        implements JsonSerializer<Market>, JsonDeserializer<Market> {
    @Override
    public JsonElement serialize(Market src, Type srcType, JsonSerializationContext context) {
        return new JsonPrimitive(src.getOrganizationId());
    }

    @Override
    public Market deserialize(JsonElement json, Type type, JsonDeserializationContext context)
            throws JsonParseException {
        return new Market(json.getAsInt());
    }
}
