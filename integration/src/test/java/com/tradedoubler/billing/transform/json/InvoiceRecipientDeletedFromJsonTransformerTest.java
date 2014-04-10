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
 * @since 2012-06-25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext-test.xml", "/spring/springBeansContext.xml"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class InvoiceRecipientDeletedFromJsonTransformerTest {
    @Autowired
    private ApplicationContext applicationContext;

    private InvoiceRecipientDeletedFromJsonTransformer transformer;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Before
    public void setUp() throws Exception {
        ApplicationContextUtil contextUtil = new ApplicationContextUtil(applicationContext);
        transformer = contextUtil.registerAnnotatedBean(InvoiceRecipientDeletedFromJsonTransformer.class);
    }

    @Test
    public void testEmptyJson() throws Exception {
        JsonMessage jsonMessage = new JsonMessage("");
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setRawData(jsonMessage);

        ServiceResult result = (ServiceResult) transformer.doTransform(serviceResult, "UTF-8");
        assertNull(result.getIntegrationMessage());
        collector.checkThat(result.isBugDisturbance(), is(true));
        collector.checkThat(result.getErrorMessage(), is("Was not able to transform class class com.tradedoubler.billing.domain.InvoiceRecipientDeleted"));
    }

    @Test
    public void testExampleJson() throws Exception {
        String json = FileUtil.readFileFromClasspath("json-examples/invoice-recipient-deleted-example.json");
        JsonMessage jsonMessage = new JsonMessage(json);
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setRawData(jsonMessage);

        ServiceResult transformedServiceResult = (ServiceResult) transformer.doTransform(serviceResult, "UTF-8");
        InvoiceRecipientDeleted invoiceRecipientDeleted = (InvoiceRecipientDeleted) transformedServiceResult.getIntegrationMessage().getDomainObject();

        MetaData metaData = invoiceRecipientDeleted.getMetaData();

        collector.checkThat(metaData.getMessageType(), is("DeleteInvoiceRecipient"));
        collector.checkThat(metaData.getMessageId().getGuid(), is("5b15c006-1c3f-4a72-867e-0beff7acf728"));
        collector.checkThat(metaData.getCreationTime().getTimestamp(), is("2012-08-31T14:44:43.290+02:00"));
        collector.checkThat(metaData.getVersion(), is("1.0"));
        collector.checkThat(metaData.getSourceSystem(), is("CRM"));

        collector.checkThat(invoiceRecipientDeleted.getInvoiceRecipientId().getGuid(), is("2b29cd0c-25e5-e111-8b5b-005056b45da6"));
        collector.checkThat(invoiceRecipientDeleted.getMarketId().getOrganizationId(), is(51));
    }
}

