package com.tradedoubler.billing.service.pan.call;

import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.pan.handler.OrderLinesPanHandler;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author bjoek
 * @since 2012-10-02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class ConfirmReadyToInvoiceCallTest {
    @Autowired
    private OrderLinesPanHandler orderLinesPanHandler;

    @Test
    public void confirmOrderLinesShouldWork() throws BillingServiceException {
        orderLinesPanHandler.confirmInvoicingStarted();
    }

}
