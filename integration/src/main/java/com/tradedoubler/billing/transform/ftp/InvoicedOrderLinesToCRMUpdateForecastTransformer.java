package com.tradedoubler.billing.transform.ftp;

import com.google.gson.Gson;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.crm.JsonMessage;
import com.tradedoubler.billing.transform.json.gson.GsonFactory;
import com.tradedoubler.billing.validate.GUIDValidator;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.tradedoubler.billing.transform.ftp.SalesParts.*;

/**
 * This class transforms invoiced order lines domain objects into update forecasts for CRM.
 */
public class InvoicedOrderLinesToCRMUpdateForecastTransformer {
    private final static Logger log = LoggerFactory.getLogger(InvoicedOrderLinesToCRMUpdateForecastTransformer.class);


    private final List<InvoicedOrderLine> invoicedOrderLines;
    private final MetaData metaData;
    private final Map<String, List<InvoicedOrderLine>> orderLinesMap = new LinkedHashMap();
    private final  List<JsonMessage> listOfUpdatedForecastJson = new ArrayList<JsonMessage>();

    public InvoicedOrderLinesToCRMUpdateForecastTransformer(List<InvoicedOrderLine> invoicedOrderLines, MetaData metaData) {
        this.invoicedOrderLines = invoicedOrderLines;
        this.metaData = metaData;
        createOrderLinesMap();
    }

    public Map<String, UpdateForecast> execute() throws BillingServiceException {
        log.info(String.format("Transforming invoice %s to update-forecast.", metaData.getMessageId()));
        Map<String, UpdateForecast> agreementUpdateForecastMap = aggregateUpdateForecast();
        Gson gson = GsonFactory.getGson();

        for (String agreement : agreementUpdateForecastMap.keySet()) {
            UpdateForecast updateForecast = agreementUpdateForecastMap.get(agreement);

            listOfUpdatedForecastJson.add(new JsonMessage(gson.toJson(updateForecast)));
        }

        return agreementUpdateForecastMap;
    }

    public List<JsonMessage> getListOfUpdatedForecastJson() {
        return listOfUpdatedForecastJson;
    }

    /** TODO: use ForecastCalculator instead */
    @Deprecated
    private Map<String, UpdateForecast> aggregateUpdateForecast() throws BillingServiceException {
        log.info(String.format("Aggregating  %d order lines to update-forecast.", invoicedOrderLines.size()));
        int year = -1;
        int month = -1;
        Map<String, UpdateForecast> agreementUpdateForecastMap = new LinkedHashMap<String, UpdateForecast>();
        //Loop over map containing agreement - ListOfOrderLines map
        for (List<InvoicedOrderLine> listOfInvoicesOrderLines : orderLinesMap.values()) {
            Currency currencyCode = null;
            BigDecimal accountManagement = BigDecimal.ZERO;
            BigDecimal consulting = BigDecimal.ZERO;
            BigDecimal filehostingFee = BigDecimal.ZERO;
            BigDecimal minimumTransactionFee = BigDecimal.ZERO;
            BigDecimal networkFee = BigDecimal.ZERO;
            BigDecimal other = BigDecimal.ZERO;
            BigDecimal suf = BigDecimal.ZERO;
            BigDecimal tradedoublerCommission = BigDecimal.ZERO;
            BigDecimal transactionalRevenue = BigDecimal.ZERO;
            BigDecimal fixedAndOtherRevenue = BigDecimal.ZERO;
            String sourceSystemAgreementId = null;
            for (InvoicedOrderLine invoicedOrderLine : listOfInvoicesOrderLines) {
                OrderLine orderLine = invoicedOrderLine.getOrderLine();
                String salesPart = orderLine.getSalesPart();
                currencyCode = invoicedOrderLine.getCurrencyCode();
                sourceSystemAgreementId = orderLine.getSystemAgreementId().trim();
                year = orderLine.getYear();
                month = orderLine.getMonth();

                if (getSalesPartsResult(salesPart).contains(ACCOUNT_MANAGEMENT))
                    accountManagement = accountManagement.add(orderLine.getTotal().getValue().subtract(orderLine.getCost().getValue()));
                if (getSalesPartsResult(salesPart).contains(CONSULTING))
                    consulting = consulting.add(orderLine.getTotal().getValue().subtract(orderLine.getCost().getValue()));
                if (getSalesPartsResult(salesPart).contains(FILEHOSTING_FEE))
                    filehostingFee = filehostingFee.add(orderLine.getTotal().getValue().subtract(orderLine.getCost().getValue()));
                if (getSalesPartsResult(salesPart).contains(MINIMUM_TRANSACTION_FEE))
                    minimumTransactionFee = minimumTransactionFee.add(orderLine.getTotal().getValue().subtract(orderLine.getCost().getValue()));
                if (getSalesPartsResult(salesPart).contains(NETWORK_FEE))
                    networkFee = networkFee.add(orderLine.getTotal().getValue().subtract(orderLine.getCost().getValue()));
                if (getSalesPartsResult(salesPart).contains(OTHER))
                    other = other.add(orderLine.getTotal().getValue().subtract(orderLine.getCost().getValue()));
                if (getSalesPartsResult(salesPart).contains(SET_UP_FEE))
                    suf = suf.add(orderLine.getTotal().getValue().subtract(orderLine.getCost().getValue()));
                if (getSalesPartsResult(salesPart).contains(TRADEDOUBLER_COMMISSION))
                    tradedoublerCommission = tradedoublerCommission.add(orderLine.getTotal().getValue().subtract(orderLine.getCost().getValue()));
                if (getSalesPartsResult(salesPart).contains(ACTUAL_TRANSACTIONAL_REVENUE))
                    transactionalRevenue = transactionalRevenue.add(orderLine.getTotal().getValue());
                if (getSalesPartsResult(salesPart).contains(ACTUAL_FIXED_AND_OTHER_REVENUE))
                    fixedAndOtherRevenue = fixedAndOtherRevenue.add(orderLine.getTotal().getValue());

            }

            MonthlyForecast monthlyForecast = new MonthlyForecast(sourceSystemAgreementId, year, month, currencyCode, accountManagement,
                    consulting, filehostingFee, minimumTransactionFee, networkFee, other, suf, tradedoublerCommission, transactionalRevenue, fixedAndOtherRevenue);
            UpdateForecast updateForecast = new UpdateForecast(new MetaData(metaData.getMessageType(), generateForecastGUID(metaData.getMessageId().getGuid(), sourceSystemAgreementId), metaData.getCreationTime(), metaData.getVersion(), metaData.getSourceSystem()), monthlyForecast);


            agreementUpdateForecastMap.put(sourceSystemAgreementId, updateForecast);

        }

        return agreementUpdateForecastMap;
    }

    /**
     * This method generates a unique GUID for the forecast based on the GUIDs in the meta info (i.e. from the invoice) and from the agreement.
     * @param metaGuid
     * @param agreementGuid
     * @return  forecast GUID
     * @throws BillingServiceException
     */
    private Guid generateForecastGUID(String metaGuid, String agreementGuid) throws BillingServiceException {
        int start = 0;
        agreementGuid = agreementGuid.trim();
        agreementGuid = agreementGuid.replace(" ", "");
        if (agreementGuid.contains("-")) start = agreementGuid.indexOf("-") +1;
        int agreementIDTruncationLength = 8;
        int end = Math.min(agreementIDTruncationLength, agreementGuid.length());
        String tweakedAgreementID = agreementGuid.substring(start, end);
        tweakedAgreementID = StringUtils.leftPad(tweakedAgreementID, agreementIDTruncationLength, '0');
        Guid combinedGuid;
        try {
            combinedGuid = new Guid(metaGuid.substring(0, metaGuid.length() - agreementIDTruncationLength).concat(tweakedAgreementID));
        } catch (Exception e) {
            throw BillingServiceException.createBugDisturbance(String.format("Failed to create unique Guid for Update forecast from %s and %s", metaGuid, agreementGuid));
        }

        boolean isGuid = GUIDValidator.validateGUI(combinedGuid);

        if (!isGuid){
            throw BillingServiceException.createBugDisturbance(String.format("Failed to create unique Guid for Update forecast from %s and %s", metaGuid, agreementGuid));
        }
        return combinedGuid;
    }

    private void createOrderLinesMap() {
        for (InvoicedOrderLine invoicedOrderLine : invoicedOrderLines) {
            if (!orderLinesMap.containsKey(invoicedOrderLine.getUpdateForecastKey())) {
                List<InvoicedOrderLine> orderList = new ArrayList<InvoicedOrderLine>();
                orderList.add(invoicedOrderLine);
                orderLinesMap.put(invoicedOrderLine.getUpdateForecastKey(), orderList);
            } else {
                orderLinesMap.get(invoicedOrderLine.getUpdateForecastKey()).add(invoicedOrderLine);
            }
        }

    }

}
