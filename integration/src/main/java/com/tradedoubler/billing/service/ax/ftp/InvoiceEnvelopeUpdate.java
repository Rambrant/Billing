package com.tradedoubler.billing.service.ax.ftp;

import com.tradedoubler.billing.domain.Event;
import com.tradedoubler.billing.domain.Invoice;
import com.tradedoubler.billing.domain.MetaData;

import java.math.BigDecimal;

/** A wrapper for the updated invoice and its meta-data. Used for json-serialization. */

class InvoiceEnvelopeUpdate {
    private final MetaData metaData;
    private final String invoiceId;
    private final Event invoicingEvent;
    private final String paidDate;
    private final BigDecimal amountOpen;
    private final String modifiedOn;

    public InvoiceEnvelopeUpdate(Invoice invoice, MetaData metaData) {
        invoiceId =invoice.getInvoiceId();
        invoicingEvent = invoice.getEvent();
        paidDate = invoice.getPaidDate();
        modifiedOn = invoice.getModifiedOn();
        amountOpen = invoice.getAmountOpen();
        this.metaData = metaData;
    }


}
