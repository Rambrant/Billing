package com.tradedoubler.billing.service.crm.azure;

import com.microsoft.windowsazure.services.queue.client.CloudQueueMessage;
import com.tradedoubler.billing.fetch.FlowName;
import com.tradedoubler.billing.service.crm.JsonMessage;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * User: erigu
 * Date: 2012-06-15
 */
public class AzureToJsonMessageTransformerTest {
    private final AzureToJsonMessageTransformer azureToJsonMessageTransformer = new AzureToJsonMessageTransformer();

    @Test
    public void doTransform() throws Exception {
        AzureMessage azureMessage = new AzureMessage(new CloudQueueMessage("someText åäö"), "queueName");
        JsonMessage jsonMessage = azureToJsonMessageTransformer.doTransform(azureMessage, FlowName.DeleteInvoiceRecipientCrm);
        assertNotNull(jsonMessage);
        assertEquals("someText åäö", jsonMessage.jsonString);
    }

}
