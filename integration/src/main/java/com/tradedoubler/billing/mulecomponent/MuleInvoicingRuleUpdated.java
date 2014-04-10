package com.tradedoubler.billing.mulecomponent;

import com.tradedoubler.billing.platform.flowcontroller.*;
import com.tradedoubler.billing.service.ax.AxService;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.pan.PanService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * This is the mule business component that sends an updated invoicing rule to Ax.
 *
 * @since 2012-06-12
 */
@Component
public class MuleInvoicingRuleUpdated {

    private final static Logger log = LoggerFactory.getLogger(MuleInvoicingRuleUpdated.class);

    @Autowired
    private AxService axService;

    @Autowired
    private PanService panService;

    public ServiceResult execute(ServiceResult serviceResult) {
        log.info(serviceResult.toStringShort());
        try {
            if (serviceResultIsOk(serviceResult)) {
                // The graph is handled by two services
                serviceResult = axService.updateInvoicingRule(serviceResult);
                serviceResult = panService.updateDisplayTradeDoublerCommission(serviceResult);
            }
        } catch (BillingServiceException bse) {
            serviceResult = ServiceResultErrorHandler.handleBillingException(serviceResult, bse, "InvoicingRuleUpdated WebService failed");
        } catch (Exception rex) {
            serviceResult = ServiceResultErrorHandler.handleException(serviceResult, "Accessing webservice", rex);
        }
        return serviceResult;
    }

    private boolean serviceResultIsOk(ServiceResult serviceResult) {
        return !serviceResult.getIntegrationMessage().isOutOfSequence() && !serviceResult.isDisturbance();
    }
}
