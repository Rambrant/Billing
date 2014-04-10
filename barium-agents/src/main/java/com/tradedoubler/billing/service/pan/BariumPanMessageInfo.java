package com.tradedoubler.billing.service.pan;

import com.tradedoubler.billing.type.ProducerEventDbType;

/**
 * @author Thomas Rambrant (thore)
 */

public class BariumPanMessageInfo
{
    private String              batchId;
    private Long                tableRowId;
    private ProducerEventDbType eventType;

    public BariumPanMessageInfo(
        String              batchId,
        Long                tableRowId,
        ProducerEventDbType eventType )
    {
        this.batchId    = batchId;
        this.tableRowId = tableRowId;
        this.eventType  = eventType;
    }

    public String getBatchId()
    {
        return batchId;
    }

    public Long getTableRowId()
    {
        return tableRowId;
    }

    public ProducerEventDbType getEventType()
    {
        return eventType;
    }
}
