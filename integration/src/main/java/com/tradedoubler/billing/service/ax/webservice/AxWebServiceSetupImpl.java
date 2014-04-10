package com.tradedoubler.billing.service.ax.webservice;

import com.microsoft.schemas.dynamics._2008._01.services.*;
import com.microsoft.schemas.dynamics._2010._01.datacontracts.*;
import com.microsoft.schemas.dynamics._2010._01.datacontracts.ObjectFactory;
import com.tradedoubler.billing.service.ParameterUtil;
import com.tradedoubler.billing.service.ax.webservice.routingservice.*;
import mds_salesorderbasisline.SalesOrderBasisLineProcessing;
import org.apache.cxf.binding.soap.saaj.SAAJOutInterceptor;
import org.apache.cxf.common.logging.LogUtils;
import org.apache.cxf.configuration.security.AuthorizationPolicy;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.*;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.http.HTTPConduit;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.tempuri.*;

import javax.annotation.PostConstruct;
import java.net.*;

/**
 * Sets up the necessary ports and context for all web-services provided by the AX system.
 *
 * @author bjoek
 * @since 2012-06-11
 */
@Component
public class AxWebServiceSetupImpl implements AxWebServiceSetup {
    private static final String WEBSERVICE_CONTEXT_LANGUAGE = "en-US";

    private final static Logger log = LoggerFactory.getLogger(AxWebServiceSetupImpl.class);

    private final ObjectFactory headerObjectFactory = new ObjectFactory();

    private boolean initialized = false;

    private MDSITGSalesInvRService salesInvoiceRulePort;
    private MDSITGSalesClAService salesClientAgreementPort;
    private CustomerService customerServicePort;
    private MDSITGCustBankService customerBankServicePort;
    private MDSITGSInvRecService invoiceRecipientPort;
    private MDSITGSInvMesService invoiceSalesMessagePort;
    private MDSSalesOrderBasisLineService orderBasisLinePort;
    private SalesOrderBasisLineProcessing orderBasisLineProcessingPort;

    @Value("${WEBSERVICE_USER_NAME}")
    private String userName;

    @Value("${WEBSERVICE_PASSWORD}")
    private String password;

    @Value("${WEBSERVICE_SalesInvRService_WSDL_LOCATION}")
    private String salesInvRServiceWsdlLocation;

    @Value("${WEBSERVICE_SalesClientAgreementService_WSDL_LOCATION}")
    private String salesClientAgreementServiceWsdlLocation;

    @Value("${WEBSERVICE_CustomerService_WSDL_LOCATION}")
    private String customerServiceWsdlLocation;

    @Value("${WEBSERVICE_CustomerBankService_WSDL_LOCATION}")
    private String customerBankServiceWsdlLocation;

    @Value("${WEBSERVICE_InvoiceRecipient_WSDL_LOCATION}")
    private String invoiceRecipientWsdlLocation;

    @Value("${WEBSERVICE_InvoiceSalesMessage_WSDL_LOCATION}")
    private String invoiceSalesMessageWsdlLocation;

    @Value("${WEBSERVICE_OrderBasisLinePort_WSDL_LOCATION}")
    private String orderBasisLinePortWsdlLocation;

    @Value("${WEBSERVICE_OrderBasisLineProcessing_WSDL_LOCATION}")
    private String orderBasisLineProcessingPortWsdlLocation;


    @PostConstruct
    private void setup() {
        log.debug("Check all parameters that are populated from properties");
        ParameterUtil.checkParameter(userName);
        ParameterUtil.checkParameter(password);
        ParameterUtil.checkParameter(salesInvRServiceWsdlLocation);
        ParameterUtil.checkParameter(salesClientAgreementServiceWsdlLocation);
        ParameterUtil.checkParameter(customerServiceWsdlLocation);
        ParameterUtil.checkParameter(customerBankServiceWsdlLocation);
        ParameterUtil.checkParameter(invoiceRecipientWsdlLocation);
        ParameterUtil.checkParameter(invoiceSalesMessageWsdlLocation);
        ParameterUtil.checkParameter(orderBasisLinePortWsdlLocation);
        ParameterUtil.checkParameter(orderBasisLineProcessingPortWsdlLocation);
    }

    /**
     * Each web service call needs a call context that contains standard information such as
     * market (aka dataAreaId in Ax),
     * userName (common user for all web service calls)
     * language (must always be en-US so that error messages are in english)
     */
    @Override
    public CallContext getCallContext(String dataAreaId) {
        CallContext callContext = new CallContext();
        callContext.setCompany(headerObjectFactory.createCallContextCompany(dataAreaId));
        callContext.setLogonAsUser(headerObjectFactory.createCallContextLogonAsUser(userName));
        callContext.setLanguage(headerObjectFactory.createCallContextLanguage(WEBSERVICE_CONTEXT_LANGUAGE));
        return callContext;
    }

    /** Get initialized web service port */
    @Override
    public synchronized MDSITGSalesInvRService getSalesInvoiceRulePort() {
        if (!initialized) {
            initializeAllPorts();
        }
        return salesInvoiceRulePort;
    }

    /** Get initialized web service port */
    @Override
    public synchronized MDSITGSalesClAService getSalesClientAgreementPort() {
        if (!initialized) {
            initializeAllPorts();
        }
        return salesClientAgreementPort;
    }

    /** Get initialized web service port */
    @Override
    public synchronized CustomerService getCustomerPort() {
        if (!initialized) {
            initializeAllPorts();
        }
        return customerServicePort;
    }

    /** Get initialized web service port */
    @Override
    public synchronized MDSITGCustBankService getCustomerBankServicePort() {
        if (!initialized) {
            initializeAllPorts();
        }
        return customerBankServicePort;
    }

    /** Get initialized web service port */
    @Override
    public synchronized MDSITGSInvRecService getInvoiceRecipientPort() {
        if (!initialized) {
            initializeAllPorts();
        }
        return invoiceRecipientPort;
    }

    /** Get initialized web service port */
    @Override
    public synchronized MDSITGSInvMesService getSalesInvMessagePort() {
        if (!initialized) {
            initializeAllPorts();
        }
        return invoiceSalesMessagePort;
    }

    /** Get initialized web service port */
    @Override
    public synchronized MDSSalesOrderBasisLineService getOrderBasisLinePort() {
        if (!initialized) {
            initializeAllPorts();
        }
        return orderBasisLinePort;
    }

    /** Get initialized web service port */
    @Override
    public synchronized SalesOrderBasisLineProcessing getOrderBasisLineProcessingPort() {
        if (!initialized) {
            initializeAllPorts();
        }
        return orderBasisLineProcessingPort;
    }

    private void initializeAllPorts() {
        log.info("Start to initialize all ports for userName " + userName);

        URL wsdlURL = getUrl(salesInvRServiceWsdlLocation);
        AxSalesInvRService salesInvRService = new AxSalesInvRService(wsdlURL);
        this.salesInvoiceRulePort = addAuthorizationToPort(salesInvRService.getBasicHttpBindingMDSITGSalesInvRService());

        AxSalesClientAgreementService salesClientAgreementService = new AxSalesClientAgreementService(getUrl(salesClientAgreementServiceWsdlLocation));
        this.salesClientAgreementPort = addAuthorizationToPort(salesClientAgreementService.getBasicHttpBindingMDSITGSalesClAService());

        AxCustomerService customerService = new AxCustomerService(getUrl(customerServiceWsdlLocation));
        this.customerServicePort = addAuthorizationToPort(customerService.getBasicHttpBindingCustomerService());
        addPatchInterceptorForCustomer();

        AxCustomerBankService customerBankService = new AxCustomerBankService(getUrl(customerBankServiceWsdlLocation));
        this.customerBankServicePort = addAuthorizationToPort(customerBankService.getBasicHttpBindingMDSITGCustBankService());

        AxInvRecipientService invoiceRecService = new AxInvRecipientService(getUrl(invoiceRecipientWsdlLocation));
        this.invoiceRecipientPort = addAuthorizationToPort(invoiceRecService.getBasicHttpBindingMDSITGSInvRecService());

        AxInvMessageService axInvMessageService = new AxInvMessageService(getUrl(invoiceSalesMessageWsdlLocation));
        this.invoiceSalesMessagePort = addAuthorizationToPort(axInvMessageService.getBasicHttpBindingMDSITGSInvMesService());

        AxOrderLineService orderLineService = new AxOrderLineService(getUrl(orderBasisLinePortWsdlLocation));
        this.orderBasisLinePort = addAuthorizationToPort(orderLineService.getBasicHttpBindingMDSSalesOrderBasisLineService());

        AxScheduleOrderLineService orderLineScheduleService = new AxScheduleOrderLineService(getUrl(orderBasisLineProcessingPortWsdlLocation));
        this.orderBasisLineProcessingPort = addAuthorizationToPort(orderLineScheduleService.getBasicHttpBindingSalesOrderBasisLineProcessing());

        log.info("Finished initializing all ports for userName " + userName);
        initialized = true;
    }

    /** Adds patch. See documentation for the Interceptor class used. */
    private void addPatchInterceptorForCustomer() {
        Client client = ClientProxy.getClient(this.customerServicePort);
        client.getOutInterceptors().add(new SAAJOutInterceptor());
        client.getOutInterceptors().add(new CustomerDirPartyInterceptor());
    }


    private URL getUrl(String wsdlLocation) {
        try {
            return new URL(wsdlLocation);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private <T> T addAuthorizationToPort(T port) {
        LogUtils.setLoggerClass(org.apache.cxf.common.logging.Log4jLogger.class);

        Client client = ClientProxy.getClient(port);
        HTTPConduit http = (HTTPConduit) client.getConduit();
        AuthorizationPolicy policy = new AuthorizationPolicy();
        policy.setUserName(userName);
        policy.setPassword(password);
        http.setAuthorization(policy);
        client.getOutInterceptors().add(new SAAJOutInterceptor());
        client.getOutInterceptors().add(new CustomerDirPartyInterceptor());

        client.getInInterceptors().add(new LoggingInInterceptor());
        client.getOutInterceptors().add(new LoggingOutInterceptor(Phase.SEND));
        return port;
    }

}
