package com.tradedoubler.billing.mulecomponent;

import com.tradedoubler.billing.domain.ResellerInvoicingRuleUpdated;
import com.tradedoubler.billing.platform.flowcontroller.*;
import org.slf4j.*;
import org.springframework.stereotype.Component;


/**
 * This mule business component sets up an UpdateAgreement as domain object.
 *
 * @since 2013-01-04
 */
@Component
public class MuleResellerUpdateInvoicingRuleAgreementSetup {

    private final static Logger log = LoggerFactory.getLogger(MuleResellerUpdateInvoicingRuleAgreementSetup.class);

    public ServiceResult execute(ServiceResult serviceResult) {
        log.info(serviceResult.toStringShort());
        try {
            if (serviceResultIsOk(serviceResult)) {
                // Swap domain object to agreement
                ResellerInvoicingRuleUpdated invoicingRuleUpdated = (ResellerInvoicingRuleUpdated)serviceResult.getCommitInfo();
                serviceResult.getIntegrationMessage().setDomainObject(invoicingRuleUpdated.getAgreementUpdated());
            }
        } catch (Exception rex) {
            serviceResult = ServiceResultErrorHandler.handleException(serviceResult, "Accessing webservice", rex);
        }
        return serviceResult;
    }

    private boolean serviceResultIsOk(ServiceResult serviceResult) {
        return !serviceResult.getIntegrationMessage().isOutOfSequence() && !serviceResult.isDisturbance();
    }
}

