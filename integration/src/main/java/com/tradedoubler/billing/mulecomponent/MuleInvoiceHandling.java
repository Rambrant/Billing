package com.tradedoubler.billing.mulecomponent;

import com.tradedoubler.billing.platform.flowcontroller.ServiceResult;
import com.tradedoubler.billing.platform.flowcontroller.ServiceResultErrorHandler;
import com.tradedoubler.billing.service.crm.CrmService;
import com.tradedoubler.billing.service.crm.JsonValidatorService;
import com.tradedoubler.billing.service.pan.PanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* Mule component for triggering handling of the XML-invoice content
 */
@Component
public class MuleInvoiceHandling {

    private final static Logger log = LoggerFactory.getLogger(MuleInvoiceHandling.class);

    @Autowired
    private CrmService crmService;

    @Autowired
    private PanService panService;

    @Autowired
    private JsonValidatorService jsonValidatorService;

    public ServiceResult execute(ServiceResult serviceResult) {
        log.info(serviceResult.toStringShort());
        try {
            //No out-of-sequence handling is necessary here. Instead, Crm will keep track of the out-of-sequence of
            //the invoices. The time they use is from the time-stamp in the invoices' meta-header.
           if (serviceResult.isDisturbance()) {
                serviceResult = handleDisturbance(serviceResult);
            } else {

                if (serviceResult.getIntegrationMessage() != null && serviceResult.getIntegrationMessage().getDomainObject() != null) {
                    //Assume both forecast and invoice creations are ok
                    //First do validations
                    serviceResult = jsonValidatorService.validateCreateInvoice(serviceResult);
                    serviceResult = jsonValidatorService.validateUpdateForecast(serviceResult);

                    //Insert invoice to CRM
                    serviceResult = crmService.insertInvoice(serviceResult);

                    //Insert update forecasts to CRM
                    serviceResult = crmService.insertUpdateForecast(serviceResult);

                    //Handle invoice within Pan
                    serviceResult = panService.handleInvoiceForPan(serviceResult);

                }


            }
        }

        catch (Exception rex) {
            serviceResult = ServiceResultErrorHandler.handleException(serviceResult, rex.getMessage(), rex);
        }
        return serviceResult;
    }


    private ServiceResult handleDisturbance(ServiceResult serviceResult) {
        return serviceResult;
    }
}
