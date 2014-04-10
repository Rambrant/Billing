package com.tradedoubler.billing.service.crm;

import com.tradedoubler.billing.domain.Event;
import com.tradedoubler.billing.domain.PrepaymentForecastUpdated;
import com.tradedoubler.billing.platform.flowcontroller.ServiceResult;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ParameterUtil;
import com.tradedoubler.billing.service.ax.ftp.AxInvoice;
import com.tradedoubler.billing.service.ax.ftp.handler.InvoiceStatus;
import com.tradedoubler.billing.transform.ftp.InvoicedOrderLinesToCRMUpdateForecastTransformer;
import com.tradedoubler.billing.validate.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/** Service for validation json within the invoice handling. The validation json schemas are provided in the property-file. */
@Component
public class JsonValidatorService {

    private final static Logger log = LoggerFactory.getLogger(JsonValidatorService.class);

    @Autowired
    private Validator validator = new Validator();

    @Value("${UPDATE_FORECAST_SCHEMA}")
    private String updateForecastSchema;

    @Value("${CREATE_INVOICE_SCHEMA}")
    private String createInvoiceSchema;

    @Value("${UPDATE_INVOICE_SCHEMA}")
    private String updateInvoiceSchema;


    /** Check that parameters are set from spring properties */
    @PostConstruct
    public void setUp() {
        ParameterUtil.checkParameter(updateForecastSchema);
        ParameterUtil.checkParameter(createInvoiceSchema);
        ParameterUtil.checkParameter(updateInvoiceSchema);
    }

    /**
     * TODO: Doc
     *
     * @param serviceResult
     * @return
     * @throws BillingServiceException
     */
    public ServiceResult validateUpdateForecast(ServiceResult serviceResult) throws BillingServiceException {

        log.info(serviceResult.toStringShort());
        AxInvoice axInvoice = (AxInvoice) serviceResult.getIntegrationMessage().getDomainObject();

        if (!axInvoice.isMigratedInvoice()) { //No need to validate for migrated invoices
            InvoicedOrderLinesToCRMUpdateForecastTransformer invoicedOrderLinesToCRMUpdateForecastJson = new InvoicedOrderLinesToCRMUpdateForecastTransformer(axInvoice.getInvoicedOrderLines(), axInvoice.getMetaData());
            invoicedOrderLinesToCRMUpdateForecastJson.execute();

            List<JsonMessage> updateForecasts = invoicedOrderLinesToCRMUpdateForecastJson.getListOfUpdatedForecastJson();

            //Validation of each update forecast message. If one fails all fail.
            for (JsonMessage jsonMessage : updateForecasts) {
                serviceResult = validator.validate(serviceResult, jsonMessage.jsonString, updateForecastSchema);
            }
            if (serviceResult.isBugDisturbance()) {
                axInvoice.setInvoiceStatus(InvoiceStatus.INVOICE_HAS_ERROR_IN_FORECAST_VALIDATION);
                throw BillingServiceException.createBugDisturbance(serviceResult.getErrorMessage());

            }

            log.debug("Exiting, serviceResult: " + serviceResult.toStringShort());
        }
        return serviceResult;
    }

    /**
     * Validate that the prepayment forecast, to Crm, has correct Json
     *
     * @param serviceResult containing PrepaymentForecastUpdated
     * @return unmodified service result if ok or service result with bug disturbance of validation fails
     * @throws BillingServiceException throw if json schema cannot be read
     */
    public ServiceResult validateUpdatePrepaymentForecast(ServiceResult serviceResult) throws BillingServiceException {
        log.info(serviceResult.toStringShort());

        PrepaymentForecastUpdated prepaymentForecastUpdated = (PrepaymentForecastUpdated) serviceResult.getIntegrationMessage().getDomainObject();

        List<JsonMessage> updateForecasts = prepaymentForecastUpdated.getForecastUpdatesJson();

        log.debug(String.format("Validating %d json forecasts", updateForecasts.size()));

        //Validation of each update forecast message. If one fails all fail.
        for (JsonMessage jsonMessage : updateForecasts) {
            serviceResult = validator.validate(serviceResult, jsonMessage.jsonString, updateForecastSchema);
        }

        log.debug("Exiting, serviceResult: " + serviceResult.toStringShort());
        return serviceResult;
    }

    /**
     * TODO: doc
     * @param serviceResult
     * @return
     * @throws BillingServiceException
     */
    public ServiceResult validateCreateInvoice(ServiceResult serviceResult) throws BillingServiceException {

        AxInvoice axInvoice = (AxInvoice) serviceResult.getIntegrationMessage().getDomainObject();

        if (!axInvoice.isMigratedInvoice()) { //No need to validate for migrated invoices

            JsonMessage invoiceJson = axInvoice.getInvoiceJson();

            String jsonString = invoiceJson.jsonString;

            if (axInvoice.getInvoice().getEvent() == Event.POSTED) {
                serviceResult = validator.validate(serviceResult, jsonString, createInvoiceSchema);
            } else {
                serviceResult = validator.validate(serviceResult, jsonString, updateInvoiceSchema);
            }

            //If SeviceResult is a bug disturbance then throw a an exception indicating a bug-disturbance.
            if (serviceResult.isBugDisturbance()) {
                axInvoice.setInvoiceStatus(InvoiceStatus.INVOICE_HAS_ERROR_IN_INVOICE_VALIDATION);
                throw BillingServiceException.createBugDisturbance(serviceResult.getErrorMessage());
            }
        }

        return serviceResult;
    }


}

