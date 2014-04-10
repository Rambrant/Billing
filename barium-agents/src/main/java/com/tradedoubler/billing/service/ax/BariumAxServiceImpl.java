package com.tradedoubler.billing.service.ax;

import com.google.gson.Gson;
import com.tradedoubler.billing.derby.dao.*;
import com.tradedoubler.billing.derby.dto.CrmMessageDto;
import com.tradedoubler.billing.derby.dto.OrderLineDto;
import com.tradedoubler.billing.domain.OrderLine;
import com.tradedoubler.billing.domain.OrderLinesCreated;
import com.tradedoubler.billing.domain.ReadyToInvoice;
import com.tradedoubler.billing.exception.BariumInternalCheckException;
import com.tradedoubler.billing.platform.flowcontroller.ServiceResult;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.crm.BariumCrmMessageInfo;
import com.tradedoubler.billing.service.pan.BariumPanMessageInfo;
import com.tradedoubler.billing.transform.json.gson.GsonFactory;
import com.tradedoubler.billing.type.EventLogType;
import com.tradedoubler.billing.type.ProducerEventDbType;
import com.tradedoubler.billing.util.ExecutionUtil;
import com.tradedoubler.billing.util.IntegrationPointUtil;
import com.tradedoubler.billing.util.ServiceResultUtil;

/**
 * @author Thomas Rambrant (thore)
 */

public class BariumAxServiceImpl implements AxService
{
    private static final Gson gson = GsonFactory.getGson();

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
    private PanOrderLineDao              panOrderLineDao;
    private AxOrderLineDao               axOrderLineDao;

    public BariumAxServiceImpl() throws Exception
    {
        ExecutionUtil.setupDatabase();

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
        panOrderLineDao           = new PanOrderLineDao();
        axOrderLineDao            = new AxOrderLineDao();
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
    public ServiceResult insertInvoicingRule( ServiceResult serviceResult) throws BillingServiceException
    {
        //
        // Is the ServiceResult valid?
        //
        ServiceResultUtil.checkServiceResultForOutput( serviceResult, errorDao);

        //
        // Check for failure of this service?
        //
        ServiceResultUtil.checkServiceFailState( serviceResult, AxService.class.getSimpleName(), eventDao, failDao);

        //
        // Read messages from the "queue" and do what they say...
        //
        if( serviceResult.getCommitInfo() instanceof BariumCrmMessageInfo)
        {
            BariumCrmMessageInfo messageInfo = (BariumCrmMessageInfo) serviceResult.getCommitInfo();

            CrmMessageDto dto = createRuleDao.read( messageInfo.getTableRowId());

            serviceResult = ServiceResultUtil.fillServiceResultForCrm(
                AxService.class.getSimpleName(),
                serviceResult,
                messageInfo,
                dto,
                errorDao);
        }

        //
        // Log the event
        //
        eventDao.create(
            EventLogType.RECEIVE,
            serviceResult.getFlowName(),
            IntegrationPointUtil.createId( AxService.class, "insertInvoicingRule"),
            serviceResult.getIntegrationMessage().getMetaData().getMessageId().getGuid());

        ExecutionUtil.sleepForLoadSimulation( 400);

        return serviceResult;
    }

    @Override
    public ServiceResult updateInvoicingRule( ServiceResult serviceResult) throws BillingServiceException
    {
        //
        // Is the ServiceResult valid?
        //
        ServiceResultUtil.checkServiceResultForOutput( serviceResult, errorDao);

        //
        // Check for failure of this service?
        //
        ServiceResultUtil.checkServiceFailState( serviceResult, AxService.class.getSimpleName(), eventDao, failDao);

        //
        // Read messages from the "queue" and do what they say...
        //
        if( serviceResult.getCommitInfo() instanceof BariumCrmMessageInfo)
        {
            BariumCrmMessageInfo messageInfo = (BariumCrmMessageInfo) serviceResult.getCommitInfo();

            CrmMessageDto dto = updateRuleDao.read( messageInfo.getTableRowId());

            HandleOutOfOrder( serviceResult, messageInfo);

            serviceResult = ServiceResultUtil.fillServiceResultForCrm(
                AxService.class.getSimpleName(),
                serviceResult,
                messageInfo,
                dto,
                errorDao);
        }

        //
        // Log the event
        //
        eventDao.create(
            EventLogType.RECEIVE,
            serviceResult.getFlowName(),
            IntegrationPointUtil.createId( AxService.class, "updateInvoicingRule"),
            serviceResult.getIntegrationMessage().getMetaData().getMessageId().getGuid());

        ExecutionUtil.sleepForLoadSimulation( 400);

        return serviceResult;
    }

    @Override
    public ServiceResult updateAgreement( ServiceResult serviceResult) throws BillingServiceException
    {
        //
        // Is the ServiceResult valid?
        //
        ServiceResultUtil.checkServiceResultForOutput( serviceResult, errorDao);

        //
        // Check for failure of this service?
        //
        ServiceResultUtil.checkServiceFailState( serviceResult, AxService.class.getSimpleName(), eventDao, failDao);

        //
        // Read messages from the "queue" and do what they say...
        //
        if( serviceResult.getCommitInfo() instanceof BariumCrmMessageInfo)
        {
            BariumCrmMessageInfo messageInfo = (BariumCrmMessageInfo) serviceResult.getCommitInfo();

            CrmMessageDto dto = updateAgreementDao.read( messageInfo.getTableRowId());

            serviceResult = ServiceResultUtil.fillServiceResultForCrm(
                AxService.class.getSimpleName(),
                serviceResult,
                messageInfo,
                dto,
                errorDao);
        }

        //
        // Log the event
        //
        eventDao.create(
            EventLogType.RECEIVE,
            serviceResult.getFlowName(),
            IntegrationPointUtil.createId( AxService.class, "updateAgreement"),
            serviceResult.getIntegrationMessage().getMetaData().getMessageId().getGuid());

        ExecutionUtil.sleepForLoadSimulation( 400);

        return serviceResult;
    }

    @Override
    public ServiceResult insertAgreement(ServiceResult serviceResult) throws BillingServiceException
    {
        //
        // Is the ServiceResult valid?
        //
        ServiceResultUtil.checkServiceResultForOutput( serviceResult, errorDao);

        //
        // Check for failure of this service?
        //
        ServiceResultUtil.checkServiceFailState( serviceResult, AxService.class.getSimpleName(), eventDao, failDao);

        //
        // Read messages from the "queue" and do what they say...
        //
        if( serviceResult.getCommitInfo() instanceof BariumCrmMessageInfo)
        {
            BariumCrmMessageInfo messageInfo = (BariumCrmMessageInfo) serviceResult.getCommitInfo();

            CrmMessageDto dto = createRuleDao.read( messageInfo.getTableRowId());

            serviceResult = ServiceResultUtil.fillServiceResultForCrm(
                AxService.class.getSimpleName(),
                serviceResult,
                messageInfo,
                dto,
                errorDao);
        }

        //
        // Log the event
        //
        eventDao.create(
            EventLogType.RECEIVE,
            serviceResult.getFlowName(),
            IntegrationPointUtil.createId( AxService.class, "insertAgreement"),
            serviceResult.getIntegrationMessage().getMetaData().getMessageId().getGuid());

        ExecutionUtil.sleepForLoadSimulation( 400);

        return serviceResult;
    }

    @Override
    public ServiceResult updateClient( ServiceResult serviceResult) throws BillingServiceException
    {
        //
        // Is the ServiceResult valid?
        //
        ServiceResultUtil.checkServiceResultForOutput( serviceResult, errorDao);

        //
        // Check for failure of this service?
        //
        ServiceResultUtil.checkServiceFailState( serviceResult, AxService.class.getSimpleName(), eventDao, failDao);

        //
        // Read messages from the "queue" and do what they say...
        //
        if( serviceResult.getCommitInfo() instanceof BariumCrmMessageInfo)
        {
            BariumCrmMessageInfo messageInfo = (BariumCrmMessageInfo) serviceResult.getCommitInfo();

            CrmMessageDto dto = updateClientDao.read( messageInfo.getTableRowId());

            serviceResult = ServiceResultUtil.fillServiceResultForCrm(
                AxService.class.getSimpleName(),
                serviceResult,
                messageInfo,
                dto,
                errorDao);
        }

        //
        // Log the event
        //
        eventDao.create(
            EventLogType.RECEIVE,
            serviceResult.getFlowName(),
            IntegrationPointUtil.createId( AxService.class, "updateClient"),
            serviceResult.getIntegrationMessage().getMetaData().getMessageId().getGuid());

        ExecutionUtil.sleepForLoadSimulation( 400);

        return serviceResult;
    }

    @Override
    public ServiceResult insertClient(ServiceResult serviceResult) throws BillingServiceException
    {
        //
        // Is the ServiceResult valid?
        //
        ServiceResultUtil.checkServiceResultForOutput( serviceResult, errorDao);

        //
        // Check for failure of this service?
        //
        ServiceResultUtil.checkServiceFailState( serviceResult, AxService.class.getSimpleName(), eventDao, failDao);

        //
        // Read messages from the "queue" and do what they say...
        //
        if( serviceResult.getCommitInfo() instanceof BariumCrmMessageInfo)
        {
            BariumCrmMessageInfo messageInfo = (BariumCrmMessageInfo) serviceResult.getCommitInfo();

            CrmMessageDto dto = createRuleDao.read( messageInfo.getTableRowId());

            serviceResult = ServiceResultUtil.fillServiceResultForCrm(
                AxService.class.getSimpleName(),
                serviceResult,
                messageInfo,
                dto,
                errorDao);
        }

        //
        // Log the event
        //
        eventDao.create(
            EventLogType.RECEIVE,
            serviceResult.getFlowName(),
            IntegrationPointUtil.createId( AxService.class, "insertClient"),
            serviceResult.getIntegrationMessage().getMetaData().getMessageId().getGuid());

        ExecutionUtil.sleepForLoadSimulation( 400);

        return serviceResult;
    }

    @Override
    public ServiceResult deleteInvoiceRecipient( ServiceResult serviceResult) throws BillingServiceException
    {
        //
        // Is the ServiceResult valid?
        //
        ServiceResultUtil.checkServiceResultForOutput( serviceResult, errorDao);

        //
        // Check for failure of this service?
        //
        ServiceResultUtil.checkServiceFailState( serviceResult, AxService.class.getSimpleName(), eventDao, failDao);

        //
        // Read messages from the "queue" and do what they say...
        //
        if( serviceResult.getCommitInfo() instanceof BariumCrmMessageInfo)
        {
            BariumCrmMessageInfo messageInfo = (BariumCrmMessageInfo) serviceResult.getCommitInfo();

            CrmMessageDto dto = deleteInvoiceRecipientDao.read( messageInfo.getTableRowId());

            serviceResult = ServiceResultUtil.fillServiceResultForCrm(
                AxService.class.getSimpleName(),
                serviceResult,
                messageInfo,
                dto,
                errorDao);
        }

        //
        // Log the event
        //
        eventDao.create(
            EventLogType.RECEIVE,
            serviceResult.getFlowName(),
            IntegrationPointUtil.createId( AxService.class, "deleteInvoiceRecipient"),
            serviceResult.getIntegrationMessage().getMetaData().getMessageId().getGuid());

        ExecutionUtil.sleepForLoadSimulation( 400);

        return serviceResult;
    }

    @Override
    public ServiceResult deleteSplittingRule( ServiceResult serviceResult) throws BillingServiceException
    {
        //
        // Is the ServiceResult valid?
        //
        ServiceResultUtil.checkServiceResultForOutput( serviceResult, errorDao);

        //
        // Check for failure of this service?
        //
        ServiceResultUtil.checkServiceFailState( serviceResult, AxService.class.getSimpleName(), eventDao, failDao);

        //
        // Read messages from the "queue" and do what they say...
        //
        if( serviceResult.getCommitInfo() instanceof BariumCrmMessageInfo)
        {
            BariumCrmMessageInfo messageInfo = (BariumCrmMessageInfo) serviceResult.getCommitInfo();

            CrmMessageDto dto = deleteSplittingRuleDao.read( messageInfo.getTableRowId());

            serviceResult = ServiceResultUtil.fillServiceResultForCrm(
                AxService.class.getSimpleName(),
                serviceResult,
                messageInfo,
                dto,
                errorDao);
        }

        //
        // Log the event
        //
        eventDao.create(
            EventLogType.RECEIVE,
            serviceResult.getFlowName(),
            IntegrationPointUtil.createId( AxService.class, "deleteSplittingRule"),
            serviceResult.getIntegrationMessage().getMetaData().getMessageId().getGuid());

        ExecutionUtil.sleepForLoadSimulation( 400);

        return serviceResult;
    }

    @Override
    public ServiceResult updateMarketMessage( ServiceResult serviceResult) throws BillingServiceException
    {
        //
        // Is the ServiceResult valid?
        //
        ServiceResultUtil.checkServiceResultForOutput( serviceResult, errorDao);

        //
        // Check for failure of this service?
        //
        ServiceResultUtil.checkServiceFailState( serviceResult, AxService.class.getSimpleName(), eventDao, failDao);

        //
        // Read messages from the "queue" and do what they say...
        //
        if( serviceResult.getCommitInfo() instanceof BariumCrmMessageInfo)
        {
            BariumCrmMessageInfo messageInfo = (BariumCrmMessageInfo) serviceResult.getCommitInfo();

            CrmMessageDto dto = updateMarketMessageDao.read( messageInfo.getTableRowId());

            serviceResult = ServiceResultUtil.fillServiceResultForCrm(
                AxService.class.getSimpleName(),
                serviceResult,
                messageInfo,
                dto,
                errorDao);
        }

        //
        // Log the event
        //
        eventDao.create(
            EventLogType.RECEIVE,
            serviceResult.getFlowName(),
            IntegrationPointUtil.createId( AxService.class, "updateMarketMessage"),
            serviceResult.getIntegrationMessage().getMetaData().getMessageId().getGuid());

        ExecutionUtil.sleepForLoadSimulation( 400);

        return serviceResult;
    }

    @Override
    public ServiceResult createOrderLines( ServiceResult serviceResult) throws BillingServiceException
    {
        //
        // Is the ServiceResult valid?
        //
        ServiceResultUtil.checkServiceResultForOutput( serviceResult, errorDao);

        //
        // Check for failure of this service?
        //
        ServiceResultUtil.checkServiceFailState( serviceResult, AxService.class.getSimpleName(), eventDao, failDao);

        //
        // Read messages from the "queue" and do what they say...
        //
        OrderLineDto dto = null;

        if( serviceResult.getCommitInfo() instanceof BariumPanMessageInfo)
        {
            BariumPanMessageInfo messageInfo = (BariumPanMessageInfo) serviceResult.getCommitInfo();

            dto = panOrderLineDao.read( messageInfo.getTableRowId());

            serviceResult = ServiceResultUtil.fillServiceResultForPan(
                AxService.class.getSimpleName(),
                serviceResult,
                messageInfo,
                dto,
                errorDao);
        }

        if( dto != null && dto.getNumOrderLines() > 0)
        {
            //
            // Store these order line "meta" lines
            //
            OrderLinesCreated message  = (OrderLinesCreated) serviceResult.getIntegrationMessage().getDomainObject();
            OrderLine         metaLine = message.getOrderLines().get( 0);

            axOrderLineDao.create( dto, metaLine.getSystemAgreementId());
        }


        //
        // Log the event
        //
        eventDao.create(
            EventLogType.RECEIVE,
            serviceResult.getFlowName(),
            IntegrationPointUtil.createId( AxService.class, "createOrderLines"),
            serviceResult.getIntegrationMessage().getMetaData().getMessageId().getGuid());

        ExecutionUtil.sleepForLoadSimulation( 400);

        return serviceResult;
    }

    @Override
    public ServiceResult startInvoicing( ServiceResult serviceResult)  throws BillingServiceException
    {
        //
        // Is the ServiceResult valid?
        //
        ServiceResultUtil.checkServiceResultForOutput( serviceResult, errorDao);

        //
        // Check for failure of this service?
        //
        ServiceResultUtil.checkServiceFailState( serviceResult, AxService.class.getSimpleName(), eventDao, failDao);

        //
        // Check the status
        //
        ReadyToInvoice readyToInvoice = (ReadyToInvoice) serviceResult.getIntegrationMessage().getDomainObject();

        if( ! readyToInvoice.isReadyToInvoice())
        {
            errorDao.create(
                "Flow error. The startInvoicing method should not been called unless Pan says readyToInvoice = true");

            throw BillingServiceException.createBugDisturbance(
                "Flow error. The startInvoicing method should not been called unless Pan says readyToInvoice = true");
        }

        //
        // Log the event
        //
        eventDao.create(
            EventLogType.RECEIVE,
            serviceResult.getFlowName(),
            IntegrationPointUtil.createId( AxService.class, "startInvoicing"),
            serviceResult.getIntegrationMessage().getMetaData().getMessageId().getGuid());

        ExecutionUtil.sleepForLoadSimulation( 200);

        return serviceResult;
    }

    /**
     * @see com.tradedoubler.billing.service.ax.AxServiceImpl#insertResellerClient
     */
    @Override
    public ServiceResult insertResellerClient(ServiceResult serviceResult) throws BillingServiceException {
        //TODO implement this
        return serviceResult;
    }

    public ServiceResult fetchCreatedInvoice( ServiceResult serviceResult)
    {
        //TODO implement this
        return serviceResult;
    }

    @Override
    public ServiceResult finalizeInvoice( ServiceResult serviceResult)
    {
        //TODO implement this
        return serviceResult;
    }

    @Override
    public ServiceResult moveFailedInvoice( ServiceResult serviceResult) throws BillingServiceException
    {
        //TODO implement this
        return serviceResult;
    }

    private void HandleOutOfOrder( ServiceResult serviceResult, BariumCrmMessageInfo messageInfo) throws BillingServiceException
    {
        //
        // This should not be done for any event other than Order
        //
        if( messageInfo.getEventType() != ProducerEventDbType.ORDER)
        {
            return;
        }

        //
        // Update the create invoice to ensure it is created and throw an appropriate exception
        //
        CrmMessageDto createDto = createRuleDao.read( messageInfo.getAssociatedRowId());

        if( ! createDto.isSent())
        {
            createDto.setOutOfOrder( false);

            createRuleDao.update( createDto);

            throw BillingServiceException.createIntegrationDisturbance(
                "Entity does not exist, update before create! (" + serviceResult.getFlowName() + ")",
                0);
        }
    }

    public ServiceResult checkResellerClientExists(ServiceResult serviceResult) throws BillingServiceException{
        // TODO
        return null;
    }
}
