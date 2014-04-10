package com.tradedoubler.billing.service.ax.webservice.call;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.webservice.AxRequestResult;
import com.tradedoubler.billing.service.ax.webservice.domainhandler.InvoiceMessageRuleHandler;
import com.tradedoubler.billing.util.AxDbConstantsUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * User: erigu
 * Date: 2012-09-10
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class FindInvoiceMessageRuleCallTest {

    @Autowired
    InvoiceMessageRuleHandler invoiceMessageRuleHandler;

    @Test
    public void findExistingShouldWork() throws BillingServiceException {
        Guid invoiceMessageRuleId = new Guid(AxDbConstantsUtil.EXISTING_INVOICE_MESSAGE_RULE_CLIENT_ID);
        FindInvoiceMessageRuleCall findInvoiceMessageRuleCall = invoiceMessageRuleHandler.findInvoiceMessageRuleByPk(invoiceMessageRuleId, new Market(51));
        assertEquals(AxRequestResult.ALL_IS_WELL, findInvoiceMessageRuleCall.getAxRequestResult());
        assertThat(findInvoiceMessageRuleCall.getNumberOfInvoiceMessageRules(), is(1));
    }

    @Test
    public void findExistingShouldWorkOnMultipleMarkets() throws BillingServiceException {
        //The invoice message is on TELIA and they are both on the swedish and finnish market
        Guid invoiceMessageRuleId = new Guid(AxDbConstantsUtil.EXISTING_INVOICE_MESSAGE_RULE_CLIENT_ID);

        // Swedish market
        FindInvoiceMessageRuleCall findInvoiceMessageRuleCall = invoiceMessageRuleHandler.findInvoiceMessageRuleByPk(invoiceMessageRuleId, new Market(51));
        assertEquals(AxRequestResult.ALL_IS_WELL, findInvoiceMessageRuleCall.getAxRequestResult());

        // Finnish market
        findInvoiceMessageRuleCall = invoiceMessageRuleHandler.findInvoiceMessageRuleByPk(invoiceMessageRuleId, new Market(135926));
        assertEquals(AxRequestResult.ALL_IS_WELL, findInvoiceMessageRuleCall.getAxRequestResult());
    }

    @Test
    public void findNonExistingShouldWork() throws BillingServiceException {
        Guid invoiceMessageRuleId = new Guid("gurka");

        FindInvoiceMessageRuleCall findInvoiceMessageRuleCall = invoiceMessageRuleHandler.findInvoiceMessageRuleByPk(invoiceMessageRuleId, new Market(51));
        assertEquals(AxRequestResult.ALL_IS_WELL, findInvoiceMessageRuleCall.getAxRequestResult());
        assertThat(findInvoiceMessageRuleCall.getNumberOfInvoiceMessageRules(), is(0));
    }

}
