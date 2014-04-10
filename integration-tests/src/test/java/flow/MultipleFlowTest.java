package flow;

import com.microsoft.schemas.dynamics._2008._01.services.*;
import com.microsoft.schemas.dynamics._2010._01.datacontracts.CallContext;
import com.microsoft.windowsazure.services.queue.client.*;
import com.tradedoubler.billing.service.ax.webservice.AxWebServiceSetup;
import com.tradedoubler.billing.service.crm.AzureServiceSetup;
import com.tradedoubler.billing.service.crm.azure.*;
import com.tradedoubler.billing.service.pan.PanDatabaseServiceSetup;
import com.tradedoubler.testutil.FileUtil;
import org.junit.*;
import org.mule.api.config.ConfigurationBuilder;
import org.mule.config.spring.*;
import org.mule.tck.junit4.AbstractMuleContextTestCase;
import org.springframework.context.ApplicationContext;
import org.tempuri.*;

import java.util.Map;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * @author bjorn
 * @since 2012-06-18
 */
public class MultipleFlowTest extends AbstractMuleContextTestCase {
    private FlowTestHelper flowTestHelper = new FlowTestHelper();

    private AzureServiceSetup azureServiceSetupMock;
    private AxWebServiceSetup axWebServiceSetupMock;
    private PanDatabaseServiceSetup panDatabaseServiceSetupMock;

    private CallContext callContext = new CallContext();
    private AzureQueueWrapper agreementUpdatedQueue;
    private AzureQueueWrapper invoicingRuleCreatedQueue;

    @Override
    protected ConfigurationBuilder getBuilder() throws Exception {
        return new SpringXmlConfigurationBuilder(new String[]{
                "spring/springPropertiesContext.xml",
                "spring/springBeansContext.xml",
                "spring/springContext-flowMock.xml",
                "spring/springServicesContext.xml",
                "flow/commons.xml",
                "flow/update-agreement-crm.xml",
                "flow/update-client-crm.xml",
                "flow/create-order-lines-pan.xml",
                "flow/delete-invoice-recipient-crm.xml",
                "flow/create-invoicing-rule-crm.xml",
                "flow/update-market-message-crm.xml",
                "flow/delete-splitting-rule-crm.xml"});
    }

    @Before
    public void setup() throws Exception {
        initializeApplicationContext();
        setupMockForAzureService(azureServiceSetupMock);

        setupCommonMocks();
    }

    private void initializeApplicationContext() {
        ApplicationContext applicationContext = (ApplicationContext) muleContext.getRegistry().lookupObject(SpringRegistry.SPRING_APPLICATION_CONTEXT);
        azureServiceSetupMock = applicationContext.getBean(AzureServiceSetup.class);
        axWebServiceSetupMock = applicationContext.getBean(AxWebServiceSetup.class);
        panDatabaseServiceSetupMock = applicationContext.getBean(PanDatabaseServiceSetup.class);

        flowTestHelper.skipMessageController(applicationContext);
    }

    private void setupMockForAzureService(AzureServiceSetup azureServiceSetupMock) {
        String json1 = FileUtil.readFileFromClasspath("json-examples/agreement-updated-example.json");
        String json2 = FileUtil.readFileFromClasspath("json-examples/invoicing-rule-created-example.json");

        try {
            agreementUpdatedQueue = mock(AzureQueueWrapper.class);
            when(azureServiceSetupMock.getCloudQueue(FlowTestHelper.AZURE_QUEUE_AGREEMENT_UPDATED)).thenReturn(
                    agreementUpdatedQueue);
            invoicingRuleCreatedQueue = mock(AzureQueueWrapper.class);
            when(azureServiceSetupMock.getCloudQueue(FlowTestHelper.AZURE_QUEUE_INVOICING_RULE_CREATED)).thenReturn(
                    invoicingRuleCreatedQueue);

            when(agreementUpdatedQueue.retrieveMessage(anyInt(), any(QueueRequestOptions.class)))
                    .thenReturn(new AzureMessage(new CloudQueueMessage(json1), FlowTestHelper.AZURE_QUEUE_AGREEMENT_UPDATED)).thenReturn(null);
            when(invoicingRuleCreatedQueue.retrieveMessage(anyInt(), any(QueueRequestOptions.class)))
                    .thenReturn(new AzureMessage(new CloudQueueMessage(json2), FlowTestHelper.AZURE_QUEUE_INVOICING_RULE_CREATED)).thenReturn(null);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void setupCommonMocks() {
        flowTestHelper.setupMockForAllPortCalls(axWebServiceSetupMock);
        flowTestHelper.setupMockForAllPortInserts(callContext);
        flowTestHelper.setupMockForAllPortUpdates(callContext);
        flowTestHelper.setupMockForAllDatabaseCalls(panDatabaseServiceSetupMock);

        when(axWebServiceSetupMock.getCallContext(anyString())).thenReturn(callContext);
    }

    /**
     * This test will take a long time to run and it it not completely configured either.
     * The test is only left "if needed" and it shall be removed before production.
     * @throws Exception
     */
    @Test
    @Ignore("This will be tested by Barium instead")
    public void normalFlowWithUpdateShouldWork() throws Exception {
        // No invoice rule found
        when(flowTestHelper.salesInvoiceRulePortMock.find(any(MDSITGSalesInvRServiceFindRequest.class), same(callContext)))
                .thenReturn(flowTestHelper.createInvoicingRuleNotFound());

        // No Invoice recipient found
        when(flowTestHelper.invoiceRecipientPortMock.find(any(MDSITGSInvRecServiceFindRequest.class), same(callContext)))
                .thenReturn(flowTestHelper.createInvoiceRecipientNotFound());

        // No Agreement found
        when(flowTestHelper.agreementPortMock.find(any(MDSITGSalesClAServiceFindRequest.class), same(callContext)))
                .thenReturn(flowTestHelper.createAgreementNotFound());

        // No Client found
        when(flowTestHelper.customerPortMock.find(any(CustomerServiceFindRequest.class), same(callContext)))
                .thenReturn(flowTestHelper.createCustomerNotFound());

        // No Bank found
        when(flowTestHelper.customerBankPortMock.find(any(MDSITGCustBankServiceFindRequest.class), same(callContext)))
                .thenReturn(flowTestHelper.createBankNotFound());

        // The read flow must return found customer, since it was created earlier in the flow
        when(flowTestHelper.customerPortMock.read(any(CustomerServiceReadRequest.class), same(callContext)))
                .thenReturn(flowTestHelper.createCustomerReadFound());

        // No Invoice message found
        when(flowTestHelper.invoiceMessagePortMock.find(any(MDSITGSInvMesServiceFindRequest.class), same(callContext)))
                .thenReturn(flowTestHelper.createInvoiceMessageNotFound());


        // Return that pan database was updated
        when(flowTestHelper.jdbcTemplateMock.update(anyString(), any(Map.class))).thenReturn(1);

        muleContext.start();

        Thread.sleep(15000);
        muleContext.stop();

        // Verify azure queue operations
        verify(agreementUpdatedQueue, atLeast(1)).retrieveMessage(anyInt(), any(QueueRequestOptions.class));
        verify(invoicingRuleCreatedQueue, atLeast(1)).retrieveMessage(anyInt(), any(QueueRequestOptions.class));

        verify(agreementUpdatedQueue).deleteMessage(any(AzureMessage.class), any(QueueRequestOptions.class));
        verify(invoicingRuleCreatedQueue).deleteMessage(any(AzureMessage.class), any(QueueRequestOptions.class));
    }


}
