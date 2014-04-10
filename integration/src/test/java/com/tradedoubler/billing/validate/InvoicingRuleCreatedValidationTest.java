package com.tradedoubler.billing.validate;

import com.tradedoubler.billing.platform.flowcontroller.ServiceResult;
import com.tradedoubler.billing.service.crm.JsonMessage;
import com.tradedoubler.testutil.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mule.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.URI;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @author bjoek
 * @since 2012-06-26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext-test.xml"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class InvoicingRuleCreatedValidationTest {
    @Autowired
    private ApplicationContext applicationContext;

    private JsonValidationProcessor validationProcessor;

    private final MuleMessage muleMessage = mock(MuleMessage.class);

    private final MuleEvent muleEvent = mock(MuleEvent.class);

    @Before
    public void setUp() throws Exception {
        ApplicationContextUtil contextUtil = new ApplicationContextUtil(applicationContext);
        contextUtil.registerAnnotatedBean(ClassPathResourceManager.class);
        contextUtil.registerAnnotatedBean(TdJsonSchemaReader.class);
        contextUtil.registerAnnotatedBean(Validator.class);
        validationProcessor = contextUtil.registerAnnotatedBean(JsonValidationProcessor.class);

        validationProcessor.setJsonSchemaPath("validation/schema/billing/invoicing-rule-created-schema.json");
    }

    @Test
    public void invoicingRuleCreatedExampleShouldWork() throws Exception {
        String json = FileUtil.readFileFromClasspath("json-examples/invoicing-rule-created-example.json");

        JsonMessage jsonMessage = new JsonMessage(json);
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setRawData(jsonMessage);

        when(muleEvent.getMessage()).thenReturn(muleMessage);
        when(muleEvent.getMessageSourceURI()).thenReturn(new URI("getMessageSourceURI"));
        when(muleMessage.getPayload()).thenReturn(serviceResult);

        validationProcessor.process(muleEvent);

        assertServiceResultFail(false, false);
    }

    @Test
    public void illegalJsonShouldNotWork() throws Exception {
        String json = "{ \"metaData\" : {} }";

        JsonMessage jsonMessage = new JsonMessage(json);
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setRawData(jsonMessage);

        when(muleEvent.getMessage()).thenReturn(muleMessage);
        when(muleEvent.getMessageSourceURI()).thenReturn(new URI("getMessageSourceURI"));
        when(muleMessage.getPayload()).thenReturn(serviceResult);

        validationProcessor.process(muleEvent);

        assertServiceResultFail(false, true);
    }

    @Test
    public void corruptServiceResultShouldNotWork() throws Exception {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setRawData(new JsonMessage(""));

        when(muleEvent.getMessage()).thenReturn(muleMessage);
        when(muleEvent.getMessageSourceURI()).thenReturn(new URI("getMessageSourceURI"));
        when(muleMessage.getPayload()).thenReturn(serviceResult);

        validationProcessor.process(muleEvent);

        assertServiceResultFail(false, true);
    }

    @Test
    public void corruptServiceResultShouldNotWork2() throws Exception {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setRawData("Howdy");

        when(muleEvent.getMessage()).thenReturn(muleMessage);
        when(muleEvent.getMessageSourceURI()).thenReturn(new URI("getMessageSourceURI"));
        when(muleMessage.getPayload()).thenReturn(serviceResult);

        validationProcessor.process(muleEvent);

        assertServiceResultFail(false, true);
    }

    private void assertServiceResultFail(boolean isIntFail, boolean isBugFail) {
        ArgumentCaptor<ServiceResult> listArgumentCaptor = ArgumentCaptor.forClass(ServiceResult.class);
        verify(muleMessage).setPayload(listArgumentCaptor.capture());
        ServiceResult value = listArgumentCaptor.getValue();
        assertEquals(isIntFail, value.isIntegrationPointDisturbance());
        assertEquals(isBugFail, value.isBugDisturbance());
    }

}
