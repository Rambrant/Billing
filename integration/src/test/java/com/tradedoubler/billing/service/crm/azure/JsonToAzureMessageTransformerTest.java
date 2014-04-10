package com.tradedoubler.billing.service.crm.azure;

import com.tradedoubler.billing.service.crm.JsonMessage;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author bjoek
 * @since 2012-10-15
 */
public class JsonToAzureMessageTransformerTest {
    private final JsonToAzureMessageTransformer jsonToAzureMessageTransformer = new JsonToAzureMessageTransformer();

    @Test
    public void doTransform() throws Exception {
        JsonMessage jsonMessage = new JsonMessage("someText åäö");
        AzureMessage azureMessage = jsonToAzureMessageTransformer.doTransform(jsonMessage, "queueName");

        assertThat(azureMessage.getQueueName(), is("queueName"));
        assertThat(azureMessage.getMessageContentAsString("UTF-8"), is("someText åäö"));
        assertThat(azureMessage.getMessage().getMessageContentAsString(), is("someText åäö"));
    }
}
