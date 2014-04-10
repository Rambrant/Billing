package com.tradedoubler.billing.transform.json.gson;

import com.google.gson.*;
import com.tradedoubler.billing.domain.ClientType;

import java.lang.reflect.Type;

/**
 * Custom serializer for Gson json transformation. It is used by the GsonFactory.
 * This serializer makes sure that the internal value is set and written with json, and not the actual class RevenueType.
 *
 * @author bjoek
 * @see com.tradedoubler.billing.transform.json.gson.GsonFactory for json example
 * @since 2012-08-17
 */
class ClientTypeSerializer
        implements JsonSerializer<ClientType>, JsonDeserializer<ClientType> {
    @Override
    public JsonElement serialize(ClientType src, Type srcType, JsonSerializationContext context) {
        return new JsonPrimitive(src.getValue());
    }

    @Override
    public ClientType deserialize(JsonElement json, Type type, JsonDeserializationContext context)
            throws JsonParseException {
        return ClientType.getByValue(json.getAsInt());
    }
}
