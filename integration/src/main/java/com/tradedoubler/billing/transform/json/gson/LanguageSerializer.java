package com.tradedoubler.billing.transform.json.gson;

import com.google.gson.*;
import com.tradedoubler.billing.domain.Language;

import java.lang.reflect.Type;

/**
 * Custom serializer for Gson json transformation. It is used by the GsonFactory.
 * This serializer makes sure that the internal value is set and written with json, and not the actual class Language.
 *
 * @author bjoek
 * @see GsonFactory for json example
 * @since 2012-08-17
 */
class LanguageSerializer
        implements JsonSerializer<Language>, JsonDeserializer<Language> {
    @Override
    public JsonElement serialize(Language src, Type srcType, JsonSerializationContext context) {
        return new JsonPrimitive(src.getLanguageCode());
    }

    @Override
    public Language deserialize(JsonElement json, Type type, JsonDeserializationContext context)
            throws JsonParseException {
        return new Language(json.getAsString());
    }
}
