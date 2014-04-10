package com.tradedoubler.billing.fetch;

import com.tradedoubler.billing.platform.flowcontroller.ServiceResult;
import com.tradedoubler.billing.platform.flowcontroller.ServiceResultErrorHandler;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.crm.CrmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * This mule component is used to fetch the different input, from Crm, for the flows.
 *
 * @since 2012-06-12
 */
@Component
public class FetchEntity {

    private final static Logger log = LoggerFactory.getLogger(FetchEntity.class);

    @Autowired
    private CrmService service;

    public ServiceResult execute(ServiceResult serviceResult) {
        log.info(serviceResult.toStringShort());
        try {
            serviceResult = fetchFromService(serviceResult);
        } catch (Exception rex) {
            serviceResult = ServiceResultErrorHandler.handleException(serviceResult, "Fetching from Azure", rex);
        }
        log.debug("Exiting, serviceResult: " + serviceResult.toStringShort());
        return serviceResult;
    }

    private ServiceResult fetchFromService(ServiceResult serviceResult) throws BillingServiceException {
        FlowName flowName = serviceResult.getFlowName();

        switch (flowName) {
            case CreateInvoicingRuleCrm:
                return service.fetchInvoicingRuleCreated(serviceResult);
            case UpdateInvoicingRuleCrm:
                return service.fetchInvoicingRuleUpdated(serviceResult);
            case UpdateAgreementCrm:
                return service.fetchAgreementUpdated(serviceResult);
            case UpdateClientCrm:
                return service.fetchClientUpdated(serviceResult);
            case DeleteSplittingRuleCrm:
                return service.fetchSplittingRuleDeleted(serviceResult);
            case DeleteInvoiceRecipientCrm:
                return service.fetchInvoiceRecipientDeleted(serviceResult);
            case UpdateMarketMessageCrm:
                return service.fetchMarketMessageUpdated(serviceResult);
            default:
                return ServiceResultErrorHandler.handleIllegalStateBug(serviceResult, "Could not handle flow: " + flowName);
        }
    }
}




