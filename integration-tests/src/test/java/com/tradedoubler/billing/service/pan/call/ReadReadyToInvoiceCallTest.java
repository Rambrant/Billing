package com.tradedoubler.billing.service.pan.call;

import com.tradedoubler.billing.domain.ReadyToInvoice;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.pan.handler.OrderLinesPanHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author bjoek
 * @since 2012-10-02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class ReadReadyToInvoiceCallTest {
    @Autowired
    private OrderLinesPanHandler orderLinesPanHandler;

    @Test
    public void confirmOrderLinesShouldWork() throws BillingServiceException {
        ReadyToInvoice readyToInvoice = orderLinesPanHandler.fetchReadyToInvoice();
        assertThat(readyToInvoice, notNullValue());
    }

}
