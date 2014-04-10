package com.tradedoubler.billing.domain;


import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author bjoek
 * @since 2013-02-18
 */
public class OrderLineTest {
    @Test
    public void illegalPeriodShouldThrowException1() {
        try {
            new OrderLine("", "", true, "", "", BigDecimal.ZERO, BigDecimal.ZERO, "1213", new Timestamp(), "", "");
            fail();
        } catch (Exception ex) {
            assertThat(ex.getMessage(), is("Month is not valid. It has to be between 1 and 12, was: 13"));
        }
    }

    @Test
    public void illegalPeriodShouldThrowException2() {
        try {
            new OrderLine("", "", true, "", "", BigDecimal.ZERO, BigDecimal.ZERO, "1200", new Timestamp(), "", "");
            fail();
        } catch (Exception ex) {
            assertThat(ex.getMessage(), is("Month is not valid. It has to be between 1 and 12, was: 0"));
        }
    }
}
