package com.tradedoubler.billing.service.ax.webservice.call;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.webservice.AxRequestResult;
import com.tradedoubler.billing.service.ax.webservice.domainhandler.OrderLineHandler;
import com.tradedoubler.billing.util.AxDbConstantsUtil;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.*;

import static com.tradedoubler.billing.service.ax.webservice.AxRequestResult.ALL_IS_WELL;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * User: erigu
 * Date: 2012-09-17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class InsertAndUpdateOrderLinesCallTest {

    @Autowired
    private OrderLineHandler orderLineHandler;

    @Test
    public void insertNewAndRepeatShouldWork() throws Exception {

        List<OrderLine> orderLines = createFakeOrderLines();

        System.out.println("InsertAndUpdateOrderLinesCallTest.insertShouldWork: Start");
        long t1 = System.currentTimeMillis();
        InsertAndUpdateOrderLinesCall insertAndUpdateOrderLinesCall = orderLineHandler.insertOrderLines(orderLines, new Market(51));

        long t2 = System.currentTimeMillis();
        System.out.println("InsertAndUpdateOrderLinesCallTest.insertShouldWork: " + (t2 - t1));
        AxRequestResult axRequestResult = insertAndUpdateOrderLinesCall.getAxRequestResult();

        List<OrderLineResponseResult> listOfFailedOrders = insertAndUpdateOrderLinesCall.getListOfFailedOrderLines();

        assertThat(axRequestResult, is(ALL_IS_WELL));

        String reason = listOfFailedOrders.size() > 0 ? listOfFailedOrders.get(0).getErrorMessage() : "";
        assertThat(reason, listOfFailedOrders.size(), is(0));

        //test to insert them again, this should also work as long as the lines are unprocessed

        long t3 = System.currentTimeMillis();
        InsertAndUpdateOrderLinesCall insertAndUpdateOrderLinesCall2 = orderLineHandler.insertOrderLines(orderLines, new Market(51));

        long t4 = System.currentTimeMillis();
        System.out.println("InsertAndUpdateOrderLinesCallTest.insertShouldWork: " + (t4 - t3));

        AxRequestResult axRequestResult2 = insertAndUpdateOrderLinesCall2.getAxRequestResult();
        List<OrderLineResponseResult> listOfFailedOrders2 = insertAndUpdateOrderLinesCall.getListOfFailedOrderLines();

        assertThat(axRequestResult2, is(ALL_IS_WELL));

        reason = listOfFailedOrders2.size() > 0 ? listOfFailedOrders2.get(0).getErrorMessage() : "";
        assertThat(reason, listOfFailedOrders2.size(), is(0));
    }

    @Test
    public void insertInvoicedShouldNotWork() throws Exception {

        List<OrderLine> orderLines = createExistingMockedOrderLines();

        InsertAndUpdateOrderLinesCall insertAndUpdateOrderLinesCall = orderLineHandler.insertOrderLines(orderLines, new Market(51));
        insertAndUpdateOrderLinesCall.getAxRequestResult();
        List<OrderLineResponseResult> listOfFailedOrders = insertAndUpdateOrderLinesCall.getListOfFailedOrderLines();

        assertThat(listOfFailedOrders.size(), is(orderLines.size()));
        OrderLineResponseResult orderLineResponseResult = listOfFailedOrders.get(0);
        assertThat(orderLineResponseResult.getErrorMessage(), is("Order basis line was not updated due to illegal status change"));
        assertThat(orderLineResponseResult.getState(), is("UpdateFailed"));
    }

    @Test
    public void insertTooLongIdShouldNotWork() throws Exception {

        List<OrderLine> orderLines = createExistingMockedOrderLines();
        orderLines.get(0).setOrderLineId("12345678901");

        InsertAndUpdateOrderLinesCall insertAndUpdateOrderLinesCall = orderLineHandler.insertOrderLines(orderLines, new Market(51));
        insertAndUpdateOrderLinesCall.getAxRequestResult();
        List<OrderLineResponseResult> listOfFailedOrders = insertAndUpdateOrderLinesCall.getListOfFailedOrderLines();

        assertThat(listOfFailedOrders.size(), is(orderLines.size()));

        OrderLineResponseResult orderLineResponseResult = listOfFailedOrders.get(0);
        assertThat(orderLineResponseResult.getErrorMessage(), is("The string is too long for the MDS_SalesOrderBasisLineId field."));
        assertThat(orderLineResponseResult.getState(), is("FieldLength"));

        orderLineResponseResult = listOfFailedOrders.get(1);
        assertThat(orderLineResponseResult.getErrorMessage(), is("Order basis line was not updated due to illegal status change"));
        assertThat(orderLineResponseResult.getState(), is("UpdateFailed"));
    }


    @Test
    @Ignore("Check so that no work starts")
    public void startSalesOrderCreationShouldWork() throws BillingServiceException {
        orderLineHandler.startInvoicing(new Market(51));
    }

    private List<OrderLine> createFakeOrderLines() {
        List<OrderLine> orderLines = new ArrayList<OrderLine>();

        for (int i = 0; i < 2; i++) {
            String id = AxDbConstantsUtil.generateOrderLineId();
            System.out.println("OrderLineId: " + id);
            String dateString = "2012-10-26T21:32:52";//"2013-05-2"+i + "T12:00:00";
            OrderLine orderLine = new OrderLine("0-123456789012", id, true, "12345678901234567890",
                    "123456789012345678901234567890123456789012345678901234567890",
                    BigDecimal.valueOf(1390.43), BigDecimal.valueOf(695.21), "1301", new Timestamp(dateString),
                    "1234567890123", "1234567890");
            orderLine.setDebitOrCredit(DebitOrCredit.DEBIT);
            orderLine.setQuantity(1);

            orderLines.add(orderLine);
        }
        return orderLines;

    }


    private List<OrderLine> createExistingMockedOrderLines() {
        List<OrderLine> orderLines = new ArrayList<OrderLine>();

        String dateString = "2013-05-24T15:30:01.999+02:00";
        for (int i = 0; i < 2; i++) {
            OrderLine orderLine = new OrderLine("0-fa51ee9a469e", AxDbConstantsUtil.EXISTING_ORDER_LINE_ID,
                    true, "110", "description" + i,
                    BigDecimal.valueOf(1390.43), BigDecimal.valueOf(695.21), "1301", new Timestamp(dateString),
                    "11111", "" + i);
            orderLine.setDebitOrCredit(DebitOrCredit.DEBIT);
            orderLine.setQuantity(1);

            orderLines.add(orderLine);
        }
        return orderLines;

    }
}
