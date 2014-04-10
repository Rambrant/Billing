package com.tradedoubler.billing.transform.json;

import com.google.gson.Gson;
import com.tradedoubler.billing.domain.MetaData;
import com.tradedoubler.billing.platform.flowcontroller.IntegrationMessage;
import com.tradedoubler.billing.platform.flowcontroller.ServiceResult;
import com.tradedoubler.billing.platform.flowcontroller.ServiceResultErrorHandler;
import com.tradedoubler.billing.platform.logging.LogError;
import com.tradedoubler.billing.service.crm.JsonMessage;
import com.tradedoubler.billing.transform.json.gson.GsonFactory;
import org.mule.transformer.AbstractTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * This class contains the template for converting json messages to domain objects.
 *
 * @since 2012-08-15
 */
public abstract class BillingAbstractTransformer<T> extends AbstractTransformer {

    private final static Logger log = LoggerFactory.getLogger(BillingAbstractTransformer.class);

    private static final Gson gson = GsonFactory.getGson();

    /**
     * @param payload This must be a ServiceResult that contains the Json as raw data
     * @param enc     Not used in the conversion process (only specified by the interface)
     * @return the desired domain object
     */
    @Override
    public final Object doTransform(Object payload, String enc) {
        ServiceResult serviceResult = (ServiceResult) payload;
        JsonMessage jsonMessage = (JsonMessage) serviceResult.getRawData();

        log.info(String.format("Transforming to %s serviceResult: %s", getDomainClass().getSimpleName(), serviceResult.toStringShort()));

        T domainObject = gson.fromJson(jsonMessage.jsonString, getDomainClass());

        serviceResult = insertDomainObjectInServiceResult(serviceResult, domainObject, jsonMessage);

        return serviceResult;
    }

    private ServiceResult insertDomainObjectInServiceResult(ServiceResult serviceResult, T domainObject, JsonMessage jsonMessage) {
        if (domainObject == null) {
            serviceResult = ServiceResultErrorHandler.handleTransformationFail(serviceResult, getDomainClass(), jsonMessage);
        } else {
            if (log.isDebugEnabled()) {
                logDomainObjectAsJson(domainObject);
            }
            IntegrationMessage integrationMessage = new IntegrationMessage(
                    getEntityId(domainObject),
                    getMetaData(domainObject));
            integrationMessage.setDomainObject(domainObject);

            serviceResult.setIntegrationMessage(integrationMessage);
        }
        return serviceResult;
    }

    /**
     * Logs the serialized version of the the domain object. This is done to allow comparisons in the log to see that
     * the serialization worked.
     */
    private void logDomainObjectAsJson(T domainObject) {
        try {
            log.debug(String.format("Reversed json transformation from domain object %s json: %s",
                    getDomainClass(), gson.toJson(domainObject)));
        } catch (Exception e) {
            log.error(LogError.BUG_DISTURBANCE.name(), e);
            log.error("domain object: " + domainObject.toString());
        }
    }

    protected abstract Class<T> getDomainClass();

    protected abstract String getEntityId(T domainObject);

    protected abstract MetaData getMetaData(T domainObject);
}
