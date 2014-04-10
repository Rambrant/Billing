package com.tradedoubler.billing.derby.dao;

import java.sql.SQLException;

/**
 * @author Thomas Rambrant (thore)
 */

public class AxOrderLineDao extends OrderLineDao
{
    public AxOrderLineDao() throws SQLException
    {
        super( "AX_ORDER_LINES");
    }
}
