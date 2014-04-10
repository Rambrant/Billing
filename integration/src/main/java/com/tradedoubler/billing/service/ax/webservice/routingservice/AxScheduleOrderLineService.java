package com.tradedoubler.billing.service.ax.webservice.routingservice;


import com.tradedoubler.webservice.routing.schedulesalesorderbasisline.RoutingService;

import java.net.URL;

/**
 * Extending class used for clarity to avoid the presence of multiple,
 * different, auto-generated RoutingService classes in the AxWebServiceSetup.
 */
public class AxScheduleOrderLineService extends RoutingService {

    public AxScheduleOrderLineService(URL wsdlLocation) {
        super(wsdlLocation);
    }

}