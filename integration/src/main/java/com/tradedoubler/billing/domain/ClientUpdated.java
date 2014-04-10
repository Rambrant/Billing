package com.tradedoubler.billing.domain;

/**
 * Information about a client that has been updated in the CRM
 *
 * @author bjoek
 * @since 2012-07-03
 */
public class ClientUpdated {
    private final MetaData metaData;
    private final Client client;

    public ClientUpdated(MetaData metaData, Client client) {
        this.metaData = metaData;
        this.client = client;
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public Client getClient() {
        return client;
    }
}
