package com.tradedoubler.billing.validate;

import org.json.*;

/** A Json validation schema is stored in in this internal class. Used by TdJsonSchemaReader */
public class TdJsonObject {
    private JSONObject jsonObject;
    private final static String FIELD_SEPARATOR_REG_EXP = "\\.";

    public TdJsonObject(String jsonString) throws JSONException {

        jsonObject = new JSONObject(jsonString);
    }

    /**
     * Removes a field.
     *
     * @param fieldName The field to remove. Examples "name"
     * @return The TdJsonObject itself, to support chaining of set() calls.
     */
    public TdJsonObject remove(String fieldName) {
        String[] fields = fieldName.split(FIELD_SEPARATOR_REG_EXP);

        if (fields.length == 1) {
            // For one-level field names, e.g. "name" or "id"
            jsonObject.remove(fieldName);
        } else {
            throw new IllegalArgumentException("This is a stripped version of TdJsonObject it does" +
                    "not support dot(.) notation, " +
                    "use version control system to find the original one");
        }

        return this;
    }

    /** @return The internal JSON representation as a String */
    public String toString() {
        return jsonObject.toString();
    }

}
