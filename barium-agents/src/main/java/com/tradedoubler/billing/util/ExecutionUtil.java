package com.tradedoubler.billing.util;

import com.tradedoubler.billing.derby.DerbyDao;
import com.tradedoubler.billing.derby.DerbyDataSource;
import com.tradedoubler.billing.derby.DerbyProperties;
import com.tradedoubler.billing.derby.DerbyServer;
import com.tradedoubler.billing.derby.dao.StartStopCommandDao;
import com.tradedoubler.billing.derby.dto.StartStopCommandDto;
import com.tradedoubler.billing.exception.BariumNotExecutedTimeoutException;

import java.util.List;

/**
 * @author Thomas Rambrant (thore)
 */

public class ExecutionUtil
{
    static DerbyServer server = null;

    public static DerbyServer setupDatabase() throws Exception
    {
        //
        // Start the database and setup the database access data source
        //
        DerbyProperties properties = new DerbyProperties();

        if( server == null)
        {
            server = new DerbyServer( properties);
        }

        server.start();

        server.cleanDatabase();

        DerbyDao.setGlobalDataSource( new DerbyDataSource( properties));

        return server;
    }

    public static void tearDownDatabase() throws Exception
    {
        if( server != null)
        {
            server.stop();
        }

        //
        // Check to see if the stop did actually stop the server and if it did, forget the server...
        //
        if( ! DerbyServer.isServerStarted())
        {
            server = null;
        }
    }

    public static void waitForStopCommand( long timeoutMs) throws Exception
    {
        long                       startTime  = System.currentTimeMillis();
        StartStopCommandDao        statusDao  = new StartStopCommandDao();
        List< StartStopCommandDto> statusList = null;

        do
        {
            //
            // We sleep for a while every turn of this loop except the first one
            //
            if( statusList != null)
            {
                Thread.sleep( 1000L);
            }

            statusList = statusDao.readAll();

            //
            // If the list is empty, that signals a non-existing Barium test execution,
            // and we have waited the given number of ms we just throws an exception
            //
            if( statusList.isEmpty() && (startTime + timeoutMs) < System.currentTimeMillis())
            {
                throw new BariumNotExecutedTimeoutException( "Barium probably not started in time. aborting...");
            }
        }
        while( statusList.isEmpty() || ( ! statusList.isEmpty() && ! statusList.get( statusList.size() - 1).isStopped()));
    }


    public static void sleepForLoadSimulation( int sleepTimeMs)
    {
        try
        {
            Thread.sleep( sleepTimeMs);
        }
        catch( InterruptedException e)
        {
            //
            // Not much to do here
            //
        }
    }
}
