package com.tradedoubler.billing.service.ax.webservice.call;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.webservice.AxRequestResult;
import com.tradedoubler.billing.service.ax.webservice.domainhandler.*;
import com.tradedoubler.billing.util.AxDbConstantsUtil;
import org.junit.*;
import org.junit.rules.ErrorCollector;
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
 * @author bjoek
 * @since 2012-07-02
 */
@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class InsertEverythingAtOnceCallTest {

    @Autowired
    private AgreementHandler agreementHandler;

    @Autowired
    private ClientHandler clientHandler;

    @Autowired
    private InvoicingRuleHandler invoicingRuleHandler;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Autowired
    private OrderLineHandler orderLineHandler;

    @Test
    @Ignore("Just use it when you need it")
    public void createEveryThingNewShouldWork() throws BillingServiceException {
        Market market = new Market(51);
        String clientId = AxDbConstantsUtil.generateClientId();
        String invoiceRuleId = AxDbConstantsUtil.generateInvoiceRuleId();
        String agreementId = AxDbConstantsUtil.generateAgreementId();

        createClient(market, clientId);
        createInvoicingRule(clientId, invoiceRuleId);
        createAgreement(clientId, invoiceRuleId, agreementId);
        createOrderLines(agreementId, market);

        startInvoiceProcess(market);

        System.out.printf("Inserted Client: %s, invoicing rule: %s , agreement: %s%n", clientId, invoiceRuleId, agreementId);
    }

    private void createClient(Market market, String clientId) throws BillingServiceException {
        Client client = WebServiceCallTestUtil.createClient(clientId, 51);
        clientHandler.insertClient(client, market);
    }

    private void createInvoicingRule(String clientId, String invoiceRuleId) throws BillingServiceException {
        InvoicingRule invoiceRule = WebServiceCallTestUtil.createInvoicingRule(invoiceRuleId, clientId, 51);
        invoicingRuleHandler.insertInvoicingRule(invoiceRule);
    }

    private void createAgreement(String clientId, String invoiceRuleId, String agreementId) throws BillingServiceException {
        Agreement agreement = WebServiceCallTestUtil.createAgreement(agreementId, clientId, invoiceRuleId, 51);
        agreementHandler.insertAgreement(agreement);
    }

    private void createOrderLines(String agreementId, Market market) throws BillingServiceException {
        List<OrderLine> orderLines = new ArrayList<OrderLine>();

        int testNumber = 100003;
        OrderLine orderLine = new OrderLine(agreementId, AxDbConstantsUtil.generateOrderLineId(), true, "1",
                testNumber + "testDebitAndCredit", new BigDecimal("33000"),
                new BigDecimal("33000"), "1301", null, null, "262627");
        orderLine.setDebitOrCredit(DebitOrCredit.DEBIT);
        orderLine.setQuantity(1);
        orderLines.add(orderLine);
//        orderLines.add(new OrderLine(agreementId, AxDbConstantsUtil.generateOrderLineId(), true, "1",
//                testNumber + "testDebitAndCredit", 1, new BigDecimal("-3300"),
//                new BigDecimal("-3300"), "1211", null, DebitOrCredit.DEBIT, null, "262627"));
//        orderLines.add(new OrderLine(agreementId, AxDbConstantsUtil.generateOrderLineId(), true, "1",
//                testNumber + "testDebitAndCredit", 1, new BigDecimal("330"),
//                new BigDecimal("330"), "1211", null, DebitOrCredit.CREDIT, null, "262627"));
//        orderLines.add(new OrderLine(agreementId, AxDbConstantsUtil.generateOrderLineId(), true, "1",
//                testNumber + "testDebitAndCredit", 1, new BigDecimal("-33"),
//                new BigDecimal("-33"), "1211", null, DebitOrCredit.CREDIT, null, "262627"));

        InsertAndUpdateOrderLinesCall insertAndUpdateOrderLinesCall = orderLineHandler.insertOrderLines(orderLines, market);

        AxRequestResult axRequestResult = insertAndUpdateOrderLinesCall.getAxRequestResult();

        List<OrderLineResponseResult> listOfFailedOrders = insertAndUpdateOrderLinesCall.getListOfFailedOrderLines();

        assertThat(axRequestResult, is(ALL_IS_WELL));

        String reason = listOfFailedOrders.size() > 0 ? listOfFailedOrders.get(0).getErrorMessage() : "";
        assertThat(reason, listOfFailedOrders.size(), is(0));

    }

    private void startInvoiceProcess(Market market) throws BillingServiceException {
        orderLineHandler.startInvoicing(market);
    }

}
