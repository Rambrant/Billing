package com.tradedoubler.billing.domain;

/**
 * Contains client information except bank information and client invoice messages
 * 
 * @author bjorn
 * @since 2013-02-05
 */
public interface ContainsBasicClientInfo {
    String getClientId();

    String getRegisteredCompanyName();

    String getCompanyRegistrationNumber();

    String getVatNumber();

    Language getInvoiceLanguage();

    String getBusinessFormCode();

    Address getRegisteredAddress();
}
