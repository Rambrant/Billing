package com.tradedoubler.billing.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Information about a client
 *
 * @author bjoek
 * @since 2012-06-25
 */
public class Client implements ContainsBasicClientInfo {
    private final List<Bank> bankAccounts = new ArrayList<Bank>();
    private final String businessFormCode;
    private String clientId;
    private ClientType clientType;
    private String companyRegistrationNumber;
    private final Language invoiceLanguage;
    private final List<ClientMessageRule> invoiceMessageRules = new ArrayList<ClientMessageRule>();
    private final List<Market> marketIds = new ArrayList<Market>();
    private final Address registeredAddress;
    private String registeredCompanyName;
    private final String vatNumber;


    public Client(String clientId, String registeredCompanyName, String companyRegistrationNumber, String vatNumber, ClientType clientType, String invoiceLanguage, String businessFormCode, List<Bank> bankAccounts, Address registeredAddress, List<ClientMessageRule> invoiceMessageRules, List<Integer> marketIds) {
        this.clientId = clientId;
        this.registeredCompanyName = registeredCompanyName;
        this.companyRegistrationNumber = (companyRegistrationNumber != null)? companyRegistrationNumber : "0";
        this.vatNumber = vatNumber;
        this.clientType = clientType;
        this.invoiceLanguage = new Language(invoiceLanguage);
        this.businessFormCode = businessFormCode;
        for (Integer marketId : marketIds) {
            this.marketIds.add(new Market(marketId));
        }
        this.bankAccounts.addAll(bankAccounts);
        this.registeredAddress = registeredAddress;
        this.invoiceMessageRules.addAll(invoiceMessageRules);
    }

    /** The PAN Org Id of the client */
    public String getClientId() {
        return clientId;
    }

    /** Company name of the client */
    public String getRegisteredCompanyName() {
        return registeredCompanyName;
    }

    /** Registration number of client */
    public String getCompanyRegistrationNumber() {
        return companyRegistrationNumber;
    }

    /** VAT number used for invoicing (may be null) */
    public String getVatNumber() {
        return vatNumber;
    }

    /** The type of client. 0 = Advertiser, 1 = Reseller */
    public ClientType getClientType() {
        return clientType;
    }

    /** Two character language code */
    public Language getInvoiceLanguage() {
        return invoiceLanguage;
    }

    /** Used for Russian invoices (KPP) (may be null) */
    public String getBusinessFormCode() {
        return businessFormCode;
    }

    /** The bank accounts for the client */
    public List<Bank> getBankAccounts() {
        return bankAccounts;
    }

    /** The registered primary address of the client */
    public Address getRegisteredAddress() {
        return registeredAddress;
    }

    /** The invoice message rules for the client */
    public List<ClientMessageRule> getInvoiceMessageRules() {
        return invoiceMessageRules;
    }

    public List<Market> getMarketIds() {
        return marketIds;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setRegisteredCompanyName(String registeredCompanyName) {
        this.registeredCompanyName = registeredCompanyName;
    }
}
