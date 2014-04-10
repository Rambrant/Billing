package com.tradedoubler.billing.service.crm.handler;

import com.tradedoubler.billing.domain.Currency;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.fetch.FlowName;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.transform.ftp.SalesParts;
import org.joda.time.DateTime;

import java.util.*;

import static com.tradedoubler.billing.transform.ftp.SalesParts.*;

/**
 * Handles forecast calculations.
 *
 * @author bjorn
 * @since 2012-10-12
 */
public class ForecastCalculator {
    private final List<PrepaymentOrderLine> prepaymentOrderLines;
    private final String version;
    private final String sourceSystem;

    private final MessageGuidGenerator messageGuidGenerator;

    private final Map<String, UpdateForecast> forecastsMappedBySystemAgreementId = new LinkedHashMap<String, UpdateForecast>();

    public ForecastCalculator(List<PrepaymentOrderLine> prepaymentOrderLines, Guid batchId, String version, String sourceSystem) {
        this.prepaymentOrderLines = prepaymentOrderLines;
        this.messageGuidGenerator = new MessageGuidGenerator(batchId);
        this.version = version;
        this.sourceSystem = sourceSystem;
    }

    /**
     * Creates forecasts from the prepayment order lines. The order lines are aggregated to one forecast per program/systemAgreementId.
     *
     * The forecast could be aggregated to one forecast per program, year and month, but this would mean that the messageId
     * in metadata would have to modified to include period in the guid (otherwise CRM would remove messages as duplicates).
     * Instead todays date is used in the forecast, since it it reasonable that invoiced prepayment order lines are exported
     * in same period as they deducted from the prepayment program.
     *
     * @return
     * @throws BillingServiceException
     */
    public Collection<UpdateForecast> calculate() throws BillingServiceException {
        for (PrepaymentOrderLine prepaymentOrderLine : prepaymentOrderLines) {
            String systemAgreementId = prepaymentOrderLine.getOrderLine().getSystemAgreementId();

            UpdateForecast updateForecast = forecastsMappedBySystemAgreementId.get(systemAgreementId);

            if (updateForecast == null) {
                updateForecast = createNewForecast(prepaymentOrderLine);

                forecastsMappedBySystemAgreementId.put(systemAgreementId, updateForecast);
            }

            addOrderLineNumbersToForecast(updateForecast.getMonthlyForecast(), prepaymentOrderLine.getOrderLine());
        }
        return forecastsMappedBySystemAgreementId.values();
    }

    private UpdateForecast createNewForecast(PrepaymentOrderLine prepaymentOrderLine) throws BillingServiceException {
        OrderLine orderLine = prepaymentOrderLine.getOrderLine();

        Guid messageId = messageGuidGenerator.generateCompositeGuid(orderLine.getSystemAgreementId());

        // The year and month is always today's date otherwise since different order lines will be grouped by programId only
        DateTime today = new DateTime();
        int year = today.getYear();
        int month = today.getMonthOfYear();
        Currency currency = prepaymentOrderLine.getCurrency();
        String systemAgreementId = orderLine.getSystemAgreementId();

        MetaData metaData = new MetaData(FlowName.UpdatePrepaymentForecastPan.name(),
                messageId, new Timestamp(), version, sourceSystem);

        MonthlyForecast monthlyForecast = MonthlyForecast.createZeroMonthlyForecast(systemAgreementId, year, month, currency);

        return new UpdateForecast(metaData, monthlyForecast);
    }

    private void addOrderLineNumbersToForecast(MonthlyForecast forecast, OrderLine orderLine) {
        String salesPart = orderLine.getSalesPart();
        List<SalesParts> salesPartsResult = getSalesPartsResult(salesPart);

        if (salesPartsResult.contains(ACCOUNT_MANAGEMENT)) {
            forecast.getAccountManagement().add(orderLine.getTotal());
            forecast.getAccountManagement().subtract(orderLine.getCost());
        }
        if (salesPartsResult.contains(CONSULTING)) {
            forecast.getConsulting().add(orderLine.getTotal());
            forecast.getConsulting().subtract(orderLine.getCost());
        }
        if (salesPartsResult.contains(FILEHOSTING_FEE)) {
            forecast.getFilehostingFee().add(orderLine.getTotal());
            forecast.getFilehostingFee().subtract(orderLine.getCost());
        }
        if (salesPartsResult.contains(MINIMUM_TRANSACTION_FEE)) {
            forecast.getMinimumTransactionFee().add(orderLine.getTotal());
            forecast.getMinimumTransactionFee().subtract(orderLine.getCost());
        }
        if (salesPartsResult.contains(NETWORK_FEE)) {
            forecast.getNetworkFee().add(orderLine.getTotal());
            forecast.getNetworkFee().subtract(orderLine.getCost());
        }
        if (salesPartsResult.contains(OTHER)) {
            forecast.getOther().add(orderLine.getTotal());
            forecast.getOther().subtract(orderLine.getCost());
        }
        if (salesPartsResult.contains(SET_UP_FEE)) {
            forecast.getSuf().add(orderLine.getTotal());
            forecast.getSuf().subtract(orderLine.getCost());
        }
        if (salesPartsResult.contains(TRADEDOUBLER_COMMISSION)) {
            forecast.getTradedoublerCommission().add(orderLine.getTotal());
            forecast.getTradedoublerCommission().subtract(orderLine.getCost());
        }
        if (salesPartsResult.contains(ACTUAL_TRANSACTIONAL_REVENUE)) {
            forecast.getTransactionalRevenue().add(orderLine.getTotal());
        }
        if (salesPartsResult.contains(ACTUAL_FIXED_AND_OTHER_REVENUE)) {
            forecast.getFixedAndOtherRevenue().add(orderLine.getTotal());
        }

    }

}
