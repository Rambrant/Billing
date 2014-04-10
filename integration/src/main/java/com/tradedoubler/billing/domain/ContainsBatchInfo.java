package com.tradedoubler.billing.domain;

/**
 * Common interface for entities that are processed as a batch, such as order lines and forecasts
 *
 * @author bjorn
 * @since 2012-10-22
 */
public interface ContainsBatchInfo {
    MetaData getMetaData();

    Guid getBatchId();
}
