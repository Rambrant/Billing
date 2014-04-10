package com.tradedoubler.billing.service.ax.ftp;

import com.tradedoubler.billing.domain.Invoice;
import com.tradedoubler.billing.domain.MetaData;

/** A wrapper for the invoice and its meta-data. Used for json-serialization. */
class InvoiceEnvelope {
    private final Invoice invoice;
    private final MetaData metaData;

    public InvoiceEnvelope(Invoice invoice, MetaData metaData) {
        this.invoice = invoice;
        this.metaData = metaData;
    }
}
