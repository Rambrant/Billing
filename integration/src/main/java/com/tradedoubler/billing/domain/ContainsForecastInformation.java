package com.tradedoubler.billing.domain;

import com.tradedoubler.billing.service.BillingServiceException;

/**
 * Common interface for entities that contain forecast information
 *
 * @author bjoek
 * @since 2012-11-08
 */
public interface ContainsForecastInformation {
    OrderLine getOrderLine();

    Currency getCurrency();

    Guid generateForecastGuid() throws BillingServiceException;
}
