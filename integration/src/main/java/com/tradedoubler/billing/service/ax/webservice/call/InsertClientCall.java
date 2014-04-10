package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2008._01.documents.customer.AxdCustomer;
import com.microsoft.schemas.dynamics._2008._01.services.*;
import com.microsoft.schemas.dynamics._2010._01.datacontracts.CallContext;
import com.tradedoubler.billing.service.ax.webservice.AxWebServiceSetup;

/**
 * Executes a web service call to Ax to insert a customer
 * User: erigu
 * Date: 2012-08-13
 */
public class InsertClientCall extends AbstractWebServiceCall {

    private final AxWebServiceSetup serviceSetup;
    private final CustomerService servicePort;
    /* We don't use this field, but it is good for debugging */
    private CustomerServiceCreateResponse response;

    public InsertClientCall(AxWebServiceSetup serviceSetup) {

        this.serviceSetup = serviceSetup;
        servicePort = serviceSetup.getCustomerPort();
    }

    /**
     * Executes the call the AX-web server, for the context provided by the market (dataAreaId)
     *
     * @param axCustomer the client to insert
     * @param dataAreaId the market for the context
     */
    public void execute(AxdCustomer axCustomer, String dataAreaId) {

        CustomerServiceCreateRequest customerServiceCreateRequest = new CustomerServiceCreateRequest();
        customerServiceCreateRequest.setCustomer(axCustomer);

        CallContext callContext = serviceSetup.getCallContext(dataAreaId);

        try {
            response = servicePort.create(customerServiceCreateRequest, callContext);
            setCallOperationSuccess();

        } catch (CustomerServiceCreateAifFaultFaultFaultMessage faultMessage) {
            analyzeAXFaultInfo(faultMessage, faultMessage.getFaultInfo(),
                    new LogInformation("Client", axCustomer.getCustTable().get(0).getAccountNum().getValue(), dataAreaId));
        }
    }

}

