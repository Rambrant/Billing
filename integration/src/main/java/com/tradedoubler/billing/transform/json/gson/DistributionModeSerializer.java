package com.tradedoubler.billing.transform.json.gson;

import com.google.gson.*;
import com.tradedoubler.billing.domain.DistributionMode;

import java.lang.reflect.Type;

/**
 * Custom serializer for Gson json transformation. It is used by the GsonFactory.
 * This serializer makes sure that the internal value is set and written with json, and not the actual class DistributionMode.
 *
 * @author bjoek
 * @see GsonFactory for json example
 * @since 2012-08-17
 */
class DistributionModeSerializer
        implements JsonSerializer<DistributionMode>, JsonDeserializer<DistributionMode> {
    @Override
    public JsonElement serialize(DistributionMode src, Type srcType, JsonSerializationContext context) {
        return new JsonPrimitive(src.getValue());
    }

    @Override
    public DistributionMode deserialize(JsonElement json, Type type, JsonDeserializationContext context)
            throws JsonParseException {
        return new DistributionMode(json.getAsInt());
    }
}
