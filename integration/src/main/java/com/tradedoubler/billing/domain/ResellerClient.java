package com.tradedoubler.billing.domain;

/**
 * Information about a client
 *
 * @author bjoek
 * @since 2012-06-25
 */
public class ResellerClient implements ContainsBasicClientInfo {
    private final String businessFormCode;
    private String clientId;
    private String companyRegistrationNumber;
    private final Language invoiceLanguage;
    private final Address registeredAddress;
    private String registeredCompanyName;
    private final String vatNumber;


    public ResellerClient(String clientId, String registeredCompanyName, String companyRegistrationNumber, String vatNumber, String invoiceLanguage, String businessFormCode, Address registeredAddress) {
        this.clientId = clientId;
        this.registeredCompanyName = registeredCompanyName;
        this.companyRegistrationNumber = (companyRegistrationNumber != null)?companyRegistrationNumber : "0";
        this.vatNumber = vatNumber;
        this.invoiceLanguage = new Language(invoiceLanguage);
        this.businessFormCode = businessFormCode;
        this.registeredAddress = registeredAddress;
    }

    /** The PAN Org Id of the client */
    @Override
    public String getClientId() {
        return clientId;
    }

    /** Company name of the client */
    @Override
    public String getRegisteredCompanyName() {
        return registeredCompanyName;
    }

    /** Registration number of client */
    @Override
    public String getCompanyRegistrationNumber() {
        return companyRegistrationNumber;
    }

    /** VAT number used for invoicing (may be null) */
    @Override
    public String getVatNumber() {
        return vatNumber;
    }

    /** Two character language code */
    @Override
    public Language getInvoiceLanguage() {
        return invoiceLanguage;
    }

    /** Used for Russian invoices (KPP) (may be null) */
    @Override
    public String getBusinessFormCode() {
        return businessFormCode;
    }

    /** The registered primary address of the client */
    @Override
    public Address getRegisteredAddress() {
        return registeredAddress;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setRegisteredCompanyName(String registeredCompanyName) {
        this.registeredCompanyName = registeredCompanyName;
    }
}
