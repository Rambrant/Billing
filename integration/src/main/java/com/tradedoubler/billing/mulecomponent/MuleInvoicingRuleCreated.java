package com.tradedoubler.billing.mulecomponent;

import com.tradedoubler.billing.platform.flowcontroller.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.AxService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * This is the mule business component that sends an new invoicing rule to Ax. The invoicing rule is accompanied by a client
 * and an agreement
 *
 * @since 2012-06-12
 */

@Component
public class MuleInvoicingRuleCreated {

    private final static Logger log = LoggerFactory.getLogger(MuleInvoicingRuleCreated.class);

    @Autowired
    private AxService service;

    public ServiceResult execute(ServiceResult serviceResult) {
        log.info(serviceResult.toStringShort());

        try {
            if (serviceResultIsOk(serviceResult)) {
                // the insertInvoicingRule will also execute updateDisplayTradeDoublerCommission in pan database
                serviceResult = service.insertInvoicingRule(serviceResult);
                serviceResult = service.insertClient(serviceResult);
                serviceResult = service.insertAgreement(serviceResult);
            }
        } catch (BillingServiceException bse) {
            serviceResult = ServiceResultErrorHandler.handleBillingException(serviceResult, bse, "InvoicingRuleCreated WebService failed");
        } catch (Exception rex) {
            serviceResult = ServiceResultErrorHandler.handleException(serviceResult, "Accessing webservice", rex);
        }
        return serviceResult;
    }

    private boolean serviceResultIsOk(ServiceResult serviceResult) {
        return !serviceResult.getIntegrationMessage().isOutOfSequence() && !serviceResult.isDisturbance();
    }
}
