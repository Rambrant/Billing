package com.tradedoubler.billing.service;

import com.microsoft.schemas.dynamics._2008._01.documents.customer.*;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgcustbank.AxdEntityCustBankAccount;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvmes.AxdEntityMDSSalesInvoiceMessage;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.platform.flowcontroller.*;
import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * @author bjoek
 * @since 2012-09-04
 */
public class ClientUpdatedGraphTest extends AbstractGraphHelper {
    private final Client client = DomainEntityFactory.createClient();
    private ServiceResult serviceResult;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    public ClientUpdatedGraphTest() throws IllegalAccessException {
        super();
    }

    @Before
    public void setUp() throws Exception {
        setupReadCall();

        serviceResult = createServiceResult(new ClientUpdated(null, client));
    }

    private void setupReadCall() {
        AxdCustomer axdCustomer = createAxdCustomer();
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

    @Test
    public void existingClientShouldUpdate() throws Exception {
        when(findClientCall.getNumberOfClients()).thenReturn(1);

        axService.updateClient(serviceResult);

        // Check that find is run for both client market array and bank markets
        verify(findClientCall).execute(client.getClientId(), "SE02");
        verify(findClientCall).execute(client.getClientId(), "DE01");
        verify(findClientCall).execute(client.getClientId(), "NO01");

        // Verify updates (one update for client and one update for bank info)
        verify(updateClientCall, times(2)).execute(eq(client.getClientId()), any(AxdCustomer.class), eq("SE02"));
        verify(updateClientCall, times(2)).execute(eq(client.getClientId()), any(AxdCustomer.class), eq("DE01"));
        verify(updateClientCall).execute(eq(client.getClientId()), any(AxdCustomer.class), eq("NO01"));

        // verify no inserts
        verifyNoMoreInteractions(insertClientCall);
    }

    @Test
    public void notFoundClientShouldInsert() throws Exception {
        when(findClientCall.getNumberOfClients()).thenReturn(0);

        axService.updateClient(serviceResult);

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
    public void mixedClientShouldInsertAndUpdate() throws Exception {
        // This will return 1 for the first call (getNumberOfClients is called once internally as well)
        when(findClientCall.getNumberOfClients()).thenReturn(1).thenReturn(1).thenReturn(0);

        axService.updateClient(serviceResult);

        // Check that find is run for both client market array and bank markets
        verify(findClientCall).execute(client.getClientId(), "SE02");
        verify(findClientCall).execute(client.getClientId(), "DE01");
        verify(findClientCall).execute(client.getClientId(), "NO01");

        // Mixed inserts and updates (one update for client and one update for bank info)
        verify(updateClientCall, times(2)).execute(eq(client.getClientId()), any(AxdCustomer.class), eq("SE02"));
        verify(insertClientCall).execute(any(AxdCustomer.class), eq("DE01"));
        verify(insertClientCall).execute(any(AxdCustomer.class), eq("NO01"));
        verify(insertClientCall, times(2)).getAxRequestResult();

        // verify no more inserts
        verifyNoMoreInteractions(insertClientCall);
    }

    @Test
    public void multipleClientHitsShouldThrowException() throws Exception {
        when(findClientCall.getNumberOfClients()).thenReturn(2);

        try {
            axService.updateClient(serviceResult);
            fail();
        } catch (BillingServiceException bsex) {
            assertThat(bsex.getMessage(), is("Found more than one Customer in Ax with ClientId: clientId"));
            assertThat(bsex.getCategory(), is(ServiceResultCategory.BUG_DISTURBANCE));
        }
    }

    /** New bank in request but no bank in Ax */
    @Test
    public void newBankShouldTryToFindBank() throws Exception {
        when(findClientCall.getNumberOfClients()).thenReturn(1);
        when(findClientCall.getBankAccount()).thenReturn(null);

        axService.updateClient(serviceResult);

        verify(findBankCall).execute("1", client.getClientId(), "SE02");
        verify(findBankCall).execute("1", client.getClientId(), "DE01");
    }

    @Test
    public void noBankShouldNotDoAnythingWithBank() throws Exception {
        when(findClientCall.getNumberOfClients()).thenReturn(1);
        when(findClientCall.getBankAccount()).thenReturn(null);
        client.getBankAccounts().clear();

        axService.updateClient(serviceResult);

        verifyNoMoreInteractions(findBankCall);
        verifyNoMoreInteractions(insertBankCall);
        verifyNoMoreInteractions(updateBankCall);
    }

    @Test
    public void removedBankShouldThrowException() throws Exception {
        when(findClientCall.getNumberOfClients()).thenReturn(1);
        when(findClientCall.getBankAccount()).thenReturn("bankAccount");
        client.getBankAccounts().clear();

        try {
            axService.updateClient(serviceResult);
            fail();
        } catch (BillingServiceException bsex) {
            assertThat(bsex.getMessage(), is("Bank existed before and now it is gone. This is not allowed"));
            assertThat(bsex.getCategory(), is(ServiceResultCategory.BUG_DISTURBANCE));
        }

    }

    @Test
    public void updatedBankShouldTryToFindBank() throws Exception {
        when(findClientCall.getNumberOfClients()).thenReturn(1);
        when(findClientCall.getBankAccount()).thenReturn("bankAccount");
        client.getBankAccounts().add(new Bank(client.getClientId(), 81861, "bankCode", "bankAccount3", "accountOwner"));

        axService.updateClient(serviceResult);

        verify(findBankCall).execute("1", client.getClientId(), "SE02");
        verify(findBankCall).execute("1", client.getClientId(), "DE01");
        verify(findBankCall).execute("1", client.getClientId(), "NO01");
    }

    @Test
    public void existingBankShouldBeUpdated() throws Exception {
        when(findClientCall.getNumberOfClients()).thenReturn(1);

        // all clients have existing banks
        when(findClientCall.getBankAccount()).thenReturn("bankAccount");
        client.getBankAccounts().add(new Bank(client.getClientId(), 81861, "bankCode", "bankAccount3", "accountOwner"));

        // Yes, we have found the bank
        when(findBankCall.getNumberOfBanks()).thenReturn(1);

        axService.updateClient(serviceResult);

        verify(findBankCall).execute("1", client.getClientId(), "SE02");
        verify(findBankCall).execute("1", client.getClientId(), "DE01");
        verify(findBankCall).execute("1", client.getClientId(), "NO01");

        verify(updateBankCall).execute(any(AxdEntityCustBankAccount.class), eq("SE02"));
        verify(updateBankCall).execute(any(AxdEntityCustBankAccount.class), eq("DE01"));
        verify(updateBankCall).execute(any(AxdEntityCustBankAccount.class), eq("NO01"));
        verify(updateBankCall, times(3)).getAxRequestResult();
        verifyNoMoreInteractions(updateBankCall);
        verifyNoMoreInteractions(insertBankCall);
    }

    @Test
    public void newBankShouldBeInserted() throws Exception {
        when(findClientCall.getNumberOfClients()).thenReturn(1);

        // No clients have existing banks
        when(findClientCall.getBankAccount()).thenReturn(null);

        // No, we didn't find a bank
        when(findBankCall.getNumberOfBanks()).thenReturn(0);

        axService.updateClient(serviceResult);

        verify(findBankCall).execute("1", client.getClientId(), "SE02");
        verify(findBankCall).execute("1", client.getClientId(), "DE01");

        verify(insertBankCall).execute(any(AxdEntityCustBankAccount.class), eq("SE02"));
        verify(insertBankCall).execute(any(AxdEntityCustBankAccount.class), eq("DE01"));
        verify(insertBankCall, times(2)).getAxRequestResult();
        verifyNoMoreInteractions(updateBankCall);
        verifyNoMoreInteractions(insertBankCall);
    }

    @Test
    public void mixedBankShouldBeBothInsertedAndUpdated() throws Exception {
        when(findClientCall.getNumberOfClients()).thenReturn(1);

        // No clients have existing banks
        when(findClientCall.getBankAccount()).thenReturn(null);

        // First bank existed before in ax, we didn't find a bank (getNumberOfBanks is called once internally as well)
        when(findBankCall.getNumberOfBanks()).thenReturn(1).thenReturn(1).thenReturn(0);

        axService.updateClient(serviceResult);

        verify(findBankCall).execute("1", client.getClientId(), "SE02");
        verify(findBankCall).execute("1", client.getClientId(), "DE01");

        verify(updateBankCall).execute(any(AxdEntityCustBankAccount.class), eq("SE02"));
        verify(insertBankCall).execute(any(AxdEntityCustBankAccount.class), eq("DE01"));
        verify(updateBankCall, times(1)).getAxRequestResult();
        verify(insertBankCall, times(1)).getAxRequestResult();
        verifyNoMoreInteractions(updateBankCall);
        verifyNoMoreInteractions(insertBankCall);
    }

    @Test
    public void multipleBankHitsShouldThrowException() throws Exception {
        when(findClientCall.getNumberOfClients()).thenReturn(1);

        // Multiple hits
        when(findBankCall.getNumberOfBanks()).thenReturn(2);

        try {
            axService.updateClient(serviceResult);
            fail();
        } catch (BillingServiceException bsex) {
            assertThat(bsex.getMessage(), is("Found more than one Bank in Ax with bankAccount : 1, accountNum: clientId"));
            assertThat(bsex.getCategory(), is(ServiceResultCategory.BUG_DISTURBANCE));
        }
    }

    @Test
    public void newInvoiceMessagesShouldBeInserted() throws Exception {
        when(findClientCall.getNumberOfClients()).thenReturn(1);

        // No, we didn't find the invoice messages
        when(findInvoiceMessageRuleCall.getNumberOfInvoiceMessageRules()).thenReturn(0);

        axService.updateClient(serviceResult);

        verify(findInvoiceMessageRuleCall).execute(client.getInvoiceMessageRules().get(0).getInvoiceMessageRuleId().getGuidForAx(), "SE02");
        verify(findInvoiceMessageRuleCall).execute(client.getInvoiceMessageRules().get(1).getInvoiceMessageRuleId().getGuidForAx(), "SE02");

        verify(insertInvoiceMessageRuleCall, times(2)).execute(any(AxdEntityMDSSalesInvoiceMessage.class), eq(client.getClientId()), eq("SE02"));
        verify(insertInvoiceMessageRuleCall, times(2)).getAxRequestResult();
        verifyNoMoreInteractions(updateInvoiceMessageRuleCall);
        verifyNoMoreInteractions(insertInvoiceMessageRuleCall);
    }

    @Test
    public void existingInvoiceMessagesShouldBeUpdated() throws Exception {
        when(findClientCall.getNumberOfClients()).thenReturn(1);

        // Yes, we found the invoice messages
        when(findInvoiceMessageRuleCall.getNumberOfInvoiceMessageRules()).thenReturn(1);

        axService.updateClient(serviceResult);

        verify(findInvoiceMessageRuleCall).execute(client.getInvoiceMessageRules().get(0).getInvoiceMessageRuleId().getGuidForAx(), "SE02");
        verify(findInvoiceMessageRuleCall).execute(client.getInvoiceMessageRules().get(1).getInvoiceMessageRuleId().getGuidForAx(), "SE02");

        verify(updateInvoiceMessageRuleCall, times(2)).execute(any(AxdEntityMDSSalesInvoiceMessage.class), eq(client.getClientId()), eq("SE02"));
        verify(updateInvoiceMessageRuleCall, times(2)).getAxRequestResult();
        verifyNoMoreInteractions(updateInvoiceMessageRuleCall);
        verifyNoMoreInteractions(insertInvoiceMessageRuleCall);
    }

    @Test
    public void mixedInvoiceMessagesShouldBeBothInsertedAndUpdated() throws Exception {
        when(findClientCall.getNumberOfClients()).thenReturn(1);

        // Only the first invoice message was found (getNumberOfInvoiceMessageRules is called once internally as well)
        when(findInvoiceMessageRuleCall.getNumberOfInvoiceMessageRules()).thenReturn(1).thenReturn(1).thenReturn(0);

        axService.updateClient(serviceResult);

        verify(findInvoiceMessageRuleCall).execute(client.getInvoiceMessageRules().get(0).getInvoiceMessageRuleId().getGuidForAx(), "SE02");
        verify(findInvoiceMessageRuleCall).execute(client.getInvoiceMessageRules().get(1).getInvoiceMessageRuleId().getGuidForAx(), "SE02");

        verify(updateInvoiceMessageRuleCall, times(1)).execute(any(AxdEntityMDSSalesInvoiceMessage.class), eq(client.getClientId()), eq("SE02"));
        verify(updateInvoiceMessageRuleCall, times(1)).getAxRequestResult();
        verify(insertInvoiceMessageRuleCall, times(1)).execute(any(AxdEntityMDSSalesInvoiceMessage.class), eq(client.getClientId()), eq("SE02"));
        verify(insertInvoiceMessageRuleCall, times(1)).getAxRequestResult();
        verifyNoMoreInteractions(updateInvoiceMessageRuleCall);
        verifyNoMoreInteractions(insertInvoiceMessageRuleCall);
    }

    @Test
    public void multipleInvoiceMessageHitsShouldThrowException() throws Exception {
        when(findClientCall.getNumberOfClients()).thenReturn(1);

        // Multiple hits
        when(findInvoiceMessageRuleCall.getNumberOfInvoiceMessageRules()).thenReturn(2);

        try {
            axService.updateClient(serviceResult);
            fail();
        } catch (BillingServiceException bsex) {
            assertThat(bsex.getMessage(), is("Found more than one InvoiceMessage in Ax with InvoiceMessageRuleId: {INVOICEMESSAGERULEID1}"));
            assertThat(bsex.getCategory(), is(ServiceResultCategory.BUG_DISTURBANCE));
        }
    }

}
