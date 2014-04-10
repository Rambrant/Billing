package com.tradedoubler.billing.derby.dao;

import java.sql.SQLException;

/**
 * @author Thomas Rambrant (thore)
 */

public class CrmCreateInvoiceRuleDao extends CrmMessageDao
{
    final static String TABLE_NAME = "QUE_CREATE_INVOICE_RULE";

    public CrmCreateInvoiceRuleDao() throws SQLException
    {
        super( TABLE_NAME);
    }
}
