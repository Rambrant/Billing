package com.tradedoubler.billing.fetch;

import com.tradedoubler.billing.platform.flowcontroller.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.pan.PanService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * This mule component is used to fetch the different input, from Pan, for the flows.
 *
 * @since 2012-06-12
 */
@Component
public class FetchPanEntity {

    private final static Logger log = LoggerFactory.getLogger(FetchPanEntity.class);

    @Autowired
    private PanService service;

    public ServiceResult execute(ServiceResult serviceResult) {
        log.info(serviceResult.toStringShort());
        try {
            serviceResult = fetchFromService(serviceResult);
        } catch (BillingServiceException bse) {
            serviceResult = ServiceResultErrorHandler.handleBillingException(serviceResult, bse, "Fetching from Pan failed");
        } catch (Exception rex) {
            serviceResult = ServiceResultErrorHandler.handleException(serviceResult, "Fetching from Pan", rex);
        }
        log.debug("Exiting, serviceResult: " + serviceResult.toStringShort());
        return serviceResult;
    }

    private ServiceResult fetchFromService(ServiceResult serviceResult) throws BillingServiceException {
        FlowName flowName = serviceResult.getFlowName();

        switch (flowName) {
            case CreateOrderLinesPan:
                return service.fetchOrderLines(serviceResult);
            case UpdatePrepaymentForecastPan:
                return service.fetchPrepaymentForecastOrderLines(serviceResult);
            case StartAxInvoicingPan:
                return service.fetchReadyToInvoice(serviceResult);
            case CreateInvoicingRulePan:
                return service.fetchCreatedInvoicingRule(serviceResult);
            case UpdateInvoicingRulePan:
                return service.fetchUpdatedInvoicingRule(serviceResult);
            case UpdateResellerClientPan:
                return service.fetchResellerClient(serviceResult);
            default:
                return ServiceResultErrorHandler.handleIllegalStateBug(serviceResult, "Could not handle flow: " + flowName);
        }
    }
}




