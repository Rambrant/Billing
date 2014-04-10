package com.tradedoubler.billing.derby;


import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Thomas Rambrant (thore)
 */

public class DerbyProperties extends Properties
{
    public DerbyProperties()
    {
        try
        {
            this.load( new ClassPathResource( "derby-connection.properties").getInputStream());
        }
        catch( IOException e)
        {
            throw new RuntimeException( "Failed to load connection settings from derby-connection.properties");
        }
    }

    public Integer getIntegerProperty( String key)
    {
        return Integer.valueOf( this.getProperty( key));
    }

    public String getDbName()
    {
        return getProperty( "db.name");
    }

    public Integer getDbPort()
    {
        return getIntegerProperty( "db.port");
    }
}
