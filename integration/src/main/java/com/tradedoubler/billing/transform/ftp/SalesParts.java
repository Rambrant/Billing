package com.tradedoubler.billing.transform.ftp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* Contains the Sales Parts according to the Functional Design Document.
 */
public enum SalesParts {

    ACCOUNT_MANAGEMENT(new String[]{"270"}),
    CONSULTING(new String[]{"112", "113", "260"}),
    FILEHOSTING_FEE(new String[]{"305", "340"}),
    MINIMUM_TRANSACTION_FEE(new String[]{"320"}),
    NETWORK_FEE(new String[]{"120", "230"}),
    OTHER(new String[]{"114"}),
    SET_UP_FEE(new String[]{"110", "240"}),
    TRADEDOUBLER_COMMISSION(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "210", "300", "335", "350"}),
    ACTUAL_TRANSACTIONAL_REVENUE(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "160", "170"}),
    ACTUAL_FIXED_AND_OTHER_REVENUE(new String[]{"270", "112", "113", "260", "305", "340", "320", "120", "230", "114", "110", "240", "210", "300", "335", "350"});
    private final String[] strings;

    SalesParts(String[] strings) {

        this.strings = strings;
    }

    public static List<SalesParts> getSalesPartsResult(String salesPart) {
        List<SalesParts> salesPartsResult = new ArrayList<SalesParts>();
        for (SalesParts salesParts : values()) {
            if (Arrays.asList(salesParts.getStrings()).contains(salesPart)) salesPartsResult.add(salesParts);
        }
        if (salesPartsResult.size() == 0) {

            //TODO: What to do?
        }
        return salesPartsResult;
    }

    private String[] getStrings() {
        return strings;
    }
}
