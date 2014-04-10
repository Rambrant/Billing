package com.tradedoubler.billing.derby;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Thomas Rambrant (thore)
 */

public class DerbyDataSourceTest
{
    private static DerbyServer     server;
    private static DerbyProperties properties;

    @BeforeClass
    public static void setUp() throws Exception
    {
        properties = new DerbyProperties();

        server = new DerbyServer( properties);

        server.start();
    }

    @AfterClass
    public static void tearDown() throws Exception
    {
        server.stop();
    }

    @Test
    public void selectUsingDataSource()
    {
        DerbyDataSource    dataSource = new DerbyDataSource( properties);
        SimpleJdbcTemplate template   = new SimpleJdbcTemplate( dataSource);

        int count = template.queryForInt( "SELECT COUNT(*) FROM sys.systables");

        Assert.assertTrue( "Rows in systables should be more than zero", count > 0);
    }

    @Test
    public void selectUsingConnection() throws SQLException
    {
        DerbyDataSource dataSource = new DerbyDataSource( properties);

        Statement statement = null;
        ResultSet resultSet = null;

        try
        {
            //
            // To test our connection, we will try to do a select from the system catalog tables
            //
            statement = dataSource.getConnection().createStatement();

            resultSet = statement.executeQuery( "SELECT COUNT(*) FROM sys.systables");

            while( resultSet.next())
            {
                Assert.assertTrue( "Rows in systables should be more than zero", resultSet.getInt( 1) > 0);
            }
        }
        finally
        {
            if( resultSet != null)
            {
                resultSet.close();
            }

            if( statement != null)
            {
                statement.close();
            }
        }
    }
}
