package com.tradedoubler.billing.service.ax.webservice.call;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.webservice.domainhandler.BankHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.tradedoubler.billing.service.ax.webservice.AxRequestResult.ALL_IS_WELL;
import static com.tradedoubler.billing.util.AxDbConstantsUtil.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author bjoek
 * @since 2012-07-02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class FindBankCallTest {

    @Autowired
    private BankHandler bankHandler;

    @Test
    public void findExistingShouldWork() throws BillingServiceException {
        FindBankCall findBankCall = bankHandler.findBankByPk(EXISTING_CLIENT_ACCOUNT_NUM, new Market(51));

        assertEquals(findBankCall.getErrorMessage(), findBankCall.getAxRequestResult(), ALL_IS_WELL);
        assertTrue(!findBankCall.getDocumentHash().getValue().isEmpty());
        assertThat(findBankCall.getNumberOfBanks(), is(1));
        assertThat(findBankCall.getBanks().get(0).getCustAccount(), is(EXISTING_CLIENT_ACCOUNT_NUM));
        assertThat(findBankCall.getBanks().get(0).getAccountID(), is("1"));
    }

    @Test
    public void findNonExistingShouldWork() throws BillingServiceException {
        FindBankCall findBankCall = bankHandler.findBankByPk("Gurka", new Market(51));

        assertEquals(findBankCall.getAxRequestResult(), ALL_IS_WELL);
        assertThat(findBankCall.getNumberOfBanks(), is(0));
    }

}
