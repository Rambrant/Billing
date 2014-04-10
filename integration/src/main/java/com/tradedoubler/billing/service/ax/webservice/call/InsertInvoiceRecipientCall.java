package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvrec.*;
import com.microsoft.schemas.dynamics._2010._01.datacontracts.CallContext;
import com.tradedoubler.billing.service.ax.webservice.AxWebServiceSetup;
import org.tempuri.*;

/**
 * Executes a web service call to Ax to insert an invoice recipient. An invoicing rule must exists before this call.
 * User: erigu
 * Date: 2012-09-04
 */
public class InsertInvoiceRecipientCall extends AbstractWebServiceCall {

    private final AxWebServiceSetup serviceSetup;
    private final MDSITGSInvRecService servicePort;
    /* We don't use this field, but it is good for debugging */
    private MDSITGSInvRecServiceCreateResponse response;

    public InsertInvoiceRecipientCall(AxWebServiceSetup serviceSetup) {
        this.serviceSetup = serviceSetup;
        servicePort = serviceSetup.getInvoiceRecipientPort();
    }

    public void execute(AxdEntityMDSSalesInvoiceRecipient axInvoiceRecipient, String dataAreaId) {
        MDSITGSInvRecServiceCreateRequest insertRequest = new MDSITGSInvRecServiceCreateRequest();
        AxdMDSITGSInvRec mdsitgsInvRec = new AxdMDSITGSInvRec();
        mdsitgsInvRec.getMDSSalesInvoiceRecipient().add(axInvoiceRecipient);
        insertRequest.setMDSITGSInvRec(mdsitgsInvRec);
        CallContext callContext = serviceSetup.getCallContext(dataAreaId);

        try {
            response = servicePort.create(insertRequest, callContext);
            setCallOperationSuccess();

        } catch (MDSITGSInvRecServiceCreateAifFaultFaultFaultMessage faultMessage) {
            analyzeAXFaultInfo(faultMessage, faultMessage.getFaultInfo(),
                    new LogInformation("InvoiceRecipient", axInvoiceRecipient.getInvoiceRecipientId(), dataAreaId));
        }


    }
}
