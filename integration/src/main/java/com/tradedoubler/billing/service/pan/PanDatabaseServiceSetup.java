package com.tradedoubler.billing.service.pan;

import org.springframework.jdbc.core.simple.*;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Sets up transaction manager, the jdbcTemplate and stored procedure entities for interaction with the Pan database.
 *
 * @see PanDatabaseServiceSetupImpl
 * @author bjoek
 * @since 2012-10-02
 */
public interface PanDatabaseServiceSetup {
    SimpleJdbcTemplate getJdbcTemplate();

    TransactionTemplate getTransactionTemplate();

    SimpleJdbcCall getFetchOrderLineBatchId();

    SimpleJdbcCall getUpdateBatchOfOrderLines();

    SimpleJdbcCall getUpdateBatchOfOrderLinesPP();

    SimpleJdbcCall getInvoicingStarted();

    SimpleJdbcCall getInvoiceCreatedAx();

    SimpleJdbcCall getFetchOrderLineBatchIdPP();

    SimpleJdbcCall getReadyToInvoice();

    SimpleJdbcCall getUpdateProgram();

    SimpleJdbcCall getInvoiceStateChanged();
}
