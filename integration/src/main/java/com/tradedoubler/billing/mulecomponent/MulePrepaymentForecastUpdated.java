package com.tradedoubler.billing.mulecomponent;

import com.tradedoubler.billing.platform.flowcontroller.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.crm.*;
import com.tradedoubler.billing.service.pan.PanService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * This is the mule business component that calculates prepayment forecast from order lines,
 * sends them to Crm and then confirms the order lines in Pan.
 *
 * @since 2012-06-12
 */
@Component
public class MulePrepaymentForecastUpdated {

    private final static Logger log = LoggerFactory.getLogger(MulePrepaymentForecastUpdated.class);

    @Autowired
    private CrmService crmService;

    @Autowired
    private PanService panService;

    @Autowired
    private JsonValidatorService jsonValidatorService;

    public ServiceResult execute(ServiceResult serviceResult) {
        log.info(serviceResult.toStringShort());
        try {
            if (serviceResultIsOk(serviceResult)) {
                serviceResult = crmService.calculatePrepaymentForecasts(serviceResult);
                serviceResult = crmService.transformPrepaymentForecasts(serviceResult);
                serviceResult = jsonValidatorService.validateUpdatePrepaymentForecast(serviceResult);
                if (serviceResult.isDisturbance()) {
                    return serviceResult;
                }
                serviceResult = crmService.insertPrepaymentForecast(serviceResult);
                serviceResult = panService.confirmForecastOrderLines(serviceResult);
            }
        } catch (BillingServiceException bse) {
            serviceResult = ServiceResultErrorHandler.handleBillingException(serviceResult, bse, "Failed to process prepayment forecasts");
        } catch (Exception rex) {
            serviceResult = ServiceResultErrorHandler.handleException(serviceResult, "Failed to process prepayment forecasts", rex);
        }
        return serviceResult;
    }

    private boolean serviceResultIsOk(ServiceResult serviceResult) {
        return !serviceResult.getIntegrationMessage().isOutOfSequence() && !serviceResult.isDisturbance();
    }
}
