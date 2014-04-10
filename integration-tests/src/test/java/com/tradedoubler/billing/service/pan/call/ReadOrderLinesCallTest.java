package com.tradedoubler.billing.service.pan.call;

import com.tradedoubler.billing.domain.OrderLinesCreated;
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
public class ReadOrderLinesCallTest {
    @Autowired
    private OrderLinesPanHandler orderLinesPanHandler;

    @Test
    public void fetchOrderLinesShouldWork() throws BillingServiceException {
        OrderLinesCreated orderLinesCreated = orderLinesPanHandler.fetchOrderLinesCreated();
        assertThat(orderLinesCreated, notNullValue());
        assertThat(orderLinesCreated.getOrderLines(), notNullValue());
    }

    @Test
    public void fetchOrderLinesShouldReturnSameValuesTwice() throws BillingServiceException {
        OrderLinesCreated orderLinesCreated1 = orderLinesPanHandler.fetchOrderLinesCreated();
        OrderLinesCreated orderLinesCreated2 = orderLinesPanHandler.fetchOrderLinesCreated();
        if (orderLinesCreated1.getBatchId() == null) {
            assertThat(orderLinesCreated2.getBatchId(), nullValue());
        } else {
            assertThat(orderLinesCreated1.getBatchId().getGuid(), is(orderLinesCreated2.getBatchId().getGuid()));
        }
        assertThat(orderLinesCreated1.getOrderLines().size(), is(orderLinesCreated2.getOrderLines().size()));
    }

}
