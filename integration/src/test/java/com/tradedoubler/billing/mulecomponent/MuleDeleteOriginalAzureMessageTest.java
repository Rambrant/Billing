package com.tradedoubler.billing.mulecomponent;

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
public class MuleDeleteOriginalAzureMessageTest {
    @Autowired
    private ApplicationContext applicationContext;

    private final CrmService crmService = mock(CrmService.class);
    private final ServiceResult serviceResult = new ServiceResult();

    private MuleDeleteOriginalAzureMessage componentToTest;

    @Before
    public void setUp() throws Exception {
        ApplicationContextUtil applicationContextUtil = new ApplicationContextUtil(applicationContext);

        applicationContextUtil.registerBeanInstance(crmService);

        componentToTest = applicationContextUtil.registerAnnotatedBean(MuleDeleteOriginalAzureMessage.class);
    }

    @Test
    @DirtiesContext
    public void normalFlowShouldWork() throws Exception {
        when(crmService.deleteOriginalMessage(serviceResult)).thenReturn(serviceResult);

        ServiceResult actualServiceResult = componentToTest.execute(serviceResult);

        assertThat(actualServiceResult.isBugDisturbance(), is(false));
        assertThat(actualServiceResult.getDetailedErrorMessage(), nullValue());
        assertThat(actualServiceResult.isIntegrationPointDisturbance(), is(false));

        verify(crmService).deleteOriginalMessage(serviceResult);
    }

    @Test
    @DirtiesContext
    public void runtimeExeceptionShouldBeStoredInServiceResult() throws Exception {
        when(crmService.deleteOriginalMessage(serviceResult)).thenThrow(
                new IllegalArgumentException("Fel någonstans"));

        ServiceResult actualServiceResult = componentToTest.execute(serviceResult);

        assertThat(actualServiceResult.isBugDisturbance(), is(true));
        assertThat(actualServiceResult.getDetailedErrorMessage(), startsWith("java.lang.IllegalArgumentException: Fel någonstans"));

        verify(crmService).deleteOriginalMessage(serviceResult);
    }

}
