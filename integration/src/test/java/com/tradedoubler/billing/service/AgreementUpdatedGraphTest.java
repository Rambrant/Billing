package com.tradedoubler.billing.service;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalescla.AxdEntityMDSSalesClientAgreement;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.platform.flowcontroller.*;
import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

/**
 * @author bjoek
 * @since 2012-09-04
 */
public class AgreementUpdatedGraphTest extends AbstractGraphHelper {

    private static final DomainEntityFactory domainEntityFactory = new DomainEntityFactory();
    private final Agreement agreement = domainEntityFactory.createAgreement();
    private ServiceResult serviceResultAgreement;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    public AgreementUpdatedGraphTest() throws IllegalAccessException {
        super();
    }

    @Before
    public void setUp() throws Exception {
        serviceResultAgreement = createServiceResult(new AgreementUpdated(null, agreement));
    }

    @Test
    public void agreementUpdatedWithExistingShouldUpdate() throws Exception {
        when(findAgreementCall.getNumberOfAgreements()).thenReturn(1);

        axService.updateAgreement(serviceResultAgreement);

        verify(findAgreementCall).execute(agreement.getSourceSystemAgreementId(), "SE02");
        verify(updateAgreementCall).execute(any(AxdEntityMDSSalesClientAgreement.class));
    }

    @Test
    public void agreementUpdatedWithNoExistingShouldInsert() throws Exception {
        when(findAgreementCall.getNumberOfAgreements()).thenReturn(0);

        axService.updateAgreement(serviceResultAgreement);

        verify(findAgreementCall).execute(agreement.getSourceSystemAgreementId(), "SE02");
        verify(insertAgreementCall).execute(any(AxdEntityMDSSalesClientAgreement.class));
    }

    @Test
    public void agreementUpdatedWithMultipleHitShouldGenerateException() throws Exception {
        expectedException.expect(BillingServiceException.class);
        expectedException.expectMessage(is("Found more than one Agreement in Ax with AgreementId: sourceSystemAgreementId"));

        when(findAgreementCall.getNumberOfAgreements()).thenReturn(2);

        axService.updateAgreement(serviceResultAgreement);
    }

}
