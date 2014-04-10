package com.tradedoubler.billing.derby.dao;

import com.tradedoubler.billing.derby.DerbyServer;
import com.tradedoubler.billing.derby.dto.OrderLineDto;
import com.tradedoubler.billing.type.ProducerEventDbType;
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
public class AxOrderLineDaoTest
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

        AxOrderLineDao dao = new AxOrderLineDao();
        OrderLineDto   dto = new OrderLineDto();

        Long id = dao.create( dto, "AgreementId");

        Assert.assertEquals( 1L, id.longValue());
    }

    @Test
    public void testDelete() throws Exception
    {
        server.cleanDatabase();

        AxOrderLineDao dao = new AxOrderLineDao();
        OrderLineDto   dto = new OrderLineDto();

        Long id = dao.create( dto, "AgreementId");

        OrderLineDto readDto = dao.read( id);

        Assert.assertNotNull( readDto);

        dao.delete( id);

        readDto = dao.read( id);

        Assert.assertNull( readDto);
    }

    @Test
    public void testUpdate() throws Exception
    {
        server.cleanDatabase();

        AxOrderLineDao dao         = new AxOrderLineDao();
        OrderLineDto   originalDto = new OrderLineDto();

        //
        // Create one message
        //
        originalDto.setBatchId( "Batch_1");
        originalDto.setEventType( ProducerEventDbType.SYNTAX);
        originalDto.setNumOrderLines( 5);
        originalDto.setOrderLineId( "75");
        originalDto.setJsonOrderLine( "OrderLine");

        Long id = dao.create( originalDto, "AgreementId");

        Assert.assertEquals( originalDto.getId(), id);
        Assert.assertEquals( ProducerEventDbType.SYNTAX, originalDto.getEventType());
        Assert.assertEquals( "Batch_1".toLowerCase(), originalDto.getBatchId());
        Assert.assertEquals( 5, originalDto.getNumOrderLines().intValue());
        Assert.assertEquals( "75", originalDto.getOrderLineId());
        Assert.assertEquals( "OrderLine", originalDto.getJsonOrderLine());
        Assert.assertEquals( "AgreementId".toLowerCase(), originalDto.getAgreementId());

        //
        // Update the message
        //
        originalDto.setBatchId( "Batch_2".toLowerCase());
        originalDto.setEventType( ProducerEventDbType.NONE );
        originalDto.setNumOrderLines( 15);
        originalDto.setOrderLineId( "5");
        originalDto.setJsonOrderLine( "OrderLine_2");
        originalDto.setAgreementId( "AgreementId_2".toLowerCase());

        dao.update( originalDto);

        //
        // Verify that everything modified has changed
        //
        OrderLineDto readDto = dao.read( id);

        Assert.assertEquals( id, readDto.getId());
        Assert.assertEquals( ProducerEventDbType.NONE, readDto.getEventType());
        Assert.assertEquals( "Batch_2".toLowerCase(), readDto.getBatchId());
        Assert.assertEquals( 15, readDto.getNumOrderLines().intValue());
        Assert.assertEquals( "5", readDto.getOrderLineId());
        Assert.assertEquals( "OrderLine_2", readDto.getJsonOrderLine());
        Assert.assertEquals( "AgreementId_2".toLowerCase(), readDto.getAgreementId());
    }

    @Test
    public void testReadNext() throws Exception
    {
        server.cleanDatabase();

        AxOrderLineDao dao = new AxOrderLineDao();
        OrderLineDto dto1  = new OrderLineDto();
        OrderLineDto dto2  = new OrderLineDto();

        dto1.setJsonOrderLine( "OrderLine_1");
        dto2.setJsonOrderLine( "OrderLine_2");

        Long id1 = dao.create( dto1, "AgreementId");
        Long id2 = dao.create( dto2, "AgreementId");

        OrderLineDto first = dao.readNextBefore( dto1.getCreated());

        Assert.assertEquals( id1, first.getId());
        Assert.assertEquals( "OrderLine_1", first.getJsonOrderLine());

        dto1.setHandled( true);

        dao.update( dto1);

        OrderLineDto second = dao.readNextBefore( dto2.getCreated());

        Assert.assertEquals( id2, second.getId());
        Assert.assertEquals( "OrderLine_2", second.getJsonOrderLine());
    }

    @Test
    public void testRead() throws Exception
    {
        server.cleanDatabase();

        AxOrderLineDao dao = new AxOrderLineDao();
        OrderLineDto   dto = new OrderLineDto();

        //
        // Remember the current time to see if the created message has a correct timestamp.
        // Then create a message and immediately read it again
        //
        dto.setBatchId( "Batch_1");
        dto.setEventType( ProducerEventDbType.SYNTAX);
        dto.setNumOrderLines( 5);
        dto.setJsonOrderLine( "OrderLine");

        Timestamp timestamp = new Timestamp( System.currentTimeMillis());

        Long id = dao.create( dto, "AgreementId");

        OrderLineDto readDto = dao.read( id);

        //
        // Assert that the created log message is correct
        //
        Assert.assertEquals( id, readDto.getId());
        Assert.assertEquals( ProducerEventDbType.SYNTAX, readDto.getEventType());
        Assert.assertEquals( "Batch_1".toLowerCase(), readDto.getBatchId());
        Assert.assertEquals( 5, readDto.getNumOrderLines().intValue());
        Assert.assertEquals( "OrderLine", readDto.getJsonOrderLine());

        //
        // Check the timestamp. A slight deviation to account for the execution time is tolerated
        //
        long timeDiff = Math.abs( readDto.getCreated().getTime() - timestamp.getTime());

        Assert.assertTrue( "Timediff: " + timeDiff, timeDiff < 50L );
    }

    @Test
    public void testReadByAgreementId() throws Exception
    {
        server.cleanDatabase();

        PanOrderLineDao dao = new PanOrderLineDao();
        OrderLineDto    dto = new OrderLineDto();

        //
        // Create some log records
        //
        Long id1 = dao.create( dto, "AgreementId");
        Long id2 = dao.create( dto, "AgreementId2");
        Long id3 = dao.create( dto, "AgreementId2");
        Long id4 = dao.create( dto, "AgreementId");

        //
        // Read them back in
        //
        List< OrderLineDto> list = dao.readByAgreementId( "AgreementId");

        //
        // Check the result
        //
        Assert.assertEquals( 2, list.size());

        Assert.assertEquals( id1, list.get( 0).getId());
        Assert.assertEquals( id4, list.get( 1).getId());
    }

    @Test
    public void testReadAll() throws Exception
    {
        server.cleanDatabase();

        PanOrderLineDao dao = new PanOrderLineDao();
        OrderLineDto    dto = new OrderLineDto();

        //
        // Create some log records
        //
        dto.setEventType( ProducerEventDbType.SYNTAX);
        Long id1 = dao.create( dto, "AgreementId");

        dto.setEventType( ProducerEventDbType.NONE);
        Long id2 = dao.create( dto, "AgreementId");

        //
        // Read them back in
        //
        List< OrderLineDto> list = dao.readAll();

        //
        // Check the result
        //
        Assert.assertEquals( 2, list.size());

        Assert.assertEquals( id1, list.get( 0).getId());
        Assert.assertEquals( ProducerEventDbType.SYNTAX, list.get( 0).getEventType());

        Assert.assertEquals( id2, list.get( 1).getId());
        Assert.assertEquals( ProducerEventDbType.NONE, list.get( 1).getEventType());
    }

    @Test
    public void testReadAllAfter() throws Exception
    {
        server.cleanDatabase();

        AxOrderLineDao dao  = new AxOrderLineDao();
        OrderLineDto   dto1 = new OrderLineDto();
        OrderLineDto   dto2 = new OrderLineDto();

        //
        // Create some log records and remember the time between them
        //
        dto1.setEventType( ProducerEventDbType.SYNTAX);
        Long id1 = dao.create( dto1, "AgreementId");

        Timestamp timestamp = getTimeAndDelay();

        dto2.setEventType( ProducerEventDbType.NONE);
        Long id2 = dao.create( dto2, "AgreementId");

        //
        // Read them back in
        //
        List< OrderLineDto> list = dao.readAllAfter( timestamp);

        //
        // Check the result
        //
        Assert.assertEquals( 1, list.size());

        Assert.assertEquals( id2, list.get( 0).getId());
        Assert.assertEquals( ProducerEventDbType.NONE, list.get( 0).getEventType());
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
        catch( InterruptedException e)
        {
            //
            // Just swallow this
            //
        }

        return time;
    }
}
