package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgcustbank.AxdEntityCustBankAccount;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.*;
import com.tradedoubler.billing.service.ax.webservice.domainhandler.*;
import com.tradedoubler.billing.util.AxDbConstantsUtil;
import org.hamcrest.Matchers;
import org.junit.*;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.tradedoubler.billing.service.ax.webservice.call.WebServiceCallTestUtil.createBank;
import static com.tradedoubler.billing.util.AxDbConstantsUtil.EXISTING_CLIENT_ACCOUNT_NUM;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author bjoek
 * @since 2012-07-02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class InsertBankCallTest {

    @Autowired
    private BankHandler bankHandler;

    @Autowired
    private ClientHandler clientHandler;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void createNewShouldWork() throws BillingServiceException {
        String clientId = AxDbConstantsUtil.generateClientId();

        Client client = createClient(clientId, createBank(clientId, 51));
        Market market = new Market(51);
        clientHandler.insertClient(client, market);

        Bank bank = client.getBankAccounts().get(0);
        bankHandler.insertBank(bank);

        verifyBankInAx(clientId, bank);
    }

    private void verifyBankInAx(String clientId, Bank expected) throws BillingServiceException {
        FindBankCall findBankCall = bankHandler.findBankByPk(clientId, expected.getMarketId());
        collector.checkThat(findBankCall.getNumberOfBanks(), is(1));

        AxdEntityCustBankAccount custBankAccount = findBankCall.getBanks().get(0);
        collector.checkThat(custBankAccount.getAccountID(), is("1"));
        collector.checkThat(custBankAccount.getName().getValue(), is(expected.getAccountOwner()));
        collector.checkThat(custBankAccount.getRegistrationNum().getValue(), is(expected.getBankCode()));
        collector.checkThat(custBankAccount.getCustAccount(), is(clientId));
        collector.checkThat(custBankAccount.getAccountNum().getValue(), is(expected.getBankAccount()));
    }

    @Test
    public void createExistingShouldNotWork() throws BillingServiceException {
        Bank bank = createBank(EXISTING_CLIENT_ACCOUNT_NUM, 51);

        try {
            bankHandler.insertBank(bank);
            fail();
        } catch (BillingServiceException bsex) {
            assertThat(bsex.getMessage(), startsWith("Bank"));
            assertThat(bsex.getMessage(), endsWith("The record already exists."));
            assertThat(bsex.getCategory(), Matchers.is(ServiceResultCategory.INTEGRATION_DISTURBANCE));
        }
    }

    @Test
    public void createExistingWithNewMarketShouldNotWork() throws BillingServiceException {
        Bank bank = createBank(EXISTING_CLIENT_ACCOUNT_NUM, 135926);

        try {
            bankHandler.insertBank(bank);
            fail();
        } catch (BillingServiceException bsex) {
            assertThat(bsex.getMessage(), startsWith("Bank"));
            assertThat(bsex.getMessage(), endsWith("The record already exists."));
            assertThat(bsex.getCategory(), Matchers.is(ServiceResultCategory.INTEGRATION_DISTURBANCE));
        }
    }

    private Client createClient(String id, Bank bank) {
        Client client = WebServiceCallTestUtil.createClient(id, 51);
        client.getBankAccounts().add(bank);
        return client;
    }

}
