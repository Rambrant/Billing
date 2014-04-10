package com.tradedoubler.billing.service.pan;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.PreDestroy;
import java.sql.SQLException;

/**
 * Sets up transaction manager, the jdbcTemplate and stored procedure entities for interaction with the Pan database.
 * The data source is created in a spring configuration file.
 *
 * @author bjoek
 * @since 2012-10-02
 */
@Component
public class PanDatabaseServiceSetupImpl implements PanDatabaseServiceSetup {
    private final static Logger log = LoggerFactory.getLogger(PanDatabaseServiceSetupImpl.class);

    @Autowired
    @Qualifier("panAdminDataSource")
    private BasicDataSource dataSource;

    private SimpleJdbcTemplate jdbcTemplate;
    private TransactionTemplate transactionTemplate;

    private SimpleJdbcCall fetchOrderLineBatchId;
    private SimpleJdbcCall updateBatchOfOrderLines;
    private SimpleJdbcCall updateBatchOfOrderLinesPP;
    private SimpleJdbcCall invoicingStarted;
    private SimpleJdbcCall invoiceCreatedAx;
    private SimpleJdbcCall fetchOrderLineBatchIdPP;
    private SimpleJdbcCall readyToInvoice;
    private SimpleJdbcCall updateProgram;
    private SimpleJdbcCall invoiceStatusChange;

    /**
     * The jdbcTemplate is used for select, update and insert queries. The SimpleJdbcTemplate is thread safe and
     * can be shared by many flows.
     */
    @Override
    public synchronized SimpleJdbcTemplate getJdbcTemplate() {
        initializeDatabaseEntities();

        return jdbcTemplate;
    }


    /**
     * The transactionTemplate is used to execute queries in a transactional context. The TransactionTemplate is thread
     * safe and can be shared by many flows
     */
    @Override
    public synchronized TransactionTemplate getTransactionTemplate() {
        initializeDatabaseEntities();

        return transactionTemplate;
    }

    /** Returns a thread-safe, reusable object representing a call to the stored function admin.billing_pkg.fetchOrderLineBatchId */
    @Override
    public synchronized SimpleJdbcCall getFetchOrderLineBatchId() {
        initializeDatabaseEntities();

        return fetchOrderLineBatchId;
    }

    /** Returns a thread-safe, reusable object representing a call to the stored function admin.billing_pkg.updateBatchOfOrderLines */
    @Override
    public synchronized SimpleJdbcCall getUpdateBatchOfOrderLines() {
        initializeDatabaseEntities();

        return updateBatchOfOrderLines;
    }

    /** Returns a thread-safe, reusable object representing a call to the stored function admin.billing_pkg.updateBatchOfForecastOrderLines */
    @Override
    public synchronized SimpleJdbcCall getUpdateBatchOfOrderLinesPP() {
        initializeDatabaseEntities();

        return updateBatchOfOrderLinesPP;
    }

    /** Returns a thread-safe, reusable object representing a call to the stored function admin.billing_pkg.invoicingStarted */
    @Override
    public synchronized SimpleJdbcCall getInvoicingStarted() {
        initializeDatabaseEntities();

        return invoicingStarted;
    }

    /** Returns a thread-safe, reusable object representing a call to the stored function admin.billing_pkg.invoiceCreatedAx */
    @Override
    public synchronized SimpleJdbcCall getInvoiceCreatedAx() {
        initializeDatabaseEntities();

        return invoiceCreatedAx;
    }

    /** Returns a thread-safe, reusable object representing a call to the stored function admin.billing_pkg.fetchForecastOrderLineBatchId */
    @Override
    public synchronized SimpleJdbcCall getFetchOrderLineBatchIdPP() {
        initializeDatabaseEntities();

        return fetchOrderLineBatchIdPP;
    }

    /** Returns a thread-safe, reusable object representing a call to the stored function admin.billing_pkg.readyToInvoice */
    @Override
    public synchronized SimpleJdbcCall getReadyToInvoice() {
        initializeDatabaseEntities();

        return readyToInvoice;
    }

    /** Returns a thread-safe, reusable object representing a call to the stored function admin.billing_pkg.updateProgram */
    @Override
    public synchronized SimpleJdbcCall getUpdateProgram() {
        initializeDatabaseEntities();

        return updateProgram;
    }

    /** Returns a thread-safe, reusable object representing a call to the stored function admin.billing_pkg.invoiceStatusChangeAx */
    @Override
    public SimpleJdbcCall getInvoiceStateChanged() {
        initializeDatabaseEntities();

        return invoiceStatusChange;
    }

    private void initializeDatabaseEntities() {
        if (jdbcTemplate == null) {
            log.info("Initializing pan database, url " + dataSource.getUrl());

            DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
            transactionTemplate = new TransactionTemplate(transactionManager);
            jdbcTemplate = new SimpleJdbcTemplate(dataSource);
            createStoredFunctionsAndProcedures();
        }
    }

    private void createStoredFunctionsAndProcedures() {
        fetchOrderLineBatchId = new SimpleJdbcCall(dataSource)
                .withSchemaName("admin").withCatalogName("billing_pkg")
                .withFunctionName("fetchOrderLineBatchId");
        updateBatchOfOrderLines = new SimpleJdbcCall(dataSource)
                .withSchemaName("admin").withCatalogName("billing_pkg")
                .withFunctionName("updateBatchOfOrderLines");
        updateBatchOfOrderLinesPP = new SimpleJdbcCall(dataSource)
                .withSchemaName("admin").withCatalogName("billing_pkg")
                .withFunctionName("updateBatchOfOrderLinesPP");
        invoicingStarted = new SimpleJdbcCall(dataSource)
                .withSchemaName("admin").withCatalogName("billing_pkg")
                .withFunctionName("invoicingStarted");
        invoiceCreatedAx = new SimpleJdbcCall(dataSource)
                .withSchemaName("admin").withCatalogName("billing_pkg")
                .withFunctionName("invoiceCreatedAx");
        fetchOrderLineBatchIdPP = new SimpleJdbcCall(dataSource)
                .withSchemaName("admin").withCatalogName("billing_pkg")
                .withFunctionName("fetchOrderLineBatchIdPP");
        readyToInvoice = new SimpleJdbcCall(dataSource)
                .withSchemaName("admin").withCatalogName("billing_pkg")
                .withFunctionName("readyToInvoice");
        updateProgram = new SimpleJdbcCall(dataSource)
                .withSchemaName("admin").withCatalogName("billing_pkg")
                .withFunctionName("updateProgram");
        invoiceStatusChange = new SimpleJdbcCall(dataSource)
                .withSchemaName("admin").withCatalogName("billing_pkg")
                .withFunctionName("invoiceStatusChangedAx");
    }

    /** Make sure that database entities are shutdown correctly */
    @PreDestroy
    public synchronized void close() {
        jdbcTemplate = null;
        transactionTemplate = null;
        if (dataSource != null) {
            try {
                dataSource.close();
            } catch (SQLException e) {
                // Spring context is on its way to disappear, there is nothing to do
            }
            dataSource = null;
        }
    }

}
