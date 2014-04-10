package com.tradedoubler.billing.service.crm;

/**
 * Wrapps a Json String
 * User: erigu
 * Date: 2012-06-13
 */
public class JsonMessage {
    public final String jsonString;

    public JsonMessage(String jsonString) {
        // Strip away all line endings and tabs, since subsequent logging of the json does not accept newlines
        this.jsonString = jsonString.replaceAll("\\r\\n|\\r|\\n|\\t", " ");
    }

    @Override
    public String toString() {
        return jsonString;
    }
}
