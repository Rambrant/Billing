package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvrec.*;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdTypeDateTime;
import com.tradedoubler.billing.service.ax.webservice.AxWebServiceSetup;
import org.tempuri.*;

import javax.xml.bind.JAXBElement;
import java.util.List;

/**
 * Executes a web service call to find an Invoice recipient, by primary key, in Ax.
 * User: bjoek
 * Date: 2012-09-05
 */
public class FindInvoiceRecipientCall extends AbstractWebServiceCall {

    private final AxWebServiceSetup serviceSetup;
    private final MDSITGSInvRecService servicePort;
    private MDSITGSInvRecServiceFindResponse response;

    public FindInvoiceRecipientCall(AxWebServiceSetup serviceSetup) {
        this.serviceSetup = serviceSetup;
        this.servicePort = serviceSetup.getInvoiceRecipientPort();
    }

    public void execute(String invoiceRecipientId, String dataAreaId) {
        MDSITGSInvRecServiceFindRequest findRequest = new MDSITGSInvRecServiceFindRequest();
        findRequest.setQueryCriteria(CallUtil.createQueryCriteria("MDS_SalesInvoiceRecipient", "InvoiceRecipientId", invoiceRecipientId));

        try {
            response = servicePort.find(findRequest, serviceSetup.getCallContext(dataAreaId));
            setCallOperationSuccess();
        } catch (MDSITGSInvRecServiceFindAifFaultFaultFaultMessage faultMessage) {
            analyzeAXFaultInfo(faultMessage, faultMessage.getFaultInfo(),
                    new LogInformation("InvoiceRecipient", invoiceRecipientId, dataAreaId));
        }
    }

    /** Provides list of splitters */
    public List<AxdEntityMDSSalesSplitter> getSplitters() {
        return getInvoiceRecipient().getMDSSalesSplitter();
    }

    /** Needed for update InvoiceRecipien. See IDD document. */
    public JAXBElement<AxdTypeDateTime> getValidAsOfDateTime() {
        return response.getMDSITGSInvRec().getValidAsOfDateTime();
    }

    /** Needed for update InvoiceRecipient. See IDD document. */
    public JAXBElement<String> getDocumentHash() {
        return getInvoiceRecipient().getDocumentHash();
    }

    /** Needed for update InvoiceRecipient. See IDD document. */
    public JAXBElement<Long> getLogisticLocationRecId() {
        return getInvoiceRecipient().getLogisticsLocation().get(0).getRecId();
    }

    /** Needed for update InvoiceRecipient. See IDD document. */
    public long getPostalAddressLocationId() {
        return getInvoiceRecipient().getLogisticsLocation().get(0).getLogisticsPostalAddress().get(0).getLocation();
    }

    /** Needed for update InvoiceRecipient. See IDD document. */
    public JAXBElement<Long> getPostalAddressRecId() {
        return getInvoiceRecipient().getLogisticsLocation().get(0).getLogisticsPostalAddress().get(0).getRecId();
    }

    public AxdEntityMDSSalesInvoiceRecipient getInvoiceRecipient() {
        return response.getMDSITGSInvRec().getMDSSalesInvoiceRecipient().get(0);
    }

    public int getNumberOfInvoiceRecipient() {
        return response.getMDSITGSInvRec().getMDSSalesInvoiceRecipient().size();
    }

}
