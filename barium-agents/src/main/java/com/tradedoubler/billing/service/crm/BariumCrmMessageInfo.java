package com.tradedoubler.billing.service.crm;

import com.tradedoubler.billing.type.CrmQueueType;
import com.tradedoubler.billing.type.ProducerEventDbType;

/**
 * @author Thomas Rambrant (thore)
 */

public class BariumCrmMessageInfo
{
    private CrmQueueType        queueType;
    private Long                tableRowId;
    private Long                associatedRowId;
    private ProducerEventDbType eventType;

    public BariumCrmMessageInfo(
        CrmQueueType        queueType,
        Long                tableRowId,
        Long                associatedRowId,
        ProducerEventDbType eventType)
    {
        this.queueType       = queueType;
        this.tableRowId      = tableRowId;
        this.associatedRowId = associatedRowId;
        this.eventType       = eventType;
    }

    public CrmQueueType getQueueType()
    {
        return queueType;
    }

    public Long getTableRowId()
    {
        return tableRowId;
    }

    public Long getAssociatedRowId()
    {
        return associatedRowId;
    }

    public ProducerEventDbType getEventType()
    {
        return eventType;
    }
}
