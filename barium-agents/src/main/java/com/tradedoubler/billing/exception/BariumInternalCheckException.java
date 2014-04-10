package com.tradedoubler.billing.exception;

/**
 * @author Thomas Rambrant (thore)
 */

public class BariumInternalCheckException extends RuntimeException
{
    public BariumInternalCheckException( String message)
    {

        super( "***BARIUM*** " + message);
    }

    public BariumInternalCheckException( String message, Throwable cause)
    {
        super(  "***BARIUM*** " + message, cause);
    }
}
