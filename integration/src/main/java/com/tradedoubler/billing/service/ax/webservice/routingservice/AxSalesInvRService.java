package com.tradedoubler.billing.service.ax.webservice.routingservice;

import com.microsoft.schemas.dynamics._2008._01.services.MDSITGSalesInvRService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

/**
 * Extending class used for clarity to avoid the presence of multiple,
 * different, auto-generated RoutingService classes in the AxWebServiceSetup.
 * @author bjoek
 * @since 2012-06-18
 */
public class AxSalesInvRService extends Service {
    private final static QName SERVICE_NAME = new QName("http://tempuri.org/", "RoutingService");
    private final static QName BasicHttpBindingMDSITGSalesInvRService = new QName("http://tempuri.org/", "BasicHttpBinding_MDS_ITGSalesInvRService");

    public AxSalesInvRService(URL wsdlDocumentLocation) {
        super(wsdlDocumentLocation, SERVICE_NAME);
    }

    public MDSITGSalesInvRService getBasicHttpBindingMDSITGSalesInvRService() {
        return super.getPort(BasicHttpBindingMDSITGSalesInvRService, MDSITGSalesInvRService.class);
    }

}

