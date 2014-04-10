package com.tradedoubler.billing.domain;

/**
 * Mule message that indicates if Pan wants Ax to start invoicing
 *
 * @author bjoek
 * @since 2012-11-06
 */
public class ReadyToInvoice {
    private final boolean readyToInvoice;
    private final MetaData metaData;

    /** Create and set readyToInvoice true */
    public static ReadyToInvoice createReadyToInvoice(MetaData metaData) {
        return new ReadyToInvoice(true, metaData);
    }

    /** Create and set readyToInvoice false */
    public static ReadyToInvoice createNotReadyToInvoice() {
        return new ReadyToInvoice(false, null);
    }

    private ReadyToInvoice(boolean readyToInvoice, MetaData metaData) {
        this.readyToInvoice = readyToInvoice;
        this.metaData = metaData;
    }

    public boolean isReadyToInvoice() {
        return readyToInvoice;
    }

    public MetaData getMetaData() {
        return metaData;
    }
}
