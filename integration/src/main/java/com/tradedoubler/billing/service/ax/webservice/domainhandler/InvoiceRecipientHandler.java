package com.tradedoubler.billing.service.ax.webservice.domainhandler;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvrec.*;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumAxdEntityAction;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.webservice.call.*;
import com.tradedoubler.billing.transform.webservice.InvoiceRecipientToAxSalesInvoiceRecipientTransformer;
import org.slf4j.*;
import org.springframework.stereotype.Component;

import java.util.*;


/**
 * This class contains convenient methods that translates the Invoice recipients (and child Splitting rules) and
 * communicates them to the AX-web service.
 * Date: 2012-09-04
 */
@Component
public class InvoiceRecipientHandler extends AbstractHandler {

    private final static Logger log = LoggerFactory.getLogger(InvoiceRecipientHandler.class);

    /** Insert a new Invoice recipient */
    public void insertInvoiceRecipient(InvoiceRecipient invoiceRecipient, Market marketId) throws BillingServiceException {
        String dataAreaId = converter.convert(marketId);

        AxdEntityMDSSalesInvoiceRecipient axInvoiceRecipient = new InvoiceRecipientToAxSalesInvoiceRecipientTransformer(converter, invoiceRecipient).transform();
        InsertInvoiceRecipientCall insertCall = webServiceCallFactory.createCall(InsertInvoiceRecipientCall.class);
        log.debug("Inserting  invoice recipient: " + invoiceRecipient.getInvoiceRecipientId().getGuidForAx());

        insertCall.execute(axInvoiceRecipient, dataAreaId);

        // Handle error codes by throwing correct exception
        callResultHandler.handleInsertResult(insertCall);
    }

    /**
     * Insert new invoice recipients all at once (atomic).
     *
     * @param invoiceRecipients the ones to insert
     * @param marketId          mandatory market id for web service call.
     */
    public void insertInvoiceRecipients(List<InvoiceRecipient> invoiceRecipients, Market marketId) throws BillingServiceException {
        String dataAreaId = converter.convert(marketId);

        List<AxdEntityMDSSalesInvoiceRecipient> axInvoiceRecipients = new ArrayList<AxdEntityMDSSalesInvoiceRecipient>();

        for (InvoiceRecipient invoiceRecipient : invoiceRecipients) {
            InvoiceRecipientToAxSalesInvoiceRecipientTransformer transformer = new InvoiceRecipientToAxSalesInvoiceRecipientTransformer(converter, invoiceRecipient);
            axInvoiceRecipients.add(transformer.transform());
        }

        InsertInvoiceRecipientsCall insertCall = webServiceCallFactory.createCall(InsertInvoiceRecipientsCall.class);
        log.debug("Inserting  invoice recipients: " + getPrimaryKeys(invoiceRecipients));

        insertCall.execute(axInvoiceRecipients, dataAreaId);

        // Handle error codes by throwing correct exception
        callResultHandler.handleInsertResult(insertCall);
    }

    private String getPrimaryKeys(Collection<InvoiceRecipient> axInvoiceRecipients) {
        List<String> keys = new ArrayList<String>();
        for (InvoiceRecipient invoiceRecipient : axInvoiceRecipients) {
            keys.add(invoiceRecipient.getInvoiceRecipientId().getGuidForAx());
        }
        return keys.toString();
    }

    /** Find an Invoice recipient (by primary key) that may exist */
    public FindInvoiceRecipientCall findInvoiceRecipientByPk(Guid invoiceRecipientId, Market marketId) throws BillingServiceException {
        String dataAreaId = converter.convert(marketId);

        String invoiceRecipientIdAx = invoiceRecipientId.getGuidForAx();

        FindInvoiceRecipientCall findCall = webServiceCallFactory.createCall(FindInvoiceRecipientCall.class);

        //Execute the request on the AxRepresentation
        log.debug("Find invoicing recipient : " + invoiceRecipientIdAx);
        findCall.execute(invoiceRecipientIdAx, dataAreaId);

        // Handle error codes by throwing correct exception
        callResultHandler.handleReadResult(findCall);

        // Errorhandling if more than one entity is found
        if (findCall.getNumberOfInvoiceRecipient() > 1) {
            throw BillingServiceException.createBugDisturbance(String.format(
                    "Found more than one InvoiceRecipient in Ax with invoice recipient id : %s",
                    invoiceRecipientIdAx));
        }

        return findCall;
    }

    /** Find several Invoice recipients (by their connection to an invoicing rule) that may exist */
    public FindInvoiceRecipientsByInvoicingRuleCall findInvoiceRecipientsByInvoicingRule(Guid invoicingRuleId, Market marketId) throws BillingServiceException {
        String dataAreaId = converter.convert(marketId);

        // Create web service call
        FindInvoiceRecipientsByInvoicingRuleCall findCall = webServiceCallFactory.createCall(FindInvoiceRecipientsByInvoicingRuleCall.class);

        log.debug(String.format("Find invoice recipients that belong to an invoicing rule: %s, dataAreaId: %s",
                invoicingRuleId.getGuidForAx(), dataAreaId));

        // Execute web service call
        findCall.execute(invoicingRuleId, dataAreaId);

        // Error handling
        callResultHandler.handleFindResult(findCall);

        return findCall;
    }

    /** Update an existing Invoice recipient. This update method will detect which splitting rules that need to be updated, inserted or deleted */
    public void updateInvoiceRecipient(FindInvoiceRecipientCall findCall, InvoiceRecipient invoiceRecipient, Market marketId) throws BillingServiceException {
        String dataAreaId = converter.convert(marketId);

        AxdEntityMDSSalesInvoiceRecipient axInvoiceRecipient = new InvoiceRecipientToAxSalesInvoiceRecipientTransformer(converter, invoiceRecipient)
                .transformForUpdate(findCall);

        // Mark inserts and updates on splitters. Deletes are not marked, they are ignored since they will be handled by another flow
        DetectSplittingRuleChanges detectSplittingRuleChanges = new DetectSplittingRuleChanges(findCall, invoiceRecipient.getSplittingRules());
        detectSplittingRuleChanges.markSplitters(axInvoiceRecipient.getMDSSalesSplitter());

        UpdateInvoiceRecipientCall updateCall = webServiceCallFactory.createCall(UpdateInvoiceRecipientCall.class);
        log.debug("Updating invoice recipient: " + invoiceRecipient.getInvoiceRecipientId().getGuidForAx());

        updateCall.execute(axInvoiceRecipient, findCall.getValidAsOfDateTime(), dataAreaId);

        // Handle error codes by throwing correct exception
        callResultHandler.handleUpdateResult(updateCall);
    }

    /**
     * Issues a delete request against Dynamics AX regarding an existing invoice recipient.
     *
     * @param invoiceRecipientId The guid of the invoice recipient to delete.
     * @param marketId           A market id that is used to set the call context when executing the call. This is NOT the same
     *                           as "the invoice recipient should be removed from this market", the reason is that Invoice recipient is a global/virtual
     *                           object in dynamics ax and is not tied to any given market.
     *                           For this reason any existing market id would suffice.
     * @throws BillingServiceException
     */
    public void deleteInvoiceRecipient(Guid invoiceRecipientId, Market marketId) throws BillingServiceException {
        String dataAreaId = converter.convert(marketId);

        DeleteInvoiceRecipientCall deleteCall = webServiceCallFactory.createCall(DeleteInvoiceRecipientCall.class);

        log.debug("Deleting  invoice recipient: " + invoiceRecipientId);
        deleteCall.execute(invoiceRecipientId.getGuidForAx(), dataAreaId);

        // Handle error codes by throwing correct exception
        callResultHandler.handleDeleteResult(deleteCall);
    }

    /** Delete an existing Splitting rule that is a child to an existing Invoice recipient */
    public void deleteSplittingRule(FindInvoiceRecipientCall findCall, Guid splittingRuleId, Market marketId) throws BillingServiceException {
        String dataAreaId = converter.convert(marketId);

        // Convert the data in the read call to an update call 
        AxdEntityMDSSalesInvoiceRecipient axInvoiceRecipient = InvoiceRecipientToAxSalesInvoiceRecipientTransformer.transformFindCallDirectlyToUpdate(findCall);

        // Mark the selected splitter so that it should be deleted
        AxdEntityMDSSalesSplitter found = null;
        for (Iterator<AxdEntityMDSSalesSplitter> iterator = axInvoiceRecipient.getMDSSalesSplitter().iterator(); found == null && iterator.hasNext(); ) {
            AxdEntityMDSSalesSplitter splitter = iterator.next();
            if (splittingRuleId.equalsAxGuid(splitter.getSplitterId())) {
                found = splitter;
            }
        }
        if (found == null) {
            throw BillingServiceException.createBugDisturbance(String.format(
                    "Internal programming error. This method should only be called if the splitter to delete exists. SplittingRuleId: %s",
                    splittingRuleId.getGuidForAx()));
        }
        found.setAction(AxdEnumAxdEntityAction.DELETE);

        // Create the update call that will do the actual delete
        UpdateInvoiceRecipientCall updateCall = webServiceCallFactory.createCall(UpdateInvoiceRecipientCall.class);

        log.debug(String.format("Updating invoice recipient (as part of deleteSplittingRule): %s, splittingRule to delete: %s",
                axInvoiceRecipient.getInvoiceRecipientId(), splittingRuleId.getGuidForAx()));

        // Update the invoice recipient so that the splitter is deleted
        updateCall.execute(axInvoiceRecipient, findCall.getValidAsOfDateTime(), dataAreaId);

        // Handle error codes by throwing correct exception
        callResultHandler.handleUpdateResult(updateCall);

    }

    /** Returns true if the splitting rule is is among the splitters list */
    public boolean containsSplittingRule(List<AxdEntityMDSSalesSplitter> splitters, Guid splittingRuleId) {
        for (AxdEntityMDSSalesSplitter splitter : splitters) {
            if (splittingRuleId.equalsAxGuid(splitter.getSplitterId())) {
                return true;
            }
        }
        return false;
    }

}
