package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalescla.AxdEntityMDSSalesClientAgreement;
import com.tradedoubler.billing.service.ax.webservice.AxWebServiceSetup;
import org.tempuri.*;

import javax.xml.bind.JAXBElement;
import java.util.List;

/**
 * Executes a web service call to Ax to find an Agreement.
 *
 * @author bjoek
 * @since 2012-06-11
 */
public class FindAgreementCall extends AbstractWebServiceCall {
    private final AxWebServiceSetup serviceSetup;
    private final MDSITGSalesClAService servicePort;
    private MDSITGSalesClAServiceFindResponse response;

    public FindAgreementCall(AxWebServiceSetup serviceSetup) {
        this.serviceSetup = serviceSetup;
        this.servicePort = serviceSetup.getSalesClientAgreementPort();
    }

    public void execute(String agreementId, String dataAreaId) {
        MDSITGSalesClAServiceFindRequest findRequest = createFindRequest(agreementId);

        try {
            response = servicePort.find(findRequest, serviceSetup.getCallContext(dataAreaId));
            setCallOperationSuccess();
        } catch (MDSITGSalesClAServiceFindAifFaultFaultFaultMessage faultMessage) {
            analyzeAXFaultInfo(faultMessage, faultMessage.getFaultInfo(),
                    new LogInformation("Agreement", agreementId, dataAreaId));
        }
    }

    private MDSITGSalesClAServiceFindRequest createFindRequest(String agreementId) {
        MDSITGSalesClAServiceFindRequest findRequest = new MDSITGSalesClAServiceFindRequest();
        findRequest.setQueryCriteria(CallUtil.createQueryCriteria("MDS_SalesClientAgreement", "SourceSystemAgreementId", agreementId));
        return findRequest;
    }

    public JAXBElement<String> getDocumentHash() {
        return getSalesClientAgreements().get(0).getDocumentHash();
    }

    public List<AxdEntityMDSSalesClientAgreement> getSalesClientAgreements() {
        return response.getMDSITGSalesClA().getMDSSalesClientAgreement();
    }

    public int getNumberOfAgreements() {
        return getSalesClientAgreements().size();
    }

}
