package com.tradedoubler.billing.mulecomponent;

import com.tradedoubler.billing.platform.flowcontroller.*;
import com.tradedoubler.billing.service.pan.PanService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * This mule component is used to remove/confirm create-invoicing-rule events from pan.
 */
@Component
public class MuleDeleteInvoicingRuleFromPan {

    private final static Logger log = LoggerFactory.getLogger(MuleDeleteInvoicingRuleFromPan.class);

    @Autowired
    private PanService service;

    public ServiceResult execute(ServiceResult serviceResult) {
        log.debug(serviceResult.toStringShort());
        try {
            if (!serviceResult.isDisturbance() || serviceResult.getIntegrationMessage().isOutOfSequence()) {
                log.info("About to confirm an invoicing rule as being processed");
                serviceResult = service.confirmInvoicingRuleProcessed(serviceResult);
            }
        } catch (Exception rex) {
            serviceResult = ServiceResultErrorHandler.handleException(serviceResult, "Deleting invoicing rule from pan", rex);
        }
        return serviceResult;
    }
}




