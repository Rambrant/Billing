package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2008._01.documents.customer.AxdEntityCustTable;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.webservice.domainhandler.ClientHandler;
import com.tradedoubler.billing.util.AxDbConstantsUtil;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.util.*;

import static com.tradedoubler.billing.util.AxDbConstantsUtil.EXISTING_CLIENT_ACCOUNT_NUM;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * User: erigu
 * Date: 2012-08-13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class UpdateClientCallTest {
    private static final Market MARKET = new Market(51);

    @Autowired
    private ClientHandler clientHandler;

    @Test
    public void updateExistingShouldWork() throws BillingServiceException {
        Client client = createClient(EXISTING_CLIENT_ACCOUNT_NUM);
        FindClientCall readClientCall = clientHandler.findClientByPk(client.getClientId(), MARKET);

        clientHandler.updateClient(readClientCall, client, MARKET);
    }

    @Test
    public void updateNonExistingShouldNotWork() throws BillingServiceException {
        Client client = createClient(EXISTING_CLIENT_ACCOUNT_NUM);
        FindClientCall readClientCall = clientHandler.findClientByPk(client.getClientId(), MARKET);

        String id = AxDbConstantsUtil.generateClientId();

        client.setClientId(id);

        try {
            clientHandler.updateClient(readClientCall, client, MARKET);
            fail();
        } catch (BillingServiceException bsex) {
            assertThat(bsex.getMessage(), Matchers.startsWith("Client PK: " + id +
                    ", dataAreaId: SE02  , No valid document identified from the entity key"));
        }

    }

    @Test
    public void updateWithWrongHashValueShouldNotWork() throws BillingServiceException {
        Client client = createClient(EXISTING_CLIENT_ACCOUNT_NUM);
        FindClientCall readClientCall = spy(clientHandler.findClientByPk(client.getClientId(), MARKET));

        QName _AxdEntityCustTableDocumentHash_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Customer", "_DocumentHash");
        JAXBElement<String> docHash = new JAXBElement<String>(_AxdEntityCustTableDocumentHash_QNAME, String.class, AxdEntityCustTable.class, "dummy");

        // Replace document hash value
        when(readClientCall.getDocumentHash()).thenReturn(docHash);

        try {
            clientHandler.updateClient(readClientCall, client, MARKET);
            fail();
        } catch (BillingServiceException bsex) {
            assertThat(bsex.getMessage(), Matchers.startsWith("Client PK: TELIA, dataAreaId: SE02  , The document hash does not match the hash in the XML."));
        }

    }

    @Test
    public void updateExistingWithBankInfoShouldWork() throws BillingServiceException {
        Bank bank = new Bank(EXISTING_CLIENT_ACCOUNT_NUM, MARKET.getOrganizationId(), "", "", "");
        ReadClientCall readClientCall = clientHandler.readClient(bank);

        clientHandler.updateClientWithBankInfo(readClientCall, bank.getMarketId());
    }

    private Client createClient(String id) {
        Address address = new Address("Vasagatan 38 - updated", null, "Göteborg - updated", null, "42120", "SE", 3);
        List<Integer> markets = Arrays.asList(51);
        return new Client(id, "Dummy - updated", "5562842319U", "UP556284231901", ClientType.ADVERTISER, "FI", "",
                new ArrayList<Bank>(), address,
                new ArrayList<ClientMessageRule>(), markets);
    }
}

