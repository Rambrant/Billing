package com.tradedoubler.billing.derby.dto;

import java.sql.Timestamp;

/**
 * @author Thomas Rambrant (thore)
 */

public class StartStopCommandDto
{
    private Long      id;
    private Timestamp created;
    private Boolean   stopped = false;

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

    public Boolean isStopped()
    {
        return stopped;
    }

    public void setStopped( Boolean stopped)
    {
        this.stopped = stopped;
    }

    @Override
    public String toString()
    {
        return "StartStopCommandDto { " +
              "id = "      + id      +
            ", stopped = " + stopped +
            ", created = " + created +
            '}';
    }
}
