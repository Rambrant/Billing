package com.tradedoubler.billing.transform.webservice;

import com.tradedoubler.billing.domain.Timestamp;
import com.tradedoubler.billing.platform.logging.LogError;
import org.joda.time.*;
import org.slf4j.*;

import javax.xml.bind.DatatypeConverter;
import javax.xml.datatype.*;
import java.util.Calendar;

/**
 * Utility class for date conversion to Ax.
 * Date: 2012-06-26
 */
public class DateConverter {

    private final static Logger log = LoggerFactory.getLogger(DateConverter.class);

    public static XMLGregorianCalendar convertYMDToXMLGregorianCalendar(int year, int month, int day) {
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendarDate(year, month, day, DatatypeConstants.FIELD_UNDEFINED);
        } catch (DatatypeConfigurationException e) {
            log.error(LogError.BUG_DISTURBANCE.name(), e);
            return null;
        }
    }

    /**
     * Converts to a suitable form used for the AX-web service
     * @param dateAsISO8601 date string
     * @return date instance
     */
    public static XMLGregorianCalendar convertISO8601ToXMLGregorianCalendar(String dateAsISO8601) {
        Calendar calenderFromISO8601 = DatatypeConverter.parseDateTime(dateAsISO8601);
        DateMidnight date = new DateMidnight(calenderFromISO8601);
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendarDate(date.getYear(), date.getMonthOfYear(), date.getDayOfMonth(), DatatypeConstants.FIELD_UNDEFINED);
        } catch (DatatypeConfigurationException e) {
            log.error(LogError.BUG_DISTURBANCE.name(), e);
            return null;
        }

    }

    /**
     * See, for example, <a>http://books.xmlschemata.org/relaxng/ch19-77049.html</a>
     * @param timeAsISO8601 with time
     * @return date instance
     */
    public static XMLGregorianCalendar convertISO8601WithTimeToXMLGregorianCalendar(String timeAsISO8601) {
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(timeAsISO8601);
        } catch (DatatypeConfigurationException e) {
            log.error(LogError.BUG_DISTURBANCE.name(), e);
            return null;
        }

    }

    //Save for a while...
//               private static final DateTimeFormatter XML_DATE_TIME_FORMAT =
//        ISODateTimeFormat.dateTimeNoMillis();
//
//    private static final DateTimeFormatter CHECKING_FORMAT =
//        ISODateTimeFormat.dateTime().withZone(DateTimeZone.UTC);
    /**
     * Convert SOAP version of Gregorian Calendar to TimeStamp
     * @return timestamp instance
     */
    public static Timestamp convertXMLGregorianCalendarToTimeStamp(XMLGregorianCalendar cal) {
        return new Timestamp(cal.toString());
    }

    public static String convertXMLGregorianDateToISODateTime(XMLGregorianCalendar cal) {

        return (new DateTime(cal.toString())).toDateTimeISO().toString();
    }



}
