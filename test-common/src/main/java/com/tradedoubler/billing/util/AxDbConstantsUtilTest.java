package com.tradedoubler.billing.util;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * @author bjoek
 * @since 2012-11-07
 */
public class AxDbConstantsUtilTest {

    @Test
    public void testCurrentTimeMillis() {
        for (int i = 0; i < 10000; i++) {
            String newId1 = AxDbConstantsUtil.generateOrderLineId();
            String newId2 = AxDbConstantsUtil.generateOrderLineId();
            assertThat("Two consecutive calls should not be the same", newId1, not(is(newId2)));
        }

    }
}
