package com.tradedoubler.billing.service.crm;

import com.microsoft.windowsazure.services.core.storage.*;
import com.microsoft.windowsazure.services.queue.client.*;
import com.tradedoubler.billing.service.ParameterUtil;
import com.tradedoubler.billing.service.crm.azure.AzureQueueWrapper;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;

/**
 * Setup information that is used in Azure calls.
 *
 * @author bjoek
 * @since 2012-10-15
 */
@Component
public class AzureServiceSetup {
    private final static Logger log = LoggerFactory.getLogger(AzureServiceSetup.class);

    @Value("${AZURE_CRM_ACCOUNT_NAME}")
    private String accountName;

    @Value("${AZURE_CRM_ACCOUNT_KEY}")
    private String accountKey;

    @Value("${AZURE_QUEUE_COMMUNICATION_PROTOCOL}")
    private String protocol;

    @Value("${AZURE_DEFAULT_SERVICE_REQUEST_TIMEOUT_MS}")
    private int timeOutMs;

    @Value("${AZURE_DELETE_REQUEST_TIMEOUT_MS}")
    private int deleteRequestTimeOutMs;

    @Value("${AZURE_FETCH_REQUEST_TIMEOUT_MS}")
    private int fetchRequestTimeOutMs;

    @Value("${AZURE_PUT_REQUEST_TIMEOUT_MS}")
    private int putRequestTimeOutMs;

    @Value("${AZURE_DEFAULT_VISIBILITY_TIMEOUT_SECONDS}")
    private int visibilityTimeOutSec;

    @PostConstruct
    private void setup() {
        log.debug("Check all parameters that are populated from properties");
        ParameterUtil.checkParameter(accountName);
        ParameterUtil.checkParameter(accountKey);
        ParameterUtil.checkParameter(protocol);
        ParameterUtil.checkParameter(timeOutMs);
        ParameterUtil.checkParameter(visibilityTimeOutSec);
        ParameterUtil.checkParameter(deleteRequestTimeOutMs);
        ParameterUtil.checkParameter(fetchRequestTimeOutMs);
        ParameterUtil.checkParameter(putRequestTimeOutMs);
    }

    /** Creates a Azure queue that can be used for fetch, delete or put calls. */
    public AzureQueueWrapper getCloudQueue(String queueName) throws StorageException, URISyntaxException, InvalidKeyException {
        CloudQueueClient queueClient = createCloudQueueClient();

        // Retrieve a reference to a queue
        CloudQueue queue = queueClient.getQueueReference(queueName);

        return new AzureQueueWrapper(queue);
    }

    /** Contains cloud account information for Azure. Do not cache, CloudQueueClient is not thread safe. */
    private CloudQueueClient createCloudQueueClient() throws URISyntaxException, InvalidKeyException {
        // Define the connection-string with your values
        String storageConnectionString =
                String.format("DefaultEndpointsProtocol=%s;AccountName=%s;AccountKey=%s", protocol, accountName, accountKey);

        // Retrieve storage account from connection-string
        CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);

        // Create the queue client
        CloudQueueClient queueClient = storageAccount.createCloudQueueClient();

        queueClient.setTimeoutInMs(timeOutMs);
        return queueClient;
    }

    /**
     * Used when a message is retrieved from the queue.
     * The message is not automatically deleted from the queue. After it has been retrieved,
     * it is not visible to other clients for the time interval specified by the visibilityTimeOutSec parameter.
     */
    public int getVisibilityTimeOutSec() {
        return visibilityTimeOutSec;
    }

    /** The Queue service returns an error when the timeout interval elapses while processing the delete request. */
    public int getDeleteRequestTimeOutMs() {
        return deleteRequestTimeOutMs;
    }

    /** The Queue service returns an error when the timeout interval elapses while processing the fetch request. */
    public int getFetchRequestTimeOutMs() {
        return fetchRequestTimeOutMs;
    }

    /** The Queue service returns an error when the timeout interval elapses while processing the put request. */
    public int getPutRequestTimeOutMs() {
        return putRequestTimeOutMs;
    }
}
