package com.tradedoubler.billing.derby.dto;

import java.sql.Timestamp;

/**
 * @author Thomas Rambrant (thore)
 */

public class DerbyTestDto
{
    private Long      id;
    private Timestamp created;
    private String    name;

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

    public String getName()
    {
        return name;
    }

    public void setName( String name)
    {
        this.name = name;
    }
}
