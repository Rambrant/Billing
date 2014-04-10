package com.tradedoubler.billing.service;

import com.tradedoubler.billing.domain.Invoice;
import com.tradedoubler.billing.mulecomponent.MuleInvoiceHandling;
import com.tradedoubler.billing.platform.flowcontroller.IntegrationMessage;
import com.tradedoubler.billing.platform.flowcontroller.ServiceResult;
import com.tradedoubler.billing.service.ax.AxServiceImpl;
import com.tradedoubler.billing.service.ax.ftp.AxInvoice;
import com.tradedoubler.billing.service.ax.ftp.call.FetchInvoiceCall;
import com.tradedoubler.billing.service.ax.ftp.handler.InvoiceFtpHandler;
import com.tradedoubler.billing.service.ax.ftp.handler.InvoiceStatus;
import com.tradedoubler.billing.service.crm.CrmServiceImpl;
import com.tradedoubler.billing.service.crm.JsonValidatorService;
import com.tradedoubler.billing.service.pan.PanService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * User: erigu
 * Date: 2012-11-07
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext-test.xml", "/spring/springBeansContext.xml"})
public class InvoiceCreatedGraphTest {
    @InjectMocks
    MuleInvoiceHandling muleInvoiceHandling = new MuleInvoiceHandling();

    @InjectMocks
    private AxServiceImpl axService;

    @Mock
    private CrmServiceImpl crmService;


    @Mock
    JsonValidatorService jsonValidatorService;

    @Mock
    InvoiceFtpHandler invoiceFtpHandler;

    @Mock
    FetchInvoiceCall fetchInvoiceCall;


    @Mock
    private PanService panService;

    private ServiceResult serviceResult;

    @InjectMocks
    private AxServiceImpl axServiceImpl;

    @Before
    public void init() throws BillingServiceException {
        initMocks(this);
    }

    @Test
    public void fetchSuccesful() throws BillingServiceException {
        serviceResult = mock(ServiceResult.class);
        IntegrationMessage integrationMessage = mock(IntegrationMessage.class);
        AxInvoice axInvoice = mock(AxInvoice.class);
        Invoice invoice = mock(Invoice.class);
        when(axInvoice.getInvoice()).thenReturn(invoice);

        when(invoiceFtpHandler.fetchInvoice()).thenReturn(axInvoice);
        when(integrationMessage.getDomainObject()).thenReturn(axInvoice);
        when(serviceResult.getIntegrationMessage()).thenReturn(integrationMessage);
        when(axInvoice.getInvoiceStatus()).thenReturn(InvoiceStatus.INVOICE_OK);
        when(fetchInvoiceCall.getAxInvoice()).thenReturn(axInvoice);
        serviceResult = new ServiceResult();
        axServiceImpl.fetchCreatedInvoice(serviceResult);
        verify(invoiceFtpHandler, times(0)).moveFailedInvoice(any(AxInvoice.class), anyString());
    }

    @Test
    public void fetchLacksDocument() throws Exception {
        serviceResult = mock(ServiceResult.class);
        IntegrationMessage integrationMessage = mock(IntegrationMessage.class);
        AxInvoice axInvoice = mock(AxInvoice.class);
        when(invoiceFtpHandler.fetchInvoice()).thenReturn(axInvoice);
        when(integrationMessage.getDomainObject()).thenReturn(axInvoice);
        when(serviceResult.getIntegrationMessage()).thenReturn(integrationMessage);
        when(axInvoice.getInvoiceStatus()).thenReturn(InvoiceStatus.INVOICE_LACKS_DOCUMENT);
        when(fetchInvoiceCall.getAxInvoice()).thenReturn(axInvoice);
        serviceResult = new ServiceResult();
        try {
            axServiceImpl.fetchCreatedInvoice(serviceResult);
        } catch (BillingServiceException e) {
            ///Changed move directory to Mule component
            verify(invoiceFtpHandler, times(0)).moveFailedInvoice(any(AxInvoice.class), anyString());
        }
    }

    @Test  //TODO: Check relevance
    public void fetchFailedReadFromFtp() throws Exception {
        serviceResult = mock(ServiceResult.class);
        IntegrationMessage integrationMessage = mock(IntegrationMessage.class);
        AxInvoice axInvoice = mock(AxInvoice.class);
        Invoice invoice = mock(Invoice.class);
        when(axInvoice.getInvoice()).thenReturn(invoice);
        when(invoiceFtpHandler.fetchInvoice()).thenReturn(axInvoice);
        when(integrationMessage.getDomainObject()).thenReturn(axInvoice);
        when(serviceResult.getIntegrationMessage()).thenReturn(integrationMessage);
        when(axInvoice.getInvoiceStatus()).thenReturn(InvoiceStatus.FAILED_READ_FROM_FTP);
        when(fetchInvoiceCall.getAxInvoice()).thenReturn(axInvoice);
        serviceResult = new ServiceResult();
        try {
            axServiceImpl.fetchCreatedInvoice(serviceResult);
        } catch (BillingServiceException e) {
            verify(invoiceFtpHandler, times(1)).moveFailedInvoice(any(AxInvoice.class), anyString());
        }
    }

    @Test
    public void handlingInvoiceSuccess() throws Exception {

        prepareForHandlingTest();

        muleInvoiceHandling.execute(serviceResult);

        verify(jsonValidatorService, times(1)).validateCreateInvoice(any(ServiceResult.class));
        verify(jsonValidatorService, times(1)).validateUpdateForecast(any(ServiceResult.class));
        verify(crmService, times(1)).insertInvoice(any(ServiceResult.class));
        verify(crmService, times(1)).insertUpdateForecast(any(ServiceResult.class));
        verify(panService, times(1)).handleInvoiceForPan(any(ServiceResult.class));

        verifyNoMoreInteractions(jsonValidatorService, crmService, panService);


    }

    @Test
    public void handlingInvoiceUpdateForecastValidationFailed() throws Exception {

        prepareForHandlingTest();


        when(jsonValidatorService.validateUpdateForecast(any(ServiceResult.class))).thenThrow(BillingServiceException.createBugDisturbance("test"));
        try {
            muleInvoiceHandling.execute(serviceResult);
        } catch (Exception e) {
            verify(jsonValidatorService, times(1)).validateCreateInvoice(any(ServiceResult.class));
            verify(jsonValidatorService, times(1)).validateUpdateForecast(any(ServiceResult.class));
            verify(crmService, times(0)).insertInvoice(any(ServiceResult.class));
            verify(crmService, times(0)).insertUpdateForecast(any(ServiceResult.class));
            verify(panService, times(0)).handleInvoiceForPan(any(ServiceResult.class));
            verifyNoMoreInteractions(jsonValidatorService, crmService, panService);
        }
    }

    private void prepareForHandlingTest() {
        serviceResult = mock(ServiceResult.class);
        IntegrationMessage integrationMessage = mock(IntegrationMessage.class);
        AxInvoice axInvoice = mock(AxInvoice.class);
        when(integrationMessage.getDomainObject()).thenReturn(axInvoice);
        when(serviceResult.getIntegrationMessage()).thenReturn(integrationMessage);
    }

    @Test
    public void handlingInvoiceInvoiceValidationFailed() throws Exception {

        prepareForHandlingTest();


        when(jsonValidatorService.validateCreateInvoice(any(ServiceResult.class))).thenThrow(BillingServiceException.createBugDisturbance("test"));
        try {
            muleInvoiceHandling.execute(serviceResult);
        } catch (Exception e) {
            verify(jsonValidatorService, times(1)).validateCreateInvoice(any(ServiceResult.class));
            verify(jsonValidatorService, times(0)).validateUpdateForecast(any(ServiceResult.class));
            verify(crmService, times(0)).insertInvoice(any(ServiceResult.class));
            verify(crmService, times(0)).insertUpdateForecast(any(ServiceResult.class));
            verify(panService, times(0)).handleInvoiceForPan(any(ServiceResult.class));
            verifyNoMoreInteractions(jsonValidatorService, crmService, panService);
        }
    }

    @Test
    public void handlingInsertCrmInvoiceFailed() throws Exception {

        prepareForHandlingTest();


        when(crmService.insertInvoice(any(ServiceResult.class))).thenThrow(BillingServiceException.createBugDisturbance("test"));
        try {
            muleInvoiceHandling.execute(serviceResult);
        } catch (Exception e) {
            verify(jsonValidatorService, times(1)).validateCreateInvoice(any(ServiceResult.class));
            verify(jsonValidatorService, times(1)).validateUpdateForecast(any(ServiceResult.class));
            verify(crmService, times(1)).insertInvoice(any(ServiceResult.class));
            verify(crmService, times(0)).insertUpdateForecast(any(ServiceResult.class));
            verify(panService, times(0)).handleInvoiceForPan(any(ServiceResult.class));
            verifyNoMoreInteractions(jsonValidatorService, crmService, panService);
        }
    }

    @Test
    public void handlingInsertCrmUpdateForecastFailed() throws Exception {

        prepareForHandlingTest();


        when(crmService.insertUpdateForecast(any(ServiceResult.class))).thenThrow(BillingServiceException.createBugDisturbance("test"));
        try {
            muleInvoiceHandling.execute(serviceResult);
        } catch (Exception e) {
            verify(jsonValidatorService, times(1)).validateCreateInvoice(any(ServiceResult.class));
            verify(jsonValidatorService, times(1)).validateUpdateForecast(any(ServiceResult.class));
            verify(crmService, times(1)).insertInvoice(any(ServiceResult.class));
            verify(crmService, times(1)).insertUpdateForecast(any(ServiceResult.class));
            verify(panService, times(0)).handleInvoiceForPan(any(ServiceResult.class));
            verifyNoMoreInteractions(jsonValidatorService, crmService, panService);
        }
    }

    @Test
    public void handlingInsertPanFailed() throws Exception {

        prepareForHandlingTest();


        when(panService.handleInvoiceForPan(any(ServiceResult.class))).thenThrow(BillingServiceException.createBugDisturbance("test"));
        try {
            muleInvoiceHandling.execute(serviceResult);
        } catch (Exception e) {
            verify(jsonValidatorService, times(1)).validateCreateInvoice(any(ServiceResult.class));
            verify(jsonValidatorService, times(1)).validateUpdateForecast(any(ServiceResult.class));
            verify(crmService, times(1)).insertInvoice(any(ServiceResult.class));
            verify(crmService, times(1)).insertUpdateForecast(any(ServiceResult.class));
            verify(panService, times(1)).handleInvoiceForPan(any(ServiceResult.class));
            verifyNoMoreInteractions(jsonValidatorService, crmService, panService);
        }
    }

}
