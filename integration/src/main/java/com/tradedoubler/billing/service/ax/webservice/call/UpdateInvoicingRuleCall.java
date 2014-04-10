package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2006._02.documents.entitykeylist.EntityKeyList;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalesinvr.*;
import com.microsoft.schemas.dynamics._2008._01.services.*;
import com.tradedoubler.billing.service.ax.webservice.AxWebServiceSetup;

import java.util.HashMap;

/**
 * Executes a web service call to Ax to update an Invoicing rule. If the entity is not found, then it is classed as a bug disturbance
 *
 * @author bjoek
 * @since 2012-06-11
 */
public class UpdateInvoicingRuleCall extends AbstractWebServiceCall {
    private final AxWebServiceSetup serviceSetup;
    private final MDSITGSalesInvRService servicePort;
    /* We don't use this field, but it is good for debugging */
    private MDSITGSalesInvRServiceUpdateResponse response;

    public UpdateInvoicingRuleCall(AxWebServiceSetup serviceSetup) {
        this.serviceSetup = serviceSetup;
        this.servicePort = serviceSetup.getSalesInvoiceRulePort();
    }

    public void execute(AxdEntityMDSSalesInvoiceRule salesInvoiceRule) {
        String dataAreaId = salesInvoiceRule.getBelongsToDataAreaId().getValue();
        AxdMDSITGSalesInvR salesInvR = new AxdMDSITGSalesInvR();
        salesInvR.getMDSSalesInvoiceRule().add(salesInvoiceRule);

        EntityKeyList entityKeyList = createUpdateEntityKeyList(salesInvoiceRule.getInvoiceRuleId());

        MDSITGSalesInvRServiceUpdateRequest updateParameters = new MDSITGSalesInvRServiceUpdateRequest();
        updateParameters.setMDSITGSalesInvR(salesInvR);
        updateParameters.setEntityKeyList(entityKeyList);

        try {
            response = servicePort.update(updateParameters, serviceSetup.getCallContext(dataAreaId));
            setCallOperationSuccess();
        } catch (MDSITGSalesInvRServiceUpdateAifFaultFaultFaultMessage faultMessage) {
            analyzeAXFaultInfo(faultMessage, faultMessage.getFaultInfo(),
                    new LogInformation("InvoicingRule", salesInvoiceRule.getInvoiceRuleId(), dataAreaId));
        }
    }

    private EntityKeyList createUpdateEntityKeyList(String invoiceRuleId) {
        HashMap<String, String> fieldAndValueMap = new HashMap<String, String>();
        fieldAndValueMap.put("InvoiceRuleId", invoiceRuleId);

        return CallUtil.createEntityKeyList(fieldAndValueMap);
    }

}
