package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvrec.*;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdTypeDateTime;
import com.microsoft.schemas.dynamics._2010._01.datacontracts.CallContext;
import com.tradedoubler.billing.service.ax.webservice.AxWebServiceSetup;
import org.tempuri.*;

import javax.xml.bind.JAXBElement;

/**
 * Executes a web service call to Ax to update an Invoice Recipient. If the entity is not found, then it is classed as a bug disturbance
 * User: erigu
 * Date: 2012-09-05
 */
public class UpdateInvoiceRecipientCall extends AbstractWebServiceCall {

    private final AxWebServiceSetup serviceSetup;
    private final MDSITGSInvRecService servicePort;
    /* We don't use this field, but it is good for debugging */
    private MDSITGSInvRecServiceUpdateResponse response;

    public UpdateInvoiceRecipientCall(AxWebServiceSetup serviceSetup) {

        this.serviceSetup = serviceSetup;
        this.servicePort = serviceSetup.getInvoiceRecipientPort();
    }

    public void execute(AxdEntityMDSSalesInvoiceRecipient axInvoiceRecipient, JAXBElement<AxdTypeDateTime> validAsOfDateTime, String dataAreaId) {
        AxdMDSITGSInvRec mdsitgsInvRec = new AxdMDSITGSInvRec();
        mdsitgsInvRec.setValidAsOfDateTime(validAsOfDateTime);
        mdsitgsInvRec.getMDSSalesInvoiceRecipient().add(axInvoiceRecipient);

        MDSITGSInvRecServiceUpdateRequest updateInvRecipientRequest = new MDSITGSInvRecServiceUpdateRequest();
        updateInvRecipientRequest.setEntityKeyList(CallUtil.createEntityKeyListForOneItem("InvoiceRecipientId", axInvoiceRecipient.getInvoiceRecipientId()));
        updateInvRecipientRequest.setMDSITGSInvRec(mdsitgsInvRec);

        CallContext callContext = serviceSetup.getCallContext(dataAreaId);

        try {
            response = servicePort.update(updateInvRecipientRequest, callContext);
            setCallOperationSuccess();
        } catch (MDSITGSInvRecServiceUpdateAifFaultFaultFaultMessage faultMessage) {
            analyzeAXFaultInfo(faultMessage, faultMessage.getFaultInfo(),
                    new LogInformation("InvoiceRecipient", axInvoiceRecipient.getInvoiceRecipientId(), dataAreaId));
        }

    }
}

