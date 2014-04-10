package flow;

import com.microsoft.windowsazure.services.queue.client.QueueRequestOptions;
import com.tradedoubler.billing.service.ax.ftp.FtpSetupServiceSetupImpl;
import com.tradedoubler.billing.service.crm.AzureServiceSetup;
import com.tradedoubler.billing.service.crm.azure.AzureMessage;
import com.tradedoubler.billing.service.pan.PanDatabaseServiceSetup;
import org.junit.Before;
import org.junit.Test;
import org.mule.api.config.ConfigurationBuilder;
import org.mule.config.spring.SpringRegistry;
import org.mule.config.spring.SpringXmlConfigurationBuilder;
import org.mule.tck.junit4.AbstractMuleContextTestCase;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.atLeast;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * User: erigu
 * Date: 2012-11-05
 */
public class InvoiceCreatedFlowTest extends AbstractMuleContextTestCase {

    private FlowTestHelper flowTestHelper = new FlowTestHelper();
    private AzureServiceSetup azureServiceSetupMock;
    private FtpSetupServiceSetupImpl ftpSetup;
    private PanDatabaseServiceSetup panDatabaseServiceSetupMock;

    @Override
    protected ConfigurationBuilder getBuilder() throws Exception {
        return new SpringXmlConfigurationBuilder(new String[]{
                "spring/springPropertiesContext.xml",
                "spring/springBeansContext.xml",
                "spring/springContext-flowMock.xml",
                "spring/springServicesContext.xml",
                "flow/commons.xml",
                "flow/test/test-invoice-flow.xml"});
    }

    @Before
    public void setup(){
        initializeApplicationContext();
        flowTestHelper.setupMockForAzureService(azureServiceSetupMock, "", FlowTestHelper.AZURE_QUEUE_UPDATE_INVOICE_INFORMATION, FlowTestHelper.AZURE_QUEUE_UPDATE_FORECAST,
                FlowTestHelper.AZURE_QUEUE_CREATE_INVOICE_INFORMATION);
        flowTestHelper.setupMockForAllDatabaseCalls(panDatabaseServiceSetupMock);


    }

    private void initializeApplicationContext() {
        ApplicationContext applicationContext = (ApplicationContext) muleContext.getRegistry().lookupObject(SpringRegistry.SPRING_APPLICATION_CONTEXT);
        azureServiceSetupMock = applicationContext.getBean(AzureServiceSetup.class);
        ftpSetup = applicationContext.getBean(FtpSetupServiceSetupImpl.class);
        panDatabaseServiceSetupMock = applicationContext.getBean(PanDatabaseServiceSetup.class);

        flowTestHelper.skipMessageController(applicationContext);
    }

    @Test
    public void moveInvoiceOnExceptionsShouldWork() throws Exception {
        flowTestHelper.setupMockForFtp(ftpSetup, "ftp/invoicepool/test_paid.xml");

        muleContext.start();
        Thread.sleep(1200);
        muleContext.stop();

//       when(flowTestHelper.ftpClient.retrieveFileStream(anyString())).thenThrow(new Exception("Fel"));

        verify(flowTestHelper.ftpClient, atLeast(1)).retrieveFileStream(anyString());

        //Should put both invoice and updateForecast to azure
        verify(flowTestHelper.cloudQueue, atLeast(2)).addMessage(any(AzureMessage.class), any(QueueRequestOptions.class));

        verify(flowTestHelper.jdbcTemplateMock, atLeast(0)).queryForInt(any(String.class), any(Object.class));


        verify(flowTestHelper.ftpClient, atLeast(1)).rename(anyString(), anyString());
        verifyNoMoreInteractions(flowTestHelper.getAllMocks());
    }

    @Test
    public void readInvoiceForPaidShouldWork() throws Exception {
        flowTestHelper.setupMockForFtp(ftpSetup, "ftp/invoicepool/test_paid.xml");

        muleContext.start();
        Thread.sleep(1200);
        muleContext.stop();

        verify(flowTestHelper.ftpClient, atLeast(1)).retrieveFileStream(anyString());

        //Should put both invoice and updateForecast to azure
        verify(flowTestHelper.cloudQueue, atLeast(2)).addMessage(any(AzureMessage.class), any(QueueRequestOptions.class));

        verify(flowTestHelper.jdbcTemplateMock, atLeast(0)).queryForInt(any(String.class), any(Object.class));


        verify(flowTestHelper.ftpClient, atLeast(1)).rename(anyString(), anyString());
        verifyNoMoreInteractions(flowTestHelper.getAllMocks());
    }

    @Test
    public void readInvoiceForPostedShouldWork() throws Exception {
        flowTestHelper.setupMockForFtp(ftpSetup, "ftp/invoicepool/test_posted.xml");

        when(flowTestHelper.invoiceCreatedAxMock.executeFunction(eq(BigDecimal.class),
                anyInt(), eq("SE100000065"),
                eq(51), eq("SEK"),
                anyString(), eq("1"))).thenReturn(BigDecimal.ZERO);

        muleContext.start();
        Thread.sleep(1200);
        muleContext.stop();

        verify(flowTestHelper.ftpClient, atLeast(1)).retrieveFileStream(anyString());

        //Should put both invoice and updateForecast to azure
        verify(flowTestHelper.cloudQueue, atLeast(2)).addMessage(any(AzureMessage.class), any(QueueRequestOptions.class));

        verify(flowTestHelper.invoiceCreatedAxMock, times(1)).executeFunction(eq(BigDecimal.class),
                anyInt(), eq("SE-12-02135"),
                eq(51), eq("SEK"),
                anyString(), eq("1"));

        verify(flowTestHelper.ftpClient, atLeast(1)).rename(anyString(), anyString());
        verifyNoMoreInteractions(flowTestHelper.getAllMocks());

    }

    @Test
    public void readInvoiceForWriteOffShouldWork() throws Exception {
        flowTestHelper.setupMockForFtp(ftpSetup, "ftp/invoicepool/test_writeoff.xml");

        muleContext.start();
        Thread.sleep(1200);
        muleContext.stop();

        verify(flowTestHelper.ftpClient, atLeast(1)).retrieveFileStream(anyString());

        //Should put both invoice and updateForecast to azure
        verify(flowTestHelper.cloudQueue, atLeast(1)).addMessage(any(AzureMessage.class), any(QueueRequestOptions.class));

        //No orderlines in writeoff file
        verify(flowTestHelper.jdbcTemplateMock, atMost(0)).queryForInt(any(String.class), any(String.class), any(String.class), any(String.class), any(String.class), any(String.class), any(String.class));

        verify(flowTestHelper.ftpClient, atLeast(1)).rename(anyString(), anyString());
        verifyNoMoreInteractions(flowTestHelper.getAllMocks());

    }
}
