package com.tradedoubler.billing.service.ax.webservice.domainhandler;

import com.microsoft.schemas.dynamics._2008._01.documents.customer.AxdCustomer;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.webservice.call.*;
import com.tradedoubler.billing.service.cache.CacheService;
import com.tradedoubler.billing.transform.webservice.ClientToAxCustomerTransformer;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * This class contains convenient methods that translates Clients and communicates them to the AX-web service.
 *
 * @author bjoek
 * @since 2012-09-03
 */
@Component
public class ClientHandler extends AbstractHandler {
    @Autowired
    private CacheService cacheService;

    private final static Logger log = LoggerFactory.getLogger(ClientHandler.class);

    /**
     * This method provides the union of the client and bank markets
     *
     * @param client      contains markets
     * @param bankMarkets all markets for the banks
     * @return union of markets
     */
    public Collection<Market> getAllClientMarkets(Client client, List<Market> bankMarkets) throws BillingServiceException {

        List<Market> markets;
        if (client.getClientType() == ClientType.RESELLER) {
            //For reseller, get all markets.
            markets = cacheService.getAllMarkets();
        } else {
            Set<Integer> marketIds = new TreeSet<Integer>();

            for (Market market : client.getMarketIds()) {
                marketIds.add(market.getOrganizationId());
            }

            for (Market market : bankMarkets) {
                marketIds.add(market.getOrganizationId());
            }

            markets = new ArrayList<Market>();
            for (Integer marketId : marketIds) {
                markets.add(new Market(marketId));
            }
        }

        return markets;
    }

    /** Inserts a new client in Ax */
    public void insertClient(ContainsBasicClientInfo client, Market marketId) throws BillingServiceException {
        String dataAreaId = converter.convert(marketId);

        // Transform client
        ClientToAxCustomerTransformer clientToAxCustomerTransformer = new ClientToAxCustomerTransformer(converter);
        AxdCustomer axCustomer = clientToAxCustomerTransformer.transform(client);

        // Create web service call
        InsertClientCall clientCall = webServiceCallFactory.createCall(InsertClientCall.class);

        log.debug(String.format("Inserting client : %s dataAreaId: %s",
                axCustomer.getCustTable().get(0).getAccountNum().getValue(), dataAreaId));

        // Execute web service call
        clientCall.execute(axCustomer, dataAreaId);

        // Handle error codes by throwing correct exception
        callResultHandler.handleInsertResult(clientCall);
    }

    /** Read an existing Bank from Ax */
    public ReadClientCall readClient(Bank bank) throws BillingServiceException {

        String accountNumKey = bank.getClientId();
        String dataAreaId = converter.convert(bank.getMarketId());

        // Create web service call
        ReadClientCall readClientCall = webServiceCallFactory.createCall(ReadClientCall.class);

        log.debug(String.format("Read client : %s dataAreaId: %s",
                accountNumKey, dataAreaId));

        // Execute web service call
        readClientCall.execute(accountNumKey, dataAreaId);

        // Error handling
        callResultHandler.handleReadResult(readClientCall);

        return readClientCall;
    }

    /** Find a Bank that may exist */
    public FindClientCall findClientByPk(String clientId, Market marketId) throws BillingServiceException {
        String dataAreaId = converter.convert(marketId);

        // Create web service call
        FindClientCall findClientCall = webServiceCallFactory.createCall(FindClientCall.class);

        log.debug(String.format("Find client : %s dataAreaId: %s",
                clientId, dataAreaId));

        // Execute web service call
        findClientCall.execute(clientId, dataAreaId);

        // Error handling
        callResultHandler.handleFindResult(findClientCall);

        // Errorhandling if more than one entity is found
        if (findClientCall.getNumberOfClients() > 1) {
            throw BillingServiceException.createBugDisturbance("Found more than one Customer in Ax with ClientId: " + clientId);
        }

        return findClientCall;
    }

    /** Update an existing Bank */
    public void updateClient(FindClientCall findCall, ContainsBasicClientInfo client, Market marketId) throws BillingServiceException {
        //Make a transform for update.
        AxdCustomer axCustomer = new ClientToAxCustomerTransformer(converter)
                .transformForUpdate(client, findCall);

        String accountNumKey = client.getClientId();
        String dataAreaId = converter.convert(marketId);

        // Create the web service call
        UpdateClientCall updateClientCall = webServiceCallFactory.createCall(UpdateClientCall.class);

        log.debug(String.format("Updating client : %s dataAreaId: %s",
                accountNumKey, dataAreaId));

        //Execute the update on the web-service.
        updateClientCall.execute(accountNumKey, axCustomer, dataAreaId);

        // Handle error codes by throwing correct exception
        callResultHandler.handleUpdateResult(updateClientCall);
    }

    /**
     * Update the existing client with just the bank account info. The rest of the client should be unchanged.
     * See Integration Design Document_MDS_ITG_Customer.docx
     */
    public void updateClientWithBankInfo(ReadClientCall readCall, Market marketId) throws BillingServiceException {
        AxdCustomer existingCustomer = readCall.getCustomer();
        String dataAreaId = converter.convert(marketId);
        String clientAccountNum = existingCustomer.getCustTable().get(0).getAccountNum().getValue();

        // Transform existing client with updated bank info
        AxdCustomer axCustomerWithBankInfo = new ClientToAxCustomerTransformer(converter)
                .transformForUpdate(existingCustomer, BankHandler.CONSTANT_BANK_ACCOUNT_ID, readCall);

        // Create the web service call
        UpdateClientCall updateClientCall = webServiceCallFactory.createCall(UpdateClientCall.class);

        log.debug(String.format("Update client : %s, bank account no : %s, dataAreaId: %s",
                clientAccountNum, BankHandler.CONSTANT_BANK_ACCOUNT_ID, dataAreaId));

        //Execute the update on the web-service.
        updateClientCall.execute(clientAccountNum, axCustomerWithBankInfo, dataAreaId);

        // Handle error codes by throwing correct exception
        callResultHandler.handleUpdateResult(updateClientCall);
    }

}
