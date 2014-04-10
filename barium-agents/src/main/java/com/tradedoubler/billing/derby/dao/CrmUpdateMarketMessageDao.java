package com.tradedoubler.billing.derby.dao;

import java.sql.SQLException;

/**
 * @author Thomas Rambrant (thore)
 */

public class CrmUpdateMarketMessageDao extends CrmMessageDao
{
    final static String TABLE_NAME = "QUE_UPDATE_MARKET_MESSAGE";

    public CrmUpdateMarketMessageDao() throws SQLException
    {
        super( TABLE_NAME);
    }
}
