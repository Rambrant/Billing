package flow;

import com.microsoft.schemas.dynamics._2010._01.datacontracts.CallContext;
import com.tradedoubler.billing.service.ax.webservice.AxWebServiceSetup;
import com.tradedoubler.billing.service.pan.PanDatabaseServiceSetup;
import mds_salesorderbasisline.*;
import org.datacontract.schemas._2004._07.dynamics_ax.ObjectFactory;
import org.junit.*;
import org.mule.api.config.ConfigurationBuilder;
import org.mule.config.spring.*;
import org.mule.tck.junit4.AbstractMuleContextTestCase;
import org.springframework.context.ApplicationContext;
import org.tempuri.MDSITGSalesClAServiceUpdateAifFaultFaultFaultMessage;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

/**
 * @author bjorn
 * @since 2012-06-18
 */
public class StartAxInvoicingFlowTest extends AbstractMuleContextTestCase {
    private FlowTestHelper flowTestHelper = new FlowTestHelper();

    private AxWebServiceSetup axWebServiceSetupMock;
    private PanDatabaseServiceSetup panDatabaseServiceSetupMock;

    private CallContext callContext = new CallContext();

    private ObjectFactory objectFactory = new ObjectFactory();
    private SalesOrderBasisLineProcessingScheduleOrderBasisLineProcessingResponse response;

    @Override
    protected ConfigurationBuilder getBuilder() throws Exception {
        return new SpringXmlConfigurationBuilder(new String[]{
                "spring/springPropertiesContext.xml",
                "spring/springBeansContext.xml",
                "spring/springContext-flowMock.xml",
                "spring/springServicesContext.xml",
                "flow/commons.xml",
                "flow/start-ax-invoicing-pan.xml"});
    }

    @Before
    public void setup() throws MDSITGSalesClAServiceUpdateAifFaultFaultFaultMessage {
        initializeApplicationContext();

        setupCommonMocks();

        setupResponse();
    }

    private void initializeApplicationContext() {
        ApplicationContext applicationContext = (ApplicationContext) muleContext.getRegistry().lookupObject(SpringRegistry.SPRING_APPLICATION_CONTEXT);
        axWebServiceSetupMock = applicationContext.getBean(AxWebServiceSetup.class);
        panDatabaseServiceSetupMock = applicationContext.getBean(PanDatabaseServiceSetup.class);

        flowTestHelper.skipMessageController(applicationContext);
    }

    private void setupCommonMocks() throws MDSITGSalesClAServiceUpdateAifFaultFaultFaultMessage {
        flowTestHelper.setupMockForAllPortCalls(axWebServiceSetupMock);
        flowTestHelper.setupMockForAllPortInserts(callContext);
        flowTestHelper.setupMockForAllPortUpdates(callContext);
        flowTestHelper.setupMockForAllDatabaseCalls(panDatabaseServiceSetupMock);

        when(axWebServiceSetupMock.getCallContext(anyString())).thenReturn(callContext);
    }

    private void setupResponse() {
        response = new SalesOrderBasisLineProcessingScheduleOrderBasisLineProcessingResponse();
        response.setResponse(true);
    }

    @Test
    public void nothingToFetchFlowShouldWork() throws Exception {
        muleContext.start();
        when(flowTestHelper.readyToInvoiceMock.executeFunction(String.class)).thenReturn("N");

        Thread.sleep(1200);
        muleContext.stop();

        // Verify that pan database was queried for order lines
        verify(flowTestHelper.readyToInvoiceMock, atLeast(1)).executeFunction(String.class);

        verifyNoMoreInteractions(flowTestHelper.getAllMocks());
    }

    @Test
    public void normalFlowShouldWork() throws Exception {
        muleContext.start();
        when(flowTestHelper.readyToInvoiceMock.executeFunction(String.class)).thenReturn("Y").thenReturn("N");
        when(flowTestHelper.salesOrderBasisLineProcessingMock.scheduleOrderBasisLineProcessing(
                any(SalesOrderBasisLineProcessingScheduleOrderBasisLineProcessingRequest.class), same(callContext)))
                .thenReturn(response);
        when(flowTestHelper.invoicingStartedMock.executeFunction(BigDecimal.class)).thenReturn(BigDecimal.ZERO);

        Thread.sleep(1200);
        muleContext.stop();

        // Verify that pan database was queried for order lines
        verify(flowTestHelper.readyToInvoiceMock, atLeast(1)).executeFunction(String.class);

        // Verify that ax invoicing is started
        verify(flowTestHelper.salesOrderBasisLineProcessingMock).scheduleOrderBasisLineProcessing(
                any(SalesOrderBasisLineProcessingScheduleOrderBasisLineProcessingRequest.class), same(callContext));

        // Verify that readyToInvoice is confirmed in Pan
        verify(flowTestHelper.invoicingStartedMock).executeFunction(BigDecimal.class);

        verifyNoMoreInteractions(flowTestHelper.getAllMocks());
    }

}
