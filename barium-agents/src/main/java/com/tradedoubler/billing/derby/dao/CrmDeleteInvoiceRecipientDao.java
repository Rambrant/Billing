package com.tradedoubler.billing.derby.dao;

import java.sql.SQLException;

/**
 * @author Thomas Rambrant (thore)
 */

public class CrmDeleteInvoiceRecipientDao extends CrmMessageDao
{
    final static String TABLE_NAME = "QUE_DELETE_INVOICE_RECIPIENT";

    public CrmDeleteInvoiceRecipientDao() throws SQLException
    {
        super( TABLE_NAME);
    }
}
