package com.tradedoubler.billing.service.ax.webservice.call;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.webservice.domainhandler.InvoiceRecipientHandler;
import com.tradedoubler.billing.util.AxDbConstantsUtil;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import static com.tradedoubler.billing.service.ServiceResultCategory.INTEGRATION_DISTURBANCE;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author bjoek
 * @since 2012-07-02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class DeleteInvoiceRecipientCallTest {
    private Market market = new Market(51);

    @Autowired
    private InvoiceRecipientHandler invoiceRecipientHandler;

    @Test
    public void deleteExistingShouldWork() throws BillingServiceException {
        String invoiceRecipientId = AxDbConstantsUtil.generateInvoiceRecipientId();

        InvoiceRecipient invoiceRecipient = createInvoiceRecipient(invoiceRecipientId, createSplittingRules(invoiceRecipientId));
        Market market = new Market(51);

        // Create first ...
        invoiceRecipientHandler.insertInvoiceRecipient(invoiceRecipient, market);

        // ... then delete
        invoiceRecipientHandler.deleteInvoiceRecipient(new Guid(invoiceRecipientId), market);
    }

    @Test
    public void deleteNonExistingShouldNotWork() throws BillingServiceException {
        try {
            invoiceRecipientHandler.deleteInvoiceRecipient(new Guid("gurka"), market);
            fail();
        } catch (BillingServiceException bsex) {
            assertThat(bsex.getCategory(), is(INTEGRATION_DISTURBANCE));
            assertThat(bsex.getMessage(), Matchers.startsWith("InvoiceRecipient PK: {GURKA}, dataAreaId: SE02  , No valid document identified from the entity key"));
        }
    }

    private ArrayList<SplittingRule> createSplittingRules(String invoiceRecipientId, String... ids) {
        ArrayList<SplittingRule> splittingRules = new ArrayList<SplittingRule>();
        for (String id : ids) {
            splittingRules.add(new SplittingRule(id, invoiceRecipientId, "sp - upd"));
        }
        return splittingRules;
    }

    private InvoiceRecipient createInvoiceRecipient(String id, ArrayList<SplittingRule> splittingRules) {
        Address address = new Address("Vasagatan 38 - upd", null, "Göteborg - upd", null, "11124", "FI", 1);
        return new InvoiceRecipient(id, AxDbConstantsUtil.EXISTING_INVOICE_RULE_ID, "Att1 - utpdat", "Att2 - utpdat", "email - utpdat", true, address,
                splittingRules);
    }
}
