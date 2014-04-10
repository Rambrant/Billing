package com.tradedoubler.billing.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
* Domain object for the invoiced agreement, extracted from an AxInvoice.
 */
public class InvoicedAgreement {
    private final String sourceSystemAgreementID;
    private transient final BigDecimal GP;
    private final transient List<InvoicedOrderLine> invoicedOrderLines = new ArrayList<InvoicedOrderLine>();


    public InvoicedAgreement(String sourceSystemAgreementID, BigDecimal GP) {
        this.sourceSystemAgreementID = sourceSystemAgreementID;
        this.GP = GP;
    }

    public String getSourceSystemAgreementID() {
        return sourceSystemAgreementID;
    }

    public BigDecimal getGP() {
        return GP;
    }

    public List<InvoicedOrderLine> getInvoicedOrderLines() {
        return invoicedOrderLines;
    }
}
