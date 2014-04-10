package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2008._01.documents.customer.AxdEntityCustTable;
import com.microsoft.schemas.dynamics._2008._01.services.*;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdTypeDateTime;
import com.tradedoubler.billing.service.ax.webservice.AxWebServiceSetup;

import javax.xml.bind.JAXBElement;

/**
 * Executes a web service call to Ax to find a Client.
 * User: erigu
 * Date: 2012-08-17
 */
public class FindClientCall extends AbstractWebServiceCall {
    private final AxWebServiceSetup serviceSetup;
    private final CustomerService servicePort;
    private CustomerServiceFindResponse response;

    public FindClientCall(AxWebServiceSetup serviceSetup) {
        this.serviceSetup = serviceSetup;
        this.servicePort = serviceSetup.getCustomerPort();
    }

    public void execute(String accountNum, String dataAreaId) {
        CustomerServiceFindRequest findRequest = createFindRequest(accountNum);
        try {
            response = servicePort.find(findRequest, serviceSetup.getCallContext(dataAreaId));
            setCallOperationSuccess();
        } catch (CustomerServiceFindAifFaultFaultFaultMessage faultMessage) {
            analyzeAXFaultInfo(faultMessage, faultMessage.getFaultInfo(),
                    new LogInformation("Client", accountNum, dataAreaId));
        }
    }

    private CustomerServiceFindRequest createFindRequest(String accountNum) {
        CustomerServiceFindRequest findRequest = new CustomerServiceFindRequest();
        findRequest.setQueryCriteria(CallUtil.createQueryCriteria("CustTable", "AccountNum", accountNum));
        return findRequest;
    }

    public AxdEntityCustTable getCustomer() {
        return response.getCustomer().getCustTable().get(0);
    }

    public int getNumberOfClients() {
        return response.getCustomer().getCustTable().size();
    }

    public JAXBElement<String> getDocumentHash() {
        return getCustomer().getDocumentHash();
    }


    public JAXBElement<AxdTypeDateTime> getValidAsOfDateTime() {
        return response.getCustomer().getValidAsOfDateTime();
    }

    /** Needed for update Customer. See IDD document. */
    public JAXBElement<Long> getDirPartyRecId() {
        return getCustomer().getDirParty().get(0).getRecId();
    }

    /** Needed for update Customer. See IDD document. */
    public JAXBElement<Long> getDirPartyPostalAddressViewRecId() {
        return getCustomer().getDirParty().get(0).getDirPartyPostalAddressView().get(0).getRecId();
    }

    public String getBankAccount() {
        JAXBElement<String> bankAccount = getCustomer().getBankAccount();
        return bankAccount == null ? null : bankAccount.getValue();
    }
}
