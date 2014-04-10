package com.tradedoubler.billing.service.ax.webservice.call;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.webservice.domainhandler.InvoicingRuleHandler;
import com.tradedoubler.billing.util.AxDbConstantsUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.tradedoubler.billing.service.ax.webservice.AxRequestResult.ALL_IS_WELL;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author bjoek
 * @since 2012-07-02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class FindInvoicingRuleCallTest {
    private static final String EXISTING_INVOICE_RULE_ID = AxDbConstantsUtil.EXISTING_INVOICE_RULE_ID;
    private static final String EXISTING_ACCOUNT_NUM = AxDbConstantsUtil.EXISTING_CLIENT_ACCOUNT_NUM;

    @Autowired
    private InvoicingRuleHandler invoicingRuleHandler;

    @Test
    public void findExistingShouldWork() throws BillingServiceException {
        FindInvoicingRuleCall findInvoicingRuleCall = invoicingRuleHandler.findInvoicingRuleByPk(new Guid(EXISTING_INVOICE_RULE_ID), new Market(51));

        assertEquals(findInvoicingRuleCall.getAxRequestResult(), ALL_IS_WELL);
        assertTrue(!findInvoicingRuleCall.getDocumentHash().isEmpty());
        assertThat(findInvoicingRuleCall.getNumberOfInvoicingRules(), is(1));
    }

    @Test
    public void findNonExistingShouldWork() throws BillingServiceException {
        FindInvoicingRuleCall findInvoicingRuleCall = invoicingRuleHandler.findInvoicingRuleByPk(new Guid("Gurka"), new Market(51));

        assertEquals(findInvoicingRuleCall.getAxRequestResult(), ALL_IS_WELL);
        assertThat(findInvoicingRuleCall.getNumberOfInvoicingRules(), is(0));
    }
}
