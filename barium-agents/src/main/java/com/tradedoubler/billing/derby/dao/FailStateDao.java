package com.tradedoubler.billing.derby.dao;

import com.tradedoubler.billing.derby.DerbyDao;
import com.tradedoubler.billing.derby.dto.FailStateDto;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Thomas Rambrant (thore)
 */

public class FailStateDao extends DerbyDao< FailStateDto>
{
    private BeanPropertyRowMapper< FailStateDto> rowMap = new BeanPropertyRowMapper< FailStateDto>( FailStateDto.class);

    final static String CREATE_SQL =
        " CREATE TABLE "                +
            "???"                       +
        " ("                            +
            " id           INT,"        +
            " created      TIMESTAMP,"  +
            " failed       BOOLEAN,"    +
            " service_name VARCHAR(64)" +
        " )";

    private String insertSql;
    private String failStateSql;


    public FailStateDao() throws SQLException
    {
        super( CREATE_SQL, "FAIL_STATE_CONTROL", "id", "created");

        initSqlStatements( "FAIL_STATE_CONTROL", "id", "created");
    }

    private void initSqlStatements( String tableName, String idColumnName, String createdColumnName)
    {
        insertSql =
            " INSERT INTO "              +
                tableName                +
            " ("                         +
                idColumnName + ", "      +    //  1
                createdColumnName + ", " +    //  2
                " failed,"               +    //  3
                " service_name)"         +    //  4
            " VALUES ( ?, ?, ?, ?)";

        failStateSql =
            " SELECT"                       +
                " *"                        +
            " FROM "                        +
                  tableName                 +
            " WHERE"                        +
                " id IN ("                  +
                    " SELECT "              +
                        " MAX( id)"         +
                    " FROM "                +
                          tableName         +
                    " WHERE"                +
                        " service_name = ?" + //  1
                " )";
    }

    //
    // Creates a new row for the integration with the current state (fail or not)
    //
    public Long create( String serviceName, boolean state)
    {
        Long id = getNextSequence();

        Timestamp createTime = new Timestamp( System.currentTimeMillis());

        getJdbcTemplate().update(
            insertSql,
            id,             //  1
            createTime,     //  2
            state,          //  3
            serviceName);   //  4

        return id;
    }

    public boolean isInFailState( String serviceName)
    {
        try
        {
            FailStateDto dto = getJdbcTemplate().queryForObject(
                failStateSql,
                rowMap,
                serviceName); //  1

            if( dto != null)
            {
                return dto.getFailed();
            }

            return false;
        }
        catch( EmptyResultDataAccessException e)
        {
            return false;
        }
    }

    @Override
    public FailStateDto read( long id)
    {
        return readByIdImpl( FailStateDto.class, id);
    }

    @Override
    public void delete( long id)
    {
        deleteByIdImpl( id);
    }

    @Override
    public List< FailStateDto> readAll()
    {
        return readAllImpl( FailStateDto.class);
    }

    @Override
    public List< FailStateDto> readAllAfter( Timestamp time)
    {
        return readAllAfterImpl( FailStateDto.class, time);
    }
}
