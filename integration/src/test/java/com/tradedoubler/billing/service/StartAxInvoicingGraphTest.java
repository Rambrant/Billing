package com.tradedoubler.billing.service;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.fetch.FlowName;
import com.tradedoubler.billing.platform.flowcontroller.*;
import com.tradedoubler.billing.service.ax.webservice.call.OrderLineResponseResult;
import org.junit.*;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;


/**
 * @author bjoek
 * @since 2012-09-04
 */
public class StartAxInvoicingGraphTest extends AbstractGraphHelper {

    private final List<OrderLine> orderLines = DomainEntityFactory.createOrderLines();
    private ServiceResult serviceResult;
    private final List<OrderLineResponseResult> failedOrderLines = DomainEntityFactory.createFailedOrderLineResults();

    public StartAxInvoicingGraphTest() throws IllegalAccessException {
        super();
    }

    @Before
    public void setUp() throws Exception {
        serviceResult = new ServiceResult();
        serviceResult.setFlowName(FlowName.StartAxInvoicingPan);
    }

    @Test
    public void normalFlowShouldReadStatusFromPan() throws Exception {
        when(readReadyToInvoiceCall.isReadyToInvoice()).thenReturn(true);
        when(startOrderLineProcessingCall.isOrderLineProcessingStarted()).thenReturn(true);

        executeGraph();

        // Check that a pan read is performed
        verify(readReadyToInvoiceCall).isReadyToInvoice();
    }

    @Test
    public void noStartFlowShouldReturnNoStart() throws Exception {
        when(readReadyToInvoiceCall.isReadyToInvoice()).thenReturn(false);

        serviceResult = panService.fetchReadyToInvoice(serviceResult);

        // Check that a pan read is performed
        verify(readReadyToInvoiceCall).isReadyToInvoice();

        assertThat(serviceResult.getIntegrationMessage(), nullValue());
    }

    @Test
    public void noStartWithIllegalMethodCallShouldThrowException() throws Exception {
        IntegrationMessage integrationMessage = new IntegrationMessage(null, null);
        integrationMessage.setDomainObject(ReadyToInvoice.createNotReadyToInvoice());
        serviceResult.setIntegrationMessage(integrationMessage);

        try {
            axService.startInvoicing(serviceResult);
            fail();
        } catch (BillingServiceException bsex) {
            assertThat(bsex.getMessage(), is("Flow error. The startInvoicing method should not been called unless Pan says readyToInvoice=true"));
        }
    }

    @Test
    public void normalFlowShouldStartInvoicingInAx() throws Exception {
        when(readReadyToInvoiceCall.isReadyToInvoice()).thenReturn(true);
        when(startOrderLineProcessingCall.isOrderLineProcessingStarted()).thenReturn(true);

        executeGraph();

        verify(startOrderLineProcessingCall).execute(eq("SE02"));
    }

    @Test
    public void axFailedToStartInvoicingShouldThrowException() throws Exception {
        when(readReadyToInvoiceCall.isReadyToInvoice()).thenReturn(true);
        when(startOrderLineProcessingCall.isOrderLineProcessingStarted()).thenReturn(false);

        try {
            executeGraph();
            fail();
        } catch (BillingServiceException bsex) {
            assertThat(bsex.getMessage(), is("Could not start invoicing in Ax"));
        }

        verify(startOrderLineProcessingCall).execute(eq("SE02"));
    }

    @Test
    public void normalFlowShouldConfirmInvoicingInPan() throws Exception {
        when(readReadyToInvoiceCall.isReadyToInvoice()).thenReturn(true);
        when(startOrderLineProcessingCall.isOrderLineProcessingStarted()).thenReturn(true);

        executeGraph();

        verify(confirmReadyToInvoiceCall).confirm();
    }

    private void executeGraph() throws BillingServiceException {
        serviceResult = panService.fetchReadyToInvoice(serviceResult);
        serviceResult = axService.startInvoicing(serviceResult);
        serviceResult = panService.confirmInvoicingStarted(serviceResult);
    }

}
