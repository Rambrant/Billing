package com.tradedoubler.billing.validate;

import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

/**
 * @author bjoek
 * @since 2012-06-01
 */
public class TestRegExp {
    @Test
    public void testRegExp() throws Exception {
        Pattern compile = Pattern.compile("([A-Fa-f0-9]{8}-[A-Fa-f0-9]{4}-[A-Fa-f0-9]{4}-[A-Fa-f0-9]{4}-[A-Fa-f0-9]{12})");
        assertTrue(compile.matcher("aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa").matches());
    }

}
