package com.tradedoubler.billing.derby.dao;

import java.sql.SQLException;

/**
 * @author Thomas Rambrant (thore)
 */

public class CrmUpdateClientDao extends CrmMessageDao
{
    final static String TABLE_NAME = "QUE_UPDATE_CLIENT";

    public CrmUpdateClientDao() throws SQLException
    {
        super( TABLE_NAME);
    }
}
