package com.tradedoubler.billing.derby.dao;

import com.tradedoubler.billing.derby.DerbyDao;
import com.tradedoubler.billing.derby.dto.EventLogDto;
import com.tradedoubler.billing.fetch.FlowName;
import com.tradedoubler.billing.type.EventLogType;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Thomas Rambrant (thore)
 */

public class EventLogDao extends DerbyDao< EventLogDto>
{
    private BeanPropertyRowMapper< EventLogDto> rowMap = new BeanPropertyRowMapper<EventLogDto>( EventLogDto.class);

    final static String CREATE_SQL =
        " CREATE TABLE "                         +
             "???"                               +
        " ("                                     +
            " id                   INT,"         +
            " created              TIMESTAMP,"   +
            " flow_name            VARCHAR(32)," +
            " message_id           VARCHAR(38)," +
            " event_type           VARCHAR(10)," +
            " integration_point_id VARCHAR(64)"  +
        " )";

    private String insertSql;
    private String readAllByMessageSql;
    private String readAllByFlowSql;
    private String readAllByFlowAfterSql;


    public EventLogDao() throws SQLException
    {
        super( CREATE_SQL, "EVENT_LOG", "id", "created");

        initSqlStatements( "EVENT_LOG", "id", "created");
    }

    private void initSqlStatements( String tableName, String idColumnName, String createdColumnName)
    {
        insertSql =
            " INSERT INTO "              +
                tableName                +
            " ("                         +
                idColumnName +", "       +  //  1
                createdColumnName + ", " +  //  2
                " flow_name,"            +  //  3
                " message_id,"           +  //  4
                " event_type,"           +  //  5
                " integration_point_id)" +  //  6
            " VALUES ( ?, ?, ?, ?, ?, ?)";

        readAllByMessageSql =
            " SELECT"             +
                " *"              +
            " FROM "              +
                tableName         +
            " WHERE"              +
                " message_id = ?";   //  1

        readAllByFlowSql =
            " SELECT"             +
                " *"              +
            " FROM "              +
                tableName         +
            " WHERE"              +
                " flow_name = ?";   //  1

        readAllByFlowAfterSql =
            " SELECT"                +
                " *"                 +
            " FROM "                 +
                tableName            +
            " WHERE"                 +
                " flow_name = ? AND" +  //  1
                " created >= ?";        //  2
    }

    public Long create(
        EventLogType eventType,
        FlowName     flowName,
        String       integrationPointId,
        String       messageId)
    {
        Long id = getNextSequence();

        Timestamp createTime = new Timestamp( System.currentTimeMillis());

        getJdbcTemplate().update(
            insertSql,
            id,                         //  1
            createTime,                 //  2
            flowName.toString(),        //  3
            messageId.toLowerCase(),    //  4
            eventType.toString(),       //  5
            integrationPointId);        //  6

        return id;
    }

    public List< EventLogDto> readAllByMessageId( String messageId)
    {
        try
        {
            return getJdbcTemplate().query(
                readAllByMessageSql,
                rowMap,
                messageId.toLowerCase()); //  1
        }
        catch( EmptyResultDataAccessException e)
        {
            return new ArrayList< EventLogDto>();
        }

    }

    public List< EventLogDto> readAllByFlowName( FlowName flowName)
    {
        try
        {
            return getJdbcTemplate().query(
                readAllByFlowSql,
                rowMap,
                flowName.toString()); //  1
        }
        catch( EmptyResultDataAccessException e)
        {
            return new ArrayList< EventLogDto>();
        }
    }

    public List< EventLogDto> readAllByFlowNameAfter( FlowName flowName, Timestamp time)
    {
        try
        {
            return getJdbcTemplate().query(
                readAllByFlowAfterSql,
                rowMap,
                flowName.toString(),    //  1
                time);                  //  2
        }
        catch( EmptyResultDataAccessException e)
        {
            return new ArrayList< EventLogDto>();
        }
    }

    @Override
    public EventLogDto read( long id)
    {
        return readByIdImpl( EventLogDto.class, id);
    }

    @Override
    public void delete( long id)
    {
        deleteByIdImpl( id);
    }

    @Override
    public List< EventLogDto> readAll()
    {
        return readAllImpl( EventLogDto.class);
    }

    @Override
    public List< EventLogDto> readAllAfter( Timestamp time)
    {
        return readAllAfterImpl( EventLogDto.class, time);
    }
}
