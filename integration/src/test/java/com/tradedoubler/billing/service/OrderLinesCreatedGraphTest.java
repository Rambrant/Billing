package com.tradedoubler.billing.service;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.fetch.FlowName;
import com.tradedoubler.billing.platform.flowcontroller.ServiceResult;
import com.tradedoubler.billing.service.ax.webservice.call.OrderLineResponseResult;
import org.datacontract.schemas._2004._07.dynamics_ax.ArrayOfMDSITGSalesOrderBasisLineContract;
import org.junit.*;
import org.mockito.ArgumentCaptor;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;


/**
 * @author bjoek
 * @since 2012-09-04
 */
public class OrderLinesCreatedGraphTest extends AbstractGraphHelper {

    private final List<OrderLine> orderLines = DomainEntityFactory.createOrderLines();
    private ServiceResult serviceResult;
    private final List<OrderLineResponseResult> failedOrderLines = DomainEntityFactory.createFailedOrderLineResults();

    public OrderLinesCreatedGraphTest() throws IllegalAccessException {
        super();
    }

    @Before
    public void setUp() throws Exception {
        serviceResult = new ServiceResult();
        serviceResult.setFlowName(FlowName.CreateOrderLinesPan);
    }

    @Test
    public void normalFlowShouldReadOrderLinesFromPan() throws Exception {
        when(readOrderLinesCall.getOrderLines()).thenReturn(orderLines);
        when(readOrderLinesCall.getBatchId()).thenReturn(new Guid("batchId"));

        executeGraph();

        // Check that a pan read is performed
        verify(readOrderLinesCall).getOrderLines();
    }

    @Test
    public void normalFlowShouldInsertOrderLinesInAx() throws Exception {
        when(readOrderLinesCall.getOrderLines()).thenReturn(orderLines);
        when(readOrderLinesCall.getBatchId()).thenReturn(new Guid("batchId"));

        executeGraph();

        verify(insertAndUpdateOrderLinesCall).execute(any(ArrayOfMDSITGSalesOrderBasisLineContract.class), eq("SE02"));
    }

    @Test
    public void normalFlowShouldConfirmOrderLinesInPan() throws Exception {
        when(readOrderLinesCall.getOrderLines()).thenReturn(orderLines);
        when(readOrderLinesCall.getBatchId()).thenReturn(new Guid("batchId"));

        executeGraph();

        verify(confirmOrderLinesCall).confirm(new Guid("batchId"), Collections.<OrderLineFailed>emptyList());
    }

    @Test
    public void failedOrderLinesShouldBeConfirmedInPan() throws Exception {
        when(readOrderLinesCall.getOrderLines()).thenReturn(orderLines);
        when(readOrderLinesCall.getBatchId()).thenReturn(new Guid("batchId"));
        when(insertAndUpdateOrderLinesCall.getListOfFailedOrderLines()).thenReturn(failedOrderLines);

        executeGraph();

        ArgumentCaptor<List> argumentCaptor = ArgumentCaptor.forClass(List.class);
        verify(confirmOrderLinesCall).confirm(eq(new Guid("batchId")), argumentCaptor.capture());

        List<OrderLineFailed> value = argumentCaptor.getValue();
        assertThat(value.size(), is(5));
        assertThat(value.get(0).getOrderLineId(), is("1"));
        assertThat(value.get(1).getOrderLineId(), is("3"));
        assertThat(value.get(2).getOrderLineId(), is("5"));
        assertThat(value.get(3).getOrderLineId(), is("7"));
        assertThat(value.get(4).getOrderLineId(), is("9"));
    }

    private void executeGraph() throws BillingServiceException {
        serviceResult = panService.fetchOrderLines(serviceResult);
        serviceResult = axService.createOrderLines(serviceResult);
        serviceResult = panService.confirmOrderLines(serviceResult);
    }

}
