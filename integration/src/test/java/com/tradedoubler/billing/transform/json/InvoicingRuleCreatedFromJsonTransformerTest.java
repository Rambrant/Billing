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
import static org.junit.Assert.assertNull;

/**
 * @author bjoek
 * @since 2012-06-25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext-test.xml", "/spring/springBeansContext.xml"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class InvoicingRuleCreatedFromJsonTransformerTest {
    @Autowired
    private ApplicationContext applicationContext;

    private InvoicingRuleCreatedFromJsonTransformer transformer;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Before
    public void setUp() throws Exception {
        ApplicationContextUtil contextUtil = new ApplicationContextUtil(applicationContext);
        transformer = contextUtil.registerAnnotatedBean(InvoicingRuleCreatedFromJsonTransformer.class);
    }

    @Test
    public void testEmptyJson() throws Exception {
        JsonMessage jsonMessage = new JsonMessage("");
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setRawData(jsonMessage);

        ServiceResult result = (ServiceResult) transformer.doTransform(serviceResult, "UTF-8");
        assertNull(result.getIntegrationMessage());
        collector.checkThat(result.isBugDisturbance(), is(true));
        collector.checkThat(result.getErrorMessage(), is("Was not able to transform class class com.tradedoubler.billing.domain.InvoicingRuleCreated"));
    }

    @Test
    public void testExampleJson() throws Exception {
        String json = FileUtil.readFileFromClasspath("json-examples/invoicing-rule-created-example.json");
        JsonMessage jsonMessage = new JsonMessage(json);
        com.tradedoubler.billing.platform.flowcontroller.ServiceResult serviceResult = new com.tradedoubler.billing.platform.flowcontroller.ServiceResult();
        serviceResult.setRawData(jsonMessage);

        ServiceResult transformedServiceResult = (ServiceResult) transformer.doTransform(serviceResult, "UTF-8");
        InvoicingRuleCreated invoicingRuleCreated = (InvoicingRuleCreated) transformedServiceResult.getIntegrationMessage().getDomainObject();

        MetaData metaData = invoicingRuleCreated.getMetaData();

        InvoicingRule invoicingRule = invoicingRuleCreated.getInvoicingRule();

        List<InvoiceRecipient> invoiceRecipients = invoicingRule.getInvoiceRecipients();
        collector.checkThat(invoiceRecipients.size(), is(3));
        InvoiceRecipient invoiceRecipient = invoiceRecipients.get(0);

        Address registeredAddressInvoiceRecipient = invoiceRecipient.getRegisteredAddress();

        List<SplittingRule> splittingRules = invoiceRecipients.get(1).getSplittingRules();
        collector.checkThat(splittingRules.size(), is(1));
        SplittingRule splittingRule = splittingRules.get(0);

        List<PurchaseOrder> purchaseOrders = invoicingRule.getPurchaseOrders();
        collector.checkThat(purchaseOrders.size(), is(4));
        PurchaseOrder purchaseOrder = purchaseOrders.get(0);

        List<InvoicingRuleMessageRule> invoiceMessageRules = invoicingRule.getInvoiceMessageRules();
        collector.checkThat(invoiceMessageRules.size(), is(1));
        InvoicingRuleMessageRule invoiceMessageRule = invoiceMessageRules.get(0);

        Agreement agreement = invoicingRuleCreated.getAgreement();

        Client client = invoicingRuleCreated.getClient();

        List<Bank> bankAccounts = client.getBankAccounts();
        collector.checkThat(bankAccounts.size(), is(1));
        Bank bank = bankAccounts.get(0);

        Address registeredAddressClient = client.getRegisteredAddress();

        List<ClientMessageRule> invoiceMessageRulesClient = client.getInvoiceMessageRules();
        collector.checkThat(invoiceMessageRulesClient.size(), is(1));
        ClientMessageRule invoiceMessageRuleClient = invoiceMessageRulesClient.get(0);

        collector.checkThat(metaData.getMessageType(), is("CreateInvoicingRule"));
        collector.checkThat(metaData.getMessageId().getGuid(), is("5b15c006-1c3f-4a72-867a-0ceff7acf728"));
        collector.checkThat(metaData.getCreationTime().getTimestamp(), is("2012-08-31T14:44:43.290+02:00"));
        collector.checkThat(metaData.getVersion(), is("1.0"));
        collector.checkThat(metaData.getSourceSystem(), is("CRM"));

        collector.checkThat(invoicingRule.getClientId(), is("49135002"));
        collector.checkThat(invoicingRule.getMarketId().getOrganizationId(), is(135899));
        collector.checkThat(invoicingRule.getInvoicingRuleId().getGuid(), is("f3de63df-24e5-e111-8b5b-005056b45da6"));
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

        collector.checkThat(invoiceRecipient.getInvoiceRecipientId().getGuid(), is("27f93000-25e5-e111-8b5b-005056b45da6"));
        collector.checkThat(invoiceRecipient.getInvoicingRuleId().getGuid(), is("f3de63df-24e5-e111-8b5b-005056b45da6"));
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

        collector.checkThat(splittingRule.getSplittingRuleId().getGuid(), is("f3f43916-25e5-e111-8b5b-005056b45da6"));
        collector.checkThat(splittingRule.getInvoiceRecipientId().getGuid(), is("2b29cd0c-25e5-e111-8b5b-005056b45da6"));
        collector.checkThat(splittingRule.getSplitter(), is("1365489"));

        collector.checkThat(purchaseOrder.getPurchaseOrderId().getGuid(), is("9ffadde7-25e5-e111-8b5b-005056b45da6"));
        collector.checkThat(purchaseOrder.getInvoicingRuleId().getGuid(), is("f3de63df-24e5-e111-8b5b-005056b45da6"));
        collector.checkThat(purchaseOrder.getPoNumber(), is("234 - do not edit"));
        collector.checkThat(purchaseOrder.getValidFrom().getTimestamp(), is("2012-08-15T00:00:00.000+02:00"));
        collector.checkThat(purchaseOrder.getValidTo().getTimestamp(), is("2012-08-17T00:00:00.000+02:00"));

        collector.checkThat(invoiceMessageRule.getInvoiceMessageRuleId().getGuid(), is("451c9139-40e5-e111-8b5b-005056b45da6"));
        collector.checkThat(invoiceMessageRule.getInvoicingRuleId().getGuid(), is("f3de63df-24e5-e111-8b5b-005056b45da6"));
        collector.checkThat(invoiceMessageRule.getMessageText(), is("This is a text to be printed on all invoices for this invoicing rule"));
        collector.checkThat(invoiceMessageRule.getValidFrom().getTimestamp(), is("2012-08-13T00:00:00.000+02:00"));
        collector.checkThat(invoiceMessageRule.getValidTo().getTimestamp(), is("2012-08-30T00:00:00.000+02:00"));

        collector.checkThat(agreement.getSourceSystemAgreementId(), is("1-888111"));
        collector.checkThat(agreement.getClientId(), is("49135002"));
        collector.checkThat(agreement.getInvoicingRuleId().getGuid(), is("f3de63df-24e5-e111-8b5b-005056b45da6"));
        collector.checkThat(agreement.getDescription(), is("German opportunity - do not edit, used in unit tests"));
        collector.checkThat(agreement.getProductType().getValue(), is(6));
        collector.checkThat(agreement.getMarketId().getOrganizationId(), is(51));
        collector.checkThat(agreement.getCurrencyCode().getCurrencyCode(), is("EUR"));
        collector.checkThat(agreement.getValidFrom().getTimestamp(), is("2012-08-15T00:00:00.000+02:00"));
        collector.checkThat(agreement.getValidTo().getTimestamp(), is("2012-08-29T00:00:00.000+02:00"));
        collector.checkThat(agreement.getDocumentLink(), nullValue());

        collector.checkThat(client.getClientId(), is("49135002"));
        collector.checkThat(client.getRegisteredCompanyName(), is("Volvo Personvagnar AB"));
        collector.checkThat(client.getCompanyRegistrationNumber(), is("5560743089"));
        collector.checkThat(client.getVatNumber(), is("1234545"));
        collector.checkThat(client.getInvoiceLanguage().getLanguageCode(), is("sv"));
        collector.checkThat(client.getBusinessFormCode(), nullValue());
        collector.checkThat(client.getClientType(), is(ClientType.ADVERTISER));

        collector.checkThat(bank.getClientId(), is("49135002"));
        collector.checkThat(bank.getMarketId().getOrganizationId(), is(135899));
        collector.checkThat(bank.getBankCode(), is("SWEDBANK"));
        collector.checkThat(bank.getBankAccount(), is("1234-123456789"));
        collector.checkThat(bank.getAccountOwner(), is("Someone at Volvo"));

        collector.checkThat(registeredAddressClient.getLine1(), is("21355"));
        collector.checkThat(registeredAddressClient.getLine2(), nullValue());
        collector.checkThat(registeredAddressClient.getCity(), is("21312"));
        collector.checkThat(registeredAddressClient.getCounty(), nullValue());
        collector.checkThat(registeredAddressClient.getPostalCode(), is("123"));
        collector.checkThat(registeredAddressClient.getCountryCode().getValue(), is("SE"));
        collector.checkThat(registeredAddressClient.getAddressType().getValue(), is(3));


        collector.checkThat(invoiceMessageRuleClient.getInvoiceMessageRuleId().getGuid(), is("4fe2e986-1ae5-e111-8b5b-005056b45da6"));
        collector.checkThat(invoiceMessageRuleClient.getClientId(), is("49135002"));

        collector.checkThat(invoiceMessageRuleClient.getMessageText(), is("This is a text to be printed on all invoices for the client"));
        collector.checkThat(invoiceMessageRuleClient.getValidFrom().getTimestamp(), is("2012-08-12T00:00:00.000+02:00"));
        collector.checkThat(invoiceMessageRuleClient.getValidTo().getTimestamp(), is("2012-10-18T00:00:00.000+02:00"));

    }
}

