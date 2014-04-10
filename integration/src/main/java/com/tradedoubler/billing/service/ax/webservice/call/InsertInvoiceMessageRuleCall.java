package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvmes.*;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvmes.ObjectFactory;
import com.microsoft.schemas.dynamics._2010._01.datacontracts.CallContext;
import com.tradedoubler.billing.service.ax.webservice.AxWebServiceSetup;
import org.tempuri.*;

/**
 * Executes a web service call to Ax to insert an invoice message.
 * If the invoice message belongs to an invoice issuer then marketId is used as parent key.
 * If the invoice message belongs to a client then clientId is used as parent key.
 * If the invoice message belongs to an invoicing rule then the Invoicing rule integration must be used instead.
 * User: erigu
 * Date: 2012-09-10
 */
public class InsertInvoiceMessageRuleCall extends AbstractWebServiceCall {


    private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();
    private final AxWebServiceSetup serviceSetup;
    private final MDSITGSInvMesService servicePort;
    /* We don't use this field, but it is good for debugging */
    private MDSITGSInvMesServiceCreateResponse response;

    public InsertInvoiceMessageRuleCall(AxWebServiceSetup serviceSetup) {
        this.serviceSetup = serviceSetup;
        this.servicePort = serviceSetup.getSalesInvMessagePort();
    }

    public void execute(AxdEntityMDSSalesInvoiceMessage salesInvoiceMessage, String parentPrimaryKey, String dataAreaId) {


        MDSITGSInvMesServiceCreateRequest request = new MDSITGSInvMesServiceCreateRequest();
        AxdMDSITGSInvMes axInvMess = OBJECT_FACTORY.createAxdMDSITGSInvMes();
        axInvMess.getMDSSalesInvoiceMessage().add(salesInvoiceMessage);
        axInvMess.setKeyId(OBJECT_FACTORY.createAxdMDSITGSInvMesKeyId(parentPrimaryKey));
        request.setMDSITGSInvMes(axInvMess);
        CallContext callContext = serviceSetup.getCallContext(dataAreaId);


        try {
            response = servicePort.create(request, callContext);
            setCallOperationSuccess();

        } catch (MDSITGSInvMesServiceCreateAifFaultFaultFaultMessage faultMessage) {
            analyzeAXFaultInfo(faultMessage, faultMessage.getFaultInfo(),
                    new LogInformation("InvoiceMessageRule", "invoiceMessageRuleId: " + salesInvoiceMessage.getInvoiceMessageId() +
                            " parentPrimaryKey: " + parentPrimaryKey, dataAreaId));
        }


    }
}
