package com.tradedoubler.billing.service.ax.webservice.call;

import com.tradedoubler.billing.domain.Bank;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.webservice.AxRequestResult;
import com.tradedoubler.billing.service.ax.webservice.domainhandler.ClientHandler;
import com.tradedoubler.billing.util.AxDbConstantsUtil;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * User: erigu
 * Date: 2012-08-13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class ReadClientCallTest {
    private static final String EXISTING_ACCOUNT_NUM = AxDbConstantsUtil.EXISTING_CLIENT_ACCOUNT_NUM;

    @Autowired
    private ClientHandler clientHandler;

    @Test
    public void readExistingShouldWork() throws BillingServiceException {
        Bank bank = new Bank(EXISTING_ACCOUNT_NUM, 51, null, null, null);
        ReadClientCall readClientCall = clientHandler.readClient(bank);

        assertThat(readClientCall.getAxRequestResult(), is(AxRequestResult.ALL_IS_WELL));
        assertNotNull(readClientCall.getDocumentHash());
        assertNotNull(readClientCall.getDirPartyPostalAddressViewRecId());
        assertNotNull(readClientCall.getDirPartyRecId());
        assertNotNull(readClientCall.getValidAsOfDateTime());
        assertNotNull(readClientCall.getCustomer());
    }

    @Test
    public void readNonExistingShouldNotWork() throws BillingServiceException {
        Bank bank = new Bank("Gurka", 51, null, null, null);
        try {
            clientHandler.readClient(bank);
            fail();
        } catch (BillingServiceException bsex) {
            assertThat(bsex.getMessage(), startsWith("Client PK: Gurka, dataAreaId: SE02  , No valid document identified from the entity key"));
        }
    }

}

