package com.tradedoubler.billing.service.ax.webservice.call;

import com.tradedoubler.billing.domain.Market;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.webservice.AxRequestResult;
import com.tradedoubler.billing.service.ax.webservice.domainhandler.AgreementHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.tradedoubler.billing.util.AxDbConstantsUtil.EXISTING_AGREEMENT_ID;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author bjoek
 * @since 2012-07-02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class FindAgreementCallTest {

    @Autowired
    private AgreementHandler agreementHandler;

    @Test
    public void findExistingShouldWork() throws BillingServiceException {
        FindAgreementCall findAgreementCall = agreementHandler.findAgreementByPk(EXISTING_AGREEMENT_ID, new Market(51));

        assertEquals(findAgreementCall.getAxRequestResult(), AxRequestResult.ALL_IS_WELL);
        assertThat(findAgreementCall.getSalesClientAgreements().size(), is(1));
        assertTrue(!findAgreementCall.getDocumentHash().getValue().isEmpty());
    }

    @Test
    public void findNonExistingShouldWork() throws BillingServiceException {
        FindAgreementCall findAgreementCall = agreementHandler.findAgreementByPk("Gurka", new Market(51));

        assertEquals(findAgreementCall.getAxRequestResult(), AxRequestResult.ALL_IS_WELL);
        assertThat(findAgreementCall.getSalesClientAgreements().size(), is(0));
    }

}
