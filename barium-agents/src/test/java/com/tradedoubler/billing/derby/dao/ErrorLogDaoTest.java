package com.tradedoubler.billing.derby.dao;

import com.tradedoubler.billing.derby.DerbyServer;
import com.tradedoubler.billing.derby.dto.ErrorLogDto;
import com.tradedoubler.billing.util.ExecutionUtil;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Thomas Rambrant (thore)
 */

public class ErrorLogDaoTest
{
    private static DerbyServer server;

    @BeforeClass
    public static void setUp() throws Exception
    {
        server = ExecutionUtil.setupDatabase();
    }

    @AfterClass
    public static void tearDown() throws Exception
    {
        ExecutionUtil.tearDownDatabase();
    }

    @Test
    public void testCreate() throws Exception
    {
        server.cleanDatabase();

        ErrorLogDao dao = new ErrorLogDao();

        Long id = dao.create( "Test");

        Assert.assertEquals( 1L, id.longValue());
    }

    @Test
    public void testRead() throws Exception
    {
        server.cleanDatabase();

        ErrorLogDao dao = new ErrorLogDao();

        //
        // Remember the current time to see if the created message has a correct timestamp.
        // Then create a message and immediately read it again
        //
        Timestamp timestamp = new Timestamp( System.currentTimeMillis());

        Long        id      = dao.create( "Test");
        ErrorLogDto readDto = dao.read( id);

        //
        // Assert that the created log message is correct
        //
        Assert.assertEquals( id,     readDto.getId());
        Assert.assertEquals( "Test", readDto.getMessage());

        //
        // Check the timestamp. A slight deviation to account for the execution time is tolerated
        //
        long timeDiff = Math.abs( readDto.getCreated().getTime() - timestamp.getTime());

        Assert.assertTrue( "Timediff: " + timeDiff, timeDiff < 50L);
    }

    @Test
    public void testDelete() throws Exception
    {
        server.cleanDatabase();

        ErrorLogDao dao = new ErrorLogDao();

        Long id = dao.create( "Test message");

        ErrorLogDto readDto = dao.read( id);

        Assert.assertNotNull( readDto);

        dao.delete( id);

        readDto = dao.read( id);

        Assert.assertNull( readDto);
    }

    @Test
    public void testReadAll() throws Exception
    {
        server.cleanDatabase();

        ErrorLogDao dao  = new ErrorLogDao();

        //
        // Create some log records
        //
        Long id1 = dao.create( "Test1");
        Long id2 = dao.create( "Test2");

        //
        // Read them back in
        //
        List< ErrorLogDto> list = dao.readAll();

        //
        // Check the result
        //
        Assert.assertEquals( 2, list.size());

        Assert.assertEquals( id1, list.get( 0).getId());
        Assert.assertEquals( "Test1", list.get( 0).getMessage());

        Assert.assertEquals( id2, list.get( 1).getId());
        Assert.assertEquals( "Test2", list.get( 1).getMessage());
    }

    @Test
    public void testReadAllAfter() throws Exception
    {
        server.cleanDatabase();

        ErrorLogDao dao = new ErrorLogDao();

        //
        // Create some log records
        //
        Long id1 = dao.create( "Test1");

        Timestamp time = getTimeAndDelay();

        Long id2 = dao.create( "Test2");

        //
        // Read them back in
        //
        List< ErrorLogDto> list = dao.readAllAfter( time);

        //
        // Check the result
        //
        Assert.assertEquals( 1, list.size());

        Assert.assertEquals( id2, list.get( 0).getId());
        Assert.assertEquals( "Test2", list.get( 0).getMessage());
    }

    private Timestamp getTimeAndDelay()
    {
        Timestamp time = new Timestamp( System.currentTimeMillis());

        try
        {
            Thread.sleep( 100L);
            time = new Timestamp( System.currentTimeMillis());
            Thread.sleep( 100L);
        }
        catch( InterruptedException e )
        {
            //
            // Just swallow this
            //
        }

        return time;
    }
}
