package com.tradedoubler.billing.transform.json.gson;

import com.google.gson.*;
import com.tradedoubler.billing.domain.ProductType;

import java.lang.reflect.Type;

/**
 * Custom serializer for Gson json transformation. It is used by the GsonFactory.
 * This serializer makes sure that the internal value is set and written with json, and not the actual class ProductType.
 *
 * @author bjoek
 * @see GsonFactory for json example
 * @since 2012-08-17
 */
class ProductTypeSerializer
        implements JsonSerializer<ProductType>, JsonDeserializer<ProductType> {
    @Override
    public JsonElement serialize(ProductType src, Type srcType, JsonSerializationContext context) {
        return new JsonPrimitive(src.getValue());
    }

    @Override
    public ProductType deserialize(JsonElement json, Type type, JsonDeserializationContext context)
            throws JsonParseException {
        return new ProductType(json.getAsInt());
    }
}
