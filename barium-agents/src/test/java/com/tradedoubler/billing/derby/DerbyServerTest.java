package com.tradedoubler.billing.derby;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Thomas Rambrant (thore)
 */

public class DerbyServerTest
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
    public void couldAccessSystemTable() throws Exception
    {
        DerbyDataSource dataSource = new DerbyDataSource( properties);

        Connection connection = dataSource.getConnection();

        Statement statement = null;
        ResultSet resultSet = null;

        try
        {
            //
            // To test our connection, we will try to do a select from the system catalog tables
            //
            statement = connection.createStatement();

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

    @Test
    public void multipleConnectionsShallCoexist() throws Exception
    {
        DerbyDataSource dataSource = new DerbyDataSource( properties);

        Connection connection1 = dataSource.getConnection();
        Connection connection2 = dataSource.getConnection();

        Assert.assertNotSame( "Connections should not be the same", connection1, connection2);
    }

    @Test
    public void multipleServerStarts() throws Exception
    {
        DerbyServer secondServer = new DerbyServer( properties);

        Assert.assertTrue( "Server should already be started", DerbyServer.isServerStarted());

        secondServer.start();

        secondServer.stop();

        Assert.assertTrue( "Server should still be started", DerbyServer.isServerStarted());
    }

    @Test
    public void shouldCleanDatabase() throws Exception
    {
        DerbyDataSource dataSource = new DerbyDataSource( properties);

        Connection connection = dataSource.getConnection();

        createTable( connection);

        Assert.assertTrue( "person table should be present", isTablePresent( connection));

        server.cleanDatabase();

        Assert.assertFalse( "person table should not be present", isTablePresent( connection));
    }

    private boolean isTablePresent( Connection connection) throws SQLException
    {
        Statement statement    = null;
        boolean   tablePresent = true;

        try
        {
            statement = connection.createStatement();

            statement.executeQuery( "SELECT COUNT(*) FROM persons");
        }
        catch( SQLException e)
        {
            tablePresent = false;
        }
        finally
        {
            if( statement != null)
            {
                statement.close();
            }
        }

        return tablePresent;
    }

    private void createTable( Connection connection) throws SQLException
    {
        Statement statement = null;

        try
        {
            statement = connection.createStatement();

            statement.executeUpdate(
                " CREATE TABLE persons" +
                " (" +
                    " P_Id      int," +
                    " LastName  varchar( 255)," +
                    " FirstName varchar( 255)," +
                    " Address   varchar( 255)," +
                    " City      varchar( 255)"  +
                " )");
        }
        catch( SQLException e)
        {
            //
            // The table might already exist
            //
            if( ! e.getSQLState().equals( "X0Y32"))
            {
                throw e;
            }
        }
        finally
        {
            if( statement != null)
            {
                statement.close();
            }
        }
    }
}
