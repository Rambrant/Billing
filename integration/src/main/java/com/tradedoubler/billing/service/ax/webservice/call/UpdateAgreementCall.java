package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2006._02.documents.entitykeylist.EntityKeyList;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalescla.*;
import com.tradedoubler.billing.service.ax.webservice.AxWebServiceSetup;
import org.tempuri.*;

import java.util.HashMap;

/**
 * Executes a web service call to Ax to update an Agreement. If the entity is not found, then it is classed as a bug disturbance
 * @author bjoek
 * @since 2012-06-11
 */
public class UpdateAgreementCall extends AbstractWebServiceCall {
    private final AxWebServiceSetup serviceSetup;
    private final MDSITGSalesClAService servicePort;
    /* We don't use this field, but it is good for debugging */
    private MDSITGSalesClAServiceUpdateResponse response;

    public UpdateAgreementCall(AxWebServiceSetup serviceSetup) {
        this.serviceSetup = serviceSetup;
        this.servicePort = serviceSetup.getSalesClientAgreementPort();
    }

    public void execute(AxdEntityMDSSalesClientAgreement salesClientAgreement) {
        String dataAreaId = salesClientAgreement.getBelongsToDataAreaId();

        AxdMDSITGSalesClA salesClA = new AxdMDSITGSalesClA();
        salesClA.getMDSSalesClientAgreement().add(salesClientAgreement);

        EntityKeyList entityKeyList = createUpdateEntityKeyList(salesClientAgreement.getSourceSystemAgreementId());

        MDSITGSalesClAServiceUpdateRequest updateParameters = new MDSITGSalesClAServiceUpdateRequest();
        updateParameters.setMDSITGSalesClA(salesClA);
        updateParameters.setEntityKeyList(entityKeyList);

        try {
            response = servicePort.update(updateParameters, serviceSetup.getCallContext(dataAreaId));
            setCallOperationSuccess();
        } catch (MDSITGSalesClAServiceUpdateAifFaultFaultFaultMessage faultMessage) {
            analyzeAXFaultInfo(faultMessage, faultMessage.getFaultInfo(),
                    new LogInformation("Agreement", salesClientAgreement.getSourceSystemAgreementId(), dataAreaId));
        }
    }

    private EntityKeyList createUpdateEntityKeyList(String agreementId) {
        HashMap<String, String> fieldAndValueMap = new HashMap<String, String>();
        fieldAndValueMap.put("SourceSystemAgreementId", agreementId);

        return CallUtil.createEntityKeyList(fieldAndValueMap);
    }

}
