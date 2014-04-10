package com.tradedoubler.billing.derby.dao;

import java.sql.SQLException;

/**
 * @author Thomas Rambrant (thore)
 */

public class CrmUpdateAgreementDao extends CrmMessageDao
{
    final static String TABLE_NAME = "QUE_UPDATE_AGREEMENT";

    public CrmUpdateAgreementDao() throws SQLException
    {
        super( TABLE_NAME);
    }
}
