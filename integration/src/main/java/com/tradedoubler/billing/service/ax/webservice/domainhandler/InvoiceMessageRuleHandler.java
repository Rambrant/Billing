package com.tradedoubler.billing.service.ax.webservice.domainhandler;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvmes.AxdEntityMDSSalesInvoiceMessage;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.webservice.call.*;
import com.tradedoubler.billing.transform.webservice.InvoicingMessageRuleToAxStandaloneSalesInvoiceMessageTransformer;
import org.slf4j.*;
import org.springframework.stereotype.Component;

/**
 * This class contains convenient methods that translates the Invoice message rules and communicates them to the AX-web service.
 * If the invoice message belongs to an invoice issuer then marketId is used as parent key.
 * If the invoice message belongs to a client then clientId is used as parent key.
 * If the invoice message belongs to an invoicing rule then the Invoicing rule integration must be used instead.
 * Date: 2012-09-07
 */
@Component
public class InvoiceMessageRuleHandler extends AbstractHandler {

    private final static Logger log = LoggerFactory.getLogger(InvoiceMessageRuleHandler.class);

    /** Insert a new Invoice message rule */
    public void insertInvoiceMessageRule(InvoiceMessageRule invoiceMessageRule, Market market) throws BillingServiceException {
        String dataAreaId = converter.convert(market);

        // The parent key can be either clientId, marketId or invoiceRuleId
        String parentPrimaryKey = invoiceMessageRule.getParentPrimaryKeyForAx(converter);

        // Transform the domain entity
        AxdEntityMDSSalesInvoiceMessage axSalesInvMess = new InvoicingMessageRuleToAxStandaloneSalesInvoiceMessageTransformer(invoiceMessageRule).transform();

        // Create web service call
        InsertInvoiceMessageRuleCall insertInvoiceMessageRuleCall = webServiceCallFactory.createCall(InsertInvoiceMessageRuleCall.class);

        log.debug(String.format("Inserting invoice message rule : %s dataAreaId: %s",
                invoiceMessageRule.getInvoiceMessageRuleId(), dataAreaId));

        // Execute web service call
        insertInvoiceMessageRuleCall.execute(axSalesInvMess, parentPrimaryKey, dataAreaId);

        // Handle error codes by throwing correct exception
        callResultHandler.handleInsertResult(insertInvoiceMessageRuleCall);
    }

    /** Find an Invoice message rule that may exist */
    public FindInvoiceMessageRuleCall findInvoiceMessageRuleByPk(Guid invoiceMessageRuleId, Market market) throws BillingServiceException {
        String dataAreaId = converter.convert(market);
        String invoiceMessageId = invoiceMessageRuleId.getGuidForAx();

        // Create web service call
        FindInvoiceMessageRuleCall findCall = webServiceCallFactory.createCall(FindInvoiceMessageRuleCall.class);

        log.debug(String.format("Find invoice message rule : %s dataAreaId: %s",
                invoiceMessageId, dataAreaId));

        // Execute web service call
        findCall.execute(invoiceMessageId, dataAreaId);

        // Error handling
        callResultHandler.handleFindResult(findCall);

        // Errorhandling if more than one entity is found
        if (findCall.getNumberOfInvoiceMessageRules() > 1) {
            throw BillingServiceException.createBugDisturbance("Found more than one InvoiceMessage in Ax with InvoiceMessageRuleId: " + invoiceMessageId);
        }

        return findCall;
    }

    /** Update an existing Invoice message rule */
    public void updateInvoiceMessageRule(FindInvoiceMessageRuleCall findCall, InvoiceMessageRule invoiceMessageRule, Market market) throws BillingServiceException {
        // Transform the domain entity
        AxdEntityMDSSalesInvoiceMessage axInvMessage = new InvoicingMessageRuleToAxStandaloneSalesInvoiceMessageTransformer(invoiceMessageRule).transformForUpdate(findCall);

        String dataAreaId = converter.convert(market);

        // Create web service call
        UpdateInvoiceMessageRuleCall updateInvoiceMessageRuleCall = webServiceCallFactory.createCall(UpdateInvoiceMessageRuleCall.class);

        // The parent key can be either clientId, marketId or invoiceRuleId
        String parentPrimaryKey = invoiceMessageRule.getParentPrimaryKeyForAx(converter);

        log.debug(String.format("Updating invoice message rule : %s dataAreaId: %s",
                axInvMessage.getInvoiceMessageId(), dataAreaId));

        // Execute the web service call
        updateInvoiceMessageRuleCall.execute(axInvMessage, parentPrimaryKey, dataAreaId);

        // Handle error codes by throwing correct exception
        callResultHandler.handleUpdateResult(updateInvoiceMessageRuleCall);
    }

}
