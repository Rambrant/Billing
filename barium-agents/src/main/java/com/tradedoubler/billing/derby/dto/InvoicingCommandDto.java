package com.tradedoubler.billing.derby.dto;

import com.tradedoubler.billing.type.InvoicingStatusType;

import java.sql.Timestamp;

/**
 * @author Thomas Rambrant (thore)
 */

public class InvoicingCommandDto
{
    private Long                id;
    private Timestamp           created;
    private Boolean             triggerAx;
    private InvoicingStatusType status = InvoicingStatusType.STOPPED;

    public Long getId()
    {
        return id;
    }

    public void setId( Long id)
    {
        this.id = id;
    }

    public Timestamp getCreated()
    {
        return created;
    }

    public void setCreated( Timestamp created)
    {
        this.created = created;
    }

    public Boolean getTriggerAx()
    {
        return triggerAx;
    }

    public void setTriggerAx( Boolean triggerAx)
    {
        this.triggerAx = triggerAx;
    }

    public InvoicingStatusType getStatus()
    {
        return status;
    }

    public void setStatus( InvoicingStatusType status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "InvoicingCommandDto {"  +
             " id = "        + id        +
            ", status = "    + status    +
            ", triggerAx = " + triggerAx +
            ", created = "   + created   +
            '}';
    }
}
