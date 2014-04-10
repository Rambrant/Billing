package com.tradedoubler.billing.validate;

import com.tradedoubler.billing.domain.PrepaymentForecastUpdated;
import com.tradedoubler.billing.platform.flowcontroller.ServiceResult;
import com.tradedoubler.billing.platform.flowcontroller.ServiceResultErrorHandler;
import com.tradedoubler.billing.service.crm.JsonMessage;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.processor.MessageProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Mule message processor used to validate an update forecast Json messages against a specific Json schema.
 * Schema must follow the Json schema spec from: http://tools.ietf.org/html/draft-zyp-com.tradedoubler.billing.common.validation-schema-03
 * The incoming message must have a payload of type String (Json formatted).
 * <p/>
 * If the validation succeeds, the original Mule message (ServiceResult payload) will just be propagated through the processor without any changes.
 * If the validation fails, the message returned will instead have a payload of type ServiceResult that contains the errors.
 */
public class UpdateForecastJsonValidationProcessor implements MessageProcessor {

    private final static Logger log = LoggerFactory.getLogger(UpdateForecastJsonValidationProcessor.class);

    @Autowired
    private Validator validator;
    private String jsonSchemaPath;

    @Override
    public MuleEvent process(MuleEvent event) throws MuleException {
        ServiceResult serviceResult = getServiceResult(event);
        log.info(serviceResult.toStringShort());

        PrepaymentForecastUpdated prepaymentForecastUpdated = (PrepaymentForecastUpdated) serviceResult.getIntegrationMessage().getDomainObject();
        List<JsonMessage> forecastUpdatesJson = prepaymentForecastUpdated.getForecastUpdatesJson();

        try {
            for (JsonMessage jsonMessage : forecastUpdatesJson) {
                serviceResult = validator.validate(serviceResult, jsonMessage.jsonString, jsonSchemaPath);
            }
        } catch (Exception rex) {
            serviceResult = ServiceResultErrorHandler.handleJsonValidationFail(serviceResult, "Validating Json", rex);
        }

        event.getMessage().setPayload(serviceResult);

        log.debug("Exiting, serviceResult: " + serviceResult.toStringShort());
        return event;
    }

    ServiceResult getServiceResult(MuleEvent event) {
        Object payload = event.getMessage().getPayload();
        if (payload instanceof ServiceResult) {
            return (ServiceResult) payload;
        }
        return null;
    }


    public void setJsonSchemaPath(String jsonSchemaPath) {

        this.jsonSchemaPath = jsonSchemaPath;
    }
}

