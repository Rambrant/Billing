package com.tradedoubler.billing.service.pan.call;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.pan.handler.OrderLinesPanHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;
import static org.junit.Assert.assertEquals;

/**
 * User: erigu
 * Date: 2012-10-31
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class InsertInvoicedOrderLinesCallTest {


    @Autowired
    private OrderLinesPanHandler orderLinesPanHandler;

    @Autowired
    private DataSource dataSource;

    @Test
    public void insertShouldWork() throws BillingServiceException {
        List<InvoicedOrderLine> orderLines = createMockedInvoicedOrderLines(false);
        try {
            orderLinesPanHandler.insertInvoicedOrderLines(orderLines);
        } catch (BillingServiceException e) {
            assertTrue(false);
        }
    }
    @Test
    public void toLongIdIdShouldRollbackFailedOrderLines() {
        SimpleJdbcTemplate template = new SimpleJdbcTemplate(dataSource);
        int countFailedBefore = template.queryForInt("SELECT COUNT(*) FROM admin.order_line_ax_errors");
        List<InvoicedOrderLine> orderLines = createMockedInvoicedOrderLines(true);

        List<OrderLineFailed> failedOrderLines = new ArrayList<OrderLineFailed>();
        failedOrderLines.add(new OrderLineFailed("100", "Test av funktion"));

        try {
            orderLinesPanHandler.insertInvoicedOrderLines(orderLines);
            fail();
        } catch (Exception usex) {
            System.out.println("InsertInvoicedOrderLinesCallTest.wrongBatchIdShouldRollbackFailedOrderLines");


            // Check that failed order line has not been inserted (rollback works)
            int countFailedAfter = template.queryForInt("SELECT COUNT(*) FROM admin.order_line_ax_errors");
            assertEquals(countFailedBefore, countFailedAfter);
        }

    }



    private List<InvoicedOrderLine> createMockedInvoicedOrderLines(boolean fail) {

        List<InvoicedOrderLine> listOfInvoicedOrderLines = new ArrayList<InvoicedOrderLine>();
        String[] salesPart = {"305", "340", "120", "114", "112", "113", "270"};
        BigDecimal[] total = {BigDecimal.valueOf(100), BigDecimal.valueOf(200), BigDecimal.valueOf(300),BigDecimal.valueOf(400), BigDecimal.valueOf(500), BigDecimal.valueOf(700), BigDecimal.valueOf(800)};
        BigDecimal[] cost = {BigDecimal.valueOf(10), BigDecimal.valueOf(20), BigDecimal.valueOf(30),BigDecimal.valueOf(40), BigDecimal.valueOf(50), BigDecimal.valueOf(60),BigDecimal.valueOf(70)};
        String idAdd = (fail)? "tttttttttttttttttttttttttttttttttttttttttttt" : "";
        for (int i = 0; i < salesPart.length; i++) {

            String dateString = "2013-05-24T15:30:01.999+02:00";
            OrderLine orderLine = new OrderLine("1-702", (5000000 + i) + idAdd, true, salesPart[i], "description" + i,
                    total[i], cost[i], "1301", new Timestamp(dateString),
                    "11111", "" + i);
            orderLine.setDebitOrCredit(DebitOrCredit.DEBIT);
            orderLine.setQuantity(1);

            InvoicedOrderLine invoicedOrderLine = new InvoicedOrderLine("SE-12-02135", (5000000 + 1) + "", new Market(51),
                    new Currency("SEK"), orderLine, "td", InvoiceOrderLineStatus.NONE);
            listOfInvoicedOrderLines.add(invoicedOrderLine);
        }
        return listOfInvoicedOrderLines;
    }
}
