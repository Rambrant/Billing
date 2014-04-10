package com.tradedoubler.billing.domain;

/**
 * Information about a reseller client that has been updated in Pan
 *
 * @author bjoek
 * @since 2012-07-03
 */
public class ResellerClientUpdated {
    private final MetaData metaData;
    private final ResellerClient client;

    public ResellerClientUpdated(MetaData metaData, ResellerClient client) {
        this.metaData = metaData;
        this.client = client;
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public ResellerClient getClient() {
        return client;
    }
}
