package com.tradedoubler.billing.service.ax.webservice.domainhandler;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalesinvr.*;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumAxdEntityAction;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.transform.webservice.InvoicingMessageRuleToAxNestedSalesInvoiceMessageTransformer;

import java.util.*;

/**
 * This class identifies exists or not-exists changes for the invoicing rules purchaseOrders and invoiceMessages.<br>
 * Note, that purchase orders are treated as invoice messages in Ax.
 *
 * @author bjoek
 * @since 2012-09-05
 */
class DetectInvoiceMessageRuleChanges {

    private final ChangeDetector changeDetector;

    public DetectInvoiceMessageRuleChanges(AxdEntityMDSSalesInvoiceRule existingInvoiceRule, InvoicingRule invoicingRule) {

        List<InvoicingRuleMessageRule> listOfInvoiceMessageRules = invoicingRule.getInvoiceMessageRules();
        List<PurchaseOrder> listOfPurchaseOrders = invoicingRule.getPurchaseOrders();


        changeDetector = new ChangeDetector(
                getExistingInvoiceMessageIds(existingInvoiceRule.getMDSSalesInvoiceMessage()),
                getFutureInvoiceMessageIds(listOfInvoiceMessageRules, listOfPurchaseOrders));
    }

    /** Existing invoice message rules comes from the readCall from Ax */
    private Set<String> getExistingInvoiceMessageIds(List<AxdEntityMDSSalesInvoiceMessage> existingInvoiceMessages) {
        Set<String> returnValue = new TreeSet<String>();
        for (AxdEntityMDSSalesInvoiceMessage message : existingInvoiceMessages) {
            returnValue.add(message.getInvoiceMessageId());
        }
        for (AxdEntityMDSSalesInvoiceMessage message : existingInvoiceMessages) {
            returnValue.add(message.getInvoiceMessageId());
        }
        return returnValue;
    }

    /** Future invoice message rules comes from the crm azure message */
    private Set<String> getFutureInvoiceMessageIds(List<? extends InvoiceMessageRule> futureInvoiceMessageRules, List<PurchaseOrder> listOfPurchaseOrders) {
        Set<String> returnValue = new TreeSet<String>();
        for (InvoiceMessageRule invoiceMessageRule : futureInvoiceMessageRules) {
            returnValue.add(invoiceMessageRule.getInvoiceMessageRuleId().getGuidForAx());
        }
        for (PurchaseOrder purchaseOrder : listOfPurchaseOrders) {
            returnValue.add(purchaseOrder.getPurchaseOrderId().getGuidForAx());
        }
        return returnValue;
    }


    /** Modifies the data that are sent to the update call to Ax */
    public void markInsertsOnTheInvoiceRuleMessages(List<AxdEntityMDSSalesInvoiceMessage> mdsSalesInvoiceMessage) {
        for (AxdEntityMDSSalesInvoiceMessage message : mdsSalesInvoiceMessage) {
            if (changeDetector.getIdsToInsert().contains(message.getInvoiceMessageId())) {
                message.setAction(AxdEnumAxdEntityAction.CREATE);
            }
        }
    }

    /** Modifies the data that are sent to the update call to Ax. Both purchase orders and invoice messages are processed */
    public void addDeletesToTheInvoiceRuleMessages(List<AxdEntityMDSSalesInvoiceMessage> mdsSalesInvoiceMessage) {
        for (String invoiceMessageId : changeDetector.getIdsToDelete()) {
            AxdEntityMDSSalesInvoiceMessage message = new InvoicingMessageRuleToAxNestedSalesInvoiceMessageTransformer(null).dummyAxdEntityMDSSalesInvoiceMessageForDeleteOperation();
            message.setAction(AxdEnumAxdEntityAction.DELETE);
            message.setInvoiceMessageId(invoiceMessageId);
            mdsSalesInvoiceMessage.add(message);
        }
    }
}
