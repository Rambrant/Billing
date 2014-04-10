package com.tradedoubler.billing.derby;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Thomas Rambrant (thore)
 */

public abstract class DerbyDao< T>
{
    private static DerbyDataSource derbyDataSource;
    private static JdbcTemplate    jdbcTemplate;

    private String createSequenceSql;
    private String nextSequenceSql;
    private String readByIdSql;
    private String deleteByIdSql;
    private String readAllSql;
    private String readAllAfterSql;

    //
    // The constructor tries to create the table according to the SQL statement given.
    // The given SQL string should have ??? as a placeholder for the table name.
    //
    // Failures due to an already existing table will silently be ignored.
    // All other exceptions will be propagated.
    //
    // A table called <table name>_SEQ will simultaneous be created to be used for identity
    // key generation
    //
    protected DerbyDao( String createSql, String tableName, String idColumnName, String createdColumnName)
    {
        //
        // Init SQL strings
        //
        initSqlStatements( tableName, idColumnName, createdColumnName);

        //
        // Create the table
        // Enhance the create table sql. Insert the table name in the correct place
        //
        String sql = createSql.replace( "???", tableName);

        try
        {
            getJdbcTemplate().execute( sql);
        }
        catch( DataIntegrityViolationException e)
        {
            //
            // Do nothing, this is ok since the table could have been created prior to this
            //
        }


        //
        // Try to create the accompanying sequence table
        //
        try
        {
            getJdbcTemplate().execute( createSequenceSql);
        }
        catch( UncategorizedSQLException e)
        {
            //
            // Do nothing, this is ok since the table could have been created prior to this
            //
        }
    }

    private void initSqlStatements( String tableName, String idColumnName, String createdColumnName)
    {
        createSequenceSql =
            " CREATE SEQUENCE "     +
                tableName + "_SEQ " +
            " AS INT "              +
                " MINVALUE 1"       +
                " MAXVALUE 999999"  +
            " CYCLE";

        nextSequenceSql =
            " VALUES"              +
                " NEXT VALUE"      +
            " FOR "                +
                tableName + "_SEQ";

        readByIdSql =
            " SELECT"        +
                " *"         +
            " FROM "         +
                tableName    +
            " WHERE "        +
                idColumnName +
                " = ?";         //  1

        deleteByIdSql =
            " DELETE FROM "  +
                tableName    +
            " WHERE "        +
                idColumnName +
                " = ?";         //  1

        readAllSql =
            " SELECT"        +
                " *"         +
            " FROM "         +
                tableName;

        readAllAfterSql =
            " SELECT"             +
                " *"              +
            " FROM "              +
                tableName         +
            " WHERE "             +
                createdColumnName +
                " >= ?";            //  1
    }

    //
    // All DerbyDao based objects will share the same data source. Call this before using any
    // operations on the sub-class objects.
    //
    public static void setGlobalDataSource( DerbyDataSource aDataSource)
    {
        derbyDataSource = aDataSource;

        //
        // Initialise the Jdbc template
        //
        jdbcTemplate = new JdbcTemplate( derbyDataSource);

        jdbcTemplate.setIgnoreWarnings( false);
        jdbcTemplate.setQueryTimeout( 30);
    }

    public static DerbyDataSource getGlobalDataSource()
    {
        return derbyDataSource;
    }

    public JdbcTemplate getJdbcTemplate()
    {
      return jdbcTemplate;
    }

    //
    //  Read a record with the given id
    //
    public abstract T read( long id);

    //
    // Delete a record in the database with the given id
    //
    public abstract void delete( long id);

    //
    // Read all records in the file
    //
    public abstract List< T> readAll();

    //
    // Read all records in a file with a creation time later than the given time
    //
    public abstract List< T> readAllAfter( Timestamp time);

    //
    // Convenience operation that implements the retrieval of one row given the id and the named id column
    //
    protected T readByIdImpl( Class<T> dtoClass, Long id)
    {
        try
        {
            return getJdbcTemplate().queryForObject(
                readByIdSql,
                new BeanPropertyRowMapper<T>( dtoClass),
                id);    //  1
        }
        catch( EmptyResultDataAccessException e)
        {
            return null;
        }
    }

    //
    // Convenience operation that implements the delete of one row given the id and the named id column
    //
    protected void deleteByIdImpl( long id)
    {
        getJdbcTemplate().update(
            deleteByIdSql,
            id);    //  1
    }

    //
    // Convenience operation that implements the retrieval of all rows
    //
    protected List< T> readAllImpl( Class<T> dtoClass)
    {
        try
        {
            return getJdbcTemplate().query( readAllSql, new BeanPropertyRowMapper<T>( dtoClass));
        }
        catch( EmptyResultDataAccessException e)
        {
            return new ArrayList<T>();
        }
    }

    //
    // Convenience operation that implements the retrieval of all rows after the given time.
    //
    protected List< T> readAllAfterImpl( Class<T> dtoClass, Timestamp time)
    {
        try
        {
            return getJdbcTemplate().query(
                readAllAfterSql,
                new BeanPropertyRowMapper<T>( dtoClass),
                time);  //  1
        }
        catch( EmptyResultDataAccessException e)
        {
            return new ArrayList<T>();
        }
    }

    //
    // Return the next value in the sequence for the table
    //
    protected Long getNextSequence()
    {
        return getJdbcTemplate().queryForLong( nextSequenceSql);
    }
}
