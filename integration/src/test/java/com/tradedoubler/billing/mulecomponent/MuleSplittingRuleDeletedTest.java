package com.tradedoubler.billing.mulecomponent;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.platform.flowcontroller.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.AxService;
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
public class MuleSplittingRuleDeletedTest {
    @Autowired
    private ApplicationContext applicationContext;

    private final AxService axService = mock(AxService.class);
    private final ServiceResult serviceResult = new ServiceResult();

    private MuleSplittingRuleDeleted componentToTest;

    @Before
    public void setup() {
        serviceResult.setIntegrationMessage(new IntegrationMessage("", new MetaData("", new Guid(""), new Timestamp(), "", "")));
    }

    @Test
    @DirtiesContext
    public void normalFlowShouldWork() throws Exception {
        setupMock();

        when(axService.deleteSplittingRule(serviceResult)).thenReturn(serviceResult);

        ServiceResult actualServiceResult = componentToTest.execute(serviceResult);

        assertThat(actualServiceResult.isBugDisturbance(), is(false));
        assertThat(actualServiceResult.getDetailedErrorMessage(), nullValue());
        assertThat(actualServiceResult.isIntegrationPointDisturbance(), is(false));

        verify(axService).deleteSplittingRule(serviceResult);
    }

    @Test
    @DirtiesContext
    public void runtimeExeceptionShouldBeStoredInServiceResult() throws Exception {
        setupMock();

        when(axService.deleteSplittingRule(serviceResult)).thenThrow(
                new IllegalArgumentException("Fel någonstans"));

        ServiceResult actualServiceResult = componentToTest.execute(serviceResult);

        assertThat(actualServiceResult.isBugDisturbance(), is(true));
        assertThat(actualServiceResult.getDetailedErrorMessage(), startsWith("java.lang.IllegalArgumentException: Fel någonstans"));

        verify(axService).deleteSplittingRule(serviceResult);
    }

    @Test
    @DirtiesContext
    public void billingExeceptionShouldBeStoredInServiceResult() throws Exception {
        setupMock();

        when(axService.deleteSplittingRule(serviceResult)).thenThrow(
                BillingServiceException.createBugDisturbance("Fel någonstans", -42));

        ServiceResult actualServiceResult = componentToTest.execute(serviceResult);

        assertThat(actualServiceResult.isIntegrationPointDisturbance(), is(false));
        assertThat(actualServiceResult.isBugDisturbance(), is(true));
        assertThat(actualServiceResult.getDetailedErrorMessage(), startsWith("Fel någonstans"));

        verify(axService).deleteSplittingRule(serviceResult);
    }

    @Test
    public void outOfSequenceShouldPassThough() throws Exception {
        ServiceResult failServiceResult = new ServiceResult();
        IntegrationMessage integrationMessage = new IntegrationMessage("", null);
        integrationMessage.setOutOfSequence(true);
        failServiceResult.setIntegrationMessage(integrationMessage);

        componentToTest = new MuleSplittingRuleDeleted();

        assertThat(componentToTest.execute(failServiceResult), is(failServiceResult));
    }

    @Test
    public void disturbanceShouldPassThough() throws Exception {
        ServiceResult failServiceResult = new ServiceResult();
        failServiceResult.setBugDisturbance(true);
        failServiceResult.setIntegrationMessage(new IntegrationMessage("", null));

        componentToTest = new MuleSplittingRuleDeleted();

        assertThat(componentToTest.execute(failServiceResult), is(failServiceResult));
    }

    public void setupMock() throws Exception {
        ApplicationContextUtil applicationContextUtil = new ApplicationContextUtil(applicationContext);

        applicationContextUtil.registerBeanInstance(axService);

        componentToTest = applicationContextUtil.registerAnnotatedBean(MuleSplittingRuleDeleted.class);
    }

}
