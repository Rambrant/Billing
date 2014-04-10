package com.tradedoubler.billing.service.ax.webservice.call;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.ax.webservice.domainhandler.InvoicingRuleHandler;
import com.tradedoubler.billing.util.AxDbConstantsUtil;
import com.tradedoubler.testutil.MultiTestUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import static com.tradedoubler.billing.service.ax.webservice.AxRequestResult.ALL_IS_WELL;
import static org.junit.Assert.assertEquals;

/**
 * @author bjoek
 * @since 2012-06-19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class ReadSalesInvoiceRuleRequestMultiThreadTest {
    public static final String EXISTING_INVOICE_RULE_ID = AxDbConstantsUtil.EXISTING_INVOICE_RULE_ID;
    private static final String EXISTING_ACCOUNT_NUM = AxDbConstantsUtil.EXISTING_CLIENT_ACCOUNT_NUM;

    @Autowired
    private InvoicingRuleHandler invoicingRuleHandler;

    @Test
    public void singleReadShouldWork() throws Exception {
        InvoicingRule invoicingRule = createInvoicingRule(EXISTING_INVOICE_RULE_ID);
        FindInvoicingRuleCall readInvoicingRuleCall = invoicingRuleHandler.findInvoicingRuleByPk(invoicingRule.getInvoicingRuleId(), invoicingRule.getMarketId());

        assertEquals(readInvoicingRuleCall.getAxRequestResult(), ALL_IS_WELL);
    }

    @Test
    public void singleThreadManyExecutionsReadShouldWork() throws Exception {
        final InvoicingRule invoicingRule = createInvoicingRule(EXISTING_INVOICE_RULE_ID);

        MultiTestUtil.create().threads(1).executions(3).test(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                FindInvoicingRuleCall readInvoicingRuleCall = invoicingRuleHandler.findInvoicingRuleByPk(invoicingRule.getInvoicingRuleId(), invoicingRule.getMarketId());
                assertEquals(readInvoicingRuleCall.getAxRequestResult(), ALL_IS_WELL);
                return null;
            }
        });
    }

    @Test
    public void multipleThreadOneExecutionReadShouldWork() throws Exception {
        final InvoicingRule invoicingRule = createInvoicingRule(EXISTING_INVOICE_RULE_ID);

        MultiTestUtil.create().threads(3).executions(1).test(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                FindInvoicingRuleCall readInvoicingRuleCall = invoicingRuleHandler.findInvoicingRuleByPk(invoicingRule.getInvoicingRuleId(), invoicingRule.getMarketId());
                assertEquals(readInvoicingRuleCall.getAxRequestResult(), ALL_IS_WELL);
                return null;
            }
        });
    }

    @Test
    public void multipleThreadMultipleExecutionsReadShouldWork() throws Exception {
        final InvoicingRule invoicingRule = createInvoicingRule(EXISTING_INVOICE_RULE_ID);

        MultiTestUtil.create().threads(2).executions(2).test(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                FindInvoicingRuleCall readInvoicingRuleCall = invoicingRuleHandler.findInvoicingRuleByPk(invoicingRule.getInvoicingRuleId(), invoicingRule.getMarketId());
                assertEquals(readInvoicingRuleCall.getAxRequestResult(), ALL_IS_WELL);
                return null;
            }
        });
    }

    private InvoicingRule createInvoicingRule(String id) {
        return new InvoicingRule(EXISTING_ACCOUNT_NUM,
                51, id, "Test", "test", "Issuer Reference", "John Doe", "SEK", 1, 30, 1, true,
                1, 1, false, new ArrayList<InvoiceRecipient>(), new ArrayList<PurchaseOrder>(),
                new ArrayList<InvoicingRuleMessageRule>(), new ArrayList<String>());
    }
}
