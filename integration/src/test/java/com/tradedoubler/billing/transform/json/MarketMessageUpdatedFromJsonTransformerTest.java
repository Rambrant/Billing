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

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;

/**
 * @author bjoek
 * @since 2012-09-26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext-test.xml", "/spring/springBeansContext.xml"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class MarketMessageUpdatedFromJsonTransformerTest {
    @Autowired
    private ApplicationContext applicationContext;

    private MarketMessageUpdatedFromJsonTransformer transformer;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Before
    public void setUp() throws Exception {
        ApplicationContextUtil contextUtil = new ApplicationContextUtil(applicationContext);
        transformer = contextUtil.registerAnnotatedBean(MarketMessageUpdatedFromJsonTransformer.class);
    }

    @Test
    public void testEmptyJson() throws Exception {
        JsonMessage jsonMessage = new JsonMessage("");
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setRawData(jsonMessage);

        ServiceResult result = (ServiceResult) transformer.doTransform(serviceResult, "UTF-8");
        assertNull(result.getIntegrationMessage());
        collector.checkThat(result.isBugDisturbance(), is(true));
        collector.checkThat(result.getErrorMessage(), is("Was not able to transform class class com.tradedoubler.billing.domain.MarketMessageUpdated"));
    }

    @Test
    public void testExampleJson() throws Exception {
        String json = FileUtil.readFileFromClasspath("json-examples/market-message-updated-example.json");
        JsonMessage jsonMessage = new JsonMessage(json);
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setRawData(jsonMessage);

        ServiceResult transformedServiceResult = (ServiceResult) transformer.doTransform(serviceResult, "UTF-8");
        MarketMessageUpdated marketMessageUpdated = (MarketMessageUpdated) transformedServiceResult.getIntegrationMessage().getDomainObject();

        MetaData metaData = marketMessageUpdated.getMetaData();

        collector.checkThat(metaData.getMessageType(), is("UpdateMarketMessage"));
        collector.checkThat(metaData.getMessageId().getGuid(), is("54d7887f-481b-62c6-5b41-3f33f46ec478"));
        collector.checkThat(metaData.getCreationTime().getTimestamp(), is("2012-09-06T12:52:20.000+02:00"));
        collector.checkThat(metaData.getVersion(), is("1.0"));
        collector.checkThat(metaData.getSourceSystem(), is("CRM"));

        InvoiceIssuerMessageRule invoiceIssuerMessageRule = marketMessageUpdated.getInvoiceMessageRule();

        collector.checkThat(invoiceIssuerMessageRule.getMarketId().getOrganizationId(), is(51));
        collector.checkThat(invoiceIssuerMessageRule.getInvoiceMessageRuleId().getGuid(), is("885d8421-11f1-4684-1769-3478152e5597"));
        collector.checkThat(invoiceIssuerMessageRule.getMessageText(), is("This is a text to be printed on all invoices for this market"));
        collector.checkThat(invoiceIssuerMessageRule.getValidFrom().toString(), is("2012-06-25T00:00:00.000+01:00"));
        collector.checkThat(invoiceIssuerMessageRule.getValidTo().toString(), is("2012-12-30T00:00:00.000+01:00"));

    }
}
