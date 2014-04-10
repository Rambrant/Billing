package com.tradedoubler.billing.service.pan;

import com.google.gson.Gson;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.platform.flowcontroller.IntegrationMessage;
import com.tradedoubler.billing.platform.flowcontroller.ServiceResult;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.ftp.AxInvoice;
import com.tradedoubler.billing.service.crm.JsonMessage;
import com.tradedoubler.billing.service.pan.handler.CommissionPanHandler;
import com.tradedoubler.billing.service.pan.handler.InvoicingRulePanHandler;
import com.tradedoubler.billing.service.pan.handler.OrderLinesPanHandler;
import com.tradedoubler.billing.transform.json.gson.GsonFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Service implementation for all interaction with the Pan system.
 *
 * @author bjoek
 * @since 2012-10-03
 */
public class PanServiceImpl implements PanService {
    @Autowired
    private CommissionPanHandler commissionPanHandler;

    @Autowired
    private OrderLinesPanHandler orderLinesHandler;

    @Autowired
    private InvoicingRulePanHandler invoicingRulePanHandler;

    private static final Gson gson = GsonFactory.getGson();

    /**
     * Updates the flag display TD commission in Pan. The operation uses the array sourceSystemAgreementIds under
     * InvoicingRule. This method is called both when updating and creating invoicing rule. When inserting invoicing rule
     * the array should only contain one value, the sourceSystemAgreementId of the accompanied agreement
     *
     * @param serviceResult containing a ContainsInvoicingRule
     * @return unmodified serviceResult
     * @throws BillingServiceException thrown if the operation fails
     */
    @Override
    public ServiceResult updateDisplayTradeDoublerCommission(ServiceResult serviceResult) throws BillingServiceException {
        ContainsInvoicingRule invoicingRuleUpdated = (ContainsInvoicingRule) serviceResult.getIntegrationMessage().getDomainObject();
        InvoicingRule invoicingRule = invoicingRuleUpdated.getInvoicingRule();
        List<String> sourceSystemAgreementIds = invoicingRule.getSourceSystemAgreementIds();

        for (String sourceSystemAgreementId : sourceSystemAgreementIds) {
            commissionPanHandler.updateDisplayTradeDoublerCommission(sourceSystemAgreementId, invoicingRule.isDisplayTradeDoublerCommission());
        }

        return serviceResult;
    }

    /**
     * Confirms in Pan that order lines have been inserted into the Ax system. The order lines are grouped together with
     * a batchId.
     *
     * @param serviceResult containing a OrderLinesCreated and has a batchId in commit info
     * @return unmodified serviceResult
     * @throws BillingServiceException thrown if the operation fails
     */
    @Override
    public ServiceResult confirmOrderLines(ServiceResult serviceResult) throws BillingServiceException {
        Guid batchId = (Guid) serviceResult.getCommitInfo();

        OrderLinesCreated orderLinesCreated = (OrderLinesCreated) serviceResult.getIntegrationMessage().getDomainObject();
        List<OrderLine> orderLines = orderLinesCreated.getOrderLines();
        List<OrderLineFailed> failedOrderLines = orderLinesHandler.filterFailedOrderLines(orderLines);

        orderLinesHandler.confirmOrderLines(batchId, failedOrderLines);

        return serviceResult;
    }

    /**
     * Confirms in Pan that prepayment order lines have been converted to forecasts and sent to Crm.
     *
     * @param serviceResult containing PrepaymentForecastUpdated and batchId as commit info
     * @return unmodified serviceResult
     * @throws BillingServiceException thrown if the operation fails
     */
    @Override
    public ServiceResult confirmForecastOrderLines(ServiceResult serviceResult) throws BillingServiceException {
        Guid batchId = (Guid) serviceResult.getCommitInfo();

        PrepaymentForecastUpdated prepaymentForecastUpdated = (PrepaymentForecastUpdated) serviceResult.getIntegrationMessage().getDomainObject();

        orderLinesHandler.confirmForecastOrderLines(batchId);

        return serviceResult;
    }


    /**
     * This method handles inserts and status changes of invoiced order lines to Pan. The rules behind how the invoices status determines
     * if Pan should be invoked or not is described in document (TODO: add document name)
     *
     * @param serviceResult
     * @return
     * @throws BillingServiceException thrown if the operation fails
     */
    @Override
    public ServiceResult handleInvoiceForPan(ServiceResult serviceResult) throws BillingServiceException {

        AxInvoice axInvoice = (AxInvoice) serviceResult.getIntegrationMessage().getDomainObject();

        //Insert invoiced order lines to PAN, if relevant
        if (axInvoice.doInsertForPan()) {
            orderLinesHandler.insertInvoicedOrderLines(axInvoice.getInvoicedOrderLines());
        }
        //Update invoice status in PAN, if relevant
        if (axInvoice.doInvoiceStatusChanged()) {
            //new status for pan. Can be PAID or WRITE_OFF (Bad debt)
            Event newStatus = Event.PAID;
            if (axInvoice.getInvoice().getEvent() == Event.WRITE_OFF) {
                newStatus = Event.WRITE_OFF;
            }

            //Provide the Original Invoice ID to Pan, if it exists, otherwise the invoice's id
            if (axInvoice.getInvoice().getOriginalInvoiceId() != null && !axInvoice.getInvoice().getOriginalInvoiceId().trim().isEmpty()) {
                orderLinesHandler.setInvoiceStatusChanged(axInvoice.getInvoice().getOriginalInvoiceId(), newStatus);
            } else {
                orderLinesHandler.setInvoiceStatusChanged(axInvoice.getInvoice().getInvoiceId(), newStatus);
            }

        }

        return serviceResult;
    }

    /**
     * Fetches created reseller customer invoicing rules from PAN.
     *
     * @param serviceResult
     * @return
     * @throws BillingServiceException thrown if the operation fails
     */
    @Override
    public ServiceResult fetchCreatedInvoicingRule(ServiceResult serviceResult) throws BillingServiceException {

        InvoicingRuleCreated invoicingRuleCreated = invoicingRulePanHandler.fetchCreatedInvoicingRule();

        if (invoicingRuleCreated != null){

            // Set the information that is used to confirm that the invoicing rule has been processed
            serviceResult.setCommitInfo(invoicingRuleCreated);

            // Create a json representation of the java object and set it as raw data
            JsonMessage jsonMessage = new JsonMessage(gson.toJson(invoicingRuleCreated));
            serviceResult.setRawData(jsonMessage);

            // Set the integration message that will be used in the flow
            IntegrationMessage integrationMessage = new IntegrationMessage(invoicingRuleCreated.getMetaData().getMessageId().getGuid(),
                    invoicingRuleCreated.getMetaData());
            integrationMessage.setDomainObject(invoicingRuleCreated);
            serviceResult.setIntegrationMessage(integrationMessage);
        }else {
            serviceResult.setCommitInfo(null);
            serviceResult.setRawData(null);
        }

        return serviceResult;
    }

    /**
     * Fetches updated reseller customer invoicing rules from PAN.
     *
     * @param serviceResult
     * @return
     * @throws BillingServiceException thrown if the operation fails
     */
    @Override
    public ServiceResult fetchUpdatedInvoicingRule(ServiceResult serviceResult) throws BillingServiceException {

        ResellerInvoicingRuleUpdated invoicingRuleUpdated = invoicingRulePanHandler.fetchUpdatedInvoicingRule();

        if (invoicingRuleUpdated != null){

            serviceResult.setCommitInfo(invoicingRuleUpdated);

            // Create a json representation of the java object and set it as raw data
            JsonMessage jsonMessage = new JsonMessage(gson.toJson(invoicingRuleUpdated.getInvoicingRuleUpdated()));
            serviceResult.setRawData(jsonMessage);

            // Set the integration message that will be used in the flow
            IntegrationMessage integrationMessage = new IntegrationMessage(invoicingRuleUpdated.getMetaData().getMessageId().getGuid(),
                    invoicingRuleUpdated.getMetaData());
            integrationMessage.setDomainObject(invoicingRuleUpdated.getInvoicingRuleUpdated());
            serviceResult.setIntegrationMessage(integrationMessage);
        }else {
            serviceResult.setCommitInfo(null);
            serviceResult.setRawData(null);
        }

        return serviceResult;
    }



    /**
     * Confirms to adminDb that a reseller invoicing rule creation/update has been delivered to AX successfully.
     *
     * @param serviceResult containing a resellerInvoiceRuleEventGuid as messageId in MetaData
     * @return unmodified serviceResult
     * @throws BillingServiceException thrown if the operation fails
     */
    @Override
    public ServiceResult confirmInvoicingRuleProcessed(ServiceResult serviceResult) throws BillingServiceException {

        invoicingRulePanHandler.confirmInvoicingRuleProcessed(serviceResult.getIntegrationMessage().getMetaData().getMessageId().getGuidForOracleDb());

        return serviceResult;
    }





    /**
     * Fetches a batch of order lines from Pan. The order lines are grouped together with a batchId. If there are
     * order lines to fetch, then the returning service result will contain raw data, integration message,
     * OrderLinesCreated as domain object and batchId as commit info.
     *
     * @param serviceResult an empty serviceResult
     * @return a service result with the fetched order lines or empty service result if no order lines to fetch
     * @throws BillingServiceException thrown if the operation fails
     */
    @Override
    public ServiceResult fetchOrderLines(ServiceResult serviceResult) throws BillingServiceException {
        OrderLinesCreated orderLinesCreated = orderLinesHandler.fetchOrderLinesCreated();

        List<OrderLine> orderLines = orderLinesCreated.getOrderLines();

        if (!orderLines.isEmpty()) {
            orderLinesHandler.checkMaxNumberOfOrderLines(orderLines);
            orderLines = orderLinesHandler.setDebitAndCredit(orderLines);
            serviceResult = insertInServiceResult(serviceResult, orderLinesCreated);

        } else {
            serviceResult.setCommitInfo(null);
            serviceResult.setRawData(null);
        }

        return serviceResult;

    }

    /**
     * Check if Pan allows Ax to start the invoicing job. The invoicing job should only be started one a day and a
     * precondition is that all order lines have been fetched and inserted in Ax. If the invoicing job should start then
     * the returning service result will contain raw data, integration message, ReadyToInvoice as domain object and
     * true as commit info
     *
     * @param serviceResult an empty service result
     * @return a service result containing ReadyToInvoice data or empty service result if invoicing job should not start
     * @throws BillingServiceException
     */
    @Override
    public ServiceResult fetchReadyToInvoice(final ServiceResult serviceResult) throws BillingServiceException {
        ReadyToInvoice readyToInvoice = orderLinesHandler.fetchReadyToInvoice();

        if (readyToInvoice.isReadyToInvoice()) {
            serviceResult.setCommitInfo(true);

            JsonMessage jsonMessage = new JsonMessage(gson.toJson(readyToInvoice));
            serviceResult.setRawData(jsonMessage);

            // Set the integration message that will be used in the flow
            MetaData metaData = readyToInvoice.getMetaData();
            IntegrationMessage integrationMessage = new IntegrationMessage(metaData.getMessageId().getGuid(),
                    metaData);
            integrationMessage.setDomainObject(readyToInvoice);

            serviceResult.setIntegrationMessage(integrationMessage);
        } else {
            serviceResult.setCommitInfo(null);
            serviceResult.setRawData(null);
        }

        return serviceResult;

    }

    /**
     * Confirm in Pan that the invoicing job has been started in Ax
     *
     * @param serviceResult not used
     * @return unmodified serviceResult
     * @throws BillingServiceException thrown if the operation fails
     */
    @Override
    public ServiceResult confirmInvoicingStarted(ServiceResult serviceResult) throws BillingServiceException {
        orderLinesHandler.confirmInvoicingStarted();

        return serviceResult;
    }

    /**
     * Fetches a batch of prepayment order lines from Pan. The order lines are grouped together with a batchId and they are
     * used to create forecasts for Crm.
     * If there are order lines to fetch, then the returning service result will contain raw data, integration message,
     * OrderLinesCreated as domain object and batchId as commit info.
     *
     * @param serviceResult an empty serviceResult
     * @return a service result with the fetched order lines or empty service result if no order lines to fetch
     * @throws BillingServiceException thrown if the operation fails
     */
    @Override
    public ServiceResult fetchPrepaymentForecastOrderLines(ServiceResult serviceResult) throws BillingServiceException {
        PrepaymentForecastUpdated prepaymentForecastUpdated = orderLinesHandler.fetchPrepaymentForecastMessage();

        List<PrepaymentOrderLine> orderLines = prepaymentForecastUpdated.getOrderLines();

        if (!orderLines.isEmpty()) {
            serviceResult = insertInServiceResult(serviceResult, prepaymentForecastUpdated);
        } else {
            serviceResult.setCommitInfo(null);
            serviceResult.setRawData(null);
            serviceResult.setIntegrationMessage(null);
        }

        return serviceResult;

    }

    private ServiceResult insertInServiceResult(ServiceResult serviceResult, ContainsBatchInfo orderLinesCreated) {
        Guid batchId = orderLinesCreated.getBatchId();

        // Set the information that is used to confirm the order lines
        serviceResult.setCommitInfo(batchId);

        // Create a json representation of the java object and set it as raw data
        JsonMessage jsonMessage = new JsonMessage(gson.toJson(orderLinesCreated));
        serviceResult.setRawData(jsonMessage);

        // Set the integration message that will be used in the flow
        IntegrationMessage integrationMessage = new IntegrationMessage(batchId.getGuid(),
                orderLinesCreated.getMetaData());
        integrationMessage.setDomainObject(orderLinesCreated);

        serviceResult.setIntegrationMessage(integrationMessage);

        return serviceResult;
    }

    /**
     * Fetches a reseller client from Pan. The reseller was created or updated in Pan
     *
     * @param serviceResult an empty serviceResult
     * @return a service result with the fetched client or empty service result if no reseller was changed
     * @throws BillingServiceException thrown if the operation fails
     */
    @Override
    public ServiceResult fetchResellerClient(ServiceResult serviceResult) throws BillingServiceException {
        ResellerClientUpdated resellerClientUpdated = invoicingRulePanHandler.getUpdatedOrCreatedReseller();

        if (resellerClientUpdated != null){

            // Set the information that is used to confirm that the invoicing rule has been processed
            serviceResult.setCommitInfo(resellerClientUpdated);

            // Create a json representation of the java object and set it as raw data
            JsonMessage jsonMessage = new JsonMessage(gson.toJson(resellerClientUpdated));
            serviceResult.setRawData(jsonMessage);

            // Set the integration message that will be used in the flow
            IntegrationMessage integrationMessage = new IntegrationMessage(resellerClientUpdated.getMetaData().getMessageId().getGuid(),
                    resellerClientUpdated.getMetaData());
            integrationMessage.setDomainObject(resellerClientUpdated);
            serviceResult.setIntegrationMessage(integrationMessage);
        }else {
            serviceResult.setCommitInfo(null);
            serviceResult.setRawData(null);
        }

        return serviceResult;
    }

    /**
     * Confirms to adminDb that a reseller client creation/update has been delivered to AX successfully.
     *
     * @param serviceResult containing a resellerClientEventGuid as messageId in MetaData
     * @return unmodified serviceResult
     * @throws BillingServiceException thrown if the operation fails
     */
    @Override
    public ServiceResult confirmResellerClientProcessed(ServiceResult serviceResult) throws BillingServiceException {

        Guid resellerClientEventGuid = serviceResult.getIntegrationMessage().getMetaData().getMessageId();
        invoicingRulePanHandler.confirmResellerClientProcessed(resellerClientEventGuid);

        return serviceResult;
    }


}
