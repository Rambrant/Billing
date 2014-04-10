package com.tradedoubler.billing.domain;

import java.util.List;

/**
 * Order lines that where created in Pan and should be sent to Ax
 *
 * @author bjorn
 * @since 2012-10-10
 */
public class OrderLinesCreated implements ContainsBatchInfo {
    private final MetaData metaData;
    private final List<OrderLine> orderLines;
    private final Guid batchId;

    public OrderLinesCreated(MetaData metaData, List<OrderLine> orderLines, Guid batchId) {
        this.metaData = metaData;
        this.orderLines = orderLines;
        this.batchId = batchId;
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public Guid getBatchId() {
        return batchId;
    }
}
