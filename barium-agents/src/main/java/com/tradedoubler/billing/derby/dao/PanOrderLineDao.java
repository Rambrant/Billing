package com.tradedoubler.billing.derby.dao;

import java.sql.SQLException;

/**
 * @author Thomas Rambrant (thore)
 */

public class PanOrderLineDao extends OrderLineDao
{
    public PanOrderLineDao() throws SQLException
    {
        super( "PAN_ORDER_LINES");
    }
}
