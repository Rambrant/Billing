package com.tradedoubler.billing.transform.json;

import com.tradedoubler.billing.domain.Currency;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.platform.flowcontroller.*;
import com.tradedoubler.billing.service.crm.JsonMessage;
import com.tradedoubler.testutil.FileUtil;
import org.junit.Test;
import org.mule.api.transformer.TransformerException;

import java.math.BigDecimal;
import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * @author bjorn
 * @since 2012-10-12
 */
public class UpdateForecastToJsonTransformerTest {
    @Test
    public void transformDomainObjectShouldWork() throws TransformerException {
        ServiceResult serviceResultIn = createServiceResult(new MonthlyForecast("1-123456789", 2012, 9, new Currency("SEK"),
                new BigDecimal("100.00"),
                new BigDecimal("100.00"),
                new BigDecimal("100.00"),
                new BigDecimal("100.00"),
                new BigDecimal("100.00"),
                new BigDecimal("100.00"),
                new BigDecimal("100.00"),
                new BigDecimal("100.00"),
                new BigDecimal("100.00"),
                new BigDecimal("100.00")
        ));

        Collection<UpdateForecast> forecastUpdates = ((PrepaymentForecastUpdated) serviceResultIn.getIntegrationMessage().getDomainObject()).getForecastUpdates();
        List<JsonMessage> forecastUpdatesJson = new UpdateForecastToJsonTransformer().doTransform(forecastUpdates);

        assertThat(forecastUpdatesJson.size(), is(1));

        String expected = FileUtil.readFileFromClasspath("json-examples/update-forecast-example.json");

        assertThat(removeWhiteSpaces(forecastUpdatesJson.get(0).jsonString), is(removeWhiteSpaces(new JsonMessage(expected).jsonString)));
    }

    private ServiceResult createServiceResult(MonthlyForecast monthlyForecast) {
        MetaData metaDate = new MetaData("UpdateForecast", new Guid("22263309-8562-4f46-43e3-1476b7543897"),
                new Timestamp("2012-09-27T13:00:00.0Z"), "1.0", "PAN");

        UpdateForecast updateForecast = new UpdateForecast(metaDate, monthlyForecast);

        List<UpdateForecast> updateForecasts = new ArrayList<UpdateForecast>();
        updateForecasts.add(updateForecast);

        MetaData metaData = new MetaData("messageType", new Guid("batchId"), new Timestamp(), "", "");
        PrepaymentForecastUpdated prepaymentForecastUpdated = new PrepaymentForecastUpdated(metaData, new Guid("batchId"), new ArrayList<PrepaymentOrderLine>());

        prepaymentForecastUpdated.setForecastUpdates(updateForecasts);

        IntegrationMessage integrationMessage = new IntegrationMessage("", null);
        integrationMessage.setDomainObject(prepaymentForecastUpdated);

        ServiceResult serviceResultIn = new ServiceResult();
        serviceResultIn.setIntegrationMessage(integrationMessage);
        return serviceResultIn;
    }

    private String removeWhiteSpaces(String str) {
        return str.replaceAll("\n|\r|\t| ", "");
    }

    @Test
    public void zeroValueShouldBeZero() throws TransformerException {
        ServiceResult serviceResultIn = createServiceResult(new MonthlyForecast("1-123456789", 2012, 9, new Currency("SEK"),
                new BigDecimal("0.000"),
                new BigDecimal("00.00"),
                new BigDecimal("0.00"),
                new BigDecimal("0.0"),
                new BigDecimal("0"),
                new BigDecimal("0.001"),
                new BigDecimal("0.005"),
                new BigDecimal("0.009"),
                new BigDecimal("-0.005"),
                new BigDecimal("-0.009")
        ));

        Collection<UpdateForecast> forecastUpdates = ((PrepaymentForecastUpdated) serviceResultIn.getIntegrationMessage().getDomainObject()).getForecastUpdates();
        List<JsonMessage> forecastUpdatesJson = new UpdateForecastToJsonTransformer().doTransform(forecastUpdates);

        assertThat(forecastUpdatesJson.size(), is(1));

        assertThat(forecastUpdatesJson.get(0).jsonString, containsString("\"accountManagement\": 0.00"));
        assertThat(forecastUpdatesJson.get(0).jsonString, containsString("\"consulting\": 0.00"));
        assertThat(forecastUpdatesJson.get(0).jsonString, containsString("\"filehostingFee\": 0.00"));
        assertThat(forecastUpdatesJson.get(0).jsonString, containsString("\"minimumTransactionFee\": 0.00"));
        assertThat(forecastUpdatesJson.get(0).jsonString, containsString("\"networkFee\": 0.00"));
        assertThat(forecastUpdatesJson.get(0).jsonString, containsString("\"other\": 0.00"));
        assertThat(forecastUpdatesJson.get(0).jsonString, containsString("\"suf\": 0.00"));
        assertThat(forecastUpdatesJson.get(0).jsonString, containsString("\"tradedoublerCommission\": 0.00"));
        assertThat(forecastUpdatesJson.get(0).jsonString, containsString("\"transactionalRevenue\": 0.00"));
        assertThat(forecastUpdatesJson.get(0).jsonString, containsString("\"fixedAndOtherRevenue\": 0.00"));
    }

}

