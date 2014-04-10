package com.tradedoubler.billing.fetch;

import com.tradedoubler.billing.platform.flowcontroller.ServiceResult;
import com.tradedoubler.billing.service.crm.CrmService;
import com.tradedoubler.testutil.ApplicationContextUtil;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.*;

/**
 * User: erigu
 * Date: 2012-06-15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext-test.xml"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class FetchEntityTest2 {
    @Autowired
    private ApplicationContext applicationContext;

    private final CrmService crmService = mock(CrmService.class);

    private FetchEntity fetchEntity;

    @Before
    public void setUp() throws Exception {
        ApplicationContextUtil applicationContextUtil = new ApplicationContextUtil(applicationContext);

        applicationContextUtil.registerBeanInstance(crmService);

        fetchEntity = applicationContextUtil.registerAnnotatedBean(FetchEntity.class);

        when(crmService.fetchClientUpdated(any(ServiceResult.class))).thenAnswer(returnsFirstArg());
        when(crmService.fetchInvoiceRecipientDeleted(any(ServiceResult.class))).thenAnswer(returnsFirstArg());
        when(crmService.fetchMarketMessageUpdated(any(ServiceResult.class))).thenAnswer(returnsFirstArg());
        when(crmService.fetchSplittingRuleDeleted(any(ServiceResult.class))).thenAnswer(returnsFirstArg());
        when(crmService.fetchAgreementUpdated(any(ServiceResult.class))).thenAnswer(returnsFirstArg());
        when(crmService.fetchInvoicingRuleCreated(any(ServiceResult.class))).thenAnswer(returnsFirstArg());
        when(crmService.fetchInvoicingRuleUpdated(any(ServiceResult.class))).thenAnswer(returnsFirstArg());
    }

    @After
    public void tearDown() {
        verifyNoMoreInteractions(crmService);
    }

    @Test
    @DirtiesContext
    public void testInvoicingRuleCreated() throws Exception {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setFlowName(FlowName.CreateInvoicingRuleCrm);
        fetchEntity.execute(serviceResult);
        verify(crmService).fetchInvoicingRuleCreated(serviceResult);
    }

    @Test
    @DirtiesContext
    public void testInvoicingRuleUpdated() throws Exception {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setFlowName(FlowName.UpdateInvoicingRuleCrm);
        fetchEntity.execute(serviceResult);
        verify(crmService).fetchInvoicingRuleUpdated(serviceResult);
    }

    @Test
    @DirtiesContext
    public void testAgreementUpdated() throws Exception {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setFlowName(FlowName.UpdateAgreementCrm);
        fetchEntity.execute(serviceResult);
        verify(crmService).fetchAgreementUpdated(serviceResult);
    }

    @Test
    @DirtiesContext
    public void testClientUpdatedCrm() throws Exception {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setFlowName(FlowName.UpdateClientCrm);
        fetchEntity.execute(serviceResult);
        verify(crmService).fetchClientUpdated(serviceResult);
    }

    @Test
    @DirtiesContext
    public void testSplittingRuleDeletedCrm() throws Exception {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setFlowName(FlowName.DeleteSplittingRuleCrm);
        fetchEntity.execute(serviceResult);
        verify(crmService).fetchSplittingRuleDeleted(serviceResult);
    }

    @Test
    @DirtiesContext
    public void testInvoiceRecipientDeletedCrm() throws Exception {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setFlowName(FlowName.DeleteInvoiceRecipientCrm);
        fetchEntity.execute(serviceResult);
        verify(crmService).fetchInvoiceRecipientDeleted(serviceResult);
    }

    @Test
    @DirtiesContext
    public void testMarketMessageUpdatedCrm() throws Exception {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setFlowName(FlowName.UpdateMarketMessageCrm);
        fetchEntity.execute(serviceResult);
        verify(crmService).fetchMarketMessageUpdated(serviceResult);
    }

    @Test
    @DirtiesContext
    public void testFaultyRuleShouldFail() {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setFlowName(FlowName.ConcurrentInstancesOfFlow);
        fetchEntity.execute(serviceResult);
        assertEquals(true, serviceResult.isBugDisturbance());
        assertThat(serviceResult.getErrorMessage(), is("Could not handle flow: ConcurrentInstancesOfFlow"));
    }
}
