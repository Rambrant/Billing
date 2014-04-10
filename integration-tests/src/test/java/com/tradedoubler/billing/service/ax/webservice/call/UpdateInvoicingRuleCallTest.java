package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalesinvr.AxdEntityMDSSalesInvoiceMessage;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumMDSSalesMessageSourceType;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.webservice.domainhandler.InvoicingRuleHandler;
import com.tradedoubler.billing.util.AxDbConstantsUtil;
import org.hamcrest.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

import static com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumMDSSalesMessageSourceType.*;
import static com.tradedoubler.billing.util.AxDbConstantsUtil.*;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * @author bjoek
 * @since 2012-07-02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class UpdateInvoicingRuleCallTest {
    private static final String INV_RULE_MESSAGE_ID1 = "00000000-0000-0000-3000-100000000001";
    private static final String INV_RULE_MESSAGE_ID2 = "00000000-0000-0000-3000-100000000002";
    private static final String INV_RULE_MESSAGE_ID3 = "00000000-0000-0000-3000-100000000003";

    private static final String PURCHASE_ORDER_ID1 = "00000000-0000-0000-4000-100000000001";
    private static final String PURCHASE_ORDER_ID2 = "00000000-0000-0000-4000-100000000002";
    private static final String PURCHASE_ORDER_ID3 = "00000000-0000-0000-4000-100000000003";

    @Autowired
    private InvoicingRuleHandler invoicingRuleHandler;

    @Test
    public void updateExistingShouldWork() throws BillingServiceException {
        InvoicingRule invoicingRule = createInvoicingRule(EXISTING_INVOICE_RULE_ID,
                createMessages(EXISTING_INVOICE_RULE_ID, INV_RULE_MESSAGE_ID1),
                createPurchaseOrders(EXISTING_INVOICE_RULE_ID, PURCHASE_ORDER_ID1));

        FindInvoicingRuleCall readInvoicingRuleCall = invoicingRuleHandler.findInvoicingRuleByPk(invoicingRule.getInvoicingRuleId(), invoicingRule.getMarketId());

        invoicingRuleHandler.updateInvoicingRule(readInvoicingRuleCall, invoicingRule);
    }

    @Test
    public void updateNonExistingShouldNotWork() throws BillingServiceException {
        InvoicingRule invoicingRule = createInvoicingRule(EXISTING_INVOICE_RULE_ID,
                createMessages(EXISTING_INVOICE_RULE_ID, INV_RULE_MESSAGE_ID1),
                createPurchaseOrders(EXISTING_INVOICE_RULE_ID, PURCHASE_ORDER_ID1));

        FindInvoicingRuleCall readInvoicingRuleCall = invoicingRuleHandler.findInvoicingRuleByPk(invoicingRule.getInvoicingRuleId(), invoicingRule.getMarketId());

        // Change the id
        String id = generateInvoiceRuleId();
        invoicingRule.setInvoicingRuleId(id);

        try {
            invoicingRuleHandler.updateInvoicingRule(readInvoicingRuleCall, invoicingRule);
            fail();
        } catch (BillingServiceException bsex) {
            assertThat(bsex.getMessage(), startsWith("InvoicingRule PK: {" + id.toUpperCase() +
                    "}, dataAreaId: SE02  , No valid document identified from the entity key."));
        }
    }

    @Test
    public void updateWithInvalidHashShouldNotWork() throws BillingServiceException {
        InvoicingRule invoicingRule = createInvoicingRule(EXISTING_INVOICE_RULE_ID,
                createMessages(EXISTING_INVOICE_RULE_ID, INV_RULE_MESSAGE_ID1),
                createPurchaseOrders(EXISTING_INVOICE_RULE_ID, PURCHASE_ORDER_ID1));

        FindInvoicingRuleCall readInvoicingRuleCall = spy(invoicingRuleHandler.findInvoicingRuleByPk(invoicingRule.getInvoicingRuleId(), invoicingRule.getMarketId()));

        // Replace the document hash
        when(readInvoicingRuleCall.getDocumentHash()).thenReturn("Dummy");

        try {
            invoicingRuleHandler.updateInvoicingRule(readInvoicingRuleCall, invoicingRule);
            fail();
        } catch (BillingServiceException bsex) {
            assertThat(bsex.getMessage(), startsWith("InvoicingRule PK: {3F2504E0-4F89-11D3-9A0C-0305E82C3405}, dataAreaId: SE02  , The document hash does not match the hash in the XML."));
        }
    }

    @Test
    public void deletePurchaseOrderShouldWork() throws BillingServiceException {
        InvoicingRule invoicingRule = createInvoicingRule(EXISTING_INVOICE_RULE_ID, new ArrayList<InvoicingRuleMessageRule>(),
                new ArrayList<PurchaseOrder>());

        // Clear all purchase order
        FindInvoicingRuleCall readInvoicingRuleCall = invoicingRuleHandler.findInvoicingRuleByPk(invoicingRule.getInvoicingRuleId(), invoicingRule.getMarketId());
        invoicingRuleHandler.updateInvoicingRule(readInvoicingRuleCall, invoicingRule);
        readInvoicingRuleCall = invoicingRuleHandler.findInvoicingRuleByPk(invoicingRule.getInvoicingRuleId(), invoicingRule.getMarketId());
        assertThat(readInvoicingRuleCall.getInvoiceRule().getMDSSalesInvoiceMessage().size(), is(0));

        String purchaseOrderId = AxDbConstantsUtil.generatePurchaseOrderId();
        invoicingRule = createInvoicingRule(EXISTING_INVOICE_RULE_ID, new ArrayList<InvoicingRuleMessageRule>(),
                createPurchaseOrders(EXISTING_INVOICE_RULE_ID, purchaseOrderId));

        // Add one purchase order
        invoicingRuleHandler.updateInvoicingRule(readInvoicingRuleCall, invoicingRule);
        readInvoicingRuleCall = invoicingRuleHandler.findInvoicingRuleByPk(invoicingRule.getInvoicingRuleId(), invoicingRule.getMarketId());
        List<AxdEntityMDSSalesInvoiceMessage> mdsSalesInvoiceMessage = readInvoicingRuleCall.getInvoiceRule().getMDSSalesInvoiceMessage();
        assertThat(mdsSalesInvoiceMessage.size(), is(1));
        assertThat(mdsSalesInvoiceMessage.get(0).getInvoiceMessageId(), is(new Guid(purchaseOrderId).getGuidForAx()));
        assertThat(mdsSalesInvoiceMessage.get(0).getSourceType(), is(INVOICE_RULE_PURCHASE_ORDER));

        invoicingRule = createInvoicingRule(EXISTING_INVOICE_RULE_ID, new ArrayList<InvoicingRuleMessageRule>(),
                        new ArrayList<PurchaseOrder>());

        // Clear purchase order
        invoicingRuleHandler.updateInvoicingRule(readInvoicingRuleCall, invoicingRule);
        readInvoicingRuleCall = invoicingRuleHandler.findInvoicingRuleByPk(invoicingRule.getInvoicingRuleId(), invoicingRule.getMarketId());
        assertThat(readInvoicingRuleCall.getInvoiceRule().getMDSSalesInvoiceMessage().size(), is(0));
    }

    @Test
    public void updateExistingWithNewInvRuleMessageShouldWork() throws BillingServiceException {
        // Make sure that there is only one random invoice rule message regardless of prior state
        String messageId = generateInvoiceMessageRuleId();
        String purchaseOrderId = generateSplittingRuleId();
        InvoicingRule invoicingRule = createInvoicingRule(EXISTING_INVOICE_RULE_ID,
                createMessages(EXISTING_INVOICE_RULE_ID, messageId),
                createPurchaseOrders(EXISTING_INVOICE_RULE_ID, purchaseOrderId));

        FindInvoicingRuleCall readInvoicingRuleCall = invoicingRuleHandler.findInvoicingRuleByPk(invoicingRule.getInvoicingRuleId(), invoicingRule.getMarketId());

        invoicingRuleHandler.updateInvoicingRule(readInvoicingRuleCall, invoicingRule);

        // Invoice rule should now contain one message
        readInvoicingRuleCall = invoicingRuleHandler.findInvoicingRuleByPk(invoicingRule.getInvoicingRuleId(), invoicingRule.getMarketId());
        assertThat(readInvoicingRuleCall.getInvoiceRule().getMDSSalesInvoiceMessage().size(), is(2));
        assertThat(readInvoicingRuleCall.getInvoiceRule().getMDSSalesInvoiceMessage().get(0),
                matchesInvMessage("{" + messageId.toUpperCase() + "}", INVOICE_RULE));
        assertThat(readInvoicingRuleCall.getInvoiceRule().getMDSSalesInvoiceMessage().get(1),
                matchesInvMessage("{" + purchaseOrderId.toUpperCase() + "}", INVOICE_RULE_PURCHASE_ORDER));


        // Update to three messages
        invoicingRule = createInvoicingRule(EXISTING_INVOICE_RULE_ID,
                createMessages(EXISTING_INVOICE_RULE_ID, INV_RULE_MESSAGE_ID1, INV_RULE_MESSAGE_ID2, INV_RULE_MESSAGE_ID3),
                createPurchaseOrders(EXISTING_INVOICE_RULE_ID, PURCHASE_ORDER_ID1, PURCHASE_ORDER_ID2, PURCHASE_ORDER_ID3));

        invoicingRuleHandler.updateInvoicingRule(readInvoicingRuleCall, invoicingRule);

        readInvoicingRuleCall = invoicingRuleHandler.findInvoicingRuleByPk(invoicingRule.getInvoicingRuleId(), invoicingRule.getMarketId());

        // Invoice rule should now contain three messages
        assertThat(readInvoicingRuleCall.getInvoiceRule().getMDSSalesInvoiceMessage().size(), is(6));
        assertThat(readInvoicingRuleCall.getInvoiceRule().getMDSSalesInvoiceMessage().get(0).getInvoiceMessageId(),
                anyOf(is("{" + INV_RULE_MESSAGE_ID1 + "}"),
                        is("{" + INV_RULE_MESSAGE_ID2 + "}"),
                        is("{" + INV_RULE_MESSAGE_ID3 + "}")));
        assertThat(readInvoicingRuleCall.getInvoiceRule().getMDSSalesInvoiceMessage().get(1).getInvoiceMessageId(),
                anyOf(is("{" + INV_RULE_MESSAGE_ID1 + "}"),
                        is("{" + INV_RULE_MESSAGE_ID2 + "}"),
                        is("{" + INV_RULE_MESSAGE_ID3 + "}")));
        assertThat(readInvoicingRuleCall.getInvoiceRule().getMDSSalesInvoiceMessage().get(2).getInvoiceMessageId(),
                anyOf(is("{" + INV_RULE_MESSAGE_ID1 + "}"),
                        is("{" + INV_RULE_MESSAGE_ID2 + "}"),
                        is("{" + INV_RULE_MESSAGE_ID3 + "}")));
        assertThat(readInvoicingRuleCall.getInvoiceRule().getMDSSalesInvoiceMessage().get(3).getInvoiceMessageId(),
                anyOf(is("{" + PURCHASE_ORDER_ID1 + "}"),
                        is("{" + PURCHASE_ORDER_ID2 + "}"),
                        is("{" + PURCHASE_ORDER_ID3 + "}")));
        assertThat(readInvoicingRuleCall.getInvoiceRule().getMDSSalesInvoiceMessage().get(4).getInvoiceMessageId(),
                anyOf(is("{" + PURCHASE_ORDER_ID1 + "}"),
                        is("{" + PURCHASE_ORDER_ID2 + "}"),
                        is("{" + PURCHASE_ORDER_ID3 + "}")));
        assertThat(readInvoicingRuleCall.getInvoiceRule().getMDSSalesInvoiceMessage().get(5).getInvoiceMessageId(),
                anyOf(is("{" + PURCHASE_ORDER_ID1 + "}"),
                        is("{" + PURCHASE_ORDER_ID2 + "}"),
                        is("{" + PURCHASE_ORDER_ID3 + "}")));


        // Update to one message again
        invoicingRule = createInvoicingRule(EXISTING_INVOICE_RULE_ID,
                createMessages(EXISTING_INVOICE_RULE_ID, INV_RULE_MESSAGE_ID1),
                createPurchaseOrders(EXISTING_INVOICE_RULE_ID, PURCHASE_ORDER_ID1));

        invoicingRuleHandler.updateInvoicingRule(readInvoicingRuleCall, invoicingRule);

        readInvoicingRuleCall = invoicingRuleHandler.findInvoicingRuleByPk(invoicingRule.getInvoicingRuleId(), invoicingRule.getMarketId());

        // Invoice rule should now contain one message
        assertThat(readInvoicingRuleCall.getInvoiceRule().getMDSSalesInvoiceMessage().size(), is(2));
        assertThat(readInvoicingRuleCall.getInvoiceRule().getMDSSalesInvoiceMessage().get(0),
                matchesInvMessage("{" + INV_RULE_MESSAGE_ID1 + "}", INVOICE_RULE));
        assertThat(readInvoicingRuleCall.getInvoiceRule().getMDSSalesInvoiceMessage().get(1),
                matchesInvMessage("{" + PURCHASE_ORDER_ID1 + "}", INVOICE_RULE_PURCHASE_ORDER));
    }

    private InvoicingRule createInvoicingRule(String invoiceRuleId, List<InvoicingRuleMessageRule> messages, List<PurchaseOrder> purchaseOrders) {
        return new InvoicingRule(EXISTING_CLIENT_ACCOUNT_NUM,
                51, invoiceRuleId, "Test", "test", "Issuer Reference", "John Doe", "SEK", 1, 30, 1, true,
                1, 1, false, new ArrayList<InvoiceRecipient>(), purchaseOrders,
                messages, new ArrayList<String>());
    }

    private List<InvoicingRuleMessageRule> createMessages(String invoiceRuleId, String... invRuleMessageId) {
        List<InvoicingRuleMessageRule> messages = new ArrayList<InvoicingRuleMessageRule>();
        for (String messageId : invRuleMessageId) {
            messages.add(new InvoicingRuleMessageRule(messageId, invoiceRuleId, "messageText",
                    new Timestamp(), new Timestamp()));
        }
        return messages;
    }

    private List<PurchaseOrder> createPurchaseOrders(String invoiceRuleId, String... purchaseOrderId) {
        List<PurchaseOrder> messages = new ArrayList<PurchaseOrder>();
        for (String id : purchaseOrderId) {
            messages.add(new PurchaseOrder(id, invoiceRuleId, "poNumber",
                    new Timestamp(), new Timestamp()));
        }
        return messages;
    }

    private Matcher<AxdEntityMDSSalesInvoiceMessage> matchesInvMessage(final String id, final AxdEnumMDSSalesMessageSourceType sourceType) {
        return new TypeSafeMatcher<AxdEntityMDSSalesInvoiceMessage>() {
            @Override
            protected boolean matchesSafely(AxdEntityMDSSalesInvoiceMessage axdEntityMDSSalesInvoiceMessage) {
                return axdEntityMDSSalesInvoiceMessage.getInvoiceMessageId().equals(id) &&
                        axdEntityMDSSalesInvoiceMessage.getSourceType() == sourceType;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText(String.format("Check that id is %s and sourceType is %s", id, sourceType));
            }
        };
    }

}
