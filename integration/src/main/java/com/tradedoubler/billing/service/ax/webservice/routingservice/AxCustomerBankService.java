package com.tradedoubler.billing.service.ax.webservice.routingservice;

import com.tradedoubler.webservice.routing.customerbank.RoutingService;

import java.net.URL;

/**
 * Extending class used for clarity to avoid the presence of multiple,
 * different, auto-generated RoutingService classes in the AxWebServiceSetup.
 */
public class AxCustomerBankService extends RoutingService {

    public AxCustomerBankService(URL wsdlLocation) {
        super(wsdlLocation);
    }

}