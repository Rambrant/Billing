package com.tradedoubler.billing.service;

import com.microsoft.schemas.dynamics._2008._01.documents.customer.*;
import com.microsoft.schemas.dynamics._2008._01.documents.customer.ObjectFactory;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgcustbank.AxdEntityCustBankAccount;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalescla.AxdEntityMDSSalesClientAgreement;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalesinvr.*;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvrec.AxdEntityMDSSalesSplitter;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumMDSSalesMessageSourceType;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.mulecomponent.MuleInvoicingRuleCreated;
import com.tradedoubler.billing.platform.flowcontroller.ServiceResult;
import com.tradedoubler.testutil.ReflectionHelper;
import org.junit.*;
import org.mockito.ArgumentCaptor;

import java.util.*;

import static com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumMDSSalesMessageSourceType.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;


/**
 * @author bjoek
 * @since 2012-09-04
 */
public class InvoicingRuleCreatedGraphTest extends AbstractGraphHelper {

    private final InvoicingRule invoicingRule = DomainEntityFactory.createInvoicingRule();
    private final Client client = DomainEntityFactory.createClient();
    private final Agreement agreement = DomainEntityFactory.createAgreement();

    private ServiceResult serviceResult;

    private final AxdCustomer axdCustomer = createAxdCustomer();

    private final MuleInvoicingRuleCreated muleInvoicingRuleCreated = new MuleInvoicingRuleCreated();

    public InvoicingRuleCreatedGraphTest() throws IllegalAccessException {
        super();
    }

    @Before
    public void setUp() throws Exception {
        serviceResult = createServiceResult(new InvoicingRuleCreated(null, invoicingRule, agreement, client));

        new ReflectionHelper(muleInvoicingRuleCreated).setField(axService);

        when(readClientCall.getCustomer()).thenReturn(axdCustomer);
    }

    private AxdCustomer createAxdCustomer() {
        ObjectFactory objectFactory = new ObjectFactory();

        AxdCustomer axdCustomer = new AxdCustomer();
        AxdEntityCustTable custTable = new AxdEntityCustTable();
        AxdEntityDirPartyDirPartyTable dirParty = new AxdEntityDirPartyDirOrganization();
        AxdEntityDirPartyPostalAddressView addressView = new AxdEntityDirPartyPostalAddressView();
        dirParty.getDirPartyPostalAddressView().add(addressView);
        custTable.getDirParty().add(dirParty);
        custTable.setAccountNum(objectFactory.createAxdEntityCustTableAccountNum(client.getClientId()));
        axdCustomer.getCustTable().add(custTable);
        return axdCustomer;
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

    private AxdEntityMDSSalesSplitter createSplitter(String id) {
        AxdEntityMDSSalesSplitter splitter = new AxdEntityMDSSalesSplitter();
        splitter.setSplitterId(id.toUpperCase());
        return splitter;
    }

    // ***********************************************************************************************************
    // Tests for the invoice rule and its sub entities 
    //

    @Test
    public void nonExistingInvoiceRuleShouldInsertInvoicingRule() throws Exception {
        // No prior invoicing rule
        when(findInvoicingRuleCall.getNumberOfInvoicingRules()).thenReturn(0);

        muleInvoicingRuleCreated.execute(serviceResult);

        verify(findInvoicingRuleCall).execute(invoicingRule.getInvoicingRuleId(), "SE02");
        verify(insertInvoicingRuleCall).execute(any(AxdEntityMDSSalesInvoiceRule.class));

    }

    @Test
    public void existingInvoiceRuleShouldNotUpdate() throws Exception {
        // Found prior invoicing rule
        when(findInvoicingRuleCall.getNumberOfInvoicingRules()).thenReturn(1);

        muleInvoicingRuleCreated.execute(serviceResult);

        verify(findInvoicingRuleCall).getNumberOfInvoicingRules();
        verifyZeroInteractions(updateInvoicingRuleCall);
    }

    @Test
    public void invoiceRecipientsShouldNotBeUpdated() throws BillingServiceException {
        // Invoicing recipients are found
        when(findInvoiceRecipientsByInvoicingRuleCall.getNumberOfInvoiceRecipient()).thenReturn(1);

        muleInvoicingRuleCreated.execute(serviceResult);

        // Entities are not updated
        verifyZeroInteractions(updateInvoiceRecipientCall);
    }

    @Test
    public void invoiceRecipientsShouldBeInserted() throws BillingServiceException {
        // Invoicing recipients are not found
        when(findInvoiceRecipientsByInvoicingRuleCall.getNumberOfInvoiceRecipient()).thenReturn(0);

        muleInvoicingRuleCreated.execute(serviceResult);

        // Entities are inserted
        verify(insertInvoiceRecipientsCall).execute(any(Collection.class), eq("SE02"));
    }

    // ***********************************************************************************************************
    // Tests for the agreement
    //

    @Test
    public void existingAgreementShouldNotBeUpdated() throws Exception {
        when(findAgreementCall.getNumberOfAgreements()).thenReturn(1);

        muleInvoicingRuleCreated.execute(serviceResult);

        verify(findAgreementCall).execute(agreement.getSourceSystemAgreementId(), "SE02");
        verifyZeroInteractions(updateAgreementCall);
    }

    @Test
    public void nonExistingAgreementShouldBeInserted() throws Exception {
        when(findAgreementCall.getNumberOfAgreements()).thenReturn(0);

        muleInvoicingRuleCreated.execute(serviceResult);

        verify(findAgreementCall).execute(agreement.getSourceSystemAgreementId(), "SE02");
        verify(insertAgreementCall).execute(any(AxdEntityMDSSalesClientAgreement.class));
    }

    // ***********************************************************************************************************
    // Tests for the client and its sub entities 
    //

    @Test
    public void existingClientWithBankAccountIdShouldNotUpdate() throws Exception {
        // Check preconditions
        assertThat(client.getMarketIds().get(0).getOrganizationId(), is(51));
        assertThat(client.getMarketIds().get(1).getOrganizationId(), is(81861));
        assertThat(client.getBankAccounts().get(0).getMarketId().getOrganizationId(), is(51));
        assertThat(client.getBankAccounts().get(1).getMarketId().getOrganizationId(), is(135899));

        when(findClientCall.getNumberOfClients()).thenReturn(1);
        when(findClientCall.getBankAccount()).thenReturn("1");

        muleInvoicingRuleCreated.execute(serviceResult);

        // Check that find is run for both client market array and bank markets
        verify(findClientCall).execute(client.getClientId(), "SE02");
        verify(findClientCall).execute(client.getClientId(), "DE01");
        verify(findClientCall).execute(client.getClientId(), "NO01");

        // Verify no updates
        verifyZeroInteractions(updateClientCall);

        // verify no inserts
        verifyNoMoreInteractions(insertClientCall);
    }

    @Test
    public void notFoundClientShouldInsert() throws Exception {
        when(findClientCall.getNumberOfClients()).thenReturn(0);

        muleInvoicingRuleCreated.execute(serviceResult);

        // Check that find is run for both client market array and bank markets
        verify(findClientCall).execute(client.getClientId(), "SE02");
        verify(findClientCall).execute(client.getClientId(), "DE01");
        verify(findClientCall).execute(client.getClientId(), "NO01");

        // Verify inserts
        verify(insertClientCall).execute(any(AxdCustomer.class), eq("SE02"));
        verify(insertClientCall).execute(any(AxdCustomer.class), eq("DE01"));
        verify(insertClientCall).execute(any(AxdCustomer.class), eq("NO01"));
        verify(insertClientCall, times(3)).getAxRequestResult();

        // verify no more inserts
        verifyNoMoreInteractions(insertClientCall);
    }

    @Test
    public void mixedClientShouldOnlyInsertAndNotUpdate() throws Exception {
        // This will return 1 for the first and second call (getNumberOfClients is called once internally as well)
        when(findClientCall.getNumberOfClients())
                // First client
                .thenReturn(1).thenReturn(1)
                // Second client
                .thenReturn(1).thenReturn(1)
                // Third client
                .thenReturn(0);
        when(findClientCall.getBankAccount()).thenReturn("1");

        muleInvoicingRuleCreated.execute(serviceResult);

        // Check that find is run for both client market array and bank markets
        verify(findClientCall).execute(client.getClientId(), "SE02");
        verify(findClientCall).execute(client.getClientId(), "NO01");
        verify(findClientCall).execute(client.getClientId(), "DE01");

        // Verify that bank account id was updated for the one insert call.
        verify(updateClientCall).execute(eq(client.getClientId()), any(AxdCustomer.class), eq("DE01"));
        verify(updateClientCall).getAxRequestResult();

        // Only inserts and no updates
        verifyNoMoreInteractions(updateClientCall);
        verify(insertClientCall).execute(any(AxdCustomer.class), eq("DE01"));
        verify(insertClientCall).getAxRequestResult();

        // verify no more inserts
        verifyNoMoreInteractions(insertClientCall);
    }

    /** New bank in request but no bank in Ax */
    @Test
    public void newBankShouldInsertBank() throws Exception {

        muleInvoicingRuleCreated.execute(serviceResult);

        verify(findBankCall).execute("1", client.getClientId(), "SE02");
        verify(findBankCall).execute("1", client.getClientId(), "DE01");

        verify(insertBankCall).execute(any(AxdEntityCustBankAccount.class), eq("SE02"));
        verify(insertBankCall).execute(any(AxdEntityCustBankAccount.class), eq("DE01"));
        verify(insertBankCall, times(2)).getAxRequestResult();
        verifyNoMoreInteractions(updateBankCall);
        verifyNoMoreInteractions(insertBankCall);

    }

    @Test
    public void noBankShouldNotDoAnythingWithBank() throws Exception {
        // No new bank and no existing
        client.getBankAccounts().clear();

        muleInvoicingRuleCreated.execute(serviceResult);

        verifyNoMoreInteractions(findBankCall);
        verifyNoMoreInteractions(insertBankCall);
        verifyNoMoreInteractions(updateBankCall);
    }

    @Test
    public void removedBankShouldDoNothing() throws Exception {
        when(findClientCall.getNumberOfClients()).thenReturn(1);
        when(findClientCall.getBankAccount()).thenReturn("bankAccount");

        // Yes, we have found the bank
        when(findBankCall.getNumberOfBanks()).thenReturn(1);

        // No new bank but bank before
        client.getBankAccounts().clear();

        verifyNoMoreInteractions(findBankCall);
        verifyNoMoreInteractions(insertBankCall);
        verifyNoMoreInteractions(updateBankCall);
    }

    @Test
    public void updatedBankShouldDoNothing() throws Exception {
        when(findClientCall.getNumberOfClients()).thenReturn(1);
        when(findClientCall.getBankAccount()).thenReturn("1");

        // Yes, we have found the bank
        when(findBankCall.getNumberOfBanks()).thenReturn(1);

        muleInvoicingRuleCreated.execute(serviceResult);

        verify(findBankCall).execute("1", client.getClientId(), "SE02");
        verify(findBankCall).execute("1", client.getClientId(), "DE01");

        verifyNoMoreInteractions(insertBankCall);
        verifyNoMoreInteractions(updateBankCall);
    }

    @Test
    public void newBankForExistingClientShouldBeInserted() throws Exception {
        when(findClientCall.getNumberOfClients()).thenReturn(1);

        // No clients have existing banks
        when(findClientCall.getBankAccount()).thenReturn(null);

        // No, we didn't find a bank
        when(findBankCall.getNumberOfBanks()).thenReturn(0);

        muleInvoicingRuleCreated.execute(serviceResult);

        verify(findBankCall).execute("1", client.getClientId(), "SE02");
        verify(findBankCall).execute("1", client.getClientId(), "DE01");

        verify(insertBankCall).execute(any(AxdEntityCustBankAccount.class), eq("SE02"));
        verify(insertBankCall).execute(any(AxdEntityCustBankAccount.class), eq("DE01"));
        verify(insertBankCall, times(2)).getAxRequestResult();
        verifyNoMoreInteractions(updateBankCall);
        verifyNoMoreInteractions(insertBankCall);
    }

    @Test
    public void newClientShouldGetBankInformation() throws Exception {

        muleInvoicingRuleCreated.execute(serviceResult);

        // Verify read and update calls
        verify(readClientCall).execute(client.getClientId(), "SE02");
        verify(readClientCall).execute(client.getClientId(), "DE01");

        ArgumentCaptor<AxdCustomer> customerArgumentCaptor = ArgumentCaptor.forClass(AxdCustomer.class);
        verify(updateClientCall).execute(eq(client.getClientId()), customerArgumentCaptor.capture(), eq("SE02"));
        verify(updateClientCall).execute(eq(client.getClientId()), customerArgumentCaptor.capture(), eq("DE01"));
        verify(updateClientCall, times(2)).getAxRequestResult();
        verifyNoMoreInteractions(updateClientCall);

        // Verify bank information
        List<AxdCustomer> customers = customerArgumentCaptor.getAllValues();
        assertThat(customers.get(0).getCustTable().get(0).getBankAccount().getValue(), is("1"));
        assertThat(customers.get(1).getCustTable().get(0).getBankAccount().getValue(), is("1"));
    }

    @Test
    public void existingClientWithNoBankInfoShouldGetBankInformation() throws Exception {
        when(findClientCall.getNumberOfClients()).thenReturn(1);

        muleInvoicingRuleCreated.execute(serviceResult);

        // Verify read and update calls
        verify(readClientCall).execute(client.getClientId(), "SE02");
        verify(readClientCall).execute(client.getClientId(), "DE01");

        ArgumentCaptor<AxdCustomer> customerArgumentCaptor = ArgumentCaptor.forClass(AxdCustomer.class);
        verify(updateClientCall).execute(eq(client.getClientId()), customerArgumentCaptor.capture(), eq("SE02"));
        verify(updateClientCall).execute(eq(client.getClientId()), customerArgumentCaptor.capture(), eq("DE01"));
        verify(updateClientCall, times(2)).getAxRequestResult();
        verifyNoMoreInteractions(updateClientCall);

        // Verify bank information
        List<AxdCustomer> customers = customerArgumentCaptor.getAllValues();
        assertThat(customers.get(0).getCustTable().get(0).getBankAccount().getValue(), is("1"));
        assertThat(customers.get(1).getCustTable().get(0).getBankAccount().getValue(), is("1"));
    }

    @Test
    public void newInvoiceMessagesShouldBeInserted() throws Exception {
        // No, we didn't find the invoice messages
        when(findInvoiceMessageRuleCall.getNumberOfInvoiceMessageRules()).thenReturn(0);

        muleInvoicingRuleCreated.execute(serviceResult);

        verify(findInvoiceMessageRuleCall).execute(client.getInvoiceMessageRules().get(0).getInvoiceMessageRuleId().getGuidForAx(), "SE02");
        verify(findInvoiceMessageRuleCall).execute(client.getInvoiceMessageRules().get(1).getInvoiceMessageRuleId().getGuidForAx(), "SE02");

        verify(insertInvoiceMessageRuleCall, times(2)).execute(any(com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvmes.AxdEntityMDSSalesInvoiceMessage.class), eq(client.getClientId()), eq("SE02"));
        verify(insertInvoiceMessageRuleCall, times(2)).getAxRequestResult();
        verifyNoMoreInteractions(updateInvoiceMessageRuleCall);
        verifyNoMoreInteractions(insertInvoiceMessageRuleCall);
    }

    @Test
    public void existingInvoiceMessagesShouldNotBeUpdated() throws Exception {
        // Yes, we found the invoice messages
        when(findInvoiceMessageRuleCall.getNumberOfInvoiceMessageRules()).thenReturn(1);

        muleInvoicingRuleCreated.execute(serviceResult);

        verify(findInvoiceMessageRuleCall).execute(client.getInvoiceMessageRules().get(0).getInvoiceMessageRuleId().getGuidForAx(), "SE02");
        verify(findInvoiceMessageRuleCall).execute(client.getInvoiceMessageRules().get(1).getInvoiceMessageRuleId().getGuidForAx(), "SE02");

        verifyNoMoreInteractions(updateInvoiceMessageRuleCall);
        verifyNoMoreInteractions(insertInvoiceMessageRuleCall);
    }

    // ***********************************************************************************************************
    // Tests for the pan service 
    //

    @Test
    public void newInvoicingRule_displayTdCommissionIdsShouldUpdated() throws BillingServiceException {
        muleInvoicingRuleCreated.execute(serviceResult);

        // The program ids are sourceSystemAgreementId sans the "1-"
        verify(updateCommissionCall).updateDisplayCommission(1234, true);
        verify(updateCommissionCall).updateDisplayCommission(4321, true);
        verifyNoMoreInteractions(updateCommissionCall);
    }

    @Test
    public void existingInvoicingRule_displayTdCommissionIdsShouldNotUpdated() throws BillingServiceException {
        when(findInvoicingRuleCall.getNumberOfInvoicingRules()).thenReturn(1);

        muleInvoicingRuleCreated.execute(serviceResult);

        verifyZeroInteractions(updateCommissionCall);
    }

    @Test
    public void displayTdCommissionFalseShouldUpdated() throws BillingServiceException {
        invoicingRule.setDisplayTDcommission(false);

        muleInvoicingRuleCreated.execute(serviceResult);

        // The program ids are sourceSystemAgreementId sans the "1-"
        verify(updateCommissionCall).updateDisplayCommission(1234, false);
        verify(updateCommissionCall).updateDisplayCommission(4321, false);
        verifyNoMoreInteractions(updateCommissionCall);
    }


}
