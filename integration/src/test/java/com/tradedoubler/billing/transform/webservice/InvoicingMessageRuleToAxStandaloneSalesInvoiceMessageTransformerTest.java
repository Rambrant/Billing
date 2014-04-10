package com.tradedoubler.billing.transform.webservice;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvmes.*;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumMDSSalesMessageSourceType;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.ax.webservice.call.FindInvoiceMessageRuleCall;
import org.junit.*;
import org.mockito.*;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * User: erigu
 * Date: 2012-09-21
 */
public class InvoicingMessageRuleToAxStandaloneSalesInvoiceMessageTransformerTest {

    @Mock
    private
    FindInvoiceMessageRuleCall findCall;

    private InvoicingMessageRuleToAxStandaloneSalesInvoiceMessageTransformer invoicingMessageRuleToAxStandaloneSalesInvoiceMessageTransformer;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testTransform() {

        InvoiceMessageRule invoiceMessageRule = createInvoiceMessage();
        invoicingMessageRuleToAxStandaloneSalesInvoiceMessageTransformer = new InvoicingMessageRuleToAxStandaloneSalesInvoiceMessageTransformer(invoiceMessageRule);


        AxdEntityMDSSalesInvoiceMessage invoiceMessage = invoicingMessageRuleToAxStandaloneSalesInvoiceMessageTransformer.transform();

        assertEquals("{INVOICEMESSID}", invoiceMessage.getInvoiceMessageId());
        assertEquals("entity", invoiceMessage.getClazz());
        assertEquals("2012-10-26", invoiceMessage.getValidFrom().toString());
        assertEquals("2012-10-28", invoiceMessage.getValidTo().toString());
        assertEquals("text", invoiceMessage.getText());
        assertEquals("Customer", invoiceMessage.getSourceType().value());

    }

    @Test
    public void testTransformUpdateWithReadCall() {

        InvoiceMessageRule invoiceMessageRule = createInvoiceMessage();
        invoicingMessageRuleToAxStandaloneSalesInvoiceMessageTransformer = new InvoicingMessageRuleToAxStandaloneSalesInvoiceMessageTransformer(invoiceMessageRule);
        ObjectFactory objectFactory = new ObjectFactory();
        when(findCall.getDocumentHash()).thenReturn(objectFactory.createAxdEntityMDSSalesInvoiceMessageDocumentHash("12345abc"));
        when(findCall.getSourceType()).thenReturn(AxdEnumMDSSalesMessageSourceType.INVOICE_RULE);

        AxdEntityMDSSalesInvoiceMessage invoiceMessage = invoicingMessageRuleToAxStandaloneSalesInvoiceMessageTransformer.transformForUpdate(findCall);

        assertEquals("{INVOICEMESSID}", invoiceMessage.getInvoiceMessageId());
        assertEquals("entity", invoiceMessage.getClazz());
        assertEquals("2012-10-26", invoiceMessage.getValidFrom().toString());
        assertEquals("2012-10-28", invoiceMessage.getValidTo().toString());
        assertEquals("text", invoiceMessage.getText());
        assertEquals("InvoiceRule", invoiceMessage.getSourceType().value());
    }

    @Test
    public void testTransformUpdateWithFindCall() {

        InvoiceMessageRule invoiceMessageRule = createInvoiceMessage();
        invoicingMessageRuleToAxStandaloneSalesInvoiceMessageTransformer = new InvoicingMessageRuleToAxStandaloneSalesInvoiceMessageTransformer(invoiceMessageRule);
        ObjectFactory objectFactory = new ObjectFactory();
        when(findCall.getDocumentHash()).thenReturn(objectFactory.createAxdEntityMDSSalesInvoiceMessageDocumentHash("12345abc"));
        when(findCall.getSourceType()).thenReturn(AxdEnumMDSSalesMessageSourceType.INVOICE_RULE);

        AxdEntityMDSSalesInvoiceMessage invoiceMessage = invoicingMessageRuleToAxStandaloneSalesInvoiceMessageTransformer.transformForUpdate(findCall);

        assertEquals("{INVOICEMESSID}", invoiceMessage.getInvoiceMessageId());
        assertEquals("entity", invoiceMessage.getClazz());
        assertEquals("2012-10-26", invoiceMessage.getValidFrom().toString());
        assertEquals("2012-10-28", invoiceMessage.getValidTo().toString());
        assertEquals("text", invoiceMessage.getText());
        assertEquals("InvoiceRule", invoiceMessage.getSourceType().value());
    }

    @Test
    public void testSourceType() {
        InvoiceMessageRule invoiceMessageRuleCust = new ClientMessageRule("id", "ID", "text", new Timestamp(), new Timestamp());
        InvoiceMessageRule invoiceMessageRuleInvRule = new InvoicingRuleMessageRule("id", "ID", "text", new Timestamp(), new Timestamp());
        InvoiceMessageRule invoiceMessageRuleMarket = new InvoiceIssuerMessageRule("id", 1, "text", new Timestamp(), new Timestamp());

        invoicingMessageRuleToAxStandaloneSalesInvoiceMessageTransformer = new InvoicingMessageRuleToAxStandaloneSalesInvoiceMessageTransformer(invoiceMessageRuleCust);
        AxdEntityMDSSalesInvoiceMessage axInvMessageService = invoicingMessageRuleToAxStandaloneSalesInvoiceMessageTransformer.transform();
        assertEquals("Customer", axInvMessageService.getSourceType().value());

        invoicingMessageRuleToAxStandaloneSalesInvoiceMessageTransformer = new InvoicingMessageRuleToAxStandaloneSalesInvoiceMessageTransformer(invoiceMessageRuleInvRule);
        axInvMessageService = invoicingMessageRuleToAxStandaloneSalesInvoiceMessageTransformer.transform();

        assertEquals("InvoiceRule", axInvMessageService.getSourceType().value());

        invoicingMessageRuleToAxStandaloneSalesInvoiceMessageTransformer = new InvoicingMessageRuleToAxStandaloneSalesInvoiceMessageTransformer(invoiceMessageRuleMarket);
        axInvMessageService = invoicingMessageRuleToAxStandaloneSalesInvoiceMessageTransformer.transform();

        assertEquals("Company", axInvMessageService.getSourceType().value());

    }

    private InvoiceMessageRule createInvoiceMessage() {

        String id = "invoiceMessID";
        String fromDate = "2012-10-26";
        String toDate = "2012-10-28";

        return new ClientMessageRule(id, "TELIA", "text", new Timestamp(fromDate), new Timestamp(toDate));
    }

}
