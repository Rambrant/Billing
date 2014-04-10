package com.tradedoubler.billing.service;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.fetch.FlowName;
import com.tradedoubler.billing.platform.flowcontroller.ServiceResult;
import com.tradedoubler.billing.service.crm.azure.AzureMessage;
import org.junit.*;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static com.tradedoubler.billing.util.AxDbConstantsUtil.generateInvoiceMessageRuleId;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;


/**
 * @author bjoek
 * @since 2012-09-04
 */
public class UpdatePrepaymentForecastGraphTest extends AbstractGraphHelper {

    private final List<PrepaymentOrderLine> orderLines = DomainEntityFactory.createPrepaymentOrderLines();
    private ServiceResult serviceResult;

    public UpdatePrepaymentForecastGraphTest() throws IllegalAccessException {
        super();
    }

    @Before
    public void setUp() throws Exception {
        serviceResult = new ServiceResult();
        serviceResult.setFlowName(FlowName.UpdatePrepaymentForecastPan);
    }

    @Test
    public void normalFlowShouldReadOrderLinesFromPan() throws Exception {
        when(readPrepaymentForecastOrderLinesCall.getOrderLines()).thenReturn(orderLines);
        when(readPrepaymentForecastOrderLinesCall.getBatchId()).thenReturn(new Guid(generateInvoiceMessageRuleId()));

        executeGraph();

        // Check that a pan read is performed
        verify(readPrepaymentForecastOrderLinesCall).read();
        verify(readPrepaymentForecastOrderLinesCall).getOrderLines();
        verify(readPrepaymentForecastOrderLinesCall).getBatchId();
        verify(readPrepaymentForecastOrderLinesCall).getSourceSystemId();
        verify(readPrepaymentForecastOrderLinesCall).getVersion();

        verifyNoMoreInteractions(readPrepaymentForecastOrderLinesCall);
    }

    @Test
    public void normalFlowShouldCalculateForecast() throws Exception {
        when(readPrepaymentForecastOrderLinesCall.getOrderLines()).thenReturn(orderLines);
        when(readPrepaymentForecastOrderLinesCall.getBatchId()).thenReturn(new Guid(generateInvoiceMessageRuleId()));

        executeGraph();

        PrepaymentForecastUpdated prepaymentForecastUpdated = (PrepaymentForecastUpdated) serviceResult.getIntegrationMessage().getDomainObject();

        // Verify that order lines exists
        assertThat(prepaymentForecastUpdated.getOrderLines().size(), is(6));
        // Verify that forecast have been calculated, one for each program
        assertThat(prepaymentForecastUpdated.getForecastUpdates().size(), is(2));
    }

    @Test
    public void normalFlowShouldTransformForecast() throws Exception {
        when(readPrepaymentForecastOrderLinesCall.getOrderLines()).thenReturn(orderLines);
        when(readPrepaymentForecastOrderLinesCall.getBatchId()).thenReturn(new Guid(generateInvoiceMessageRuleId()));

        executeGraph();

        PrepaymentForecastUpdated prepaymentForecastUpdated = (PrepaymentForecastUpdated) serviceResult.getIntegrationMessage().getDomainObject();

        // Verify that forecast have been calculated
        assertThat(prepaymentForecastUpdated.getForecastUpdates().size(), is(2));
        // Verify that forecast have been transformed to json
        assertThat(prepaymentForecastUpdated.getForecastUpdatesJson().size(), is(2));
    }

    @Test
    public void normalFlowShouldValidateForecast() throws Exception {
        when(readPrepaymentForecastOrderLinesCall.getOrderLines()).thenReturn(orderLines);
        when(readPrepaymentForecastOrderLinesCall.getBatchId()).thenReturn(new Guid(generateInvoiceMessageRuleId()));

        executeGraph();

        verify(jsonValidatorService).validateUpdatePrepaymentForecast(serviceResult);
    }

    @Test
    public void normalFlowShouldInsertForecastInCrm() throws Exception {
        when(readPrepaymentForecastOrderLinesCall.getOrderLines()).thenReturn(orderLines);
        when(readPrepaymentForecastOrderLinesCall.getBatchId()).thenReturn(new Guid(generateInvoiceMessageRuleId()));

        executeGraph();

        PrepaymentForecastUpdated prepaymentForecastUpdated = (PrepaymentForecastUpdated) serviceResult.getIntegrationMessage().getDomainObject();

        // Verify that forecast have been transformed to json
        assertThat(prepaymentForecastUpdated.getForecastUpdatesJson().size(), is(2));

        ArgumentCaptor<AzureMessage> azureMessageArgumentCaptor = ArgumentCaptor.forClass(AzureMessage.class);
        verify(putMessageCall, times(2)).putMessageInQueue(azureMessageArgumentCaptor.capture(), eq(FlowName.UpdatePrepaymentForecastPan));

        // Verify that all json messages have been sent
        assertThat(azureMessageArgumentCaptor.getAllValues().size(), is(2));

        AzureMessage value = azureMessageArgumentCaptor.getAllValues().get(0);
        String messageContentAsString = value.getMessageContentAsString("UTF-8");

        // Compare the first message to verify that the json message have been sent
        assertThat(messageContentAsString, is(prepaymentForecastUpdated.getForecastUpdatesJson().get(0).jsonString));
    }

    @Test
    public void normalFlowShouldConfirmOrderLinesInPan() throws Exception {
        String batchId = generateInvoiceMessageRuleId();

        when(readPrepaymentForecastOrderLinesCall.getOrderLines()).thenReturn(orderLines);
        when(readPrepaymentForecastOrderLinesCall.getBatchId()).thenReturn(new Guid(batchId));

        executeGraph();

        // Verify that the batchId ends up in commit info
        String commitInfo = serviceResult.getCommitInfo().toString();
        assertThat(commitInfo, is(batchId));

        ArgumentCaptor<Guid> guidArgumentCaptor = ArgumentCaptor.forClass(Guid.class);
        verify(confirmPrepaymentForecastOrderLinesCall).confirm(guidArgumentCaptor.capture());

        assertThat(guidArgumentCaptor.getValue().getGuid(), is(commitInfo));
    }

    private void executeGraph() throws BillingServiceException {
        serviceResult = panService.fetchPrepaymentForecastOrderLines(serviceResult);
        serviceResult = crmService.calculatePrepaymentForecasts(serviceResult);
        serviceResult = crmService.transformPrepaymentForecasts(serviceResult);
        serviceResult = jsonValidatorService.validateUpdatePrepaymentForecast(serviceResult);
        serviceResult = crmService.insertPrepaymentForecast(serviceResult);
        serviceResult = panService.confirmForecastOrderLines(serviceResult);
    }

}
