package com.tradedoubler.billing.derby.dao;

import com.tradedoubler.billing.derby.DerbyDao;
import com.tradedoubler.billing.derby.dto.DerbyTestDto;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Thomas Rambrant (thore)
 */

public class DerbyTestDao extends DerbyDao< DerbyTestDto>
{
    public final static String TABLE_NAME = "DERBY_TEST";

    final static String CREATE_SQL =
        " CREATE TABLE "           +
             "???"                 +
        " ("                       +
            " id      INT,"        +
            " created TIMESTAMP,"  +
            " name    VARCHAR(25)" +
        " )";

    private static String insertSql;
    private static String updateSql;


    public DerbyTestDao() throws SQLException
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
                idColumnName + ", "      +   //  1
                createdColumnName + ", " +   //  2
                " name) "                +   //  3
            " VALUES("                   +
                " ?, ?, ?)";

        updateSql =
            " UPDATE "       +
                tableName    +
            " SET"           +
                " name = ?"  +  //  1
            " WHERE"         +
                " id = ?";      //  2
    }

    public Long create( DerbyTestDto dto)
    {
        dto.setId( getNextSequence());

        Timestamp createTime = new Timestamp( System.currentTimeMillis());

        getJdbcTemplate().update(
            insertSql,
            dto.getId(),     //  1
            createTime,      //  2
            dto.getName());  //  3

        return dto.getId();
    }

    public void update( DerbyTestDto dto)
    {
        getJdbcTemplate().update(
            updateSql,
            dto.getName(),  //  1
            dto.getId());   //  2
    }

    public void delete( long id)
    {
        deleteByIdImpl( id);
    }

    @Override
    public DerbyTestDto read( long id)
    {
        return readByIdImpl( DerbyTestDto.class, id);
    }

    @Override
    public List< DerbyTestDto> readAll()
    {
        return readAllImpl( DerbyTestDto.class);
    }

    @Override
    public List< DerbyTestDto> readAllAfter( Timestamp time)
    {
        return readAllAfterImpl( DerbyTestDto.class, time);
    }
}
