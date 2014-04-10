package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvrec.AxdEntityMDSSalesInvoiceRecipient;
import com.tradedoubler.billing.domain.Guid;
import com.tradedoubler.billing.service.ax.webservice.AxWebServiceSetup;
import org.tempuri.*;

import java.util.List;

/**
 * Executes a web service call to find several Invoice recipient, by their connection to an invoicing rule, in Ax.
 * User: bjoek
 * Date: 2012-09-05
 */
public class FindInvoiceRecipientsByInvoicingRuleCall extends AbstractWebServiceCall {

    private final AxWebServiceSetup serviceSetup;
    private final MDSITGSInvRecService servicePort;
    private MDSITGSInvRecServiceFindResponse response;

    public FindInvoiceRecipientsByInvoicingRuleCall(AxWebServiceSetup serviceSetup) {
        this.serviceSetup = serviceSetup;
        this.servicePort = serviceSetup.getInvoiceRecipientPort();
    }

    public void execute(Guid invoicingRuleId, String dataAreaId) {
        MDSITGSInvRecServiceFindRequest findRequest = new MDSITGSInvRecServiceFindRequest();
        findRequest.setQueryCriteria(CallUtil.createQueryCriteria("MDS_SalesInvoiceRecipient", "InvoiceRuleId",
                invoicingRuleId.getGuidForAx()));

        try {
            response = servicePort.find(findRequest, serviceSetup.getCallContext(dataAreaId));
            setCallOperationSuccess();
        } catch (MDSITGSInvRecServiceFindAifFaultFaultFaultMessage faultMessage) {
            analyzeAXFaultInfo(faultMessage, faultMessage.getFaultInfo(),
                    new LogInformation("Multiple InvoiceRecipients", "InvoicingRuleId: " + invoicingRuleId, dataAreaId));
        }
    }

    public List<AxdEntityMDSSalesInvoiceRecipient> getInvoiceRecipients() {
        return response.getMDSITGSInvRec().getMDSSalesInvoiceRecipient();
    }

    public int getNumberOfInvoiceRecipient() {
        return getInvoiceRecipients().size();
    }

}
