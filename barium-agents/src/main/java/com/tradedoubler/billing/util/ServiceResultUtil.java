package com.tradedoubler.billing.util;

import com.tradedoubler.billing.derby.dao.ErrorLogDao;
import com.tradedoubler.billing.derby.dao.EventLogDao;
import com.tradedoubler.billing.derby.dao.FailStateDao;
import com.tradedoubler.billing.derby.dto.CrmMessageDto;
import com.tradedoubler.billing.derby.dto.OrderLineDto;
import com.tradedoubler.billing.domain.OrderLine;
import com.tradedoubler.billing.domain.OrderLinesCreated;
import com.tradedoubler.billing.exception.BariumInternalCheckException;
import com.tradedoubler.billing.platform.flowcontroller.IntegrationMessage;
import com.tradedoubler.billing.platform.flowcontroller.ServiceResult;
import com.tradedoubler.billing.platform.logging.LogError;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.crm.BariumCrmMessageInfo;
import com.tradedoubler.billing.service.pan.BariumPanMessageInfo;
import com.tradedoubler.billing.type.EventLogType;
import com.tradedoubler.billing.type.ProducerEventDbType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Thomas Rambrant (thore)
 */

public class ServiceResultUtil
{
    private final static Logger log = LoggerFactory.getLogger( ServiceResultUtil.class);

    public static void checkServiceResultForInput(
        ServiceResult serviceResult,
        ErrorLogDao   errorDao)
    {
        if( serviceResult.isDisturbance())
        {
            errorDao.create( "There should be no disturbance entering a service" + serviceResult);
            throw new BariumInternalCheckException( "There should be no disturbance entering a service" + serviceResult);
        }

        if( serviceResult.getCommitInfo() != null)
        {
            errorDao.create( "Commit info should not exist entering a input service" + serviceResult);
            throw new BariumInternalCheckException( "Commit info should not exist entering a input service" + serviceResult);
        }

        if( serviceResult.isDataToProcess())
        {
            errorDao.create( "Raw data should not exist entering an input service" + serviceResult);
            throw new BariumInternalCheckException( "Raw data should not exist entering an input service" + serviceResult);
        }

        if( serviceResult.getIntegrationMessage() != null)
        {
            errorDao.create( "An integration message should not exist entering an input service" + serviceResult);
            throw new BariumInternalCheckException( "An integration message should not exist entering an input service" + serviceResult);
        }
    }

    public static void checkServiceResultForOutput(
        ServiceResult serviceResult,
        ErrorLogDao   errorDao)
    {
        if( serviceResult.isDisturbance())
        {
            errorDao.create( "There should be no disturbance entering an output service");
            throw new BariumInternalCheckException( "There should be no disturbance entering an output service");
        }

        if( serviceResult.getCommitInfo() == null)
        {
            errorDao.create( "Commit info should exist entering an output service");
            throw new BariumInternalCheckException( "Commit info should exist entering an output service");
        }

        if( ! serviceResult.isDataToProcess())
        {
            errorDao.create( "Raw data should exist entering an output service");
            throw new BariumInternalCheckException( "Raw data should exist entering an output service");
        }

        if( serviceResult.getIntegrationMessage() == null)
        {
            errorDao.create( "An integration message should exist entering an output service");
            throw new BariumInternalCheckException( "An integration message should exist entering an output service");
        }
    }

    public static void checkServiceResultOnCommit(
        ServiceResult serviceResult,
        ErrorLogDao   errorDao)
    {
        if( serviceResult.isDisturbance())
        {
            errorDao.create( "There should be no disturbance when committing" + serviceResult);
            throw new BariumInternalCheckException( "There should be no disturbance when committing" + serviceResult);
        }

        if( serviceResult.getCommitInfo() == null)
        {
            errorDao.create( "Commit info should exist entering when committing" + serviceResult);
            throw new BariumInternalCheckException( "Commit info should exist entering when committing" + serviceResult);
        }

        if( ! serviceResult.isDataToProcess())
        {
            errorDao.create( "Raw data should exist when committing" + serviceResult);
            throw new BariumInternalCheckException( "Raw data should exist when committing" + serviceResult);
        }

        if( serviceResult.getIntegrationMessage() == null)
        {
            errorDao.create( "An integration message should exist entering on committing" + serviceResult);
            throw new BariumInternalCheckException( "An integration message should exist entering on committing" + serviceResult);
        }
    }

    public static void checkServiceFailState(
        ServiceResult serviceResult,
        String        serviceName,
        EventLogDao   eventDao,
        FailStateDao  failDao) throws BillingServiceException
    {
        if( failDao.isInFailState( serviceName))
        {
            //
            // Log the event
            //
            String guid = "";

            if( serviceResult.getIntegrationMessage() != null)
            {
                guid = serviceResult.getIntegrationMessage().getMetaData().getMessageId().getGuid();
            }

            eventDao.create( EventLogType.DISTURB, serviceResult.getFlowName(), serviceName, guid);

            //
            // Throw this instead of the proper Exception. This is the pragmatic approach to avoid more
            // throw clauses since I can't make them unchecked
            //
            sleepForLoadSimulation( 15000);

            throw BillingServiceException.createIntegrationDisturbance(
                serviceName + " failed! (" + new Date() + ")",
                0);
        }
    }

    public static void checkMessageOnCommit(
        ServiceResult       serviceResult,
        ProducerEventDbType eventType,
        ErrorLogDao         errorDao)
    {
        switch( eventType)
        {
        case NONE:
        case CREATE:

            //
            // This is ok...
            //
            break;

        case SEQUENCE:

            IntegrationMessage integrationMessage = serviceResult.getIntegrationMessage();

            if( integrationMessage.isOutOfSequence())
            {
                //
                // We delete this to get rid of it not because we are ready with it...
                // This is correct for this error state. If not out of sequence, signal an error
                //
                break;
            }

        case ORDER:
        case SYNTAX:
        case ILLEGAL:

            //
            // These should never come here
            //
            errorDao.create( "Illegal eventType in commit: " + eventType);
            throw new BariumInternalCheckException( "Illegal eventType in commit: " + eventType);
        }
    }

    public static ServiceResult fillServiceResultForCrm(
        String               serviceName,
        ServiceResult        serviceResult,
        BariumCrmMessageInfo messageInfo,
        CrmMessageDto        dto,
        ErrorLogDao          errorDao) throws BillingServiceException
    {
        if( dto == null)
        {
            errorDao.create(
                "\"Queue\" item '" + messageInfo.getTableRowId() + "' not found in DB");

            throw new BariumInternalCheckException(
                "\"Queue\" item '" + messageInfo.getTableRowId() + "' not found in DB");
        }

        switch( dto.getEventType())
        {
        case NONE:
        case CREATE:

            //
            // Check the content...
            //
            if( ! dto.getJsonMessage().equals( (serviceResult.getRawData()).toString()))
            {
                errorDao.create(
                    "Data not equal (" + serviceResult.getFlowName() + "): " + serviceResult.toStringShort());

                throw new BariumInternalCheckException(
                    "Data not equal (" + serviceResult.getFlowName() + "): " + serviceResult.toStringShort());
            }

            break;

        case ILLEGAL:

            sleepForLoadSimulation( 25000);
            throw BillingServiceException.createBugDisturbance(
                "Illegal data! (" + serviceResult.getFlowName() + ")",
                0);

        case SEQUENCE:
        case SYNTAX:

            //
            // These should never come here
            //
            errorDao.create(
                "Illegal state in " + serviceName + " (" + serviceResult.getFlowName() + "): " + dto.getEventType());

            throw new BariumInternalCheckException(
                "Illegal state in " + serviceName + " (" + serviceResult.getFlowName() + "): " + dto.getEventType());

        case ORDER:

            //
            // This should already been handled
            //
            break;
        }

        return serviceResult;
    }

    public static ServiceResult fillServiceResultForPan(
        String               serviceName,
        ServiceResult        serviceResult,
        BariumPanMessageInfo messageInfo,
        OrderLineDto         dto,
        ErrorLogDao          errorDao) throws BillingServiceException
    {
        if( dto == null)
        {
            errorDao.create(
                "\"Pan\" order lines '" + messageInfo.getTableRowId() + "' not found in DB");

            throw new BariumInternalCheckException(
                "\"Pan\" order lines '" + messageInfo.getTableRowId() + "' not found in DB");
        }

        switch( dto.getEventType())
        {
        case NONE:
        case CREATE:
        case SYNTAX:
        case ILLEGAL:

            //
            // Check the content...
            //
            if( ! dto.getBatchId().equals( serviceResult.getIntegrationMessage().getEntityId()))
            {
                errorDao.create( "EntityId (BatchId) is wrong! " + serviceResult);
                throw new BariumInternalCheckException( "EntityId (BatchId) is wrong! " + serviceResult);
            }

            //
            // Set state on received orders
            //
            OrderLinesCreated payload   = (OrderLinesCreated) serviceResult.getIntegrationMessage().getDomainObject();
            int               numErrors = 0;

            numErrors = setOrderLineResultStatus( payload.getOrderLines());

            //
            // Adjust the number of orderLines to be saved
            //
            long lineId = Long.valueOf( dto.getOrderLineId());

            dto.setNumOrderLines( dto.getNumOrderLines() - numErrors);
            dto.setOrderLineId( String.valueOf( lineId + numErrors));

            break;

        case SEQUENCE:

            //
            // These should never come here
            //
            errorDao.create(
                "Illegal state in " + serviceName + " (" + serviceResult.getFlowName() + "): " + dto.getEventType());

            throw new BariumInternalCheckException(
                "Illegal state in " + serviceName + " (" + serviceResult.getFlowName() + "): " + dto.getEventType());

        case ORDER:

            //
            // This should already been handled
            //
            break;
        }

        sleepForLoadSimulation( 2500);

        return serviceResult;
    }

    private static int setOrderLineResultStatus( List< OrderLine> orderLines)
    {
        List< String> seenOrderLineIds = new ArrayList< String>();
        int           errorCount       = 0;

        for( OrderLine orderLine : orderLines)
        {
            //
            // Set the default value that we have succeeded to store the lines in Ax
            //
            orderLine.setSentToAxSucceeded();

            //
            // Set the appropriate error status
            //
            if( orderLine.getQuantity() == 0)
            {
                orderLine.setValidationFailed( "Quantity can't be 0 [BariumAxServiceImpl]");
                log.error( LogError.OPERATIONAL_DISTURBANCE.name() + "-" + "Quantity can't be 0 [BariumAxServiceImpl]");

                ++errorCount;
            }

            if( seenOrderLineIds.contains( orderLine.getOrderLineId()))
            {
                orderLine.setSentToAxFailed( "Duplicated orderLineId [BariumAxServiceImpl]");
                log.error( LogError.OPERATIONAL_DISTURBANCE.name() + "-" + "Duplicated orderLineId [BariumAxServiceImpl]");

                ++errorCount;
            }

            seenOrderLineIds.add( orderLine.getOrderLineId());
        }

        return errorCount;
    }

    private static void sleepForLoadSimulation( int sleepTimeMs)
    {
        try
        {
            Thread.sleep( sleepTimeMs);
        }
        catch( InterruptedException e)
        {
            //
            // Not much to do here
            //
        }
    }
}