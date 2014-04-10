package com.tradedoubler.billing.service.crm.azure;

import com.microsoft.windowsazure.services.core.storage.StorageException;
import com.microsoft.windowsazure.services.queue.client.*;

/**
 * The object wrapps a azure queue and exposes relevant methods of the queue to the rest of the application.
 * The main reason behind this class is that it makes testing of the flow easier (since CloudQueue is final
 * and cannot be mocked).
 *
 * @author bjoek
 * @since 2012-10-15
 */
public class AzureQueueWrapper {
    private final CloudQueue cloudQueue;

    public AzureQueueWrapper(CloudQueue cloudQueue) {
        this.cloudQueue = cloudQueue;
    }

    public void addMessage(AzureMessage message, QueueRequestOptions options) throws StorageException {
        cloudQueue.addMessage(message.getMessage(), 0, 0, options, null);
    }

    /**
     * Retrieves a message from the front of the queue, using the specified request options. This
     * operation marks the retrieved message as invisible in the queue for the specified visibility timeout period.
     *
     * @param visibilityTimeOutSec how long the message should be invisible
     * @param options              A {@link QueueRequestOptions} object that specifies any additional options for the request. Specifying
     *                             <code>null</code> will use the default request options from the associated service client (
     *                             {@link CloudQueueClient})
     * @return message or null if not found
     * @throws StorageException
     */
    public AzureMessage retrieveMessage(int visibilityTimeOutSec, QueueRequestOptions options) throws StorageException {
        CloudQueueMessage cloudQueueMessage = cloudQueue.retrieveMessage(visibilityTimeOutSec, options, null);
        if (cloudQueueMessage == null) {
            return null;
        }
        return new AzureMessage(cloudQueueMessage, cloudQueue.getName());
    }

    public void deleteMessage(AzureMessage message, QueueRequestOptions options) throws StorageException {
        cloudQueue.deleteMessage(message.getMessage(), options, null);
    }
}
