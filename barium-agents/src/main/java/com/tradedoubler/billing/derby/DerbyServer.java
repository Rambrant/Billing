package com.tradedoubler.billing.derby;

import org.apache.derby.drda.NetworkServerControl;

import java.net.InetAddress;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Thomas Rambrant (thore)
 */

public class DerbyServer
{
    private static NetworkServerControl server;
    private static DerbyProperties      properties;
    private static int                  serverStartCount = 0;
    private static boolean              databaseOwner    = true;

    //
    // Creates an abstraction of the Derby database server given the actual connection properties
    //
    public DerbyServer( DerbyProperties property) throws Exception
    {
        properties = property;

        if( server == null)
        {
            server = new NetworkServerControl(
                InetAddress.getByName( "localhost"),
                properties.getDbPort());
        }
    }

    //
    // Starts the server. This call can be made several times but the actual start will only
    // be performed the first time.
    // We wait for the server to start to ensure a working state when we return from this call.
    //
    public void start() throws Exception
    {
        if( serverStartCount == 0)
        {
            server.start( null);
        }

        waitForStart();

        //
        // Try to connect using a embedded connection. This will fail if someone else already has started the
        // database. If this happens, make sure that we don't shut it down when we stop...
        //
        try
        {
            Class.forName( "org.apache.derby.jdbc.EmbeddedDriver");
            DriverManager.getConnection( "jdbc:derby:" + properties.getDbName() + ";create=true");

            databaseOwner = true;
        }
        catch( SQLException e)
        {
            databaseOwner = false;
        }

        ++serverStartCount;
    }

    //
    // Stops the server. The server will not be stopped until we have called this operation the same number
    // of times that we called start.
    //
    public void stop() throws Exception
    {
        --serverStartCount;

        if( serverStartCount == 0 && databaseOwner)
        {
            server.shutdown();

            server = null;
        }
    }

    //
    // Clears all content, including users, tables, sequences, from the database if and only if
    // we are the owner of it. We can't pull the rug under someone else...
    //
    public void cleanDatabase() throws Exception
    {
        if( databaseOwner && serverStartCount == 1)
        {
            Connection connection = new DerbyDataSource( properties).getConnection();

            connection.setAutoCommit( false);

            try
            {
                clearProperties( connection);
                removeObjects(   connection);
                removeRoles(     connection);
                removeUsers(     connection);
            }
            catch( SQLException e)
            {
                //
                // The table might not exist
                //
                if( ! e.getSQLState().equals( "42X05"))
                {
                    throw e;
                }
            }
            finally
            {
                connection.setAutoCommit( true);
            }
        }
	}


    public static boolean isServerStarted()
    {
        return serverStartCount != 0;
    }

    private void waitForStart() throws Exception
    {
        //
        // Try ten times to ping the server to see if we have managed to start
        //
        for( int i = 0; i < 10 ; ++i)
        {
            try
            {
                if( i != 0)
                {
                    Thread.sleep( 5000);
                }

                server.ping();

                break;
            }
            catch( Exception e)
            {
                if( i == 9)
                {
                    throw new RuntimeException( "Giving up trying to connect to Derby Network Server!", e);
                }
            }
        }
    }

    private static final String[] CLEAR_DB_PROPERTIES =
	{
	    "derby.database.classpath",
	};

	private void clearProperties( Connection connection) throws SQLException
    {
        PreparedStatement statement = connection.prepareCall( "CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY( ?, NULL)");

        for( String clearDbProperty : CLEAR_DB_PROPERTIES)
        {
            statement.setString( 1, clearDbProperty);
            statement.executeUpdate();
        }

        statement.close();

        connection.commit();
	}

    private void removeObjects( Connection connection) throws SQLException
    {
        DatabaseMetaData metaData = connection.getMetaData();

        SQLException sqlError = null;

        //
        // Loop a couple of times to catch cases
        // where objects are dependent on objects in
        // different schemas.
        //
        for( int count = 0; count < 5; ++count)
        {
            //
            // Fetch all the user schemas into a list
            //
            List< String> schemas   = new ArrayList<String>();
            ResultSet     resultSet = metaData.getSchemas();

            while( resultSet.next())
            {
                String schema = resultSet.getString( "TABLE_SCHEM");

                if( schema.startsWith( "SYS")       ||
                    schema.equals(     "SQLJ")      ||
                    schema.equals(     "NULLID"))
                {
                    continue;
                }

                schemas.add( schema);
            }

            resultSet.close();

            //
            // DROP all the user schemas.
            //
            sqlError = null;

            for( String schema : schemas)
            {
                try
                {
                    DerbyUtil.dropSchema( metaData, schema);
                }
                catch( SQLException e)
                {
                    sqlError = e;
                }
            }

            //
            // No errors means all the schemas we wanted to
            // drop were dropped, so nothing more to do.
            //
            if( sqlError == null)
            {
                return;
            }
        }

        throw sqlError;
	}

    private static void removeRoles( Connection connection) throws SQLException
    {
        Statement statement     = connection.createStatement();
        Statement dropStatement = connection.createStatement();

        //
        // cast to overcome territory differences in some cases:
        //
        ResultSet rs = statement.executeQuery( "select roleid from sys.sysroles where cast( isdef as char(1)) = 'Y'");

        while( rs.next())
        {
            dropStatement.executeUpdate( "DROP ROLE " + DerbyUtil.escape( rs.getString( 1)));
        }

        statement.close();
        dropStatement.close();

        connection.commit();
	}

    private static void removeUsers( Connection connection) throws SQLException
	{
        //
        // Get all users
        //
        Statement          statement = connection.createStatement();
        ResultSet          resultSet = statement.executeQuery( "select username from sys.sysusers");
        ArrayList< String> users     = new ArrayList<String>();

        while( resultSet.next())
        {
            users.add( resultSet.getString( 1));
        }

        resultSet.close();
        statement.close();

        //
        // Now delete them
        //
        PreparedStatement preparedStatement = connection.prepareStatement( "call syscs_util.syscs_drop_user( ?)");

        for( String user : users)
        {
            preparedStatement.setString( 1, user);

            //
            // you can't drop the database owner's credentials.... ;-)
            //
            try
            {
                preparedStatement.executeUpdate();
            }
            catch( SQLException se)
            {
                if( ! "4251F".equals( se.getSQLState()))
                {
                    throw se;
                }
            }
        }

        preparedStatement.close();

        connection.commit();
	}
}


