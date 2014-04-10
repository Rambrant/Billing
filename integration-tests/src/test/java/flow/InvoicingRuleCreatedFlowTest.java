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
import static org.mockito.Matchers.same;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.*;

/**
 * @author bjorn
 * @since 2012-06-18
 */
public class InvoicingRuleCreatedFlowTest extends AbstractMuleContextTestCase {
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
                "flow/create-invoicing-rule-crm.xml"});
    }

    @Before
    public void setup() throws SQLException {
        initializeApplicationContext();
        String json = FileUtil.readFileFromClasspath("json-examples/invoicing-rule-created-example.json");
        flowTestHelper.setupMockForAzureService(azureServiceSetupMock, json, FlowTestHelper.AZURE_QUEUE_INVOICING_RULE_CREATED);
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
    public void normalInsertNewFlowShouldWork() throws Exception {
        // No invoice rule found
        when(flowTestHelper.salesInvoiceRulePortMock.find(any(MDSITGSalesInvRServiceFindRequest.class), same(callContext)))
                .thenReturn(flowTestHelper.createInvoicingRuleNotFound());

        // Update display Td Commission went ok
        when(flowTestHelper.updateProgramMock.executeFunction(BigDecimal.class, 888111,
                "SPLIT_REVENUES", "S", 0, "Y")).thenReturn(BigDecimal.ZERO);

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

        muleContext.start();

        Thread.sleep(1200);
        muleContext.stop();

        // Insert new invoicing rule
        verify(flowTestHelper.salesInvoiceRulePortMock).find(any(MDSITGSalesInvRServiceFindRequest.class), same(callContext));
        verify(flowTestHelper.salesInvoiceRulePortMock).create(any(MDSITGSalesInvRServiceCreateRequest.class), same(callContext));

        // One find invoice recipients by invoicing rule
        verify(flowTestHelper.invoiceRecipientPortMock).find(any(MDSITGSInvRecServiceFindRequest.class), same(callContext));

        // Insert all three invoice recipients at once
        verify(flowTestHelper.invoiceRecipientPortMock).create(any(MDSITGSInvRecServiceCreateRequest.class), same(callContext));

        // Insert new agreement
        verify(flowTestHelper.agreementPortMock).find(any(MDSITGSalesClAServiceFindRequest.class), same(callContext));
        verify(flowTestHelper.agreementPortMock).create(any(MDSITGSalesClAServiceCreateRequest.class), same(callContext));

        // Insert new client
        verify(flowTestHelper.customerPortMock).find(any(CustomerServiceFindRequest.class), same(callContext));
        verify(flowTestHelper.customerPortMock).create(any(CustomerServiceCreateRequest.class), same(callContext));

        // Insert new bank
        verify(flowTestHelper.customerBankPortMock).find(any(MDSITGCustBankServiceFindRequest.class), same(callContext));
        verify(flowTestHelper.customerBankPortMock).create(any(MDSITGCustBankServiceCreateRequest.class), same(callContext));

        // Update client with bank info
        verify(flowTestHelper.customerPortMock).read(any(CustomerServiceReadRequest.class), same(callContext));
        verify(flowTestHelper.customerPortMock).update(any(CustomerServiceUpdateRequest.class), same(callContext));

        // Insert new invoice message
        verify(flowTestHelper.invoiceMessagePortMock).find(any(MDSITGSInvMesServiceFindRequest.class), same(callContext));
        verify(flowTestHelper.invoiceMessagePortMock).create(any(MDSITGSInvMesServiceCreateRequest.class), same(callContext));

        // Update display TD commission
        verify(flowTestHelper.updateProgramMock).executeFunction(BigDecimal.class, 888111, "SPLIT_REVENUES", "S", 0, "Y");

        // Verify azure queue operations
        verify(flowTestHelper.cloudQueue, atLeast(1)).retrieveMessage(anyInt(), any(QueueRequestOptions.class));
        verify(flowTestHelper.cloudQueue).deleteMessage(any(AzureMessage.class), any(QueueRequestOptions.class));

        verifyNoMoreInteractions(flowTestHelper.getAllMocks());
    }

    @Test
    public void normalFlowShouldNotUpdate() throws Exception {
        // Invoice rule found
        when(flowTestHelper.salesInvoiceRulePortMock.find(any(MDSITGSalesInvRServiceFindRequest.class), same(callContext)))
                .thenReturn(flowTestHelper.createInvoicingRuleFound());

        // Invoice recipient found
        when(flowTestHelper.invoiceRecipientPortMock.find(any(MDSITGSInvRecServiceFindRequest.class), same(callContext)))
                .thenReturn(flowTestHelper.createInvoiceRecipientFound());

        // Agreement found
        when(flowTestHelper.agreementPortMock.find(any(MDSITGSalesClAServiceFindRequest.class), same(callContext)))
                .thenReturn(flowTestHelper.createAgreementFound());

        // Client found
        CustomerServiceFindResponse customerFound = flowTestHelper.createCustomerFound();
        customerFound.getCustomer().getCustTable().get(0).setBankAccount(null);
        when(flowTestHelper.customerPortMock.find(any(CustomerServiceFindRequest.class), same(callContext)))
                .thenReturn(customerFound);

        // Bank found
        when(flowTestHelper.customerBankPortMock.find(any(MDSITGCustBankServiceFindRequest.class), same(callContext)))
                .thenReturn(flowTestHelper.createBankFound());

        // The read flow must return found customer, since it was created earlier in the flow
        when(flowTestHelper.customerPortMock.read(any(CustomerServiceReadRequest.class), same(callContext)))
                .thenReturn(flowTestHelper.createCustomerReadFound());

        // Invoice message found
        when(flowTestHelper.invoiceMessagePortMock.find(any(MDSITGSInvMesServiceFindRequest.class), same(callContext)))
                .thenReturn(flowTestHelper.createInvoiceMessageFound());

        muleContext.start();

        Thread.sleep(1200);
        muleContext.stop();

        // Find invoicing rule
        verify(flowTestHelper.salesInvoiceRulePortMock).find(any(MDSITGSalesInvRServiceFindRequest.class), same(callContext));
        // No update
        verifyNoMoreInteractions(flowTestHelper.salesInvoiceRulePortMock);

        // Three finds for three update invoice recipients
        verify(flowTestHelper.invoiceRecipientPortMock).find(any(MDSITGSInvRecServiceFindRequest.class), same(callContext));
        // No update
        verifyNoMoreInteractions(flowTestHelper.invoiceRecipientPortMock);

        // Find agreement
        verify(flowTestHelper.agreementPortMock).find(any(MDSITGSalesClAServiceFindRequest.class), same(callContext));
        // No update
        verifyNoMoreInteractions(flowTestHelper.agreementPortMock);

        // Find client
        verify(flowTestHelper.customerPortMock).find(any(CustomerServiceFindRequest.class), same(callContext));

        // Find bank
        verify(flowTestHelper.customerBankPortMock).find(any(MDSITGCustBankServiceFindRequest.class), same(callContext));
        // No update
        verifyNoMoreInteractions(flowTestHelper.customerBankPortMock);

        // Update client with bank info (the update is verified earlier (3 rows up))
        verify(flowTestHelper.customerPortMock).read(any(CustomerServiceReadRequest.class), same(callContext));
        //One update for bank info
        verify(flowTestHelper.customerPortMock).update(any(CustomerServiceUpdateRequest.class), same(callContext));

        // Find invoice message
        verify(flowTestHelper.invoiceMessagePortMock).find(any(MDSITGSInvMesServiceFindRequest.class), same(callContext));
        // No update
        verifyNoMoreInteractions(flowTestHelper.invoiceMessagePortMock);

        // No update display TD commission for updated invoicing rules
        verifyZeroInteractions(flowTestHelper.jdbcTemplateMock);

        // Verify azure queue operations
        verify(flowTestHelper.cloudQueue, atLeast(1)).retrieveMessage(anyInt(), any(QueueRequestOptions.class));
        verify(flowTestHelper.cloudQueue).deleteMessage(any(AzureMessage.class), any(QueueRequestOptions.class));

        verifyNoMoreInteractions(flowTestHelper.getAllMocks());
    }
}
