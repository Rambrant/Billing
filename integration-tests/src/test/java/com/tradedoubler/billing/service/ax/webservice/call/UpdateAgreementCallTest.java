package com.tradedoubler.billing.service.ax.webservice.call;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.webservice.domainhandler.AgreementHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import static com.tradedoubler.billing.util.AxDbConstantsUtil.*;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * @author bjoek
 * @since 2012-07-02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class UpdateAgreementCallTest {

    @Autowired
    private AgreementHandler agreementHandler;

    @Test
    public void updateExistingShouldWork() throws BillingServiceException {
        Agreement agreement = createAgreement(EXISTING_AGREEMENT_ID);
        FindAgreementCall readAgreementCall = agreementHandler.findAgreementByPk(EXISTING_AGREEMENT_ID, new Market(51));

        agreementHandler.updateAgreement(readAgreementCall, agreement);
    }

    @Test
    public void updateNonExistingShouldNotWork() throws BillingServiceException {
        Agreement agreement = createAgreement(EXISTING_AGREEMENT_ID);
        FindAgreementCall readAgreementCall = agreementHandler.findAgreementByPk(EXISTING_AGREEMENT_ID, new Market(51));

        String id = generateAgreementId();
        agreement.setSourceSystemAgreementId(id);

        try {
            agreementHandler.updateAgreement(readAgreementCall, agreement);
            fail();
        } catch (BillingServiceException bsex) {
            assertThat(bsex.getMessage(), startsWith("Agreement PK: " + id + ", dataAreaId: SE02  , No valid document identified from the entity key."));
        }
    }

    @Test
    public void updateWithInvalidHashShouldNotWork() throws BillingServiceException {
        Agreement agreement = createAgreement(EXISTING_AGREEMENT_ID);
        FindAgreementCall readAgreementCall = spy(agreementHandler.findAgreementByPk(EXISTING_AGREEMENT_ID, new Market(51)));

        QName _AxdEntityMDSSalesClientAgreementDocumentHash_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSalesClA", "_DocumentHash");
        JAXBElement<String> docHash = new JAXBElement<String>(_AxdEntityMDSSalesClientAgreementDocumentHash_QNAME, String.class, "Dummy");
        when(readAgreementCall.getDocumentHash()).thenReturn(docHash);

        try {
            agreementHandler.updateAgreement(readAgreementCall, agreement);
            fail();
        } catch (BillingServiceException bsex) {
            assertThat(bsex.getMessage(), startsWith("Agreement PK: TTHHQXTScafebabe0003, dataAreaId: SE02  , The document hash does not match the hash in the XML."));
        }
    }

    private Agreement createAgreement(String id) {
        return new Agreement(id, EXISTING_CLIENT_ACCOUNT_NUM, EXISTING_INVOICE_RULE_ID,
                "test - updated", 1, 51, "EUR", new Timestamp(), new Timestamp(), "\\\\someserver\\somefolder\\somefile.pdf");
    }


}
