package com.tradedoubler.billing.service.pan.call;

import com.tradedoubler.billing.domain.ResellerClientUpdated;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.pan.handler.InvoicingRulePanHandler;
import com.tradedoubler.billing.transform.json.gson.GsonFactory;
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
public class ReadUpdatedOrCreatedResellerCallTest {
    @Autowired
    private InvoicingRulePanHandler invoicingRulePanHandler;

    @Test
    public void getUpdatedOrCreatedResellerShouldWork() throws BillingServiceException {
        ResellerClientUpdated updatedOrCreatedReseller = invoicingRulePanHandler.getUpdatedOrCreatedReseller();
        System.out.println(GsonFactory.getGson().toJson(updatedOrCreatedReseller));
    }

}
