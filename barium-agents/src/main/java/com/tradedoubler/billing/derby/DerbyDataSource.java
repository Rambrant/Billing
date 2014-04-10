package com.tradedoubler.billing.derby;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * @author Thomas Rambrant (thore)
 */

public class DerbyDataSource extends BasicDataSource
{
    public DerbyDataSource( DerbyProperties properties)
    {
        setDriverClassName( "org.apache.derby.jdbc.ClientDriver");
        setUrl( "jdbc:derby://localhost:" + properties.getDbPort() + "/" + properties.getDbName() + ";create=true");

        //
        // Set the parameters so that we survive
        //
        //TODO pooling off?
        setPoolPreparedStatements( false);
        setTestOnBorrow( true);
        setTestOnReturn( false);
        setTestWhileIdle( true);
        setRemoveAbandoned( true);
        setRemoveAbandonedTimeout( 60);
        setValidationQuery( "VALUES(1)");
        setValidationQueryTimeout( 60);
        setDefaultAutoCommit( true);
    }
}
