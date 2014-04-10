package com.tradedoubler.billing.transform.json.gson;

import com.google.gson.*;
import com.tradedoubler.billing.domain.Guid;

import java.lang.reflect.Type;

/**
 * Custom serializer for Gson json transformation. It is used by the GsonFactory.
 * This serializer makes sure that the internal value is set and written with json, and not the actual class Guid.
 *
 * @author bjoek
 * @see GsonFactory for json example
 * @since 2012-08-17
 */
class GuidSerializer
        implements JsonSerializer<Guid>, JsonDeserializer<Guid> {
    @Override
    public JsonElement serialize(Guid src, Type srcType, JsonSerializationContext context) {
        return new JsonPrimitive(src.getGuid());
    }

    @Override
    public Guid deserialize(JsonElement json, Type type, JsonDeserializationContext context)
            throws JsonParseException {
        return new Guid(json.getAsString());
    }
}
