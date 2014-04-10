package com.tradedoubler.billing.derby.dao;

import com.tradedoubler.billing.derby.DerbyDao;
import com.tradedoubler.billing.derby.dto.CrmMessageDto;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Thomas Rambrant (thore)
 */

public abstract class CrmMessageDao extends DerbyDao< CrmMessageDto>
{
    private BeanPropertyRowMapper< CrmMessageDto> rowMapper = new BeanPropertyRowMapper< CrmMessageDto>( CrmMessageDto.class);

    static String CREATE_SQL =
        " CREATE TABLE"                            +
             " ???"                                +
        " ("                                       +
            " id                   INT,"           +
            " created              TIMESTAMP,"     +
            " entity_id            VARCHAR(64),"   +
            " event_type           VARCHAR(32),"   +
            " out_of_order         BOOLEAN,"       +
            " associated_row_id    INT,"           +
            " sent                 BOOLEAN,"       +
            " send_time            TIMESTAMP,"     +
            " number_of_sends      INT,"           +
            " deleted              BOOLEAN,"       +
            " delete_time          TIMESTAMP,"     +
            " message_id           VARCHAR(38),"   +
            " json_message         VARCHAR(30000)" +
        " )";

    private String insertSql;
    private String updateSql;
    private String readNextSql;
    private String readByEntitySql;
    private String readLastByEntitySql;


    public CrmMessageDao( String tableName) throws SQLException
    {
        super( CREATE_SQL, tableName, "id", "created");

        initSqlStatements( tableName, "id", "created");
    }

    private void initSqlStatements( String tableName, String idColumnName, String createdColumnName)
    {
        insertSql =
            " INSERT INTO "              +
                tableName                +
            " ( "                        +
                idColumnName + ", "      +  //  1
                createdColumnName + ", " +  //  2
                " entity_id,"            +  //  3
                " event_type,"           +  //  4
                " out_of_order,"         +  //  5
                " associated_row_id,"    +  //  6
                " sent,"                 +  //  7
                " send_time,"            +  //  8
                " number_of_sends,"      +  //  9
                " deleted,"              +  // 10
                " delete_time,"          +  // 11
                " message_id,"           +  // 12
                " json_message) "        +  // 13
            " VALUES ( ?, ?, ?, ? , ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        updateSql =
            " UPDATE "                    +
                tableName                 +
            " SET"                        +
                " event_type        = ?," +     //  1
                " out_of_order      = ?," +     //  2
                " associated_row_id = ?," +     //  3
                " sent              = ?," +     //  4
                " send_time         = ?," +     //  5
                " number_of_sends   = ?," +     //  6
                " deleted           = ?," +     //  7
                " delete_time       = ?," +     //  8
                " message_id        = ?," +     //  9
                " entity_id         = ?," +     // 10
                " json_message      = ?"  +     // 11
            " WHERE "                     +
                idColumnName +" = ?";           // 12

        readNextSql =
            " SELECT"                                  +
                " *"                                   +
            " FROM "                                   +
                tableName                              +
            " WHERE"                                   +
                " id IN ("                             +
                    " SELECT"                          +
                        " MIN( id)"                    +
                    " FROM "                           +
                        tableName                      +
                    " WHERE"                           +
                        " deleted = FALSE AND"         +
                        " out_of_order = FALSE AND ( " +
                            " sent = FALSE OR "        +
                            " send_time <= ?))";            //  1

        readByEntitySql =
            " SELECT"             +
                " *"              +
            " FROM "              +
                tableName         +
            " WHERE"              +
                " entity_id = ?";   //  1

        readLastByEntitySql =
            " SELECT"                  +
                " *"                   +
            " FROM "                   +
                tableName              +
            " WHERE"                   +
                " id IN ("             +
                    " SELECT"          +
                        " MAX( id)"    +
                    " FROM "           +
                        tableName      +
                    " WHERE"           +
                        " entity_id = ?)";  //  1

    }

    public Long create( CrmMessageDto dto, String entityId)
    {
        dto.setId( getNextSequence());
        dto.setEntityId( entityId.toLowerCase());
        dto.setCreated( new Timestamp( System.currentTimeMillis()));

        dto.setMessageId( (dto.getMessageId() == null) ? null : dto.getMessageId());

        getJdbcTemplate().update(
            insertSql,
            dto.getId(),                    //  1
            dto.getCreated(),               //  2
            dto.getEntityId(),              //  3
            dto.getEventType().toString(),  //  4
            dto.isOutOfOrder(),             //  5
            dto.getAssociatedRowId(),       //  6
            dto.isSent(),                   //  7
            dto.getSendTime(),              //  8
            dto.getNumberOfSends(),         //  9
            dto.isDeleted(),                // 10
            dto.getDeleteTime(),            // 11
            dto.getMessageId(),             // 12
            dto.getJsonMessage());          // 13

        return dto.getId();
    }

    public void update( CrmMessageDto dto)
    {
        dto.setMessageId( (dto.getMessageId() == null) ? null : dto.getMessageId().toLowerCase());
        dto.setEntityId( (dto.getEntityId() == null) ? null : dto.getEntityId().toLowerCase());

        getJdbcTemplate().update(
            updateSql,
            dto.getEventType().toString(),  //  1
            dto.isOutOfOrder(),             //  2
            dto.getAssociatedRowId(),       //  3
            dto.isSent(),                   //  4
            dto.getSendTime(),              //  5
            dto.getNumberOfSends(),         //  6
            dto.isDeleted(),                //  7
            dto.getDeleteTime(),            //  8
            dto.getMessageId(),             //  9
            dto.getEntityId(),              // 10
            dto.getJsonMessage(),           // 11
            dto.getId());                   // 12
    }

    public CrmMessageDto readNext( long timeout)
    {
        try
        {
            Timestamp time = new Timestamp( System.currentTimeMillis() - timeout);

            return getJdbcTemplate().queryForObject(
                readNextSql,
                rowMapper,
                time);  //  1
        }
        catch( EmptyResultDataAccessException e)
        {
            return null;
        }
    }

    public List< CrmMessageDto> readByEntityId( String entityId)
    {
        try
        {
            return getJdbcTemplate().query(
                readByEntitySql,
                rowMapper,
                entityId.toLowerCase());  //  1
        }
        catch( EmptyResultDataAccessException e)
        {
            return new ArrayList< CrmMessageDto>();
        }
    }

    public CrmMessageDto readLastByEntityId( String entityId)
    {
        try
        {
            return getJdbcTemplate().queryForObject(
                readLastByEntitySql,
                rowMapper,
                entityId.toLowerCase());  //  1
        }
        catch( EmptyResultDataAccessException e)
        {
            return null;
        }
    }

    @Override
    public CrmMessageDto read( long id)
    {
        return readByIdImpl( CrmMessageDto.class, id);
    }

    @Override
    public void delete( long id)
    {
        deleteByIdImpl( id);
    }

    @Override
    public List< CrmMessageDto> readAll()
    {
        return readAllImpl( CrmMessageDto.class);
    }

    @Override
    public List< CrmMessageDto> readAllAfter( Timestamp time)
    {
        return readAllAfterImpl( CrmMessageDto.class, time);
    }
}
