package com.tradedoubler.billing.derby.dao;

import com.tradedoubler.billing.derby.DerbyServer;
import com.tradedoubler.billing.derby.dto.CrmMessageDto;
import com.tradedoubler.billing.type.ProducerEventDbType;
import com.tradedoubler.billing.util.ExecutionUtil;
import com.tradedoubler.testutil.FileUtil;
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

public class CrmMessageDaoTest
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

        CrmCreateInvoiceRuleDao dao = new CrmCreateInvoiceRuleDao();
        CrmMessageDto           dto = new CrmMessageDto();

        dto.setJsonMessage( FileUtil.readFileFromClasspath( "json-examples/invoicing-rule-created-example.json"));

        Long id = dao.create( dto, "Entity");

        Assert.assertEquals( id, dto.getId());
        Assert.assertEquals( 1L, id.longValue());
        Assert.assertEquals( "Entity".toLowerCase(), dto.getEntityId());
        Assert.assertEquals( false, dto.isSent());
    }

    @Test
    public void testRead() throws Exception
    {
        server.cleanDatabase();

        CrmCreateInvoiceRuleDao dao = new CrmCreateInvoiceRuleDao();
        CrmMessageDto           dto = new CrmMessageDto();

        String guid = UUID.randomUUID().toString();

        dto.setAssociatedRowId( 4L);
        dto.setDeleted( true);
        dto.setEventType( ProducerEventDbType.SYNTAX);
        dto.setOutOfOrder( true);
        dto.setSent( true);
        dto.setMessageId( guid);
        dto.setJsonMessage( FileUtil.readFileFromClasspath( "json-examples/invoicing-rule-created-example.json"));

        Long id = dao.create( dto, "EntityId");

        CrmMessageDto readDto = dao.read( id);

        Assert.assertEquals( id,                          dto.getId());
        Assert.assertEquals( dto.getId(),                 readDto.getId());
        Assert.assertEquals( dto.getEntityId(),           readDto.getEntityId());
        Assert.assertEquals( dto.getAssociatedRowId(),    readDto.getAssociatedRowId());
        Assert.assertEquals( dto.isSent(),                readDto.isSent());
        Assert.assertEquals( dto.isDeleted(),             readDto.isDeleted());
        Assert.assertEquals( dto.isOutOfOrder(),          readDto.isOutOfOrder());
        Assert.assertEquals( dto.getSendTime(),           readDto.getSendTime());
        Assert.assertEquals( dto.getDeleteTime(),         readDto.getDeleteTime());
        Assert.assertEquals( dto.getNumberOfSends(),      readDto.getNumberOfSends());
        Assert.assertEquals( dto.getEventType(),          readDto.getEventType());
        Assert.assertEquals( dto.getMessageId(),          readDto.getMessageId());
        Assert.assertEquals( dto.getJsonMessage(),        readDto.getJsonMessage());
    }

    @Test
    public void testDelete() throws Exception
    {
        server.cleanDatabase();

        CrmCreateInvoiceRuleDao dao = new CrmCreateInvoiceRuleDao();
        CrmMessageDto           dto = new CrmMessageDto();

        Long id = dao.create( dto, "Entity");

        CrmMessageDto readDto = dao.read( id);

        Assert.assertNotNull( readDto);

        dao.delete( id);

        readDto = dao.read( id);

        Assert.assertNull( readDto);
    }

    @Test
    public void testUpdate() throws Exception
    {
        server.cleanDatabase();

        CrmCreateInvoiceRuleDao dao         = new CrmCreateInvoiceRuleDao();
        CrmMessageDto           originalDto = new CrmMessageDto();

        //
        // Create one message
        //
        String message = FileUtil.readFileFromClasspath( "json-examples/invoicing-rule-created-example.json").replace( "\n", " ");

        originalDto.setJsonMessage( message);

        Long id = dao.create( originalDto, "Entity");

        Assert.assertEquals( originalDto.getId(), id);
        Assert.assertFalse(  originalDto.isDeleted());
        Assert.assertFalse(  originalDto.isOutOfOrder());
        Assert.assertFalse(  originalDto.isSent());
        Assert.assertNull(   originalDto.getSendTime());
        Assert.assertNull(   originalDto.getMessageId());
        Assert.assertEquals( originalDto.getJsonMessage(), message);

        //
        // Update the message
        //
        String guid = UUID.randomUUID().toString();

        originalDto.setDeleted( true);
        originalDto.setJsonMessage( "Dummy Message");
        originalDto.setOutOfOrder( true);
        originalDto.setEventType( ProducerEventDbType.SEQUENCE);
        originalDto.setSent( true);
        originalDto.setMessageId( guid);

        dao.update( originalDto);

        //
        // Verify that everything modified has changed
        //
        CrmMessageDto readDto = dao.read( id);

        Assert.assertEquals( originalDto.getId(),              readDto.getId());
        Assert.assertEquals( originalDto.getAssociatedRowId(), readDto.getAssociatedRowId());
        Assert.assertEquals( originalDto.isSent(),             readDto.isSent());
        Assert.assertEquals( originalDto.isDeleted(),          readDto.isDeleted());
        Assert.assertEquals( originalDto.isOutOfOrder(),       readDto.isOutOfOrder());
        Assert.assertEquals( originalDto.getSendTime(),        readDto.getSendTime());
        Assert.assertEquals( originalDto.getDeleteTime(),      readDto.getDeleteTime());
        Assert.assertEquals( originalDto.getEventType(),       readDto.getEventType());
        Assert.assertEquals( originalDto.getMessageId(),       readDto.getMessageId());
        Assert.assertEquals( originalDto.getJsonMessage(),     readDto.getJsonMessage());
    }

    @Test
    public void testReadAll() throws Exception
    {
        server.cleanDatabase();

        CrmCreateInvoiceRuleDao dao  = new CrmCreateInvoiceRuleDao();
        CrmMessageDto           dto1 = new CrmMessageDto();
        CrmMessageDto           dto2 = new CrmMessageDto();

        dto1.setJsonMessage( FileUtil.readFileFromClasspath( "json-examples/invoicing-rule-created-example.json"));
        dto2.setJsonMessage( FileUtil.readFileFromClasspath( "json-examples/invoicing-rule-created-example.json"));

        Long id1 = dao.create( dto1, "Entity");
        Long id2 = dao.create( dto1, "Entity");

        List< CrmMessageDto> list = dao.readAll();

        Assert.assertEquals( 2, list.size());

        Assert.assertEquals( id1, list.get( 0).getId());
        Assert.assertEquals( id2, list.get( 1).getId());
    }

    @Test
    public void testReadAllAfter() throws Exception
    {
        server.cleanDatabase();

        CrmCreateInvoiceRuleDao dao  = new CrmCreateInvoiceRuleDao();
        CrmMessageDto           dto1 = new CrmMessageDto();
        CrmMessageDto           dto2 = new CrmMessageDto();

        dto1.setJsonMessage( FileUtil.readFileFromClasspath( "json-examples/invoicing-rule-created-example.json"));
        dto2.setJsonMessage( FileUtil.readFileFromClasspath( "json-examples/invoicing-rule-created-example.json"));

        Long id1 = dao.create( dto1, "Entity");

        Timestamp time = getTimeAndDelay();

        Long id2 = dao.create( dto1, "Entity" );

        List< CrmMessageDto> list = dao.readAllAfter( time);

        Assert.assertEquals( 1, list.size());

        Assert.assertEquals( id2, list.get( 0).getId());
    }

    @Test
    public void testReadNext() throws Exception
    {
        server.cleanDatabase();

        CrmCreateInvoiceRuleDao dao  = new CrmCreateInvoiceRuleDao();
        CrmMessageDto           dto1 = new CrmMessageDto();
        CrmMessageDto           dto2 = new CrmMessageDto();
        CrmMessageDto           dto3 = new CrmMessageDto();

        dto1.setJsonMessage( FileUtil.readFileFromClasspath( "json-examples/invoicing-rule-created-example.json"));
        dto2.setJsonMessage( FileUtil.readFileFromClasspath( "json-examples/invoicing-rule-created-example.json"));
        dto3.setJsonMessage( FileUtil.readFileFromClasspath( "json-examples/invoicing-rule-created-example.json"));

        dto1.setOutOfOrder( true);

        Long id1 = dao.create( dto1, "Entity" );
        Long id2 = dao.create( dto2, "Entity");
        Long id3 = dao.create( dto3, "Entity");

        CrmMessageDto readDto = dao.readNext( 5000L);

        Assert.assertEquals( id2, readDto.getId());


    }

    @Test
    public void testReadByEntity() throws Exception
    {
        server.cleanDatabase();

        CrmCreateInvoiceRuleDao dao  = new CrmCreateInvoiceRuleDao();
        CrmMessageDto           dto1 = new CrmMessageDto();

        dto1.setJsonMessage( FileUtil.readFileFromClasspath( "json-examples/invoicing-rule-created-example.json"));

        Long id1 = dao.create( dto1, "Entity1");
        Long id2 = dao.create( dto1, "Entity2");
        Long id3 = dao.create( dto1, "Entity1");

        List< CrmMessageDto> list = dao.readByEntityId( "Entity1" );

        Assert.assertEquals( 2, list.size());

        Assert.assertEquals( id1, list.get( 0).getId());
        Assert.assertEquals( id3, list.get( 1).getId());
    }

    @Test
    public void testReadLastByEntity() throws Exception
    {
        server.cleanDatabase();

        CrmCreateInvoiceRuleDao dao  = new CrmCreateInvoiceRuleDao();
        CrmMessageDto           dto1 = new CrmMessageDto();

        dto1.setJsonMessage( FileUtil.readFileFromClasspath( "json-examples/invoicing-rule-created-example.json"));

        Long id1 = dao.create( dto1, "Entity1");
        Long id2 = dao.create( dto1, "Entity2");
        Long id3 = dao.create( dto1, "Entity1");

        CrmMessageDto readDto = dao.readLastByEntityId( "Entity1");

        Assert.assertEquals( id3, readDto.getId());
    }

    @Test
    public void testReadNextOneDeleted() throws Exception
    {
        server.cleanDatabase();

        CrmCreateInvoiceRuleDao dao  = new CrmCreateInvoiceRuleDao();
        CrmMessageDto dto1 = new CrmMessageDto();
        CrmMessageDto dto2 = new CrmMessageDto();

        dto1.setJsonMessage( FileUtil.readFileFromClasspath( "json-examples/invoicing-rule-created-example.json"));
        dto2.setJsonMessage( FileUtil.readFileFromClasspath( "json-examples/invoicing-rule-created-example.json"));

        dto1.setDeleted( true);

        Long id1 = dao.create( dto1, "Entity");
        Long id2 = dao.create( dto2, "Entity");

        CrmMessageDto readDto = dao.readNext( 5000L);

        Assert.assertEquals( id2, readDto.getId());
    }

    @Test
    public void testVisibilityTimeout() throws Exception
    {
        server.cleanDatabase();

        CrmCreateInvoiceRuleDao dao = new CrmCreateInvoiceRuleDao();
        CrmMessageDto           dto = new CrmMessageDto();

        //
        // Put one message on the queue
        //
        dto.setJsonMessage( FileUtil.readFileFromClasspath( "json-examples/invoicing-rule-created-example.json"));

        Long id1 = dao.create( dto, "Entity");

        CrmMessageDto readDto = dao.readNext( 2000L);

        Assert.assertNotNull( readDto);

        //
        // "Send it" and wait for its reappearance
        //
        dto.setSent( true);
        dao.update( dto);

        long startTime = System.currentTimeMillis();

        do
        {
            readDto = dao.readNext( 2000L);
        }
        while( readDto == null);

        long endTime = System.currentTimeMillis() - startTime;

        Assert.assertTrue( Math.abs( endTime - 2000L) < 200L);
        Assert.assertNotNull( readDto);

        //
        // "Send" it again, delete it and wait for it to reappear, it should not ;-)
        //
        dto.setSent( true);
        dto.setDeleted( true);
        dao.update( dto);

        Thread.sleep( 3000L);

        readDto = dao.readNext( 2000L);

        Assert.assertNull( readDto);
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
