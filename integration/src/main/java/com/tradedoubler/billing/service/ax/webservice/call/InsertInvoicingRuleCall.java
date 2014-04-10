package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalesinvr.*;
import com.microsoft.schemas.dynamics._2008._01.services.*;
import com.tradedoubler.billing.service.ax.webservice.AxWebServiceSetup;

/**
 * Executes a web service call to Ax to insert an invoice rule.
 *
 * @author bjoek
 * @since 2012-06-11
 */
public class InsertInvoicingRuleCall extends AbstractWebServiceCall {
    private final AxWebServiceSetup serviceSetup;
    private final MDSITGSalesInvRService servicePort;
    /* We don't use this field, but it is good for debugging */
    private MDSITGSalesInvRServiceCreateResponse response;

    public InsertInvoicingRuleCall(AxWebServiceSetup serviceSetup) {
        this.serviceSetup = serviceSetup;
        this.servicePort = serviceSetup.getSalesInvoiceRulePort();
    }


    public void execute(AxdEntityMDSSalesInvoiceRule salesInvoiceRule) {
        String dataAreaId = salesInvoiceRule.getBelongsToDataAreaId().getValue();
        AxdMDSITGSalesInvR salesInvR = new AxdMDSITGSalesInvR();
        salesInvR.getMDSSalesInvoiceRule().add(salesInvoiceRule);

        MDSITGSalesInvRServiceCreateRequest createParams = new MDSITGSalesInvRServiceCreateRequest();
        createParams.setMDSITGSalesInvR(salesInvR);

        try {
            response = servicePort.create(createParams, serviceSetup.getCallContext(dataAreaId));
            setCallOperationSuccess();
        } catch (MDSITGSalesInvRServiceCreateAifFaultFaultFaultMessage faultMessage) {
            analyzeAXFaultInfo(faultMessage, faultMessage.getFaultInfo(),
                    new LogInformation("InvoicingRule", salesInvoiceRule.getInvoiceRuleId(), dataAreaId));
        }

    }
}
