package com.tradedoubler.billing.domain;

/**
 * Bank Information for a client. Primary key is marketId and clientId
 *
 * @author bjoek
 * @since 2012-06-25
 */
public class Bank {
    private String accountOwner;
    private final String bankAccount;
    private final String bankCode;
    private String clientId;
    private final Market marketId;

    public Bank(String clientId, int marketId, String bankCode, String bankAccount, String accountOwner) {
        this.clientId = clientId;
        this.marketId = new Market(marketId);
        this.bankCode = bankCode;
        this.bankAccount = bankAccount;
        this.accountOwner = accountOwner;
    }

    /** A reference to the client the bank information refers to */
    public String getClientId() {
        return clientId;
    }

    /** Market where selected payment method is valid */
    public Market getMarketId() {
        return marketId;
    }

    /** Customer bank code */
    public String getBankCode() {
        return bankCode;
    }

    /** Customer bank account number */
    public String getBankAccount() {
        return bankAccount;
    }

    /** Name of bank account owner */
    public String getAccountOwner() {
        return accountOwner;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }
}
