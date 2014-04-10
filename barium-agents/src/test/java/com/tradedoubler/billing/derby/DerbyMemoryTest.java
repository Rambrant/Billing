package com.tradedoubler.billing.derby;

import com.tradedoubler.billing.derby.dao.CrmCreateInvoiceRuleDao;
import com.tradedoubler.billing.derby.dao.CrmUpdateClientDao;
import com.tradedoubler.billing.derby.dao.EventLogDao;
import com.tradedoubler.billing.derby.dto.CrmMessageDto;
import com.tradedoubler.billing.derby.dto.EventLogDto;
import com.tradedoubler.billing.fetch.FlowName;
import com.tradedoubler.billing.type.EventLogType;
import com.tradedoubler.billing.util.ExecutionUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.UUID;

/**
 * @author Thomas Rambrant (thore)
 */

@Ignore
public class DerbyMemoryTest
{
    private static DerbyServer server;

    @Before
    public void setUp() throws Exception
    {
        server = ExecutionUtil.setupDatabase();
    }

    @After
    public void tearDown() throws Exception
    {
        ExecutionUtil.tearDownDatabase();
    }

    @Test
    public void updateRecordAndRetrieve() throws Exception
    {
        server.cleanDatabase();

        CrmCreateInvoiceRuleDao createDao = new CrmCreateInvoiceRuleDao();
        CrmUpdateClientDao      clientDao = new CrmUpdateClientDao();
        EventLogDao             eventDao  = new EventLogDao();

        while( true)
        {
            CrmMessageDto createDto = new CrmMessageDto();
            CrmMessageDto clientDto = new CrmMessageDto();
            EventLogDto   eventDto  = new EventLogDto();

            long createId = createDao.create( createDto, UUID.randomUUID().toString());
            long clientId = clientDao.create( createDto, UUID.randomUUID().toString());
            long eventId  = eventDao.create( EventLogType.DELETE, FlowName.UpdateClientCrm, "Test", "Test");

            createDao.update( createDto);
            clientDao.update( clientDto);

            createDto = createDao.read( createId);
            clientDto = clientDao.read( clientId);
        }
    }
}
