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

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;

/**
 * User: erigu
 * Date: 2012-09-24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext-test.xml", "/spring/springBeansContext.xml"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class ClientUpdatedFromJsonTransformerTest {
    @Autowired
    private ApplicationContext applicationContext;

    private ClientUpdatedFromJsonTransformer transformer;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Before
    public void setUp() throws Exception {
        ApplicationContextUtil contextUtil = new ApplicationContextUtil(applicationContext);
        transformer = contextUtil.registerAnnotatedBean(ClientUpdatedFromJsonTransformer.class);
    }

    @Test
    public void testEmptyJson() throws Exception {
        JsonMessage jsonMessage = new JsonMessage("");
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setRawData(jsonMessage);

        ServiceResult result = (ServiceResult) transformer.doTransform(serviceResult, "UTF-8");
        assertNull(result.getIntegrationMessage());
        collector.checkThat(result.isBugDisturbance(), is(true));
        collector.checkThat(result.getErrorMessage(), is("Was not able to transform class class com.tradedoubler.billing.domain.ClientUpdated"));
    }

    @Test
    public void testExampleJson() throws Exception {
        String json = FileUtil.readFileFromClasspath("json-examples/client-updated-example.json");
        JsonMessage jsonMessage = new JsonMessage(json);
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setRawData(jsonMessage);

        ServiceResult transformedServiceResult = (ServiceResult) transformer.doTransform(serviceResult, "UTF-8");
        ClientUpdated clientUpdated = (ClientUpdated) transformedServiceResult.getIntegrationMessage().getDomainObject();

        MetaData metaData = clientUpdated.getMetaData();

        collector.checkThat(metaData.getMessageType(), is("UpdateClient"));
        collector.checkThat(metaData.getMessageId().getGuid(), is("54d7887f-481a-62f6-5b41-3f33f46ec478"));
        collector.checkThat(metaData.getCreationTime().getTimestamp(), is("2012-07-07T12:52:20.000+02:00"));
        collector.checkThat(metaData.getVersion(), is("1.0"));
        collector.checkThat(metaData.getSourceSystem(), is("CRM"));

        Client client = clientUpdated.getClient();

        collector.checkThat(client.getClientId(), is("Cl42824050"));
        collector.checkThat(client.getBusinessFormCode(), is(""));
        collector.checkThat(client.getCompanyRegistrationNumber(), is("556284-2319"));
        collector.checkThat(client.getInvoiceLanguage().getLanguageCode(), is("SV"));
        collector.checkThat(client.getRegisteredCompanyName(), is("Kentor IT AB"));
        collector.checkThat(client.getVatNumber(), is("SE556284231901"));
        collector.checkThat(client.getClientType(), is(ClientType.ADVERTISER));

        List<Bank> bankAccounts = client.getBankAccounts();
        collector.checkThat(bankAccounts.size(), is(1));
        Bank bank = bankAccounts.get(0);

        collector.checkThat(bank.getAccountOwner(), is("Account Owner Example"));
        collector.checkThat(bank.getBankAccount(), is("4242424242"));
        collector.checkThat(bank.getBankCode(), is("SWEDSESS"));
        collector.checkThat(bank.getClientId(), is("Cl42824050"));
        collector.checkThat(bank.getMarketId().getOrganizationId(), is(51));

        List<ClientMessageRule> invoiceMessageRules = client.getInvoiceMessageRules();
        collector.checkThat(invoiceMessageRules.size(), is(1));
        ClientMessageRule clientMessageRule = invoiceMessageRules.get(0);

        collector.checkThat(clientMessageRule.getClientId(), is("Cl42824050"));
        collector.checkThat(clientMessageRule.getInvoiceMessageRuleId().getGuid(), is("face8421-11f1-4684-1769-3478152e5597"));
        collector.checkThat(clientMessageRule.getMessageText(), is("This is a text to be printed on all invoices for this client"));
        collector.checkThat(clientMessageRule.getValidFrom().toString(), is("2012-06-25T00:00:00.000+01:00"));
        collector.checkThat(clientMessageRule.getValidTo().toString(), is("2012-08-30T00:00:00.000+01:00"));

        List<Market> marketIds = client.getMarketIds();
        collector.checkThat(marketIds.size(), is(1));
        collector.checkThat(marketIds.get(0).getOrganizationId(), is(51));

        Address registeredAddress = client.getRegisteredAddress();

        collector.checkThat(registeredAddress.getCity(), is("Stockholm"));
        collector.checkThat(registeredAddress.getCountryCode().getValue(), is("SE"));
        collector.checkThat(registeredAddress.getLine1(), is("Vasagatan 38"));
        collector.checkThat(registeredAddress.getLine2(), is("hejsan"));
        collector.checkThat(registeredAddress.getPostalCode(), is("11120"));
        collector.checkThat(registeredAddress.getAddressType().getValue(), is(3));
        collector.checkThat(registeredAddress.getCounty(), nullValue());
    }
}
