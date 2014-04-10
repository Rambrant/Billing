package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2008._01.documents.customer.*;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.*;
import com.tradedoubler.billing.service.ax.webservice.domainhandler.ClientHandler;
import com.tradedoubler.billing.util.AxDbConstantsUtil;
import org.hamcrest.Matchers;
import org.junit.*;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

import static com.tradedoubler.billing.service.ax.webservice.call.WebServiceCallTestUtil.createClient;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * User: erigu
 * Date: 2012-08-13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class InsertClientCallTest {

    @Autowired
    private ClientHandler clientHandler;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void createNewShouldWork() throws BillingServiceException {
        String id = AxDbConstantsUtil.generateClientId();

        Client client = createClient(id, 51);
        Market market = new Market(51);

        clientHandler.insertClient(client, market);

        verifyClientInAx(id, client);
    }

    @Test
    public void insertResellerDataShouldWork() throws BillingServiceException {
        String no_county = null;
        String no_companyRegistrationNumber = null;
        String no_vatNumber = null;

        String id = AxDbConstantsUtil.generateClientId();

        char[] lineArr = new char[120];
        Arrays.fill(lineArr, 'l');
        Address address = new Address(new String(lineArr), new String(lineArr),
                "123456789012345678901234567890123456789012345678901234567890",
                no_county,
                "1234567890", "SE", 3);
        List<Integer> markets = Arrays.asList(51);
        char[] nameArr = new char[100];
        Arrays.fill(nameArr, 'n');
        Client client = new Client(id, new String(nameArr), no_companyRegistrationNumber, no_vatNumber, ClientType.RESELLER, "SV",
                "12345678901234567890123456789012345678901234567890",
                new ArrayList<Bank>(), address,
                new ArrayList<ClientMessageRule>(), markets);
        Market market = new Market(51);

        clientHandler.insertClient(client, market);
    }

    @Test
    public void createNewForRelease1MarketsMarketsShouldWork() throws BillingServiceException {
        String clientId = AxDbConstantsUtil.generateClientId();

        List<Bank> bankAccounts = new ArrayList<Bank>();
        bankAccounts.add(new Bank(clientId, 51, "SWEDSESS", "4242424242", "Pelle tönt"));

        Address address = new Address("Street-4", "hejsan", "Stockholm", null, "11120", "SE", 3);

        List<ClientMessageRule> rules = new ArrayList<ClientMessageRule>();
        rules.add(new ClientMessageRule("facecb15-85ec-4761-bd41-719e7fbe3d95", clientId,
                "test text 1", new Timestamp(), new Timestamp()));

        List<Integer> marketIds = new ArrayList<Integer>();
        marketIds.add(51);

        Client client = new Client(clientId, "ACME-3", "556284-2319", "7777777", ClientType.ADVERTISER,
                "SV", "", bankAccounts, address, rules, marketIds);

        // NO
        clientHandler.insertClient(client, new Market(81861));
        // DK
        clientHandler.insertClient(client, new Market(135827));
        // FI
        clientHandler.insertClient(client, new Market(135926));
        // SE
        clientHandler.insertClient(client, new Market(51));
        // DE
        clientHandler.insertClient(client, new Market(135899));
    }

    @Test
    public void createExistingShouldNotWork() throws BillingServiceException {
        Client client = createClient(AxDbConstantsUtil.EXISTING_CLIENT_ACCOUNT_NUM, 51);
        Market market = new Market(51);

        try {
            clientHandler.insertClient(client, market);
            fail();
        } catch (BillingServiceException bsex) {
            assertThat(bsex.getMessage(), startsWith("Client"));
            assertThat(bsex.getMessage(), endsWith("The record already exists."));
            assertThat(bsex.getCategory(), Matchers.is(ServiceResultCategory.INTEGRATION_DISTURBANCE));
        }
    }

    private void verifyClientInAx(String id, Client expected) throws BillingServiceException {
        FindClientCall findClientCall = clientHandler.findClientByPk(id, new Market(51));
        assertThat(findClientCall.getNumberOfClients(), is(1));
        AxdEntityCustTable customer = findClientCall.getCustomer();

        collector.checkThat(customer.getAccountNum().getValue(), is(id));
        collector.checkThat(customer.getIdentificationNumber().getValue(), is(expected.getBusinessFormCode()));
        AxdEntityDirPartyDirOrganization partyDirOrganization = (AxdEntityDirPartyDirOrganization) customer.getDirParty().get(0);
        collector.checkThat(partyDirOrganization.getOrgNumber().getValue(), is(expected.getCompanyRegistrationNumber()));
        collector.checkThat(partyDirOrganization.getLanguageId().getValue(), is(expected.getInvoiceLanguage().getLanguageCode().toLowerCase()));
        collector.checkThat(partyDirOrganization.getName().getValue(), is(expected.getRegisteredCompanyName()));
        collector.checkThat(customer.getVATNum().getValue(), is(expected.getVatNumber()));

        AxdEntityDirPartyPostalAddressView addressView = partyDirOrganization.getDirPartyPostalAddressView().get(0);
        collector.checkThat(addressView.getCity().getValue(), is(expected.getRegisteredAddress().getCity()));
        collector.checkThat(addressView.getBuildingCompliment().getValue(), is(expected.getRegisteredAddress().getCounty()));
        collector.checkThat(replaceNewLine(addressView.getStreet().getValue(), ":"), is(expected.getRegisteredAddress().getLine1() + ":" +
                expected.getRegisteredAddress().getLine2()));
        collector.checkThat(addressView.getZipCode().getValue(), is(expected.getRegisteredAddress().getPostalCode()));
        collector.checkThat(addressView.getRoles().getValue(), is("Business"));
        collector.checkThat(addressView.getCountryRegionId().getValue(), is("SWE"));
    }

    private String replaceNewLine(String string, String replacement) {
        return string.replaceAll("\\n\\r|\\n|\\r", replacement);
    }

}

