package com.tradedoubler.billing.service.ax.webservice.domainhandler;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalesinvr.AxdEntityMDSSalesInvoiceRule;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.webservice.call.*;
import com.tradedoubler.billing.transform.webservice.InvoicingRuleToAxSalesInvoiceRuleTransformer;
import org.slf4j.*;
import org.springframework.stereotype.Component;


/**
 * This class contains convenient methods that translates the Invoicing rules (and their child Invoice message rules)
 * and communicates them to the AX-web service.
 *
 * @author bjoek
 * @since 2012-09-03
 */
@Component
public class InvoicingRuleHandler extends AbstractHandler {

    private final static Logger log = LoggerFactory.getLogger(InvoicingRuleHandler.class);

    /**
     * Insert an existing Invoicing rule in Ax
     *
     * @param invoicingRule -the domain object
     */
    public void insertInvoicingRule(InvoicingRule invoicingRule) throws BillingServiceException {
        String dataAreaId = converter.convert(invoicingRule.getMarketId());

        //Transform domain object to an AxRepresentation
        AxdEntityMDSSalesInvoiceRule axSalesInvoiceRule = new InvoicingRuleToAxSalesInvoiceRuleTransformer(converter, invoicingRule, dataAreaId).transform();

        //Create the request based on the provided AxWebServiceSetup
        InsertInvoicingRuleCall insertCall = webServiceCallFactory.createCall(InsertInvoicingRuleCall.class);

        //Execute the request on the AxRepresentation
        log.debug("Inserting invoicing rule : " + invoicingRule.getInvoicingRuleId());
        insertCall.execute(axSalesInvoiceRule);

        // Handle error codes by throwing correct exception
        callResultHandler.handleInsertResult(insertCall);
    }

    /** Find an Invoicing rule that may exist */
    public FindInvoicingRuleCall findInvoicingRuleByPk(Guid invoicingRuleId, Market marketId) throws BillingServiceException {
        String dataAreaId = converter.convert(marketId);

        // Create web service call
        FindInvoicingRuleCall findCall = webServiceCallFactory.createCall(FindInvoicingRuleCall.class);

        //Execute the request on the AxRepresentation
        log.debug("Find invoicing rule : " + invoicingRuleId.getGuidForAx());
        findCall.execute(invoicingRuleId, dataAreaId);

        // Handle error codes by throwing correct exception
        callResultHandler.handleFindResult(findCall);

        return findCall;
    }

    /** Update an existing Invoicing rule. This update method will also detect which invoice rule messages and purchase orders that need to be updated, inserted or deleted */
    public void updateInvoicingRule(FindInvoicingRuleCall findCall, InvoicingRule invoicingRule) throws BillingServiceException {
        String dataAreaId = converter.convert(invoicingRule.getMarketId());
        String documentHash = findCall.getDocumentHash();
        AxdEntityMDSSalesInvoiceRule invoiceRule = findCall.getInvoiceRule();

        InvoicingRuleToAxSalesInvoiceRuleTransformer transformer = new InvoicingRuleToAxSalesInvoiceRuleTransformer(converter, invoicingRule, dataAreaId);
        AxdEntityMDSSalesInvoiceRule axSalesInvoiceRule = transformer.transformForUpdate(documentHash);

        // (May) modify the invoicing rule messages and purchase orders depending on their previous state
        // Note that purchase orders are treated as invoice messages in Ax
        DetectInvoiceMessageRuleChanges detectInvoiceMessageRuleChanges = new DetectInvoiceMessageRuleChanges(invoiceRule, invoicingRule);
        detectInvoiceMessageRuleChanges.markInsertsOnTheInvoiceRuleMessages(axSalesInvoiceRule.getMDSSalesInvoiceMessage());
        detectInvoiceMessageRuleChanges.addDeletesToTheInvoiceRuleMessages(axSalesInvoiceRule.getMDSSalesInvoiceMessage());

        // Create web service call
        UpdateInvoicingRuleCall updateCall = webServiceCallFactory.createCall(UpdateInvoicingRuleCall.class);

        log.debug("Updating invoicing rule : " + invoicingRule.getInvoicingRuleId());

        //Execute the request on the AxRepresentation
        updateCall.execute(axSalesInvoiceRule);

        // Handle error codes by throwing correct exception
        callResultHandler.handleUpdateResult(updateCall);
    }

}
