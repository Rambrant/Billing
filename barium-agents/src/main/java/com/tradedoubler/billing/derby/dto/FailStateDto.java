package com.tradedoubler.billing.derby.dto;

import java.sql.Timestamp;

/**
 * @author Thomas Rambrant (thore)
 */

public class FailStateDto
{
    private Long      id;
    private Timestamp created;
    private Boolean   failed;
    private String    serviceName;

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

    public Boolean getFailed()
    {
        return failed;
    }

    public void setFailed( Boolean failed)
    {
        this.failed = failed;
    }

    public String getServiceName()
    {
        return serviceName;
    }

    public void setServiceName( String serviceName)
    {
        this.serviceName = serviceName;
    }

    @Override
    public String toString()
    {
        return "FailStateDto { " +
              "id = "           + id          +
            ", failed = "       + failed      +
            ", serviceName = '" + serviceName +
            ", created = "      + created     +
            '}';
    }
}
