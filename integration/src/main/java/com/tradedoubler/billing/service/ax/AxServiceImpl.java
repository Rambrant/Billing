package com.tradedoubler.billing.service.ax;

import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumNoYesCombo;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.platform.flowcontroller.IntegrationMessage;
import com.tradedoubler.billing.platform.flowcontroller.ServiceResult;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.ftp.AxInvoice;
import com.tradedoubler.billing.service.ax.ftp.handler.InvoiceFtpHandler;
import com.tradedoubler.billing.service.ax.webservice.call.*;
import com.tradedoubler.billing.service.ax.webservice.domainhandler.*;
import com.tradedoubler.billing.service.cache.CacheService;
import com.tradedoubler.billing.service.pan.PanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

import static com.tradedoubler.billing.service.ax.BankMap.BankStatus;
import static com.tradedoubler.billing.service.ax.ftp.handler.InvoiceStatus.INVOICE_LACKS_DOCUMENT;
import static com.tradedoubler.billing.service.ax.ftp.handler.InvoiceStatus.INVOICE_OK;

/**
 * Represents the interface for working against the Ax web service. Each interface method accepts a ServiceResult object
 * which contains the domain object within its IntegrationMessage.<br>
 *
 * @author bjoek
 * @since 2012-06-12
 */

public class AxServiceImpl implements AxService {

    private final static Logger log = LoggerFactory.getLogger(AxServiceImpl.class);

    @Autowired
    private ClientHandler clientHandler;

    @Autowired
    private BankHandler bankHandler;

    @Autowired
    private InvoicingRuleHandler invoicingRuleHandler;

    @Autowired
    private AgreementHandler agreementHandler;

    @Autowired
    private InvoiceRecipientHandler invoiceRecipientHandler;

    @Autowired
    private InvoiceMessageRuleHandler invoiceMessageRuleHandler;

    @Autowired
    private InvoiceFtpHandler invoiceFtpHandler;

    @Autowired
    private OrderLineHandler orderLineHandler;

    @Autowired
    private PanService panService;
    
    @Autowired
    private CacheService cacheService;

    /**
     * Inserts an Invoicing rule and invoice recipients in Ax. The method also makes a call to update displayTdCommission in Pan
     *
     * @param serviceResult contains an InvoicingRuleCreated
     * @return unmodified serviceResult regardless of success status
     * @throws BillingServiceException thrown if service call fails
     */
    @Override
    public ServiceResult insertInvoicingRule(final ServiceResult serviceResult) throws BillingServiceException {

        //Extract all sub items
        InvoicingRuleCreated invoicingRuleCreated = (InvoicingRuleCreated) serviceResult.getIntegrationMessage().getDomainObject();
        InvoicingRule invoicingRule = invoicingRuleCreated.getInvoicingRule();
        List<InvoiceRecipient> invoiceRecipients = invoicingRule.getInvoiceRecipients();
        Market marketId = invoicingRule.getMarketId();

        FindInvoicingRuleCall findCall = invoicingRuleHandler.findInvoicingRuleByPk(invoicingRule.getInvoicingRuleId(), marketId);
        if (findCall.getNumberOfInvoicingRules() == 1) {
            // The invoicing rule already exists. It must have been created earlier by this flow (no need to update it again),
            // the update invoicing rule flow does not create invoicing rules.
        } else {
            // If the flow should insert the invoicing rule, then it shall also update the commission flag in pan database
            panService.updateDisplayTradeDoublerCommission(serviceResult);

            invoicingRuleHandler.insertInvoicingRule(invoicingRule);
        }

        FindInvoiceRecipientsByInvoicingRuleCall findInvoiceRecipients = invoiceRecipientHandler.findInvoiceRecipientsByInvoicingRule(invoicingRule.getInvoicingRuleId(), marketId);
        if (findInvoiceRecipients.getNumberOfInvoiceRecipient() >= 1) {
            // The invoice recipients already exists. They were either created earlier by this flow (no need to update them again) or they where
            // created by an update flow (which means that the invoice recipients are newer than current flow).
        } else {
            invoiceRecipientHandler.insertInvoiceRecipients(invoiceRecipients, marketId);
        }

        return serviceResult;
    }

    /**
     * Inserts an Agreement in Ax
     *
     * @param serviceResult contains an InvoicingRuleCreated
     * @return unmodified serviceResult regardless of success status
     * @throws BillingServiceException thrown if service call fails
     */
    @Override
    public ServiceResult insertAgreement(final ServiceResult serviceResult) throws BillingServiceException {
        InvoicingRuleCreated agreementInserted = (InvoicingRuleCreated) serviceResult.getIntegrationMessage().getDomainObject();
        Agreement agreement = agreementInserted.getAgreement();

        FindAgreementCall findAgreementCall = agreementHandler.findAgreementByPk(agreement.getSourceSystemAgreementId(), agreement.getMarketId());

        if (findAgreementCall.getNumberOfAgreements() == 1) {
            // The agreement already exists. It was either created earlier by this flow (no need to update it again) or it was
            // created by an update flow (which means that the agreement is newer than current flow).
        } else {
            agreementHandler.insertAgreement(agreement);
        }

        return serviceResult;
    }

    /**
     * Updates an (or creates a new) Agreement in Ax
     *
     * @param serviceResult contains an AgreementUpdated
     * @return unmodified serviceResult regardless of success status
     * @throws BillingServiceException thrown if service call fails
     */
    @Override
    public ServiceResult updateAgreement(final ServiceResult serviceResult) throws BillingServiceException {
        AgreementUpdated agreementUpdated = (AgreementUpdated) serviceResult.getIntegrationMessage().getDomainObject();
        Agreement agreement = agreementUpdated.getAgreement();

        FindAgreementCall findAgreementCall = agreementHandler.findAgreementByPk(agreement.getSourceSystemAgreementId(), agreement.getMarketId());

        if (findAgreementCall.getNumberOfAgreements() == 1) {
            agreementHandler.updateAgreement(findAgreementCall, agreement);
        } else {
            agreementHandler.insertAgreement(agreement);
        }

        return serviceResult;
    }


    /**
     * Updates an Invoicing rule and invoice recipients in Ax
     *
     * @param serviceResult contains an InvoicingRuleUpdated
     * @return unmodified serviceResult regardless of success status
     * @throws BillingServiceException thrown if service call fails
     */
    @Override
    public ServiceResult updateInvoicingRule(final ServiceResult serviceResult) throws BillingServiceException {
        InvoicingRuleUpdated invoicingRuleUpdated = (InvoicingRuleUpdated) serviceResult.getIntegrationMessage().getDomainObject();
        InvoicingRule invoicingRule = invoicingRuleUpdated.getInvoicingRule();
        List<InvoiceRecipient> invoiceRecipients = invoicingRule.getInvoiceRecipients();
        Market marketId = invoicingRule.getMarketId();

        FindInvoicingRuleCall findCall = invoicingRuleHandler.findInvoicingRuleByPk(invoicingRule.getInvoicingRuleId(), marketId);
        if (findCall.getNumberOfInvoicingRules() == 0) {
            // An invoicing rule can never be created though an update message since we don't have all information needed.
            throw BillingServiceException.createIntegrationDisturbance("Cannot find invoicing rule when updating, invoiceRuleId: " +
                    invoicingRule.getInvoicingRuleId().getGuidForAx(), -1);
        }

        // The update method will detect which invoice rule messages and purchase orders
        // that need to be updated, inserted or deleted
        invoicingRuleHandler.updateInvoicingRule(findCall, invoicingRule);

        // Insert or update the invoice recipients
        for (InvoiceRecipient invoiceRecipient : invoiceRecipients) {
            FindInvoiceRecipientCall findInvoiceRecipientCall = invoiceRecipientHandler.findInvoiceRecipientByPk(invoiceRecipient.getInvoiceRecipientId(), marketId);
            if (findInvoiceRecipientCall.getNumberOfInvoiceRecipient() == 1) {
                // Always update the invoice recipient (even if not changed)
                // The update method will detect which splitting rules that need to be updated, inserted or deleted
                invoiceRecipientHandler.updateInvoiceRecipient(findInvoiceRecipientCall, invoiceRecipient, marketId);
            } else {
                invoiceRecipientHandler.insertInvoiceRecipient(invoiceRecipient, marketId);
            }
        }

        return serviceResult;
    }

    /**
     * Insert a client for several markets, banks and client invoice messages in Ax
     *
     * @param serviceResult contains an InvoicingRuleCreated
     * @return unmodified serviceResult regardless of success status
     * @throws BillingServiceException thrown if service call fails
     */
    @Override
    public ServiceResult insertClient(final ServiceResult serviceResult) throws BillingServiceException {
        InvoicingRuleCreated clientInserted = (InvoicingRuleCreated) serviceResult.getIntegrationMessage().getDomainObject();
        Client client = clientInserted.getClient();
        List<ClientMessageRule> invoiceMessageRules = client.getInvoiceMessageRules();
        BankMap bankMap = new BankMap(client.getBankAccounts());

        // Client must be updated by market. The marketIds are found both in the client and bank list.
        Collection<Market> markets = clientHandler.getAllClientMarkets(client, bankMap.getBankMarkets());

        for (Market marketId : markets) {
            FindClientCall findClientCall = clientHandler.findClientByPk(client.getClientId(), marketId);

            // Insert the client information
            int numberOfClients = findClientCall.getNumberOfClients();
            if (numberOfClients == 1) {
                // The client already exists. It was either created earlier by this flow (no need to update it again) or it was
                // created by an update flow (which means that the client is newer than current flow).
            } else {
                clientHandler.insertClient(client, marketId);
            }

            if (bankMap.doesClientHaveBank(marketId)) {
                Bank bank = bankMap.getBank(marketId);

                // Check if the bank already exists in ax
                FindBankCall findBankCall = bankHandler.findBankByPk(bank.getClientId(), bank.getMarketId());

                if (findBankCall.getNumberOfBanks() == 1) {
                    // The bank already exists. It was either created earlier by this flow (no need to update it again) or it was
                    // created by an update flow (which means that the bank is newer than current flow).
                } else {
                    // Insert a new bank in ax
                    bankHandler.insertBank(bank);
                }

                // If the bank account id exist in the current client. The bank account id is always set to "1"
                boolean existsBankAccountId = numberOfClients == 1 && findClientCall.getBankAccount() != null;

                if (!existsBankAccountId) {
                    //Write the AccountId as the BankAccount-tag in Customer
                    ReadClientCall readCall = clientHandler.readClient(bank);
                    clientHandler.updateClientWithBankInfo(readCall, bank.getMarketId());
                }
            }

        } // End of all market loop

        // Insert or update invoice messages
        // These invoice message rules will be applied to the client on all markets
        for (InvoiceMessageRule invoiceMessageRule : invoiceMessageRules) {
            // The web service call must have a market id when operating, so we just pick the first one from the client
            Market market = client.getMarketIds().get(0);

            // Check if the invoice message rule exists
            FindInvoiceMessageRuleCall findInvoiceMessageRuleCall = invoiceMessageRuleHandler.findInvoiceMessageRuleByPk(invoiceMessageRule.getInvoiceMessageRuleId(), market);

            if (findInvoiceMessageRuleCall.getNumberOfInvoiceMessageRules() == 1) {
                // The invoice message rule already exists. It was either created earlier by this flow (no need to update it again) or it was
                // created by an update flow (which means that the invoice message rule is newer than current flow).
            } else {
                invoiceMessageRuleHandler.insertInvoiceMessageRule(invoiceMessageRule, market);
            }
        }

        return serviceResult;
    }

    /**
     * Updates a (or creates a new) client for several markets, banks and client invoice messages in Ax
     *
     * @param serviceResult contains an ClientUpdated
     * @return unmodified serviceResult regardless of success status
     * @throws BillingServiceException thrown if service call fails
     */
    @Override
    public ServiceResult updateClient(final ServiceResult serviceResult) throws BillingServiceException {
        ClientUpdated clientUpdated = (ClientUpdated) serviceResult.getIntegrationMessage().getDomainObject();
        Client client = clientUpdated.getClient();
        List<ClientMessageRule> invoiceMessageRules = client.getInvoiceMessageRules();
        BankMap bankMap = new BankMap(client.getBankAccounts());

        // Client must be updated by market. The marketIds are found both in the client and bank list.
        Collection<Market> markets = clientHandler.getAllClientMarkets(client, bankMap.getBankMarkets());

        for (Market marketId : markets) {
            FindClientCall findCall = clientHandler.findClientByPk(client.getClientId(), marketId);

            // Update or insert the client information
            if (findCall.getNumberOfClients() == 1) {
                // Always update the client (even if not changed)
                clientHandler.updateClient(findCall, client, marketId);
            } else {
                // The client update message may cause a client to be created for a new market (if the bank info has changed)
                clientHandler.insertClient(client, marketId);
            }

            // If the bank account id exist in the current client. The bank account id is always set to "1"
            boolean haveExistingBankId = findCall.getNumberOfClients() == 1 && findCall.getBankAccount() != null;

            // Detect how the list of banks should be handled
            BankStatus bankStatus = bankMap.doesClientHaveBankForThisMarket(marketId, haveExistingBankId);
            switch (bankStatus) {
                case NO_BANK_BEFORE_OR_AFTER:
                    // Do nothing
                    break;

                case REMOVE_EXISTING_BANK:
                    throw BillingServiceException.createBugDisturbance("Bank existed before and now it is gone. This is not allowed");

                case UPDATE_BANK:
                    // Same flow operations for both insert and update (no break here)
                case INSERT_NEW_BANK:

                    // Get the bank to insert
                    Bank bank = bankMap.getBank(marketId);

                    // Check if the bank already exists in ax
                    FindBankCall findBankCall = bankHandler.findBankByPk(bank.getClientId(), bank.getMarketId());

                    if (findBankCall.getNumberOfBanks() == 1) {
                        // Always update bank info (even if not changed)
                        bankHandler.updateBank(findBankCall, bank, marketId);
                    } else {
                        // Insert a new bank in ax
                        bankHandler.insertBank(bank);
                    }

                    //Write the AccountId as the BankAccount-tag in Customer
                    ReadClientCall readCall = clientHandler.readClient(bank);
                    clientHandler.updateClientWithBankInfo(readCall, bank.getMarketId());

                    break;

                default:
                    throw new IllegalArgumentException("Cannot handle unknown status: " + bankStatus);
            }

        } // End of all market loop

        // Insert or update invoice messages
        // These invoice message rules will be applied to the client on all markets
        for (InvoiceMessageRule invoiceMessageRule : invoiceMessageRules) {
            // The web service call must have a market id when operating, so we just pick the first one from the client
            Market market = client.getMarketIds().get(0);

            // Check if the invoice message rule exists
            FindInvoiceMessageRuleCall findInvoiceMessageRuleCall = invoiceMessageRuleHandler.findInvoiceMessageRuleByPk(invoiceMessageRule.getInvoiceMessageRuleId(), market);

            if (findInvoiceMessageRuleCall.getNumberOfInvoiceMessageRules() == 1) {
                // Always update invoice message rule (even if not changed)
                invoiceMessageRuleHandler.updateInvoiceMessageRule(findInvoiceMessageRuleCall, invoiceMessageRule, market);
            } else {
                invoiceMessageRuleHandler.insertInvoiceMessageRule(invoiceMessageRule, market);
            }
        }

        return serviceResult;
    }

    /**
     * Deletes an Invoice recipient (and related splitting rules) in Ax
     *
     * @param serviceResult contains an InvoiceRecipientDeleted
     * @return unmodified serviceResult regardless of success status
     * @throws BillingServiceException thrown if service call fails
     */
    @Override
    public ServiceResult deleteInvoiceRecipient(final ServiceResult serviceResult) throws BillingServiceException {
        InvoiceRecipientDeleted invoiceRecipientDeleted = (InvoiceRecipientDeleted) serviceResult.getIntegrationMessage().getDomainObject();
        Guid invoiceRecipientId = invoiceRecipientDeleted.getInvoiceRecipientId();
        Market marketId = invoiceRecipientDeleted.getMarketId();

        FindInvoiceRecipientCall findInvoiceRecipientCall = invoiceRecipientHandler.findInvoiceRecipientByPk(invoiceRecipientId, marketId);
        if (findInvoiceRecipientCall.getNumberOfInvoiceRecipient() == 0) {
            throw BillingServiceException.createIntegrationDisturbance(
                    "Could not find the InvoiceRecipient to delete, invoiceRecipientId: " +
                            invoiceRecipientId.getGuidForAx(), -1);
        }
        if (findInvoiceRecipientCall.getInvoiceRecipient().getDefaultRecipient() == AxdEnumNoYesCombo.YES) {
            throw BillingServiceException.createBugDisturbance(
                    "Cannot delete invoice recipient since it is the default recipient. There must always be one default invoice recipient for an invoicing rule. invoiceRecipientId: " +
                            invoiceRecipientId.getGuidForAx());
        }

        // Delete invoice recipient
        invoiceRecipientHandler.deleteInvoiceRecipient(invoiceRecipientId, marketId);

        return serviceResult;
    }

    /**
     * Deletes a Splitting rule in Ax
     *
     * @param serviceResult contains an SplittingRuleDeleted
     * @return unmodified serviceResult regardless of success status
     * @throws BillingServiceException thrown if service call fails
     */
    @Override
    public ServiceResult deleteSplittingRule(final ServiceResult serviceResult) throws BillingServiceException {
        SplittingRuleDeleted splittingRuleDeleted = (SplittingRuleDeleted) serviceResult.getIntegrationMessage().getDomainObject();
        Guid invoiceRecipientId = splittingRuleDeleted.getInvoiceRecipientId();
        Guid splittingRuleId = splittingRuleDeleted.getSplittingRuleId();
        Market marketId = splittingRuleDeleted.getMarketId();

        FindInvoiceRecipientCall findInvoiceRecipientCall = invoiceRecipientHandler.findInvoiceRecipientByPk(invoiceRecipientId, marketId);
        if (findInvoiceRecipientCall.getNumberOfInvoiceRecipient() == 0) {
            throw BillingServiceException.createBugDisturbance(String.format(
                    "When deleting splitting rule, the parent invoice recipient could not be found, invoiceRecipientId: %s, splittingRuleId: %s",
                    invoiceRecipientId.getGuidForAx(), splittingRuleId.getGuidForAx()));
        }
        if (!invoiceRecipientHandler.containsSplittingRule(findInvoiceRecipientCall.getSplitters(), splittingRuleId)) {
            throw BillingServiceException.createBugDisturbance(String.format(
                    "When deleting splitting rule, the parent invoice recipient was found but not the actual splitting rule, invoiceRecipientId: %s, splittingRuleId: %s",
                    invoiceRecipientId.getGuidForAx(), splittingRuleId.getGuidForAx()));
        }

        invoiceRecipientHandler.deleteSplittingRule(findInvoiceRecipientCall, splittingRuleId, marketId);

        return serviceResult;
    }

    /**
     * Updates a Market message in Ax. The market message is also known as InvoiceMessageRule for market.
     *
     * @param serviceResult contains an MarketMessageUpdated
     * @return unmodified serviceResult regardless of success status
     * @throws BillingServiceException thrown if service call fails
     */
    @Override
    public ServiceResult updateMarketMessage(final ServiceResult serviceResult) throws BillingServiceException {
        MarketMessageUpdated marketMessageUpdated = (MarketMessageUpdated) serviceResult.getIntegrationMessage().getDomainObject();
        InvoiceIssuerMessageRule invoiceMessageRule = marketMessageUpdated.getInvoiceMessageRule();
        // This marketId will be valid since this message belongs to a market
        Market marketId = invoiceMessageRule.getMarketId();

        FindInvoiceMessageRuleCall findInvoiceMessageRuleCall = invoiceMessageRuleHandler.findInvoiceMessageRuleByPk(invoiceMessageRule.getInvoiceMessageRuleId(), marketId);
        if (findInvoiceMessageRuleCall.getNumberOfInvoiceMessageRules() == 1) {
            invoiceMessageRuleHandler.updateInvoiceMessageRule(findInvoiceMessageRuleCall, invoiceMessageRule, marketId);
        } else {
            invoiceMessageRuleHandler.insertInvoiceMessageRule(invoiceMessageRule, marketId);
        }

        return serviceResult;
    }

    /**
     * Fetches the invoice-xml from the file-server. It also invokes parsing of the xml file to be able to
     * extract necessary meta information, such as time-stamp and check if pdf-link is present.
     *
     * @param serviceResult Empty service result
     * @return a serviceResult containing only status
     * @throws BillingServiceException thrown if service call fails
     */
    @Override
    public ServiceResult fetchCreatedInvoice(ServiceResult serviceResult) throws BillingServiceException {

        AxInvoice axInvoice = invoiceFtpHandler.fetchInvoice();
        serviceResult.setCommitInfo(axInvoice);


        if (axInvoice != null) {


            serviceResult.setRawData(axInvoice.getRawXML());

            //A temporary IntegrationMessage in case the Xml-parser fails. This is needed to keep the platform running.
            IntegrationMessage integrationMessage = new IntegrationMessage("FF8481B0-B630-45F5-8F80-D602E0215DBF", new MetaData("UpdateInvoiceInformation", new Guid("FF8481B0-B630-45F5-8F80-D602E0215DBF"), new Timestamp(), "1", "AX"));
            serviceResult.setIntegrationMessage(integrationMessage);

            //needs transformation here to extract necessary meta information
            invoiceFtpHandler.doTransformation(axInvoice);
            MetaData metaData = axInvoice.getMetaData();

            //sets integration messageId even if domain invoice fails later on
            String entityId = (axInvoice.getGuidForInvoiceFile() != null)? axInvoice.getGuidForInvoiceFile().toString(): axInvoice.getFileName();
            integrationMessage = new IntegrationMessage(entityId, metaData);
            serviceResult.setIntegrationMessage(integrationMessage);

            serviceResult.setBugDisturbance(axInvoice.getInvoiceStatus() != INVOICE_OK);


            if (axInvoice.getInvoiceStatus() == INVOICE_LACKS_DOCUMENT) {
                log.info(String.format(
                        "PDF-file for invoice %s is missing", axInvoice.getGuidForInvoiceFile()));
                throw BillingServiceException.createBugDisturbance(String.format(
                        "PDF-file for invoice %s is missing", axInvoice.getGuidForInvoiceFile()));
            }

            if (axInvoice.getInvoice() != null) {
                serviceResult.getIntegrationMessage().setDomainObject(axInvoice);
            } else{
                log.info(String.format(
                        "Domain invoice missing for invoice GUID: %s ", axInvoice.getGuidForInvoiceFile()));
                throw BillingServiceException.createBugDisturbance(String.format(
                        "Domain invoice missing for invoice GUID: %s ", axInvoice.getGuidForInvoiceFile()));
            }

        }

        return serviceResult;
    }

    /**
     * Inserts order lines in Ax. Single order lines are allowed to fail when inserted in Ax and this will be reported in 
     * the status field for each order line
     *
     * @param serviceResult contains an OrderLinesCreated
     * @return a serviceResult that contains the insertion status for each order line
     * @throws BillingServiceException thrown if the whole service call fails
     */
    @Override
    public ServiceResult createOrderLines(final ServiceResult serviceResult) throws BillingServiceException {
        OrderLinesCreated orderLinesCreated = (OrderLinesCreated) serviceResult.getIntegrationMessage().getDomainObject();
        List<OrderLine> orderLines = orderLinesCreated.getOrderLines();

        //The order lines have been transformed and validated when they are fetched

        // Only send order lines that have not failed validation
        List<OrderLine> orderLinesNotFailed = orderLineHandler.filterNotFailed(orderLines);

        //A market is needed to make the web service call, so we use a default one (SE02)
        Market market = new Market(51);

        InsertAndUpdateOrderLinesCall insertAndUpdateOrderLinesCall = orderLineHandler.insertOrderLines(orderLinesNotFailed, market);

        orderLineHandler.setInsertionStatusOnOrderLines(orderLinesCreated.getBatchId(), orderLinesNotFailed, insertAndUpdateOrderLinesCall);

        return serviceResult;
    }

    /**
     * Moves invoice to archive directory on the ftp-server. Adds current time in milliseconds to the moved file.
     *
     * @param serviceResult contains an AxInvoice
     * @return A cleared ServiceResult
     * @throws BillingServiceException thrown if service call fails
     */
    public ServiceResult finalizeInvoice(final ServiceResult serviceResult) throws BillingServiceException {
        AxInvoice invoice = (AxInvoice) serviceResult.getCommitInfo();

        invoiceFtpHandler.archiveSuccessfulInvoice(invoice);
        serviceResult.setCommitInfo(null);
        serviceResult.setRawData(null);
        invoice = null;

        return serviceResult;
    }

    /**
     * Moves the failed invoice to the fail directory on the ftp-server. <br>
     * The serviceResult then sets to ok to enable a quick fetch of a new invoice. If the move fails
     * a integration disturbance is raised.
     *
     * @param serviceResult contains an AxInvoice
     * @return a cleared Service result
     * @throws BillingServiceException thrown if service call fails
     */
    @Override
    public ServiceResult moveFailedInvoice(final ServiceResult serviceResult) throws BillingServiceException {
        log.info(String.format(
                String.format("Moves failed invoice %s to failed-directory", serviceResult.getCommitInfo())));
        AxInvoice invoice = (AxInvoice) serviceResult.getCommitInfo();

        if (invoice != null) {
            invoiceFtpHandler.moveFailedInvoice(invoice, serviceResult.getErrorMessage());
            //Clear and set serviceResult to ok to enable a quick next fetch of invoices
            serviceResult.setCommitInfo(null);
            serviceResult.setBugDisturbance(false);

        }
        return serviceResult;
    }

    /**
     * Starts the invoicing process job in Ax
     *
     * @param serviceResult contains an ReadyToInvoice
     * @return unmodified serviceResult regardless of success status
     * @throws BillingServiceException thrown if service call fails
     */
    @Override
    public ServiceResult startInvoicing(final ServiceResult serviceResult) throws BillingServiceException {
        checkServiceResultContent(serviceResult);

        //A market is needed to make the web service call, so we use a default one (SE02)
        Market market = new Market(51);

        orderLineHandler.startInvoicing(market);

        return serviceResult;
    }

    /** Make sure that service result contains a ReadyToInvoice instance. */
    private void checkServiceResultContent(ServiceResult serviceResult) throws BillingServiceException {
        ReadyToInvoice readyToInvoice = (ReadyToInvoice) serviceResult.getIntegrationMessage().getDomainObject();

        if (!readyToInvoice.isReadyToInvoice()) {
            throw BillingServiceException.createBugDisturbance("Flow error. The startInvoicing method should not been called unless Pan says readyToInvoice=true");
        }
    }

    /** Inserts a new or updated reseller client (from Pan) in Ax. */
    @Override
    public ServiceResult insertResellerClient(ServiceResult serviceResult) throws BillingServiceException {
        ResellerClientUpdated resellerClientUpdated = (ResellerClientUpdated) serviceResult.getIntegrationMessage().getDomainObject();
        ResellerClient client = resellerClientUpdated.getClient();

        List<Market> markets = cacheService.getAllMarkets();

        log.info(String.format("Inserting reseller %s on all active markets %s",
                client.getClientId(), Market.toString(markets)));

        for (Market marketId : markets) {
            FindClientCall findCall = clientHandler.findClientByPk(client.getClientId(), marketId);

            // Update or insert the client information
            if (findCall.getNumberOfClients() == 1) {
                // Always update the client (even if not changed)
                clientHandler.updateClient(findCall, client, marketId);
            } else {
                // The client was not found, so insert it
                clientHandler.insertClient(client, marketId);
            }
            
        }
        return serviceResult;  
    }

    /**
     * Verifies that the given reseller client is present in the given AX local market.
     * @param serviceResult
     * @return
     * @throws BillingServiceException
     */
    public ServiceResult checkResellerClientExists(ServiceResult serviceResult) throws BillingServiceException{
        InvoicingRuleCreated invoicingRuleCreated = (InvoicingRuleCreated) serviceResult.getIntegrationMessage().getDomainObject();
        InvoicingRule invoicingRule = invoicingRuleCreated.getInvoicingRule();
        Market marketId = invoicingRule.getMarketId();
        Client client = invoicingRuleCreated.getClient();

        FindClientCall findCall = clientHandler.findClientByPk(client.getClientId(), marketId);

        if (findCall.getNumberOfClients() < 1) {
            // The reseller client is not found in the market
            serviceResult.setBugDisturbance(true);
            serviceResult.setErrorMessage("A local reseller client (orgId=" + client.getClientId() + ") is missing from AX (Market=" +
                    + marketId.getOrganizationId() +  ")");
            serviceResult.setDetailedErrorMessage("Raw data: " + serviceResult.getRawData());
        }
        return serviceResult;
    }

}

