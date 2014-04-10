package com.tradedoubler.billing.derby.dao;

import com.tradedoubler.billing.derby.DerbyServer;
import com.tradedoubler.billing.derby.dto.EventLogDto;
import com.tradedoubler.billing.fetch.FlowName;
import com.tradedoubler.billing.type.EventLogType;
import com.tradedoubler.billing.util.ExecutionUtil;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

/**
 * @author Thomas Rambrant (thore)
 */

public class EventLogDaoTest
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

        EventLogDao dao = new EventLogDao();

        Long id = dao.create(
            EventLogType.DELETE,
            FlowName.CreateInvoicingRuleCrm,
            "IntegrationId",
            UUID.randomUUID().toString());

        Assert.assertEquals( 1L, id.longValue());
    }

    @Test
    public void testRead() throws Exception
    {
        server.cleanDatabase();

        EventLogDao dao = new EventLogDao();

        //
        // Remember the current time to see if the created message has a correct timestamp.
        // Then create a message and immediately read it again
        //
        Timestamp timestamp = new Timestamp( System.currentTimeMillis());

        String guid = UUID.randomUUID().toString();

        Long id = dao.create(
            EventLogType.DELETE,
            FlowName.CreateInvoicingRuleCrm,
            "IntegrationPointId",
            guid);

        EventLogDto readDto = dao.read( id);

        //
        // Assert that the created log message is correct
        //
        Assert.assertEquals( id, readDto.getId());
        Assert.assertEquals( EventLogType.DELETE, readDto.getEventType());
        Assert.assertEquals( FlowName.CreateInvoicingRuleCrm, readDto.getFlowName());
        Assert.assertEquals( guid, readDto.getMessageId());
        Assert.assertEquals( "IntegrationPointId", readDto.getIntegrationPointId());

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

        EventLogDao dao = new EventLogDao();

        Long id = dao.create(
            EventLogType.DELETE,
            FlowName.CreateInvoicingRuleCrm,
            "IntegrationId",
            UUID.randomUUID().toString());

        EventLogDto readDto = dao.read( id);

        Assert.assertNotNull( readDto);

        dao.delete( id);

        readDto = dao.read( id);

        Assert.assertNull( readDto);
    }

    @Test
    public void testReadAll() throws Exception
    {
        server.cleanDatabase();

        EventLogDao dao  = new EventLogDao();

        //
        // Create some log records
        //
        Long id1 = dao.create(
            EventLogType.DELETE,
            FlowName.CreateInvoicingRuleCrm,
            "IntegrationId",
            UUID.randomUUID().toString());

        Long id2 = dao.create(
            EventLogType.RECEIVE,
            FlowName.CreateInvoicingRuleCrm,
            "IntegrationId",
            UUID.randomUUID().toString());

        //
        // Read them back in
        //
        List< EventLogDto> list = dao.readAll();

        //
        // Check the result
        //
        Assert.assertEquals( 2, list.size());

        Assert.assertEquals( id1, list.get( 0).getId());
        Assert.assertEquals( EventLogType.DELETE, list.get( 0).getEventType());

        Assert.assertEquals( id2, list.get( 1).getId());
        Assert.assertEquals( EventLogType.RECEIVE, list.get( 1).getEventType());
    }

    @Test
    public void testReadAllByMessageId() throws Exception
    {
        server.cleanDatabase();

        EventLogDao dao  = new EventLogDao();

        //
        // Create some log records
        //
        Long id1 = dao.create(
            EventLogType.DELETE,
            FlowName.CreateInvoicingRuleCrm,
            "IntegrationId",
            UUID.randomUUID().toString());

        String uuid =  UUID.randomUUID().toString();

        Long id2 = dao.create(
            EventLogType.RECEIVE,
            FlowName.CreateInvoicingRuleCrm,
            "IntegrationId",
            uuid);

        //
        // Read them back in
        //
        List< EventLogDto> list = dao.readAllByMessageId( uuid);

        //
        // Check the result
        //
        Assert.assertEquals( 1, list.size());

        Assert.assertEquals( id2, list.get( 0).getId());
        Assert.assertEquals( EventLogType.RECEIVE, list.get( 0).getEventType());
        Assert.assertEquals( uuid, list.get( 0).getMessageId());
    }

    @Test
    public void testReadAllByFlowName() throws Exception
    {
        server.cleanDatabase();

        EventLogDao dao = new EventLogDao();

        //
        // Create some log records
        //
        Long id1 = dao.create(
            EventLogType.DELETE,
            FlowName.CreateInvoicingRuleCrm,
            "IntegrationId",
            UUID.randomUUID().toString());

        String uuid =  UUID.randomUUID().toString();

        Long id2 = dao.create(
            EventLogType.RECEIVE,
            FlowName.UpdateInvoicingRuleCrm,
            "IntegrationId",
            uuid);

        //
        // Read them back in
        //
        List< EventLogDto> list = dao.readAllByFlowName( FlowName.UpdateInvoicingRuleCrm);

        //
        // Check the result
        //
        Assert.assertEquals( 1, list.size());

        Assert.assertEquals( id2, list.get( 0).getId());
        Assert.assertEquals( EventLogType.RECEIVE, list.get( 0).getEventType());
        Assert.assertEquals( FlowName.UpdateInvoicingRuleCrm, list.get( 0).getFlowName());
    }

    @Test
    public void testReadAllByFlowNameAfter() throws Exception
    {
        server.cleanDatabase();

        EventLogDao dao = new EventLogDao();

        //
        // Create some log records
        //
        Long id1 = dao.create(
            EventLogType.DELETE,
            FlowName.UpdateInvoicingRuleCrm,
            "IntegrationId",
            UUID.randomUUID().toString());

        String    uuid      = UUID.randomUUID().toString();
        Timestamp timestamp = getTimeAndDelay();

        Long id2 = dao.create(
            EventLogType.RECEIVE,
            FlowName.UpdateInvoicingRuleCrm,
            "IntegrationId",
            uuid);

        //
        // Read them back in
        //
        List< EventLogDto> list = dao.readAllByFlowNameAfter( FlowName.UpdateInvoicingRuleCrm,timestamp);

        //
        // Check the result
        //
        Assert.assertEquals( 1, list.size());

        Assert.assertEquals( id2, list.get( 0).getId());
        Assert.assertEquals( EventLogType.RECEIVE, list.get( 0).getEventType());
        Assert.assertEquals( FlowName.UpdateInvoicingRuleCrm, list.get( 0).getFlowName());
    }

    @Test
    public void testReadAllAfter() throws Exception
    {
        server.cleanDatabase();

        EventLogDao dao = new EventLogDao();

        //
        // Create two messages and store the time between them
        //
        Long id1 = dao.create(
            EventLogType.DELETE,
            FlowName.CreateInvoicingRuleCrm,
            "IntegrationId",
            UUID.randomUUID().toString());

        Timestamp timestamp = getTimeAndDelay();

        Long id2 = dao.create(
            EventLogType.SEND,
            FlowName.CreateInvoicingRuleCrm,
            "IntegrationId",
            UUID.randomUUID().toString());

        //
        // Read the back in
        //
        List< EventLogDto> list = dao.readAllAfter( timestamp);

        //
        // Assert that only the last message is found
        //
        Assert.assertEquals( 1, list.size());

        Assert.assertEquals( id2, list.get( 0).getId());
        Assert.assertEquals( EventLogType.SEND, list.get( 0).getEventType());
        Assert.assertTrue( timestamp.getTime() <= list.get(  0).getCreated().getTime());
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
