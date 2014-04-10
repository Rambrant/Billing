package flow;

import com.microsoft.schemas.dynamics._2010._01.datacontracts.CallContext;
import com.microsoft.windowsazure.services.queue.client.QueueRequestOptions;
import com.tradedoubler.billing.domain.Currency;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.ax.webservice.AxWebServiceSetup;
import com.tradedoubler.billing.service.crm.AzureServiceSetup;
import com.tradedoubler.billing.service.crm.azure.AzureMessage;
import com.tradedoubler.billing.service.pan.PanDatabaseServiceSetup;
import org.junit.*;
import org.mule.api.config.ConfigurationBuilder;
import org.mule.config.spring.*;
import org.mule.tck.junit4.AbstractMuleContextTestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.RowMapper;
import org.tempuri.MDSITGSalesClAServiceUpdateAifFaultFaultFaultMessage;

import java.math.BigDecimal;
import java.util.*;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * @author bjorn
 * @since 2012-06-18
 */
public class UpdatePrepaymentForecastFlowTest extends AbstractMuleContextTestCase {
    private FlowTestHelper flowTestHelper = new FlowTestHelper();

    private AxWebServiceSetup axWebServiceSetupMock;
    private PanDatabaseServiceSetup panDatabaseServiceSetupMock;
    List<PrepaymentOrderLine> prepaymentOrderLines = createOrderLines();

    private CallContext callContext = new CallContext();
    private AzureServiceSetup azureServiceSetupMock;

    @Override
    protected ConfigurationBuilder getBuilder() throws Exception {
        return new SpringXmlConfigurationBuilder(new String[]{
                "spring/springPropertiesContext.xml",
                "spring/springBeansContext.xml",
                "spring/springContext-flowMock.xml",
                "spring/springServicesContext.xml",
                "flow/commons.xml",
                "flow/update-prepayment-forecast-pan.xml"});
    }

    @Before
    public void setup() throws MDSITGSalesClAServiceUpdateAifFaultFaultFaultMessage {
        initializeApplicationContext();

        setupCommonMocks();
    }

    private void initializeApplicationContext() {
        ApplicationContext applicationContext = (ApplicationContext) muleContext.getRegistry().lookupObject(SpringRegistry.SPRING_APPLICATION_CONTEXT);
        axWebServiceSetupMock = applicationContext.getBean(AxWebServiceSetup.class);
        panDatabaseServiceSetupMock = applicationContext.getBean(PanDatabaseServiceSetup.class);
        azureServiceSetupMock = applicationContext.getBean(AzureServiceSetup.class);

        flowTestHelper.skipMessageController(applicationContext);
    }

    private void setupCommonMocks() throws MDSITGSalesClAServiceUpdateAifFaultFaultFaultMessage {
        flowTestHelper.setupMockForAllPortCalls(axWebServiceSetupMock);
        flowTestHelper.setupMockForAllPortInserts(callContext);
        flowTestHelper.setupMockForAllPortUpdates(callContext);
        flowTestHelper.setupMockForAllDatabaseCalls(panDatabaseServiceSetupMock);
        flowTestHelper.setupMockForAzureService(azureServiceSetupMock, null, "update-forecast");

        when(axWebServiceSetupMock.getCallContext(anyString())).thenReturn(callContext);
    }

    private List<PrepaymentOrderLine> createOrderLines() {
        List<PrepaymentOrderLine> returnValue = new ArrayList<PrepaymentOrderLine>();

        returnValue.add(createPaymentOrderLine("1-1234567890", 100, 10, "120", "1301"));
        returnValue.add(createPaymentOrderLine("1-1234567890", 100, 10, "120", "1301"));
        returnValue.add(createPaymentOrderLine("1-1234567890", 100, 10, "114", "1301"));
        returnValue.add(createPaymentOrderLine("1-1234567890", 100, 10, "114", "1302"));
        returnValue.add(createPaymentOrderLine("1-4242424242", 100, 10, "120", "1301"));
        returnValue.add(createPaymentOrderLine("1-4242424242", 100, 10, "120", "1302"));

        return returnValue;
    }

    private PrepaymentOrderLine createPaymentOrderLine(String systemAgreementId, int total, int cost, String salesPart, String period) {
        OrderLine orderLine = new OrderLine(systemAgreementId, "orderLineId", true, salesPart, "description",
                new BigDecimal(total), new BigDecimal(cost), period, new Timestamp(), null,
                null);
        orderLine.setDebitOrCredit(DebitOrCredit.DEBIT);
        orderLine.setQuantity(1);

        return new PrepaymentOrderLine(
                orderLine,
                new Currency("SEK"));
    }

    @Test
    public void nothingToFetchFlowShouldWork() throws Exception {
        muleContext.start();
        when(flowTestHelper.fetchForecastOrderLineBatchIdMock.executeFunction(String.class)).thenReturn("0");

        Thread.sleep(1200);
        muleContext.stop();

        // Verify that pan database was queried for order lines
        verify(flowTestHelper.fetchForecastOrderLineBatchIdMock, atLeast(1)).executeFunction(String.class);

        verifyNoMoreInteractions(flowTestHelper.getAllMocks());
    }

    @Test
    public void normalFlowShouldWork() throws Exception {
        muleContext.start();
        when(flowTestHelper.fetchForecastOrderLineBatchIdMock.executeFunction(String.class)).thenReturn("BA4CB1D0000000003000100000000001").thenReturn("0");
        when(flowTestHelper.jdbcTemplateMock.query(anyString(), any(RowMapper.class), eq("BA4CB1D0000000003000100000000001"))).thenReturn(prepaymentOrderLines);
        when(flowTestHelper.jdbcTemplateMock.queryForInt(anyString(), eq("BA4CB1D0000000003000100000000001"))).thenReturn(1);

        Thread.sleep(1200);
        muleContext.stop();

        // Verify that pan database was queried for order lines
        verify(flowTestHelper.fetchForecastOrderLineBatchIdMock, atLeast(1)).executeFunction(String.class);
        verify(flowTestHelper.jdbcTemplateMock).query(anyString(), any(RowMapper.class), eq("BA4CB1D0000000003000100000000001"));

        // Verify that forecast was sent to CRM
        verify(flowTestHelper.cloudQueue, atLeast(1)).addMessage(any(AzureMessage.class), any(QueueRequestOptions.class));

        // Verify that order lines were confirmed
        verify(flowTestHelper.updateBatchOfForecastOrderLinesMock).executeFunction(eq(BigDecimal.class), eq("BA4CB1D0000000003000100000000001"));

        verifyNoMoreInteractions(flowTestHelper.getAllMocks());
    }

}
