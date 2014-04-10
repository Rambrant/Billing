package com.tradedoubler.billing.service.ax.webservice.call;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.webservice.domainhandler.BankHandler;
import com.tradedoubler.billing.util.AxDbConstantsUtil;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import static com.tradedoubler.billing.util.AxDbConstantsUtil.EXISTING_CLIENT_ACCOUNT_NUM;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * @author bjoek
 * @since 2012-07-02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class UpdateBankCallTest {

    @Autowired
    private BankHandler bankHandler;

    @Test
    public void updateExistingShouldWork() throws BillingServiceException {
        Bank bank = createBank(EXISTING_CLIENT_ACCOUNT_NUM);
        FindBankCall readBankCall = bankHandler.findBankByPk(bank.getClientId(), bank.getMarketId());

        Market market = new Market(51);
        bankHandler.updateBank(readBankCall, bank, market);
    }

    @Test
    public void updateNonExistingShouldNotWork() throws BillingServiceException {
        Bank bank = createBank(EXISTING_CLIENT_ACCOUNT_NUM);
        FindBankCall readBankCall = bankHandler.findBankByPk(bank.getClientId(), bank.getMarketId());

        // Change client id
        String clientId = AxDbConstantsUtil.generateClientId();
        bank.setClientId(clientId);

        Market market = new Market(51);
        try {
            bankHandler.updateBank(readBankCall, bank, market);
            fail();
        } catch (BillingServiceException bsex) {
            assertThat(bsex.getMessage(), Matchers.startsWith("Bank PK: bankAccount: 1 customerAccount: " + clientId +
                    ", dataAreaId: SE02  , No valid document identified from the entity key"));
        }
    }

    @Test
    public void updateWithInvalidHashShouldNotWork() throws BillingServiceException {
        Bank bank = createBank(EXISTING_CLIENT_ACCOUNT_NUM);
        FindBankCall readBankCall = spy(bankHandler.findBankByPk(bank.getClientId(), bank.getMarketId()));

        // Change hash
        QName _AxdEntityCustBankAccountDocumentHash_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGCustBank", "_DocumentHash");
        JAXBElement<String> docHash = new JAXBElement<String>(_AxdEntityCustBankAccountDocumentHash_QNAME, String.class, "dummy");
        when(readBankCall.getDocumentHash()).thenReturn(docHash);

        Market market = new Market(51);
        try {
            bankHandler.updateBank(readBankCall, bank, market);
            fail();
        } catch (BillingServiceException bsex) {
            assertThat(bsex.getMessage(), Matchers.startsWith("Bank PK: bankAccount: 1 customerAccount: TELIA, dataAreaId: SE02  , The document hash does not match the hash in the XML."));
        }
    }

    private Bank createBank(String clientId) {
        return new Bank(clientId, 51, "SWED UPD", "1234567890123456789012", "Someone at Volvo - updated");
    }

}
