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
 * @since 2012-06-18
 */
public class SplittingRuleDeletedFlowTest extends AbstractMuleContextTestCase {
    private FlowTestHelper flowTestHelper = new FlowTestHelper();

    private AxWebServiceSetup axWebServiceSetupMock;
    private AzureServiceSetup azureServiceSetupMock;

    private CallContext callContext = new CallContext();

    @Override
    protected ConfigurationBuilder getBuilder() throws Exception {
        return new SpringXmlConfigurationBuilder(new String[]{
                "spring/springPropertiesContext.xml",
                "spring/springBeansContext.xml",
                "spring/springContext-flowMock.xml",
                "spring/springServicesContext.xml",
                "flow/commons.xml",
                "flow/delete-splitting-rule-crm.xml"});
    }

    @Before
    public void setup() throws MDSITGSalesClAServiceUpdateAifFaultFaultFaultMessage {
        initializeApplicationContext();
        String json = FileUtil.readFileFromClasspath("json-examples/splitting-rule-deleted-example.json");
        flowTestHelper.setupMockForAzureService(azureServiceSetupMock, json,FlowTestHelper.AZURE_QUEUE_SPLITTING_RULE_DELETED);

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

        muleContext.start();

        Thread.sleep(1200);
        muleContext.stop();

        verify(flowTestHelper.invoiceRecipientPortMock).find(any(MDSITGSInvRecServiceFindRequest.class), same(callContext));
        // The update removes the splitter
        verify(flowTestHelper.invoiceRecipientPortMock).update(any(MDSITGSInvRecServiceUpdateRequest.class), same(callContext));

        // Verify azure queue operations
        verify(flowTestHelper.cloudQueue, atLeast(1)).retrieveMessage(anyInt(), any(QueueRequestOptions.class));
        verify(flowTestHelper.cloudQueue).deleteMessage(any(AzureMessage.class), any(QueueRequestOptions.class));

        verifyNoMoreInteractions(flowTestHelper.getAllMocks());
    }

    @Test
    public void flowWithNotFoundShouldThrowException() throws Exception {
        // Not found
        when(flowTestHelper.invoiceRecipientPortMock.find(any(MDSITGSInvRecServiceFindRequest.class), same(callContext)))
                .thenReturn(flowTestHelper.createInvoiceRecipientNotFound());

        muleContext.start();

        Thread.sleep(1200);
        muleContext.stop();

        verify(flowTestHelper.invoiceRecipientPortMock).find(any(MDSITGSInvRecServiceFindRequest.class), same(callContext));

        // verify the delete has not been performed, since the flow should fail
        // Verify azure queue operations
        verify(flowTestHelper.cloudQueue, atLeast(1)).retrieveMessage(anyInt(), any(QueueRequestOptions.class));

        verifyNoMoreInteractions(flowTestHelper.getAllMocks());
    }

}
