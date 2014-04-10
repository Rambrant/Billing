package com.tradedoubler.billing.transform.json;

import com.google.gson.Gson;
import com.tradedoubler.billing.domain.UpdateForecast;
import com.tradedoubler.billing.service.crm.JsonMessage;
import com.tradedoubler.billing.transform.json.gson.GsonFactory;
import org.slf4j.*;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Converts a list of UpdateForecast to Json strings
 *
 * @author bjorn
 * @since 2012-10-12
 */
@Component
public class UpdateForecastToJsonTransformer {
    private final static Logger log = LoggerFactory.getLogger(UpdateForecastToJsonTransformer.class);
    private final static Gson gson = GsonFactory.getGson();

    public List<JsonMessage> doTransform(Collection<UpdateForecast> forecastUpdates) {
        List<JsonMessage> jsonMessages = new ArrayList<JsonMessage>();
        for (UpdateForecast forecastUpdate : forecastUpdates) {
            String jsonString = transformToJson(forecastUpdate);
            jsonMessages.add(new JsonMessage(jsonString));

            if (log.isDebugEnabled()) {
                log.debug("Transforming UpdateForecast, json : " + jsonString);
            }
        }

        return jsonMessages;
    }

    private String transformToJson(UpdateForecast updateForecast) {
        return gson.toJson(updateForecast);
    }

}
