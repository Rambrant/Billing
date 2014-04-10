package com.tradedoubler.billing.derby;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Thomas Rambrant (thore)
 *
 * Adopted from Derby test code "JDBC.java"
 */

public class DerbyUtil
{
    public static final String[] GET_TABLES_TABLE   = new String[] { "TABLE"   };
    public static final String[] GET_TABLES_VIEW    = new String[] { "VIEW"    };
    public static final String[] GET_TABLES_SYNONYM = new String[] { "SYNONYM" };

	//
	// Drop a database schema by dropping all objects in it
	// and then executing DROP SCHEMA.
	//
	public static void dropSchema( DatabaseMetaData metaData, String schemaName) throws SQLException
	{
        //
        // get a connection and make sure that auto commit is false
        //
		Connection connection = metaData.getConnection();

		if( connection.getAutoCommit())
        {
            throw new RuntimeException( "Auto commit should be set to false");
        }

        //
        // Prepare us for dropping tha database content
        //
        Statement         statement;
        PreparedStatement preparedStatement;
        ResultSet         resultSet;

        //
        // Drop Functions
        //
        statement = connection.createStatement();

        preparedStatement = connection.prepareStatement(
            "SELECT"                           +
                " ALIAS"                       +
            " FROM"                            +
                " SYS.SYSALIASES A,"           +
                " SYS.SYSSCHEMAS S"            +
            " WHERE"                           +
                " A.SCHEMAID = S.SCHEMAID AND" +
                " CHAR( A.ALIASTYPE) = ?  AND" +
                " S.SCHEMANAME = ?");

        preparedStatement.setString( 1, "F");
        preparedStatement.setString( 2, schemaName);

        resultSet = preparedStatement.executeQuery();

        dropUsingDMD( statement, resultSet, schemaName, "ALIAS", "FUNCTION");

        //
		// Drop Procedures
        //
		resultSet = metaData.getProcedures( null, schemaName, null);

		dropUsingDMD( statement, resultSet, schemaName, "PROCEDURE_NAME", "PROCEDURE");

        //
		// Drop Views
        //
		resultSet = metaData.getTables( null, schemaName, null, GET_TABLES_VIEW);

		dropUsingDMD( statement, resultSet, schemaName, "TABLE_NAME", "VIEW");

        //
		// Drop Tables
        //
		resultSet = metaData.getTables( null, schemaName, null, GET_TABLES_TABLE);

		dropUsingDMD( statement, resultSet, schemaName, "TABLE_NAME", "TABLE");

        //
        // At this point there may be tables left due to foreign key constraints leading to a dependency loop.
        //
        // Drop any constraints that remain and then drop the tables again.
        //
        ResultSet tableResultSet = metaData.getTables( null, schemaName, null, GET_TABLES_TABLE);

        while( tableResultSet.next())
        {
            String tableName = tableResultSet.getString( "TABLE_NAME");

            resultSet = metaData.getExportedKeys( null, schemaName, tableName);

            while( resultSet.next())
            {
                short keyPosition = resultSet.getShort( "KEY_SEQ");

                if( keyPosition != 1)
                {
                    continue;
                }

                String foreignKeyName = resultSet.getString( "FK_NAME");

                if( foreignKeyName == null)
                {
                    //
                    // No name, probably can't happen but couldn't drop it anyway.
                    //
                    continue;
                }

                String foreignKeySchema = resultSet.getString( "FKTABLE_SCHEM");
                String foreignKeyTable  = resultSet.getString( "FKTABLE_NAME");

                String dropForeignKeySql =
                    "ALTER TABLE "                                        +
                    DerbyUtil.escape( foreignKeySchema, foreignKeyTable) +
                    " DROP FOREIGN KEY "                                  +
                    DerbyUtil.escape( foreignKeyName);

                statement.executeUpdate( dropForeignKeySql);
            }

            resultSet.close();
        }

        tableResultSet.close();
        connection.commit();

        resultSet = metaData.getTables( null, schemaName, null, GET_TABLES_TABLE);

        dropUsingDMD( statement, resultSet, schemaName, "TABLE_NAME", "TABLE");

        //
        // Drop User Defined Types (UDTs)
        //
        preparedStatement.setString( 1, "A");
        preparedStatement.setString( 2, schemaName);

        resultSet = preparedStatement.executeQuery();

        dropUsingDMD( statement, resultSet, schemaName, "ALIAS", "TYPE");

        preparedStatement.close();

        //
        // Drop Synonyms
        //
        resultSet = metaData.getTables( null, schemaName, null, GET_TABLES_SYNONYM);

        dropUsingDMD( statement, resultSet, schemaName, "TABLE_NAME", "SYNONYM");

        //
        // Drop Sequences
        //
        if( sysSequencesExists( connection))
        {
            preparedStatement = connection.prepareStatement(
                 "SELECT" +
                     " SEQUENCENAME" +
                 " FROM" +
                     " SYS.SYSSEQUENCES A," +
                     " SYS.SYSSCHEMAS S" +
                 " WHERE" +
                     " A.SCHEMAID = S.SCHEMAID AND" +
                     " S.SCHEMANAME = ?");

            preparedStatement.setString( 1, schemaName);

            resultSet = preparedStatement.executeQuery();

            dropUsingDMD( statement, resultSet, schemaName, "SEQUENCENAME", "SEQUENCE");

            preparedStatement.close();
        }

        //
		// Finally drop the schema if it is not APP
        //
		if( ! schemaName.equals( "APP"))
        {
			statement.executeUpdate( "DROP SCHEMA " + DerbyUtil.escape( schemaName) + " RESTRICT");
		}

        connection.commit();

        statement.close();
	}

    public static boolean isTableCreated( Connection connection, String tableName) throws SQLException
    {
        DatabaseMetaData metaData  = connection.getMetaData();
        ResultSet        resultSet = metaData.getTables( null, null, tableName, null);

        return resultSet.next();
    }

    public static String escape( String name)
    {
        StringBuilder buffer = new StringBuilder( name.length() + 2);

        buffer.append( '"');

        for( int i = 0; i < name.length(); i++)
        {
            char c = name.charAt(i);

            //
            // escape double quote characters with an extra double quote
            //
            if( c == '"') buffer.append('"');

            buffer.append( c);
        }

        buffer.append('"');
        return buffer.toString();
    }

    public static String escape( String schema, String name)
    {
        return escape( schema) + "." + escape( name);
    }

    private static boolean sysSequencesExists( Connection connection) throws SQLException
    {
        PreparedStatement preparedStatement = null;
        ResultSet         resultSet         = null;

        try
        {
            preparedStatement = connection.prepareStatement(
                 "select " +
                     " count(*)" +
                 " from" +
                     " sys.systables t," +
                     " sys.sysschemas s" +
                 " where" +
                     " t.schemaid = s.schemaid and" +
                     " ( cast( s.schemaname as varchar(128))) = 'SYS' and" +
                     " ( cast( t.tablename  as varchar(128))) = 'SYSSEQUENCES'");

            resultSet = preparedStatement.executeQuery();

            resultSet.next();

            return( resultSet.getInt( 1) > 0);
        }
        finally
        {
            if( resultSet != null)
            {
                resultSet.close();
            }

            if( preparedStatement != null)
            {
                preparedStatement.close();
            }
        }
    }

	//
	// DROP a set of objects based upon a ResultSet from a
	// DatabaseMetaData call.
	//
	private static void dropUsingDMD(
	    Statement statement,
        ResultSet resultSet,
        String    schema,
		String    metadataColumn,
		String    dropType) throws SQLException
	{
		String dropLeadIn = "DROP " + dropType + " ";

        //
        // Collect the set of DROP SQL statements.
        //
        List<String> dropSQLList = new ArrayList<String>();

		while( resultSet.next())
		{
            String objectName = resultSet.getString(metadataColumn);
            String raw        = dropLeadIn + DerbyUtil.escape( schema, objectName);

            if( "TYPE".equals( dropType)  ||
                "SEQUENCE".equals( dropType))
            {
                raw = raw + " restrict ";
            }

            dropSQLList.add( raw);
		}

		resultSet.close();

        if (dropSQLList.isEmpty())
            return;

        //
        // Execute them as a complete batch, hoping they will all succeed.
        //
        statement.clearBatch();

        int batchCount = 0;

        for( String sql : dropSQLList)
        {
            if( sql != null)
            {
                statement.addBatch( sql);

                ++batchCount;
            }
        }

		int[]   results;
        boolean hadError;

        try
        {
		    results = statement.executeBatch();

            if( results == null)
            {
                throw new RuntimeException( "Results from executeBatch should not be null");
            }

            if( batchCount != results.length)
            {
                throw new RuntimeException( "Incorrect result length from executeBatch");
            }

            hadError = false;

		}
        catch( BatchUpdateException batchException)
        {
			results = batchException.getUpdateCounts();

            if( results == null)
            {
                throw new RuntimeException( "Results from executeBatch should not be null");
            }

            if( results.length <= batchCount)
            {
                throw new RuntimeException( "Too many results in BatchUpdateException");
            }

            hadError = true;
		}

        //
        // Remove any statements from the list that succeeded.
        //
		boolean didDrop = false;

		for( int i = 0; i < results.length; ++i)
		{
			int result = results[ i];

			if( result == Statement.EXECUTE_FAILED)
            {
                hadError = true;
            }
			else
            {
                if( result == Statement.SUCCESS_NO_INFO || result >= 0)
                {
                    didDrop = true;

                    dropSQLList.set( i, null);
                }
                else
                {
                    throw new RuntimeException( "Negative executeBatch status");
                }
            }
		}

        statement.clearBatch();

        if( didDrop)
        {
            statement.getConnection().commit();
        }

        //
        // If we had failures drop them as individual statements
        // until there are none left or none succeed. We need to
        // do this because the batch processing stops at the first
        // error. This copes with the simple case where there
        // are objects of the same type that depend on each other
        // and a different drop order will allow all or most
        // to be dropped.
        //
        if( hadError)
        {
            do
            {
                hadError = false;
                didDrop  = false;

                for( ListIterator< String> i = dropSQLList.listIterator(); i.hasNext();)
                {
                    Object sql = i.next();

                    if( sql != null)
                    {
                        try
                        {
                            statement.executeUpdate( sql.toString());

                            i.set(null);

                            didDrop = true;
                        }
                        catch( SQLException e)
                        {
                            hadError = true;
                        }
                    }
                }

                if( didDrop)
                {
                    statement.getConnection().commit();
                }

            } while( hadError && didDrop);
        }
	}
}
