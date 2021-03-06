package com.tradedoubler.billing.service.ax.webservice.routingservice;

import com.tradedoubler.webservice.routing.invoicerecipient.RoutingService;

import java.net.URL;

/**
 * Extending class used for clarity to avoid the presence of multiple,
 * different, auto-generated RoutingService classes in the AxWebServiceSetup.
 */
public class AxInvRecipientService extends RoutingService {

    public AxInvRecipientService(URL wsdlLocation) {
        super(wsdlLocation);
    }

}