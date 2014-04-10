package com.tradedoubler.billing.service.crm;

import com.tradedoubler.billing.domain.Event;
import com.tradedoubler.billing.domain.PrepaymentForecastUpdated;
import com.tradedoubler.billing.domain.PrepaymentOrderLine;
import com.tradedoubler.billing.domain.UpdateForecast;
import com.tradedoubler.billing.fetch.FlowName;
import com.tradedoubler.billing.platform.flowcontroller.ServiceResult;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ParameterUtil;
import com.tradedoubler.billing.service.ax.ftp.AxInvoice;
import com.tradedoubler.billing.service.crm.azure.AzureMessage;
import com.tradedoubler.billing.service.crm.azure.AzureToJsonMessageTransformer;
import com.tradedoubler.billing.service.crm.azure.JsonToAzureMessageTransformer;
import com.tradedoubler.billing.service.crm.call.AzureCallFactory;
import com.tradedoubler.billing.service.crm.call.DeleteMessageCall;
import com.tradedoubler.billing.service.crm.call.FetchMessageCall;
import com.tradedoubler.billing.service.crm.call.PutMessageCall;
import com.tradedoubler.billing.service.crm.handler.ForecastCalculator;
import com.tradedoubler.billing.transform.ftp.InvoicedOrderLinesToCRMUpdateForecastTransformer;
import com.tradedoubler.billing.transform.json.UpdateForecastToJsonTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.List;


/**
 * Represents the interface for working against the Azure Storage. Each interface method accept a ServiceResult object
 * which handles the Azure message within its commitInfo object.<br>
 * The Spring injected AzureServiceSetup contains setup information like Queue-names.
 * <p/>
 * Date: 2012-06-13
 */
public class CrmServiceImpl implements CrmService {
    private final static Logger log = LoggerFactory.getLogger(CrmServiceImpl.class);

    @Autowired
    private AzureCallFactory callFactory;

    @Autowired
    private UpdateForecastToJsonTransformer updateForecastToJsonTransformer;

    @Value("${AZURE_QUEUE_INVOICING_UPDATED}")
    private String queueSalesInvoicingRuleUpdated;

    @Value("${AZURE_QUEUE_INVOICING_CREATED}")
    private String queueSalesInvoicingRuleCreated;

    @Value("${AZURE_QUEUE_AGREEMENT_UPDATED}")
    private String queueAgreementUpdated;

    @Value("${AZURE_QUEUE_CLIENT_UPDATED}")
    private String queueClientUpdated;

    @Value("${AZURE_QUEUE_SPLITTING_RULE_DELETED}")
    private String queueSplittingRuleDeleted;

    @Value("${AZURE_QUEUE_INVOICE_RECIPIENT_DELETED}")
    private String queueInvoiceRecipientDeleted;

    @Value("${AZURE_QUEUE_MARKET_MESSAGE_UPDATED}")
    private String queueMarketMessageUpdated;

    @Value("${AZURE_QUEUE_UPDATE_FORECAST}")
    private String queueUpdateForecast;

    @Value("${AZURE_QUEUE_CREATE_INVOICE_INFORMATION}")
    private String queueCreateInvoice;

    @Value("${AZURE_QUEUE_UPDATE_INVOICE_INFORMATION}")
    private String queueUpdateInvoice;


    @PostConstruct
    private void setup() {
        log.debug("Check all parameters that are populated from properties");
        ParameterUtil.checkParameter(queueSalesInvoicingRuleUpdated);
        ParameterUtil.checkParameter(queueSalesInvoicingRuleCreated);
        ParameterUtil.checkParameter(queueAgreementUpdated);
        ParameterUtil.checkParameter(queueClientUpdated);
        ParameterUtil.checkParameter(queueSplittingRuleDeleted);
        ParameterUtil.checkParameter(queueInvoiceRecipientDeleted);
        ParameterUtil.checkParameter(queueMarketMessageUpdated);
        ParameterUtil.checkParameter(queueUpdateForecast);
        ParameterUtil.checkParameter(queueCreateInvoice);
        ParameterUtil.checkParameter(queueUpdateInvoice);
    }


    @Autowired
    private AzureToJsonMessageTransformer azureToJsonMessageTransformer;

    @Autowired
    private JsonToAzureMessageTransformer jsonToAzureMessageTransformer;

    /**
     * Delete message from queue. Message identification is taken from commitInfo in serviceResult
     *
     * @param serviceResult with an AzureMessage in commitInfo
     * @return unmodified serviceResult regardless of success status
     * @throws BillingServiceException thrown if service call fails
     */
    @Override
    public ServiceResult deleteOriginalMessage(ServiceResult serviceResult) throws BillingServiceException {
        AzureMessage message = (AzureMessage) serviceResult.getCommitInfo();

        DeleteMessageCall call = callFactory.createCall(DeleteMessageCall.class);
        call.deleteMessage(message, serviceResult.getFlowName());

        return serviceResult;
    }

    /**
     * Calculate forecasts from order lines.
     *
     * @param serviceResult containing a PrepaymentForecastUpdated
     * @return serviceResult with an updated PrepaymentForecastUpdated containing UpdateForecast
     * @throws BillingServiceException thrown if service call fails
     */
    @Override
    public ServiceResult calculatePrepaymentForecasts(ServiceResult serviceResult) throws BillingServiceException {
        PrepaymentForecastUpdated prepaymentForecastUpdated = (PrepaymentForecastUpdated) serviceResult.getIntegrationMessage().getDomainObject();
        List<PrepaymentOrderLine> orderLines = prepaymentForecastUpdated.getOrderLines();

        Collection<UpdateForecast> forecasts = new ForecastCalculator(orderLines,
                prepaymentForecastUpdated.getBatchId(),
                prepaymentForecastUpdated.getMetaData().getVersion(),
                prepaymentForecastUpdated.getMetaData().getSourceSystem()).calculate();

        log.info(String.format("Calculating prepayment forecasts: %d order lines became %d forecasts", orderLines.size(), forecasts.size()));

        prepaymentForecastUpdated.setForecastUpdates(forecasts);

        return serviceResult;
    }

    /**
     * TODO
     *
     * @param serviceResult containing a AxInvoice
     * @return unmodified serviceResult regardless of success status
     * @throws BillingServiceException thrown if service call fails
     */
    @Override
    public ServiceResult insertInvoice(ServiceResult serviceResult) throws BillingServiceException {
        AxInvoice axInvoice = (AxInvoice) serviceResult.getIntegrationMessage().getDomainObject();
        if (!axInvoice.isMigratedInvoice()) {
            JsonMessage invoiceJson = axInvoice.getInvoiceJson();

            FlowName flowName = serviceResult.getFlowName();

            PutMessageCall call = callFactory.createCall(PutMessageCall.class);

            String queue = (axInvoice.getInvoice().getEvent() == Event.POSTED) ? queueCreateInvoice : queueUpdateInvoice;
            AzureMessage message = jsonToAzureMessageTransformer.doTransform(invoiceJson, queue);

            call.putMessageInQueue(message, flowName);
        }

        return serviceResult;
    }

    /**
     * Transform List of UpdateForecast to List of JsonMessage.
     *
     * @param serviceResult containing a PrepaymentForecastUpdated
     * @return serviceResult with an updated PrepaymentForecastUpdated containing JsonMessages
     */
    @Override
    public ServiceResult transformPrepaymentForecasts(ServiceResult serviceResult) {
        log.debug("Transforming prepayment forecasts");
        PrepaymentForecastUpdated prepaymentForecastUpdated = (PrepaymentForecastUpdated) serviceResult.getIntegrationMessage().getDomainObject();
        Collection<UpdateForecast> forecastUpdates = prepaymentForecastUpdated.getForecastUpdates();

        log.info(String.format("Transforming %d UpdateForecasts to json, serviceResult: %s", forecastUpdates.size(), serviceResult.toStringShort()));

        List<JsonMessage> jsonMessages = updateForecastToJsonTransformer.doTransform(forecastUpdates);

        prepaymentForecastUpdated.setForecastUpdatesJson(jsonMessages);

        return serviceResult;
    }

    /**
     * Inserts updated forecast to Crm. One per agreement.
     *
     * @param serviceResult containing an AxInvoice
     * @return unmodified serviceResult regardless of success status
     * @throws BillingServiceException thrown if service call fails
     */
    public ServiceResult insertUpdateForecast(ServiceResult serviceResult) throws BillingServiceException {
        AxInvoice axInvoice = (AxInvoice) serviceResult.getIntegrationMessage().getDomainObject();

        if (!axInvoice.isMigratedInvoice()) {
            InvoicedOrderLinesToCRMUpdateForecastTransformer invoicedOrderLinesToCRMUpdateForecastJson = new InvoicedOrderLinesToCRMUpdateForecastTransformer(axInvoice.getInvoicedOrderLines(), axInvoice.getMetaData());
            invoicedOrderLinesToCRMUpdateForecastJson.execute();

            List<JsonMessage> updateForecasts = invoicedOrderLinesToCRMUpdateForecastJson.getListOfUpdatedForecastJson();

            FlowName flowName = serviceResult.getFlowName();

            PutMessageCall call = callFactory.createCall(PutMessageCall.class);

            for (JsonMessage jsonMessage : updateForecasts) {
                AzureMessage message = jsonToAzureMessageTransformer.doTransform(jsonMessage, queueUpdateForecast);

                call.putMessageInQueue(message, flowName);
            }
        }

        return serviceResult;

    }

    /**
     * Puts several prepayment forecast messages on the Azure queue.
     *
     * @param serviceResult containing a PrepaymentForecastUpdated
     * @return unmodified serviceResult regardless of success status
     * @throws BillingServiceException thrown if service call fails
     */
    @Override
    public ServiceResult insertPrepaymentForecast(ServiceResult serviceResult) throws BillingServiceException {
        PrepaymentForecastUpdated prepaymentForecastUpdated = (PrepaymentForecastUpdated) serviceResult.getIntegrationMessage().getDomainObject();
        List<JsonMessage> forecastUpdatesJson = prepaymentForecastUpdated.getForecastUpdatesJson();
        FlowName flowName = serviceResult.getFlowName();

        log.debug(String.format("Inserting %d json forecasts in azure queue", forecastUpdatesJson.size()));

        PutMessageCall call = callFactory.createCall(PutMessageCall.class);

        for (JsonMessage jsonMessage : forecastUpdatesJson) {
            AzureMessage message = jsonToAzureMessageTransformer.doTransform(jsonMessage, queueUpdateForecast);

            call.putMessageInQueue(message, flowName);
        }

        return serviceResult;
    }

    /**
     * Fetches next message from the agreement-updated-queue as defined in billing-integration.properties
     *
     * @param serviceResult containing a correct flowName
     * @return a serviceResult with rawData and commitInfo filled in
     * @throws BillingServiceException thrown if service call fails
     */
    @Override
    public ServiceResult fetchAgreementUpdated(ServiceResult serviceResult) throws BillingServiceException {
        return fetchMessage(serviceResult, queueAgreementUpdated);
    }

    /**
     * Fetches next message from the invoicing-created-queue as defined in billing-integration.properties
     *
     * @param serviceResult containing a correct flowName
     * @return a serviceResult with rawData and commitInfo filled in
     * @throws BillingServiceException thrown if service call fails
     */
    @Override
    public ServiceResult fetchInvoicingRuleCreated(ServiceResult serviceResult) throws BillingServiceException {
        return fetchMessage(serviceResult, queueSalesInvoicingRuleCreated);
    }

    /**
     * Fetches next message from the invoicing-updated-queue as defined in billing-integration.properties
     *
     * @param serviceResult containing a correct flowName
     * @return a serviceResult with rawData and commitInfo filled in
     * @throws BillingServiceException thrown if service call fails
     */
    @Override
    public ServiceResult fetchInvoicingRuleUpdated(ServiceResult serviceResult) throws BillingServiceException {
        return fetchMessage(serviceResult, queueSalesInvoicingRuleUpdated);
    }

    /**
     * Fetches next message from the client-updated-queue as defined in billing-integration.properties
     *
     * @param serviceResult containing a correct flowName
     * @return a serviceResult with rawData and commitInfo filled in
     * @throws BillingServiceException thrown if service call fails
     */
    @Override
    public ServiceResult fetchClientUpdated(ServiceResult serviceResult) throws BillingServiceException {
        return fetchMessage(serviceResult, queueClientUpdated);
    }

    /**
     * Fetches next message from the splitting-rule-deleted-queue as defined in billing-integration.properties
     *
     * @param serviceResult containing a correct flowName
     * @return a serviceResult with rawData and commitInfo filled in
     * @throws BillingServiceException thrown if service call fails
     */
    @Override
    public ServiceResult fetchSplittingRuleDeleted(ServiceResult serviceResult) throws BillingServiceException {
        return fetchMessage(serviceResult, queueSplittingRuleDeleted);
    }

    /**
     * Fetches next message from the invoice-recipient-deleted-queue as defined in billing-integration.properties
     *
     * @param serviceResult containing a correct flowName
     * @return a serviceResult with rawData and commitInfo filled in
     * @throws BillingServiceException thrown if service call fails
     */
    @Override
    public ServiceResult fetchInvoiceRecipientDeleted(ServiceResult serviceResult) throws BillingServiceException {
        return fetchMessage(serviceResult, queueInvoiceRecipientDeleted);
    }

    /**
     * Fetches next message from the market-message-updated-queue as defined in billing-integration.properties
     *
     * @param serviceResult containing a correct flowName
     * @return a serviceResult with rawData and commitInfo filled in
     * @throws BillingServiceException thrown if service call fails
     */
    @Override
    public ServiceResult fetchMarketMessageUpdated(ServiceResult serviceResult) throws BillingServiceException {
        return fetchMessage(serviceResult, queueMarketMessageUpdated);
    }

    private ServiceResult fetchMessage(ServiceResult serviceResult, String queueName) throws BillingServiceException {
        FlowName flowName = serviceResult.getFlowName();

        FetchMessageCall call = callFactory.createCall(FetchMessageCall.class);
        AzureMessage retrievedMessage = call.fetchMessage(queueName, flowName);

        if (retrievedMessage != null) {
            serviceResult.setCommitInfo(retrievedMessage);
            JsonMessage jsonMessage = azureToJsonMessageTransformer.doTransform(retrievedMessage, flowName);
            serviceResult.setRawData(jsonMessage);
        } else {
            serviceResult.setCommitInfo(null);
            serviceResult.setRawData(null);
        }

        return serviceResult;

    }
}

