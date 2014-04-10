package com.tradedoubler.billing.type;

/**
 * @author Thomas Rambrant (thore)
 */

public enum InvoicingStatusType
{
    //
    // No invoicing is in progress. Data is generated as
    //
    STOPPED,

    //
    // No more data is produced
    //
    STARTED,

    //
    // All data is handled and invoices are produced
    //
    RUNNING
}
