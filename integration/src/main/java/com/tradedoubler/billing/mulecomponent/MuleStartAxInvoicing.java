package com.tradedoubler.billing.mulecomponent;

import com.tradedoubler.billing.platform.flowcontroller.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.AxService;
import com.tradedoubler.billing.service.pan.PanService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * This is the mule business component that starts the invoicing process job in Ax and then confirms the job start
 * in Pan.
 *
 * @since 2012-06-12
 */
@Component
public class MuleStartAxInvoicing {

    private final static Logger log = LoggerFactory.getLogger(MuleStartAxInvoicing.class);

    @Autowired
    private AxService axService;

    @Autowired
    private PanService panService;

    public ServiceResult execute(ServiceResult serviceResult) {
        log.info(serviceResult.toStringShort());
        try {
            if (serviceResultIsOk(serviceResult)) {
                serviceResult = axService.startInvoicing(serviceResult);
                serviceResult = panService.confirmInvoicingStarted(serviceResult);
            }
        } catch (BillingServiceException bse) {
            serviceResult = ServiceResultErrorHandler.handleBillingException(serviceResult, bse, "Start invoicing flow failed");
        } catch (Exception rex) {
            serviceResult = ServiceResultErrorHandler.handleException(serviceResult, "Accessing webservice", rex);
        }
        return serviceResult;
    }

    private boolean serviceResultIsOk(ServiceResult serviceResult) {
        return !serviceResult.getIntegrationMessage().isOutOfSequence() && !serviceResult.isDisturbance();
    }
}
