package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2006._02.documents.querycriteria.CriteriaElement;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgcustbank.AxdEntityCustBankAccount;
import com.tradedoubler.billing.service.ax.webservice.AxWebServiceSetup;
import org.tempuri.*;

import javax.xml.bind.JAXBElement;
import java.util.List;

/**
 * Executes a web service call to Ax to find a clients bank.
 * User: erigu
 * Date: 2012-08-17
 */
public class FindBankCall extends AbstractWebServiceCall {
    private final AxWebServiceSetup serviceSetup;
    private final MDSITGCustBankService servicePort;
    private MDSITGCustBankServiceFindResponse response;

    public FindBankCall(AxWebServiceSetup serviceSetup) {
        this.serviceSetup = serviceSetup;
        this.servicePort = serviceSetup.getCustomerBankServicePort();
    }

    public void execute(String bankAccountId, String customerAccount, String dataAreaId) {
        MDSITGCustBankServiceFindRequest findRequest = createFindRequest(bankAccountId, customerAccount);
        try {
            response = servicePort.find(findRequest, serviceSetup.getCallContext(dataAreaId));
            setCallOperationSuccess();
        } catch (MDSITGCustBankServiceFindAifFaultFaultFaultMessage faultMessage) {
            analyzeAXFaultInfo(faultMessage, faultMessage.getFaultInfo(),
                    new LogInformation("Bank", "bankAccount: " + bankAccountId + " customerAccount: " + customerAccount, dataAreaId));
        }
    }

    private MDSITGCustBankServiceFindRequest createFindRequest(String accountId, String custAccount) {
        MDSITGCustBankServiceFindRequest findRequest = new MDSITGCustBankServiceFindRequest();
        CriteriaElement additionalElement = CallUtil.createCriteriaElement("CustBankAccount", "CustAccount", custAccount);
        findRequest.setQueryCriteria(CallUtil.createQueryCriteria("CustBankAccount", "AccountID", accountId, additionalElement));
        return findRequest;
    }

    public List<AxdEntityCustBankAccount> getBanks() {
        return response.getMDSITGCustBank().getCustBankAccount();
    }

    public int getNumberOfBanks() {
        return getBanks().size();
    }

    public JAXBElement<String> getDocumentHash() {
        return getBanks().get(0).getDocumentHash();
    }

}
