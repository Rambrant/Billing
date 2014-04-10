package com.tradedoubler.billing.service.pan.call;

import com.tradedoubler.billing.domain.Guid;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.pan.handler.InvoicingRulePanHandler;
import org.junit.Test;
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
public class ConfirmResellerClientProcessedCallTest {
    @Autowired
    private InvoicingRulePanHandler invoicingRulePanHandler;

    @Test
    public void confirmOrderLinesShouldWork() throws BillingServiceException {
        Guid resellerClientEventGuid = new Guid("d5250806-60a6-6a56-e044-002128bba6a6");
        invoicingRulePanHandler.confirmResellerClientProcessed(resellerClientEventGuid);
    }

}
