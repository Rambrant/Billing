package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgcustbank.*;
import com.tradedoubler.billing.service.ax.webservice.AxWebServiceSetup;
import org.tempuri.*;

/**
 * Executes a web service call to Ax to insert a bank for a customer. The customer must exist before.
 * User: erigu
 * Date: 2012-06-25
 */
public class InsertBankCall extends AbstractWebServiceCall {

    private final AxWebServiceSetup serviceSetup;
    private final MDSITGCustBankService servicePort;
    /* We don't use this field, but it is good for debugging */
    private MDSITGCustBankServiceCreateResponse response;

    public InsertBankCall(AxWebServiceSetup serviceSetup) {
        this.serviceSetup = serviceSetup;
        servicePort = serviceSetup.getCustomerBankServicePort();
    }

    public void execute(AxdEntityCustBankAccount custBankAccount, String dataAreaId) {
        AxdMDSITGCustBank custBank = new AxdMDSITGCustBank();
        custBank.getCustBankAccount().add(custBankAccount);

        MDSITGCustBankServiceCreateRequest createParams = new MDSITGCustBankServiceCreateRequest();
        createParams.setMDSITGCustBank(custBank);

        try {
            response = servicePort.create(createParams, serviceSetup.getCallContext(dataAreaId));
            setCallOperationSuccess();
        } catch (MDSITGCustBankServiceCreateAifFaultFaultFaultMessage faultMessage) {
            analyzeAXFaultInfo(faultMessage, faultMessage.getFaultInfo(),
                    new LogInformation("Bank", "bankAccount: " + custBankAccount.getAccountID() +
                            " customerAccount: " + custBankAccount.getCustAccount(), dataAreaId));
        }
    }
}
