package com.tradedoubler.billing.domain;

import java.util.List;

/**
 * The PAN Org Id for an TradeDoubler organization
 *
 * @since 2012-08-17
 */
public class Market {
    private int organizationId;

    public Market(int organizationId) {
        this.organizationId = organizationId;
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public static String toString(List<Market> markets) {
        StringBuilder returnValue = new StringBuilder("[");
        boolean first = true;
        for (Market market : markets) {
            if (first) {
                first = false;
            } else {
                returnValue.append(", ");
            }
            returnValue.append(market.getOrganizationId());
        }
        returnValue.append("]");

        return returnValue.toString();
    }
}
