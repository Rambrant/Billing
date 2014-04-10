package com.tradedoubler.billing.platform.flowcontroller.test;

import com.tradedoubler.billing.platform.flowcontroller.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mock mule component for testing.
 */
public class BusinessComponentMock2 {


    private static int counter = 10;

    private static boolean ok = true;


    private final static Logger log = LoggerFactory.getLogger(BusinessComponentMock2.class);


    public ServiceResult execute(ServiceResult input) {


        IntegrationMessage intMess = input.getIntegrationMessage();
        if (intMess.isOutOfSequence()) {

        }


        try {
            // In a real flow: Do the business work
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //return e.getMessage();
        }

        --counter;

        //if ( counter == 2 || counter == 1){
        /*if ( counter == 1){
            ok = false;
            log.info( "Output point NOT OPERATIONAL. Expecting FlowController to react.");
        }else */
        if (counter == 0) {
            ok = false;
            counter = 10;
            log.info("OUTPUT INTEGRATION POINT NOT OPERATIONAL. Expecting FlowController to react.");
        } else {
            ok = true;
            //log.info( "Output point operational");
        }

        if (ok) {
            input.setRawData("BusinessComponentMock2 done sleeping and has handled input: " + input.getRawData());
        } else {
            input.setIntegrationPointDisturbance(true);
            input.setErrorMessage("No route to host");
        }


        // Code to trigger the default exception handler
        /*
        Object obj = null;
        if ( 1 == 1) obj.equals(1L);
        */

        /*if( 1 == 1){
            throw new IllegalArgumentException("I did some strange error now!!!");
        } */


        return input;
    }
}
