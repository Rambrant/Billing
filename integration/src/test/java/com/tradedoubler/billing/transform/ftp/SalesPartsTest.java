package com.tradedoubler.billing.transform.ftp;

import org.junit.Test;

import static com.tradedoubler.billing.transform.ftp.SalesParts.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * User: erigu
 * Date: 2012-10-18
 */
public class SalesPartsTest {


    @Test
    public void testSomeRetrievalOfSalesPart(){

        assertTrue(getSalesPartsResult("270").contains(ACCOUNT_MANAGEMENT));
        assertTrue(getSalesPartsResult("112").contains(CONSULTING));
        assertTrue(getSalesPartsResult("260").contains(CONSULTING));
        assertTrue(getSalesPartsResult("340").contains(FILEHOSTING_FEE));
        assertTrue(getSalesPartsResult("320").contains(MINIMUM_TRANSACTION_FEE));
        assertTrue(getSalesPartsResult("120").contains(NETWORK_FEE));
        assertTrue(getSalesPartsResult("230").contains(NETWORK_FEE));
        assertTrue(getSalesPartsResult("114").contains(OTHER));

        assertTrue(getSalesPartsResult("110").contains(SET_UP_FEE));
        assertTrue(getSalesPartsResult("240").contains(SET_UP_FEE));
        assertTrue(getSalesPartsResult("240").contains(ACTUAL_FIXED_AND_OTHER_REVENUE));
        assertTrue(getSalesPartsResult("1").contains(TRADEDOUBLER_COMMISSION));
        assertTrue(getSalesPartsResult("1").contains(ACTUAL_TRANSACTIONAL_REVENUE));

        assertFalse(getSalesPartsResult("240").contains(CONSULTING));


    }
}
