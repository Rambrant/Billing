package com.tradedoubler.billing.service.crm.azure;

import com.microsoft.windowsazure.services.core.storage.StorageException;
import com.microsoft.windowsazure.services.queue.client.CloudQueueMessage;

import java.io.UnsupportedEncodingException;

/**
 * Wraps a fetched azure queue message and the queue name it was fetched from.
 */
public class AzureMessage {

    private final CloudQueueMessage message;
    private final String queueName;

    public AzureMessage(CloudQueueMessage message, String queueName){
        this.message = message;
        this.queueName = queueName;
    }

    public CloudQueueMessage getMessage() {
        return message;
    }

    public String getQueueName() {
        return queueName;
    }

    public String getMessageContentAsString(String encoding) throws StorageException, UnsupportedEncodingException {
        return new String(message.getMessageContentAsByte(), encoding);
    }

    public String getId() {
        return message.getId();
    }
}
