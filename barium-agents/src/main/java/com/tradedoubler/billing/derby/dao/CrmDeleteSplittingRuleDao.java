package com.tradedoubler.billing.derby.dao;

import java.sql.SQLException;

/**
 * @author Thomas Rambrant (thore)
 */

public class CrmDeleteSplittingRuleDao extends CrmMessageDao
{
    final static String TABLE_NAME = "QUE_DELETE_SPLITTING_RULE";

    public CrmDeleteSplittingRuleDao() throws SQLException
    {
        super( TABLE_NAME);
    }
}
