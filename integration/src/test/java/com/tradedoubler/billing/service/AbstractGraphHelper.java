package com.tradedoubler.billing.service;

import com.tradedoubler.billing.platform.flowcontroller.*;
import com.tradedoubler.billing.service.ax.*;
import com.tradedoubler.billing.service.ax.ftp.call.*;
import com.tradedoubler.billing.service.ax.ftp.handler.InvoiceFtpHandler;
import com.tradedoubler.billing.service.ax.webservice.AxRequestResult;
import com.tradedoubler.billing.service.ax.webservice.call.*;
import com.tradedoubler.billing.service.ax.webservice.domainhandler.*;
import com.tradedoubler.billing.service.crm.*;
import com.tradedoubler.billing.service.crm.azure.*;
import com.tradedoubler.billing.service.crm.call.*;
import com.tradedoubler.billing.service.pan.*;
import com.tradedoubler.billing.service.pan.call.*;
import com.tradedoubler.billing.service.pan.handler.*;
import com.tradedoubler.billing.service.transform.AxConverterServiceImpl;
import com.tradedoubler.billing.transform.json.UpdateForecastToJsonTransformer;
import com.tradedoubler.testutil.ReflectionHelper;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * @author bjoek
 * @since 2012-10-05
 */
public class AbstractGraphHelper {
    final AxService axService = new AxServiceImpl();
    final PanService panService = new PanServiceImpl();
    final CrmService crmService = new CrmServiceImpl();
    final JsonValidatorService jsonValidatorService = mock(JsonValidatorService.class);

    private final InvoicingRuleHandler invoicingRuleHandler = new InvoicingRuleHandler();
    private final InvoiceRecipientHandler invoiceRecipientHandler = new InvoiceRecipientHandler();
    private final AgreementHandler agreementHandler = new AgreementHandler();
    private final ClientHandler clientHandler = new ClientHandler();
    private final BankHandler bankHandler = new BankHandler();
    private final InvoiceMessageRuleHandler invoiceMessageRuleHandler = new InvoiceMessageRuleHandler();
    private final OrderLineHandler orderLineHandler = new OrderLineHandler();
    
    private final CommissionPanHandler commissionPanHandler = new CommissionPanHandler();
    private final OrderLinesPanHandler orderLinesPanHandler = new OrderLinesPanHandler();

    final FindClientCall findClientCall = mock(FindClientCall.class);
    final InsertClientCall insertClientCall = mock(InsertClientCall.class);
    final UpdateClientCall updateClientCall = mock(UpdateClientCall.class);
    final ReadClientCall readClientCall = mock(ReadClientCall.class);
    final FindBankCall findBankCall = mock(FindBankCall.class);
    final InsertBankCall insertBankCall = mock(InsertBankCall.class);
    final UpdateBankCall updateBankCall = mock(UpdateBankCall.class);
    final FindInvoiceMessageRuleCall findInvoiceMessageRuleCall = mock(FindInvoiceMessageRuleCall.class);
    final InsertInvoiceMessageRuleCall insertInvoiceMessageRuleCall = mock(InsertInvoiceMessageRuleCall.class);
    final UpdateInvoiceMessageRuleCall updateInvoiceMessageRuleCall = mock(UpdateInvoiceMessageRuleCall.class);
    final FindAgreementCall findAgreementCall = mock(FindAgreementCall.class);
    final InsertAgreementCall insertAgreementCall = mock(InsertAgreementCall.class);
    final UpdateAgreementCall updateAgreementCall = mock(UpdateAgreementCall.class);
    final FindInvoicingRuleCall findInvoicingRuleCall = mock(FindInvoicingRuleCall.class);
    final UpdateInvoicingRuleCall updateInvoicingRuleCall = mock(UpdateInvoicingRuleCall.class);
    final InsertInvoicingRuleCall insertInvoicingRuleCall = mock(InsertInvoicingRuleCall.class);
    final FindInvoiceRecipientsByInvoicingRuleCall findInvoiceRecipientsByInvoicingRuleCall = mock(FindInvoiceRecipientsByInvoicingRuleCall.class);
    final DeleteInvoiceRecipientCall deleteInvoiceRecipientCall = mock(DeleteInvoiceRecipientCall.class);
    final FindInvoiceRecipientCall findInvoiceRecipientCall = mock(FindInvoiceRecipientCall.class);
    final InsertInvoiceRecipientCall insertInvoiceRecipientCall = mock(InsertInvoiceRecipientCall.class);
    final InsertInvoiceRecipientsCall insertInvoiceRecipientsCall = mock(InsertInvoiceRecipientsCall.class);
    final UpdateInvoiceRecipientCall updateInvoiceRecipientCall = mock(UpdateInvoiceRecipientCall.class);
    final InsertAndUpdateOrderLinesCall insertAndUpdateOrderLinesCall = mock(InsertAndUpdateOrderLinesCall.class);
    final StartOrderLineProcessingCall startOrderLineProcessingCall = mock(StartOrderLineProcessingCall.class);

    final UpdateCommissionCall updateCommissionCall = mock(UpdateCommissionCall.class);
    final ConfirmOrderLinesCall confirmOrderLinesCall = mock(ConfirmOrderLinesCall.class);
    final ReadOrderLinesCall readOrderLinesCall = mock(ReadOrderLinesCall.class);
    final ReadReadyToInvoiceCall readReadyToInvoiceCall = mock(ReadReadyToInvoiceCall.class);
    final ConfirmReadyToInvoiceCall confirmReadyToInvoiceCall = mock(ConfirmReadyToInvoiceCall.class);
    final ReadPrepaymentForecastOrderLinesCall readPrepaymentForecastOrderLinesCall = mock(ReadPrepaymentForecastOrderLinesCall.class);
    final ConfirmPrepaymentForecastOrderLinesCall confirmPrepaymentForecastOrderLinesCall = mock(ConfirmPrepaymentForecastOrderLinesCall.class);

    final DeleteMessageCall deleteMessageCall = mock(DeleteMessageCall.class);
    final FetchMessageCall fetchMessageCall = mock(FetchMessageCall.class);
    final PutMessageCall putMessageCall = mock(PutMessageCall.class);

       //Ftp
    final DeleteInvoiceCall deleteInvoiceCall = mock(DeleteInvoiceCall.class);
    final FetchInvoiceCall fetchInvoiceCall = mock(FetchInvoiceCall.class);
    final MoveInvoiceCall moveInvoiceCall = mock(MoveInvoiceCall.class);
    final InvoiceFtpHandler invoiceFtpHandler = new InvoiceFtpHandler();


    AbstractGraphHelper() throws IllegalAccessException {
        AbstractWebServiceCall[] calls = new AbstractWebServiceCall[]{
                findInvoicingRuleCall,
                updateInvoicingRuleCall,
                insertInvoicingRuleCall,
                findInvoiceRecipientsByInvoicingRuleCall,
                deleteInvoiceRecipientCall,
                findInvoiceRecipientCall,
                insertInvoiceRecipientCall,
                insertInvoiceRecipientsCall,
                updateInvoiceRecipientCall,
                findAgreementCall,
                insertAgreementCall,
                updateAgreementCall,
                findClientCall,
                insertClientCall,
                updateClientCall,
                readClientCall,
                findBankCall,
                insertBankCall,
                updateBankCall,
                findInvoiceMessageRuleCall,
                insertInvoiceMessageRuleCall,
                updateInvoiceMessageRuleCall,
                insertAndUpdateOrderLinesCall,
                startOrderLineProcessingCall

        };

                AbstractFtpCall[] ftpCalls = new AbstractFtpCall[]{
                   deleteInvoiceCall,
                        fetchInvoiceCall,
                        moveInvoiceCall

        };
        setupCalls(calls);
        setupService(calls);
        setUpFtpCalls(ftpCalls);
    }

    private void setupCalls(AbstractWebServiceCall[] calls) {
        for (AbstractWebServiceCall call : calls) {
            when(call.getAxRequestResult()).thenReturn(AxRequestResult.ALL_IS_WELL);
        }
    }

    private void setUpFtpCalls(AbstractFtpCall[] ftpCalls) throws IllegalAccessException {
//        new ReflectionHelper(invoiceFtpHandler).setField(ftp);
    }

    private void setupService(AbstractWebServiceCall[] calls) throws IllegalAccessException {
        setupAxService(calls);

        setupPanService();


        setupCrmService();

        setupJsonValidationService();
    }

    private void setupAxService(AbstractWebServiceCall[] calls) throws IllegalAccessException {
        // Ax service mock stuff
        WebServiceCallFactory webServiceCallFactory = new MockWebServiceCallFactory(calls);

        Object[] handlers = {invoicingRuleHandler, invoiceRecipientHandler, agreementHandler,
                clientHandler, bankHandler, invoiceMessageRuleHandler, orderLineHandler};

        for (Object handler : handlers) {
            new ReflectionHelper(axService).setField(handler);

            new ReflectionHelper(handler).setField(AxConverterServiceImpl.createNonDatabaseInstanceForTest());
            new ReflectionHelper(handler).setField(webServiceCallFactory);
            new ReflectionHelper(handler).setField(new CallResultHandler());
        }
        new ReflectionHelper(axService).setField(panService);
    }

    private void setupPanService() throws IllegalAccessException {
        // Pan service mock stuff
        DatabaseCallFactory databaseCallFactory = new MockDatabaseCallFactory(
                updateCommissionCall,
                readOrderLinesCall,
                confirmOrderLinesCall,
                readPrepaymentForecastOrderLinesCall,
                confirmPrepaymentForecastOrderLinesCall,
                readReadyToInvoiceCall,
                confirmReadyToInvoiceCall);

        Object[] panHandlers = {commissionPanHandler, orderLinesPanHandler};

        for (Object panHandler : panHandlers) {
            new ReflectionHelper(panHandler).setField(databaseCallFactory);

            new ReflectionHelper(panService).setField(panHandler);
        }
        setMaxNumberOfOrderLinesTo6000();
    }

    private void setupCrmService() throws IllegalAccessException {
        // Crm service mock stuff
        AzureCallFactory azureCallFactory = new MockAzureCallFactory(deleteMessageCall,
                fetchMessageCall, putMessageCall);

        new ReflectionHelper(crmService).setField(azureCallFactory);
        new ReflectionHelper(crmService).setField(new AzureToJsonMessageTransformer());
        new ReflectionHelper(crmService).setField(new JsonToAzureMessageTransformer());
        new ReflectionHelper(crmService).setField(new UpdateForecastToJsonTransformer());
    }

    private void setMaxNumberOfOrderLinesTo6000() {
        try {
            new ReflectionHelper(orderLinesPanHandler).setField("maxNumberOfOrderLines", 9000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setupJsonValidationService() {
        try {
            when(jsonValidatorService.validateUpdatePrepaymentForecast(any(ServiceResult.class))).then(returnsFirstArg());
            when(jsonValidatorService.validateCreateInvoice(any(ServiceResult.class))).then(returnsFirstArg());
            when(jsonValidatorService.validateUpdateForecast(any(ServiceResult.class))).then(returnsFirstArg());
        } catch (BillingServiceException e) {
            e.printStackTrace();
        }
    }

    ServiceResult createServiceResult(Object domainObject) {
        IntegrationMessage integrationMessage = new IntegrationMessage("entityId", null);
        integrationMessage.setDomainObject(domainObject);

        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setIntegrationMessage(integrationMessage);
        return serviceResult;
    }


}
