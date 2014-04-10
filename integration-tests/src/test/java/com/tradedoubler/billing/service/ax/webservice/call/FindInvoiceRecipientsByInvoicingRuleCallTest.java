package com.tradedoubler.billing.service.ax.webservice.call;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.webservice.domainhandler.InvoiceRecipientHandler;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

import static com.tradedoubler.billing.util.AxDbConstantsUtil.EXISTING_INVOICE_RULE_ID;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author bjoek
 * @since 2012-07-02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class FindInvoiceRecipientsByInvoicingRuleCallTest {

    @Autowired
    private InvoiceRecipientHandler invoiceRecipientHandler;

    @Test
    @Ignore("The method findInvoiceRecipientsToDelete does not exist any more, use a different method instead")
    public void findExistingShouldWork() throws BillingServiceException {
        Guid invoicingRuleId = new Guid(EXISTING_INVOICE_RULE_ID);
//        List<Guid> invoiceRecipientsToDelete = invoiceRecipientHandler.findInvoiceRecipientsToDelete(invoicingRuleId, new Market(51), new ArrayList<InvoiceRecipient>());
        List<Guid> invoiceRecipientsToDelete = null;

        assertNotNull(invoiceRecipientsToDelete);
        System.out.printf("Found %d items%n", invoiceRecipientsToDelete.size());
    }

    @Test
    @Ignore("The method findInvoiceRecipientsToDelete does not exist any more, use a different method instead")
    public void findNonExistingShouldWork() throws BillingServiceException {
        Guid invoicingRuleId = new Guid("Gurka");

//        List<Guid> invoiceRecipientsToDelete = invoiceRecipientHandler.findInvoiceRecipientsToDelete(invoicingRuleId, new Market(51), new ArrayList<InvoiceRecipient>());
        List<Guid> invoiceRecipientsToDelete = null;

        assertNotNull(invoiceRecipientsToDelete);
        assertThat(invoiceRecipientsToDelete.size(), is(0));
    }

}
