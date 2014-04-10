package com.tradedoubler.billing.service.pan.call;

import com.tradedoubler.billing.domain.PrepaymentForecastUpdated;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.pan.handler.OrderLinesPanHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * @author bjoek
 * @since 2012-10-02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class ReadPrepaymentForecastOrderLinesCallTest {
    @Autowired
    private OrderLinesPanHandler orderLinesPanHandler;

    @Test
    public void fetchOrderLinesShouldWork() throws BillingServiceException {
        PrepaymentForecastUpdated prepaymentForecastUpdated = orderLinesPanHandler.fetchPrepaymentForecastMessage();
        assertThat(prepaymentForecastUpdated, notNullValue());
        assertThat(prepaymentForecastUpdated.getOrderLines(), notNullValue());
    }

    @Test
    public void fetchOrderLinesShouldReturnSameValuesTwice() throws BillingServiceException {
        PrepaymentForecastUpdated prepaymentForecastUpdated1 = orderLinesPanHandler.fetchPrepaymentForecastMessage();
        PrepaymentForecastUpdated prepaymentForecastUpdated2 = orderLinesPanHandler.fetchPrepaymentForecastMessage();
        if (prepaymentForecastUpdated1.getBatchId() == null) {
            assertThat(prepaymentForecastUpdated2.getBatchId(), nullValue());
        } else {
            assertThat(prepaymentForecastUpdated1.getBatchId().getGuid(), is(prepaymentForecastUpdated2.getBatchId().getGuid()));
        }
        assertThat(prepaymentForecastUpdated1.getOrderLines().size(), is(prepaymentForecastUpdated2.getOrderLines().size()));
    }

}
