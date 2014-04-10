package com.tradedoubler.billing.service.ax.ftp.handler;

/** Contains status definitions used for the invoice during its life-cycle. */
public enum InvoiceStatus {
    INVOICE_OK("Everything is ok"),
    FAILED_READ_FROM_FTP("Failed to retrieve file from ftp"),
    INVOICE_LACKS_DOCUMENT("Invoice lacks PDF-document"),
    INVOICE_HAS_ERROR_IN_FORECAST_VALIDATION("Failed when validating json for update forecast"),
    INVOICE_HAS_ERROR_IN_INVOICE_VALIDATION("Failed when validating json for invoice"),
    INCOMPLETE("Invoice lacks required elements");

    private String description;


    InvoiceStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
