package com.tradedoubler.billing.service.ax.webservice.call;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.webservice.domainhandler.InvoiceRecipientHandler;
import com.tradedoubler.billing.util.AxDbConstantsUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.tradedoubler.billing.service.ax.webservice.AxRequestResult.ALL_IS_WELL;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

/**
 * @author bjoek
 * @since 2012-07-02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class FindInvoiceRecipientCallTest {

    @Autowired
    private InvoiceRecipientHandler invoiceRecipientHandler;

    @Test
    public void findExistingShouldWork() throws BillingServiceException {
        Market market = new Market(51);

        FindInvoiceRecipientCall findCall = invoiceRecipientHandler.findInvoiceRecipientByPk(new Guid(AxDbConstantsUtil.EXISTING_INVOICE_RECIPIENT_ID), market);

        assertEquals(findCall.getErrorMessage(), findCall.getAxRequestResult(), ALL_IS_WELL);
        assertEquals(findCall.getNumberOfInvoiceRecipient(), 1);
        assertTrue(!findCall.getDocumentHash().getValue().isEmpty());
        //assertThat(findCall.getSplitters().size(), is(1));
        assertThat(findCall.getValidAsOfDateTime(), notNullValue());
        assertThat(findCall.getLogisticLocationRecId(), notNullValue());
        assertThat(findCall.getPostalAddressLocationId(), notNullValue());
        assertThat(findCall.getPostalAddressRecId(), notNullValue());
    }

    @Test
    public void findNonExistingShouldWork() throws BillingServiceException {
        Market market = new Market(51);

        FindInvoiceRecipientCall findInvoiceRecipientCall = invoiceRecipientHandler.findInvoiceRecipientByPk(new Guid("gurka"), market);

        assertEquals(findInvoiceRecipientCall.getErrorMessage(), findInvoiceRecipientCall.getAxRequestResult(), ALL_IS_WELL);
        assertEquals(findInvoiceRecipientCall.getNumberOfInvoiceRecipient(), 0);
    }
}
