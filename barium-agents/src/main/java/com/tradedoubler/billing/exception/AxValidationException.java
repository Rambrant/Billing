package com.tradedoubler.billing.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Thomas Rambrant (thore)
 */

public class AxValidationException extends Exception
{
    private List< String> errors;
    private String        entity;
    private String        entityId;

    public AxValidationException( String entity, String entityId)
    {
        super( "Error in validation of " + entity + " '" + entityId + "'");

        this.errors   = new ArrayList< String>();
        this.entity   = entity;
        this.entityId = entityId;
    }

    public void addError( String message)
    {
        errors.add( message);
    }

    public boolean hasErrors()
    {
        return errors.size() != 0;
    }

    public List< String> getErrors()
    {
        return errors;
    }

    public String getEntity()
    {
        return entity;
    }

    public String getEntityId()
    {
        return entityId;
    }
}
