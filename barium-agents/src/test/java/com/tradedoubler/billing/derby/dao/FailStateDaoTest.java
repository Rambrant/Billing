package com.tradedoubler.billing.derby.dao;

import com.tradedoubler.billing.derby.DerbyServer;
import com.tradedoubler.billing.derby.dto.FailStateDto;
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

public class FailStateDaoTest
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

        FailStateDao dao = new FailStateDao();

        Long id = dao.create( "TestId", true);

        Assert.assertEquals( 1L, id.longValue());
    }

    @Test
    public void testRead() throws Exception
    {
        server.cleanDatabase();

        FailStateDao dao = new FailStateDao();

        Long         id      = dao.create( "TestId", true);
        FailStateDto readDto = dao.read( id);

        //
        // Assert that the created message is correct
        //
        Assert.assertEquals( id,       readDto.getId());
        Assert.assertEquals( "TestId", readDto.getServiceName());
        Assert.assertEquals( true, readDto.getFailed());
    }

    @Test
    public void testDelete() throws Exception
    {
        server.cleanDatabase();

        FailStateDao dao = new FailStateDao();

        //
        // Then create a message and assert that its there
        //
        Long         id      = dao.create( "TestId", false);
        FailStateDto readDto = dao.read( id);

        Assert.assertNotNull( readDto);

        //
        // Delete it and se if it's gone
        //
        dao.delete( id);

        readDto = dao.read( id);

        Assert.assertNull( readDto);
    }

    @Test
    public void testFailureState() throws Exception
    {
        server.cleanDatabase();

        FailStateDao dao = new FailStateDao();

        Assert.assertFalse( dao.isInFailState( "TestId1"));

        //
        // Create a failure interval now
        //
        dao.create( "TestId1", true);

        Assert.assertTrue( dao.isInFailState( "TestId1"));

        //
        // Remove the failure state
        //
        dao.create( "TestId1", false);

        Assert.assertFalse( dao.isInFailState( "TestId1"));
    }

    @Test
    public void testReadAll() throws Exception
    {
        server.cleanDatabase();

        FailStateDao dao  = new FailStateDao();

        //
        // Create some log records
        //
        Long id1 = dao.create( "TestId1", true);
        Long id2 = dao.create( "TestId2", false);

        //
        // Read them back in
        //
        List< FailStateDto> list = dao.readAll();

        //
        // Check the result
        //
        Assert.assertEquals( 2, list.size());

        Assert.assertEquals( id1, list.get( 0).getId());
        Assert.assertEquals( "TestId1", list.get( 0).getServiceName());

        Assert.assertEquals( id2, list.get( 1).getId());
        Assert.assertEquals( "TestId2", list.get( 1).getServiceName());
    }

    @Test
    public void testReadAllAfter() throws Exception
    {
        server.cleanDatabase();

        FailStateDao dao  = new FailStateDao();

        //
        // Create some log records
        //
        Long id1 = dao.create( "TestId1", true);

        Timestamp time = getTimeAndDelay();

        Long id2 = dao.create( "TestId2", false);

        //
        // Read them back in
        //
        List< FailStateDto> list = dao.readAllAfter( time);

        //
        // Check the result
        //
        Assert.assertEquals( 1, list.size());

        Assert.assertEquals( id2, list.get( 0).getId());
        Assert.assertEquals( "TestId2", list.get( 0).getServiceName());
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
