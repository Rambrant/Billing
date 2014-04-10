package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2006._02.documents.entitykeylist.EntityKeyList;
import com.microsoft.schemas.dynamics._2008._01.documents.customer.*;
import com.microsoft.schemas.dynamics._2008._01.services.*;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdTypeDateTime;
import com.tradedoubler.billing.service.ax.webservice.AxWebServiceSetup;

import javax.xml.bind.JAXBElement;

/**
 * Executes a web service call to Ax to read an entity. If the entity is not found, then it is classed as a bug disturbance
 * User: erigu
 * Date: 2012-08-17
 */
public class ReadClientCall extends AbstractWebServiceCall {
    private final AxWebServiceSetup serviceSetup;
    private final CustomerService servicePort;
    private CustomerServiceReadResponse response;

    public ReadClientCall(AxWebServiceSetup serviceSetup) {
        this.serviceSetup = serviceSetup;
        this.servicePort = serviceSetup.getCustomerPort();
    }

    public void execute(String accountNum, String dataAreaId) {
        EntityKeyList entityKeyList = CallUtil.createEntityKeyListForOneItem("AccountNum", accountNum);
        CustomerServiceReadRequest readRequest = new CustomerServiceReadRequest();
        readRequest.setEntityKeyList(entityKeyList);

        try {
            response = servicePort.read(readRequest, serviceSetup.getCallContext(dataAreaId));
            setCallOperationSuccess();
        } catch (CustomerServiceReadAifFaultFaultFaultMessage faultMessage) {
            analyzeAXFaultInfo(faultMessage, faultMessage.getFaultInfo(),
                    new LogInformation("Client", accountNum, dataAreaId));
        }

    }


    public AxdCustomer getCustomer() {
        return response.getCustomer();
    }

    /** Needed for update Customer. See IDD document. */
    public JAXBElement<AxdTypeDateTime> getValidAsOfDateTime() {
        return response.getCustomer().getValidAsOfDateTime();
    }

    /** Needed for update Customer. See IDD document. */
    public JAXBElement<Long> getDirPartyRecId() {
        return getCustTable().getDirParty().get(0).getRecId();
    }

    /** Needed for update Customer. See IDD document. */
    public JAXBElement<Long> getDirPartyPostalAddressViewRecId() {
        return getCustTable().getDirParty().get(0).getDirPartyPostalAddressView().get(0).getRecId();
    }

    /** Needed for update Customer. See IDD document. */
    public JAXBElement<String> getDocumentHash() {
        return getCustTable().getDocumentHash();
    }

    private AxdEntityCustTable getCustTable() {
        return response.getCustomer().getCustTable().get(0);
    }

}
