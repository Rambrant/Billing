package com.tradedoubler.billing.service.ax.webservice.domainhandler;

import com.tradedoubler.billing.service.ax.CallResultHandler;
import com.tradedoubler.billing.service.ax.webservice.call.WebServiceCallFactory;
import com.tradedoubler.billing.service.transform.AxConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Contains converting information for, for instance country codes
 * Defined by injection in SpringConfig.
 */
@Component
public abstract class AbstractHandler {

    @Autowired
    protected AxConverterService converter;
    @Autowired
    protected WebServiceCallFactory webServiceCallFactory;
    @Autowired
    protected CallResultHandler callResultHandler;


}
