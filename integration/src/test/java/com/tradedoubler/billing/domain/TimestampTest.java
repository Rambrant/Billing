package com.tradedoubler.billing.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author bjoek
 * @since 2012-08-10
 */
public class TimestampTest {
    @Test
    public void testGetSqlTimestamp() throws Exception {
        String dateString = "2011-05-24T15:30:01.999+02:00";
        Timestamp timestamp = new Timestamp(dateString);
        java.sql.Timestamp sqlTimestamp = timestamp.getSqlTimestamp();
        assertEquals("2011-05-24 15:30:01.999", sqlTimestamp.toString());
    }
}
