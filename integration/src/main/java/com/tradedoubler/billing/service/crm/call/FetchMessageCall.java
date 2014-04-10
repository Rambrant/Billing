package com.tradedoubler.billing.service.crm.call;

import com.microsoft.windowsazure.services.core.storage.StorageException;
import com.tradedoubler.billing.fetch.FlowName;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.crm.*;
import com.tradedoubler.billing.service.crm.azure.*;
import org.slf4j.*;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;

/**
 * Read a message (without removing it) from an Azure queue.
 *
 * @author bjoek
 * @since 2012-10-15
 */
public class FetchMessageCall extends AbstractAzureCall {
    private final static Logger log = LoggerFactory.getLogger(FetchMessageCall.class);

    public FetchMessageCall(AzureServiceSetup serviceSetup) {
        super(serviceSetup);
    }

    public AzureMessage fetchMessage(String queueName, FlowName flowName) throws BillingServiceException {
        try {
            AzureQueueWrapper queue = serviceSetup.getCloudQueue(queueName);

            // Retrieve the first visible message in the queue
            AzureMessage retrievedMessage = queue.retrieveMessage(
                    serviceSetup.getVisibilityTimeOutSec(),
                    createRequestOptions(serviceSetup.getFetchRequestTimeOutMs()));

            String message = retrievedMessage == null ? "<null message>" : retrievedMessage.getId();
            log.debug(String.format("Fetched message from %s, messageId: %s", queueName, message));

            return retrievedMessage;
        } catch (StorageException e) {
            throw AzureExceptionHandler.createException(e, flowName, queueName);
        } catch (InvalidKeyException e) {
            throw AzureExceptionHandler.createException(e, flowName, queueName);
        } catch (URISyntaxException e) {
            throw AzureExceptionHandler.createException(e, flowName, queueName);
        }
    }

}
