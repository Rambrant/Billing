package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalescla.*;
import com.tradedoubler.billing.service.ax.webservice.AxWebServiceSetup;
import org.tempuri.*;

/**
 * Executes a web service call to Ax to insert an agreement. Both client and invoicing rule must exist before this call.
 * Date: 2012-06-25
 */
public class InsertAgreementCall extends AbstractWebServiceCall {

    private final AxWebServiceSetup serviceSetup;
    private final MDSITGSalesClAService servicePort;
    /* We don't use this field, but it is good for debugging */
    private MDSITGSalesClAServiceCreateResponse response;

    public InsertAgreementCall(AxWebServiceSetup serviceSetup) {
        this.serviceSetup = serviceSetup;
        servicePort = serviceSetup.getSalesClientAgreementPort();
    }

    public void execute(AxdEntityMDSSalesClientAgreement agreement) {
        String dataAreaId = agreement.getBelongsToDataAreaId();
        AxdMDSITGSalesClA salesClA = new AxdMDSITGSalesClA();
        salesClA.getMDSSalesClientAgreement().add(agreement);

        MDSITGSalesClAServiceCreateRequest createParams = new MDSITGSalesClAServiceCreateRequest();
        createParams.setMDSITGSalesClA(salesClA);

        try {
            response = servicePort.create(createParams, serviceSetup.getCallContext(dataAreaId));
            setCallOperationSuccess();
        } catch (MDSITGSalesClAServiceCreateAifFaultFaultFaultMessage faultMessage) {
            analyzeAXFaultInfo(faultMessage, faultMessage.getFaultInfo(),
                    new LogInformation("Agreement", agreement.getSourceSystemAgreementId(), dataAreaId));
        }
    }

}

