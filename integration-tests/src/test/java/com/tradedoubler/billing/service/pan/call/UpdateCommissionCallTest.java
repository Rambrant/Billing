package com.tradedoubler.billing.service.pan.call;

import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.pan.handler.CommissionPanHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.NonTransientDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * @author bjoek
 * @since 2012-10-02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class UpdateCommissionCallTest {
    @Autowired
    private CommissionPanHandler commissionPanHandler;

    @Test
    public void updateExistingShouldWork() throws BillingServiceException {
        commissionPanHandler.updateDisplayTradeDoublerCommission("1-81", true);
        commissionPanHandler.updateDisplayTradeDoublerCommission("1-81", false);
    }

    @Test
    public void updateNonExistingShouldThrowException() throws BillingServiceException {
        try {
            commissionPanHandler.updateDisplayTradeDoublerCommission("1-1", false);
            fail();
        } catch (NonTransientDataAccessException bsex) {
            assertThat(bsex.getMessage(), containsString("The program 1 could not be found in the database. Please check program id."));
        }
    }

    @Test
    public void illegalSourceAgreementIdShouldThrowException() throws BillingServiceException {
        try {
            commissionPanHandler.updateDisplayTradeDoublerCommission("1-abc", false);
            fail();
        } catch (NumberFormatException nfex) {
            assertThat(nfex.getMessage(), is("For input string: \"abc\""));
        }
    }

    @Test
    public void nonProgramSourceAgreementIdShouldDoNothing() throws BillingServiceException {
        commissionPanHandler.updateDisplayTradeDoublerCommission("2-0", false);
    }
}
