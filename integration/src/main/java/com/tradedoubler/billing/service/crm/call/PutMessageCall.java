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
 * Put a new message on an Azure queue.
 *
 * @author bjoek
 * @since 2012-10-15
 */
public class PutMessageCall extends AbstractAzureCall {
    private final static Logger log = LoggerFactory.getLogger(PutMessageCall.class);

    public PutMessageCall(AzureServiceSetup serviceSetup) {
        super(serviceSetup);
    }

    public void putMessageInQueue(AzureMessage message, FlowName flowName) throws BillingServiceException {
        String queueName = message.getQueueName();

        try {
            AzureQueueWrapper queue = serviceSetup.getCloudQueue(queueName);

            if (log.isDebugEnabled()) {
                log.debug(String.format("Put message in queue %s", queueName));
            }

            queue.addMessage(message, createRequestOptions(serviceSetup.getPutRequestTimeOutMs()));
        } catch (StorageException e) {
            throw AzureExceptionHandler.createException(e, flowName, queueName);
        } catch (InvalidKeyException e) {
            throw AzureExceptionHandler.createException(e, flowName, queueName);
        } catch (URISyntaxException e) {
            throw AzureExceptionHandler.createException(e, flowName, queueName);
        }
    }

}
