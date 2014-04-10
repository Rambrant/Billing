package com.tradedoubler.billing.service.ax.webservice.call;

import com.tradedoubler.billing.service.ax.webservice.AxWebServiceSetup;
import org.tempuri.*;

/**
 * This web service call to Ax deletes an Invoice Recipient and all child nodes (addresses and splitters).
 * User: erigu
 * Date: 2012-09-05
 */
public class DeleteInvoiceRecipientCall extends AbstractWebServiceCall {

    private final AxWebServiceSetup serviceSetup;
    private final MDSITGSInvRecService servicePort;
    /* We don't use this field, but it is good for debugging */
    private MDSITGSInvRecServiceDeleteResponse response;

    public DeleteInvoiceRecipientCall(AxWebServiceSetup serviceSetup) {
        this.serviceSetup = serviceSetup;
        this.servicePort = serviceSetup.getInvoiceRecipientPort();
    }

    /**
     * Executes the call the AX-web server, for the context provided by the market (dataAreaId).
     *
     * @param invoiceRecipientId id for the Invoice Recipient to be deleted
     * @param dataAreaId         market
     */
    public void execute(String invoiceRecipientId, String dataAreaId) {

        MDSITGSInvRecServiceDeleteRequest deleteRequest = new MDSITGSInvRecServiceDeleteRequest();
        deleteRequest.setEntityKeyList(CallUtil.createEntityKeyListForOneItem("InvoiceRecipientId", invoiceRecipientId));

        try {
            response = servicePort.delete(deleteRequest, serviceSetup.getCallContext(dataAreaId));
            setCallOperationSuccess();
        } catch (MDSITGSInvRecServiceDeleteAifFaultFaultFaultMessage faultMessage) {
            analyzeAXFaultInfo(faultMessage, faultMessage.getFaultInfo(),
                    new LogInformation("InvoiceRecipient", invoiceRecipientId, dataAreaId));
        }
    }
}
