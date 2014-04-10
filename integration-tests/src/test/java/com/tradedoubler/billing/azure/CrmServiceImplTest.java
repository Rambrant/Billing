package com.tradedoubler.billing.azure;

import com.tradedoubler.billing.platform.flowcontroller.ServiceResult;
import com.tradedoubler.billing.service.crm.CrmServiceImpl;
import org.junit.*;
import org.springframework.context.support.*;

import static org.junit.Assert.assertNotNull;


/**
 * User: erigu
 * Date: 2012-06-19
 */
public class CrmServiceImplTest {

    private CrmServiceImpl crmService;

    @Before
    public void setup() {
        GenericApplicationContext context = new GenericXmlApplicationContext("/spring/springPropertiesContext.xml",
                "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml");
        crmService = context.getBean(CrmServiceImpl.class);
    }

    @Test
    public void fetchAgreementUpdatedShallWork() throws Exception {
        ServiceResult result = crmService.fetchAgreementUpdated(new ServiceResult());
        assertNotNull(result);
    }

    @Test
    public void fetchClientUpdatedShallWork() throws Exception {
        ServiceResult result = crmService.fetchClientUpdated(new ServiceResult());
        assertNotNull(result);

    }

    @Test
    public void fetchInvoiceRecipientDeletedShallWork() throws Exception {
        ServiceResult result = crmService.fetchInvoiceRecipientDeleted(new ServiceResult());
        assertNotNull(result);

    }

    @Test
    public void fetchInvoicingRuleCreatedShallWork() throws Exception {
        ServiceResult result = crmService.fetchInvoicingRuleCreated(new ServiceResult());
        assertNotNull(result);

    }

    @Test
    public void fetchInvoicingRuleUpdatedShallWork() throws Exception {
        ServiceResult result = crmService.fetchInvoicingRuleUpdated(new ServiceResult());
        assertNotNull(result);

    }

    @Test
    public void fetchSplittingRuleDeletedShallWork() throws Exception {
        ServiceResult result = crmService.fetchSplittingRuleDeleted(new ServiceResult());
        assertNotNull(result);

    }

}
