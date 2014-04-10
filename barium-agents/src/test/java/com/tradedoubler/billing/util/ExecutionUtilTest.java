package com.tradedoubler.billing.util;

import com.tradedoubler.billing.derby.dao.StartStopCommandDao;
import com.tradedoubler.billing.derby.dto.StartStopCommandDto;
import com.tradedoubler.billing.exception.BariumNotExecutedTimeoutException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Thomas Rambrant (thore)
 */

public class ExecutionUtilTest
{
    @Before
    public void setUp() throws Exception
    {
        ExecutionUtil.setupDatabase();
    }

    @After
    public void tearDown() throws Exception
    {
        ExecutionUtil.tearDownDatabase();
    }

    @Test
    public void testWaitForStopCommandTimeout() throws Exception
    {
        long startTime = System.currentTimeMillis();

        try
        {
            //
            // This call will timeout since we never create a StartStopCommand entry in the database
            //
            ExecutionUtil.waitForStopCommand( 2000L);

            //
            // We should not end up here since we expect the exception
            //
            Assert.fail();
        }
        catch( BariumNotExecutedTimeoutException e)
        {
            long diffTime = startTime + 2000L - System.currentTimeMillis();

            Assert.assertTrue( "diffTime: " + diffTime, Math.abs( diffTime) < 1000L);
        }
    }

    @Test
    public void testWaitForStopCommand() throws Exception
    {
        StartStopCommandDao dao = new StartStopCommandDao();
        StartStopCommandDto dto = new StartStopCommandDto();

        //
        // Set the status to stopped in the database
        //
        dto.setStopped( true);

        dao.create( dto);

        long startTime = System.currentTimeMillis();

        //
        // This call only involves one database access since the status is already set to stop
        // and should therefore be fast.
        //
        ExecutionUtil.waitForStopCommand( 20000L);

        long diffTime = startTime - System.currentTimeMillis();

        Assert.assertTrue( "diffTime: " + diffTime, Math.abs( diffTime) < 500L);
    }

    @Test
    public void testWaitForStopCommandSeveralInTable() throws Exception
    {
        StartStopCommandDao dao = new StartStopCommandDao();
        StartStopCommandDto dto = new StartStopCommandDto();

        //
        // Create a couple of stopped false entries
        //
        dto.setStopped( false);

        dao.create( dto);
        dao.create( dto);

        //
        // Set the status to stopped in the database
        //
        dto.setStopped( true);

        dao.create( dto);

        long startTime = System.currentTimeMillis();

        //
        // This call only involves one database access since the status is already set to stop
        // and should therefore be fast.
        //
        ExecutionUtil.waitForStopCommand( 20000L);

        long diffTime = startTime - System.currentTimeMillis();

        Assert.assertTrue( "diffTime: " + diffTime, Math.abs( diffTime) < 500L);
    }
}
