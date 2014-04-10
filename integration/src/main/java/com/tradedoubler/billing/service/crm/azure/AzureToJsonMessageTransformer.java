package com.tradedoubler.billing.service.crm.azure;


import com.microsoft.windowsazure.services.core.storage.StorageException;
import com.tradedoubler.billing.fetch.FlowName;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.crm.*;
import org.slf4j.*;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * Converts the Azure message to a Json representaion. The content of the Azure message is UTF-8 encoded.
 * Date: 2012-06-13
 */
@Component
public class AzureToJsonMessageTransformer {

    private final static Logger log = LoggerFactory.getLogger(AzureToJsonMessageTransformer.class);

    private static final String ENCODING = "UTF-8";

    public JsonMessage doTransform(AzureMessage message, FlowName flowName) throws BillingServiceException {
        checkPayload(message);

        String jsonString;
        try {
            jsonString = message.getMessageContentAsString(ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Unknown encoding: " + ENCODING, e);
        } catch (StorageException e) {
            throw AzureExceptionHandler.createException(e, flowName, message.getQueueName());
        }

        JsonMessage jsonMessage = new JsonMessage(jsonString);
        log.debug("Original json message : " + jsonMessage);

        return jsonMessage;
    }

    private void checkPayload(Object payload) {
        if (payload == null) {
            throw new IllegalArgumentException("Message must not be null");
        }
    }
}
