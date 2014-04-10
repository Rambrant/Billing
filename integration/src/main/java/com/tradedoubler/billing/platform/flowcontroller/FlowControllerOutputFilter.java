package com.tradedoubler.billing.platform.flowcontroller;

import org.mule.api.MuleMessage;
import org.mule.api.routing.filter.Filter;

/** Filters output from the FlowController. Will end a flow if necessary. */
public class FlowControllerOutputFilter implements Filter {

    @Override
    public boolean accept(MuleMessage message) {
        // If the Flow controller has passed a ServiceResult it is deemed  "OK" and the
        // flow is allowed to continue, otherwise the flow will be ended here and now
        return message.getPayload() instanceof ServiceResult;
    }
}



