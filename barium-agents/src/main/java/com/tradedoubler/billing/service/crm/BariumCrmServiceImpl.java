package com.tradedoubler.billing.service.crm;

import com.tradedoubler.billing.derby.dao.*;
import com.tradedoubler.billing.derby.dto.CrmMessageDto;
import com.tradedoubler.billing.exception.BariumInternalCheckException;
import com.tradedoubler.billing.platform.flowcontroller.ServiceResult;
import com.tradedoubler.billing.property.BillingIntegrationProperties;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.type.CrmQueueType;
import com.tradedoubler.billing.type.EventLogType;
import com.tradedoubler.billing.util.ExecutionUtil;
import com.tradedoubler.billing.util.IntegrationPointUtil;
import com.tradedoubler.billing.util.ServiceResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;

/**
 * @author Thomas Rambrant (thore)
 */

public class BariumCrmServiceImpl implements CrmService
{
    private final static Logger log = LoggerFactory.getLogger( BariumCrmServiceImpl.class);
    private final long VISIBILITY_PERIOD_MS;

    private EventLogDao                  eventDao;
    private ErrorLogDao                  errorDao;
    private FailStateDao                 failDao;
    private CrmCreateInvoiceRuleDao      createRuleDao;
    private CrmUpdateInvoiceRuleDao      updateRuleDao;
    private CrmUpdateClientDao           updateClientDao;
    private CrmUpdateAgreementDao        updateAgreementDao;
    private CrmUpdateMarketMessageDao    updateMarketMessageDao;
    private CrmDeleteSplittingRuleDao    deleteSplittingRuleDao;
    private CrmDeleteInvoiceRecipientDao deleteInvoiceRecipientDao;

    public BariumCrmServiceImpl() throws Exception
    {
        ExecutionUtil.setupDatabase();

        this.VISIBILITY_PERIOD_MS = new BillingIntegrationProperties().getAzureVisibilityTimeoutSec() * 1000L;

        eventDao                  = new EventLogDao();
        errorDao                  = new ErrorLogDao();
        failDao                   = new FailStateDao();
        createRuleDao             = new CrmCreateInvoiceRuleDao();
        updateRuleDao             = new CrmUpdateInvoiceRuleDao();
        updateClientDao           = new CrmUpdateClientDao();
        updateAgreementDao        = new CrmUpdateAgreementDao();
        updateMarketMessageDao    = new CrmUpdateMarketMessageDao();
        deleteSplittingRuleDao    = new CrmDeleteSplittingRuleDao();
        deleteInvoiceRecipientDao = new CrmDeleteInvoiceRecipientDao();
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
            e.printStackTrace();
        }
    }

    @Override
    public ServiceResult fetchInvoicingRuleCreated( ServiceResult serviceResult) throws BillingServiceException
    {
        //
        // Is the ServiceResult valid?
        //
        ServiceResultUtil.checkServiceResultForInput( serviceResult, errorDao);

        //
        // Check for failure of this service?
        //
        ServiceResultUtil.checkServiceFailState( serviceResult, CrmService.class.getSimpleName(), eventDao, failDao);

        //
        // Read messages from the "queue" and do what they say...
        //
        CrmMessageDto dto = createRuleDao.readNext( VISIBILITY_PERIOD_MS);

        if( dto != null)
        {
            serviceResult = fillServiceResult( serviceResult, dto, CrmQueueType.INVOICING_RULE_CREATED);

            dto.setSent( true);

            createRuleDao.update( dto);

            eventDao.create(
                EventLogType.SEND,
                serviceResult.getFlowName(),
                IntegrationPointUtil.createId( CrmService.class, "fetchInvoicingRuleCreated"),
                dto.getMessageId());

            return serviceResult;
        }

        return serviceResult;
    }

    @Override
    public ServiceResult fetchInvoicingRuleUpdated( ServiceResult serviceResult) throws BillingServiceException
    {
        //
        // Is the ServiceResult valid?
        //
        ServiceResultUtil.checkServiceResultForInput( serviceResult, errorDao);

        //
        // Check for failure of this service?
        //
        ServiceResultUtil.checkServiceFailState( serviceResult, CrmService.class.getSimpleName(), eventDao, failDao);

        //
        // Read messages from the "queue" and do what they say...
        //
        CrmMessageDto dto = updateRuleDao.readNext( VISIBILITY_PERIOD_MS);

        if( dto != null)
        {
            serviceResult = fillServiceResult( serviceResult, dto, CrmQueueType.INVOICING_RULE_UPDATED);

            dto.setSent( true);

            updateRuleDao.update( dto);

            eventDao.create(
                EventLogType.SEND,
                serviceResult.getFlowName(),
                IntegrationPointUtil.createId( CrmService.class, "fetchInvoicingRuleUpdated"),
                dto.getMessageId());

            return serviceResult;
        }

        return serviceResult;
    }

    @Override
    public ServiceResult fetchClientUpdated( ServiceResult serviceResult) throws BillingServiceException
    {
        //
        // Is the ServiceResult valid?
        //
        ServiceResultUtil.checkServiceResultForInput( serviceResult, errorDao);

        //
        // Check for failure of this service?
        //
        ServiceResultUtil.checkServiceFailState( serviceResult, CrmService.class.getSimpleName(), eventDao, failDao);

        //
        // Read messages from the "queue" and do what they say...
        //
        CrmMessageDto dto = updateClientDao.readNext( VISIBILITY_PERIOD_MS);

        if( dto != null)
        {
            serviceResult = fillServiceResult( serviceResult, dto, CrmQueueType.CLIENT_UPDATED);

            dto.setSent( true);

            updateClientDao.update( dto);

            eventDao.create(
                EventLogType.SEND,
                serviceResult.getFlowName(),
                IntegrationPointUtil.createId( CrmService.class, "fetchClientUpdated"),
                dto.getMessageId());

            return serviceResult;
        }

        return serviceResult;
    }

    @Override
    public ServiceResult fetchAgreementUpdated( ServiceResult serviceResult) throws BillingServiceException
    {
        //
        // Is the ServiceResult valid?
        //
        ServiceResultUtil.checkServiceResultForInput( serviceResult, errorDao);

        //
        // Check for failure of this service?
        //
        ServiceResultUtil.checkServiceFailState( serviceResult, CrmService.class.getSimpleName(), eventDao, failDao);

        //
        // Read messages from the "queue" and do what they say...
        //
        CrmMessageDto dto = updateAgreementDao.readNext( VISIBILITY_PERIOD_MS);

        if( dto != null)
        {
            serviceResult = fillServiceResult( serviceResult, dto, CrmQueueType.AGREEMENT_UPDATED);

            dto.setSent( true);

            updateAgreementDao.update( dto);

            eventDao.create(
                EventLogType.SEND,
                serviceResult.getFlowName(),
                IntegrationPointUtil.createId( CrmService.class, "fetchAgreementUpdated"),
                dto.getMessageId());

            return serviceResult;
        }

        return serviceResult;
    }

    @Override
    public ServiceResult fetchSplittingRuleDeleted( ServiceResult serviceResult) throws BillingServiceException
    {
        //
        // Is the ServiceResult valid?
        //
        ServiceResultUtil.checkServiceResultForInput( serviceResult, errorDao);

        //
        // Check for failure of this service?
        //
        ServiceResultUtil.checkServiceFailState( serviceResult, CrmService.class.getSimpleName(), eventDao, failDao);

        //
        // Read messages from the "queue" and do what they say...
        //
        CrmMessageDto dto = deleteSplittingRuleDao.readNext( VISIBILITY_PERIOD_MS);

        if( dto != null)
        {
            serviceResult = fillServiceResult( serviceResult, dto, CrmQueueType.SPLITTING_RULE_DELETED);

            dto.setSent( true);

            deleteSplittingRuleDao.update( dto);

            eventDao.create(
                EventLogType.SEND,
                serviceResult.getFlowName(),
                IntegrationPointUtil.createId( CrmService.class, "fetchSplittingRuleDeleted"),
                dto.getMessageId());

            return serviceResult;
        }

        return serviceResult;
    }

    @Override
    public ServiceResult fetchInvoiceRecipientDeleted( ServiceResult serviceResult) throws BillingServiceException
    {
        //
        // Is the ServiceResult valid?
        //
        ServiceResultUtil.checkServiceResultForInput( serviceResult, errorDao);

        //
        // Check for failure of this service?
        //
        ServiceResultUtil.checkServiceFailState( serviceResult, CrmService.class.getSimpleName(), eventDao, failDao);

        //
        // Read messages from the "queue" and do what they say...
        //
        CrmMessageDto dto = deleteInvoiceRecipientDao.readNext( VISIBILITY_PERIOD_MS);

        if( dto != null)
        {
            serviceResult = fillServiceResult( serviceResult, dto, CrmQueueType.INVOICE_RECIPIENT_DELETED);

            dto.setSent( true);

            deleteInvoiceRecipientDao.update( dto);

            eventDao.create(
                EventLogType.SEND,
                serviceResult.getFlowName(),
                IntegrationPointUtil.createId( CrmService.class, "fetchInvoiceRecipientDeleted"),
                dto.getMessageId());

            return serviceResult;
        }

        return serviceResult;
    }

    @Override
    public ServiceResult fetchMarketMessageUpdated( ServiceResult serviceResult) throws BillingServiceException
    {
        //
        // Is the ServiceResult valid?
        //
        ServiceResultUtil.checkServiceResultForInput( serviceResult, errorDao);

        //
        // Check for failure of this service?
        //
        ServiceResultUtil.checkServiceFailState( serviceResult, CrmService.class.getSimpleName(), eventDao, failDao);

        //
        // Read messages from the "queue" and do what they say...
        //
        CrmMessageDto dto = updateMarketMessageDao.readNext( VISIBILITY_PERIOD_MS);

        if( dto != null)
        {
            serviceResult = fillServiceResult( serviceResult, dto, CrmQueueType.MARKET_MESSAGE_UPDATED);

            dto.setSent( true);

            updateMarketMessageDao.update( dto);

            eventDao.create(
                EventLogType.SEND,
                serviceResult.getFlowName(),
                IntegrationPointUtil.createId( CrmService.class, "fetchMarketMessageUpdated"),
                dto.getMessageId());

            return serviceResult;
        }

        return serviceResult;
    }

    @Override
    public ServiceResult insertPrepaymentForecast( ServiceResult serviceResult)
    {
        //TODO implement this
        return serviceResult;
    }

    @Override
    public ServiceResult calculatePrepaymentForecasts( ServiceResult serviceResult)
    {
        //TODO implement this
        return serviceResult;
    }

    @Override
    public ServiceResult transformPrepaymentForecasts( ServiceResult serviceResult)
    {
        //TODO implement this
        return serviceResult;
    }

    @Override
    public ServiceResult insertInvoice( ServiceResult serviceResult) throws BillingServiceException
    {
        //TODO implement this
        return serviceResult;
    }

    @Override
    public ServiceResult insertUpdateForecast( ServiceResult serviceResult) throws BillingServiceException
    {
        //TODO implement this
        return serviceResult;
    }

    @Override
    public ServiceResult deleteOriginalMessage( ServiceResult serviceResult) throws BillingServiceException
    {
        //
        // Is the ServiceResult valid?
        //
        ServiceResultUtil.checkServiceResultOnCommit( serviceResult, errorDao);

        //
        // Get the commit info with all the info we need for deletion. Check it before we continue
        //
        BariumCrmMessageInfo messageInfo = (BariumCrmMessageInfo) serviceResult.getCommitInfo();

        ServiceResultUtil.checkMessageOnCommit( serviceResult, messageInfo.getEventType(), errorDao);

        //
        // Delete the message from the corresponding "queue"
        //
        try
        {
            switch( messageInfo.getQueueType())
            {
                case INVOICING_RULE_CREATED:

                    deleteOriginalMessageInvoiceRuleCreated( serviceResult, messageInfo.getTableRowId());
                    break;

                case INVOICING_RULE_UPDATED:

                    deleteOriginalMessageInvoiceRuleUpdated( serviceResult, messageInfo.getTableRowId());
                    break;

                case CLIENT_UPDATED:

                    deleteOriginalMessageClientUpdated( serviceResult, messageInfo.getTableRowId());
                    break;

                case AGREEMENT_UPDATED:

                    deleteOriginalMessageAgreementUpdated( serviceResult, messageInfo.getTableRowId());
                    break;

                case MARKET_MESSAGE_UPDATED:

                    deleteOriginalMessageMarketMessageUpdated( serviceResult, messageInfo.getTableRowId());
                    break;

                case INVOICE_RECIPIENT_DELETED:
                    deleteOriginalMessageInvoiceRecipientDeleted( serviceResult, messageInfo.getTableRowId());
                    break;

                case SPLITTING_RULE_DELETED:
                    deleteOriginalMessageSplittingRuleDeleted( serviceResult, messageInfo.getTableRowId());

                default:

                    throw new BariumInternalCheckException( "Queue is not implemented");
            }
        }
        catch( RuntimeException e)
        {
            throw new BariumInternalCheckException( "Could not update deleted status", e);
        }

        return serviceResult;
    }

    private void deleteOriginalMessageInvoiceRuleCreated( ServiceResult serviceResult, Long tableRowId) throws BillingServiceException
    {
        //
        // Shall this service fail?
        //
        ServiceResultUtil.checkServiceFailState( serviceResult, CrmService.class.getSimpleName(), eventDao, failDao);

        //
        // Update the status and log the event
        //
        createRuleDao.update( setDeleted( createRuleDao.read( tableRowId)));

        eventDao.create(
            EventLogType.DELETE,
            serviceResult.getFlowName(),
            IntegrationPointUtil.createId( CrmService.class, "deleteOriginalMessage"),
            serviceResult.getIntegrationMessage().getMetaData().getMessageId().getGuid());
    }

    private void deleteOriginalMessageInvoiceRuleUpdated( ServiceResult serviceResult, Long tableRowId) throws BillingServiceException
    {
        //
        // Shall this service fail?
        //
        ServiceResultUtil.checkServiceFailState( serviceResult, CrmService.class.getSimpleName(), eventDao, failDao);

        //
        // Update the status and log the event
        //
        updateRuleDao.update( setDeleted( updateRuleDao.read( tableRowId)));

        eventDao.create(
            EventLogType.DELETE,
            serviceResult.getFlowName(),
            IntegrationPointUtil.createId( CrmService.class, "deleteOriginalMessage"),
            serviceResult.getIntegrationMessage().getMetaData().getMessageId().getGuid());
    }

    private void deleteOriginalMessageClientUpdated( ServiceResult serviceResult, Long tableRowId) throws BillingServiceException
    {
        //
        // Shall this service fail?
        //
        ServiceResultUtil.checkServiceFailState( serviceResult, CrmService.class.getSimpleName(), eventDao, failDao);

        //
        // Update the status and log the event
        //
        updateClientDao.update( setDeleted( updateClientDao.read( tableRowId)));

        eventDao.create(
            EventLogType.DELETE,
            serviceResult.getFlowName(),
            IntegrationPointUtil.createId( CrmService.class, "deleteOriginalMessage"),
            serviceResult.getIntegrationMessage().getMetaData().getMessageId().getGuid());
    }

    private void deleteOriginalMessageAgreementUpdated( ServiceResult serviceResult, Long tableRowId) throws BillingServiceException
    {
        //
        // Shall this service fail?
        //
        ServiceResultUtil.checkServiceFailState( serviceResult, CrmService.class.getSimpleName(), eventDao, failDao);

        //
        // Update the status and log the event
        //
        updateAgreementDao.update( setDeleted( updateAgreementDao.read( tableRowId)));

        eventDao.create(
            EventLogType.DELETE,
            serviceResult.getFlowName(),
            IntegrationPointUtil.createId( CrmService.class, "deleteOriginalMessage"),
            serviceResult.getIntegrationMessage().getMetaData().getMessageId().getGuid());
    }

    private void deleteOriginalMessageMarketMessageUpdated( ServiceResult serviceResult, Long tableRowId) throws BillingServiceException
    {
        //
        // Shall this service fail?
        //
        ServiceResultUtil.checkServiceFailState( serviceResult, CrmService.class.getSimpleName(), eventDao, failDao);

        //
        // Update the status and log the event
        //
        updateMarketMessageDao.update( setDeleted( updateMarketMessageDao.read(tableRowId)));

        eventDao.create(
            EventLogType.DELETE,
            serviceResult.getFlowName(),
            IntegrationPointUtil.createId( CrmService.class, "deleteOriginalMessage"),
            serviceResult.getIntegrationMessage().getMetaData().getMessageId().getGuid());
    }

    private void deleteOriginalMessageSplittingRuleDeleted( ServiceResult serviceResult, Long tableRowId) throws BillingServiceException
    {
        //
        // Shall this service fail?
        //
        ServiceResultUtil.checkServiceFailState( serviceResult, CrmService.class.getSimpleName(), eventDao, failDao);

        //
        // Update the status and log the event
        //
        deleteSplittingRuleDao.update( setDeleted( deleteSplittingRuleDao.read( tableRowId)));

        eventDao.create(
            EventLogType.DELETE,
            serviceResult.getFlowName(),
            IntegrationPointUtil.createId( CrmService.class, "deleteOriginalMessage"),
            serviceResult.getIntegrationMessage().getMetaData().getMessageId().getGuid());
    }

    private void deleteOriginalMessageInvoiceRecipientDeleted( ServiceResult serviceResult, Long tableRowId) throws BillingServiceException
    {
        //
        // Shall this service fail?
        //
        ServiceResultUtil.checkServiceFailState( serviceResult, CrmService.class.getSimpleName(), eventDao, failDao);

        //
        // Update the status and log the event
        //
        deleteInvoiceRecipientDao.update( setDeleted( deleteInvoiceRecipientDao.read( tableRowId)));

        eventDao.create(
            EventLogType.DELETE,
            serviceResult.getFlowName(),
            IntegrationPointUtil.createId( CrmService.class, "deleteOriginalMessage"),
            serviceResult.getIntegrationMessage().getMetaData().getMessageId().getGuid());
    }

    private ServiceResult fillServiceResult(
        ServiceResult serviceResult,
        CrmMessageDto dto,
        CrmQueueType  queueType)
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
                    "Data = " + dto.shortString() + "\n");
        }

        //
        // Create the info we need to handle the message going through the flow
        //
        BariumCrmMessageInfo messageInfo = new BariumCrmMessageInfo(
            queueType,
            dto.getId(),
            dto.getAssociatedRowId(),
            dto.getEventType());

        //
        // Create the raw data. In this case a json string
        //
        JsonMessage json = new JsonMessage( dto.getJsonMessage());

        //
        // Set a proper serviceResult to return
        //
        serviceResult.setRawData( json);
        serviceResult.setCommitInfo( messageInfo);

        return serviceResult;
    }

    private CrmMessageDto setDeleted( CrmMessageDto dto)
    {
        if( dto == null)
        {
            errorDao.create( "Azure message to delete does not exist on the queue" + dto);
            throw new BariumInternalCheckException( "Azure message to delete does not exist on the queue");
        }

        dto.setDeleted( true);

        return dto;
    }
}
