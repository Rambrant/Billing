package com.tradedoubler.billing.service.crm.handler;

import com.tradedoubler.billing.domain.Currency;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.util.AxDbConstantsUtil;
import org.joda.time.DateTime;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author bjoek
 * @since 2013-03-06
 */
public class ForecastCalculatorTest {
    @Test
    public void generateForecastGuidShouldWork() throws BillingServiceException {
        OrderLine orderLine = new OrderLine("0-123456789", AxDbConstantsUtil.EXISTING_ORDER_LINE_ID,
                true, "110", "description",
                BigDecimal.valueOf(1390.43), BigDecimal.valueOf(695.21), "1301", new Timestamp(),
                "11111", "");
        Guid guid = new Guid("FF8481B0-B630-45F5-8F80-D602E0215DBF");
        PrepaymentOrderLine prepaymentOrderLine = new PrepaymentOrderLine(orderLine, new Currency("SEK"));

        Collection<UpdateForecast> updateForecasts = new ForecastCalculator(Arrays.asList(prepaymentOrderLine), guid, "version", "pan").calculate();
        Guid forecastGuid = updateForecasts.iterator().next().getMetaData().getMessageId();

        assertThat(forecastGuid.getGuid(), is("ff8481b0-b630-45f5-8f80-d60223456789"));
    }

    @Test
    public void generateShortForecastGuidShouldWork() throws BillingServiceException {
        OrderLine orderLine = new OrderLine("0-123", AxDbConstantsUtil.EXISTING_ORDER_LINE_ID,
                true, "110", "description",
                BigDecimal.valueOf(1390.43), BigDecimal.valueOf(695.21), "1301", new Timestamp(),
                "11111", "");

        Guid guid = new Guid("FF8481B0-B630-45F5-8F80-D602E0215DBF");

        PrepaymentOrderLine prepaymentOrderLine = new PrepaymentOrderLine(orderLine, new Currency("SEK"));

        Collection<UpdateForecast> updateForecasts = new ForecastCalculator(Arrays.asList(prepaymentOrderLine), guid, "version", "pan").calculate();
        Guid forecastGuid = updateForecasts.iterator().next().getMetaData().getMessageId();

        assertThat(forecastGuid.getGuid(), is("ff8481b0-b630-45f5-8f80-d60200000123"));
    }

    @Test
    public void generateShortestForecastGuidShouldWork() throws BillingServiceException {
        OrderLine orderLine = new OrderLine("1-1", AxDbConstantsUtil.EXISTING_ORDER_LINE_ID,
                true, "110", "description",
                BigDecimal.valueOf(1390.43), BigDecimal.valueOf(695.21), "1301", new Timestamp(),
                "11111", "");

        Guid guid = new Guid("FF8481B0-B630-45F5-8F80-D602E0215DBF");

        PrepaymentOrderLine prepaymentOrderLine = new PrepaymentOrderLine(orderLine, new Currency("SEK"));

        Collection<UpdateForecast> updateForecasts = new ForecastCalculator(Arrays.asList(prepaymentOrderLine), guid, "version", "pan").calculate();
        Guid forecastGuid = updateForecasts.iterator().next().getMetaData().getMessageId();

        assertThat(forecastGuid.getGuid(), is("ff8481b0-b630-45f5-8f80-d60200000001"));
    }

    @Test
    public void dateShouldBeTodaysDate() throws BillingServiceException {
        OrderLine orderLine = new OrderLine("1-1", AxDbConstantsUtil.EXISTING_ORDER_LINE_ID,
                true, "110", "description",
                BigDecimal.valueOf(1390.43), BigDecimal.valueOf(695.21), "1201", new Timestamp(),
                "11111", "");

        Guid guid = new Guid("FF8481B0-B630-45F5-8F80-D602E0215DBF");

        PrepaymentOrderLine prepaymentOrderLine = new PrepaymentOrderLine(orderLine, new Currency("SEK"));

        Collection<UpdateForecast> updateForecasts = new ForecastCalculator(Arrays.asList(prepaymentOrderLine), guid, "version", "pan").calculate();
        UpdateForecast updateForecast = updateForecasts.iterator().next();
        MonthlyForecast monthlyForecast = updateForecast.getMonthlyForecast();

        assertThat(monthlyForecast.getYear(), is(new DateTime().getYear()));
        assertThat(monthlyForecast.getMonth(), is(new DateTime().getMonthOfYear()));
    }
}
