package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalesinvr.AxdEntityMDSSalesInvoiceRule;
import com.microsoft.schemas.dynamics._2008._01.services.*;
import com.tradedoubler.billing.domain.Guid;
import com.tradedoubler.billing.service.ax.webservice.AxWebServiceSetup;

/**
 * Executes a web service call to Ax to find an Invoicing rule.
 *
 * @author bjoek
 * @since 2012-06-11
 */
public class FindInvoicingRuleCall extends AbstractWebServiceCall {
    private final AxWebServiceSetup serviceSetup;
    private final MDSITGSalesInvRService servicePort;
    private MDSITGSalesInvRServiceFindResponse response;

    public FindInvoicingRuleCall(AxWebServiceSetup serviceSetup) {
        this.serviceSetup = serviceSetup;
        this.servicePort = serviceSetup.getSalesInvoiceRulePort();
    }

    public void execute(Guid invoiceRuleId, String dataAreaId) {
        MDSITGSalesInvRServiceFindRequest findRequest = new MDSITGSalesInvRServiceFindRequest();
        findRequest.setQueryCriteria(CallUtil.createQueryCriteria("MDS_SalesInvoiceRule", "InvoiceRuleId", invoiceRuleId.getGuidForAx()));

        try {
            response = servicePort.find(findRequest, serviceSetup.getCallContext(dataAreaId));
            setCallOperationSuccess();
        } catch (MDSITGSalesInvRServiceFindAifFaultFaultFaultMessage faultMessage) {
            analyzeAXFaultInfo(faultMessage, faultMessage.getFaultInfo(),
                    new LogInformation("InvoicingRule", invoiceRuleId.getGuidForAx(), dataAreaId));
        }
    }

    public AxdEntityMDSSalesInvoiceRule getInvoiceRule() {
        return response.getMDSITGSalesInvR().getMDSSalesInvoiceRule().get(0);
    }

    public String getDocumentHash() {
        return getInvoiceRule().getDocumentHash().getValue();
    }

    public int getNumberOfInvoicingRules() {
        return response.getMDSITGSalesInvR().getMDSSalesInvoiceRule().size();
    }
}
