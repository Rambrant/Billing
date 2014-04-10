package com.tradedoubler.billing.transform.json.gson;

import com.google.gson.*;
import com.tradedoubler.billing.domain.Event;
import com.tradedoubler.billing.transform.ftp.InvoiceConverter;

import java.lang.reflect.Type;

/**
 * TODO
 * User: erigu
 * Date: 2012-10-16
 */
class EventSerializer implements JsonSerializer<Event> {

    private final InvoiceConverter invoiceConverter = new InvoiceConverter();

    //    InvoiceConverter
    @Override
    public JsonElement serialize(Event event, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(invoiceConverter.convertEventFromDomainToCRM(event));
    }
}
