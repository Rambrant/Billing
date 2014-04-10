package com.tradedoubler.billing.domain;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author bjorn
 * @since 2012-10-10
 */
public class GuidTest {
    @Test
    public void createGuidFromStringShouldGiveTheSameResult() throws Exception {
        String expected;

        expected = Guid.createGuidFromString("Björn").toString();
        assertThat(Guid.createGuidFromString("Björn").toString(), is(expected));

        expected = Guid.createGuidFromString("123556!#€#%#€&€/%$¢").toString();
        assertThat(Guid.createGuidFromString("123556!#€#%#€&€/%$¢").toString(), is(expected));
    }

    @Test
    public void testEquals() throws Exception {
        assertThat(new Guid("abc").equalsCrmGuid("abc"), is(true));
        assertThat(new Guid("abc").equalsCrmGuid("aBC"), is(true));
        assertThat(new Guid("abc").equalsCrmGuid("{abc}"), is(false));

        assertThat(new Guid("abc").equalsAxGuid("{aBc}"), is(true));
        assertThat(new Guid("abc").equalsAxGuid("{ABC}"), is(true));
        assertThat(new Guid("abc").equalsAxGuid("abc"), is(false));

        assertThat(new Guid("abc").equalsGuid(new Guid("abc")), is(true));
        assertThat(new Guid("abc").equalsGuid(new Guid("aBC")), is(true));
        assertThat(new Guid("abc").equalsGuid(Guid.createFromAxGuid("{ABC}")), is(true));

        assertThat(new Guid("abc").equals(new Guid("abc")), is(true));
        assertThat(new Guid("abc").equals(new Guid("aBC")), is(true));
        assertThat(new Guid("abc").equals(Guid.createFromAxGuid("{ABC}")), is(true));
    }

    @Test
    public void testGuidFromOracleShouldWork() {
        assertThat(Guid.createFromOracleDbGuid("CCCE9A85A62805B4E044002128BBA6A6").getGuid(), is("ccce9a85-a628-05b4-e044-002128bba6a6"));
    }

    @Test
    public void testGuidToOracleShouldWork() {

        assertThat(new Guid("ccce9a85-a628-05b4-e044-002128bba6a6").getGuidForOracleDb(), is("CCCE9A85A62805B4E044002128BBA6A6"));
    }
}
