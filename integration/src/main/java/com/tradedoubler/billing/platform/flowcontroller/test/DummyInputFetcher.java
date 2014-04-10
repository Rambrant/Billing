package com.tradedoubler.billing.platform.flowcontroller.test;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.platform.flowcontroller.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test mule component for input fetching.
 */
public class DummyInputFetcher {

    private final static Logger log = LoggerFactory.getLogger(DummyInputFetcher.class);

    /*

    static int NUM_OF_DUMMY_MESSAGES = 20;

    public ServiceResult execute( ServiceResult result) {


        if ( --NUM_OF_DUMMY_MESSAGES < -3){
            NUM_OF_DUMMY_MESSAGES = 19;
        }

        if ( NUM_OF_DUMMY_MESSAGES >= 0){

            String dummy = "";
            StringBuffer sb = new StringBuffer();
            for( int i=0; i < 1000000; i++){
                sb.append("D");
            }
            dummy = sb.toString();

            result.setRawData( dummy + "_Dummy Message " + (NUM_OF_DUMMY_MESSAGES + 1));




            MetaData metaData = new MetaData("testType", new Guid("123456"),new Timestamp("2012-08-16T15:30:01.999+02:00"),"1","CRM");
            IntegrationMessage intMessage = new IntegrationMessage("10", metaData);
            result.setIntegrationMessage( intMessage);
            log.info( "NUM_OF_DUMMY_MESSAGES = " + NUM_OF_DUMMY_MESSAGES);
        }else{
            log.info( "NO INPUT TO HANDLE.");
        }


        if ( NUM_OF_DUMMY_MESSAGES == 1){
            result.setBugDisturbance(true);
            result.setErrorMessage("A bad input related bug has occurred!");

            result.setDetailedErrorMessage(new Exception("This is my exception error"));
            log.info( "INPUT INTEGRATION POINT BUG IDENTIFIED. Expecting FlowController to react.");
        }else if ( NUM_OF_DUMMY_MESSAGES == 2 ){
            result.setIntegrationPointDisturbance(true);
            result.setErrorMessage( "Error 201 - DummyInputFetcher is tired");
            log.info( "INPUT INTEGRATION POINT NOT OPERATIONAL. Expecting FlowController to react.");
        }

        return result;
    }
                                 */


    private static int NUM_OF_DUMMY_MESSAGES = 20;

    public ServiceResult execute(ServiceResult result) {

        //AzureTest test = new AzureTest();
        //test.fetchMessage();


        if (--NUM_OF_DUMMY_MESSAGES < -3) {
            NUM_OF_DUMMY_MESSAGES = 19;
        }

        if (NUM_OF_DUMMY_MESSAGES >= 0) {
            result.setRawData("Dummy Message__XX " + (NUM_OF_DUMMY_MESSAGES + 1));


            MetaData metaData = new MetaData("testType", new Guid("123456"), new Timestamp("2012-08-15T15:30:01.999+02:00"), "1", "CRM");
            IntegrationMessage intMessage = new IntegrationMessage("10", metaData);
            result.setIntegrationMessage(intMessage);
            log.info("NUM_OF_DUMMY_MESSAGES = " + NUM_OF_DUMMY_MESSAGES);
        } else {
            log.info("NO INPUT TO HANDLE.");
        }


        if (NUM_OF_DUMMY_MESSAGES == 1) {
            result.setBugDisturbance(true);
            result.setErrorMessage("A bad input related bug has occurred! 2 ");
            log.info("BUG DISTURBANCE INTEGRATION POINT BUG IDENTIFIED. Expecting FlowController to react.");
        } else if (NUM_OF_DUMMY_MESSAGES == 2) {
            result.setIntegrationPointDisturbance(true);
            result.setErrorMessage("Error 201 - DummyInputFetcher is tired 2");
            log.info("INPUT INTEGRATION POINT NOT OPERATIONAL. Expecting FlowController to react.");
        }



        return result;
    }
}
