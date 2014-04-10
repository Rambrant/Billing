package com.tradedoubler.billing.domain;

import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumMDSSalesMessageSourceType;

/**
 * TODO:
 *
 * @author bjoek
 * @since 2012-06-25
 */
public class PurchaseOrder {
    private Guid invoicingRuleId;
    private String poNumber;
    private Guid purchaseOrderId;
    private final Timestamp validFrom;
    private final Timestamp validTo;

    public PurchaseOrder(String purchaseOrderId, String invoicingRuleId, String poNumber, Timestamp validFrom, Timestamp validTo) {
        this.purchaseOrderId = (purchaseOrderId == null)? null: new Guid(purchaseOrderId);
        this.invoicingRuleId = (invoicingRuleId == null)? null: new Guid(invoicingRuleId);
        this.poNumber = poNumber;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    /** The CRM primary key for the purchase order */
    public Guid getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId( String purchaseOrderId) {
        this.purchaseOrderId = new Guid(purchaseOrderId);
    }

    /** A reference to the invoicing rule the purchase order refers to */
    public Guid getInvoicingRuleId() {
        return invoicingRuleId;
    }

    public void setInvoicingRuleId(String invoicingRuleId) {
        this.invoicingRuleId = new Guid(invoicingRuleId);
    }

    /** Number of purchase order set by the client */
    public String getPoNumber() {
        return poNumber;
    }

    /** Start date for purchase order (date) */
    public Timestamp getValidFrom() {
        return validFrom;
    }

    /** Stop date for purchase order (date) */
    public Timestamp getValidTo() {
        return validTo;
    }

    public AxdEnumMDSSalesMessageSourceType getSourceType() {
        return AxdEnumMDSSalesMessageSourceType.COMPANY;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }
}
