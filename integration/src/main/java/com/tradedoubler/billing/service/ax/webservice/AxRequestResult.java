package com.tradedoubler.billing.service.ax.webservice;

/**
* Represents the different types of results returned by the AX-system. This follows the Ax Exception handling document.
 */
public enum AxRequestResult {
    ALL_IS_WELL(-1000, "All is well"),
    UNKNOWN(-123, "Unknown error"),
    SCHEMA_ERROR(-1, "Uncorrect value according to schema"),
    DB_DEADLOCK(2, "Database lock"),
    FATAL_ERROR(3, "Fatal error. Transaction has been stopped"),
    ENTITY_NOT_FOUND(3, "No valid document identified from the entity key."),
    DOCUMENT_HASH_CHANGED(3, "The document hash does not match the hash in the XML."),
    RECORD_ALREADY_EXISTS(13, "Error from transaction using Optimistic Concurrency Control"),
    TIME_OUT_SERVER_BUSY(15, "Time out. Server is busy");


    private final int code;
    private final String description;


    AxRequestResult(int code, String description) {
        this.code = code;
        this.description = description;
    }

    int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }


    /**
     * Converts error code to enum. 
     * 
     * @param code main identifier for error categorization
     * @param message is sometimes used to make fine-grain categorization
     * @return error categorization
     */
    public static AxRequestResult forError(int code, String message) {
        for (AxRequestResult typе : AxRequestResult.values()) {
            if (typе.getCode() == code) {
                if (code == 3) {
                    return detectDifferentFatalErrors(message);
                }
                return typе;
            }
        }
        return UNKNOWN;
    }

    private static AxRequestResult detectDifferentFatalErrors(String message) {
        if (message.endsWith("No valid document identified from the entity key.")) {
            return ENTITY_NOT_FOUND;
        }
        if (message.endsWith("The document hash does not match the hash in the XML. The document may have been changed since last read")) {
            return DOCUMENT_HASH_CHANGED;
        }
        return FATAL_ERROR;
    }

}
