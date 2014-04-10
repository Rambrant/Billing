package com.tradedoubler.billing.transform.json.gson;

import com.google.gson.*;
import com.tradedoubler.billing.domain.Timestamp;

import java.lang.reflect.Type;

/**
 * Custom serializer for Gson json transformation. It is used by the GsonFactory.
 * This serializer makes sure that the internal value is set and written with json, and not the actual class Timestamp.
 *
 * @author bjoek
 * @see GsonFactory for json example
 * @since 2012-08-17
 */
class TimestampSerializer
        implements JsonSerializer<Timestamp>, JsonDeserializer<Timestamp> {
    @Override
    public JsonElement serialize(Timestamp src, Type srcType, JsonSerializationContext context) {
        return new JsonPrimitive(src.getTimestamp());
    }

    @Override
    public Timestamp deserialize(JsonElement json, Type type, JsonDeserializationContext context)
            throws JsonParseException {
        return new Timestamp(json.getAsString());
    }
}
