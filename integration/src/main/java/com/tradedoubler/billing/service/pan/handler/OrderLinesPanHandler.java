package com.tradedoubler.billing.service.pan.handler;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.fetch.FlowName;
import com.tradedoubler.billing.platform.logging.LogError;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ParameterUtil;
import com.tradedoubler.billing.service.pan.call.*;
import com.tradedoubler.billing.transform.ftp.InvoiceConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Contains convenience operations to transform, log and process order lines from and to the Pan database.
 *
 * @author bjoek
 * @since 2012-09-26
 */
@Component
public class OrderLinesPanHandler {
    private final static Logger log = LoggerFactory.getLogger(OrderLinesPanHandler.class);

    @Value("${PAN_MAX_NO_ORDER_LINES}")
    private int maxNumberOfOrderLines;

    @Autowired
    private DatabaseCallFactory databaseCallFactory;

    @PostConstruct
    private void setup() {
        log.debug("Check all parameters that are populated from properties");
        ParameterUtil.checkParameter(maxNumberOfOrderLines);
    }

    /**
     * Inserts invoiced order lines to Pan. If insertion of one or more a more order lines has failed a BillingServiceException
     * for an integration disturbance is thrown
     *
     * @param invoicedOrderLines the order lines to insert
     * @throws BillingServiceException
     */
    public void insertInvoicedOrderLines(List<InvoicedOrderLine> invoicedOrderLines) throws BillingServiceException {
        InsertInvoicedOrderLineCall call = databaseCallFactory.createCall(InsertInvoicedOrderLineCall.class);

        log.debug("Inserting order lines from Pan");

        call.insert(invoicedOrderLines);
    }


    /**
     *  Changes invoice status in Pan. If this method should be invoked is determined right after the Mule Component.
     *
     */
    public void setInvoiceStatusChanged(String invoiceId, Event event) throws BillingServiceException {
        InvoiceConverter invoiceConverter = new InvoiceConverter();
        int invoiceStatus = invoiceConverter.convertEventFromDomainToPan(event);
        InvoiceStatusChangedCall call = databaseCallFactory.createCall(InvoiceStatusChangedCall.class);

        log.debug("Change Status in Pan");

        call.updateState(invoiceId, invoiceStatus);
    }


    /**
     * Fetch a batch of order lines (to be invoiced) from the Pan database.
     *
     * @return batchId and order lines
     * @throws BillingServiceException
     */
    public OrderLinesCreated fetchOrderLinesCreated() throws BillingServiceException {
        ReadOrderLinesCall call = databaseCallFactory.createCall(ReadOrderLinesCall.class);

        log.debug("Reading order lines from Pan");

        call.read();

        List<OrderLine> orderLines = call.getOrderLines();
        Guid batchId = call.getBatchId();

        if (orderLines.isEmpty()) {
            log.info(String.format("Found batchId %s from Pan database. No order lines will be inserted into Ax",
                    batchId == null ? "<none>" : batchId.getGuidForOracleDb()));
        } else {
            log.info(String.format("Found batchId %s and %d order lines from Pan database. They will be inserted into Ax",
                    batchId.getGuidForOracleDb(), orderLines.size()));
        }

        MetaData metaData = new MetaData(FlowName.CreateOrderLinesPan.name(), batchId,
                new Timestamp(), call.getVersion(), call.getSourceSystemId());

        return new OrderLinesCreated(metaData, orderLines, batchId);
    }

    /**
     * Confirm that the order lines have been inserted in Ax
     *
     * @param batchId          identifier for the group of order lines that where fetched before
     * @param failedOrderLines contains order lines have failed to be inserted in Ax
     * @throws BillingServiceException
     */
    public void confirmOrderLines(Guid batchId, List<OrderLineFailed> failedOrderLines) throws BillingServiceException {
        ConfirmOrderLinesCall call = databaseCallFactory.createCall(ConfirmOrderLinesCall.class);

        log.debug(String.format("Confirming order lines in Pan, batchId : %s, nr of failed order lines: %d",
                batchId, failedOrderLines.size()));

        call.confirm(batchId, failedOrderLines);
    }

    /**
     * Confirms that the order line forecasts have been sent to Crm.
     *
     * @param batchId identifier for the group of order lines that where fetched before
     * @throws BillingServiceException
     */
    public void confirmForecastOrderLines(Guid batchId) throws BillingServiceException {
        ConfirmPrepaymentForecastOrderLinesCall call = databaseCallFactory.createCall(ConfirmPrepaymentForecastOrderLinesCall.class);

        log.debug(String.format("Confirming forecast order lines in Pan, batchId : %s", batchId));

        call.confirm(batchId);
    }

    /**
     * Extracts the order lines that did not become inserted when sent to Ax
     *
     * @param orderLines A batch of order lines that where inserted in Ax
     * @return All order lines that failed to be inserted in Ax
     * @throws BillingServiceException
     */
    public List<OrderLineFailed> filterFailedOrderLines(List<OrderLine> orderLines) throws BillingServiceException {
        List<OrderLineFailed> failedOrderLines = new ArrayList<OrderLineFailed>();
        for (OrderLine orderLine : orderLines) {
            switch (orderLine.getStatus()) {
                case NOT_PROCESSED:
                    throw BillingServiceException.createBugDisturbance("All order lines must be processed to confirm order lines, OrderLineId: "
                            + orderLine.getOrderLineId());
                case SENT_TO_AX_FAILED:
                    failedOrderLines.add(new OrderLineFailed(orderLine.getOrderLineId(),
                            orderLine.getStatus() + " - " + orderLine.getErrorMessage()));
                    break;
                case VALIDATION_FAILED:
                    failedOrderLines.add(new OrderLineFailed(orderLine.getOrderLineId(),
                            orderLine.getStatus() + " - " + orderLine.getErrorMessage()));
                    break;
                case SENT_TO_AX_SUCCEEDED:
                    // Do nothing, everything is ok
                    break;
                default:
                    throw new IllegalStateException("Cannot handle status " + orderLine.getStatus());
            }
        }
        return failedOrderLines;
    }

    /** Make sure that the size of the batch of order lines didn't exceed a maximum value */
    public void checkMaxNumberOfOrderLines(List<OrderLine> orderLines) throws BillingServiceException {
        if (orderLines.size() > maxNumberOfOrderLines) {
            throw BillingServiceException.createBugDisturbance(String.format("The number of order lines (%d) exceeded maximum allowed (%d)",
                    orderLines.size(), maxNumberOfOrderLines));
        }
    }

    /**
     * Fetch a batch of order lines (to be sent as forecasts) from the Pan database.
     *
     * @return batchId and order lines
     * @throws BillingServiceException
     */
    public PrepaymentForecastUpdated fetchPrepaymentForecastMessage() throws BillingServiceException {
        ReadPrepaymentForecastOrderLinesCall call = databaseCallFactory.createCall(ReadPrepaymentForecastOrderLinesCall.class);

        log.debug("Reading prepayment order lines from Pan");

        call.read();

        List<PrepaymentOrderLine> orderLines = call.getOrderLines();

        log.debug("Found " + orderLines.size() +
                " prepayment order lines from Pan");

        Guid batchId = call.getBatchId();
        MetaData metaData = new MetaData(FlowName.UpdatePrepaymentForecastPan.name(), batchId,
                new Timestamp(), call.getVersion(), call.getSourceSystemId());

        return new PrepaymentForecastUpdated(metaData, batchId, orderLines);

    }

    /** Check if Pan allows Ax to start the invoicing job */
    public ReadyToInvoice fetchReadyToInvoice() throws BillingServiceException {
        ReadReadyToInvoiceCall call = databaseCallFactory.createCall(ReadReadyToInvoiceCall.class);

        log.debug("Checking ready to invoice from Pan");

        call.read();

        if (!call.isReadyToInvoice()) {
            log.debug("ReadyToInvoice from Pan: No");

            return ReadyToInvoice.createNotReadyToInvoice();
        }

        MetaData metaData = new MetaData(FlowName.StartAxInvoicingPan.name(), new Guid(UUID.randomUUID().toString()),
                new Timestamp(), call.getVersion(), call.getSourceSystemId());

        log.debug("ReadyToInvoice from Pan: Yes!");

        return ReadyToInvoice.createReadyToInvoice(metaData);
    }

    /** Confirm in Pan that the invoicing job has been started in Ax */
    public void confirmInvoicingStarted() throws BillingServiceException {
        ConfirmReadyToInvoiceCall call = databaseCallFactory.createCall(ConfirmReadyToInvoiceCall.class);

        log.debug("Confirming ready to invoice to Pan");

        call.confirm();
    }


    /** Set the Debit/Credit flag and quantity for each order line */
    public List<OrderLine> setDebitAndCredit(List<OrderLine> orderLines) {
        for (OrderLine orderLine : orderLines) {
            validateTotalAndCost(orderLine);

            if (!orderLine.getStatus().isFailed()) {
                if (orderLine.getTotal().isPositive() || orderLine.getCost().isPositive()) {
                    orderLine.setDebitOrCredit(DebitOrCredit.DEBIT);
                    orderLine.setQuantity(1);
                }
                if (orderLine.getTotal().isNegative() || orderLine.getCost().isNegative()) {
                    orderLine.setDebitOrCredit(DebitOrCredit.CREDIT);
                    orderLine.setQuantity(-1);
                }
            }

        }
        return orderLines;
    }

    private void validateTotalAndCost(OrderLine orderLine) {
        String errorMessage = null;

        // Handle error states
        if (orderLine.getCost().isZero() && orderLine.getTotal().isZero()) {
            errorMessage = "An order line cannot have both cost and total zero";
        }
        if (orderLine.getCost().isPositive() && orderLine.getTotal().isNegative()) {
            errorMessage = "An order line cannot have positive cost and negative total.";
        }
        if (orderLine.getCost().isNegative() && orderLine.getTotal().isPositive()) {
            errorMessage = "An order line cannot have negative cost and positive total.";
        }

        if (errorMessage != null) {
            orderLine.setValidationFailed(errorMessage);
            log.error(LogError.OPERATIONAL_DISTURBANCE.name() + "-" + errorMessage);
        }
    }

}
