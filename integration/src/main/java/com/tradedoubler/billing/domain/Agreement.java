package com.tradedoubler.billing.domain;


/**
 * Information about an agreement
 *
 * @author bjoek
 * @since 2012-06-25
 */
public class Agreement {
    private String clientId;
    private final Currency currencyCode;
    private String description;
    private final String documentLink;
    private Guid invoicingRuleId;
    private final Market marketId;
    private final ProductType productType;
    private String sourceSystemAgreementId;
    private final Timestamp validFrom;
    private final Timestamp validTo;

    public Agreement(String sourceSystemAgreementId, String clientId, String invoicingRuleId,
                     String description, int productType, int marketId, String currencyCode,
                     Timestamp validFrom, Timestamp validTo, String documentLink) {
        this.sourceSystemAgreementId = sourceSystemAgreementId;
        this.clientId = clientId;
        this.invoicingRuleId = new Guid(invoicingRuleId);
        this.description = description;
        this.productType = new ProductType(productType);
        this.marketId = new Market(marketId);
        this.currencyCode = new Currency(currencyCode);
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.documentLink = documentLink;
    }

    /** Agreement identity set by the system delivering order-lines. Used in order-lines for referencing agreements. */
    public String getSourceSystemAgreementId() {
        return sourceSystemAgreementId;
    }

    /** The PAN Org Id of the client the agreement belongs to */
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /** Id for the invoicing rule the agreement refers to */
    public Guid getInvoicingRuleId() {
        return invoicingRuleId;
    }

    public void setInvoicingRuleId(String invoicingRuleId) {
        this.invoicingRuleId = new Guid(invoicingRuleId);
    }

    /** Description of agreement, i.e agreement name */
    public String getDescription() {
        return description;
    }

    /**
     * Type of product sold in the agreement.
     * 1 = Public affiliate program, 2 = TD internal program, 3 = Campaign program, 4 = Media toolbox program,
     * 5 = Call program, 6 = Adnetwork program, 7 = Paid search program
     */
    public ProductType getProductType() {
        return productType;
    }

    /** The PAN Market ID for the market that shall receive revenue for the agreement */
    public Market getMarketId() {
        return marketId;
    }

    /**
     * Currency used for the agreement.
     * <p/>
     * Pattern: ^[A-Z]{3}$
     */
    public Currency getCurrencyCode() {
        return currencyCode;
    }

    /** Used for setting invoicing period */
    public Timestamp getValidFrom() {
        return validFrom;
    }

    /** Used for setting invoicing period (may be null) */
    public Timestamp getValidTo() {
        return validTo;
    }

    /** Link to agreement document file (printed and attached as appendix to Russian invoices) (may be null) */
    public String getDocumentLink() {
        return documentLink;
    }

    public void setSourceSystemAgreementId(String sourceSystemAgreementId) {
        this.sourceSystemAgreementId = sourceSystemAgreementId;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
