package com.tradedoubler.billing.service.ax.webservice.routingservice;


import com.tradedoubler.webservice.routing.invoicemessage.RoutingService;

import java.net.URL;

/**
 * Extending class used for clarity to avoid the presence of multiple,
 * different, auto-generated RoutingService classes in the AxWebServiceSetup.
 */
public class AxInvMessageService extends RoutingService {

    public AxInvMessageService(URL wsdlLocation) {
        super(wsdlLocation);
    }

}