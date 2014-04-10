package com.tradedoubler.billing.domain;

import org.joda.time.*;
import org.joda.time.format.*;

import java.sql.Date;

/**
 * Timestamp formatted as an ISO8601 timestamp, i.e. YYYY-MM-DD'T'hh:mm:ss.SSSZ. For example '2011-05-24T15:30:01.999+02:00'
 * <p/>
 * Pattern: ^(-?(?:[1-9][0-9]*)?[0-9]{4})-(1[0-2]|0[1-9])-(3[0-1]|0[1-9]|[1-2][0-9])T(2[0-3]|[0-1][0-9]):([0-5][0-9]):([0-5][0-9])(\\.[0-9]+)(Z|[+-](?:2[0-3]|[0-1][0-9]):?[0-5][0-9])$
 *
 * @author bjoek
 * @since 2012-06-25
 */
public class Timestamp {
    private final String timestamp;

    // The Joda-time formatter is threadsafe
    private static final DateTimeFormatter isoFormatter = ISODateTimeFormat.dateTime();

    public Timestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /** Creates date from JodaTime date classes */
    public Timestamp(ReadableInstant dateTime) {
        this(isoFormatter.print(dateTime));
    }

    public Timestamp() {
        this(new DateTime());
    }

    public Timestamp(Date date) {
        this(new DateTime(date));
    }

    public String getTimestamp() {
        return timestamp;
    }

    public java.sql.Timestamp getSqlTimestamp() {
        DateTime dateTime = isoFormatter.parseDateTime(timestamp);
        return new java.sql.Timestamp(dateTime.getMillis());
    }

    @Override
    public String toString() {
        return timestamp;
    }
}
