package com.tradedoubler.billing.service;

import com.tradedoubler.billing.exception.BariumNotExecutedTimeoutException;
import com.tradedoubler.billing.util.ExecutionUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mule.api.config.ConfigurationBuilder;
import org.mule.config.spring.SpringXmlConfigurationBuilder;
import org.mule.tck.junit4.AbstractMuleContextTestCase;

import java.util.Properties;

/**
 * @author Thomas Rambrant (thore)
 */

public class FlowAzureTest extends AbstractMuleContextTestCase
{
    @Override
    protected ConfigurationBuilder getBuilder() throws Exception
    {
        return new SpringXmlConfigurationBuilder( new String[]
        {
            "spring/springPropertiesContext-barium.xml",
            "spring/springServicesContext-barium-realAzure.xml",
            "spring/springBeansContext.xml",
            "flow/commons.xml",
            "flow/create-invoicing-rule-crm.xml",
            "flow/create-invoicing-rule-pan.xml",
            "flow/update-invoicing-rule-crm.xml",
            "flow/update-invoicing-rule-pan.xml",
            "flow/update-client-crm.xml",
            "flow/update-agreement-crm.xml",
            "flow/update-market-message-crm.xml",
            "flow/update-prepayment-forecast-pan.xml",
            "flow/update-reseller-client-pan.xml",
            "flow/delete-splitting-rule-crm.xml",
            "flow/delete-invoice-recipient-crm.xml",
            "flow/create-order-lines-pan.xml",
//            "flow/deliver-invoice-ax.xml",
            "flow/start-ax-invoicing-pan.xml"
        });
    }

    @BeforeClass
    public static void beforeClass()
    {
        //
        // Set the timeout used by the Mule framework. This value can be changed to whatever you need
        // We initially set this to 10 hours (36000 seconds)
        //
        Properties systemProperties = System.getProperties();

        systemProperties.setProperty( "mule.test.timeoutSecs", "36000");
    }

    @Before
    public void setup() throws Exception
    {
        //
        // Setup the database
        //
        ExecutionUtil.setupDatabase().cleanDatabase();
    }

    @After
    public void tearDown() throws Exception
    {
        ExecutionUtil.tearDownDatabase();
    }

    @Test
    public void normalFlowShouldWork() throws Exception
    {
        muleContext.start();

        try
        {
            System.out.print( "********************************************************************************\n");
            System.out.print( "*                         Time to start Barium                                 *\n");
            System.out.print( "********************************************************************************\n");

            ExecutionUtil.waitForStopCommand( 10000);

        }
        catch( BariumNotExecutedTimeoutException e)
        {
            //
            // This is nothing alarming. It just means that the Barium test framework didn't run a flow test in time
            //
            System.out.print( "*** Barium test framework didn't run a flow test in time\n");
        }

        muleContext.stop();
    }
}
