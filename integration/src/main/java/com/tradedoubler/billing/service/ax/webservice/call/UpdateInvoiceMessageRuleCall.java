package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2006._02.documents.entitykeylist.EntityKeyList;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvmes.*;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvmes.ObjectFactory;
import com.microsoft.schemas.dynamics._2010._01.datacontracts.CallContext;
import com.tradedoubler.billing.service.ax.webservice.AxWebServiceSetup;
import org.tempuri.*;

/**
 * Executes a web service call to Ax to update an invoice message. This is for messages for a Client or Market, messages
 * for Invoicing rules are integrated into the Invoicing rule integration.
 * If the entity is not found, then it is classed as a bug disturbance
 * User: erigu
 * Date: 2012-09-10
 */
public class UpdateInvoiceMessageRuleCall extends AbstractWebServiceCall {

    private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();
    private final AxWebServiceSetup serviceSetup;
    private final MDSITGSInvMesService servicePort;
    /* We don't use this field, but it is good for debugging */
    private MDSITGSInvMesServiceUpdateResponse response;

    public UpdateInvoiceMessageRuleCall(AxWebServiceSetup serviceSetup) {
        this.serviceSetup = serviceSetup;
        servicePort = serviceSetup.getSalesInvMessagePort();
    }


    public void execute(AxdEntityMDSSalesInvoiceMessage salesInvoiceMessage, String parentPrimaryKey, String dataAreaId) {

        MDSITGSInvMesServiceUpdateRequest invMessageUpdateRequest = new MDSITGSInvMesServiceUpdateRequest();
        EntityKeyList entityKeyList = CallUtil.createEntityKeyListForOneItem("InvoiceMessageId", salesInvoiceMessage.getInvoiceMessageId());

        invMessageUpdateRequest.setEntityKeyList(entityKeyList);
        AxdMDSITGSInvMes axSInvMes = new AxdMDSITGSInvMes();
        axSInvMes.setKeyId(OBJECT_FACTORY.createAxdMDSITGSInvMesKeyId(parentPrimaryKey));
        axSInvMes.getMDSSalesInvoiceMessage().add(salesInvoiceMessage);
        invMessageUpdateRequest.setMDSITGSInvMes(axSInvMes);

        CallContext callContext = serviceSetup.getCallContext(dataAreaId);

        try {
            response = servicePort.update(invMessageUpdateRequest, callContext);
            setCallOperationSuccess();
        } catch (MDSITGSInvMesServiceUpdateAifFaultFaultFaultMessage faultMessage) {
            analyzeAXFaultInfo(faultMessage, faultMessage.getFaultInfo(),
                    new LogInformation("InvoiceMessageRule", "invoiceMessageRuleId: " + salesInvoiceMessage.getInvoiceMessageId() +
                            " parentPrimaryKey: " + parentPrimaryKey, dataAreaId));
        }
    }
}
