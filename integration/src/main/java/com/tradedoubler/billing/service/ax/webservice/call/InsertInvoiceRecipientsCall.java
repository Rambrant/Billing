package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvrec.*;
import com.microsoft.schemas.dynamics._2010._01.datacontracts.CallContext;
import com.tradedoubler.billing.service.ax.webservice.AxWebServiceSetup;
import org.tempuri.*;

import java.util.*;

/**
 * Executes a web service call to Ax to insert several invoice recipient belonging to the same invoicing rule.
 * The invoicing rule must exists before this call.
 * User: bjoek
 * Date: 2012-09-04
 */
public class InsertInvoiceRecipientsCall extends AbstractWebServiceCall {

    private final AxWebServiceSetup serviceSetup;
    private final MDSITGSInvRecService servicePort;
    /* We don't use this field, but it is good for debugging */
    private MDSITGSInvRecServiceCreateResponse response;

    public InsertInvoiceRecipientsCall(AxWebServiceSetup serviceSetup) {
        this.serviceSetup = serviceSetup;
        servicePort = serviceSetup.getInvoiceRecipientPort();
    }

    public void execute(Collection<AxdEntityMDSSalesInvoiceRecipient> axInvoiceRecipients, String dataAreaId) {
        MDSITGSInvRecServiceCreateRequest insertRequest = new MDSITGSInvRecServiceCreateRequest();
        AxdMDSITGSInvRec mdsitgsInvRec = new AxdMDSITGSInvRec();
        mdsitgsInvRec.getMDSSalesInvoiceRecipient().addAll(axInvoiceRecipients);
        insertRequest.setMDSITGSInvRec(mdsitgsInvRec);
        CallContext callContext = serviceSetup.getCallContext(dataAreaId);

        try {
            response = servicePort.create(insertRequest, callContext);
            setCallOperationSuccess();

        } catch (MDSITGSInvRecServiceCreateAifFaultFaultFaultMessage faultMessage) {
            analyzeAXFaultInfo(faultMessage, faultMessage.getFaultInfo(),
                    new LogInformation("InvoiceRecipients", getPrimaryKeys(axInvoiceRecipients), dataAreaId));
        }

    }

    private String getPrimaryKeys(Collection<AxdEntityMDSSalesInvoiceRecipient> axInvoiceRecipients) {
        List<String> keys = new ArrayList<String>();
        for (AxdEntityMDSSalesInvoiceRecipient axInvoiceRecipient : axInvoiceRecipients) {
            keys.add(axInvoiceRecipient.getInvoiceRecipientId());
        }
        return keys.toString();
    }
}
