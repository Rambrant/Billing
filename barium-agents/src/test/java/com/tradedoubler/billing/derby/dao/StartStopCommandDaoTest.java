package com.tradedoubler.billing.derby.dao;

import com.tradedoubler.billing.derby.DerbyServer;
import com.tradedoubler.billing.derby.dto.StartStopCommandDto;
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

public class StartStopCommandDaoTest
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

        StartStopCommandDao dao = new StartStopCommandDao();
        StartStopCommandDto dto = new StartStopCommandDto();

        Long id = dao.create( dto);

        Assert.assertEquals( 1L, id.longValue());
    }

    @Test
    public void testRead() throws Exception
    {
        server.cleanDatabase();

        StartStopCommandDao dao = new StartStopCommandDao();
        StartStopCommandDto dto = new StartStopCommandDto();

        Long                id      = dao.create( dto);
        StartStopCommandDto readDto = dao.read( id);

        //
        // Assert that the created message is correct
        //
        Assert.assertEquals( id, readDto.getId());
        Assert.assertFalse( readDto.isStopped());
    }

    @Test
    public void testDelete() throws Exception
    {
        server.cleanDatabase();

        StartStopCommandDao dao = new StartStopCommandDao();
        StartStopCommandDto dto = new StartStopCommandDto();

        //
        // Then create a message and assert that its there
        //
        Long                id      = dao.create( dto);
        StartStopCommandDto readDto = dao.read( id);

        Assert.assertNotNull( readDto);

        //
        // Delete it and se if it's gone
        //
        dao.delete( id);

        readDto = dao.read( id);

        Assert.assertNull( readDto);
    }

    @Test
    public void testReadAll() throws Exception
    {
        server.cleanDatabase();

        StartStopCommandDao dao = new StartStopCommandDao();
        StartStopCommandDto dto = new StartStopCommandDto();

        dto.setStopped( true);

        //
        // Create some log records
        //
        Long id1 = dao.create( dto);
        Long id2 = dao.create( dto);

        //
        // Read them back in
        //
        List< StartStopCommandDto> list = dao.readAll();

        //
        // Check the result
        //
        Assert.assertEquals( 2, list.size());

        Assert.assertEquals( id1, list.get( 0).getId());
        Assert.assertTrue( list.get( 0).isStopped());

        Assert.assertEquals( id2, list.get( 1).getId());
        Assert.assertTrue( list.get( 1).isStopped());
    }

    @Test
    public void testReadAllAfter() throws Exception
    {
        server.cleanDatabase();

        StartStopCommandDao dao = new StartStopCommandDao();
        StartStopCommandDto dto = new StartStopCommandDto();

        //
        // Create some log records
        //
        Long id1 = dao.create( dto);

        Timestamp time = getTimeAndDelay();

        Long id2 = dao.create( dto);

        //
        // Read them back in
        //
        List< StartStopCommandDto> list = dao.readAllAfter( time);

        //
        // Check the result
        //
        Assert.assertEquals( 1, list.size());

        Assert.assertEquals( id2, list.get( 0).getId());
    }

    private Timestamp getTimeAndDelay()
    {
        Timestamp time = null;

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
