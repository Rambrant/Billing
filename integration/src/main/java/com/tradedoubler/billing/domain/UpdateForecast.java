package com.tradedoubler.billing.domain;

/**
 * A message that will update a forecast in the CRM
 *
 * @author bjorn
 * @since 2012-10-12
 */
public class UpdateForecast {
    private final MetaData metaData;
    private final MonthlyForecast monthlyForecast;

    public UpdateForecast(MetaData metaData, MonthlyForecast monthlyForecast) {
        this.metaData = metaData;
        this.monthlyForecast = monthlyForecast;
    }

    /** A message that will update a forecast in the CRM */
    public MetaData getMetaData() {
        return metaData;
    }

    /** The monthly forecast to update */
    public MonthlyForecast getMonthlyForecast() {
        return monthlyForecast;
    }
}
