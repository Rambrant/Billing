package com.tradedoubler.billing.service.ax.webservice.call;

import com.tradedoubler.billing.domain.Market;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.webservice.AxRequestResult;
import com.tradedoubler.billing.service.ax.webservice.domainhandler.ClientHandler;
import com.tradedoubler.billing.util.AxDbConstantsUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * User: erigu
 * Date: 2012-08-13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class FindClientCallTest {
    private static final String EXISTING_ACCOUNT_NUM = AxDbConstantsUtil.EXISTING_CLIENT_ACCOUNT_NUM;

    @Autowired
    private ClientHandler clientHandler;

    @Test
    public void findExistingShouldWork() throws BillingServiceException {
        Market market = new Market(51);
        FindClientCall findClientCall = clientHandler.findClientByPk(EXISTING_ACCOUNT_NUM, market);

        assertThat(findClientCall.getAxRequestResult(), is(AxRequestResult.ALL_IS_WELL));
        assertNotNull(findClientCall.getDocumentHash());
        assertNotNull(findClientCall.getDirPartyPostalAddressViewRecId());
        assertNotNull(findClientCall.getDirPartyRecId());
        assertNotNull(findClientCall.getValidAsOfDateTime());
        assertNotNull(findClientCall.getBankAccount());
    }

    @Test
    public void findNonExistingShouldNotWork() throws BillingServiceException {
        Market market = new Market(51);
        FindClientCall findClientCall = clientHandler.findClientByPk("Gurka", market);

        assertThat(findClientCall.getAxRequestResult(), is(AxRequestResult.ALL_IS_WELL));
        assertThat(findClientCall.getNumberOfClients(), is(0));
    }

}

