package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2006._02.documents.entitykeylist.EntityKeyList;
import com.microsoft.schemas.dynamics._2008._01.documents.customer.AxdCustomer;
import com.microsoft.schemas.dynamics._2008._01.services.*;
import com.microsoft.schemas.dynamics._2010._01.datacontracts.CallContext;
import com.tradedoubler.billing.service.ax.webservice.AxWebServiceSetup;

import java.util.HashMap;

/**
 * Executes a web service call to Ax to update a client. If the entity is not found, then it is classed as a bug disturbance
 * User: erigu
 * Date: 2012-08-17
 */
public class UpdateClientCall extends AbstractWebServiceCall {
    private final AxWebServiceSetup serviceSetup;
    private final CustomerService servicePort;
    /* We don't use this field, but it is good for debugging */
    private CustomerServiceUpdateResponse response;

    public UpdateClientCall(AxWebServiceSetup serviceSetup) {
        this.serviceSetup = serviceSetup;
        servicePort = serviceSetup.getCustomerPort();
    }

    public void execute(String accountNum, AxdCustomer axCustomer, String dataAreaId) {

        CustomerServiceUpdateRequest updateCustomerRequest = new CustomerServiceUpdateRequest();

        updateCustomerRequest.setCustomer(axCustomer);
        EntityKeyList entityKeyList = createUpdateEntityKeyList(accountNum);
        updateCustomerRequest.setEntityKeyList(entityKeyList);

        CallContext callContext = serviceSetup.getCallContext(dataAreaId);

        try {
            response = servicePort.update(updateCustomerRequest, callContext);
            setCallOperationSuccess();
        } catch (CustomerServiceUpdateAifFaultFaultFaultMessage faultMessage) {
            analyzeAXFaultInfo(faultMessage, faultMessage.getFaultInfo(),
                    new LogInformation("Client", accountNum, dataAreaId));
        }
    }

    private EntityKeyList createUpdateEntityKeyList(String accountNum) {
        HashMap<String, String> fieldAndValueMap = new HashMap<String, String>();
        fieldAndValueMap.put("AccountNum", accountNum);

        return CallUtil.createEntityKeyList(fieldAndValueMap);
    }

}

