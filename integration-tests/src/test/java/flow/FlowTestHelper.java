package flow;

import com.microsoft.schemas.dynamics._2008._01.documents.customer.*;
import com.microsoft.schemas.dynamics._2008._01.documents.customer.ObjectFactory;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgcustbank.*;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalescla.*;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalesinvr.*;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvmes.AxdEntityMDSSalesInvoiceMessage;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvmes.*;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvrec.*;
import com.microsoft.schemas.dynamics._2008._01.services.*;
import com.microsoft.schemas.dynamics._2010._01.datacontracts.CallContext;
import com.microsoft.windowsazure.services.queue.client.*;
import com.tradedoubler.billing.domain.Market;
import com.tradedoubler.billing.platform.messagecontroller.MessageController;
import com.tradedoubler.billing.service.ax.ftp.FtpSetupServiceSetupImpl;
import com.tradedoubler.billing.service.ax.webservice.AxWebServiceSetup;
import com.tradedoubler.billing.service.cache.CacheService;
import com.tradedoubler.billing.service.crm.AzureServiceSetup;
import com.tradedoubler.billing.service.crm.azure.*;
import com.tradedoubler.billing.service.pan.PanDatabaseServiceSetup;
import com.tradedoubler.testutil.ReflectionHelper;
import mds_salesorderbasisline.SalesOrderBasisLineProcessing;
import org.apache.commons.net.ftp.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.simple.*;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.*;
import org.tempuri.*;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.io.InputStream;
import java.util.Arrays;

import static org.hamcrest.Matchers.isIn;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/** @since 2012-09-10 */
public class FlowTestHelper {
    public static final String AZURE_QUEUE_AGREEMENT_UPDATED = "agreement-updated";
    public static final String AZURE_QUEUE_CLIENT_UPDATED = "client-updated";
    public static final String AZURE_QUEUE_INVOICING_RULE_CREATED = "invoicing-rule-created";
    public static final String AZURE_QUEUE_INVOICING_RULE_UPDATED = "invoicing-rule-updated";
    public static final String AZURE_QUEUE_INVOICE_RECIPIENT_DELETED = "invoice-recipient-deleted";
    public static final String AZURE_QUEUE_SPLITTING_RULE_DELETED = "splitting-rule-deleted";
    public static final String AZURE_QUEUE_MARKET_MESSAGE_UPDATED = "market-message-updated";
    public static final String AZURE_QUEUE_UPDATE_FORECAST = "update-forecast";
    public static final String AZURE_QUEUE_UPDATE_INVOICE_INFORMATION = "update-invoice-information";
    public static final String AZURE_QUEUE_CREATE_INVOICE_INFORMATION = "create-invoice-information";

    public final JAXBElement<String> documentHashXml = new JAXBElement<String>(new QName(""), String.class, "documentHash");

    public final MDSITGSalesInvRService salesInvoiceRulePortMock = mock(MDSITGSalesInvRService.class);
    public final MDSITGSalesClAService agreementPortMock = mock(MDSITGSalesClAService.class);
    public final CustomerService customerPortMock = mock(CustomerService.class);
    public final MDSITGCustBankService customerBankPortMock = mock(MDSITGCustBankService.class);
    public final MDSITGSInvRecService invoiceRecipientPortMock = mock(MDSITGSInvRecService.class);
    public final MDSITGSInvMesService invoiceMessagePortMock = mock(MDSITGSInvMesService.class);
    public final MDSSalesOrderBasisLineService salesOrderBasisLinePortMock = mock(MDSSalesOrderBasisLineService.class);
    public final SalesOrderBasisLineProcessing salesOrderBasisLineProcessingMock = mock(SalesOrderBasisLineProcessing.class);

    public final FTPClient ftpClient = mock(FTPClient.class);


    public final SimpleJdbcTemplate jdbcTemplateMock = mock(SimpleJdbcTemplate.class);
    public final SimpleJdbcCall fetchOrderLineBatchIdMock = mock(SimpleJdbcCall.class);
    public final SimpleJdbcCall updateBatchOfOrderLinesMock = mock(SimpleJdbcCall.class);
    public final SimpleJdbcCall fetchForecastOrderLineBatchIdMock = mock(SimpleJdbcCall.class);
    public final SimpleJdbcCall invoiceCreatedAxMock = mock(SimpleJdbcCall.class);
    public final SimpleJdbcCall invoicingStartedMock = mock(SimpleJdbcCall.class);
    public final SimpleJdbcCall updateBatchOfForecastOrderLinesMock = mock(SimpleJdbcCall.class);
    public final SimpleJdbcCall updateProgramMock = mock(SimpleJdbcCall.class);
    public final SimpleJdbcCall readyToInvoiceMock = mock(SimpleJdbcCall.class);

    public final TransactionTemplate transactionTemplateMock = mock(TransactionTemplate.class);
    public final AzureQueueWrapper cloudQueue = mock(AzureQueueWrapper.class);

    private MDSITGSalesInvRServiceCreateResponse salesInvCreateResponse = new MDSITGSalesInvRServiceCreateResponse();
    private MDSITGSalesClAServiceCreateResponse clientAgreementCreateResponse = new MDSITGSalesClAServiceCreateResponse();
    private CustomerServiceCreateResponse customerServiceCreateResponse = new CustomerServiceCreateResponse();
    private MDSITGCustBankServiceCreateResponse customerBankServiceCreateResponse = new MDSITGCustBankServiceCreateResponse();
    private MDSITGSInvRecServiceCreateResponse invoiceRecipientServiceCreateResponse = new MDSITGSInvRecServiceCreateResponse();
    private MDSITGSInvMesServiceCreateResponse invoiceMessageServiceCreateResponse = new MDSITGSInvMesServiceCreateResponse();

    private MDSITGSalesInvRServiceUpdateResponse salesInvUpdateResponse = new MDSITGSalesInvRServiceUpdateResponse();
    private MDSITGSalesClAServiceUpdateResponse clientAgreementUpdateResponse = new MDSITGSalesClAServiceUpdateResponse();
    private CustomerServiceUpdateResponse customerServiceUpdateResponse = new CustomerServiceUpdateResponse();
    private MDSITGCustBankServiceUpdateResponse customerBankServiceUpdateResponse = new MDSITGCustBankServiceUpdateResponse();
    private MDSITGSInvRecServiceUpdateResponse invoiceRecipientServiceUpdateResponse = new MDSITGSInvRecServiceUpdateResponse();
    private MDSITGSInvMesServiceUpdateResponse invoiceMessageServiceUpdateResponse = new MDSITGSInvMesServiceUpdateResponse();

    public void setupMockForAllPortCalls(AxWebServiceSetup axWebServiceSetupMock) {
        when(axWebServiceSetupMock.getSalesInvoiceRulePort()).thenReturn(salesInvoiceRulePortMock);
        when(axWebServiceSetupMock.getSalesClientAgreementPort()).thenReturn(agreementPortMock);
        when(axWebServiceSetupMock.getCustomerPort()).thenReturn(customerPortMock);
        when(axWebServiceSetupMock.getCustomerBankServicePort()).thenReturn(customerBankPortMock);
        when(axWebServiceSetupMock.getInvoiceRecipientPort()).thenReturn(invoiceRecipientPortMock);
        when(axWebServiceSetupMock.getSalesInvMessagePort()).thenReturn(invoiceMessagePortMock);
        when(axWebServiceSetupMock.getOrderBasisLinePort()).thenReturn(salesOrderBasisLinePortMock);
        when(axWebServiceSetupMock.getOrderBasisLineProcessingPort()).thenReturn(salesOrderBasisLineProcessingMock);
    }

    public void setupMockForAllPortUpdates(CallContext callContext) {
        try {
            when(salesInvoiceRulePortMock.update(any(MDSITGSalesInvRServiceUpdateRequest.class), same(callContext))).thenReturn(salesInvUpdateResponse);
            when(agreementPortMock.update(any(MDSITGSalesClAServiceUpdateRequest.class), same(callContext))).thenReturn(clientAgreementUpdateResponse);
            when(customerPortMock.update(any(CustomerServiceUpdateRequest.class), same(callContext))).thenReturn(customerServiceUpdateResponse);
            when(customerBankPortMock.update(any(MDSITGCustBankServiceUpdateRequest.class), same(callContext))).thenReturn(customerBankServiceUpdateResponse);
            when(invoiceRecipientPortMock.update(any(MDSITGSInvRecServiceUpdateRequest.class), same(callContext))).thenReturn(invoiceRecipientServiceUpdateResponse);
            when(invoiceMessagePortMock.update(any(MDSITGSInvMesServiceUpdateRequest.class), same(callContext))).thenReturn(invoiceMessageServiceUpdateResponse);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setupMockForAllPortInserts(CallContext callContext) {
        try {
            when(salesInvoiceRulePortMock.create(any(MDSITGSalesInvRServiceCreateRequest.class), same(callContext))).thenReturn(salesInvCreateResponse);
            when(agreementPortMock.create(any(MDSITGSalesClAServiceCreateRequest.class), same(callContext))).thenReturn(clientAgreementCreateResponse);
            when(customerPortMock.create(any(CustomerServiceCreateRequest.class), same(callContext))).thenReturn(customerServiceCreateResponse);
            when(customerBankPortMock.create(any(MDSITGCustBankServiceCreateRequest.class), same(callContext))).thenReturn(customerBankServiceCreateResponse);
            when(invoiceRecipientPortMock.create(any(MDSITGSInvRecServiceCreateRequest.class), same(callContext))).thenReturn(invoiceRecipientServiceCreateResponse);
            when(invoiceMessagePortMock.create(any(MDSITGSInvMesServiceCreateRequest.class), same(callContext))).thenReturn(invoiceMessageServiceCreateResponse);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setupMockForAllDatabaseCalls(PanDatabaseServiceSetup panDatabaseServiceSetupMock) {
        when(transactionTemplateMock.execute(any(TransactionCallback.class))).thenAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                TransactionCallback callback = (TransactionCallback) invocation.getArguments()[0];
                return callback.doInTransaction(mock(TransactionStatus.class));
            }
        });
        when(panDatabaseServiceSetupMock.getJdbcTemplate()).thenReturn(jdbcTemplateMock);
        when(panDatabaseServiceSetupMock.getTransactionTemplate()).thenReturn(transactionTemplateMock);
        when(panDatabaseServiceSetupMock.getFetchOrderLineBatchId()).thenReturn(fetchOrderLineBatchIdMock);
        when(panDatabaseServiceSetupMock.getUpdateBatchOfOrderLines()).thenReturn(updateBatchOfOrderLinesMock);
        when(panDatabaseServiceSetupMock.getUpdateBatchOfOrderLinesPP()).thenReturn(updateBatchOfForecastOrderLinesMock);
        when(panDatabaseServiceSetupMock.getInvoicingStarted()).thenReturn(invoicingStartedMock);
        when(panDatabaseServiceSetupMock.getInvoiceCreatedAx()).thenReturn(invoiceCreatedAxMock);
        when(panDatabaseServiceSetupMock.getFetchOrderLineBatchIdPP()).thenReturn(fetchForecastOrderLineBatchIdMock);
        when(panDatabaseServiceSetupMock.getReadyToInvoice()).thenReturn(readyToInvoiceMock);
        when(panDatabaseServiceSetupMock.getUpdateProgram()).thenReturn(updateProgramMock);
    }

    public void setupMockForAzureService(AzureServiceSetup azureServiceSetupMock, String json, final Object... queueName) {
        try {
            when(azureServiceSetupMock.getCloudQueue(anyString())).then(new Answer<AzureQueueWrapper>() {
                @Override
                public AzureQueueWrapper answer(InvocationOnMock invocationOnMock) throws Throwable {

                    assertThat(invocationOnMock.getArguments()[0].toString(), isIn(queueName));
                    return cloudQueue;
                }
            });

            when(cloudQueue.retrieveMessage(anyInt(), any(QueueRequestOptions.class)))
                    .thenReturn(new AzureMessage(new CloudQueueMessage(json), (String) queueName[0])).thenReturn(null);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Object[] getAllMocks() {
        return new Object[]{salesInvoiceRulePortMock, agreementPortMock, customerPortMock,
                customerBankPortMock, invoiceRecipientPortMock, invoiceMessagePortMock, salesOrderBasisLinePortMock,

                jdbcTemplateMock, cloudQueue, salesOrderBasisLineProcessingMock,

                fetchOrderLineBatchIdMock, updateBatchOfOrderLinesMock,
                fetchForecastOrderLineBatchIdMock, invoiceCreatedAxMock,
                invoicingStartedMock, updateBatchOfForecastOrderLinesMock,
                updateProgramMock, readyToInvoiceMock,
        }; //Do not add ftpClient

    }

    public void skipMessageController(ApplicationContext applicationContext) {
        MessageController messageController = applicationContext.getBean(MessageController.class);
        messageController.setSkipMessageController(true);
    }

    public MDSITGSInvMesServiceFindResponse createInvoiceMessageFound() {
        AxdEntityMDSSalesInvoiceMessage invoiceMessage = new AxdEntityMDSSalesInvoiceMessage();
        invoiceMessage.setDocumentHash(documentHashXml);

        AxdMDSITGSInvMes value = new AxdMDSITGSInvMes();
        value.getMDSSalesInvoiceMessage().add(invoiceMessage);

        MDSITGSInvMesServiceFindResponse findInvoiceMessageFound = new MDSITGSInvMesServiceFindResponse();
        findInvoiceMessageFound.setMDSITGSInvMes(value);
        return findInvoiceMessageFound;
    }

    public MDSITGSInvMesServiceFindResponse createInvoiceMessageNotFound() {
        MDSITGSInvMesServiceFindResponse findInvoiceMessageNotFound = new MDSITGSInvMesServiceFindResponse();
        findInvoiceMessageNotFound.setMDSITGSInvMes(new AxdMDSITGSInvMes());
        return findInvoiceMessageNotFound;
    }

    public CustomerServiceFindResponse createCustomerFound() {
        AxdEntityDirPartyDirPartyTable dirParty = new AxdEntityDirPartyDirOrganization();
        dirParty.getDirPartyPostalAddressView().add(new AxdEntityDirPartyPostalAddressView());

        AxdEntityCustTable customer = new AxdEntityCustTable();
        ObjectFactory objectFactory = new ObjectFactory();
        customer.setDocumentHash(documentHashXml);
        customer.setBankAccount(objectFactory.createAxdEntityCustTableBankAccount("1234-1234567890"));
        customer.getDirParty().add(dirParty);

        AxdCustomer value = new AxdCustomer();
        value.getCustTable().add(customer);

        CustomerServiceFindResponse findCustomerResponseFound = new CustomerServiceFindResponse();
        findCustomerResponseFound.setCustomer(value);

        return findCustomerResponseFound;

    }

    public CustomerServiceFindResponse createCustomerNotFound() {
        CustomerServiceFindResponse findCustomerResponseNotFound = new CustomerServiceFindResponse();
        findCustomerResponseNotFound.setCustomer(new AxdCustomer());

        return findCustomerResponseNotFound;
    }

    public MDSITGSalesInvRServiceFindResponse createInvoicingRuleFound() {
        AxdEntityMDSSalesInvoiceRule invoiceRule = new AxdEntityMDSSalesInvoiceRule();
        invoiceRule.setDocumentHash(documentHashXml);

        AxdMDSITGSalesInvR value = new AxdMDSITGSalesInvR();
        value.getMDSSalesInvoiceRule().add(invoiceRule);

        MDSITGSalesInvRServiceFindResponse findResponse = new MDSITGSalesInvRServiceFindResponse();
        findResponse.setMDSITGSalesInvR(value);

        return findResponse;
    }

    public MDSITGSalesInvRServiceFindResponse createInvoicingRuleNotFound() {
        MDSITGSalesInvRServiceFindResponse findResponse = new MDSITGSalesInvRServiceFindResponse();
        findResponse.setMDSITGSalesInvR(new AxdMDSITGSalesInvR());

        return findResponse;
    }

    public MDSITGSalesClAServiceFindResponse createAgreementFound() {
        MDSITGSalesClAServiceFindResponse findResponseFound = new MDSITGSalesClAServiceFindResponse();

        AxdEntityMDSSalesClientAgreement agreement = new AxdEntityMDSSalesClientAgreement();
        agreement.setDocumentHash(documentHashXml);

        AxdMDSITGSalesClA value = new AxdMDSITGSalesClA();
        value.getMDSSalesClientAgreement().add(agreement);

        findResponseFound.setMDSITGSalesClA(value);
        return findResponseFound;
    }

    public MDSITGSalesClAServiceFindResponse createAgreementNotFound() {
        MDSITGSalesClAServiceFindResponse findResponseNotFound = new MDSITGSalesClAServiceFindResponse();

        findResponseNotFound.setMDSITGSalesClA(new AxdMDSITGSalesClA());
        return findResponseNotFound;
    }

    public CustomerServiceReadResponse createCustomerReadFound() {
        CustomerServiceReadResponse readCustomerResponseFound = new CustomerServiceReadResponse();
        AxdEntityDirPartyDirPartyTable dirParty = new AxdEntityDirPartyDirOrganization();
        dirParty.getDirPartyPostalAddressView().add(new AxdEntityDirPartyPostalAddressView());

        AxdEntityCustTable customer = new AxdEntityCustTable();
        ObjectFactory objectFactory = new ObjectFactory();
        customer.setDocumentHash(documentHashXml);
        customer.setBankAccount(objectFactory.createAxdEntityCustTableBankAccount("1234-1234567890"));
        customer.setAccountNum(objectFactory.createAxdEntityCustTableAccountNum("accountNum"));
        customer.getDirParty().add(dirParty);

        AxdCustomer value = new AxdCustomer();
        value.getCustTable().add(customer);

        readCustomerResponseFound.setCustomer(value);
        return readCustomerResponseFound;
    }

    public MDSITGCustBankServiceFindResponse createBankFound() {
        MDSITGCustBankServiceFindResponse findCustomerBankResponseFound = new MDSITGCustBankServiceFindResponse();
        AxdEntityCustBankAccount bank = new AxdEntityCustBankAccount();
        bank.setDocumentHash(documentHashXml);
        bank.setAccountID("1234-1234567890");

        AxdMDSITGCustBank value2 = new AxdMDSITGCustBank();
        value2.getCustBankAccount().add(bank);

        findCustomerBankResponseFound.setMDSITGCustBank(value2);
        return findCustomerBankResponseFound;
    }

    public MDSITGCustBankServiceFindResponse createBankNotFound() {
        MDSITGCustBankServiceFindResponse findCustomerBankResponseNotFound = new MDSITGCustBankServiceFindResponse();
        findCustomerBankResponseNotFound.setMDSITGCustBank(new AxdMDSITGCustBank());
        return findCustomerBankResponseNotFound;
    }

    public MDSITGSInvRecServiceFindResponse createInvoiceRecipientFound() {
        MDSITGSInvRecServiceFindResponse findInvoiceRecipientFound = new MDSITGSInvRecServiceFindResponse();
        AxdEntityLogisticsPostalAddress postalAddress = new AxdEntityLogisticsPostalAddress();

        AxdEntityLogisticsLocation location = new AxdEntityLogisticsLocation();
        location.getLogisticsPostalAddress().add(postalAddress);

        AxdEntityMDSSalesSplitter splitter = new AxdEntityMDSSalesSplitter();
        splitter.setSplitterId("{F3F43916-25E5-E111-8B5B-005056B45DA6}");

        AxdEntityMDSSalesInvoiceRecipient recipient = new AxdEntityMDSSalesInvoiceRecipient();
        recipient.getMDSSalesSplitter().add(splitter);
        recipient.setDocumentHash(documentHashXml);
        recipient.getLogisticsLocation().add(location);
        recipient.setInvoiceRecipientId("invoiceRecipientId");

        AxdMDSITGSInvRec value = new AxdMDSITGSInvRec();
        value.getMDSSalesInvoiceRecipient().add(recipient);

        findInvoiceRecipientFound.setMDSITGSInvRec(value);
        return findInvoiceRecipientFound;
    }

    public MDSITGSInvRecServiceFindResponse createInvoiceRecipientNotFound() {
        MDSITGSInvRecServiceFindResponse findInvoiceRecipientNotFound = new MDSITGSInvRecServiceFindResponse();
        findInvoiceRecipientNotFound.setMDSITGSInvRec(new AxdMDSITGSInvRec());
        return findInvoiceRecipientNotFound;
    }

    public void setupMockForFtp(FtpSetupServiceSetupImpl ftpSetup, String file) {

        FTPFile ftpFile = mock(FTPFile.class);

        when(ftpFile.isFile()).thenReturn(true);
        when(ftpFile.getName()).thenReturn(file);

        FTPFile[] files = {ftpFile};
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream(file);
            when(ftpClient.retrieveFileStream(anyString())).thenReturn(is);
            when(ftpClient.completePendingCommand()).thenReturn(true);
            when(ftpClient.listFiles()).thenReturn(files);
            when(ftpSetup.connect()).thenReturn(ftpClient);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadMarketsInCacheService(CacheService cacheService, Market... markets) {
        try {
            new ReflectionHelper(cacheService).setField("markets", Arrays.asList(markets));
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

