package com.tradedoubler.billing.service.ax.webservice;

import com.microsoft.schemas.dynamics._2008._01.services.*;
import com.microsoft.schemas.dynamics._2010._01.datacontracts.CallContext;
import mds_salesorderbasisline.SalesOrderBasisLineProcessing;
import org.tempuri.*;

/**
 * Sets up the necessary ports and context for all web-services provided by the AX system.
 * 
 * @author bjoek
 * @since 2012-06-20
 */
public interface AxWebServiceSetup {
    CallContext getCallContext(String dataAreaId);

    MDSITGSalesInvRService getSalesInvoiceRulePort();

    MDSITGSalesClAService getSalesClientAgreementPort();

    CustomerService getCustomerPort();

    MDSITGCustBankService getCustomerBankServicePort();

    MDSITGSInvRecService getInvoiceRecipientPort();

    MDSITGSInvMesService getSalesInvMessagePort();

    MDSSalesOrderBasisLineService getOrderBasisLinePort();

    SalesOrderBasisLineProcessing getOrderBasisLineProcessingPort();
}
