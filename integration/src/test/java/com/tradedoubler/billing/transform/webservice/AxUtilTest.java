package com.tradedoubler.billing.transform.webservice;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author bjoek
 * @since 2012-09-12
 */
public class AxUtilTest {
    @Test
    public void twoLinesShouldBecomeStreetWithLineBreak() throws Exception {
        String street = AxUtil.createStreet("line1", "line2");
        assertThat(street, is("line1\r\nline2"));
    }

    @Test
    public void singleLine1ShouldBecomeStreetWithNoLineBreak() throws Exception {
        String street = AxUtil.createStreet("line1", null);
        assertThat(street, is("line1"));
    }

    @Test
    public void singleLine2ShouldBecomeStreetWithNoLineBreak() throws Exception {
        String street = AxUtil.createStreet("", "line2");
        assertThat(street, is("line2"));
    }
}
