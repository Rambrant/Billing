package com.tradedoubler.billing.service.pan;

import com.google.gson.Gson;
import com.tradedoubler.billing.derby.dao.*;
import com.tradedoubler.billing.derby.dto.*;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.exception.BariumInternalCheckException;
import com.tradedoubler.billing.fetch.FlowName;
import com.tradedoubler.billing.platform.flowcontroller.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.crm.JsonMessage;
import com.tradedoubler.billing.transform.json.gson.GsonFactory;
import com.tradedoubler.billing.type.*;
import com.tradedoubler.billing.util.*;
import org.slf4j.*;

import java.sql.Date;
import java.util.*;

/**
 * @author Thomas Rambrant (thore)
 */

public class BariumPanServiceImpl implements PanService
{
    private final static Logger log  = LoggerFactory.getLogger( BariumPanServiceImpl.class);
    private static final Gson   gson = GsonFactory.getGson();

    private PanOrderLineDao     orderDao;
    private InvoicingCommandDao commandDao;
    private EventLogDao         eventDao;
    private ErrorLogDao         errorDao;
    private FailStateDao        failDao;

    public BariumPanServiceImpl() throws Exception
    {
        ExecutionUtil.setupDatabase();

        orderDao   = new PanOrderLineDao();
        commandDao = new InvoicingCommandDao();
        eventDao   = new EventLogDao();
        errorDao   = new ErrorLogDao();
        failDao    = new FailStateDao();
    }

    //
    // Make sure that this code is executed by the spring configuration. This is done using the
    // destroy-method="tearDownService" directive in the bean definition
    //
    public void tearDownService()
    {
        try
        {
            ExecutionUtil.tearDownDatabase();
        }
        catch( Exception e)
        {
            throw new BariumInternalCheckException( "Tearing down database", e);
        }
    }

    @Override
    public ServiceResult updateDisplayTradeDoublerCommission( ServiceResult serviceResult) throws BillingServiceException
    {
        //
        // Is the ServiceResult valid?
        //
        ServiceResultUtil.checkServiceResultForOutput( serviceResult, errorDao);

        //
        // Check for failure of this service?
        //
        ServiceResultUtil.checkServiceFailState( serviceResult, PanService.class.getSimpleName(), eventDao, failDao);

        //
        // Log the event
        //
        eventDao.create(
            EventLogType.RECEIVE,
            serviceResult.getFlowName(),
            IntegrationPointUtil.createId( PanService.class, "updateDisplayTradeDoublerCommission"),
            serviceResult.getIntegrationMessage().getMetaData().getMessageId().getGuid());

        ExecutionUtil.sleepForLoadSimulation( 400);

        return serviceResult;
    }

    @Override
    public ServiceResult fetchOrderLines( ServiceResult serviceResult) throws BillingServiceException
    {
        //
        // Is the ServiceResult valid?
        //
        ServiceResultUtil.checkServiceResultForInput( serviceResult, errorDao);

        //
        // Check for failure of this service?
        //
        ServiceResultUtil.checkServiceFailState( serviceResult, PanService.class.getSimpleName(), eventDao, failDao);

        //
        // Get some data to work on (If there are some, and we should do this...?)
        //
        InvoicingCommandDto commandDto = commandDao.readLatest();

        if( commandDto != null && commandDto.getStatus() == InvoicingStatusType.STARTED)
        {
            OrderLineDto orderLine  = orderDao.readNextBefore( commandDto.getCreated());

            if( orderLine == null)
            {
                //
                // Nothing to fetch. Set the status that triggers the invocation of the invoicing job
                //
                commandDao.create( InvoicingStatusType.RUNNING, commandDto.getTriggerAx());

                return serviceResult;
            }

            serviceResult = fillOrderLineServiceResult( serviceResult, orderLine);

            eventDao.create(
                EventLogType.SEND,
                serviceResult.getFlowName(),
                IntegrationPointUtil.createId( PanService.class, "fetchOrderLines"),
                orderLine.getBatchId());
        }

        return serviceResult;
    }

    @Override
    public ServiceResult confirmOrderLines( ServiceResult serviceResult) throws BillingServiceException
    {
        //
        // Is the ServiceResult valid?
        //
        ServiceResultUtil.checkServiceResultOnCommit( serviceResult, errorDao);

        //
        // Get the commit info with all the info we need for deletion. Check it before we continue
        //
        BariumPanMessageInfo messageInfo = (BariumPanMessageInfo) serviceResult.getCommitInfo();

        //
        // Shall this service fail?
        //
        ServiceResultUtil.checkServiceFailState( serviceResult, PanService.class.getSimpleName(), eventDao, failDao);

        //
        // Check the message
        //
        OrderLineDto dto = orderDao.read( messageInfo.getTableRowId());

        checkIntegrationMessage( serviceResult, dto);

        //
        // Update the status and log the event
        //
        dto.setHandled( true);

        orderDao.update( dto);

        eventDao.create(
            EventLogType.DELETE,
            serviceResult.getFlowName(),
            IntegrationPointUtil.createId( PanService.class, "confirmOrderLines"),
            serviceResult.getIntegrationMessage().getMetaData().getMessageId().getGuid());

        return serviceResult;
    }

    @Override
    public ServiceResult fetchReadyToInvoice( ServiceResult serviceResult) throws BillingServiceException
    {
        //
        // Is the ServiceResult valid?
        //
        ServiceResultUtil.checkServiceResultForInput( serviceResult, errorDao);

        //
        // Check for failure of this service?
        //
        ServiceResultUtil.checkServiceFailState( serviceResult, PanService.class.getSimpleName(), eventDao, failDao);

        //
        // Shall we try to trigger Ax
        //
        InvoicingCommandDto commandDto = commandDao.readLatest();

        if( commandDto != null && commandDto.getStatus() == InvoicingStatusType.RUNNING)


        //
        // Get some data to work on (If there are some, and we should do this...?)
        //

        if( commandDto != null && commandDto.getStatus() == InvoicingStatusType.RUNNING)
        {
            //
            // Shall we trigger AX at all?
            //
            if( commandDto.getTriggerAx())
            {
                fillReadyToInvoiceServiceResult( serviceResult);

                eventDao.create(
                    EventLogType.SEND,
                    serviceResult.getFlowName(),
                    IntegrationPointUtil.createId( PanService.class, "fetchReadyToInvoice"),
                    serviceResult.getIntegrationMessage().getMetaData().getMessageId().getGuid());
            }
        }

        return serviceResult;
    }

    @Override
    public ServiceResult confirmInvoicingStarted( ServiceResult serviceResult) throws BillingServiceException
    {
        //
        // Is the ServiceResult valid?
        //
        ServiceResultUtil.checkServiceResultOnCommit( serviceResult, errorDao);

        //
        // Get the commit info with all the info we need for confirmation
        //
        Boolean status = (Boolean) serviceResult.getCommitInfo();

        if( status != null && ! status.equals( true))
        {
            errorDao.create( "Confirmation of InvoicingStarted failed!");
            throw new BariumInternalCheckException( "Confirmation of InvoicingStarted failed!");
        }

        //
        // Shall this service fail?
        //
        ServiceResultUtil.checkServiceFailState( serviceResult, PanService.class.getSimpleName(), eventDao, failDao);

        //
        // make sure that we only signal the start of invoicing once
        //
        InvoicingCommandDto commandDto = commandDao.readLatest();

        commandDao.create( InvoicingStatusType.STOPPED, commandDto.getTriggerAx());

        //
        // Log the event
        //
        eventDao.create(
            EventLogType.DELETE,
            serviceResult.getFlowName(),
            IntegrationPointUtil.createId( PanService.class, "confirmInvoicingStarted"),
            serviceResult.getIntegrationMessage().getMetaData().getMessageId().getGuid());

        return serviceResult;
    }

    @Override
    public ServiceResult handleInvoiceForPan( ServiceResult serviceResult) throws BillingServiceException
    {
        return null;  //TODO
    }

    @Override
    public ServiceResult fetchPrepaymentForecastOrderLines(ServiceResult serviceResult) throws BillingServiceException
    {
        //TODO implement this
        return serviceResult;
    }

    @Override
    public ServiceResult confirmForecastOrderLines( ServiceResult serviceResult) throws BillingServiceException
    {
        //TODO implement this
        return serviceResult;
    }

    private ServiceResult fillOrderLineServiceResult( ServiceResult serviceResult, OrderLineDto dto)
    {
        if( log.isInfoEnabled())
        {
            log.info(
                "***** [" + serviceResult.getFlowName() + "] " +
                    "(" + Calendar.getInstance().getTime() + ") " +
                    "Data = " + dto.toString());
        }
        else
        {
            System.out.print(
                "\t***** [" + serviceResult.getFlowName() + "] " +
                    "(" + Calendar.getInstance().getTime() + ") " +
                    "Data = " + dto.toString() + "\n");
        }

        //
        // Create the integration message
        //
        List< OrderLine> orderLines = new ArrayList< OrderLine>();

        long lineId = Long.valueOf( dto.getOrderLineId());

        for( int i = 0; i < dto.getNumOrderLines(); ++i)
        {
            OrderLine orderLine = gson.fromJson( dto.getJsonOrderLine(), OrderLine.class);

            orderLine.setOrderLineId( String.valueOf( lineId + i));

            orderLines.add( orderLine);
        }

        if( dto.getEventType() == ProducerEventDbType.SYNTAX)
        {
            //
            // Make the first orderLine fail the validation
            //
            orderLines.get( 0).setQuantity( 0);
        }

        if( dto.getEventType() == ProducerEventDbType.ILLEGAL)
        {
            //
            // Make the second orderLine fail insertion in Ax
            //
            if( orderLines.size() > 1)
            {
                orderLines.get( 1).setOrderLineId( orderLines.get( 0).getOrderLineId());
            }
            else
            {
                errorDao.create( "Too few lines to allow ILLEGAL events on OrderLines");
            }
        }

        //
        // Create the integration message
        //
        MetaData metadata = new MetaData(
            FlowName.CreateOrderLinesPan.name(),
            new Guid( dto.getBatchId()),
            new Timestamp( new Date( dto.getCreated().getTime())),
            "1.0",
            "PAN");

        OrderLinesCreated message = new OrderLinesCreated(
            metadata,
            orderLines,
            new Guid( dto.getBatchId()));

        IntegrationMessage integrationMessage = new IntegrationMessage(
            message.getBatchId().toString(),
            message.getMetaData());

        integrationMessage.setDomainObject( message);

        //
        // Create the raw data. In this case a json string
        //
        JsonMessage json = new JsonMessage( gson.toJson( message));

        //
        // Create the commit info that will help us through the flow
        //
        BariumPanMessageInfo commitInfo = new BariumPanMessageInfo(
            dto.getBatchId(),
            dto.getId(),
            dto.getEventType());

        //
        // Set a proper serviceResult to return
        //
        serviceResult.setCommitInfo( commitInfo);
        serviceResult.setRawData( json);
        serviceResult.setIntegrationMessage( integrationMessage);

        return serviceResult;
    }

    private ServiceResult fillReadyToInvoiceServiceResult( ServiceResult serviceResult)
    {
        if( log.isInfoEnabled())
        {
            log.info(
                "***** [" + serviceResult.getFlowName() + "] " +
                    "(" + Calendar.getInstance().getTime() + ")");
        }
        else
        {
            System.out.print(
                "\t***** [" + serviceResult.getFlowName() + "] " +
                    "(" + Calendar.getInstance().getTime() + ")\n");
        }

        //
        // Create the integration message
        //
        MetaData metadata = new MetaData(
            FlowName.CreateOrderLinesPan.name(),
            new Guid( UUID.randomUUID().toString()),
            new Timestamp( new Date( System.currentTimeMillis())),
            "1.0",
            "PAN");

        ReadyToInvoice readyToInvoice = ReadyToInvoice.createReadyToInvoice( metadata);

        IntegrationMessage integrationMessage = new IntegrationMessage(
            readyToInvoice.getMetaData().getMessageId().getGuid(),
            readyToInvoice.getMetaData());

        integrationMessage.setDomainObject( readyToInvoice);

        //
        // Create the raw data. In this case a json string
        //
        JsonMessage json = new JsonMessage( gson.toJson( readyToInvoice));

        //
        // Set a proper serviceResult to return
        //
        serviceResult.setCommitInfo( true);
        serviceResult.setRawData( json);
        serviceResult.setIntegrationMessage( integrationMessage);

        return serviceResult;
    }

    private void checkIntegrationMessage( ServiceResult serviceResult, OrderLineDto dto)
    {
        if( dto == null)
        {
            errorDao.create( "Order Lines to confirm does not exist in PAN " + dto);
            throw new BariumInternalCheckException( "Order Lines to confirm does not exist in PAN");
        }

        OrderLinesCreated message = (OrderLinesCreated) serviceResult.getIntegrationMessage().getDomainObject();

        if( ! dto.getBatchId().equals( message.getBatchId().toString()))
        {
            errorDao.create( "Wrong batchId on confirm! " + serviceResult);
            throw new BariumInternalCheckException( "Wrong batchId on confirm! " + serviceResult);
        }

        if( dto.getNumOrderLines() != message.getOrderLines().size())
        {
            errorDao.create( "Wrong number of order lines on confirm! " + serviceResult);
            throw new BariumInternalCheckException( "Wrong number of order lines on confirm! " + serviceResult);
        }

        //
        // Check of returned lines... have anyone failed?
        //
        int errorNum = 0;

        for( OrderLine orderLine: message.getOrderLines())
        {
            if( orderLine.getStatus() != OrderLineStatus.SENT_TO_AX_SUCCEEDED)
            {
                ++errorNum;
            }
        }

        switch( dto.getEventType())
        {
        case NONE:
        case CREATE:

            if( errorNum != 0)
            {
                errorDao.create( "No failed row allowed on Confirm! (EventType: " + dto.getEventType() + ")");
                throw new BariumInternalCheckException( "No failed row allowed on Confirm! (EventType: " + dto.getEventType() + ")");
            }

            break;

        case SYNTAX:

            if( errorNum == 0)
            {
                errorDao.create( "At least one failed row on Confirm! (EventType: " + dto.getEventType() + ")");
                throw new BariumInternalCheckException( "At least one failed row on Confirm! (EventType: " + dto.getEventType() + ")");
            }
            break;

        case ILLEGAL:

            if( errorNum == 0 && message.getOrderLines().size() > 1)
            {
                errorDao.create( "At least one failed row on Confirm! (EventType: " + dto.getEventType() + ")");
                throw new BariumInternalCheckException( "At least one failed row on Confirm! (EventType: " + dto.getEventType() + ")");
            }
            break;

        case SEQUENCE:
        case ORDER:

            //
            // These should never come here
            //
            errorDao.create( "Illegal eventType in commit: " + dto.getEventType());
            throw new BariumInternalCheckException( "Illegal eventType in commit: " + dto.getEventType());
        }

    }

    @Override
    public ServiceResult fetchCreatedInvoicingRule(ServiceResult serviceResult) throws BillingServiceException {
        // TODO needs to be implemented to run reseller create invoicing rule flow
        return serviceResult;
    }

    @Override
    public ServiceResult confirmInvoicingRuleProcessed(ServiceResult serviceResult) throws BillingServiceException {
        // TODO needs to be implemented to commit reseller create/update invoicing rule flows
        return serviceResult;
    }

    @Override
    public ServiceResult fetchUpdatedInvoicingRule(ServiceResult serviceResult) throws BillingServiceException {
        // TODO needs to be implemented to run reseller update invoicing rule flow
        return serviceResult;
    }

    @Override
    public ServiceResult fetchResellerClient(ServiceResult serviceResult) throws BillingServiceException {
        //TODO implement this
        return serviceResult;
    }

    @Override
    public ServiceResult confirmResellerClientProcessed(ServiceResult serviceResult) throws BillingServiceException {
        //TODO implement this
        return serviceResult;
    }

}

