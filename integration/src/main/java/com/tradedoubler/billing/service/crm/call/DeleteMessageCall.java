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
 * Delete a message from an Azure queue.
 *
 * @author bjoek
 * @since 2012-10-15
 */
public class DeleteMessageCall extends AbstractAzureCall {
    private final static Logger log = LoggerFactory.getLogger(DeleteMessageCall.class);

    public DeleteMessageCall(AzureServiceSetup serviceSetup) {
        super(serviceSetup);
    }

    public void deleteMessage(AzureMessage message, FlowName flowName) throws BillingServiceException {
        String queueName = message.getQueueName();

        try{
            AzureQueueWrapper queue = serviceSetup.getCloudQueue(queueName);

            log.debug(String.format("Deleting message from %s, messageId: %s", queueName, message.getId()));

            queue.deleteMessage(message, createRequestOptions(serviceSetup.getDeleteRequestTimeOutMs()));
        }catch(StorageException e){
            throw AzureExceptionHandler.createException(e, flowName, queueName);
        } catch (InvalidKeyException e) {
            throw AzureExceptionHandler.createException(e, flowName, queueName);
        } catch (URISyntaxException e) {
            throw AzureExceptionHandler.createException(e, flowName, queueName);
        }
    }

}
