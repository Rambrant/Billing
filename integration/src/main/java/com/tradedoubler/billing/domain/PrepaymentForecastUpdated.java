package com.tradedoubler.billing.domain;

import com.tradedoubler.billing.service.crm.JsonMessage;

import java.util.*;

/**
 * Forecast for prepayment programs received from Pan should be sent to to Crm
 *
 * @author bjorn
 * @since 2012-10-10
 */
public class PrepaymentForecastUpdated implements ContainsBatchInfo {
    private final MetaData metaData;
    private final Guid batchId;
    private final List<PrepaymentOrderLine> orderLines;

    /** Populated later in the Mule flow when forecast order line are converted to forecasts */
    private Collection<UpdateForecast> forecastUpdates;

    /** Populated later in the Mule flow when forecast are converted to Json messages */
    private List<JsonMessage> forecastUpdatesJson;

    public PrepaymentForecastUpdated(MetaData metaData, Guid batchId, List<PrepaymentOrderLine> orderLines) {
        this.metaData = metaData;
        this.batchId = batchId;
        this.orderLines = orderLines;
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public Guid getBatchId() {
        return batchId;
    }

    public List<PrepaymentOrderLine> getOrderLines() {
        return orderLines;
    }

    public Collection<UpdateForecast> getForecastUpdates() {
        return forecastUpdates;
    }

    public void setForecastUpdates(Collection<UpdateForecast> forecastUpdates) {
        this.forecastUpdates = forecastUpdates;
    }

    public List<JsonMessage> getForecastUpdatesJson() {
        return forecastUpdatesJson;
    }

    public void setForecastUpdatesJson(List<JsonMessage> forecastUpdatesJson) {
        this.forecastUpdatesJson = forecastUpdatesJson;
    }
}
