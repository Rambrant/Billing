package com.tradedoubler.billing.service;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalesinvr.*;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvrec.AxdEntityMDSSalesInvoiceRecipient;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.*;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.platform.flowcontroller.*;
import org.hamcrest.*;
import org.junit.*;
import org.mockito.ArgumentCaptor;

import javax.xml.bind.JAXBElement;
import java.util.*;

import static com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumAxdEntityAction.*;
import static com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumMDSSalesMessageSourceType.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;


/**
 * @author bjoek
 * @since 2012-09-04
 */
public class InvoicingRuleUpdatedGraphTest extends AbstractGraphHelper {

    private final InvoicingRule invoicingRule = DomainEntityFactory.createInvoicingRule();
    private ServiceResult serviceResult;

    private final AxdEntityMDSSalesInvoiceRule axInvoiceRule = createAxInvoicingRule();
    private final List<AxdEntityMDSSalesInvoiceRecipient> axInvoiceRecipientList = createAxInvoiceRecipientList();

    public InvoicingRuleUpdatedGraphTest() throws IllegalAccessException {
        super();
    }

    @Before
    public void setUp() throws Exception {
        serviceResult = createServiceResult(new InvoicingRuleUpdated(null, invoicingRule));
    }

    private AxdEntityMDSSalesInvoiceRule createAxInvoicingRule() {
        AxdEntityMDSSalesInvoiceRule axdEntityMDSSalesInvoiceRule = new AxdEntityMDSSalesInvoiceRule();

        axdEntityMDSSalesInvoiceRule.getMDSSalesInvoiceMessage().add(createAxInvMessage("invoiceMessageRuleId1", INVOICE_RULE));
        axdEntityMDSSalesInvoiceRule.getMDSSalesInvoiceMessage().add(createAxInvMessage("invoiceMessageRuleId3", INVOICE_RULE));
        axdEntityMDSSalesInvoiceRule.getMDSSalesInvoiceMessage().add(createAxInvMessage("PurchaseOrderId1", INVOICE_RULE_PURCHASE_ORDER));
        axdEntityMDSSalesInvoiceRule.getMDSSalesInvoiceMessage().add(createAxInvMessage("PurchaseOrderId3", INVOICE_RULE_PURCHASE_ORDER));
        return axdEntityMDSSalesInvoiceRule;
    }

    private AxdEntityMDSSalesInvoiceMessage createAxInvMessage(String id, AxdEnumMDSSalesMessageSourceType sourceType) {
        AxdEntityMDSSalesInvoiceMessage axInvoiceMessage = new AxdEntityMDSSalesInvoiceMessage();
        axInvoiceMessage.setInvoiceMessageId("{" + id.toUpperCase() + "}");
        axInvoiceMessage.setSourceType(sourceType);
        return axInvoiceMessage;
    }

    private List<AxdEntityMDSSalesInvoiceRecipient> createAxInvoiceRecipientList() {
        AxdEntityMDSSalesInvoiceRecipient invoiceRecipient1 = new AxdEntityMDSSalesInvoiceRecipient();
        invoiceRecipient1.setInvoiceRecipientId("{invRecId1}".toUpperCase());

        AxdEntityMDSSalesInvoiceRecipient invoiceRecipient3 = new AxdEntityMDSSalesInvoiceRecipient();
        invoiceRecipient3.setInvoiceRecipientId("{invRecId3}".toUpperCase());

        List<AxdEntityMDSSalesInvoiceRecipient> list = new ArrayList<AxdEntityMDSSalesInvoiceRecipient>();
        list.add(invoiceRecipient1);
        list.add(invoiceRecipient3);
        return list;
    }

    @Test
    public void nonExistingInvoiceRuleShouldThrowIntDisturbance() throws Exception {
        when(findInvoicingRuleCall.getNumberOfInvoicingRules()).thenReturn(0);

        try{
            axService.updateInvoicingRule(serviceResult);
            fail();
        } catch (BillingServiceException bsex) {
            assertThat(bsex.getMessage(), startsWith("Cannot find invoicing rule when updating, invoiceRuleId: {3F2504E0-4F89-11D3-9A0C-0305E82C3405}"));
            assertThat(bsex.getCategory(), is(ServiceResultCategory.INTEGRATION_DISTURBANCE));
        }

        verify(findInvoicingRuleCall).execute(invoicingRule.getInvoicingRuleId(), "SE02");
        verify(findInvoicingRuleCall).getAxRequestResult();
        verify(findInvoicingRuleCall).getNumberOfInvoicingRules();

        // verify no calls
        verifyNoMoreInteractions(findInvoicingRuleCall,
                updateInvoicingRuleCall,
                findInvoiceRecipientsByInvoicingRuleCall,
                deleteInvoiceRecipientCall,
                findInvoiceRecipientCall,
                insertInvoiceRecipientCall,
                updateInvoiceRecipientCall);
    }

    @Test
    public void existingInvoiceRuleShouldUpdate() throws Exception {
        when(findInvoicingRuleCall.getNumberOfInvoicingRules()).thenReturn(1);
        when(findInvoicingRuleCall.getInvoiceRule()).thenReturn(axInvoiceRule);

        axService.updateInvoicingRule(serviceResult);


        // Check that find is run for both client market array and bank markets
        verify(findInvoicingRuleCall).getNumberOfInvoicingRules();
        verify(updateInvoicingRuleCall).execute(any(AxdEntityMDSSalesInvoiceRule.class));
    }

    @Test
    public void axInvoiceMessagesShouldBeFlaggedCorrectlyWhenUpdating() throws BillingServiceException {
        when(findInvoicingRuleCall.getNumberOfInvoicingRules()).thenReturn(1);
        when(findInvoicingRuleCall.getInvoiceRule()).thenReturn(axInvoiceRule);

        axService.updateInvoicingRule(serviceResult);

        // Capture the argument to the update method
        ArgumentCaptor<AxdEntityMDSSalesInvoiceRule> axInvMessCaptor = ArgumentCaptor.forClass(AxdEntityMDSSalesInvoiceRule.class);
        verify(updateInvoicingRuleCall).execute(axInvMessCaptor.capture());
        AxdEntityMDSSalesInvoiceRule value = axInvMessCaptor.getValue();

        List<AxdEntityMDSSalesInvoiceMessage> invoiceMessages = value.getMDSSalesInvoiceMessage();
        assertThat(invoiceMessages.size(), is(6));

        //invoiceMessageRuleId1 and PurchaseOrderId1 should be updated
        //invoiceMessageRuleId2 and PurchaseOrderId2 should be created (they are new)
        //invoiceMessageRuleId3 and PurchaseOrderId3 should be deleted (they are not part of new)
        assertThat(invoiceMessages.get(0), matchesInvMessage("invoiceMessageRuleId1", UPDATE, INVOICE_RULE));
        assertThat(invoiceMessages.get(1), matchesInvMessage("invoiceMessageRuleId2", CREATE, INVOICE_RULE));
        assertThat(invoiceMessages.get(2), matchesInvMessage("PurchaseOrderId1", UPDATE, INVOICE_RULE_PURCHASE_ORDER));
        assertThat(invoiceMessages.get(3), matchesInvMessage("PurchaseOrderId2", CREATE, INVOICE_RULE_PURCHASE_ORDER));
        assertThat(invoiceMessages.get(4), matchesInvMessage("invoiceMessageRuleId3", DELETE, INVOICE_RULE));

        //A purchase order that is to be removed does not have be of right type (since the delete only looks on id)
        assertThat(invoiceMessages.get(5), matchesInvMessage("PurchaseOrderId3", DELETE, INVOICE_RULE));
    }

    private Matcher<AxdEntityMDSSalesInvoiceMessage> matchesInvMessage(final String invoiceMessageRuleId1, final AxdEnumAxdEntityAction action, final AxdEnumMDSSalesMessageSourceType sourceType) {
        return new TypeSafeMatcher<AxdEntityMDSSalesInvoiceMessage>() {
            @Override
            protected boolean matchesSafely(AxdEntityMDSSalesInvoiceMessage axdEntityMDSSalesInvoiceMessage) {
                return axdEntityMDSSalesInvoiceMessage.getInvoiceMessageId().equals("{" + invoiceMessageRuleId1.toUpperCase() + "}") &&
                        axdEntityMDSSalesInvoiceMessage.getAction() == action &&
                        axdEntityMDSSalesInvoiceMessage.getSourceType() == sourceType;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText(String.format("Check that id is %s and action is %s and sourceType is %s", invoiceMessageRuleId1, action, sourceType));
            }
        };
    }

    @Test
    public void invoiceRecipientsThatAreNotPartOfaCallShouldBeIgnored() throws BillingServiceException {
        when(findInvoicingRuleCall.getNumberOfInvoicingRules()).thenReturn(1);
        when(findInvoicingRuleCall.getInvoiceRule()).thenReturn(axInvoiceRule);
        when(findInvoiceRecipientsByInvoicingRuleCall.getInvoiceRecipients()).thenReturn(axInvoiceRecipientList);

        axService.updateInvoicingRule(serviceResult);

        // Invoice Recipient 3 is part of findInvoiceRecipientsByInvoicingRuleCall but not part of the new values, it should be ignored
        verifyNoMoreInteractions(deleteInvoiceRecipientCall);
    }

    @Test
    public void invoiceRecipientsShouldBeUpdated() throws BillingServiceException {
        when(findInvoicingRuleCall.getNumberOfInvoicingRules()).thenReturn(1);
        when(findInvoicingRuleCall.getInvoiceRule()).thenReturn(axInvoiceRule);
        when(findInvoiceRecipientsByInvoicingRuleCall.getInvoiceRecipients()).thenReturn(axInvoiceRecipientList);
        // Entities are found
        when(findInvoiceRecipientCall.getNumberOfInvoiceRecipient()).thenReturn(1);

        axService.updateInvoicingRule(serviceResult);

        verify(findInvoiceRecipientCall).execute("{INVRECID1}", "SE02");
        verify(findInvoiceRecipientCall).execute("{INVRECID2}", "SE02");
        // Entities are updated
        verify(updateInvoiceRecipientCall, times(2)).execute(any(AxdEntityMDSSalesInvoiceRecipient.class), any(JAXBElement.class), eq("SE02"));
    }

    @Test
    public void invoiceRecipientsShouldBeInserted() throws BillingServiceException {
        when(findInvoicingRuleCall.getNumberOfInvoicingRules()).thenReturn(1);
        when(findInvoicingRuleCall.getInvoiceRule()).thenReturn(axInvoiceRule);
        when(findInvoiceRecipientsByInvoicingRuleCall.getInvoiceRecipients()).thenReturn(axInvoiceRecipientList);
        // Entities are not found
        when(findInvoiceRecipientCall.getNumberOfInvoiceRecipient()).thenReturn(0);

        axService.updateInvoicingRule(serviceResult);

        verify(findInvoiceRecipientCall).execute("{INVRECID1}", "SE02");
        verify(findInvoiceRecipientCall).execute("{INVRECID2}", "SE02");
        // Entities are inserted
        verify(insertInvoiceRecipientCall, times(2)).execute(any(AxdEntityMDSSalesInvoiceRecipient.class), eq("SE02"));
    }

    @Test
    public void displayTdCommissionIdsShouldUpdated() throws BillingServiceException {
        panService.updateDisplayTradeDoublerCommission(serviceResult);

        // The program ids are sourceSystemAgreementId sans the "1-"
        verify(updateCommissionCall).updateDisplayCommission(1234, true);
        verify(updateCommissionCall).updateDisplayCommission(4321, true);
        verifyNoMoreInteractions(updateCommissionCall);
    }


}
