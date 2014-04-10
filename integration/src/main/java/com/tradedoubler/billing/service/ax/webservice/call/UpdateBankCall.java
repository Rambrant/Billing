package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2006._02.documents.entitykeylist.EntityKeyList;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgcustbank.*;
import com.microsoft.schemas.dynamics._2010._01.datacontracts.CallContext;
import com.tradedoubler.billing.service.ax.webservice.AxWebServiceSetup;
import org.tempuri.*;

import java.util.HashMap;

/**
 * Executes a web service call to Ax to update a clients Bank. If the entity is not found, then it is classed as a bug disturbance
 *
 * @author bjoek
 * @since 2012-06-11
 */
public class UpdateBankCall extends AbstractWebServiceCall {
    private final AxWebServiceSetup serviceSetup;
    private final MDSITGCustBankService servicePort;
    /* We don't use this field, but it is good for debugging */
    private MDSITGCustBankServiceUpdateResponse response;

    public UpdateBankCall(AxWebServiceSetup serviceSetup) {
        this.serviceSetup = serviceSetup;
        this.servicePort = serviceSetup.getCustomerBankServicePort();
    }

    public void execute(AxdEntityCustBankAccount custBankAccount, String dataAreaId) {
        AxdMDSITGCustBank custBank = new AxdMDSITGCustBank();
        custBank.getCustBankAccount().add(custBankAccount);

        EntityKeyList entityKeyList = createUpdateEntityKeyList(custBankAccount);

        MDSITGCustBankServiceUpdateRequest updateParameters = new MDSITGCustBankServiceUpdateRequest();
        updateParameters.setMDSITGCustBank(custBank);
        updateParameters.setEntityKeyList(entityKeyList);

        CallContext callContext = serviceSetup.getCallContext(dataAreaId);
        try {
            response = servicePort.update(updateParameters, callContext);
            setCallOperationSuccess();
        } catch (MDSITGCustBankServiceUpdateAifFaultFaultFaultMessage faultMessage) {
            analyzeAXFaultInfo(faultMessage, faultMessage.getFaultInfo(),
                    new LogInformation("Bank", "bankAccount: " + custBankAccount.getAccountID() +
                            " customerAccount: " + custBankAccount.getCustAccount(), dataAreaId));
        }
    }

    private EntityKeyList createUpdateEntityKeyList(AxdEntityCustBankAccount custBankAccount) {
        HashMap<String, String> fieldAndValueMap = new HashMap<String, String>();
        fieldAndValueMap.put("AccountID", custBankAccount.getAccountID());
        fieldAndValueMap.put("CustAccount", custBankAccount.getCustAccount());

        return CallUtil.createEntityKeyList(fieldAndValueMap);
    }

}
