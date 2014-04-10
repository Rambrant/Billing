package com.tradedoubler.billing.transform.json;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.platform.flowcontroller.ServiceResult;
import com.tradedoubler.billing.service.crm.JsonMessage;
import com.tradedoubler.testutil.*;
import org.junit.*;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author bjoek
 * @since 2012-07-04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext-test.xml",
        "/spring/springBeansContext.xml"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class InvoicingRuleUpdatedFromJsonTransformerTest {
    @Autowired
    private ApplicationContext applicationContext;

    private InvoicingRuleUpdatedFromJsonTransformer transformer;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Before
    public void setUp() throws Exception {
        ApplicationContextUtil contextUtil = new ApplicationContextUtil(applicationContext);
        transformer = contextUtil.registerAnnotatedBean(InvoicingRuleUpdatedFromJsonTransformer.class);
    }

    @Test
    public void testEmptyJson() throws Exception {
        JsonMessage jsonMessage = new JsonMessage("");
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setRawData(jsonMessage);

        ServiceResult result = (ServiceResult) transformer.doTransform(serviceResult, "UTF-8");
        assertNull(result.getIntegrationMessage());
        assertEquals(true, result.isBugDisturbance());
        assertThat(result.getErrorMessage(), is("Was not able to transform class class com.tradedoubler.billing.domain.InvoicingRuleUpdated"));
    }

    @Test
    public void testExampleJson() throws Exception {
        String json = FileUtil.readFileFromClasspath("json-examples/invoicing-rule-updated-example.json");
        JsonMessage jsonMessage = new JsonMessage(json);
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setRawData(jsonMessage);

        ServiceResult result = (ServiceResult) transformer.doTransform(serviceResult, "UTF-8");
        InvoicingRuleUpdated invoicingRuleCreated = (InvoicingRuleUpdated) result.getIntegrationMessage().getDomainObject();

        MetaData metaData = invoicingRuleCreated.getMetaData();

        InvoicingRule invoicingRule = invoicingRuleCreated.getInvoicingRule();

        List<InvoiceRecipient> invoiceRecipients = invoicingRule.getInvoiceRecipients();
        collector.checkThat(invoiceRecipients.size(), is(3));

        InvoiceRecipient invoiceRecipient = invoiceRecipients.get(0);

        Address registeredAddressInvoiceRecipient = invoiceRecipient.getRegisteredAddress();

        List<SplittingRule> splittingRules = invoiceRecipients.get(2).getSplittingRules();
        collector.checkThat(splittingRules.size(), is(3));
        SplittingRule splittingRule = splittingRules.get(0);

        List<PurchaseOrder> purchaseOrders = invoicingRule.getPurchaseOrders();
        collector.checkThat(purchaseOrders.size(), is(3));
        PurchaseOrder purchaseOrder = purchaseOrders.get(0);

        List<InvoicingRuleMessageRule> invoiceMessageRules = invoicingRule.getInvoiceMessageRules();
        collector.checkThat(invoiceMessageRules.size(), is(1));
        InvoicingRuleMessageRule invoiceMessageRule = invoiceMessageRules.get(0);


        collector.checkThat(metaData.getMessageType(), is("UpdateInvoicingRule"));
        collector.checkThat(metaData.getMessageId().getGuid(), is("28b62635-15a0-b15e-c5f4-5442b66d1059"));
        collector.checkThat(metaData.getCreationTime().getTimestamp(), is("2012-07-05T13:21:00.000+02:00"));
        collector.checkThat(metaData.getVersion(), is("1.0"));
        collector.checkThat(metaData.getSourceSystem(), is("CRM"));

        collector.checkThat(invoicingRule.getClientId(), is("TELIA"));
        collector.checkThat(invoicingRule.getMarketId().getOrganizationId(), is(51));
        collector.checkThat(invoicingRule.getInvoicingRuleId().getGuid(), is("3f2504e0-4f89-11d3-9a0c-0305e82c3405"));
        collector.checkThat(invoicingRule.getInvoicingRuleName(), is("Volvo - do not edit"));
        collector.checkThat(invoicingRule.getDescription(), is("Used in unit tests - do not edit"));
        collector.checkThat(invoicingRule.getIssuerReference(), is("Maria Lind"));
        collector.checkThat(invoicingRule.getClientReference(), is("Lasse Volvosson"));
        collector.checkThat(invoicingRule.getCurrencyCode().getCurrencyCode(), is("EUR"));
        collector.checkThat(invoicingRule.getDistributionMode().getValue(), is(1));
        collector.checkThat(invoicingRule.getTermsOfPayment().getDays(), is(30));
        collector.checkThat(invoicingRule.getPostingProfile().getValue(), is(1));
        collector.checkThat(invoicingRule.isDisplayTradeDoublerCommission(), is(true));
        collector.checkThat(invoicingRule.getRevenueType().getValue(), is(1));
        collector.checkThat(invoicingRule.getPaymentMethod().getValue(), is(2));
        collector.checkThat(invoicingRule.isDeviatingExchangeRate(), is(false));

        collector.checkThat(invoiceRecipient.getInvoiceRecipientId().getGuid(), is("703b123f-6329-4d79-bfaa-60762a5f6cf4"));
        collector.checkThat(invoiceRecipient.getInvoicingRuleId().getGuid(), is("3f2504e0-4f89-11d3-9a0c-0305e82c3405"));
        collector.checkThat(invoiceRecipient.getAttentionRow1(), is("Attention of default recipient!"));
        collector.checkThat(invoiceRecipient.getAttentionRow2(), nullValue());
        collector.checkThat(invoiceRecipient.getEmailAddress(), nullValue());
        collector.checkThat(invoiceRecipient.isDefaultRecipient(), is(true));

        collector.checkThat(registeredAddressInvoiceRecipient.getLine1(), is("AVD. 50090 HB3S"));
        collector.checkThat(registeredAddressInvoiceRecipient.getLine2(), nullValue());
        collector.checkThat(registeredAddressInvoiceRecipient.getCity(), is("Göteborg"));
        collector.checkThat(registeredAddressInvoiceRecipient.getCounty(), nullValue());
        collector.checkThat(registeredAddressInvoiceRecipient.getPostalCode(), is("40531"));
        collector.checkThat(registeredAddressInvoiceRecipient.getCountryCode().getValue(), is("SE"));
        collector.checkThat(registeredAddressInvoiceRecipient.getAddressType().getValue(), is(1));

        collector.checkThat(splittingRule.getSplittingRuleId().getGuid(), is("8f756919-c9ed-e111-8b5b-005056b45da6"));
        collector.checkThat(splittingRule.getInvoiceRecipientId().getGuid(), is("3ac9520d-c9ed-e111-8b5b-005056b45da6"));
        collector.checkThat(splittingRule.getSplitter(), is("kjhh567855"));

        collector.checkThat(purchaseOrder.getInvoicingRuleId().getGuid(), is("3f2504e0-4f89-11d3-9a0c-0305e82c3405"));
        collector.checkThat(purchaseOrder.getPoNumber(), is("234 - do not edit"));
        collector.checkThat(purchaseOrder.getPurchaseOrderId().getGuid(), is("00000000-0000-0000-4000-100000000001"));
        collector.checkThat(purchaseOrder.getValidFrom().getTimestamp(), is("2012-08-15T00:00:00.000+02:00"));
        collector.checkThat(purchaseOrder.getValidTo().getTimestamp(), is("2012-08-17T00:00:00.000+02:00"));

        collector.checkThat(invoiceMessageRule.getInvoiceMessageRuleId().getGuid(), is("00000000-0000-0000-3000-100000000001"));
        collector.checkThat(invoiceMessageRule.getInvoicingRuleId().getGuid(), is("3f2504e0-4f89-11d3-9a0c-0305e82c3405"));
        collector.checkThat(invoiceMessageRule.getMessageText(), is("This is a text to be printed on all invoices for this invoicing rule"));
        collector.checkThat(invoiceMessageRule.getValidFrom().getTimestamp(), is("2012-08-13T00:00:00.000+02:00"));
        collector.checkThat(invoiceMessageRule.getValidTo().getTimestamp(), is("2012-08-30T00:00:00.000+02:00"));
    }
}

