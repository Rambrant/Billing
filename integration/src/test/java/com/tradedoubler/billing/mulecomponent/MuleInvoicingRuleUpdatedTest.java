package com.tradedoubler.billing.mulecomponent;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.platform.flowcontroller.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.AxService;
import com.tradedoubler.billing.service.pan.PanService;
import com.tradedoubler.testutil.ApplicationContextUtil;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * @author bjoek
 * @since 2012-08-20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext-test.xml"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class MuleInvoicingRuleUpdatedTest {
    @Autowired
    private ApplicationContext applicationContext;

    private final AxService axService = mock(AxService.class);
    private final PanService panService = mock(PanService.class);
    private final ServiceResult serviceResult = new ServiceResult();

    private MuleInvoicingRuleUpdated componentToTest;

    @Before
    public void setup() {
        serviceResult.setIntegrationMessage(new IntegrationMessage("", new MetaData("", new Guid(""), new Timestamp(), "", "")));
    }

    @Test
    @DirtiesContext
    public void normalFlowShouldWork() throws Exception {
        setupMock();

        when(axService.updateInvoicingRule(serviceResult)).thenReturn(serviceResult);
        when(panService.updateDisplayTradeDoublerCommission(serviceResult)).thenReturn(serviceResult);

        ServiceResult actualServiceResult = componentToTest.execute(serviceResult);

        assertThat(actualServiceResult.isBugDisturbance(), is(false));
        assertThat(actualServiceResult.getDetailedErrorMessage(), nullValue());
        assertThat(actualServiceResult.isIntegrationPointDisturbance(), is(false));

        verify(axService).updateInvoicingRule(serviceResult);
    }

    @Test
    @DirtiesContext
    public void runtimeExeceptionShouldBeStoredInServiceResult() throws Exception {
        setupMock();

        when(axService.updateInvoicingRule(serviceResult)).thenThrow(
                new IllegalArgumentException("Fel någonstans"));

        ServiceResult actualServiceResult = componentToTest.execute(serviceResult);

        assertThat(actualServiceResult.isBugDisturbance(), is(true));
        assertThat(actualServiceResult.getDetailedErrorMessage(), startsWith("java.lang.IllegalArgumentException: Fel någonstans"));

        verify(axService).updateInvoicingRule(serviceResult);
    }

    @Test
    @DirtiesContext
    public void billingExeceptionShouldBeStoredInServiceResult() throws Exception {
        setupMock();

        when(axService.updateInvoicingRule(serviceResult)).thenThrow(
                BillingServiceException.createBugDisturbance("Fel någonstans", -42));

        ServiceResult actualServiceResult = componentToTest.execute(serviceResult);

        assertThat(actualServiceResult.isIntegrationPointDisturbance(), is(false));
        assertThat(actualServiceResult.isBugDisturbance(), is(true));
        assertThat(actualServiceResult.getDetailedErrorMessage(), startsWith("Fel någonstans"));

        verify(axService).updateInvoicingRule(serviceResult);
    }

    @Test
    public void outOfSequenceShouldPassThough() throws Exception {
        ServiceResult failServiceResult = new ServiceResult();
        IntegrationMessage integrationMessage = new IntegrationMessage("", null);
        integrationMessage.setOutOfSequence(true);
        failServiceResult.setIntegrationMessage(integrationMessage);

        componentToTest = new MuleInvoicingRuleUpdated();

        assertThat(componentToTest.execute(failServiceResult), is(failServiceResult));
    }

    @Test
    public void disturbanceShouldPassThough() throws Exception {
        ServiceResult failServiceResult = new ServiceResult();
        failServiceResult.setBugDisturbance(true);
        failServiceResult.setIntegrationMessage(new IntegrationMessage("", null));

        componentToTest = new MuleInvoicingRuleUpdated();

        assertThat(componentToTest.execute(failServiceResult), is(failServiceResult));
    }

    public void setupMock() throws Exception {
        ApplicationContextUtil applicationContextUtil = new ApplicationContextUtil(applicationContext);

        applicationContextUtil.registerBeanInstance(axService);
        applicationContextUtil.registerBeanInstance(panService);

        componentToTest = applicationContextUtil.registerAnnotatedBean(MuleInvoicingRuleUpdated.class);
    }
}
