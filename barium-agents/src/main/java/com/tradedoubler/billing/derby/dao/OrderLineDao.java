package com.tradedoubler.billing.derby.dao;

import com.tradedoubler.billing.derby.DerbyDao;
import com.tradedoubler.billing.derby.dto.OrderLineDto;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Thomas Rambrant (thore)
 */

public abstract class OrderLineDao extends DerbyDao< OrderLineDto>
{
    private BeanPropertyRowMapper< OrderLineDto> rowMap = new BeanPropertyRowMapper< OrderLineDto>( OrderLineDto.class);

    static String CREATE_SQL =
        " CREATE TABLE"                        +
             " ???"                            +
        " ("                                   +
            " id               INT,"           +
            " agreement_id     VARCHAR(64),"   +
            " created          TIMESTAMP,"     +
            " event_type       VARCHAR(32),"   +
            " handled          BOOLEAN,"       +
            " batch_id         VARCHAR(36),"   +
            " num_order_lines  INT,"           +
            " order_line_id    VARCHAR(10),"   +
            " json_order_line  VARCHAR(30000)" +
        " )";

    private String insertSql;
    private String updateSql;
    private String readNextSql;
    private String readByAgreementSql;


    public OrderLineDao( String tableName) throws SQLException
    {
        super( CREATE_SQL, tableName, "id", "created");

        initSqlStatements( tableName, "id", "created");
    }

    private void initSqlStatements( String tableName, String idColumnName, String createdColumnName)
    {
        insertSql =
            " INSERT INTO "             +
                tableName               +
            " ("                        +
                idColumnName + ","      +  //  1
                " agreement_id, "       +  //  2
                createdColumnName + "," +  //  3
                " event_type,"          +  //  4
                " handled,"             +  //  5
                " batch_id,"            +  //  6
                " num_order_lines,"     +  //  7
                " order_line_id,"       +  //  8
                " json_order_line) "    +  //  9
            " VALUES ( ?, ?, ?, ? , ?, ?, ?, ?, ?)";

        updateSql =
            " UPDATE "                      +
                tableName                   +
            " SET "                         +
                createdColumnName + " = ?," +   //  1
                " event_type          = ?," +   //  2
                " handled             = ?," +   //  3
                " batch_id            = ?," +   //  4
                " num_order_lines     = ?," +   //  5
                " order_line_id       = ?," +   //  6
                " agreement_id        = ?," +   //  7
                " json_order_line     = ?"  +   //  8
            " WHERE "                       +
                idColumnName + " = ?";          //  9

        readNextSql =
            " SELECT"                          +
                " *"                           +
            " FROM "                           +
                tableName                      +
            " WHERE"                           +
                " id IN ("                     +
                    " SELECT"                  +
                        " MIN( id)"            +
                    " FROM "                   +
                        tableName              +
                    " WHERE"                   +
                        " handled = FALSE AND" +
                        " created <= ?"        +    //  1
                " )";

        readByAgreementSql =
            " SELECT"                +
                " *"                 +
            " FROM "                 +
                tableName            +
            " WHERE"                 +
                " agreement_id = ?";    //  1
    }

    public Long create( OrderLineDto dto, String agreementId)
    {
        dto.setId( getNextSequence());
        dto.setAgreementId( agreementId.toLowerCase());

        if( dto.getCreated() == null)
        {
            dto.setCreated( new Timestamp( System.currentTimeMillis()));
        }

        dto.setBatchId( (dto.getBatchId() == null) ? null : dto.getBatchId().toLowerCase());
        dto.setOrderLineId( (dto.getOrderLineId() == null) ? null : dto.getOrderLineId().toLowerCase());

        getJdbcTemplate().update(
            insertSql,
            dto.getId(),                    //  1
            dto.getAgreementId(),           //  2
            dto.getCreated(),               //  3
            dto.getEventType().toString(),  //  4
            dto.isHandled(),                //  5
            dto.getBatchId(),               //  6
            dto.getNumOrderLines(),         //  7
            dto.getOrderLineId(),           //  8
            dto.getJsonOrderLine());        //  9

        return dto.getId();
    }

    public void update( OrderLineDto dto)
    {
        dto.setAgreementId( (dto.getAgreementId() == null) ? null : dto.getAgreementId().toLowerCase());
        dto.setBatchId( (dto.getBatchId() == null) ? null : dto.getBatchId().toLowerCase());
        dto.setOrderLineId( (dto.getOrderLineId() == null) ? null : dto.getOrderLineId().toLowerCase());

        getJdbcTemplate().update(
            updateSql,
            dto.getCreated(),                   //  1
            dto.getEventType().toString(),      //  2
            dto.isHandled(),                    //  3
            dto.getBatchId(),                   //  4
            dto.getNumOrderLines(),             //  5
            dto.getOrderLineId(),               //  6
            dto.getAgreementId(),               //  7
            dto.getJsonOrderLine(),             //  8
            dto.getId());                       //  9
    }

    public OrderLineDto readNextBefore( Timestamp created)
    {
        try
        {
            return getJdbcTemplate().queryForObject(
                readNextSql,
                rowMap,
                created);
        }
        catch( EmptyResultDataAccessException e)
        {
            return null;
        }
    }

    public List< OrderLineDto> readByAgreementId( String agreementId)
    {
        try
        {
            return getJdbcTemplate().query(
                readByAgreementSql,
                rowMap,
                (agreementId.toLowerCase() == null) ? null : agreementId.toLowerCase());   //  1
        }
        catch( EmptyResultDataAccessException e)
        {
            return new ArrayList< OrderLineDto>();
        }
    }

    @Override
    public OrderLineDto read( long id)
    {
        return readByIdImpl( OrderLineDto.class, id);
    }

    @Override
    public void delete( long id)
    {
        deleteByIdImpl( id);
    }

    @Override
    public List< OrderLineDto> readAll()
    {
        return readAllImpl( OrderLineDto.class);
    }

    @Override
    public List< OrderLineDto> readAllAfter( Timestamp time)
    {
        return readAllAfterImpl( OrderLineDto.class, time);
    }
}
