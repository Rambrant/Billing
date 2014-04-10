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
public class InvoiceRecipientDeletedFlowTest extends AbstractMuleContextTestCase {
    private FlowTestHelper flowTestHelper = new FlowTestHelper();

    private AzureServiceSetup azureServiceSetupMock;
    private AxWebServiceSetup axWebServiceSetupMock;

    private CallContext callContext = new CallContext();

    private MDSITGSInvRecServiceDeleteResponse serviceDeleteResponse = new MDSITGSInvRecServiceDeleteResponse();

    @Override
    protected ConfigurationBuilder getBuilder() throws Exception {
        return new SpringXmlConfigurationBuilder(new String[]{
                "spring/springPropertiesContext.xml",
                "spring/springBeansContext.xml",
                "spring/springContext-flowMock.xml",
                "spring/springServicesContext.xml",
                "flow/commons.xml",
                "flow/delete-invoice-recipient-crm.xml"});
    }

    @Before
    public void setup() throws MDSITGSalesClAServiceUpdateAifFaultFaultFaultMessage {
        initializeApplicationContext();
        String json = FileUtil.readFileFromClasspath("json-examples/invoice-recipient-deleted-example.json");
        flowTestHelper.setupMockForAzureService(azureServiceSetupMock, json, FlowTestHelper.AZURE_QUEUE_INVOICE_RECIPIENT_DELETED);

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
    public void normalFlowWithFoundInvoiceRecipientShouldWork() throws Exception {
        // Normal flow response
        when(flowTestHelper.invoiceRecipientPortMock.find(any(MDSITGSInvRecServiceFindRequest.class), same(callContext)))
                .thenReturn(flowTestHelper.createInvoiceRecipientFound());
        when(flowTestHelper.invoiceRecipientPortMock.delete(any(MDSITGSInvRecServiceDeleteRequest.class), same(callContext)))
                .thenReturn(serviceDeleteResponse);

        muleContext.start();

        Thread.sleep(1200);
        muleContext.stop();

        verify(flowTestHelper.invoiceRecipientPortMock).find(any(MDSITGSInvRecServiceFindRequest.class), same(callContext));
        verify(flowTestHelper.invoiceRecipientPortMock).delete(any(MDSITGSInvRecServiceDeleteRequest.class), same(callContext));

        // Verify azure queue operations
        verify(flowTestHelper.cloudQueue, atLeast(1)).retrieveMessage(anyInt(), any(QueueRequestOptions.class));
        verify(flowTestHelper.cloudQueue).deleteMessage(any(AzureMessage.class), any(QueueRequestOptions.class));

        verifyNoMoreInteractions(flowTestHelper.getAllMocks());
    }
}
