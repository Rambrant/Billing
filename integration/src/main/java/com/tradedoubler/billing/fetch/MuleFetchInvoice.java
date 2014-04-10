package com.tradedoubler.billing.fetch;

import com.tradedoubler.billing.platform.flowcontroller.ServiceResult;
import com.tradedoubler.billing.platform.flowcontroller.ServiceResultErrorHandler;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.AxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/** This is the mule business component that fetches an invoice from the ftp-server. */
@Component
public class MuleFetchInvoice {

    private final static Logger log = LoggerFactory.getLogger(MuleFetchInvoice.class);

    @Autowired
    private AxService service;

    public ServiceResult execute(ServiceResult serviceResult) {
        log.info(serviceResult.toStringShort());
        try {

                serviceResult = service.fetchCreatedInvoice(serviceResult);

        } catch (Exception rex) {
            serviceResult = ServiceResultErrorHandler.handleException(serviceResult, rex.getMessage(), rex);

        }
        //If fetch fails due to bug-disturbance, most likely caused by error in XML, then move the file and handle the bug-disturbance to
        //enable a new fetch.
        if (serviceResult.isBugDisturbance()) {
            log.info(String.format(
                    String.format("Moves failed invoice %s to failed-directory", serviceResult.getCommitInfo())));
            try {
                service.moveFailedInvoice(serviceResult);
            } catch (BillingServiceException e) {
                serviceResult = ServiceResultErrorHandler.handleException(serviceResult, e.getMessage(), e);
            }
        }

        return serviceResult;
    }

    private ServiceResult handleDisturbance(ServiceResult serviceResult) {
        return serviceResult;
    }
}
