package com.tradedoubler.billing.mulecomponent;

import com.tradedoubler.billing.platform.flowcontroller.ServiceResult;
import com.tradedoubler.billing.platform.flowcontroller.ServiceResultErrorHandler;
import com.tradedoubler.billing.service.ax.AxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/** This is the mule business component that finalizes an invoice. How it is finalized depends on if the invoice handling was successful or not. */
@Component
public class MuleFinalizeInvoice {

    private final static Logger log = LoggerFactory.getLogger(MuleFinalizeInvoice.class);

    @Autowired
    private AxService service;

    public ServiceResult execute(ServiceResult serviceResult) {
        log.info(serviceResult.toStringShort());
        try {
            //No out-of-sequence handling is necessary here for this flow and this particular component.
            if (serviceResult.isBugDisturbance()) {
                //if a bug disturbance is flagged the failed invoice is moved and the bug flag is cleared
                serviceResult = service.moveFailedInvoice(serviceResult);

            } else if (serviceResultIsOk(serviceResult)) {
                //If all ok finalize the invoice
                serviceResult = service.finalizeInvoice(serviceResult);

            }
        } catch (Exception rex) {
            serviceResult = ServiceResultErrorHandler.handleException(serviceResult, rex.getMessage(), rex);
        }
        return serviceResult;
    }

    private boolean serviceResultIsOk(ServiceResult serviceResult) {// &&& serviceResult.getIntegrationMessage() != null
        return serviceResult.getCommitInfo() != null  && serviceResult.getIntegrationMessage() != null && !serviceResult.isDisturbance();
    }


}
