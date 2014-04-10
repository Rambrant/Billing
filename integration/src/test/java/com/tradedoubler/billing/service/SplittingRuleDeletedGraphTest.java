package com.tradedoubler.billing.service;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvrec.*;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.platform.flowcontroller.ServiceResult;
import com.tradedoubler.billing.service.ax.webservice.AxRequestResult;
import org.hamcrest.Matchers;
import org.junit.*;

import javax.xml.bind.JAXBElement;
import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * @author bjoek
 * @since 2012-09-04
 */
public class SplittingRuleDeletedGraphTest extends AbstractGraphHelper {
    private ServiceResult serviceResultAgreement;

    private final String invoiceRecipientId = "invoiceRecipientId";
    private final String splittingRuleId = "splittingRuleId";

    public SplittingRuleDeletedGraphTest() throws IllegalAccessException {
        super();
    }

    @Before
    public void setUp() throws Exception {
        serviceResultAgreement = createServiceResult(new SplittingRuleDeleted(null, splittingRuleId, invoiceRecipientId, 51));
    }

    private AxdEntityMDSSalesInvoiceRecipient createAxEntity() {
        AxdEntityMDSSalesSplitter splitter = new AxdEntityMDSSalesSplitter();
        splitter.setSplitterId(new Guid(splittingRuleId).getGuidForAx());

        AxdEntityLogisticsPostalAddress axdEntityLogisticsPostalAddress = new AxdEntityLogisticsPostalAddress();

        AxdEntityLogisticsLocation logisticsLocation = new AxdEntityLogisticsLocation();
        logisticsLocation.getLogisticsPostalAddress().add(axdEntityLogisticsPostalAddress);

        AxdEntityMDSSalesInvoiceRecipient axdEntityMDSSalesInvoiceRecipient = new AxdEntityMDSSalesInvoiceRecipient();
        axdEntityMDSSalesInvoiceRecipient.getMDSSalesSplitter().add(splitter);
        axdEntityMDSSalesInvoiceRecipient.getLogisticsLocation().add(logisticsLocation);

        return axdEntityMDSSalesInvoiceRecipient;
    }

    @Test
    public void deleteExistingSplittingRuleShouldWork() throws Exception {
        AxdEntityMDSSalesInvoiceRecipient axEntity = createAxEntity();

        when(findInvoiceRecipientCall.getNumberOfInvoiceRecipient()).thenReturn(1);
        when(findInvoiceRecipientCall.getSplitters()).thenReturn(axEntity.getMDSSalesSplitter());
        when(findInvoiceRecipientCall.getInvoiceRecipient()).thenReturn(axEntity);

        ServiceResult serviceResult = axService.deleteSplittingRule(serviceResultAgreement);

        verify(findInvoiceRecipientCall).execute("{" + invoiceRecipientId.toUpperCase() + "}", "SE02");
        verify(updateInvoiceRecipientCall).execute(any(AxdEntityMDSSalesInvoiceRecipient.class), any(JAXBElement.class), eq("SE02"));
        assertThat(serviceResult.isDisturbance(), is(false));
    }

    @Test
    public void InvoiceRecipientNotFoundShouldThrowException() throws Exception {
        when(findInvoiceRecipientCall.getAxRequestResult()).thenReturn(AxRequestResult.ALL_IS_WELL);
        when(findInvoiceRecipientCall.getNumberOfInvoiceRecipient()).thenReturn(0);

        try{
            axService.deleteSplittingRule(serviceResultAgreement);
            fail();
        } catch (BillingServiceException bsex) {
            assertThat(bsex.getMessage(), is("When deleting splitting rule, the parent invoice recipient could not be found, invoiceRecipientId: {INVOICERECIPIENTID}, splittingRuleId: {SPLITTINGRULEID}"));
        }

        verify(findInvoiceRecipientCall).execute("{" + invoiceRecipientId.toUpperCase() + "}", "SE02");
    }

    @Test
    public void SplitterNotFoundShouldThrowException() throws Exception {

        when(findInvoiceRecipientCall.getAxRequestResult()).thenReturn(AxRequestResult.ALL_IS_WELL);
        when(findInvoiceRecipientCall.getNumberOfInvoiceRecipient()).thenReturn(1);

        AxdEntityMDSSalesSplitter splitter = new AxdEntityMDSSalesSplitter();
        splitter.setSplitterId("Gurka");
        List<AxdEntityMDSSalesSplitter> splitters = new ArrayList<AxdEntityMDSSalesSplitter>();
        splitters.add(splitter);

        when(findInvoiceRecipientCall.getSplitters()).thenReturn(splitters);

        try{
            axService.deleteSplittingRule(serviceResultAgreement);
            fail();
        } catch (BillingServiceException bsex) {
            assertThat(bsex.getMessage(), is("When deleting splitting rule, the parent invoice recipient was found but not the actual splitting rule, invoiceRecipientId: {INVOICERECIPIENTID}, splittingRuleId: {SPLITTINGRULEID}"));
        }

        verify(findInvoiceRecipientCall).execute("{" + invoiceRecipientId.toUpperCase() + "}", "SE02");
    }

    @Test
    public void multipleInvoiceRecipientShouldThrowException() throws Exception {
        when(findInvoiceRecipientCall.getAxRequestResult()).thenReturn(AxRequestResult.ALL_IS_WELL);
        when(findInvoiceRecipientCall.getNumberOfInvoiceRecipient()).thenReturn(2);

        try{
            axService.deleteSplittingRule(serviceResultAgreement);
            fail();
        } catch (BillingServiceException bsex) {
            assertThat(bsex.getMessage(), Matchers.is("Found more than one InvoiceRecipient in Ax with invoice recipient id : {INVOICERECIPIENTID}"));
            assertThat(bsex.getCategory(), Matchers.is(ServiceResultCategory.BUG_DISTURBANCE));
        }

        verify(findInvoiceRecipientCall).execute("{" + invoiceRecipientId.toUpperCase() + "}", "SE02");
    }

}
