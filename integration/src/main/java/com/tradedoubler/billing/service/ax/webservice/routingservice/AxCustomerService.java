package com.tradedoubler.billing.service.ax.webservice.routingservice;

import com.tradedoubler.webservice.routing.salescustomer.RoutingService;

import java.net.URL;

/**
 * Extending class used for clarity to avoid the presence of multiple,
 * different, auto-generated RoutingService classes in the AxWebServiceSetup.
 * User: erigu
 * Date: 2012-08-13
 */
public class AxCustomerService extends RoutingService {

    public AxCustomerService(URL wsdlLocation) {
        super(wsdlLocation);
    }

}