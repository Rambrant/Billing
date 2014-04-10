package com.tradedoubler.billing.mulecomponent;

import com.tradedoubler.billing.platform.flowcontroller.*;
import com.tradedoubler.billing.service.crm.CrmService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * This mule component is used by the different flows to remove/confirm azure messages
 *
 * @since 2012-06-12
 */
@Component
public class MuleDeleteOriginalAzureMessage {

    private final static Logger log = LoggerFactory.getLogger(MuleDeleteOriginalAzureMessage.class);

    @Autowired
    private CrmService service;

    public ServiceResult execute(ServiceResult serviceResult) {
        log.debug(serviceResult.toStringShort());
        try {
            if (!serviceResult.isDisturbance() || serviceResult.getIntegrationMessage().isOutOfSequence()) {
                serviceResult = service.deleteOriginalMessage(serviceResult);
            }
        } catch (Exception rex) {
            serviceResult = ServiceResultErrorHandler.handleException(serviceResult, "Deleting Azure message", rex);
        }
        return serviceResult;
    }

}




