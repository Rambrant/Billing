package com.tradedoubler.billing.domain;

/**
* Enum for OL-status in an invoice. All order lines in the invoice should have the same status. This enum mimics more or less the enum-stub
 * in the jaxb-generated code but is instead keep clean code dependency.
 */
public enum InvoiceOrderLineStatus {
    NONE("non"),NO_ORDER_LINES("noOrderLines"), PROCESSED("Processed"),UNPROCESSED("Unprocessed"), HOLD("Hold"),ERROR("Error"), READY_FOR_REPROCESS("ReadyForReprocess");
    private final String axName;

    private InvoiceOrderLineStatus(String axName) {
        this.axName = axName;
    }

    public String getAxName() {
        return axName;
    }

    public static InvoiceOrderLineStatus getByAxName(String axName) {
        InvoiceOrderLineStatus[] values = InvoiceOrderLineStatus.values();
        for (InvoiceOrderLineStatus clientType : values) {
            if (clientType.axName.equalsIgnoreCase(axName)) {
                return clientType;
            }
        }
        return NONE;
    }
    }
