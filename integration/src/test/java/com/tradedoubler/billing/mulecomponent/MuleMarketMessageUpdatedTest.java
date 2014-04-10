package com.tradedoubler.billing.mulecomponent;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.platform.flowcontroller.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.AxService;
import com.tradedoubler.testutil.ApplicationContextUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * User: erigu
 * Date: 2012-09-25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext-test.xml"})
@DirtiesContext
public class MuleMarketMessageUpdatedTest {
    @Autowired
    private ApplicationContext applicationContext;

    private final AxService axService = mock(AxService.class);
    private final ServiceResult serviceResult = new ServiceResult();

    private MuleMarketMessageUpdated muleMarketMessageUpdated;

    public void setupMock() throws Exception {
        ApplicationContextUtil applicationContextUtil = new ApplicationContextUtil(applicationContext);

        applicationContextUtil.registerBeanInstance(axService);

        muleMarketMessageUpdated = applicationContextUtil.registerAnnotatedBean(MuleMarketMessageUpdated.class);
    }

    @Test
    @DirtiesContext
    public void normalFlowShouldWork() throws Exception {
        setupMock();
        serviceResult.setIntegrationMessage(new IntegrationMessage("", new MetaData("", new Guid(""), new Timestamp(), "", "")));

        when(axService.updateMarketMessage(serviceResult)).thenReturn(serviceResult);

        ServiceResult actualServiceResult = muleMarketMessageUpdated.execute(serviceResult);

        assertFalse(actualServiceResult.isBugDisturbance());
        assertNull(actualServiceResult.getDetailedErrorMessage());
        assertFalse(actualServiceResult.isIntegrationPointDisturbance());
        assertEquals(serviceResult, actualServiceResult);
    }

    @Test
    @DirtiesContext
    public void shouldCreateDisturbance() throws Exception {
        setupMock();
        serviceResult.setIntegrationMessage(new IntegrationMessage("", new MetaData("", new Guid(""), new Timestamp(), "", "")));
        serviceResult.setIntegrationPointDisturbance(true);
        when(axService.updateMarketMessage(serviceResult)).thenReturn(serviceResult);

        ServiceResult actualServiceResult = muleMarketMessageUpdated.execute(serviceResult);

        assertFalse(actualServiceResult.isBugDisturbance());
        assertNull(actualServiceResult.getDetailedErrorMessage());
        assertTrue(actualServiceResult.isIntegrationPointDisturbance());
    }

    @Test
    @DirtiesContext
    public void shouldHandleOutOfSequence() throws Exception {
        setupMock();
        IntegrationMessage integrationMessage = new IntegrationMessage("", new MetaData("", new Guid(""), new Timestamp(), "", ""));
        integrationMessage.setOutOfSequence(true);
        serviceResult.setIntegrationMessage(integrationMessage);
        serviceResult.setIntegrationPointDisturbance(true);
        when(axService.updateMarketMessage(serviceResult)).thenReturn(serviceResult);

        ServiceResult actualServiceResult = muleMarketMessageUpdated.execute(serviceResult);

        assertFalse(actualServiceResult.isBugDisturbance());
        assertNull(actualServiceResult.getDetailedErrorMessage());
        assertTrue(actualServiceResult.isIntegrationPointDisturbance());
    }


    @Test
    @DirtiesContext
    public void shouldCreateBug() throws Exception {
        setupMock();
        serviceResult.setIntegrationMessage(new IntegrationMessage("", new MetaData("", new Guid(""), new Timestamp(), "", "")));
        serviceResult.setBugDisturbance(true);
        when(axService.updateMarketMessage(serviceResult)).thenReturn(serviceResult);

        ServiceResult actualServiceResult = muleMarketMessageUpdated.execute(serviceResult);

        assertTrue(actualServiceResult.isBugDisturbance());
        assertNull(actualServiceResult.getDetailedErrorMessage());
        assertFalse(actualServiceResult.isIntegrationPointDisturbance());
    }


    @Test
    @DirtiesContext
    public void shouldCatchException() throws Exception {
        setupMock();
        serviceResult.setIntegrationMessage(new IntegrationMessage("", new MetaData("", new Guid(""), new Timestamp(), "", "")));

        when(axService.updateMarketMessage(serviceResult)).thenThrow(
                BillingServiceException.createBugDisturbance("Fel någonstans", -42));
        ServiceResult actualServiceResult = muleMarketMessageUpdated.execute(serviceResult);

        assertTrue(actualServiceResult.isBugDisturbance());
        assertEquals("Fel någonstans", actualServiceResult.getDetailedErrorMessage());
        assertFalse(actualServiceResult.isIntegrationPointDisturbance());
    }

    @Test
    @DirtiesContext
    public void shouldHandleException() throws Exception {
        setupMock();
        serviceResult.setIntegrationMessage(new IntegrationMessage("", new MetaData("", new Guid(""), new Timestamp(), "", "")));

        when(axService.updateMarketMessage(serviceResult)).thenThrow(
                new IllegalArgumentException("Fel"));
        ServiceResult actualServiceResult = muleMarketMessageUpdated.execute(serviceResult);

        assertTrue(actualServiceResult.isBugDisturbance());
        assertTrue(actualServiceResult.getDetailedErrorMessage().contains("Fel"));
        assertFalse(actualServiceResult.isIntegrationPointDisturbance());
    }
}
