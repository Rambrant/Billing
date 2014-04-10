package flow;

import com.microsoft.schemas.dynamics._2010._01.datacontracts.CallContext;
import com.microsoft.windowsazure.services.queue.client.QueueRequestOptions;
import com.tradedoubler.billing.service.ax.webservice.AxWebServiceSetup;
import com.tradedoubler.billing.service.crm.AzureServiceSetup;
import com.tradedoubler.billing.service.crm.azure.AzureMessage;
import com.tradedoubler.testutil.FileUtil;
import org.junit.*;
import org.mule.api.config.ConfigurationBuilder;
import org.mule.config.spring.*;
import org.mule.tck.junit4.AbstractMuleContextTestCase;
import org.springframework.context.ApplicationContext;
import org.tempuri.*;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * @author bjorn
 * @since 2012-06-18
 */
public class MarketMessageUpdatedFlowTest extends AbstractMuleContextTestCase {

    private FlowTestHelper flowTestHelper = new FlowTestHelper();

    private AzureServiceSetup azureServiceSetupMock;
    private AxWebServiceSetup axWebServiceSetupMock;

    private CallContext callContext = new CallContext();

    @Override
    protected ConfigurationBuilder getBuilder() throws Exception {
        return new SpringXmlConfigurationBuilder(new String[]{
                "spring/springPropertiesContext.xml",
                "spring/springBeansContext.xml",
                "spring/springContext-flowMock.xml",
                "spring/springServicesContext.xml",
                "flow/commons.xml",
                "flow/update-market-message-crm.xml"});
    }

    @Before
    public void setup() throws MDSITGSalesClAServiceUpdateAifFaultFaultFaultMessage {
        initializeApplicationContext();
        String json = FileUtil.readFileFromClasspath("json-examples/market-message-updated-example.json");
        flowTestHelper.setupMockForAzureService(azureServiceSetupMock, json, FlowTestHelper.AZURE_QUEUE_MARKET_MESSAGE_UPDATED);

        setupCommonMocks();
    }

    private void initializeApplicationContext() {
        ApplicationContext applicationContext = (ApplicationContext) muleContext.getRegistry().lookupObject(SpringRegistry.SPRING_APPLICATION_CONTEXT);
        azureServiceSetupMock = applicationContext.getBean(AzureServiceSetup.class);
        axWebServiceSetupMock = applicationContext.getBean(AxWebServiceSetup.class);

        flowTestHelper.skipMessageController(applicationContext);
    }

    private void setupCommonMocks() throws MDSITGSalesClAServiceUpdateAifFaultFaultFaultMessage {
        flowTestHelper.setupMockForAllPortCalls(axWebServiceSetupMock);
        flowTestHelper.setupMockForAllPortInserts(callContext);
        flowTestHelper.setupMockForAllPortUpdates(callContext);

        when(axWebServiceSetupMock.getCallContext(anyString())).thenReturn(callContext);
    }

    @Test
    public void normalFlowWithUpdateShouldWork() throws Exception {
        when(flowTestHelper.invoiceMessagePortMock.find(any(MDSITGSInvMesServiceFindRequest.class), same(callContext)))
                .thenReturn(flowTestHelper.createInvoiceMessageFound());

        muleContext.start();

        Thread.sleep(1200);
        muleContext.stop();

        verify(flowTestHelper.invoiceMessagePortMock).find(any(MDSITGSInvMesServiceFindRequest.class), same(callContext));
        verify(flowTestHelper.invoiceMessagePortMock).update(any(MDSITGSInvMesServiceUpdateRequest.class), same(callContext));

        // Verify azure queue operations
        verify(flowTestHelper.cloudQueue, atLeast(1)).retrieveMessage(anyInt(), any(QueueRequestOptions.class));
        verify(flowTestHelper.cloudQueue).deleteMessage(any(AzureMessage.class), any(QueueRequestOptions.class));

        verifyNoMoreInteractions(flowTestHelper.getAllMocks());
    }

    @Test
    public void normalFlowWithInsertShouldWork() throws Exception {
        when(flowTestHelper.invoiceMessagePortMock.find(any(MDSITGSInvMesServiceFindRequest.class), same(callContext)))
                .thenReturn(flowTestHelper.createInvoiceMessageNotFound());

        muleContext.start();

        Thread.sleep(1200);
        muleContext.stop();

        verify(flowTestHelper.invoiceMessagePortMock).find(any(MDSITGSInvMesServiceFindRequest.class), same(callContext));
        verify(flowTestHelper.invoiceMessagePortMock).create(any(MDSITGSInvMesServiceCreateRequest.class), same(callContext));

        // Verify azure queue operations
        verify(flowTestHelper.cloudQueue, atLeast(1)).retrieveMessage(anyInt(), any(QueueRequestOptions.class));
        verify(flowTestHelper.cloudQueue).deleteMessage(any(AzureMessage.class), any(QueueRequestOptions.class));

        verifyNoMoreInteractions(flowTestHelper.getAllMocks());
    }
}
