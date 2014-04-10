package com.tradedoubler.billing.mulecomponent;

import com.tradedoubler.billing.platform.flowcontroller.*;
import com.tradedoubler.billing.service.ax.AxService;
import com.tradedoubler.billing.service.BillingServiceException;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * This is the mule business component that removes an invoice recipient from Ax.
 *
 * @since 2012-06-12
 */

@Component
public class MuleInvoiceRecipientDeleted {

    private final static Logger log = LoggerFactory.getLogger(MuleInvoiceRecipientDeleted.class);

    @Autowired
    private AxService service;

    public ServiceResult execute(ServiceResult serviceResult) {
        log.info(serviceResult.toStringShort());

        try {
            if (serviceResultIsOk(serviceResult)) {
                serviceResult = service.deleteInvoiceRecipient(serviceResult);
            }
        } catch (BillingServiceException bse) {
            serviceResult = ServiceResultErrorHandler.handleBillingException(serviceResult, bse, "InvoiceRecipientDeleted WebService failed");
        } catch (Exception rex) {
            serviceResult = ServiceResultErrorHandler.handleException(serviceResult, "Accessing webservice", rex);
        }
        return serviceResult;
    }

    private boolean serviceResultIsOk(ServiceResult serviceResult) {
        return !serviceResult.getIntegrationMessage().isOutOfSequence() && !serviceResult.isDisturbance();
    }
}
