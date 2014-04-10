package com.tradedoubler.billing.mulecomponent;

import com.tradedoubler.billing.platform.flowcontroller.ServiceResult;
import com.tradedoubler.billing.platform.flowcontroller.ServiceResultErrorHandler;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.AxService;
import com.tradedoubler.billing.service.pan.PanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * This is the mule business component that sends an order lines to Ax and then confirms them in Pan.
 *
 * @since 2012-06-12
 */
@Component
public class MuleOrderLinesCreated {

    private final static Logger log = LoggerFactory.getLogger(MuleOrderLinesCreated.class);

    @Autowired
    private AxService axService;

    @Autowired
    private PanService panService;

    public ServiceResult execute(ServiceResult serviceResult) {
        log.info(serviceResult.toStringShort());
        try {
            if (serviceResultIsOk(serviceResult)) {
                serviceResult = axService.createOrderLines(serviceResult);
                serviceResult = panService.confirmOrderLines(serviceResult);
            }
        } catch (BillingServiceException bse) {
            serviceResult = ServiceResultErrorHandler.handleBillingException(serviceResult, bse, "OrderLinesCreated WebService failed");
        } catch (Exception rex) {
            serviceResult = ServiceResultErrorHandler.handleException(serviceResult, "Accessing webservice", rex);
        }
        return serviceResult;
    }

    private boolean serviceResultIsOk(ServiceResult serviceResult) {
        return !serviceResult.getIntegrationMessage().isOutOfSequence() && !serviceResult.isDisturbance();
    }
}
