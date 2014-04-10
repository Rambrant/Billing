package com.tradedoubler.billing.transform.webservice;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalesinvr.AxdEntityMDSSalesInvoiceMessage;
import com.tradedoubler.billing.domain.*;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.*;

/**
 * This class transforms Invoice RuleMessages that are communicated to the AX in the InvoiceRule webservice.<br>
 * <b>Note:</b> the wsdl Ax rule message object transformed here is not to be mixed up with the AX web service wsdl object, having the same name,
 * that belongs to the Ax InvoiceMessage web service.
 */
public class InvoicingMessageRuleToAxNestedSalesInvoiceMessageTransformer {

    private final List<InvoicingRuleMessageRule> invoiceMessageRules;

    public InvoicingMessageRuleToAxNestedSalesInvoiceMessageTransformer(List<InvoicingRuleMessageRule> invoiceMessageRule) {
        this.invoiceMessageRules = invoiceMessageRule;
    }


    public List<AxdEntityMDSSalesInvoiceMessage> transform() {
        ArrayList<AxdEntityMDSSalesInvoiceMessage> salesInvoiceMessages = new ArrayList<AxdEntityMDSSalesInvoiceMessage>();

        for (InvoicingRuleMessageRule invoiceMessageRule : invoiceMessageRules) {

            AxdEntityMDSSalesInvoiceMessage message = transFormOneMessage(invoiceMessageRule);

            salesInvoiceMessages.add(message);
        }
        return salesInvoiceMessages;
    }

    private AxdEntityMDSSalesInvoiceMessage transFormOneMessage(InvoiceMessageRule invoiceMessageRule) {
        AxdEntityMDSSalesInvoiceMessage message = new AxdEntityMDSSalesInvoiceMessage();
        message.setClazz("entity");
        message.setInvoiceMessageId(invoiceMessageRule.getInvoiceMessageRuleId().getGuidForAx());
        message.setSourceType(invoiceMessageRule.getSourceType());
        message.setText(invoiceMessageRule.getMessageText());
        XMLGregorianCalendar from = DateConverter.convertISO8601ToXMLGregorianCalendar(invoiceMessageRule.getValidFrom().getTimestamp());
        XMLGregorianCalendar to = DateConverter.convertISO8601ToXMLGregorianCalendar(invoiceMessageRule.getValidTo().getTimestamp());
        message.setValidFrom(from);
        message.setValidTo(to);
        return message;
    }

    /**
     * This dummy is used for both purchase orders and invoice messages. That means that the purchase order WILL get
     * wrong source type, so this dummy should only be used when deleting entities.
     */
    public AxdEntityMDSSalesInvoiceMessage dummyAxdEntityMDSSalesInvoiceMessageForDeleteOperation() {
        InvoicingRuleMessageRule invoiceMessageRule = new InvoicingRuleMessageRule(
                "Dummy", "Dummy", "Dummy", new Timestamp(), new Timestamp());
        return transFormOneMessage(invoiceMessageRule);
    }

}
