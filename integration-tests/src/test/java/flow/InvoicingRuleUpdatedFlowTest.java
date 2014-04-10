package flow;

import com.microsoft.schemas.dynamics._2008._01.services.*;
import com.microsoft.schemas.dynamics._2010._01.datacontracts.CallContext;
import com.microsoft.windowsazure.services.queue.client.QueueRequestOptions;
import com.tradedoubler.billing.service.ax.webservice.AxWebServiceSetup;
import com.tradedoubler.billing.service.crm.AzureServiceSetup;
import com.tradedoubler.billing.service.crm.azure.AzureMessage;
import com.tradedoubler.billing.service.pan.PanDatabaseServiceSetup;
import com.tradedoubler.testutil.FileUtil;
import org.junit.*;
import org.mule.api.config.ConfigurationBuilder;
import org.mule.config.spring.*;
import org.mule.tck.junit4.AbstractMuleContextTestCase;
import org.springframework.context.ApplicationContext;
import org.tempuri.*;

import java.math.BigDecimal;
import java.sql.SQLException;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * @author bjorn
 * @since 2012-06-18
 */
public class InvoicingRuleUpdatedFlowTest extends AbstractMuleContextTestCase {
    private FlowTestHelper flowTestHelper = new FlowTestHelper();

    private AzureServiceSetup azureServiceSetupMock;
    private AxWebServiceSetup axWebServiceSetupMock;
    private PanDatabaseServiceSetup panDatabaseServiceSetupMock;

    private CallContext callContext = new CallContext();

    @Override
    protected ConfigurationBuilder getBuilder() throws Exception {
        return new SpringXmlConfigurationBuilder(new String[]{
                "spring/springPropertiesContext.xml",
                "spring/springBeansContext.xml",
                "spring/springContext-flowMock.xml",
                "spring/springServicesContext.xml",
                "flow/commons.xml",
                "flow/update-invoicing-rule-crm.xml"});
    }

    @Before
    public void setup() throws SQLException {
        initializeApplicationContext();
        String json = FileUtil.readFileFromClasspath("json-examples/invoicing-rule-updated-example.json");
        flowTestHelper.setupMockForAzureService(azureServiceSetupMock, json, FlowTestHelper.AZURE_QUEUE_INVOICING_RULE_UPDATED);

        setupCommonMocks();
    }

    private void initializeApplicationContext() {
        ApplicationContext applicationContext = (ApplicationContext) muleContext.getRegistry().lookupObject(SpringRegistry.SPRING_APPLICATION_CONTEXT);
        azureServiceSetupMock = applicationContext.getBean(AzureServiceSetup.class);
        axWebServiceSetupMock = applicationContext.getBean(AxWebServiceSetup.class);
        panDatabaseServiceSetupMock = applicationContext.getBean(PanDatabaseServiceSetup.class);

        flowTestHelper.skipMessageController(applicationContext);
    }

    private void setupCommonMocks() throws SQLException {
        flowTestHelper.setupMockForAllPortCalls(axWebServiceSetupMock);
        flowTestHelper.setupMockForAllPortInserts(callContext);
        flowTestHelper.setupMockForAllPortUpdates(callContext);
        flowTestHelper.setupMockForAllDatabaseCalls(panDatabaseServiceSetupMock);
        when(axWebServiceSetupMock.getCallContext(anyString())).thenReturn(callContext);
    }

    @Test
    public void normalFlowShouldWork() throws Exception {
        when(flowTestHelper.salesInvoiceRulePortMock.find(any(MDSITGSalesInvRServiceFindRequest.class), same(callContext)))
                .thenReturn(flowTestHelper.createInvoicingRuleFound());
        // Don't find the new ones to insert
        when(flowTestHelper.invoiceRecipientPortMock.find(any(MDSITGSInvRecServiceFindRequest.class), same(callContext)))
                .thenReturn(flowTestHelper.createInvoiceRecipientNotFound());

        // Update display Td Commission went ok
        when(flowTestHelper.updateProgramMock.executeFunction(BigDecimal.class, 81,
                "SPLIT_REVENUES", "S", 0, "Y")).thenReturn(BigDecimal.ZERO);

        muleContext.start();

        Thread.sleep(1200);
        muleContext.stop();

        verify(flowTestHelper.salesInvoiceRulePortMock).find(any(MDSITGSalesInvRServiceFindRequest.class), same(callContext));
        verify(flowTestHelper.salesInvoiceRulePortMock).update(any(MDSITGSalesInvRServiceUpdateRequest.class), same(callContext));

        // Three ones to update from the json example
        verify(flowTestHelper.invoiceRecipientPortMock, times(3)).find(any(MDSITGSInvRecServiceFindRequest.class), same(callContext));

        // Do not delete the old one (this will be handled by another flow entirely)
        verify(flowTestHelper.invoiceRecipientPortMock, never()).delete(any(MDSITGSInvRecServiceDeleteRequest.class), same(callContext));

        // Insert the three new ones
        verify(flowTestHelper.invoiceRecipientPortMock, times(3)).create(any(MDSITGSInvRecServiceCreateRequest.class), same(callContext));

        // Update display TD commission
        verify(flowTestHelper.updateProgramMock).executeFunction(BigDecimal.class, 81, "SPLIT_REVENUES", "S", 0, "Y");

        // Verify azure queue operations
        verify(flowTestHelper.cloudQueue, atLeast(1)).retrieveMessage(anyInt(), any(QueueRequestOptions.class));
        verify(flowTestHelper.cloudQueue).deleteMessage(any(AzureMessage.class), any(QueueRequestOptions.class));

        verifyNoMoreInteractions(flowTestHelper.getAllMocks());
    }

    @Test
    public void notFoundInvoiceRuleFlowShouldThrowException() throws Exception {
        when(flowTestHelper.salesInvoiceRulePortMock.find(any(MDSITGSalesInvRServiceFindRequest.class), same(callContext)))
                .thenReturn(flowTestHelper.createInvoicingRuleNotFound());

        muleContext.start();

        Thread.sleep(1200);
        muleContext.stop();

        verify(flowTestHelper.salesInvoiceRulePortMock).find(any(MDSITGSalesInvRServiceFindRequest.class), same(callContext));

        // Verify azure queue operations
        verify(flowTestHelper.cloudQueue, atLeast(1)).retrieveMessage(anyInt(), any(QueueRequestOptions.class));

        verifyNoMoreInteractions(flowTestHelper.getAllMocks());
    }
}
