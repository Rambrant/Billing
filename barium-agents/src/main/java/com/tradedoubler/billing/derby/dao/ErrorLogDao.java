package com.tradedoubler.billing.derby.dao;

import com.tradedoubler.billing.derby.DerbyDao;
import com.tradedoubler.billing.derby.dto.ErrorLogDto;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Thomas Rambrant (thore)
 */

public class ErrorLogDao extends DerbyDao< ErrorLogDto>
{
    final static String TABLE_NAME = "ERROR_LOG";

    final static String CREATE_SQL =
        " CREATE TABLE "              +
             "???"                    +
        " ("                          +
            " id        INT,"         +
            " created   TIMESTAMP,"   +
            " message   VARCHAR(256)" +
        " )";

    private String insertSql;


    public ErrorLogDao() throws SQLException
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
                idColumnName + ", "      +       //  1
                createdColumnName + ", " +       //  2
                " message) "             +       //  3
            " VALUES ( ?, ?, ?)";
   }

    public Long create( String message)
    {
        Long id = getNextSequence();

        Timestamp createTime = new Timestamp( System.currentTimeMillis());

        //
        // The message can't be longer than the maximum size of the database column 'message'
        //
        String subMessage = message.substring( 0, (message.length() > 255) ? 255 : message.length());

        getJdbcTemplate().update(
            insertSql,
            id,             //  1
            createTime,     //  2
            subMessage);    //  3

        return id;
    }

    @Override
    public ErrorLogDto read( long id)
    {
        return readByIdImpl( ErrorLogDto.class, id);
    }

    @Override
    public void delete( long id)
    {
        deleteByIdImpl( id);
    }

    @Override
    public List< ErrorLogDto> readAll()
    {
        return readAllImpl( ErrorLogDto.class);
    }

    @Override
    public List< ErrorLogDto> readAllAfter( Timestamp time)
    {
        return readAllAfterImpl( ErrorLogDto.class, time);
    }
}
