package com.tradedoubler.billing.service.ax;

import com.tradedoubler.billing.domain.*;

import java.util.*;

import static com.tradedoubler.billing.service.ax.BankMap.BankStatus.*;

/**
 * Collection of banks mapped by the banks market (organizationId).
 *
 * @author bjoek
 * @since 2012-09-12
 */
public class BankMap {
    private final Map<Integer, Bank> bankByMarketMap = new TreeMap<Integer, Bank>();

    public BankMap(List<Bank> allBanksForClient) {
        for (Bank bank : allBanksForClient) {
            bankByMarketMap.put(bank.getMarketId().getOrganizationId(), bank);
        }
    }

    /** Determines if the bank should be updated, inserted or removed */
    public BankStatus doesClientHaveBankForThisMarket(Market marketId, boolean haveExistingBankId) {
        BankStatus bankStatus;

        Bank bank = getBank(marketId);


        if (haveExistingBankId) {
            // There was a previous bank for this market

            if (bank == null) {
                // There is no new bank
                bankStatus = REMOVE_EXISTING_BANK;
            } else {
                // The bank still exists
                bankStatus = UPDATE_BANK;
            }
        } else {
            // There was no bank before

            if (bank == null) {
                // There is no new bank
                bankStatus = NO_BANK_BEFORE_OR_AFTER;
            } else {
                // The is a new bank for this market
                bankStatus = INSERT_NEW_BANK;
            }
        }

        return bankStatus;
    }

    public boolean doesClientHaveBank(Market market) {
        return getBank(market) != null;
    }

    public Bank getBank(Market market) {
        return bankByMarketMap.get(market.getOrganizationId());
    }

    /** Returns all bank markets */
    public List<Market> getBankMarkets() {
        List<Market> markets = new ArrayList<Market>();
        
        for (Bank bank : bankByMarketMap.values()) {
            markets.add(bank.getMarketId());
        }
        return markets;
    }

    enum BankStatus {
        NO_BANK_BEFORE_OR_AFTER, REMOVE_EXISTING_BANK, UPDATE_BANK, INSERT_NEW_BANK
    }
}
