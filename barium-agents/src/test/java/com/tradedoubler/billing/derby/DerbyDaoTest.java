package com.tradedoubler.billing.derby;

import com.tradedoubler.billing.derby.dao.DerbyTestDao;
import com.tradedoubler.billing.derby.dto.DerbyTestDto;
import com.tradedoubler.billing.util.ExecutionUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Thomas Rambrant (thore)
 */

@SuppressWarnings( { "RedundantIfStatement" })
public class DerbyDaoTest
{
    private static DerbyServer server;
    private static DataSource  derbyDataSource;

    @Before
    public void setUp() throws Exception
    {
        DerbyProperties properties = new DerbyProperties();

        server = ExecutionUtil.setupDatabase();

        derbyDataSource = new DerbyDataSource( properties);
    }

    @After
    public void tearDown() throws Exception
    {
        ExecutionUtil.tearDownDatabase();
    }

    @Test
    public void multipleCreateShallSucceed() throws Exception
    {
        server.cleanDatabase();

        Assert.assertFalse(
            "table should not exist",
            DerbyUtil.isTableCreated( derbyDataSource.getConnection(), DerbyTestDao.TABLE_NAME));

        DerbyTestDao testDao = new DerbyTestDao();

        Assert.assertTrue(
            "table should exist",
            DerbyUtil.isTableCreated( derbyDataSource.getConnection(), DerbyTestDao.TABLE_NAME));

        DerbyTestDao secondTestDao = new DerbyTestDao();

        Assert.assertTrue(
            "table should still exist",
            DerbyUtil.isTableCreated( derbyDataSource.getConnection(), DerbyTestDao.TABLE_NAME));
    }

    @Test
    public void insertRecordsCheckSequenceNumber() throws Exception
    {
        server.cleanDatabase();

        DerbyTestDao testDao = new DerbyTestDao();
        DerbyTestDto testDto = new DerbyTestDto();

        testDto.setName( "Nisse");

        Long id  = testDao.create( testDto);
        Long id2 = testDao.create( testDto);

        Assert.assertEquals( 1L, id.longValue());
        Assert.assertEquals( 2L, id2.longValue());
    }

    @Test
    public void insertRecordAndRetrieve() throws Exception
    {
        server.cleanDatabase();

        DerbyTestDao testDao   = new DerbyTestDao();
        DerbyTestDto createDto = new DerbyTestDto();

        createDto.setName( "Nisse");

        Long id = testDao.create( createDto);

        DerbyTestDto retrievedDto = testDao.read( id);

        Assert.assertTrue(
            "The retrieved dto should contain the same data as the created",
            isDerbyDtoEqual( retrievedDto, createDto));
    }

    @Test
    public void updateRecordAndRetrieve() throws Exception
    {
        server.cleanDatabase();

        DerbyTestDao testDao   = new DerbyTestDao();
        DerbyTestDto createDto = new DerbyTestDto();
        DerbyTestDto updateDto = new DerbyTestDto();

        createDto.setName( "Nisse");
        updateDto.setName( "Pelle");

        Long id = testDao.create( createDto);

        updateDto.setId( id);
        testDao.update( updateDto);

        DerbyTestDto retrievedDto = testDao.read( id);

        Assert.assertFalse(
            "The created dto should not contain the same data as the retrieved",
            isDerbyDtoEqual( retrievedDto, createDto));

        Assert.assertTrue(
            "The retrieved dto should contain the same data as the retrieved",
            isDerbyDtoEqual( retrievedDto, updateDto));
    }

    @Test
    public void insertRecordsAndRetrieveAll() throws Exception
    {
        server.cleanDatabase();

        DerbyTestDao testDao    = new DerbyTestDao();
        DerbyTestDto createDto1 = new DerbyTestDto();
        DerbyTestDto createDto2 = new DerbyTestDto();
        DerbyTestDto createDto3 = new DerbyTestDto();

        createDto1.setName( "Nisse");
        createDto2.setName( "Pelle");
        createDto3.setName( "Kalle");

        testDao.create( createDto1);
        testDao.create( createDto2);
        testDao.create( createDto3);

        List< DerbyTestDto> retrievedDtos = testDao.readAll();

        Assert.assertEquals(
            "The number of retrieved Dtos should match the number of created",
            3,
            retrievedDtos.size());

        Assert.assertTrue( isDerbyDtoEqual( createDto1, retrievedDtos.get( 0)));
        Assert.assertTrue( isDerbyDtoEqual( createDto2, retrievedDtos.get( 1)));
        Assert.assertTrue( isDerbyDtoEqual( createDto3, retrievedDtos.get( 2)));
    }

    @Test
    public void insertRecordsAndRetrieveAllAfterTime() throws Exception
    {
        server.cleanDatabase();

        DerbyTestDao testDao    = new DerbyTestDao();
        DerbyTestDto createDto1 = new DerbyTestDto();
        DerbyTestDto createDto2 = new DerbyTestDto();
        DerbyTestDto createDto3 = new DerbyTestDto();

        createDto1.setName( "Nisse");
        createDto2.setName( "Pelle");
        createDto3.setName( "Kalle");

        testDao.create( createDto1);

        Timestamp time = getTimeAndDelay();

        testDao.create( createDto2);
        testDao.create( createDto3);

        List< DerbyTestDto> retrievedDtos = testDao.readAllAfter( time);

        Assert.assertEquals(
            "The number of retrieved Dtos should match the number of created",
            2,
            retrievedDtos.size());

        Assert.assertTrue( isDerbyDtoEqual( createDto2, retrievedDtos.get( 0)));
        Assert.assertTrue( isDerbyDtoEqual( createDto3, retrievedDtos.get(1)));
    }

    @Test
    public void insertRecordAndDeleteShouldGiveNoResult() throws Exception
    {
        server.cleanDatabase();

        DerbyTestDao testDao   = new DerbyTestDao();
        DerbyTestDto createDto = new DerbyTestDto();

        createDto.setName( "Kalle");

        Long id = testDao.create( createDto);

        DerbyTestDto retrievedDto = testDao.read( id);

        Assert.assertNotNull(
            "The retrieved dto should contain data",
            retrievedDto);

        testDao.delete( id);

        DerbyTestDto emptyDto = testDao.read( id);

        Assert.assertNull(
            "The retrieved dto should be empty",
            emptyDto);

        List< DerbyTestDto> list = testDao.readAll();

        Assert.assertNotNull(
            "The retrieved list should exist",
            list);

        Assert.assertTrue(
            "The retrieved list should be empty",
            list.isEmpty());
    }

    private boolean isDerbyDtoEqual( DerbyTestDto a, DerbyTestDto b)
    {
        if( a.getId() != null ? ! a.getId().equals( b.getId()) : b.getId() != null)
        {
            return false;
        }

        if( a.getName() != null ? ! a.getName().equals( b.getName()) : b.getName() != null)
        {
            return false;
        }

        return true;
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
