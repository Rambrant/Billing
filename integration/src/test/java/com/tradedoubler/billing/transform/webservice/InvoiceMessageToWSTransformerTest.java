package com.tradedoubler.billing.transform.webservice;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalesinvr.AxdEntityMDSSalesInvoiceMessage;
import com.tradedoubler.billing.domain.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * User: erigu
 * Date: 2012-09-21
 */
public class InvoiceMessageToWSTransformerTest {

    private InvoicingMessageRuleToAxNestedSalesInvoiceMessageTransformer invoiceMessageToAxSalesInvoiceMessageTransformerMessageNested;

    @Test
    public void testTransform(){

        List<InvoicingRuleMessageRule> invoiceMessageRules = createInvoiceMessages();
        invoiceMessageToAxSalesInvoiceMessageTransformerMessageNested = new InvoicingMessageRuleToAxNestedSalesInvoiceMessageTransformer(invoiceMessageRules);


        List<AxdEntityMDSSalesInvoiceMessage> axObject = invoiceMessageToAxSalesInvoiceMessageTransformerMessageNested.transform();
        assertEquals(2, axObject.size());

        for (int i = 0; i < axObject.size(); i++) {
            AxdEntityMDSSalesInvoiceMessage invoiceMessage = axObject.get(i);
            assertEquals("{ORDERLINEID" + i + "}", invoiceMessage.getInvoiceMessageId());
            assertEquals("entity", invoiceMessage.getClazz());
            assertEquals("2012-10-26", invoiceMessage.getValidFrom().toString());
            assertEquals("2012-10-28", invoiceMessage.getValidTo().toString());
            assertEquals("text", invoiceMessage.getText());
            assertEquals("InvoiceRule", invoiceMessage.getSourceType().value());
        }
    }

    @Test
    public void testCreateDummy(){

        List<InvoicingRuleMessageRule> purchaseOrders = createInvoiceMessages();
        invoiceMessageToAxSalesInvoiceMessageTransformerMessageNested = new InvoicingMessageRuleToAxNestedSalesInvoiceMessageTransformer(purchaseOrders);

        AxdEntityMDSSalesInvoiceMessage axObject = invoiceMessageToAxSalesInvoiceMessageTransformerMessageNested.dummyAxdEntityMDSSalesInvoiceMessageForDeleteOperation();
        assertNotNull(axObject);
        assertEquals("InvoiceRule", axObject.getSourceType().value());
        assertEquals("Dummy", axObject.getText());

    }

    private List<InvoicingRuleMessageRule> createInvoiceMessages() {
        List<InvoicingRuleMessageRule> messageRules = new ArrayList<InvoicingRuleMessageRule>();

        for (int i = 0; i < 2; i++) {
            String id = "orderLineID";
            String fromDate = "2012-10-26";
            String toDate = "2012-10-28";
            InvoicingRuleMessageRule messageRule = new InvoicingRuleMessageRule(id + i, "TELIA", "text", new Timestamp(fromDate), new Timestamp(toDate));
            messageRules.add(messageRule);
        }

        return messageRules;
    }

}
