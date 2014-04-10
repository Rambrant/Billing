package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalescla.AxdEntityMDSSalesClientAgreement;
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

import java.util.List;

import static com.tradedoubler.billing.service.ax.webservice.call.WebServiceCallTestUtil.*;
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
public class InsertAgreementCallTest {

    @Autowired
    private AgreementHandler agreementHandler;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void createNewShouldWork() throws BillingServiceException {
        String id = AxDbConstantsUtil.generateAgreementId();

        Agreement agreement = createAgreement(id, AxDbConstantsUtil.EXISTING_CLIENT_ACCOUNT_NUM,
                AxDbConstantsUtil.EXISTING_INVOICE_RULE_ID, 51);
        agreementHandler.insertAgreement(agreement);

        verifyAgreementInAx(id, agreement);
    }

    private void verifyAgreementInAx(String id, Agreement expected) throws BillingServiceException {
        FindAgreementCall findAgreementCall = agreementHandler.findAgreementByPk(id, expected.getMarketId());
        assertThat(findAgreementCall.getNumberOfAgreements(), is(1));
        List<AxdEntityMDSSalesClientAgreement> salesClientAgreements = findAgreementCall.getSalesClientAgreements();
        AxdEntityMDSSalesClientAgreement salesClientAgreement = salesClientAgreements.get(0);

        collector.checkThat(salesClientAgreement.getSourceSystemAgreementId(), is(id));
        collector.checkThat(salesClientAgreement.getCustId(), is(expected.getClientId()));
        collector.checkThat(salesClientAgreement.getDescription(), is(expected.getDescription()));
        collector.checkThat(salesClientAgreement.getDocumentLink().getValue(), is(expected.getDocumentLink()));
        collector.checkThat(salesClientAgreement.getProductTypeId(), is("" + expected.getProductType().getValue()));
        collector.checkThat(salesClientAgreement.getValidFrom().toString(), is(expected.getValidFrom().toString().substring(0, 10)));
        collector.checkThat(salesClientAgreement.getValidTo().toString(), is(expected.getValidTo().toString().substring(0, 10)));
        collector.checkThat(salesClientAgreement.getCurrencyCode(), is(expected.getCurrencyCode().getCurrencyCode()));
        collector.checkThat(salesClientAgreement.getInvoiceRuleId(), is(expected.getInvoicingRuleId().getGuidForAx()));
        collector.checkThat(salesClientAgreement.getBelongsToDataAreaId(), is("SE02"));
    }

    @Test
    public void createNewWithNullDateShouldWork() throws BillingServiceException {
        String id = AxDbConstantsUtil.generateAgreementId();

        Agreement agreement = createAgreementWithNullDates(id, AxDbConstantsUtil.EXISTING_CLIENT_ACCOUNT_NUM,
                AxDbConstantsUtil.EXISTING_INVOICE_RULE_ID, 51);
//        System.out.println("AgreementId: " + id);
        agreementHandler.insertAgreement(agreement);
    }

    @Test
    public void createExistingShouldNotWork() throws BillingServiceException {
        Agreement agreement = createAgreement(AxDbConstantsUtil.EXISTING_AGREEMENT_ID,
                AxDbConstantsUtil.EXISTING_CLIENT_ACCOUNT_NUM, AxDbConstantsUtil.EXISTING_INVOICE_RULE_ID, 51);

        try {
            agreementHandler.insertAgreement(agreement);
            fail();
        } catch (BillingServiceException bsex) {
            assertThat(bsex.getMessage(), startsWith("Agreement"));
            assertThat(bsex.getMessage(), endsWith("The record already exists."));
            assertThat(bsex.getCategory(), Matchers.is(ServiceResultCategory.INTEGRATION_DISTURBANCE));
        }
    }

}
