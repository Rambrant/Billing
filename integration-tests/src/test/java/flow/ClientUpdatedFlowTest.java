package flow;

import com.microsoft.schemas.dynamics._2008._01.services.*;
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
public class ClientUpdatedFlowTest extends AbstractMuleContextTestCase {
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
                "flow/update-client-crm.xml"});
    }

    @Before
    public void setup() throws MDSITGSalesClAServiceUpdateAifFaultFaultFaultMessage {
        initializeApplicationContext();
        String json = FileUtil.readFileFromClasspath("json-examples/client-updated-example.json");
        flowTestHelper.setupMockForAzureService(azureServiceSetupMock, json, FlowTestHelper.AZURE_QUEUE_CLIENT_UPDATED);

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
        // Normal flow response
        when(flowTestHelper.customerPortMock.find(any(CustomerServiceFindRequest.class), same(callContext))).thenReturn(flowTestHelper.createCustomerFound());
        when(flowTestHelper.customerBankPortMock.find(any(MDSITGCustBankServiceFindRequest.class), same(callContext))).thenReturn(flowTestHelper.createBankFound());
        // Response when updating bank info on client
        when(flowTestHelper.customerPortMock.read(any(CustomerServiceReadRequest.class), same(callContext))).thenReturn(flowTestHelper.createCustomerReadFound());

        when(flowTestHelper.invoiceMessagePortMock.find(any(MDSITGSInvMesServiceFindRequest.class), same(callContext))).thenReturn(flowTestHelper.createInvoiceMessageFound());

        muleContext.start();

        Thread.sleep(1200);
        muleContext.stop();

        verify(flowTestHelper.customerPortMock).find(any(CustomerServiceFindRequest.class), same(callContext));
        // One for update client and one for update client bank info
        verify(flowTestHelper.customerPortMock, times(2)).update(any(CustomerServiceUpdateRequest.class), same(callContext));

        verify(flowTestHelper.customerBankPortMock).find(any(MDSITGCustBankServiceFindRequest.class), same(callContext));
        verify(flowTestHelper.customerBankPortMock).update(any(MDSITGCustBankServiceUpdateRequest.class), same(callContext));

        verify(flowTestHelper.customerPortMock).read(any(CustomerServiceReadRequest.class), same(callContext));

        verify(flowTestHelper.invoiceMessagePortMock).find(any(MDSITGSInvMesServiceFindRequest.class), same(callContext));
        verify(flowTestHelper.invoiceMessagePortMock).update(any(MDSITGSInvMesServiceUpdateRequest.class), same(callContext));

        // Verify azure queue operations
        verify(flowTestHelper.cloudQueue, atLeast(1)).retrieveMessage(anyInt(), any(QueueRequestOptions.class));
        verify(flowTestHelper.cloudQueue).deleteMessage(any(AzureMessage.class), any(QueueRequestOptions.class));

        verifyNoMoreInteractions(flowTestHelper.getAllMocks());
    }

    @Test
    public void normalFlowWithInsertShouldWork() throws Exception {
        // Alternative flow, inserts must be performed instead
        when(flowTestHelper.customerPortMock.find(any(CustomerServiceFindRequest.class), same(callContext))).thenReturn(flowTestHelper.createCustomerNotFound());
        when(flowTestHelper.customerBankPortMock.find(any(MDSITGCustBankServiceFindRequest.class), same(callContext))).thenReturn(flowTestHelper.createBankNotFound());
        // Response when updating bank info on client
        when(flowTestHelper.customerPortMock.read(any(CustomerServiceReadRequest.class), same(callContext))).thenReturn(flowTestHelper.createCustomerReadFound());

        when(flowTestHelper.invoiceMessagePortMock.find(any(MDSITGSInvMesServiceFindRequest.class), same(callContext))).thenReturn(flowTestHelper.createInvoiceMessageNotFound());

        muleContext.start();

        Thread.sleep(1200);
        muleContext.stop();

        verify(flowTestHelper.customerPortMock).find(any(CustomerServiceFindRequest.class), same(callContext));
        verify(flowTestHelper.customerPortMock).create(any(CustomerServiceCreateRequest.class), same(callContext));

        verify(flowTestHelper.customerBankPortMock).find(any(MDSITGCustBankServiceFindRequest.class), same(callContext));
        verify(flowTestHelper.customerBankPortMock).create(any(MDSITGCustBankServiceCreateRequest.class), same(callContext));

        verify(flowTestHelper.customerPortMock).read(any(CustomerServiceReadRequest.class), same(callContext));
        verify(flowTestHelper.customerPortMock).update(any(CustomerServiceUpdateRequest.class), same(callContext));

        verify(flowTestHelper.invoiceMessagePortMock).find(any(MDSITGSInvMesServiceFindRequest.class), same(callContext));
        verify(flowTestHelper.invoiceMessagePortMock).create(any(MDSITGSInvMesServiceCreateRequest.class), same(callContext));

        // Verify azure queue operations
        verify(flowTestHelper.cloudQueue, atLeast(1)).retrieveMessage(anyInt(), any(QueueRequestOptions.class));
        verify(flowTestHelper.cloudQueue).deleteMessage(any(AzureMessage.class), any(QueueRequestOptions.class));

        verifyNoMoreInteractions(flowTestHelper.getAllMocks());
    }
}
