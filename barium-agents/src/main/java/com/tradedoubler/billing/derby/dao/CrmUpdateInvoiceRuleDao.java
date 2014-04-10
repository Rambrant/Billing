package com.tradedoubler.billing.derby.dao;

import java.sql.SQLException;

/**
 * @author Thomas Rambrant (thore)
 */

public class CrmUpdateInvoiceRuleDao extends CrmMessageDao
{
    final static String TABLE_NAME = "QUE_UPDATE_INVOICE_RULE";

    public CrmUpdateInvoiceRuleDao() throws SQLException
    {
        super( TABLE_NAME);
    }
}
