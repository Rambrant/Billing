package com.tradedoubler.billing.service.pan.call;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.BillingServiceException;
import org.slf4j.*;
import org.springframework.jdbc.core.simple.*;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.*;

import java.math.BigDecimal;
import java.util.*;

/**
 * Confirms in Pan that order lines have been inserted into Ax. Order line insertion failures are inserted in the table
 * order_line_ax_errors before the confirmation.
 *
 * @author bjorn
 * @since 2012-10-10
 */
public class ConfirmOrderLinesCall extends AbstractDatabaseCall {
    private final static Logger log = LoggerFactory.getLogger(ConfirmOrderLinesCall.class);

    private final TransactionTemplate transactionTemplate;
    private final SimpleJdbcCall updateBatchOfOrderLines;

    public ConfirmOrderLinesCall(SimpleJdbcTemplate jdbcTemplate, TransactionTemplate transactionTemplate, SimpleJdbcCall updateBatchOfOrderLines) {
        super(jdbcTemplate);
        this.updateBatchOfOrderLines = updateBatchOfOrderLines;
        this.transactionTemplate = transactionTemplate;
    }

    /**
     * The confirmation will be done inside a transaction, failed order lines will not be left in pan database if the
     * call to updateBatchOfOrderLines fails.
     *
     * @param batchId          the batch to confirm
     * @param failedOrderLines order lines that have not been inserted into Ax (if any)
     * @throws BillingServiceException thrown if database operation fails
     */
    public void confirm(final Guid batchId, List<OrderLineFailed> failedOrderLines) throws BillingServiceException {
        final int nrOfFailedOrderLines = failedOrderLines.size();
        final Map<String, Object>[] valuesMappedByParameterNameArray = new Map[nrOfFailedOrderLines];

        for (int i = 0; i < nrOfFailedOrderLines; i++) {
            OrderLineFailed failedOrderLine = failedOrderLines.get(i);
            valuesMappedByParameterNameArray[i] = new LinkedHashMap<String, Object>(3);
            valuesMappedByParameterNameArray[i].put("batchId", batchId.getGuidForOracleDb());
            valuesMappedByParameterNameArray[i].put("orderLineId", failedOrderLine.getOrderLineId());
            valuesMappedByParameterNameArray[i].put("errorCode", failedOrderLine.getErrorMessage());
        }

        TransactionCallback<Integer> insertAndConfirmOrderLines = new InsertAndConfirmOrderLines(getJdbcTemplate(), updateBatchOfOrderLines, batchId, valuesMappedByParameterNameArray);
        Integer returnValue = transactionTemplate.execute(insertAndConfirmOrderLines);

        if (returnValue == DB_FUNCTION_ERROR_CODE) {
            throw BillingServiceException.createBugDisturbance("Something went wrong when executing stored function billing_pkg.updateBatchOfOrderLines in Pan database, batchId: " + batchId.getGuidForOracleDb());
        }
    }

    /**
     * This represents several sql calls which will be executed in a transaction context.
     *
     * @see TransactionCallback
     */
    private static class InsertAndConfirmOrderLines implements TransactionCallback<Integer> {
        private final SimpleJdbcTemplate jdbcTemplate;
        private final SimpleJdbcCall updateBatchOfOrderLines;
        private final Guid batchId;
        private final Map<String, Object>[] valuesMappedByParameterNameArray;

        public InsertAndConfirmOrderLines(SimpleJdbcTemplate jdbcTemplate, SimpleJdbcCall updateBatchOfOrderLines, Guid batchId, Map<String, Object>[] valuesMappedByParameterNameArray) {
            this.jdbcTemplate = jdbcTemplate;
            this.updateBatchOfOrderLines = updateBatchOfOrderLines;
            this.batchId = batchId;
            this.valuesMappedByParameterNameArray = valuesMappedByParameterNameArray;
        }

        /**
         * Gets called by {@link TransactionTemplate#execute} within a transactional context.
         * Does not need to care about transactions itself, although it can retrieve
         * and influence the status of the current transaction via the given status
         * object, e.g. setting rollback-only.
         * <p/>
         * <p>Allows for returning a result object created within the transaction, i.e.
         * a domain object or a collection of domain objects. A RuntimeException thrown
         * by the callback is treated as application exception that enforces a rollback.
         * An exception gets propagated to the caller of the template.
         *
         * @param transactionStatus associated transaction status
         * @return a result status for the updateBatchOfOrderLines stored function
         * @see TransactionTemplate#execute
         */
        @Override
        public Integer doInTransaction(TransactionStatus transactionStatus) {
            int returnValue = insertOrderLineErrorsAndConfirmBatch();

            if (returnValue == DB_FUNCTION_ERROR_CODE) {
                transactionStatus.setRollbackOnly();
            }

            return returnValue;
        }

        private int insertOrderLineErrorsAndConfirmBatch() {
            // Insert failed order lines if any exists
            if (valuesMappedByParameterNameArray.length != 0) {
                jdbcTemplate.batchUpdate("" +
                        " INSERT INTO admin.order_line_ax_errors" +
                        " (order_line_batch_id, order_line_id, error_code)" +
                        " VALUES (:batchId, :orderLineId, :errorCode)",
                        valuesMappedByParameterNameArray);
                log.debug(String.format("Inserted %d failed order lines in order_line_ax_errors", valuesMappedByParameterNameArray.length));
            }

            // Confirm that the batch has been processed
            return updateBatchOfOrderLines.executeFunction(BigDecimal.class, batchId.getGuidForOracleDb()).intValue();
        }
    }
}
