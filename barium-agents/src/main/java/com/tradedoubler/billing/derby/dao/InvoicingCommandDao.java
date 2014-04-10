package com.tradedoubler.billing.derby.dao;

import com.tradedoubler.billing.derby.DerbyDao;
import com.tradedoubler.billing.derby.dto.InvoicingCommandDto;
import com.tradedoubler.billing.type.InvoicingStatusType;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Thomas Rambrant (thore)
 */

public class InvoicingCommandDao extends DerbyDao< InvoicingCommandDto>
{
    private BeanPropertyRowMapper< InvoicingCommandDto> rowMap = new BeanPropertyRowMapper< InvoicingCommandDto>( InvoicingCommandDto.class);

    final static String TABLE_NAME = "INVOICING_COMMAND";

    final static String CREATE_SQL =
        " CREATE TABLE "              +
            "???"                     +
        " ("                          +
            " id         INT,"        +
            " created    TIMESTAMP,"  +
            " trigger_ax Boolean,"    +
            " status     VARCHAR(15)" +
        " )";

    private String insertSql;
    private String updateSql;
    private String readLatestSql;


    public InvoicingCommandDao() throws SQLException
    {
        super( CREATE_SQL, TABLE_NAME, "id", "created");

        initSqlStatements( TABLE_NAME, "id", "created");
    }

    private void initSqlStatements( String tableName, String idColumnName, String createdColumnName)
    {
        insertSql =
            " INSERT INTO "             +
                tableName               +
            " ("                        +
                idColumnName + ", "     +   //  1
                createdColumnName + "," +   //  2
                " trigger_ax,"          +   //  3
                " status)"              +   //  4
            " VALUES ( ?, ?, ?, ?)";

        updateSql =
            " UPDATE "                +
                tableName             +
            " SET"                    +
                " trigger_ax = ?"     + //  1
                " status = ?"         + //  2
            " WHERE "                 +
                idColumnName + " = ?";  //  3

        readLatestSql =
            " SELECT"                                +
                " *"                                 +
            " FROM "                                 +
                  tableName                          +
            " WHERE "                                +
                idColumnName + " IN ("               +
                    " SELECT "                       +
                        " MAX(" + idColumnName + ")" +
                    " FROM "                         +
                          tableName                  +
                " )";

    }

    public Long create( InvoicingStatusType status, Boolean triggerAx)
    {
        long id = getNextSequence();

        Timestamp createTime = new Timestamp( System.currentTimeMillis());

        getJdbcTemplate().update(
            insertSql,
            id ,            //  1
            createTime,     //  2
            triggerAx,      //  3
            status.name()); //  4

        return id;
    }

    public void update( InvoicingCommandDto dto)
    {
        getJdbcTemplate().update(
            updateSql,
            dto.getTriggerAx(), //  1
            dto.getStatus(),    //  2
            dto.getId());       //  3
    }

    public InvoicingCommandDto readLatest()
    {
        try
        {
            InvoicingCommandDto dto = getJdbcTemplate().queryForObject(
                readLatestSql,
                rowMap);

            return dto;
        }
        catch( EmptyResultDataAccessException e)
        {
            return null;
        }
    }

    public boolean isStopped()
    {
        InvoicingCommandDto dto = readLatest();

        if( dto == null || dto.getStatus() == InvoicingStatusType.STOPPED)
        {
            return true;
        }

        return false;
    }

    public boolean isStarted()
    {
        InvoicingCommandDto dto = readLatest();

        if( dto != null && dto.getStatus() == InvoicingStatusType.STARTED)
        {
            return true;
        }

        return false;
    }

    public boolean isRunning()
    {
        InvoicingCommandDto dto = readLatest();

        if( dto != null && dto.getStatus() == InvoicingStatusType.RUNNING)
        {
            return true;
        }

        return false;
    }

    public boolean shallTriggerAx()
    {
        InvoicingCommandDto dto = readLatest();

        if( dto != null)
        {
            return dto.getTriggerAx();
        }

        return false;
    }

    @Override
    public InvoicingCommandDto read( long id)
    {
        return readByIdImpl( InvoicingCommandDto.class, id);
    }

    @Override
    public void delete( long id)
    {
        deleteByIdImpl( id);
    }

    @Override
    public List< InvoicingCommandDto> readAll()
    {
        return readAllImpl( InvoicingCommandDto.class);
    }

    @Override
    public List< InvoicingCommandDto> readAllAfter( Timestamp time)
    {
        return readAllAfterImpl( InvoicingCommandDto.class, time);
    }
}
