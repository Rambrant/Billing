package com.tradedoubler.billing.derby.dto;

import java.sql.Timestamp;

/**
 * @author Thomas Rambrant (thore)
 */

public class ErrorLogDto
{
    private Long      id;
    private Timestamp created;
    private String    message;

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

    public String getMessage()
    {
        return message;
    }

    public void setMessage( String message)
    {
        this.message = message;
    }

    @Override
    public String toString()
    {
        return "ErrorLogDto { " +
              "id = "       + id      +
            ", message = '" + message +
            ", created = "  + created +
            '}';
    }
}
