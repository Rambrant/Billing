package com.tradedoubler.billing.service.crm.azure;


import com.microsoft.windowsazure.services.queue.client.CloudQueueMessage;
import com.tradedoubler.billing.service.crm.JsonMessage;
import org.slf4j.*;
import org.springframework.stereotype.Component;

/**
 * Converts the Azure message to a Json representaion. The content of the Azure message is UTF-8 encoded.
 * Date: 2012-06-13
 */
@Component
public class JsonToAzureMessageTransformer {

    private final static Logger log = LoggerFactory.getLogger(JsonToAzureMessageTransformer.class);

    public AzureMessage doTransform(JsonMessage jsonMessage, String queueName) {
        checkMessage(jsonMessage);

        if (log.isDebugEnabled()) {
            log.debug("Original json message : " + jsonMessage);
        }

        CloudQueueMessage message = new CloudQueueMessage(jsonMessage.jsonString);

        return new AzureMessage(message, queueName);
    }

    private void checkMessage(Object message) {
        if (message == null) {
            throw new IllegalArgumentException("Message must not be null");
        }
    }
}
