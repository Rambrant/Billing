package com.tradedoubler.billing.transform.webservice;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvmes.AxdEntityMDSSalesInvoiceMessage;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumMDSSalesMessageSourceType;
import com.tradedoubler.billing.domain.InvoiceMessageRule;
import com.tradedoubler.billing.service.ax.webservice.call.*;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * This class transforms Invoice RuleMessages that are communicated to the AX RuleMessage webservice.<br>
 * <b>Note:</b> the wsdl Ax rule message object transformed here is not to be mixed up with the AX web service wsdl object, having the same name,
 * that belongs to the Ax invoice rule web service.
 */
public class InvoicingMessageRuleToAxStandaloneSalesInvoiceMessageTransformer {

    private final InvoiceMessageRule invoiceMessageRule;

    public InvoicingMessageRuleToAxStandaloneSalesInvoiceMessageTransformer(InvoiceMessageRule invoiceMessageRule) {
        this.invoiceMessageRule = invoiceMessageRule;
    }


    public AxdEntityMDSSalesInvoiceMessage transform() {
        AxdEntityMDSSalesInvoiceMessage message = new AxdEntityMDSSalesInvoiceMessage();
        message.setClazz("entity");
        message.setInvoiceMessageId(invoiceMessageRule.getInvoiceMessageRuleId().getGuidForAx());
        message.setSourceType(getSource());
        message.setText(invoiceMessageRule.getMessageText());
        XMLGregorianCalendar from = DateConverter.convertISO8601ToXMLGregorianCalendar(invoiceMessageRule.getValidFrom().getTimestamp());
        XMLGregorianCalendar to = DateConverter.convertISO8601ToXMLGregorianCalendar(invoiceMessageRule.getValidTo().getTimestamp());
        message.setValidFrom(from);
        message.setValidTo(to);
        return message;
    }

    /**
     * The invoice message can be connected to a client, invoice issuer or to an invoicing rule.
     */
    private AxdEnumMDSSalesMessageSourceType getSource() {
        switch (invoiceMessageRule.getSourceType()) {
            case INVOICE_RULE:
                return AxdEnumMDSSalesMessageSourceType.INVOICE_RULE;
            case COMPANY:
                return AxdEnumMDSSalesMessageSourceType.COMPANY;
            case CUSTOMER:
                return AxdEnumMDSSalesMessageSourceType.CUSTOMER;
            case INVOICE_RULE_PURCHASE_ORDER:
                throw new IllegalStateException(String.format(
                        "InvoiceMessageRule cannot have source type 'purchase order', InvoiceMessageRuleId: %s",
                        invoiceMessageRule.getInvoiceMessageRuleId()));
        }
        throw new IllegalArgumentException("Cannot handle SourceType: " + invoiceMessageRule.getSourceType());
    }

    public AxdEntityMDSSalesInvoiceMessage transformForUpdate(FindInvoiceMessageRuleCall findCall) {
        AxdEntityMDSSalesInvoiceMessage axInvMessage = transform();
        AxUtil.addUpdateInfoOnInvoiceMessage(axInvMessage, findCall.getDocumentHash(), findCall.getSourceType());
        return axInvMessage;
    }
}
