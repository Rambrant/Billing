package com.tradedoubler.billing.platform.flowcontroller.test;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.platform.flowcontroller.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test mule component for input load testing.
 */
public class DummyInputLoadFetcher {

    private final static Logger log = LoggerFactory.getLogger(DummyInputLoadFetcher.class);

    private static long time = System.currentTimeMillis();

    public ServiceResult execute(ServiceResult result) {
        time++;

        MetaData metaData = new MetaData("testType" + time, new Guid("" + time), new Timestamp("2012-08-15T15:30:01.999+02:00"), "1", "CRM");
        result.setRawData("Dummy Message__XX_ " + time);
        IntegrationMessage intMessage = new IntegrationMessage("" + time, metaData);
        result.setIntegrationMessage(intMessage);

        return result;
    }
}
