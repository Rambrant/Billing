package com.tradedoubler.billing.service.crm.call;

import com.tradedoubler.billing.service.crm.AzureServiceSetup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Factory to create (instantiate) Azure queue calls. The calls use AzureServiceSetup to find azure queues and timeout values.
 * This class was originally created to simplify testing of flows with dummy azure queue calls.
 * @author bjoek
 * @since 2012-10-15
 */
@SuppressWarnings("unchecked")
@Component
public class AzureCallFactory {
    @Autowired
    private AzureServiceSetup serviceSetup;

    /** Returns an instantiated Call class */
    public <T extends AbstractAzureCall> T createCall(Class<T> clazz) {
        if (clazz == DeleteMessageCall.class) {
            return (T) new DeleteMessageCall(serviceSetup);
        }
        if (clazz == FetchMessageCall.class) {
            return (T) new FetchMessageCall(serviceSetup);
        }
        if (clazz == PutMessageCall.class) {
            return (T) new PutMessageCall(serviceSetup);
        }

        throw new IllegalArgumentException("Cannot handle " + clazz);
    }
}
