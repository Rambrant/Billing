package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvmes.AxdEntityMDSSalesInvoiceMessage;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumMDSSalesMessageSourceType;
import com.tradedoubler.billing.service.ax.webservice.AxWebServiceSetup;
import org.tempuri.*;

import javax.xml.bind.JAXBElement;
import java.util.List;

/**
 * Executes a web service call to find an invoice message in Ax. This is for messages for a Client or Market, messages
 * for Invoicing rules are integrated into the Invoicing rule integration.
 * User: bjoek
 * Date: 2012-09-10
 */
public class FindInvoiceMessageRuleCall extends AbstractWebServiceCall {
    private final AxWebServiceSetup serviceSetup;
    private final MDSITGSInvMesService servicePort;
    private MDSITGSInvMesServiceFindResponse response;

    public FindInvoiceMessageRuleCall(AxWebServiceSetup serviceSetup) {
        this.serviceSetup = serviceSetup;
        this.servicePort = serviceSetup.getSalesInvMessagePort();
    }

    public void execute(String invoiceMessageRuleId, String dataAreaId) {
        MDSITGSInvMesServiceFindRequest findRequest = createFindRequest(invoiceMessageRuleId);

        try {
            response = servicePort.find(findRequest, serviceSetup.getCallContext(dataAreaId));
            setCallOperationSuccess();
        } catch (MDSITGSInvMesServiceFindAifFaultFaultFaultMessage faultMessage) {
            analyzeAXFaultInfo(faultMessage, faultMessage.getFaultInfo(),
                    new LogInformation("InvoiceMessageRule", invoiceMessageRuleId, dataAreaId));
        }

    }

    private MDSITGSInvMesServiceFindRequest createFindRequest(String invoiceMessageId) {
        MDSITGSInvMesServiceFindRequest findRequest = new MDSITGSInvMesServiceFindRequest();
        findRequest.setQueryCriteria(CallUtil.createQueryCriteria("MDS_SalesInvoiceMessage", "InvoiceMessageId", invoiceMessageId));
        return findRequest;
    }

    public JAXBElement<String> getDocumentHash() {
        return getAxInvMessage().getDocumentHash();

    }

    public AxdEnumMDSSalesMessageSourceType getSourceType() {
        return getAxInvMessage().getSourceType();
    }

    private AxdEntityMDSSalesInvoiceMessage getAxInvMessage() {
        return getInvoiceMessageList().get(0);
    }

    public int getNumberOfInvoiceMessageRules() {
        return getInvoiceMessageList().size();
    }

    public List<AxdEntityMDSSalesInvoiceMessage> getInvoiceMessageList() {
        return response.getMDSITGSInvMes().getMDSSalesInvoiceMessage();
    }

}
