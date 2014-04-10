package com.tradedoubler.billing.service.pan.call;

import java.sql.Date;

/**
 * @author bjoek
 * @since 2013-02-04
 */
public class ResellerClientEvent {
    /** The guid for this event. */
    public final String resellerClientEventGuid;

    /** The foreign key to the reseller_clients table denoting which client the event targets. */
    public final long resellerClientId;

    /** The time when the event occurred. */
    public final Date eventCreateDate;

    /** Determines if the event represents a create or update */
    public final ModificationType modification;

    public ResellerClientEvent(String resellerClientEventGuid, long resellerClientId, Date eventCreateDate, ModificationType modification) {
        this.resellerClientEventGuid = resellerClientEventGuid;
        this.resellerClientId = resellerClientId;
        this.eventCreateDate = eventCreateDate;
        this.modification = modification;
    }

    public static enum ModificationType {
        CREATE, UPDATE
    }
}
