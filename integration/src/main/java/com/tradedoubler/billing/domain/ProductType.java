package com.tradedoubler.billing.domain;

/**
 * What kind of product that an Agreement has
 * 1 - Public Affiliate Program (a.k.a. TD Affiliate)
 * 2 - TradeDoubler Internal Program (a.k.a. Other)
 * 3 - Campaign Program (a.k.a. Campaign - old)
 * 4 - Media Toolbox Program  (a.k.a. TD integral)
 * 5 - Call Program (a.k.a. TD Talk)
 * 6 - Adnetwork Program (a.k.a. TD Campaigns)
 * 7 - Paid Search Program (a.k.a. TD Search)
 *
 * @author bjoek
 * @since 2012-06-25
 */
public class ProductType {
    private final int value;

    public ProductType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
