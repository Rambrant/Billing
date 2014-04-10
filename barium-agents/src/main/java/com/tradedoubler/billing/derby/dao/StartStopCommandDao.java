package com.tradedoubler.billing.derby.dao;

import com.tradedoubler.billing.derby.DerbyDao;
import com.tradedoubler.billing.derby.dto.StartStopCommandDto;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Thomas Rambrant (thore)
 */

public class StartStopCommandDao extends DerbyDao< StartStopCommandDto>
{
    final static String TABLE_NAME = "COMMAND_START_STOP";

    final static String CREATE_SQL =
        " CREATE TABLE "           +
            "???"                  +
        " ("                       +
            " id      INT,"        +
            " created TIMESTAMP, " +
            " stopped BOOLEAN"     +
        " )";

    private String insertSql;
    private String updateSql;


    public StartStopCommandDao() throws SQLException
    {
        super( CREATE_SQL, TABLE_NAME, "id", "created");

        initSqlStatements( TABLE_NAME, "id", "created");
    }

    private void initSqlStatements( String tableName, String idColumnName, String createdColumnName)
    {
        insertSql =
            " INSERT INTO "              +
                tableName                +
            " ("                         +
                idColumnName + ", "      +  //  1
                createdColumnName + ", " +  //  2
                " stopped) "             +  //  3
            " VALUES ( ?, ?, ?)";

        updateSql =
            " UPDATE "                +
                tableName             +
            " SET"                    +
                " stopped = ?"        + //  1
            " WHERE "                 +
                idColumnName + " = ?";  //  2

    }

    public Long create( StartStopCommandDto dto)
    {
        dto.setId( getNextSequence());

        Timestamp createTime = new Timestamp( System.currentTimeMillis());

        getJdbcTemplate().update(
            insertSql,
            dto.getId(),        //  1
            createTime,         //  2
            dto.isStopped());   //  3

        return dto.getId();
    }

    public void update( StartStopCommandDto dto)
    {
        getJdbcTemplate().update(
            updateSql,
            dto.isStopped(),  //  1
            dto.getId());     //  2
    }

    @Override
    public StartStopCommandDto read( long id)
    {
        return readByIdImpl( StartStopCommandDto.class, id);
    }

    @Override
    public void delete( long id)
    {
        deleteByIdImpl( id);
    }

    @Override
    public List< StartStopCommandDto> readAll()
    {
        return readAllImpl( StartStopCommandDto.class);
    }

    @Override
    public List< StartStopCommandDto> readAllAfter( Timestamp time)
    {
        return readAllAfterImpl( StartStopCommandDto.class, time);
    }
}
