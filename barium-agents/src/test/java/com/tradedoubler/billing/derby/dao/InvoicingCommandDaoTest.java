package com.tradedoubler.billing.derby.dao;

import com.tradedoubler.billing.derby.DerbyServer;
import com.tradedoubler.billing.derby.dto.InvoicingCommandDto;
import com.tradedoubler.billing.type.InvoicingStatusType;
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

public class InvoicingCommandDaoTest
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

        InvoicingCommandDao dao = new InvoicingCommandDao();

        Long id = dao.create( InvoicingStatusType.STARTED, true);

        Assert.assertEquals( 1L, id.longValue());
    }

    @Test
    public void testRead() throws Exception
    {
        server.cleanDatabase();

        InvoicingCommandDao dao = new InvoicingCommandDao();

        Long                id      = dao.create( InvoicingStatusType.STARTED, true);
        InvoicingCommandDto readDto = dao.read( id);

        //
        // Assert that the created message is correct
        //
        Assert.assertEquals( id, readDto.getId());
        Assert.assertEquals( InvoicingStatusType.STARTED, readDto.getStatus());
    }

    @Test
    public void testDelete() throws Exception
    {
        server.cleanDatabase();

        InvoicingCommandDao dao = new InvoicingCommandDao();

        //
        // Then create a message and assert that its there
        //
        Long                id      = dao.create( InvoicingStatusType.STOPPED, true);
        InvoicingCommandDto readDto = dao.read( id);

        Assert.assertNotNull( readDto);

        //
        // Delete it and se if it's gone
        //
        dao.delete( id);

        readDto = dao.read( id);

        Assert.assertNull( readDto);
    }

    @Test
    public void testReadLatest() throws Exception
    {
        server.cleanDatabase();

        InvoicingCommandDao dao  = new InvoicingCommandDao();

        //
        // Create some log records
        //
        Long id1 = dao.create( InvoicingStatusType.STOPPED, true);
        Long id2 = dao.create( InvoicingStatusType.RUNNING, true);

        //
        // Read them back in
        //
        InvoicingCommandDto dto = dao.readLatest();

        //
        // Check the result
        //
        Assert.assertEquals( id2, dto.getId());
        Assert.assertEquals( InvoicingStatusType.RUNNING, dto.getStatus());
    }

    @Test
    public void testIsStopped() throws Exception
    {
        server.cleanDatabase();

        InvoicingCommandDao dao  = new InvoicingCommandDao();

        //
        // An empty table should also signal stopped'
        //
        Assert.assertTrue( dao.isStopped());

        //
        // Create a Running log record
        //
        dao.create( InvoicingStatusType.RUNNING, true);

        Assert.assertFalse( dao.isStopped());

        //
        // Signal stopped
        //
        dao.create( InvoicingStatusType.STOPPED, true);

        Assert.assertTrue( dao.isStopped());
    }

    @Test
    public void testIsStarted() throws Exception
    {
        server.cleanDatabase();

        InvoicingCommandDao dao  = new InvoicingCommandDao();

        //
        // An empty table should signal stopped'
        //
        Assert.assertFalse( dao.isStarted());

        //
        // Create a Running log record
        //
        dao.create( InvoicingStatusType.RUNNING, true);

        Assert.assertFalse( dao.isStarted());

        //
        // Signal stopped
        //
        dao.create( InvoicingStatusType.STARTED, true);

        Assert.assertTrue( dao.isStarted());
    }

    @Test
    public void testIsRunning() throws Exception
    {
        server.cleanDatabase();

        InvoicingCommandDao dao  = new InvoicingCommandDao();

        //
        // An empty table should signal stopped'
        //
        Assert.assertFalse( dao.isRunning());

        //
        // Create a Running log record
        //
        dao.create( InvoicingStatusType.STARTED, true);

        Assert.assertFalse( dao.isRunning());

        //
        // Signal stopped
        //
        dao.create( InvoicingStatusType.RUNNING, true);

        Assert.assertTrue( dao.isRunning());
    }
    @Test
    public void testReadAll() throws Exception
    {
        server.cleanDatabase();

        InvoicingCommandDao dao  = new InvoicingCommandDao();

        //
        // Create some log records
        //
        Long id1 = dao.create( InvoicingStatusType.STOPPED, true);
        Long id2 = dao.create( InvoicingStatusType.RUNNING, true);

        //
        // Read them back in
        //
        List< InvoicingCommandDto> list = dao.readAll();

        //
        // Check the result
        //
        Assert.assertEquals( 2, list.size());

        Assert.assertEquals( id1, list.get( 0).getId());
        Assert.assertEquals( InvoicingStatusType.STOPPED, list.get( 0).getStatus());

        Assert.assertEquals( id2, list.get( 1).getId());
        Assert.assertEquals( InvoicingStatusType.RUNNING, list.get( 1).getStatus());
    }

    @Test
    public void testReadAllAfter() throws Exception
    {
        server.cleanDatabase();

        InvoicingCommandDao dao  = new InvoicingCommandDao();

        //
        // Create some log records
        //
        Long id1 = dao.create( InvoicingStatusType.STOPPED, true);

        Timestamp time = getTimeAndDelay();

        Long id2 = dao.create( InvoicingStatusType.RUNNING, true);

        //
        // Read them back in
        //
        List< InvoicingCommandDto> list = dao.readAllAfter( time);

        //
        // Check the result
        //
        Assert.assertEquals( 1, list.size());

        Assert.assertEquals( id2, list.get( 0).getId());
        Assert.assertEquals( InvoicingStatusType.RUNNING, list.get( 0).getStatus());
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
