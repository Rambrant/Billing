package com.tradedoubler.billing.service;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvrec.AxdEntityMDSSalesInvoiceRecipient;
import com.tradedoubler.billing.domain.InvoiceRecipientDeleted;
import com.tradedoubler.billing.platform.flowcontroller.ServiceResult;
import com.tradedoubler.billing.service.ax.webservice.AxRequestResult;
import org.junit.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * @author bjoek
 * @since 2012-09-04
 */
public class InvoiceRecipientDeletedGraphTest extends AbstractGraphHelper {
    private ServiceResult serviceResultAgreement;

    private final String invoiceRecipientId = "invoiceRecipientId";

    public InvoiceRecipientDeletedGraphTest() throws IllegalAccessException {
        super();
    }

    @Before
    public void setUp() throws Exception {
        serviceResultAgreement = createServiceResult(new InvoiceRecipientDeleted(null, invoiceRecipientId, 51));
    }

    @Test
    public void deleteExistingInvoiceRecipientShouldWork() throws Exception {
        when(findInvoiceRecipientCall.getNumberOfInvoiceRecipient()).thenReturn(1);
        when(findInvoiceRecipientCall.getInvoiceRecipient()).thenReturn(new AxdEntityMDSSalesInvoiceRecipient());
        when(deleteInvoiceRecipientCall.getAxRequestResult()).thenReturn(AxRequestResult.ALL_IS_WELL);

        ServiceResult serviceResult = axService.deleteInvoiceRecipient(serviceResultAgreement);

        verify(deleteInvoiceRecipientCall).execute("{" + invoiceRecipientId.toUpperCase() + "}", "SE02");
        assertThat(serviceResult.isDisturbance(), is(false));
    }

    @Test
    public void deleteNonExistingInvoiceRecipientShouldThrowException() throws Exception {
        try{
            axService.deleteInvoiceRecipient(serviceResultAgreement);
            fail();
        } catch (BillingServiceException bsex) {
            assertThat(bsex.getMessage(), is("Could not find the InvoiceRecipient to delete, invoiceRecipientId: {INVOICERECIPIENTID}"));
        }

        verify(findInvoiceRecipientCall, atLeast(1)).getNumberOfInvoiceRecipient();
    }

}
