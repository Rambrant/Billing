package com.tradedoubler.billing.service.pan.call;

import com.tradedoubler.billing.domain.InvoicedOrderLine;
import com.tradedoubler.billing.service.BillingServiceException;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * This call inserts invoiced order lines into Pan.
 */
public class InsertInvoicedOrderLineCall extends AbstractDatabaseCall {

    private List<InvoicedOrderLine> failedInvoicedOrderLines = new ArrayList<InvoicedOrderLine>();
    private final TransactionTemplate transactionTemplate;
    private final SimpleJdbcCall invoiceCreatedAx;

    protected InsertInvoicedOrderLineCall(SimpleJdbcTemplate jdbcTemplate, TransactionTemplate transactionTemplate, SimpleJdbcCall invoiceCreatedAx) {
        super(jdbcTemplate);
        this.transactionTemplate = transactionTemplate;
        this.invoiceCreatedAx = invoiceCreatedAx;
    }

    public void insert(List<InvoicedOrderLine> invoicedOrderLines) throws BillingServiceException {
        TransactionCallback<Integer> insertInvoicedOrderLines = new InsertInvoicedOrderLines(invoicedOrderLines, invoiceCreatedAx);
        Integer returnValue;

            try {
                returnValue = transactionTemplate.execute(insertInvoicedOrderLines);
            } catch (TransactionException es) {
                //this could happen, for instance, if the db is unreachable. Therefore throw an integration disturbance
                throw BillingServiceException.createIntegrationDisturbance(es.getMessage());

            }


            if (returnValue == DB_FUNCTION_ERROR_CODE) {
                throw BillingServiceException.createBugDisturbance("BUG_DISTURBANCE : Error when inserting invoiced order lines: " + ((InsertInvoicedOrderLines) insertInvoicedOrderLines).getFailedOrderLine());
            }
        }

        /**
         * This class performs the transaction for insertion of order-lines. If one fails the transaction is rolled back and a bug disturbance is initiated.
         * @see TransactionCallback
         */
        static class InsertInvoicedOrderLines implements TransactionCallback<Integer> {
            private final List<InvoicedOrderLine> orderLines;
            private final SimpleJdbcCall invoiceCreatedAx;
            private InvoicedOrderLine failedOrderLine;

            public InsertInvoicedOrderLines(List<InvoicedOrderLine> orderLines, SimpleJdbcCall invoiceCreatedAx) {
                this.orderLines = orderLines;
                this.invoiceCreatedAx = invoiceCreatedAx;
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
             * @return a result status for the insertInvoicedOrderLinesAx stored function
             * @see TransactionTemplate#execute
             */

            @Override
            public Integer doInTransaction(TransactionStatus transactionStatus) {
                try {
                    int returnValue = doInsert();

                    if (returnValue == DB_FUNCTION_ERROR_CODE) {
                        transactionStatus.setRollbackOnly();
                    }

                    return returnValue;
                } catch (Exception ex) {
                    // Rollback transaction if any exception occurs
                    transactionStatus.setRollbackOnly();

                    if (ex instanceof RuntimeException) {
                        // Rethrow the exception
                        throw (RuntimeException) ex;
                    }
                    throw new RuntimeException(ex);
                }
            }

            private int doInsert() throws BillingServiceException {
                int result = 0;

                for (InvoicedOrderLine invoicedOrderLine : orderLines) {
                    try {
                        result = invoiceCreatedAx.executeFunction(BigDecimal.class,
                                Long.parseLong(invoicedOrderLine.getOrderLine().getOrderLineId()), invoicedOrderLine.getInvoiceId(),
                                invoicedOrderLine.getMarket().getOrganizationId(), invoicedOrderLine.getCurrencyCode().getCurrencyCode(),
                                invoicedOrderLine.getOrderLine().getSystemAgreementId().trim(), invoicedOrderLine.getInvoiceRevenueType()).intValue();
                    } catch (NumberFormatException e) {
                        //If a number format exception occurs a bug is present and a bugdisturbance should be thrown
                        throw BillingServiceException.createBugDisturbance(String.format("Number format exception for order line id : %s", invoicedOrderLine.getOrderLine().getOrderLineId()));
                    }

                    if (result == -1){
                        failedOrderLine = invoicedOrderLine;
                        break;
                    }

                }
                return result;
            }

            public InvoicedOrderLine getFailedOrderLine() {
                return failedOrderLine;
            }
        }
        public List<InvoicedOrderLine> getFailedInvoicedOrderLines() {
            return failedInvoicedOrderLines;
        }
    }
