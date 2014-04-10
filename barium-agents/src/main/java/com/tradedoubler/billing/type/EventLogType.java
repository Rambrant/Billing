package com.tradedoubler.billing.type;

/**
 * @author Thomas Rambrant (thore)
 */

public enum EventLogType
{
    //
    // We have sent a message of some sort
    //
    SEND,

    //
    // we have received a message of some sort
    //
    RECEIVE,

    //
    // we have deleted a message since it was handled
    //
    DELETE,

    //
    // We had a disturbance
    //
    DISTURB
}
