package com.tradedoubler.billing.service.ax.webservice.domainhandler;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.platform.logging.LogError;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.webservice.call.*;
import com.tradedoubler.billing.transform.webservice.OrderLineToAxSalesOrderBasisLineContractTransformer;
import org.datacontract.schemas._2004._07.dynamics_ax.ArrayOfMDSITGSalesOrderBasisLineContract;
import org.slf4j.*;
import org.springframework.stereotype.Component;

import java.util.*;


/**
 * This class contains convenient methods that translates the Order lines and communicates them to the AX-web service.
 * Also handles starting of the invoicing process.
 * Date: 2012-09-04
 */
@Component
public class OrderLineHandler extends AbstractHandler {

    private final static Logger log = LoggerFactory.getLogger(OrderLineHandler.class);

    /**
     * Inserts order lines in Ax. Insert and update use the webservice method (see IDD)
     *
     * @param orderLines - list of domain objects
     * @param marketId   market
     * @return the call instance that contains the result
     * @throws BillingServiceException
     */
    public InsertAndUpdateOrderLinesCall insertOrderLines(List<OrderLine> orderLines, Market marketId) throws BillingServiceException {
        String dataAreaId = converter.convert(marketId);

        ArrayOfMDSITGSalesOrderBasisLineContract axOrderBasisLineArray = new OrderLineToAxSalesOrderBasisLineContractTransformer(orderLines).transform();

        //Create web service call
        InsertAndUpdateOrderLinesCall insertCall = webServiceCallFactory.createCall(InsertAndUpdateOrderLinesCall.class);
        log.debug("Inserting order lines: [" + getIds(orderLines) + "]");

        //Execute web service call
        insertCall.execute(axOrderBasisLineArray, dataAreaId);

        // Handle error codes by throwing correct exception
        callResultHandler.handleInsertResult(insertCall);

        return insertCall;
    }

    private String getIds(List<OrderLine> orderLines) {
        StringBuilder ids = new StringBuilder();
        for (OrderLine orderLine : orderLines) {
            if (ids.length() != 0) {
                ids.append(",");
            }
            ids.append(orderLine.getOrderLineId());
        }
        return ids.toString();
    }

    /**
     * Starts the order line processing in Ax. Ax will place a 'start invoicing'-job in a queue, so it doesn't mean that
     * the invoicing process in Ax is finished or even started.
     *
     * @param marketId market is needed for the actual web service call, it has no other significance
     */
    public void startInvoicing(Market marketId) throws BillingServiceException {
        String dataAreaId = converter.convert(marketId);

        //Create web service call
        StartOrderLineProcessingCall orderLineProcessingCall = webServiceCallFactory.createCall(StartOrderLineProcessingCall.class);
        log.debug("Starting invoicing (OrderLineProcessing) in Ax, default market is: " + dataAreaId);

        //Execute web service call
        orderLineProcessingCall.execute(dataAreaId);

        // Handle error codes by throwing correct exception
        callResultHandler.handleUpdateResult(orderLineProcessingCall);

        boolean started = orderLineProcessingCall.isOrderLineProcessingStarted();

        // Make sure that the invoicing process has started
        if (!started) {
            throw BillingServiceException.createIntegrationDisturbance("Could not start invoicing in Ax");
        }
    }

    /** Marks each order line if the insertion in Ax was successful or not */
    public void setInsertionStatusOnOrderLines(Guid batchId, List<OrderLine> orderLines, InsertAndUpdateOrderLinesCall insertAndUpdateOrderLinesCall) throws BillingServiceException {
        Map<String, OrderLine> orderLinesMappedById = new HashMap<String, OrderLine>();
        for (OrderLine orderLine : orderLines) {
            orderLinesMappedById.put(orderLine.getOrderLineId(), orderLine);
            orderLine.setSentToAxSucceeded();
        }

        List<OrderLineResponseResult> listOfFailedOrderLines = insertAndUpdateOrderLinesCall.getListOfFailedOrderLines();
        for (OrderLineResponseResult failedOrderLine : listOfFailedOrderLines) {
            String orderLineId = failedOrderLine.getOrderLineId();

            OrderLine orderLine = orderLinesMappedById.get(orderLineId);
            if (orderLine == null) {
                throw BillingServiceException.createBugDisturbance(
                        String.format("Could not find order line from insert failure list, batchId: %s, orderLineId: %s, failure message: %s, failure state: %s",
                                batchId, orderLineId, failedOrderLine.getErrorMessage(), failedOrderLine.getState()));
            }
            orderLine.setSentToAxFailed(failedOrderLine.getState() + " " + failedOrderLine.getErrorMessage());

            String message = String.format("The order line was not accepted by Ax, batchId: %s, orderLineId: %s, failure message: %s, failure state: %s",
                    batchId, orderLineId, failedOrderLine.getErrorMessage(), failedOrderLine.getState());
            log.error(LogError.OPERATIONAL_DISTURBANCE.name() + "-" + message);
        }
    }

    /** Return all order lines that are successful or unprocessed */
    public List<OrderLine> filterNotFailed(List<OrderLine> orderLines) {
        List<OrderLine> returnValue = new ArrayList<OrderLine>();
        for (OrderLine orderLine : orderLines) {
            if (!orderLine.getStatus().isFailed()) {
                returnValue.add(orderLine);
            }
        }
        return returnValue;
    }
}

