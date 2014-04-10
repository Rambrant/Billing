package com.tradedoubler.billing.validate;

import org.junit.Test;

/**
 * @author bjoek
 * @since 2012-08-21
 */
public class TdJsonObjectTest {
    @Test(expected = IllegalArgumentException.class)
    public void removeWithDotNotationShouldNotWork() throws Exception {
        TdJsonObject tdJsonObject = new TdJsonObject("{}");
        tdJsonObject.remove("name.id");
    }
}
