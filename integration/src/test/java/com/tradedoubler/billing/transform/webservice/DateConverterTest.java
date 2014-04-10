package com.tradedoubler.billing.transform.webservice;

import org.junit.Test;

import javax.xml.datatype.XMLGregorianCalendar;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * User: erigu
 * Date: 2012-09-24
 */
public class DateConverterTest {

    @Test
    public void testConvertYMDToXMLGregorianCalendar() throws Exception {
        XMLGregorianCalendar calender = DateConverter.convertYMDToXMLGregorianCalendar(2012, 01, 01);
        assertNotNull(calender);
        assertEquals(2012, calender.getYear());
        assertEquals(1,calender.getMonth());
        assertEquals(1,calender.getDay());

        calender = DateConverter.convertISO8601WithTimeToXMLGregorianCalendar("2001-10-26T21:32:52");
        assertNotNull(calender);
        assertEquals(2001, calender.getYear());
        assertEquals(10, calender.getMonth());
        assertEquals(26,calender.getDay());
        assertEquals(21,calender.getHour());
        assertEquals(32,calender.getMinute());
        assertEquals(52,calender.getSecond());

        calender = DateConverter.convertISO8601ToXMLGregorianCalendar("2001-10-26");
        assertNotNull(calender);
        assertEquals(2001,calender.getYear());
        assertEquals(10,calender.getMonth());
        assertEquals(26,calender.getDay());


        assertThat(new DateConverter(), notNullValue());


    }
    @Test
    public void testConvertFromXMLGregorianCalendar() throws Exception {

        XMLGregorianCalendar calender = DateConverter.convertYMDToXMLGregorianCalendar(2012, 01, 01);
         DateConverter.convertXMLGregorianCalendarToTimeStamp(calender);




        assertThat(new DateConverter(), notNullValue());


    }
    @Test
    public void testExceptionsCaught() throws Exception {
        XMLGregorianCalendar calender = null;
        try {
            calender = DateConverter.convertYMDToXMLGregorianCalendar(2012, 14, 01);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertTrue(e.getMessage().startsWith("Invalid value 14 for Month field."));
        }

        try {
            calender = DateConverter.convertISO8601WithTimeToXMLGregorianCalendar("2001-10-26T21:32:52");
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertTrue(e.getMessage().startsWith("Invalid value 14 for Month field."));
        }

        try {
            calender = DateConverter.convertISO8601ToXMLGregorianCalendar("2001-10-26");
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertTrue(e.getMessage().startsWith("Invalid value 14 for Month field."));
        }



        assertThat(new DateConverter(), notNullValue());


    }
}
