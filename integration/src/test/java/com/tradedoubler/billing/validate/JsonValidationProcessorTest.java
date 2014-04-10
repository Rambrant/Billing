package com.tradedoubler.billing.validate;

import com.tradedoubler.billing.platform.flowcontroller.ServiceResult;
import com.tradedoubler.billing.service.crm.JsonMessage;
import com.tradedoubler.testutil.*;
import org.junit.*;
import org.mule.*;
import org.mule.api.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * @author bjoek
 * @since 2012-09-19
 */
public class JsonValidationProcessorTest {
    private final JsonValidationProcessor jsonValidationProcessor = new JsonValidationProcessor();
    private final Validator validator = new Validator();
    private final TdJsonSchemaReader tdJsonSchemaReader = new TdJsonSchemaReader();

    @Before
    public void setUp() throws Exception {
        new ReflectionHelper(validator).setField(tdJsonSchemaReader);
        new ReflectionHelper(jsonValidationProcessor).setField(validator);

        jsonValidationProcessor.setJsonSchemaPath("validation/schema/billing/agreement-updated-schema.json");
    }

    @Test
    public void correctJsonShouldWork() throws MuleException {
        String json = FileUtil.readFileFromClasspath("json-examples/agreement-updated-example.json");
        ServiceResult serviceResult = createServiceResult(json);
        jsonValidationProcessor.process(createMuleEvent(serviceResult));
        assertThat(serviceResult.isDisturbance(), is(false));
    }

    @Test
    public void missingPropertiesShouldNotWork() throws MuleException {
        String json = FileUtil.readFileFromClasspath("json-examples/client-updated-example.json");
        ServiceResult serviceResult = createServiceResult(json);
        jsonValidationProcessor.process(createMuleEvent(serviceResult));
        assertThat(serviceResult.isBugDisturbance(), is(true));
        assertThat(serviceResult.getErrorMessage(), startsWith("Was not able to validate json"));
        assertThat(serviceResult.getErrorMessage(), containsString("missing: [\"agreement\"]; required: [\"agreement\",\"metaData\"]]"));

    }

    @Test
    public void toManyPropertiesShouldNotWork() throws MuleException {
        String json = FileUtil.readFileFromClasspath("json-examples/invoicing-rule-created-example.json");
        ServiceResult serviceResult = createServiceResult(json);
        jsonValidationProcessor.process(createMuleEvent(serviceResult));
        assertThat(serviceResult.isBugDisturbance(), is(true));
        assertThat(serviceResult.getErrorMessage(), startsWith("Was not able to validate json"));
        assertThat(serviceResult.getErrorMessage(), endsWith("unwanted: [\"client\",\"invoicingRule\"]]"));

    }

    @Test
    public void wrongTypeShouldNotWork() throws MuleException {
        String json = FileUtil.readFileFromClasspath("json-examples/agreement-updated-example.json");
        assertThat("Prerequisite: value 51 in market must exist", json, containsString(": 51,"));

        // Replace number with string
        json = json.replace(": 51,", ": \"51\",");

        ServiceResult serviceResult = createServiceResult(json);
        jsonValidationProcessor.process(createMuleEvent(serviceResult));
        assertThat(serviceResult.isBugDisturbance(), is(true));
        assertThat(serviceResult.getErrorMessage(), startsWith("Was not able to validate json"));
        assertThat(serviceResult.getErrorMessage(), containsString("instance does not match any allowed primitive type; allowed: [\"integer\"]; found: \"string\"]"));
    }

    private MuleEvent createMuleEvent(ServiceResult serviceResult) {
        MuleMessage muleMessage = new DefaultMuleMessage(serviceResult, mock(MuleContext.class));
        return new DefaultMuleEvent(muleMessage, mock(MuleEvent.class));
    }

    private ServiceResult createServiceResult(String json) {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setRawData(new JsonMessage(json));
        return serviceResult;
    }
}
