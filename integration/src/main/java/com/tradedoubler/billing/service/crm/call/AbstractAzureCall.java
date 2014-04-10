package com.tradedoubler.billing.service.crm.call;

import com.microsoft.windowsazure.services.queue.client.QueueRequestOptions;
import com.tradedoubler.billing.service.crm.AzureServiceSetup;

/**
 * Common functionality for Azure calls
 *
 * @author bjoek
 * @since 2012-10-15
 */
public class AbstractAzureCall {
    final AzureServiceSetup serviceSetup;

    AbstractAzureCall(AzureServiceSetup serviceSetup) {
        this.serviceSetup = serviceSetup;
    }

    QueueRequestOptions createRequestOptions(int callTimeOutMs) {
        QueueRequestOptions opts = new QueueRequestOptions();

        opts.setTimeoutIntervalInMs(callTimeOutMs);
        return opts;
    }
}
